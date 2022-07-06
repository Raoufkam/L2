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


int fichierInfos(char *nom_fichier);

int sousRep(char *nom_repertoire);

int main(int argc , char *argv[]){
	
	//Test nombre paramètres Pour exercice 11 
	/*if (argc < 2 ){
		printf("%s: Nombre de parametres non valide \n",argv[0]);
		return -2 ;
	}*/
	
	//Pour exercice 12
	if (argc < 2){
		sousRep(".");
	}
	else
	{
		for(int i=1;i<argc;i++){
			
			fichierInfos(argv[i]);
		}
	}
	
	return 0 ;	
}

int fichierInfos(char *nom_fichier)
{
    struct stat fich;
    char mess[48] ;
    if (stat(nom_fichier, &fich) == -1)
    {
		sprintf(mess,"Echec '%s'",nom_fichier);
        perror(mess);
        return -1;
    }

    printf("%-20s:",nom_fichier);//


    if (S_ISREG(fich.st_mode)!= 0)
    {
        printf(" fichier");
    }
    if (S_ISDIR(fich.st_mode)!=0)
    {
		printf(" repertoire");
	}
	
    printf("%8ld octets ",fich.st_size);
    printf("%s",ctime(&fich.st_atime));
    
    return 0;
}

int sousRep(char *nom_repertoire)
{
	char mess[48] ;
	//Pour parcourir le repertoire
    DIR *repertoire;
    struct dirent *entreeCourant;

    if ((repertoire=opendir(nom_repertoire))==NULL)
    {
		sprintf(mess,"Echec '%s'",nom_repertoire);
        perror(mess);
        return -3 ;
    }

    while ((entreeCourant = readdir(repertoire))!= NULL)
    {
        fichierInfos(entreeCourant->d_name);
    }

    if (closedir(repertoire)==-1)
    {
		//sprintf(mess,"Echec '%s'",repertoire);
        perror("Echec fermeture");
        return -4 ;
    }
    return 0;
}


