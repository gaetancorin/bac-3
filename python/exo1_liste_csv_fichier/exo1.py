# Ecrire un script python qui prend en paramètre un chemin vers un dossier, une extension de fichier (.zip .exe...) et liste dans un fichier CSV l'ensemble des fichiers portant l'extension dans l'arborescence du dossier.
# Le fichier CSV contiendra la première suivante :
# "Chemin vers le fichier","Nom du fichier","Critère validité","Date de création","Date de modification"
# Chaque nouveau fichier rencontré dans l'arborescence et correspondant au critère d'extension sera ajouté à la fin du fichier dnas une nouvelle ligne.
# Par défaut le critère de validité est à "FAUX"

from sys import argv
from os.path import isdir, exists, getctime, getmtime
from os import listdir

def help():
    print("python listFile.py <chemin> <extension>")

if (len(argv)!= 3) :
    print(help())
    exit(1)

chemin=argv[1]
extension=argv[2]

# vérifier si le dossier passé en paramètre existe et est accesible
if not(exists(chemin)) :
    print("le chemin "+chemin+" n'existe pas")
    help()
    exit(2)
elif not(isdir(chemin)) :
    print("le chemin "+chemin+" n'est pas un dossier")
    help()
    exit(3)
if(extension[0] !='.') :
    print('une extension commence toujours par un point')
    help()
    exit(4)

CSVContenu='"Chemin vers le fichier","Nom du fichier","Critere validite","Date de creation","Date de modification"\n'
def parcoursProfondeur(chemin_dossier,CSV):
    listeContenu=listdir(chemin_dossier)
    for fichier in listeContenu:
        if(isdir(chemin_dossier+"/"+fichier)):
            CSV=parcoursProfondeur(chemin_dossier+"/"+fichier,CSV)
        else:
            if (fichier.split('.')[-1]==extension.split('.')[-1]):
                CSV+='"'+chemin_dossier+"/"+fichier+'"'
                CSV+=',"'+fichier+'"'
                CSV+=',"FAUX"'
                CSV+=',"'+str(getctime(chemin_dossier+"/"+fichier))+'"'
                CSV+=',"'+str(getmtime(chemin_dossier+"/"+fichier))+'"\n'
    return CSV
CSVContenu=parcoursProfondeur(chemin,CSVContenu)
fichierCSV=open('listFile.csv','w')
fichierCSV.write(CSVContenu)
fichierCSV.close()