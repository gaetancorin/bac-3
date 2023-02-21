from sys import argv
from os.path import exists, isfile

def help():
    print("python lanceur_programme.py <fichiercsv> <bat|sh>")

if (len(argv)!= 3) :
    print(help())
    exit(1)

cheminCSV = argv[1]
typeScript = argv[2]

if not(exists(cheminCSV)) :
    print("le fichier"+cheminCSV+" n'existe pas.")
    help()
    exit(2)
if not(isfile(cheminCSV)) :
    print("le fichier "+cheminCSV+" n'est pas un fichier.")
    help()
    exit(3)
if (typeScript !='bat' or typeScript !='sh') :
    print("le fichier de sortie "+typeScript+" n'est pas correct.")
    help()
    exit(4)
fichierCSV= open(cheminCSV, 'r')
contenuCSV = fichierCSV.readlines()
fichierCSV.close()
for ligne in contenuCSV : 
    listeInformation = ligne.split(',')
    if(listeInformation[1] ==0) :
        # on lance pas le lundi
