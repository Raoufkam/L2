#include<stdlib.h>
#include<stdio.h>
#include<sys/types.h>
#include<unistd.h>

#include "matrice.h"
#include "traiterLigne.h"



int main(int argc , char const *argv[]){

    int matrice[NB_LIGNES_MAX][NB_COLONNES_MAX];
    int tabRes[4];

   /* Pour faire des test

    int L = 5 , C = 5;

    initialiserMatrice(matrice,L,C);
    afficherMatrice(matrice,L,C);
    */
    //Test nombre parametres//
    if(argc!=5){
		printf("Erreur : %s : nombre parametres non valide\n",argv[0]);
		exit(1);
	}

    int nbLignes = atoi(argv[1]) , nbColonnes = atoi(argv[2]) ;
    int v1 = atoi(argv[3]) , v2 = atoi(argv[4]);

    initialiserMatrice(matrice,nbLignes,nbColonnes);
    afficherMatrice(matrice,nbLignes,nbColonnes);

    for (int i=0 ; i<nbLignes ; i++){
		unsigned retour_ligne = traiterLigne(matrice[i],nbColonnes,v1,v2);
        switch(retour_ligne){

            case 0:
                tabRes[0]++;
                break;
            case 1:
                tabRes[1]++;
                break;
            case 2:
                tabRes[2]++;
                break;
            case 3:
                tabRes[3]++;
                break;
        }
		printf("%d:%u\n",i,retour_ligne);
	}

	// a faire
    printf("total: %d_de_rien_trouve , %d_de_%d , %d_de_%d , %d_de_%d_et_%d\n",
           tabRes[0],tabRes[1],v1,tabRes[2],v2,tabRes[3],v1,v2);

    return 0 ;
}


