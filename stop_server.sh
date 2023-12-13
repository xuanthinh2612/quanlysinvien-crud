cd ~
export CATALINA_HOME="/opt/tomcat"
export PATH="$PATH:$CATALINA_HOME/bin"
source ~/.bashrc
catalina.sh stop

#sudo killall java
#exit 0

rm -r /opt/tomcat/webapps/ROOT
rm /opt/tomcat/webapps/ROOT.war

cp ROOT.war /opt/tomcat/webapps