#!/bin/bash
cd ~/starry
git pull
mvn clean package
cd ~/starry/target
mv starry.war ROOT.war
echo "关闭Tomcat"
sh ~/apache-tomcat/bin/shutdown.sh
echo "转移资源"
if test ! -d "~/headimg"
then
    mkdir ~/headimg
else
    rm -rf ~/headimg/*
fi
if test -d "~/apache-tomcat/webapps/ROOT/resources/headimg/"
then
    mv ~/apache-tomcat/webapps/ROOT/resources/headimg/* ~/headimg/
fi
echo "重新部署"
rm -rf ~/apache-tomcat/webapps/ROOT
mv ROOT.war ~/apache-tomcat/webapps/
echo "启动Tomcat"
sh ~/apache-tomcat/bin/startup.sh
echo "Waiting for Tomcat..."
while true
do
    if test -d "~/apache-tomcat/webapps/ROOT/resources/"
    then
        mkdir ~/apache-tomcat/webapps/ROOT/resources/headimg/
        break
    fi
done
mv ~/headimg/* ~/apache-tomcat/webapps/ROOT/resources/headimg/
echo -e "\033[32m Deployment is complete! \033[0m"