# Pull tomcat latest image from dockerhub
FROM tomcat:8.0.51-jre8-alpine
MAINTAINER nishigandha1995@gmail.com
# copy war file on to container
COPY ./target/tata*.war /usr/local/tomcat/webapps
EXPOSE  8080 80
USER tata
WORKDIR /usr/local/tomcat/webapps
CMD ["catalina.sh","run"]