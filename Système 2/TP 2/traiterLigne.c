
#include "matrice.h"
#include "traiterLigne.h"

/* retourne 0: aucun trouve, 1: V1 trouve, 2: v2 trouve et 3: v1 et v2 trouve */
unsigned traiterLigne(  int uneLigne[NB_COLONNES_MAX], unsigned c,
			unsigned v1, unsigned v2)
{
    /* A FAIRE */
   int retour_v1= 0 , retour_v2=0 , retour_v1_v2 = retour_v1 + retour_v2 ;
   for(int i=0 ; i<c ; i++){
	   
	   if(uneLigne[i] == v1){
		   // v1 trouvé
		   retour_v1 = 1;
		}
		
		if(uneLigne[i] == v2){
			// v2 trouvé
			retour_v2 = 2 ;
		//Valeur de retour du total
		retour_v1_v2 = retour_v1 + retour_v2;
		}
   }
   
   return retour_v1_v2 ;
}
