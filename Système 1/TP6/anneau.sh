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

N=`expr $1 - 1`
pid=$$
while [ $N -ge 1 ]
do
  sh maillon.sh $N $pid &
  pid=$!
  N=`expr $N - 1`
done

while true
do
  attendreJeton
  echo "Maillon $1/$$ ayant pour successeur $pid a le jeton"
  echo "Maillon $1/$$ ayant pour successeur $pid donne le jeton"
  donnerJetonAuSuivant $pid
done
