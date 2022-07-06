#define _POSIX_C_SOURCE 1

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <time.h>

#include <sys/types.h> /* types implémentés différemment selon la version d'Unix */
#include <sys/stat.h> /* constantes symboliques pour les droits d'accès */
#include <fcntl.h> /* constantes symboliques pour les différents types d'ouverture */
#include <dirent.h>

int tailleFichier(char *fichier, off_t taille);

int main(int argc,char *argv[]){

	off_t taille = 0 ;

	if(argc < 2 ){
		printf("Nombre parametre non valide \n");
		return -1 ;
	}

	else
	{
		tailleFichier(argv[1],taille);
	}

	return 0;
}

int tailleFichier(char *fichier, off_t taille)
{
    printf("%-20s",fichier);
    printf(": %8ld octets\n", taille);
    return 0;
}


