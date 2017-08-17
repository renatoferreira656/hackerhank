#!/bin/bash

TEST=$1;
javac Solution.java
mkdir -p result
rm -rf result/* || true

if [[ "$TEST" != "" ]]; then
	cat ./test$TEST.txt | java Solution;
	exit 0;
fi
for i in `find * -maxdepth 0 -name "test*"`; do
	NUMBER=`echo $i | grep -o "[0-9*]"`
	cat $i | java Solution > result/test$NUMBER.txt;
	EXIST=`file ./expected/test$NUMBER.txt | grep -o "No such"` ;
	if [ "$EXIST" == "" ]; then
		RESULT=`diff ./result/test$NUMBER.txt ./expected/test$NUMBER.txt`;
		if [ "$RESULT" != "" ]; then
		   echo "test $NUMBER failed";
		fi
	fi
done;
