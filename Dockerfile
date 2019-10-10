FROM java:8-jre

ADD ./target/config-manager-1.0.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/config-manager-1.0.jar"]

EXPOSE 18898
