FROM openjdk:17
COPY ".target/EmpresaTransporte-1.jar" "app.jar"
EXPOSE 8041
ENTRYPOINT [ "java", "-jar", "app.jar"]