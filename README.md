# Microservicio de Costo de producción (ms-production-cost)

## Descripción

El microservicio `ms-production-cost` se encarga de gestionar todas las funcionalidades relacionadas con el calculo del costo de producción del sistema, tales como:

- Creacion del producto final.
- Creación de la materia prima del respectivo producto con sus costes.
- Creación de la mano de obra del respectivo producto con sus costes.
- Creacion de costos indirectos de ese producto.

## Estructura del Proyecto

```
ms-production-cost
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── yourcompany
│   │   │           └── mssecurity
│   │   │               ├── controller
│   │   │               │   └── productController.java
│   │   │               ├── service
│   │   │               │   └── productService.java
│   │   │               ├── repository
│   │   │               │   └── productRepository.java
│   │   │               ├── model
│   │   │               │   ├── product.java
│   │   │               │   └── workforce.java
│   │   │               ├── dto
│   │   │               │   ├── productRequest.java
│   │   │               │   ├── workforceRequest.java
│   │   │               │   └── feedstockResponse.java
│   │   │               ├── exception
│   │   │               │   └── CustomException.java
│   │   │               └── MsProductionCostApplication.java
│   │   ├── resources
│   │   │   ├── application.properties
│   │   │   └── application-dev.properties
│   │   └── docker
│   │       └── Dockerfile
│   └── test
│       └── java
│           └── com
│               └── yourcompany
│                   └── msproductioncost
│                       └── productTests.java
├── pom.xml
└── README.md
```

## Requisitos Previos

- JDK 11 o superior
- Maven 3.6.3 o superior
- Docker (opcional, para contenedorización)

## Configuración del Proyecto

### Configuración de Maven

Asegúrate de tener Maven instalado y configurado en tu sistema. Puedes verificar la instalación con el siguiente comando:

```sh
mvn -v
```

### Dependencias

El archivo `pom.xml` incluye todas las dependencias necesarias para el proyecto. Asegúrate de incluir las siguientes dependencias en tu `pom.xml`:

```xml
<dependencies>
    <!-- Dependencias de Spring Boot -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-security</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-validation</artifactId>
    </dependency>
    <dependency>
        <groupId>io.jsonwebtoken</groupId>
        <artifactId>jjwt</artifactId>
        <version>0.9.1</version>
    </dependency>
    <!-- Dependencias de prueba -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
</dependencies>
```

## Ejecución del Proyecto

Para ejecutar el proyecto localmente, utiliza el siguiente comando de Maven:

```sh
mvn spring-boot:run
```

## Contenedorización con Docker

El proyecto incluye un `Dockerfile` para contenedorización. Para construir y ejecutar la imagen Docker, utiliza los siguientes comandos:

```sh
# Construir la imagen Docker
docker build -t ms-production-cost .

# Ejecutar el contenedor
docker run -p 8080:8080 ms-production-cost
```

## Endpoints

### Creacion de elementos

- `POST /api/production-cost/product`: Crear producto
- `POST /api/production-cost/workforce`: Crear materia prima
- `POST /api/production-cost/recover`: Crear mano de obra

## Contribuciones

Si deseas contribuir al proyecto, por favor sigue estos pasos:

1. Haz un fork del repositorio.
2. Crea una nueva rama (`git checkout -b feature/nueva-funcionalidad`).
3. Realiza tus cambios y haz commit (`git commit -am 'Agregar nueva funcionalidad'`).
4. Haz push a la rama (`git push origin feature/nueva-funcionalidad`).
5. Abre un Pull Request.

## Licencia

Este proyecto está licenciado bajo los términos de la licencia MIT. Consulta el archivo [LICENSE](LICENSE) para más detalles.
