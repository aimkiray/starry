#!/bin/bash
cd /home/starry
git pull
mvn clean package
cd /home/starry/target
mv starry.war ROOT.war
echo "关闭Tomcat"
sh /home/apache-tomcat-9.0.0.M26/bin/shutdown.sh
echo "转移资源"
if test ! -d "/home/headimg"
then
    mkdir /home/headimg
else
    rm -rf /home/headimg/*
fi
if test -d "/home/apache-tomcat-9.0.0.M26/webapps/ROOT/resources/headimg/"
then
    mv /home/apache-tomcat-9.0.0.M26/webapps/ROOT/resources/headimg/* /home/headimg/
fi
echo "重新部署"
rm -rf /home/apache-tomcat-9.0.0.M26/webapps/ROOT
mv ROOT.war /home/apache-tomcat-9.0.0.M26/webapps/
echo "启动Tomcat"
sh /home/apache-tomcat-9.0.0.M26/bin/startup.sh
echo "Waiting for Tomcat to start..."
while true
do
    if test -d "/home/apache-tomcat-9.0.0.M26/webapps/ROOT/resources/"
    then
        mkdir /home/apache-tomcat-9.0.0.M26/webapps/ROOT/resources/headimg/
        break
    fi
done
mv /home/headimg/* /home/apache-tomcat-9.0.0.M26/webapps/ROOT/resources/headimg/
echo -e "\033[32m Deployment is complete! \033[0m"