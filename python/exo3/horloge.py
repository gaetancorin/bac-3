class Horloge :
    def __init__(self,h=0,m=0,s=0):
        self._heure=self._set_heure(h)
        self._minute=self._set_minute(m)
        self._seconde=self._set_seconde(s)
       
    def _get_heure(self):
        return(self._heure)
    
    def _set_heure(self,h):
        try :
            val=int(h)
        except ValueError :
            print("Attention, l'heure ne peut etre qu'une valeur entiere")
            return(-1)
        if(val>23 or val<0):
            print("Attention, l'heure ne peut que comprise entre 0 et 23")
            return(-1)
        self._heure=val
        return(val)
        
    def _get_minute(self):
        return(self._minute)
    
    def _set_minute(self,m):
        try :
            val=int(m)
        except ValueError :
            print("Attention, la minute ne peut etre qu'une valeur entiere")
            return(-1)
        if(val>59 or val<0):
            print("Attention, la minute ne peut que comprise entre 0 et 59")
            return(-1)
        self._minute=val
        return(val)
        
    def _get_seconde(self):
        return(self._seconde)
        
    def _set_seconde(self,s):
        try :
            val=int(s)
        except ValueError :
            print("Attention, la seconde ne peut etre qu'une valeur entiere")
            return(-1)
        if(val>61 or val<0):
            print("Attention, la seconde ne peut que comprise entre 0 et 61")
            return(-1)
        self._seconde=val
        return(val)
    
    def __str__(self):
        if(self._heure==-1 or self._minute==-1 or self._seconde==-1) :
            return "Erreur dans la definition de l'horloge"
        return str(self._heure).zfill(2)+':'+str(self._minute).zfill(2)+':'+str(self._seconde).zfill(2)
    
    def gmt(self,fuseau):
        try :
            val=int(fuseau)
        except ValueError:
            print("Un fuseau horaire est une valeur entiere")
            return
        if val>23 or val<0 :
            print("Un fuseau horaire est compris entre 0 et 23")
            print ("L'horloge n'a pas été modifiee")
            return
        self._set_heure((self._heure+val)%24)
        print(self)

    heure=property(_get_heure,_set_heure)
    minute=property(_get_minute,_set_minute)
    seconde=property(_get_seconde,_set_seconde)


horloge1=Horloge()
print(horloge1)
horloge2=Horloge(2,3,4)
print(horloge2)