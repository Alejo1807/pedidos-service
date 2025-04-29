# Microservicio de Pedidos

Este es el microservicio de Pedidos del sistema de gestión de pedidos de un restaurante. Se encarga de gestionar la creación, actualización y consulta de pedidos realizados por los clientes.

## 🚀 Requisitos Previos
Antes de ejecutar el microservicio, asegúrate de tener instalado lo siguiente:

- Java (Versión recomendada: 21+)
- Git (Opcional, para clonar el repositorio)

## 📂 Configuración del Proyecto

### 1️⃣ Clonar el Repositorio
```sh
git clone <URL_DEL_REPOSITORIO>
cd nombre-del-repositorio
```

### 3️⃣ Ejecutar el Proyecto
Compila y ejecuta el microservicio con el siguiente comando:

```sh
mvn spring-boot:run
```
El microservicio se ejecutará en `http://localhost:8081`.

## 📌 Endpoints Principales

### Pedidos
| Método  | Endpoint            | Descripción                     |
|---------|---------------------|---------------------------------|
| GET     | /api/pedidos/list-all | Lista todos los pedidos        |
| GET     | /api/pedidos/{id}   | Obtiene un pedido por su ID    |
| POST    | /api/pedidos        | Crea un nuevo pedido           |
| PUT     | /api/pedidos        | Actualiza un pedido existente  |

### Clientes
| Método  | Endpoint            | Descripción                     |
|---------|---------------------|---------------------------------|
| GET     | /api/clientes/{id}  | Busca un cliente por su ID     |
| POST    | /api/clientes       | Guarda un nuevo cliente        |
| PUT     | /api/clientes       | Actualiza un cliente existente |

## Diagrama de Arquitectura
Este diagrama muestra la arquitectura del microservicio de pedidos, incluyendo los componentes principales y sus interacciones.

![alt text](<Pedidos-Service.drawio (1).png>)

## Variables de entorno
Configura las siguientes variables de entorno.
```env
DB_USER_POSTGRES=tu_usuario_postgres
DB_PASSWORD_POSTGRES=tu_password_postgres
RABBITMQ_SP_HOST=localhost
RABBITMQ_SP_PORT=5672
RABBITMQ_SP_USER=guest
RABBITMQ_SP_PASSWORD=guest
```

## 🛠 Tecnologías Utilizadas

- Java con Spring Boot
- Swagger para documentación de API
- Arquitectura Hexagonal

## 📝 Notas Adicionales
Si necesitas ayuda, ¡abre un issue o contáctanos! 🚀



