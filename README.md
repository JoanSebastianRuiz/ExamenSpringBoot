# Sistema de Gestión de Reservas para Coworking
## Descripción del Proyecto
Este proyecto tiene como objetivo la creación de un sistema de gestión de reservas para Coworking, donde los usuarios pueden consultar y reservar espacios dentro de una red de oficinas, salas de reuniones y escritorios compartidos. La solución proporcionada es una API REST desarrollada con Spring Boot y PostgreSQL para gestionar tanto los espacios como las reservas de manera eficiente.

## Funcionalidades Principales:
- Gestión de Espacios: Crear, consultar, modificar y eliminar espacios de coworking.
- Gestión de Reservas: Los usuarios pueden crear, modificar y cancelar reservas de espacios. Se asegura que no haya solapamientos de reservas en los mismos horarios.
- API REST: Los endpoints están bien definidos y documentados, permitiendo la fácil integración con otras plataformas.
## Tecnologías Utilizadas
- Spring Boot: Framework principal para el desarrollo de la API REST.
- PostgreSQL: Base de datos relacional para persistencia de los datos de espacios y reservas.
- Swagger/OpenAPI: Documentación de la API para facilitar el consumo de la misma.
- Spring Data JPA: Para interactuar con la base de datos utilizando repositorios.
## Requisitos Previos:
Java 17 o superior.
PostgreSQL instalado y configurado.
Maven para la gestión de dependencias.
Swagger UI para la documentación interactiva de la API.
