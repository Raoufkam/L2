#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<sys/wait.h>
#include"term_canon.h"
#include"touche.h"
 
 
 int main(int argc , char* argv[]){
	 
	 pid_t pid_pere = getpid();
	 int cr ;
	 
	 
	 // Passage au mode non-canonique
	
	 Term_non_canonique();
	 
	 printf("   MODE NON-CANONIQUE  \n");
	 
	 /*
	 //scanf("Veuillez entrez un caractere au clavier : %c",&var);
	 read(0,&var,sizeof(char));
	 write(1,&var,sizeof(char));
	 */
	 

	 for(int i=0;i<2;i++)
	 {
		switch(fork()){
		case -1:
			//Echec du fork
			printf("Pere et echec du fork \n");
			exit(1);
			break;
		case 0:
			//fils
			touche();
			exit(0);
			break;
		default:
			//pere
			wait(&cr);
			if (WIFEXITED(cr)){
					printf("\n Mon PID (pere) : %u \n",pid_pere);
					//LE FILS A BIEN ETE TERMINER
					int exit_status=WEXITSTATUS(cr);
					printf("\n Le fils %d a terminer et il a laisser la valeur de retour : %d \n",i+1,exit_status);
			}
		}
	}
		
	 //Passage au mode canonique
	 
	 Term_canonique();
	 printf("\n   FIN MODE NON-CANONIQUE   \n");
	 
	
	return 0; 
	 
}
	 
	 
