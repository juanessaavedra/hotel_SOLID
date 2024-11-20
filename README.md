# Sistema de Reservas de Hotel
## Descripción General
Sistema de gestión hotelera que permite realizar reservas de habitaciones, manejar clientes y procesar pagos. Desarrollado bajo principios de diseño que aseguran un código mantenible y escalable.

# Funcionalidades Principales

## Gestión de reservas
- Diferentes tipos de habitaciones (Estándar y Suite)
- Sistema de clientes VIP
- Múltiples métodos de pago
- Servicios adicionales para suites

# Principios SOLID Aplicados
El proyecto está construido siguiendo los principios SOLID, lo que nos permite tener:

## Responsabilidad Única:
Cada clase del sistema tiene una única tarea. Por ejemplo, la clase de pagos solo se encarga de procesar pagos, mientras que la de reservas solo maneja reservaciones.

## Abierto/Cerrado: 
El sistema está diseñado para añadir nuevas funcionalidades sin modificar el código existente. Podemos agregar nuevos tipos de habitaciones o métodos de pago fácilmente.

## Sustitución de Liskov: 
Todas las clases heredadas (como habitaciones VIP o estándar) pueden usarse de manera intercambiable sin afectar el funcionamiento del sistema.

## Segregación de Interfaces: 
Usamos interfaces pequeñas y específicas en lugar de una grande y general, lo que hace el código más flexible y fácil de mantener.

## Inversión de Dependencias: 
El sistema depende de abstracciones (interfaces) y no de implementaciones concretas, lo que facilita cambiar componentes sin afectar otras partes del sistema.

## Cómo Usar el Sistema

1. Registrar un cliente
2. Seleccionar tipo de habitación
3. Elegir método de pago
4. Confirmar reserva
