//EXERCICE 8 // Creation FICHIER

#define _POSIX_C_SOURCE 1
#include<stdlib.h>
#include<stdio.h>
#include<string.h>
#include<unistd.h>
#include<sys/types.h>
#include<sys/stat.h>
#include<fcntl.h>

//Fonction
int creation(char *NomFichier);
int consultation(char *NomFichier);


//Type d'une fiche//
#define LONG_MAX_NOM 20

typedef struct
{
char Nom[LONG_MAX_NOM+1];
int Age;
int NbEnfants;
} Infos;


int main(int argc , char *argv[]){


	creation("fiches.txt");

	if(argc < 2){
        perror("Erreur nombre parametres") ;
        return 6 ;
	}
	else if (argc == 2)
    {
        consultation(argv[1]);

    }


	return 0;
}


int creation(char *NomFichier)
{
    int desc;
    int nb_fiches;
    Infos fiches;
    //int lecture ;
    //int ecriture ;

    // Ouverture du desc
    desc = open(NomFichier, O_WRONLY | O_CREAT | O_TRUNC, S_IRUSR | S_IWUSR);

    if (desc == -1)
    {
        //echec d'ouverture du fichier
        close(desc);
        printf("Erreur ouverture du fichier : %s ",NomFichier);
        return 1;
    }

    printf("Veuillez entrer le nombre de fiches souhaités : ");
    scanf("%d",&nb_fiches);
    printf("D'accord je vais vous faire remplir  %d de fiches \n \n",nb_fiches);

    for(int i=1 ; i<=nb_fiches ; i++ ){
		printf("  - Bonjour veuillez entrer les informations de la fiche %d  - \n",i);

		printf("NOM : ");
		fflush(stdout);
		scanf("%s",fiches.Nom);
		printf("Age : ");
		scanf("%d",&fiches.Age);
		printf("NbEnfants : ");
		scanf("%d",&fiches.NbEnfants);
		printf("\nMerci pour vos reponse ! \n");

		int ecriture = write(desc,&fiches,sizeof(Infos));
		if(ecriture == -1){
			close(desc);
			printf("Echec de write : %s",NomFichier);
			return 3 ;
		}
	}

	close(desc);
	return 0 ;
}

void afficherFiche(Infos fiche)
{
    //AFFICHAGE DES INFORMATION
    printf("Nom: %s \n", fiche.Nom);
    printf("Age: %d \n", fiche.Age);
    printf("Nb_enfants: %d \n", fiche.NbEnfants);
}

int consultation(char *NomFichier)
{
    int desc;
    int numFiche;
    off_t nbFiche;

    int ctnue;

    Infos fiche;

    desc = open(NomFichier, O_RDONLY);
    if (desc == -1)
    {
        perror(NomFichier);
        exit(4);
    }

    nbFiche = lseek(desc, 0L, SEEK_END);
    nbFiche /= sizeof(Infos);
    printf("Nombre de Fiches = %d\n", (int)nbFiche);

    lseek(desc, 0L, SEEK_SET);


    do
    {

        printf("Numero de la fiche a consulter: ");
        scanf("%d", &numFiche);

        if (numFiche > nbFiche)
        {
            fprintf(stderr, "Erreur, nombre de fiche est plus petit que %ld",nbFiche);
            return 2;
        }


        lseek(desc, (nbFiche - 1) * sizeof(Infos), SEEK_CUR);

        if (read(desc, &fiche, sizeof(Infos)) == -1)
        {
            perror("Numero de fiche : nbFiche");
            return 3;
        }

        afficherFiche(fiche);

        lseek(desc, 0L, SEEK_SET);

        printf("Pour consulter une nouvelle fiche taper 1:OUI || 0:NON : ");
        scanf("%d", &ctnue);
    } while (ctnue);



    if (close(desc) == -1)
    {
        perror(NomFichier);
        return -1;
    }

    return 0;
}








