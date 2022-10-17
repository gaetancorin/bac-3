#include <iostream>
#include <string>

using namespace std;

/* créer une fonction qui découpe un nombre de minutespassées en paramètre en heure et minutes
1ère version: affichage de la fonction
2ème version: on crée 2 variables pour heures et minutes dans le code appelant, on les mets à jour dans la fonction
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
