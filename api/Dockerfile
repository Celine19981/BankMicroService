FROM maven:3.8.6

WORKDIR /api/

COPY src src
COPY pom.xml .
RUN mvn package -DskipTests
RUN mv target/*.jar app.jar

ENTRYPOINT [ "java" ]
CMD ["-jar", "app.jar" ]
