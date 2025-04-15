# Usa una imagen de Java específica
FROM eclipse-temurin:21-jdk-alpine

# Directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo jar generado por tu proyecto (ajusta el nombre)
COPY target/pedidos-service-0.0.1-SNAPSHOT.jar app.jar

# Exponer el puerto que usa Spring Boot (ajusta si es distinto)
EXPOSE 8080

# Comando para ejecutar el microservicio
ENTRYPOINT ["java", "-jar", "app.jar"]