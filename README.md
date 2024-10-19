# TP 1 PROGRAMACION AVANZADA II Spring Boot

## Descripción del Proyecto
Este proyecto implementa operaciones sobre colas siguiendo el estandar AMQP.

## Casos de Uso
1. **Push Message**: Agrega un mensaje a la cola.
2. **Pop Message**: Extrae un mensaje de la cola y cambia el estado.
3. **Get Messages**: Obtiene todos los mensajes en la cola.


### Rutas del API

1. **Obtener Mensajes**
   - **Método**: `GET`
   - **Ruta**: `/queue`
   - **Descripción**: Obtiene todos los mensajes en la cola.

2. **Agregar Mensaje a la Cola**
   - **Método**: `POST`
   - **Ruta**: `/queue/push`
   - **Descripción**: Agrega un nuevo mensaje a la cola.
   - **Estructura**:
     ```json
     {
         "content": "Mensaje",
         "userId": "12345",
         "to": "carlitos@eejemplo.com",
         "priority": 1,
         "contentType": "text/plain",
     }
     ```

3. **Extraer Mensaje de la Cola**
   - **Metodo**: `DELETE`
   - **Ruta**: `/queue/pop`
   - **Descripción**: Extrae el mensaje en orden FIFO y cambia el estado a "IN PROGRESS".

- **Estados de Mensaje**: 
  - `PENDING`: El mensaje se agrego a la cola.
  - `IN PROGRESS`: El mensaje se extrajo.
  - `COMPLETED`: (No implementado, pero se usaria para marcar el mensaje como procesado).
  
- **Propiedades**:
  - `content`: Contenido del mensaje.
  - `userId`: ID del usuario que envía el mensaje.
  - `to`: Destinatario del mensaje.
  - `priority`: Prioridad del mensaje.
  - `contentType`: Tipo de contenido del mensaje.


