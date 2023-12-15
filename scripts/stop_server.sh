#!/bin/bash

#export CATALINA_HOME="/opt/tomcat"
#export PATH="$PATH:$CATALINA_HOME/bin"
#source ~/.bashrc
#catalina.sh stop
#

sudo systemctl stop rebootServer


# Kiểm tra xem có quy trình Java đang chạy không
#if pgrep -x "java" > /dev/null
#then
#  echo "Đang có quy trình Java chạy. Đang tiêu diệt..."
#  sudo killall java
#  echo "Đã tiêu diệt quy trình Java."
#else
#  echo "Không có quy trình Java đang chạy."
#fi

#
##rm -r /opt/tomcat/webapps/ROOT
##rm /opt/tomcat/webapps/ROOT.war
#
#cp server/ROOT.war /opt/tomcat/webapps

#copy service nếu chưa tồn tại
