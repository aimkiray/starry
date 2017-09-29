#!/bin/bash
cd /home/starry
git pull
mvn clean package
cd /home/starry/target
mv starry.war ROOT.war
sh /home/apache-tomcat-9.0.0.M26/bin/shutdown.sh
rm -rf /home/apache-tomcat-9.0.0.M26/webapps/ROOT
mv ROOT.war /home/apache-tomcat-9.0.0.M26/webapps/
sh /home/apache-tomcat-9.0.0.M26/bin/startup.sh
echo -e "\033[32m Deployment is complete! \033[0m"