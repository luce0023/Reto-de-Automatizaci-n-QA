
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
   git clone https://github.com/luce0023/Reto-de-Automatizaci-n-QA.git
   ```
2. Entrar al proyecto Front-End:
   ```bash
   cd Reto-de-Automatizaci-n-QA/RetoFrontEndPlaywrightCucumber
   ```
3. Instalar dependencias:
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
  target/cucumber-reports/cucumber-report.html
  ```

### 📂 Estructura del proyecto
```
RetoFrontEndPlaywrightCucumber/
│   pom.xml
│
├───src
│   └───test
│       ├───java
│       │   └───com/saucedemo
│       │       ├───pages
│       │       │       CartPage.java
│       │       │       CheckoutPage.java
│       │       │       InventoryPage.java
│       │       │       LoginPage.java
│       │       │
│       │       ├───runners
│       │       │       RunCucumberTest.java
│       │       │
│       │       └───steps
│       │               LoginSteps.java
│       │               PlaywrightContext.java
│       │               ProductSteps.java
│       │
│       └───resources
│           └───features
│                   Login.feature
│
└───target
    ├───cucumber-reports
    │       cucumber-report.html
    ├───surefire-reports
    │       TEST-com.saucedemo.runners.RunCucumberTest.xml
    │       com.saucedemo.runners.RunCucumberTest.txt
    └───test-classes
            (clases compiladas)
```

---

## 📊 Informe Breve: Estrategia de Automatización y Patrones Utilizados

### 🎯 Estrategia de Automatización
- Se automatizó la aplicación **Sauce Demo** validando escenarios de login y flujo de compra.  
- Se diseñaron escenarios **positivos y negativos** en Gherkin para reflejar criterios de aceptación.  
- Se validan tanto **comportamientos funcionales** (redirecciones, mensajes de error) como la **visibilidad de elementos clave**.  
- Los tests son **independientes**: cada escenario abre navegador, ejecuta acciones y se cierra al finalizar.  

### 🧩 Patrones Utilizados
- **Page Object Model (POM)**: cada página tiene su clase con selectores y métodos (`LoginPage`, `InventoryPage`, `CartPage`, `CheckoutPage`).  
- **Cucumber + Gherkin**: definición clara de escenarios en lenguaje natural (`Login.feature`).  
- **Hooks (@Before, @After)**: inicialización y cierre de Playwright en cada escenario para garantizar limpieza.  
- **Separación de responsabilidades**:  
  - *Features*: describen el comportamiento esperado.  
  - *Steps*: conectan las frases Gherkin con código Java.  
  - *Pages*: encapsulan la lógica de interacción con la UI.  
- **Validaciones con JUnit**: uso de `assertTrue` y `assertEquals` para comprobar resultados esperados.  

---
