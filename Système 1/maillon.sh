#!/bin/sh

attendreJeton()
{
  s=0
  while [ $s -eq 0 ]
  do
    trap "s=1" CONT
    sleep 1
  done
}

donnerJetonAuSuivant()
{
  kill -18 $1
}

if [ $# -lt 2 ]
then
  echo "Deux paramètres sont attendus"
  exit 1
fi
if [ $1 -eq 1 ]
then
  echo "Maillon $1/$$ ayant pour successeur $2 a le jeton"
  echo "Maillon $1/$$ ayant pour successeur $2 donne le jeton"
  donnerJetonAuSuivant $2
fi
while true
do
  attendreJeton
  echo "Maillon $1/$$ ayant pour successeur $2 a le jeton"
  echo "Maillon $1/$$ ayant pour successeur $2 donne le jeton"
  donnerJetonAuSuivant $2
done
