FROM maven as build
WORKDIR /opt/networkhealth
COPY . .
RUN mvn package -DskipTests

FROM primetoninc/jdk:1.8
COPY --from=build /opt/networkhealth/target/networkhealth-0.0.1-SNAPSHOT.jar .
EXPOSE 8080
CMD java -jar networkhealth-0.0.1-SNAPSHOT.jar
