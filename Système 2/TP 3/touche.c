#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<sys/wait.h>
#include"touche.h"


void touche(){
	
	//Inisialisation
	char car;
	pid_t pid = getpid();
	
	read(0,&car,sizeof(char)); // premiere lecture du caractere
	
	//Boucle pour afficher et faire les cllectures qui suivent
	while(car!='f'){
		
		printf("\n Le caractere : ' %c ' : %u \n",car,pid);
		fflush(stdout);
		
		read(0,&car,sizeof(char));
		
	}
}

