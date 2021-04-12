FROM java:8

EXPOSE 8080

ADD target/SalesManager.jar SalesManager.jar

ENTRYPOINT ["java","-jar","SalesManager.jar"]