#include<stdlib.h>
#include<stdio.h>
#include<sys/types.h>
#include<unistd.h>
#include<sys/wait.h>
//Prototypage des fonctions
void afficher(char *message) ;// fonction pour l'affichage des informations ;

int main(int argc , char const *argv[]) {

    //printf("Hello World!");
    
    // afficher(); // test
    
    int pid = fork();
    int cr ;
    
    switch(pid){
		case -1 :
			printf("Je suis le pere car y'as eu un erreur dans la creation du fils voici mes informations : \n");
			exit(11);
			break ;
		case 0:
			printf("Je suis le fils est voici infoirmations \n");
			afficher("Je vais me terminer avec la valeur 79 \n");
			exit(79);
			break;
		default :
			printf("Salut je suis le pere !\n");
			wait(&cr);
			if (WIFEXITED(cr)){
				//LE FILS A BIEN ETE TERMINER
				int exit_status=WEXITSTATUS(cr);
				printf("\n Le fils a terminer et il a laisser la valeur de retour : %d \n",exit_status);
			}
			printf("\n \n Fils terminer : Je suis le père et voici mes informations : \n");
			afficher("Je vais me terminer avec la valeur 11 \n");
			exit(11);
	}

	return 0;
}

void afficher(char *message) {
	
	printf("%s \n",message);
	
	pid_t pid = getpid();
	pid_t pid_pere = getppid();
	pid_t id_grp = getpgrp();
	char *login = getlogin();
	uid_t uid = getuid();
	
	printf("Le PID du processus est : %u \n",pid);
	printf("Le PID du Pere est : %u \n",pid_pere);
	printf("Le Identificateur du groupe est : %u \n",id_grp);
	printf("Le nom du login est %s \n",login);
	printf("Le Identificateur du UID courant est : %u \n",uid);
	
	
}


