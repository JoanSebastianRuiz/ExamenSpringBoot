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

## API Documentation

### Base URL
http://localhost:8081

---

## Endpoints

### 1. **Actualizar Reserva**
- **Endpoint:** `/reservas/{id}`
- **Método HTTP:** `PUT`
- **Descripción:** Actualiza la información de una reserva existente.
- **Parámetros:**
  - `id` (path parameter, requerido): El ID de la reserva a actualizar.
- **Cuerpo de la petición:**
```json
{
  "documentoUsuario": "12345678",
  "idEspacio": 1,
  "fecha": "2025-02-21T10:00:00",
  "horaInicio": "2025-02-21T10:00:00",
  "horaFin": "2025-02-21T12:00:00"
}

Respuesta (200 OK):
{
  "message": "Reserva actualizada correctamente"
}
