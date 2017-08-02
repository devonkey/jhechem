#!/bin/sh
project='jhechem'
clearLog=false
sendWar=false
if [ -n "$1" ] ; then
        project=$1
fi
if [ -n "$2" ] ; then
        clearLog=$2
fi
if [ -n "$3" ] ; then
        sendWar=$3
fi

if [ $sendWar = true ] ; then
	if [ $project = 'jhechem' ] ; then
        project='user'
        scp ${project}/target/libs/${project}.war hugo@$BMW:~/war/
        ssh -t hugo@$BMW "sh ~/deploy.sh ${project} ${clearLog}"
        project='order'
        scp ${project}/target/libs/${project}.war hugo@$BMW:~/war/
        ssh -t hugo@$BMW "sh ~/deploy.sh ${project} ${clearLog}"
        project='web'
        scp ${project}/target/libs/${project}.war hugo@$BMW:~/war/
        ssh -t hugo@$BMW "sh ~/deploy.sh ${project} ${clearLog}"
    else
        scp ${project}/target/libs/${project}.war hugo@$BMW:~/war/
        ssh -t hugo@$BMW "sh ~/deploy.sh ${project} ${clearLog}"
    fi
else
    if [ $project = 'jhechem' ] ; then
        project='user'
        ssh -t hugo@$BMW "sh ~/deploy.sh ${project} ${clearLog}"
        project='order'
        ssh -t hugo@$BMW "sh ~/deploy.sh ${project} ${clearLog}"
        project='web'
        ssh -t hugo@$BMW "sh ~/deploy.sh ${project} ${clearLog}"
    else
        ssh -t hugo@$BMW "sh ~/deploy.sh ${project} ${clearLog}"
    fi
fi



