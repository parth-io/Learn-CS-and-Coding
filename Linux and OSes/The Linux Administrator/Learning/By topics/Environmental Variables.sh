#!/bin/bash

echo "Enter 1 or 2, to set the environmental variable EVAR to Yes or No"
read ans

# Set up a return code
RC=0

if [ $ans -eq 1 ]  
then 
    export EVAR="Yes"
else
    if [ $ans -eq 2 ]
    then
	export EVAR="No"
    else
# can only reach here with a bad answer
	export EVAR="Unknown"
	RC=1
    fi    
fi
echo "The value of EVAR is: $EVAR"
exit $RC
