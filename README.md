
---

```markdown
# Reto de Automatización QA

Este repositorio contiene dos proyectos independientes de automatización:

- **Reto Front-End**: Automatización de la aplicación Sauce Demo usando Playwright + Cucumber + Page Object Model (POM).
- **Reto Back-End**: Automatización de la API ServeRest usando Karate DSL.

---

## 📂 Estructura del repositorio

```
Reto-de-Automatizacion-QA/
├── RetoFrontEndPlaywrightCucumber/
│   ├── pom.xml
│   ├── src/...
│   └── README.md   ← Instrucciones específicas + Informe breve
│
└── RetoBackEndApiServerest/
    ├── pom.xml
    ├── src/...
    └── README.md   ← Instrucciones específicas + Informe breve
```

---

## 📖 Documentación

Cada reto tiene su propia documentación en un archivo **README.md** dentro de su carpeta:

- [Reto Front-End](./RetoFrontEndPlaywrightCucumber/README.md)  
- [Reto Back-End](./RetoBackEndApiServerest/README.md)

En cada README encontrarás:
1. **Instrucciones de configuración y ejecución** para correr las pruebas.  
2. **Informe breve** sobre la estrategia de automatización y los patrones utilizados.  

---

## ▶️ Ejecución rápida

### Clonar el repositorio
```bash
git clone https://github.com/luce0023/Reto-de-Automatizaci-n-QA.git
```

### Entrar al proyecto Front-End
```bash
cd Reto-de-Automatizaci-n-QA/RetoFrontEndPlaywrightCucumber
mvn test
```

### Entrar al proyecto Back-End
```bash
cd Reto-de-Automatizaci-n-QA/RetoBackEndApiServerest
mvn test
```

---

## ✨ Notas
- Cada proyecto es independiente y puede ejecutarse por separado.  
- Los reportes de ejecución se generan en la carpeta `target` de cada reto.  
```

---
