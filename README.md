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

---

## Entidades implementadas

- **Usuario**: Clientes, jefes de produccion, administradores y Gestor Logistico.
- **Producto**: Productos agrícolas orgánicos.
- **Pedido**: Solicitudes realizadas por los clientes.
- **Entrega**: Logística de entrega de los pedidos.

Cada entidad cuenta con:
- `@Entity` (modelo de datos)
- `@Repository` para acceso a datos
- `@RestController` para exponer APIs
- `DTO` para transporte de datos
- Servicios opcionales (`@Service`) para lógica de negocio


---

## Estructura del Proyecto y Microservicios

El proyecto está organizado de forma modular, simulando una arquitectura basada en microservicios por entidad. Cada entidad (Usuario, Producto, Pedido, Entrega) cuenta con:

- Un controlador REST (`@RestController`)
- Un servicio de negocio (`@Service`)
- Un repositorio (`@Repository`)
- Su modelo de datos (`@Entity`)
- Su DTO para transferencia de datos

Esto permite una estructura escalable que puede adaptarse a una arquitectura de microservicios distribuida en futuras etapas del proyecto.

---

## Endpoints disponibles

| Recurso   | Método  | Endpoint              | Descripción básica                        |
|-----------|---------|------------------------|--------------------------------------------|
| Usuario   | GET     | `/api/usuarios`        | Listar todos los usuarios                  |
| Usuario   | POST    | `/api/usuarios`        | Crear un nuevo usuario                     |
| Usuario   | PUT     | `/api/usuarios/{id}`   | Actualizar un usuario por ID               |
| Usuario   | DELETE  | `/api/usuarios/{id}`   | Eliminar un usuario por ID                 |
| Producto  | GET     | `/api/productos`       | Listar todos los productos                 |
| Producto  | POST    | `/api/productos`       | Crear un nuevo producto                    |
| Producto  | PUT     | `/api/productos/{id}`  | Actualizar un producto por ID              |
| Producto  | DELETE  | `/api/productos/{id}`  | Eliminar un producto por ID                |
| Pedido    | GET     | `/api/pedidos`         | Listar pedidos realizados                  |
| Pedido    | POST    | `/api/pedidos`         | Crear un nuevo pedido                      |
| Pedido    | PUT     | `/api/pedidos/{id}`    | Actualizar un pedido por ID                |
| Pedido    | DELETE  | `/api/pedidos/{id}`    | Eliminar un pedido por ID                  |
| Entrega   | GET     | `/api/entregas`        | Listar entregas programadas                |
| Entrega   | POST    | `/api/entregas`        | Crear una nueva entrega                    |
| Entrega   | PUT     | `/api/entregas/{id}`   | Actualizar una entrega por ID              |
| Entrega   | DELETE  | `/api/entregas/{id}`   | Eliminar una entrega por ID                |

---

## Pruebas de funcionamiento (RA3)

Las pruebas de las APIs fueron realizadas con **Postman**, verificando lo siguiente:

- Inserción de datos con `POST`
- Consulta de datos con `GET`
- Actualización de registros con `PUT`
- Eliminación de datos con `DELETE`
- Validación de respuestas correctas (status 200, 201, 204)

---

## Página de inicio

La aplicación muestra una interfaz inicial y descriptiva, Tecnologias usadas para la creacion de esta, los perfiles del sistema y accesos a las APIs.

---

## Autor

- **Nombre:** Nicolas Maturana, Andy Navarrete, Vicente Guiterrez y Raimundo Larrain
- **Carrera:** Ingeniería en Informatica
- **Institución:** Duoc UC, San Carlos de Apoquindo

---

## Notas

- `spring.jpa.hibernate.ddl-auto=update` Cambiamos de "create-drop" a "update" para que los datos no se borren al reiniciar la app.
- Dependecias de Oracle recomendadas por Profesor usadas.
- Proyecto probado y funcional conectado a Oracle Cloud via Wallet.

