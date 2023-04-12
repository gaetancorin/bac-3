from chronometre import Chronometre
from time import strftime,sleep,strptime,mktime
# class Chronometre(Horloge):
    # def __init__(self,nbMax=10)
    # def _set_nbTpsMax(self,nbMax)
    # def _get_nbTpsMax(self)
    # def _get_listeTemps(self)
    # def setTime(self)        
    # def __str__(self)
    # def start(self)
    # def restart(self)
    # def stop(self)
    # nbTpsMax
    # listeTemps
class Minuteur(Chronometre):
    def __init__(self,tpsMinute):
        super().__init__(nbMax=1)
        self._tempsMinute=self._set_tempsMinute(tpsMinute)
   
    def _set_tempsMinute(self,timeString):
        try :
            timeStruct=strptime('00:'+timeString+' 1971','%H:%M:%S %Y')
        except Exception:
            print('Format du minutage incorrect !')
            print('Minuteur 1 minute par défaut')
            timeStruct=strptime('00:01:00 1971','%H:%M:%S %Y')
        return(timeStruct)
   
    def _get_tempsMinute(self):
        ts=strptime('00:00:00 1971','%H:%M:%S %Y')
        nbSecMinute=mktime(self._tempsMinute)-mktime(ts)
        return(nbSecMinute)
   
    def __str__(self):
        if(self._heure==-1 or self._minute==-1 or self._seconde==-1) :
            return "Erreur dans la definition de l'horloge"
        return str(self._heure).zfill(2)+':'+str(self._minute).zfill(2)+':'+str(self._seconde).zfill(2)
   
    def start(self):
        self.setTime()
        ts=strptime(str(self)+' 1971','%H:%M:%S %Y')
        tempsStart=mktime(ts)
        tempsStop=tempsStart+self._get_tempsMinute()
        while(tempsStop-tempsStart>0):
            sleep(1)
            self.setTime()
            ts=strptime(str(self)+' 1971','%H:%M:%S %Y')
            tempsStart=mktime(ts)
        print("Le minuteur est terminé")
    def restart(self):
        self.start()
    tempsMinute=property(_get_tempsMinute,_set_tempsMinute)