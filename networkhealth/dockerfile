FROM Maven as build
WORKDIR /opt/networkhealth
COPY . WORKDIR
RUN mvn package -DskipTests

FROM alpine:latest
COPY --from=build /opt/networkhealth/target/networkhealth-0.0.1-SNAPSHOT.jar .
EXPOSE 8080
CMD java -jar networkhealth-0.0.1-SNAPSHOT.jar
