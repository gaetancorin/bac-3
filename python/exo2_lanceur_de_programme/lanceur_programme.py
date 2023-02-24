# Ecrire un script python qui prend en paramètre  un fichier CSV au format suivant :
# "Chemin vers exécutable" ,"Lancer le lundi" ,"Lancer le mardi" ,"Lancer le mercredi"  ,"Lancer le jeudi"  ,"Lancer le vendredi"  ,"Lancer le samedi" ,"Lancer le dimanche "
# et qui produit un script batch ('.bat') ou un script bash ('.sh') pour chaque jour de la semaine. ('lundi.bat' ou 'lundi.sh'...)
# Le type de script produit sera passé en paramètre du script
#ETAPE 1 :
# Vérifier les paramètre passé au programme
# 2 paramètres attendus
# 3 en tout dans argv (en comptant le nom du fichier python)
# python lanceurSemaine.py  
from sys import argv
from os.path import exists,isfile
from os import remove

def help():
    print("python lanceurSemaine.py <chemin_vers_csv> <bat|sh>")
if (len(argv)!=3) :
    help()
    exit(1)
cheminCSV=argv[1]
typeScript=argv[2]
if not(exists(cheminCSV)):
    print("Le fichier "+cheminCSV+" n'existe pas.")
    help()
    exit(2)
if not(isfile(cheminCSV)):
    print("Le fichier "+cheminCSV+" n'est pas un fichier.")
    help()
    exit(3)
if (typeScript!='bat' and typeScript!='sh'):
    print("Le type de fichier de sortie "+typeScript+" n'est correct.")
    help()
    exit(4)
fichierCSV=open(cheminCSV,'r')
contenuCSV=fichierCSV.readlines()
fichierCSV.close()
cmpt=0
semaine=['lundi','mardi','mercredi','jeudi','vendredi','samedi','dimanche']
for lanceur in semaine :
    if exists(lanceur+'.'+typeScript):
        remove(lanceur+'.'+typeScript)
for ligne in contenuCSV:
    cmpt+=1
    ligne=ligne.replace('"','')
    listeInformation=ligne.split(',')
    if(len(listeInformation)!=8):
        print('Attention la ligne '+str(cmpt)+" n'est pas formatee correctement")
        print('Ligne '+str(cmpt)+" ignoree")
        continue
    chemin_executable=listeInformation.pop(0)
    if not(exists(chemin_executable)):
        print('Attention a la ligne '+str(cmpt)+" le fichier "+chemin_executable+" n'existe pas")
        print('Ligne '+str(cmpt)+" ignoree")
        continue
    if not(isfile(chemin_executable)):
        print('Attention a la ligne '+str(cmpt)+" le fichier "+chemin_executable+" n'est pas un fichier")
        print('Ligne '+str(cmpt)+" ignoree")
        continue   
    for lancement,jour in zip(listeInformation,semaine) :
        if(lancement=='1'):
            fichierLanceur=open(jour+'.'+typeScript,'a')
            fichierLanceur.write('"'+chemin_executable+'"\n')
            fichierLanceur.close()