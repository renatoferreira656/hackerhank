#!/bin/bash

TEST=$1;
mkdir -p result
mkdir -p target
javac Solution.java -d target
rm -rf result/* || true

if [[ "$TEST" != "" ]]; then
	cat ./test$TEST.txt | java -cp target Solution;
	exit 0;
fi
for i in `find * -maxdepth 0 -name "test*"`; do
	NUMBER=`echo $i | grep -o "[0-9*]"`
	cat $i | java -cp target Solution > result/test$NUMBER.txt;
	if [ -e "./expected/test$NUMBER.txt" ]; then
		RESULT=`diff ./result/test$NUMBER.txt ./expected/test$NUMBER.txt`;
		if [ "$RESULT" != "" ]; then
		   echo "test $NUMBER failed";
		fi
	fi
done;
