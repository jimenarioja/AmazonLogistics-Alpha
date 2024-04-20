# <span style="color: #0D88D2;">Sistema de Taquillas Autoservicio de Amazon</span>

Bienvenido al sistema de gestión de taquillas autoservicio de Amazon. Este proyecto en Java implementa un sistema de puntos de recogida y devolución de paquetes utilizando taquillas autoservicio situadas en varios puntos de la ciudad.

## <span style="color: #9FD7F9;">Descripción general</span>

El sistema permite a los clientes seleccionar un Package Locker como punto de recogida para sus pedidos. Los clientes pueden consultar la ubicación y horario de apertura de los puntos de recogida antes de seleccionar uno. Un empleado de Amazon entrega el paquete en la taquilla correspondiente y el cliente recibe una notificación con los datos necesarios para recogerlo.

El sistema controla la entrega y recogida de paquetes, asegurando que los clientes tengan una experiencia fluida y que los paquetes se recojan a tiempo. Los paquetes se almacenan en las taquillas durante un período de tiempo específico antes de ser devueltos a la central de Amazon si no son recogidos.

## <span style="color: #9FD7F9;">Funcionalidades</span>

El proyecto se compone de las siguientes clases:

- **PickingPointsSystem**: Gestiona los puntos de recogida, permitiendo añadir, eliminar y consultar información sobre los Package Lockers.
- **PackageLocker**: Representa un Package Locker, con características como un identificador, coordenadas GPS, horario de apertura y estado operativo.
- **Package**: Representa un paquete, con características como un código de paquete, fecha límite de almacenaje y estados de recogido o devuelto.

El sistema también incluye clases de prueba (JUnit4) para cada una de las clases principales.

## <span style="color: #9FD7F9;">Uso</span>

El sistema se ejecuta como un programa Java que puede ser configurado con parámetros de línea de comandos para controlar los Package Lockers y paquetes.

## <span style="color: #9FD7F9;">Licencia</span>

Este proyecto está bajo la [Licencia MIT](https://opensource.org/licenses/MIT).

## <span style="color: #9FD7F9;">Autor</span>

Este proyecto fue desarrollado por [tu nombre o nombre de tu equipo].

## <span style="color: #9FD7F9;">Contacto</span>

Para cualquier consulta o sugerencia, puedes contactar con el autor del proyecto.

## <span style="color: #9FD7F9;">Contribuciones</span>

Las contribuciones son bienvenidas. Si tienes alguna mejora o corrección, no dudes en abrir una solicitud de extracción.
