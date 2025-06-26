![Imagen Proyecto](https://github.com/user-attachments/assets/be5732a6-73c7-4ae2-b1fd-e8a3af7685d4)

# AgroVerde SPA - Transformación Digital para La Agricultura Organica

Proyecto desarrollado para la evaluación de la asignatura Desarrollo Fullstack I.  
Consiste en la implementación de una solución tecnológica escalable para la empresa AgroVerde SPA, dedicada a la venta y distribución de productos agrícolas orgánicos.

---

## Tecnologías utilizadas

- Java 17
- Spring Boot 3.3.12
- Oracle SQL (conexion via Wallet)
- Maven
- Visual Studio Code (Con extensiones Spring Boot Extension Pack y Extension Pack for Java)
- Postman (para pruebas de ingreso, obtencion y eliminacion de datos en las APIs)
- Spring Web (Para desarrollo de APIs)
- Lombok (Anotaciones para la simplificacion de codigo)
- Spring DATA JPA (Para mayor persistencia)
- Oracle Driver (Driver que entrega acceso a la conexion de Oracle)
- Spring HATEOAS (Para la implementación de enlaces HATEOAS en las respuestas de las APIs)
- Spring Security (JWT) (Para protección de los recursos con autenticación)


---

## Entidades implementadas

- **Usuario**: Clientes, jefes de produccion, administradores y Gestor Logistico.
- **Producto**: Productos agrícolas orgánicos.
- **Pedido**: Solicitudes realizadas por los clientes.
- **Entrega**: Logística de entrega de los pedidos.

Cada entidad cuenta con:
- @Entity modelo de datos
- @Repository para acceso a datos
- @RestController para exponer APIs
- DTO para transporte de datos
- Servicios opcionales (@Service) para lógica de negocio
- HATEOAS implementado usando **`RepresentationModelAssembler`** para devolver enlaces en las respuestas.


---

## Estructura del Proyecto y Microservicios

El proyecto está organizado de forma modular, simulando una arquitectura basada en microservicios por entidad. Cada entidad (Usuario, Producto, Pedido, Entrega) cuenta con:

- Un controlador REST (@RestController)
- Un servicio de negocio (@Service)
- Un repositorio (@Repository)
- Su modelo de datos (@Entity)
- Su DTO para transferencia de datos
- Enlaces HATEOAS para recursos accesibles, como `actualizar`, `eliminar` y `listar`

Esto permite una estructura escalable que puede adaptarse a una arquitectura de microservicios distribuida en futuras etapas del proyecto.

---

## Endpoints disponibles

| Recurso   | Método  | Endpoint              | Descripción básica                        |
|-----------|---------|------------------------|--------------------------------------------|
| Usuario   | GET     | /api/usuarios        | Listar todos los usuarios                  |
| Usuario   | POST    | /api/usuarios        | Crear un nuevo usuario                     |
| Usuario   | PUT     | /api/usuarios/{id}   | Actualizar un usuario por ID               |
| Usuario   | DELETE  | /api/usuarios/{id}   | Eliminar un usuario por ID                 |
| Producto  | GET     | /api/productos       | Listar todos los productos                 |
| Producto  | POST    | /api/productos       | Crear un nuevo producto                    |
| Producto  | PUT     | /api/productos/{id}  | Actualizar un producto por ID              |
| Producto  | DELETE  | /api/productos/{id}  | Eliminar un producto por ID                |
| Pedido    | GET     | /api/pedidos         | Listar pedidos realizados                  |
| Pedido    | POST    | /api/pedidos         | Crear un nuevo pedido                      |
| Pedido    | PUT     | /api/pedidos/{id}    | Actualizar un pedido por ID                |
| Pedido    | DELETE  | /api/pedidos/{id}    | Eliminar un pedido por ID                  |
| Entrega   | GET     | /api/entregas        | Listar entregas programadas                |
| Entrega   | POST    | /api/entregas        | Crear una nueva entrega                    |
| Entrega   | PUT     | /api/entregas/{id}   | Actualizar una entrega por ID              |
| Entrega   | DELETE  | /api/entregas/{id}   | Eliminar una entrega por ID                |

---

## Pruebas de funcionamiento (RA3)

Las pruebas de las APIs fueron realizadas con **Postman**, verificando lo siguiente:

- Inserción de datos con POST
- Consulta de datos con GET
- Actualización de registros con PUT
- Eliminación de datos con DELETE
- Validación de respuestas correctas (status 200, 201, 204)

---

## Capturas de pantalla de Postman

-Crear Producto (POST /api/productos)
![image](https://github.com/user-attachments/assets/f33882f7-d7ed-48a1-92e9-c2fbcd2c1bad)


-Listar Productos (GET /api/productos)
![image](https://github.com/user-attachments/assets/c8fe2b34-9ea2-4247-9f92-96cf46736ce8)


-Actualizar Producto (PUT /api/productos/{id})
![image](https://github.com/user-attachments/assets/de45c007-fcb3-496d-ac83-d44f55ae7ca9)


-Eliminacion Producto (DELETE /api/productos/{id})
![image](https://github.com/user-attachments/assets/b8f82c71-192c-4a92-a0fd-e33a5f5eec94)


---

## Implementación de HATEOAS

Se ha implementado **HATEOAS** para todas las entidades principales (Usuario, Producto, Pedido, Entrega) utilizando **`RepresentationModelAssembler`**. Esto permite que la API devuelva enlaces a las operaciones disponibles para cada recurso. Los enlaces incluyen:

- **`self`**: Enlace al recurso mismo (`GET`).
- **`actualizar`**: Enlace para actualizar el recurso (`PUT`).
- **`eliminar`**: Enlace para eliminar el recurso (`DELETE`).

### **Ejemplo de respuesta con HATEOAS en Productos**:

{
  "id": 3,
  "nombre": "Caja de mangos",
  "tipo": "Mangos",
  "stock": 13,
  "precio": 15000,
  "_links": {
    "productos": {
      "href": "http://localhost:8080/api/productos"
    },
    "actualizar": {
      "href": "http://localhost:8080/api/productos/3"
    },
    "eliminar": {
      "href": "http://localhost:8080/api/productos/3"
    }
  }
}

---

## Capturas de pantalla utilizando Swagger

-Crear Producto (POST /api/productos)
![image](https://github.com/user-attachments/assets/0b273198-6b56-43d4-bc15-7f6bd059561c)


-Listar Productos (GET /api/productos)
![image](https://github.com/user-attachments/assets/bb6cbf08-53b0-49ef-9df4-cdfc653198dc)


-Actualizar Producto (PUT /api/productos/{id})
![image](https://github.com/user-attachments/assets/330bab21-2b34-4155-b9ec-a326fddd5fd5)


-Eliminacion Producto (DELETE /api/productos/{id})
![image](https://github.com/user-attachments/assets/399d60c7-72c8-46b7-9019-a864badf6c69)

---

## Página de inicio

La aplicación muestra una interfaz inicial y descriptiva, Tecnologias usadas para la creacion de esta, los perfiles del sistema y accesos a las APIs.

---

## Credenciales de Swagger 

**Swagger muestra un popup** para autenticarse. En este caso, cuando accedas a la documentación de Swagger en **`http://localhost:8080/doc/swagger-ui/index.html`**, aparecerá una ventana emergente que solicita un **usuario** y **contraseña**. 

### **Credenciales de acceso**:
- **Usuario**: `admin` 
- **Contraseña**: `1234`

---

## Autor

- **Nombre:** Nicolas Maturana, Andy Navarrete, Vicente Guiterrez y Raimundo Larrain
- **Carrera:** Ingeniería en Informatica
- **Institución:** Duoc UC, San Carlos de Apoquindo

---

## Notas

- spring.jpa.hibernate.ddl-auto=update Cambiamos de "create-drop" a "update" para que los datos no se borren al reiniciar la app.
- Dependecias de Oracle recomendadas por Profesor usadas.
- Proyecto probado y funcional conectado a Oracle Cloud via Wallet.


---

## Instalacion 
```
bash
git clone https://github.com/Nimaturana/PruebaFullS.git
cd PruebaFullS
```

Ejecucion de la aplicacion 
1. Configura correctamente la base de datos Oracle y la Wallet.
2. Verifica que el archivo [application.properties] tenga la siguiente configuracion junto tus datos.

spring.datasource.url=jdbc:oracle:thin:@TU_WALLET_DB_HIGH

spring.datasource.username=tu_usuario_BD

spring.datasource.password=tu_contraseña_BD

spring.jpa.hibernate.ddl-auto=update     
Nota: Puedes usar "create-drop" para que cada vez que reinicies la aplicacion la informacion de las APIs sean borradas. 

3. Ejecutar proyecto desde la consola
```
bash
./mvnw spring-boot:run
```

O abriendo AgroVerdeSpaApplication.java haciendo click en Ejecutar ▶️

4. Acceder a las APIs desde Postman
```
http://localhost:8080/api/(api que desees ingresar)
```
5. Acceder al Swagger 

```
http://localhost:8080/doc/swagger-ui/index.html
```

---
##  Propuesta de workflow

name: CI AgroVerde

on:
  push:
    branches: [ main ]
  pull_request:
    branches: [ main ]

jobs:
  build:

    runs-on: ubuntu-latest

    steps:
    - name: Clonar repositorio
      uses: actions/checkout@v3

    - name: Configurar Java
      uses: actions/setup-java@v3
      with:
        java-version: '17'
        distribution: 'temurin'

    - name: Construir con Maven
      run: mvn clean install
