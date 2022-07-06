/* Lecture d'un entier tapé au clavier */
int LireEntier(void)
{
  int n;

  while(scanf("%d",&n)!=1)
  {
    printf("? ");
    fflush(stdout);
    while (getchar()!='\n');
  }
  return n;
}
