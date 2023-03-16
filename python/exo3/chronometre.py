from horloge import Horloge
from time import time,gmtime,strftime,sleep,strptime,mktime
class Chronometre(Horloge):
    def __init__(self,nbMax=10):
        tmps=gmtime(time())
        h=strftime('%H',tmps)
        m=strftime('%M',tmps)
        s=strftime('%S',tmps)
        super().__init__(h,m,s)
        self._nbTpsMax=self._set_nbTpsMax(nbMax)
        self._listeTemps=[]
    
    def _set_nbTpsMax(self,nbMax):
        if nbMax<0:
            print("Attention, le nombre max de temps est strictement positif ")
            return(-1)
        else:
            self._nbTpsMax=nbMax
            return(nbMax)
    
    def _get_nbTpsMax(self):
        return(self._nbTpsMax)    
    
    def _get_listeTemps(self):
        return(self._listeTemps) 
    
    def setTime(self):
        tmps=gmtime(time())
        h=strftime('%H',tmps)
        m=strftime('%M',tmps)
        s=strftime('%S',tmps)
        self._heure=self._set_heure(h)
        self._minute=self._set_minute(m)
        self._seconde=self._set_seconde(s)
        
    def __str__(self):
        if(self._nbTpsMax==-1):
            return 'Erreur lors de la définition du chronomètre, le nombre de temps max est mal défini'
        retour='Nombre de temps max : '+str(self._nbTpsMax)+'\n'
        for temps in self._listeTemps:
            retour+=temps[0]+' : '+temps[1]+'\n'
        return(retour)
    
    def start(self):
        if len(self._listeTemps)!=0 and self._listeTemps[-1][1]=='':
            print('Un chronomètre est déjà en cours')
            print('Veuillez redémarrer le chronomètre ou arrêter celui courant')
        if len(self._listeTemps)==self._nbTpsMax :
            del self._listeTemps[0]
        self.setTime()
        self._listeTemps.append((super().__str__(),''))
        
    def restart(self):
        if len(self._listeTemps)!=0 and self._listeTemps[-1][1]=='':
            del self._listeTemps[-1]
        self.start()
    
    def stop(self):
        if not(len(self._listeTemps)!=0 and self._listeTemps[-1][1]==''):
            print('Aucun chonomètre en cours, impossible de stopper')
            print('Veuillez démarrer un chronomètre avant de l\'arrêter')
        ts=strptime(self._listeTemps[-1][0]+' 1971','%H:%M:%S %Y')
        # +' 1971' et ' %Y' nécessaires car par défaut la date n'étant pas renseignée, 
        # strptime initialise le struct_time avec la date 1900 ce qui hors de ce que mktime peut traiter.
        tempsStart=mktime(ts)
        self.setTime()
        ts=strptime(super().__str__()+' 1971','%H:%M:%S %Y')
        tempsStop=mktime(ts)
        tempsEcoule=tempsStop-tempsStart
        self._listeTemps[-1]=(self._listeTemps[-1][0],strftime('%H:%M:%S',gmtime(tempsEcoule)))
        
    nbTpsMax=property(_get_nbTpsMax,_set_nbTpsMax)
    listeTemps=property(_get_listeTemps)
    
    
    

chrono1=Chronometre(5)
print(chrono1)
chrono1.nbTpsMax=-10
print(chrono1)
chrono1.start()
print(chrono1)
sleep(2)
chrono1.stop()
print(chrono1)