#include <iostream>
#include <string>

using namespace std;

/* cr�er une fonction qui d�coupe un nombre de minutespass�es en param�tre en heure et minutes
1�re version: affichage de la fonction
2�me version: on cr�e 2 variables pour heures et minutes dans le code appelant, on les mets � jour dans la fonction
            et on les affiche dans le main
 */

int minutes = 90;

void decoupeMinutes(int min)
{
    int minutes = 0, heures = 0;
    heures = min / 60;
    min = min % 60;
    cout << "Heures :" << heures << endl << "Minutes :" << min ;
    return ;
}


int main(int argc, char * argv[])
{
    decoupeMinutes(minutes);

    return 0;
}
