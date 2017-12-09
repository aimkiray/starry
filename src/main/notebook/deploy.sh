#!/bin/bash
cd
path=$(pwd)
cd ${path}/starry
git pull
mvn clean package
cd ${path}/starry/target
mv starry.war ROOT.war
echo "关闭Tomcat"
sh ${path}/apache-tomcat/bin/shutdown.sh
echo "转移资源"
if test ! -d "$path/headimg"
then
    mkdir ${path}/headimg
else
    rm -rf ${path}/headimg/*
fi
if test -d "$path/apache-tomcat/webapps/ROOT/resources/headimg/"
then
    mv ${path}/apache-tomcat/webapps/ROOT/resources/headimg/* ${path}/headimg/
fi
echo "重新部署"
rm -rf ${path}/apache-tomcat/webapps/ROOT
mv ROOT.war ${path}/apache-tomcat/webapps/
echo "启动Tomcat"
sh ${path}/apache-tomcat/bin/startup.sh
echo "Waiting for Tomcat ready..."
while true
do
    if test -d "$path/apache-tomcat/webapps/ROOT/resources/"
    then
        mkdir ${path}/apache-tomcat/webapps/ROOT/resources/headimg/
        break
    fi
done
mv ${path}/headimg/* ${path}/apache-tomcat/webapps/ROOT/resources/headimg/
if test -d "$path/favicon/"
then
    cp ${path}/favicon/* ${path}/apache-tomcat/webapps/ROOT/
fi
echo -e "\033[32m Deployment is complete! \033[0m"