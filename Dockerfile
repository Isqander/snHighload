FROM tomcat:latest
ADD build/libs/HighloadSN-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war
#RUN sed -i 's/port="8080"/port="4446"/' ${CATALINA_HOME}/conf/server.xml
EXPOSE 8080
CMD ["catalina.sh", "run"]