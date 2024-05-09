# Backend de EventZ

Este repositorio contiene el código fuente del backend de EventZ. 

EventZ es una aplicación móvil de gestión de eventos, el usuario va a poder realizar eventos e invitar a demás personas mediante la propia aplicación y/o a través de mensajes de WhatsApp.

Futuras funcionalidades:
- Poder crear, actualizar y borrar eventos.
- Poder guardar el evento en Google Calendar.
- Poder enviar invitaciones a través de WhatsApp.

La estructura de archivos y directorios es la siguiente:

- `src/main/java/com/gestioneventos/controller`: Este directorio contiene los controladores de Spring Boot para la API REST. Los controladores son responsables de manejar las solicitudes HTTP y enviar las respuestas correspondientes.

- `src/main/java/com/gestioneventos/model`: Este directorio contiene las clases de modelo de Spring Boot. Estas clases representan las entidades de la base de datos y se utilizan para mapear los datos de la base de datos a objetos Java y viceversa.

- `src/main/java/com/gestioneventos/repository`: Este directorio contiene las interfaces de repositorio de Spring Boot. Estas interfaces definen los métodos para acceder a los datos en la base de datos.

- `src/main/java/com/gestioneventos/service`: Este directorio contiene las clases de servicio de Spring Boot. Estas clases implementan la lógica de negocio de la aplicación y utilizan los repositorios para acceder a los datos.


Para ejecutar el backend de la aplicación, asegúrese de tener instalado Java y Maven en su sistema. Luego, puede ejecutar el siguiente comando en la raíz del proyecto:

```
mvn spring-boot:run
```

Esto iniciará el servidor de desarrollo de Spring Boot y la API REST estará disponible en `http://localhost:8080`.