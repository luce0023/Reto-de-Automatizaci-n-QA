
---

```markdown
# Reto Front-End - Automatización Sauce Demo con Playwright y Cucumber

---

## 📖 README: Configuración y Ejecución

### 🚀 Requisitos previos
- Java JDK 11+
- Apache Maven 3.6+
- VSCode con extensiones:
  - Extension Pack for Java
  - Maven for Java
- Playwright instalado
- Conexión a internet (aplicación pública: https://www.saucedemo.com/)

### ⚙️ Configuración
1. Clonar el repositorio:
   ```bash
   git clone https://github.com/tuusuario/RetoFrontEndPlaywrightCucumber.git
   ```
2. Entrar al proyecto:
   ```bash
   cd RetoFrontEndPlaywrightCucumber
   ```
3. Verificar dependencias:
   ```bash
   mvn clean install
   ```

### ▶️ Ejecución de pruebas
- Ejecutar todos los tests:
  ```bash
  mvn test
  ```
- Ver reporte en HTML:
  ```
  target/cucumber-reports/index.html
  ```

### 📂 Estructura del proyecto
```
src
 ├── main
 │    └── java
 │         └── utilidades (clases de soporte si aplica)
 └── test
      └── java
           └── com.saucedemo.runners
                └── RunCucumberTest.java
           └── com.saucedemo.steps
                ├── LoginSteps.java
                └── CompraSteps.java
           └── com.saucedemo.pages
                ├── LoginPage.java
                ├── ProductosPage.java
                ├── CarritoPage.java
                └── CheckoutPage.java
      └── resources
           └── features
                ├── Login.feature
                └── CompraCompleta.feature
```

---

## 📊 Informe Breve: Estrategia de Automatización y Patrones Utilizados

### 🎯 Estrategia de Automatización
- Se automatizó la aplicación **Sauce Demo** validando escenarios de login y compra completa.
- Se diseñaron escenarios **positivos y negativos** en Gherkin para reflejar criterios de aceptación.
- Se validan tanto **comportamientos funcionales** (redirecciones, mensajes de error) como la **visibilidad de elementos clave**.
- Los tests son **independientes**: cada escenario abre navegador, ejecuta acciones y se cierra al finalizar.

### 🧩 Patrones Utilizados
- **Page Object Model (POM)**: cada página tiene su clase con selectores y métodos (`LoginPage`, `ProductosPage`, etc.).
- **Cucumber + Gherkin**: definición clara de escenarios en lenguaje natural (`Login.feature`, `CompraCompleta.feature`).
- **Hooks (@Before, @After)**: inicialización y cierre de Playwright en cada escenario para garantizar limpieza.
- **Separación de responsabilidades**:
  - *Features*: describen el comportamiento esperado.
  - *Steps*: conectan las frases Gherkin con código Java.
  - *Pages*: encapsulan la lógica de interacción con la UI.
- **Validaciones con JUnit**: uso de `assertTrue` y `assertEquals` para comprobar resultados esperados.

---

