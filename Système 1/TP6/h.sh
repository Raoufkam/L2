#!/bin/sh

while true
do
  trap "echo 'nope'" SIGINT
  date
  sleep 1
done
