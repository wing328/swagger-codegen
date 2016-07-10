#!/bin/sh

for SCRIPT in ./bin/*
do
    if [ -f $SCRIPT -a -x $SCRIPT ]
    then
        $SCRIPT
        rc=$?
        if [[ $rc != 0 ]]
        then
            echo "ERROR!! FAILED TO RUN $SCRIPT"
            exit $rc;
        fi
    fi
done
