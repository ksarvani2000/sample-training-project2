FROM tomcat
ADD target/order-management.jar /usr/local/tomcat/webapps/
EXPOSE 8080
CMD ["catalina.sh","run"]