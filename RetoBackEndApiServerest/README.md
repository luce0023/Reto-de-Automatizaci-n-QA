
```markdown
# Reto Backend - Automatización con Karate DSL

## 🚀 Requisitos previos
- Java JDK 11+
- Apache Maven 3.6+
- VSCode o IDE de preferencia
- Conexión a internet (API pública: https://serverest.dev)

## ⚙️ Configuración
1. Clonar el repositorio:
   ```bash
   git clone https://github.com/tuusuario/RetoBackEndApiServerest.git
   ```
2. Entrar al proyecto:
   ```bash
   cd RetoBackEndApiServerest
   ```
3. Instalar dependencias:
   ```bash
   mvn clean install
   ```

## ▶️ Ejecución de pruebas
- Ejecutar todos los tests:
  ```bash
  mvn test
  ```
- Ver reporte en HTML:
  ```
  target/karate-reports/karate-summary.html
  ```

## 📂 Estructura del proyecto
```
src/test/resources/features/users/
  ├── GetUsers.feature
  ├── GetUserById.feature
  ├── PostUser.feature
  ├── PutUser.feature
```

## 📊 Estrategia de Automatización
- Escenarios positivos y negativos para cada endpoint (`GET`, `POST`, `PUT`).
- Validación de **status codes**, **mensajes de respuesta** y **estructura de datos**.
- Uso de datos dinámicos (emails únicos) para evitar colisiones.
- Independencia de los tests: cada escenario crea sus propios datos antes de consultarlos.

## 🧩 Patrones utilizados
- **Background**: configuración común (URL base, paths).
- **Data Generator**: clase auxiliar en Java para datos válidos y únicos.
- **Scenario chaining**: crear recurso con `POST` y luego usar su `_id` en `GET/PUT`.
- **Validación flexible**: `#string`, `#number`, `match each` para validar tipos.
- **Separación de features**: cada endpoint en su propio archivo `.feature`.
```

