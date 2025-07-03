🧠 Backend

📝 Estado: Borrador — aquí desarrollaremos el backend para el proyecto final.


---

📋 Descripción

Este repositorio contendrá todo el código relacionado con la lógica del servidor y la API REST. El objetivo principal es gestionar la comunicación con el frontend, procesar las peticiones del usuario, aplicar la lógica de negocio y mantener una estructura modular, segura y escalable.
Nota: Este backend no incluye manejo de base de datos en esta fase inicial.


---

🛠️ Tecnologías

☕ Java 17

⚙️ Spring Boot — Framework para aplicaciones Java

📦 Maven — Herramienta de construcción y gestión de dependencias

🔐 Spring Security — Módulo de seguridad (opcional según requerimientos)

🌐 API REST — Exposición de servicios al frontend

🧪 JUnit / Mockito — Pruebas unitarias y de integración



---

📂 Estructura del proyecto

/src
  /main
    /java
      /com/miempresa/miproyecto
        /controllers   # 🎮 Define los endpoints REST
        /services      # 🧠 Contiene la lógica de negocio
        /models        # 📦 Clases de datos (DTOs o modelos internos)
        /config        # ⚙️ Configuración general (CORS, seguridad, etc.)
    /resources
      application.properties  # 📁 Configuración del proyecto
  /test
    /java
      /com/miempresa/miproyecto  # 🧪 Pruebas automatizadas


---

🔗 Conexión con el frontend

El backend está diseñado para funcionar de forma integrada con el frontend desarrollado en Angular. Todos los servicios expuestos siguen el estándar REST y están listos para ser consumidos desde el cliente web.


---

📝 Notas

Este README es un borrador en evolución. Será actualizado conforme se definan nuevas rutas, módulos o configuraciones.
Cualquier sugerencia o mejora es bienvenida 🚀


---
