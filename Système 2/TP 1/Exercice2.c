#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>

#define _POSIX_C_SOURCE 1


#define NBMOTSMAX 20

int Decoupe(char Chaine[], char *pMots[]);



int main(int argc, char *argv[])
{
    pid_t pid;
    pid_t pid_pere;
    pid_t pid_fils;

    int cr;
    char *mots[NBMOTSMAX+1];
    int i = 0;
    while (mots[i]!=NULL)
    {
        printf("nb trouve = %d\n", Decoupe(argv[i], mots));

        switch (pid = fork())
        {
        case -1:
            printf("Erreur : echec du fork() !!\n");
            break;

        case 0://CAS DE FILS
            pid_fils = getpid();
            printf("%d : je lance %s\n", pid_fils, mots[i]);
            exit(10+i);

        default: //CAS DU PERE
            pid_pere = getpid();
            printf("%d: je delegue -> la commande en parmetre : cmd : %d\n", p_pere, pid);
            if ((pid_fils = wait(&cr)) != -1)
            {
                printf("%d : %d termine \n", p_pere, pid_fils);
            }
            break;
        }
        i++;
    }

    return 0;
}


// LA FONCTION DECOUPE DEJA DONNER

int Decoupe(char Chaine[], char *pMots[])
{
    char *p;
    int NbMots = 0;

    p = Chaine; /* On commence par le d�but */
    /* Tant que la fin de la cha�ne n'est pas atteinte et qu'on ne d�borde pas */
    while ((*p) != '\0' && NbMots < NBMOTSMAX)
    {
        while ((*p) == ' ' && (*p) != '\0')
            p++; /* Recherche du d�but du mot */
        if ((*p) == '\0')
            break;           /* Fin de cha�ne atteinte */
        pMots[NbMots++] = p; /* Rangement de l'adresse du 1er caract�re du mot */
        while ((*p) != ' ' && (*p) != '\0')
            p++; /* Recherche de la fin du mot */
        if ((*p) == '\0')
            break; /* Fin de cha�ne atteinte */
        *p = '\0'; /* Marquage de la fin du mot */
        p++;       /* Passage au caract�re suivant */
    }
    pMots[NbMots] = NULL; /* Derni�re adresse */
    return NbMots;
}

