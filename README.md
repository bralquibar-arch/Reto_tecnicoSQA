# 🧠 Proyecto de Automatización - JQueryUI Datepicker (Serenity Screenplay)

Este proyecto implementa pruebas automatizadas utilizando **Serenity BDD**, **Screenplay Pattern** y **Cucumber**, verificando el comportamiento del componente **Datepicker** del sitio [JQueryUI](https://jqueryui.com/datepicker/).

---

## 📋 Descripción General

El objetivo del proyecto es validar la funcionalidad del calendario emergente (Datepicker), incluyendo:
- Selección de fechas dentro del rango permitido.
- Navegación entre meses y años.
- Restricción de fechas deshabilitadas (fuera del rango permitido).

Se utiliza el enfoque **Screenplay Pattern** para mantener un diseño modular, reutilizable y fácil de mantener.

---

## 🧱 Estructura del Proyecto

```
TallerSQAScreenplay/
│
├── build.gradle                     # Configuración de dependencias Gradle
├── serenity.conf                    # Configuración de Serenity
├── README.md                        # Este archivo
│
├── src/
│   ├── main/
│   │   └── java/com/jqueryui/
│   │       ├── tasks/               # Acciones del actor (abrir calendario, seleccionar fechas, etc.)
│   │       ├── ui/                  # Mapeo de elementos (Targets)
│   │       └── questions/           # Validaciones (Ensure / SeeThat)
│   │
│   └── test/
│       ├── java/com/jqueryui/Stepdefinitions/  # Steps Cucumber (Given, When, Then)
│       └── resources/features/                 # Archivos .feature en Gherkin
│           └── userRegisterDate.feature
│
└── reports/                        # Reportes generados por Serenity
```

---

## 🧰 Tecnologías Utilizadas

| Tecnología | Descripción |
|-------------|--------------|
| **Java 17** | Lenguaje de programación base |
| **Serenity BDD** | Framework principal para la automatización |
| **Screenplay Pattern** | Modelo de diseño para tareas, preguntas y actores |
| **Cucumber** | Definición de escenarios en lenguaje Gherkin |
| **Gradle** | Gestor de dependencias |
| **JUnit 5** | Motor de ejecución de pruebas |

---

## ⚙️ Configuración del Entorno

### 🧩 Requisitos Previos
- Java 17 o superior  
- Gradle 7.5+  
- Navegador **Google Chrome** 
- ChromeDriver 

---

## 🚀 Ejecución de las Pruebas

Desde la raíz del proyecto, ejecutar:

```bash
gradlew clean test
```

Para generar el reporte de Serenity:

```bash
gradlew aggregate
```

El reporte estará disponible en:
```
target/site/serenity/index.html
```
O en proyectos recientes:
```
build/reports/serenity/index.html
```

---

## 🧪 Escenarios Implementados

 Escenario1
  Scenario: Mostrar calendario emergente al hacer clic en el campo de fecha
    Given que el usuario esta en la pagina del formulario
    When hace clic en el campo de fecha
    Then se debe mostrar el calendario emergente

  Escenario2
  Scenario: Seleccionar una fecha dentro del rango permitido
    Given que el calendario emergente esta Abierto
    When el usuario selecciona una fecha detro del rango permitido
    Then la fecha seleccionada se muestra en el campo con el formato esperado

  Escenario3
  Scenario: Navegar entre meses y años en el calendario
    Given que el calendario emergente que tiene en lista meses y años esta Abierto
    When el usuario navega al mes siguiente y anterior ademas de cambiar el año
    Then el calendario debe actualizarse y mostrar las fechas del nuevo mes año

  Escenario4
  Scenario: Impedir seleccion de fechas fuera del rango permitido
    Given que el calendario emergente con retriccion de rango esta Abierto
    When el usuario intenta seleccionar una fecha fuera del rango permitido
    Then la fecha no debe ser seleccionada


---

## 🧩 Principales Clases

| Clase | Descripción |
|-------|--------------|
| `HomeDateUI` | Mapeo del iframe principal y campo de fecha |
| `CalendarUI` | Elementos internos del calendario (mes, año, botones, etc.) |
| `SelectDateTask` | Acción de seleccionar una fecha válida |
| `SelectDataRestrictedTask` | Acción de intentar seleccionar fecha deshabilitada |
| `ValidateCalendar` | Verificación de que el calendario se muestre correctamente |
| `ValidateDateEmpty` | Question que valida si el campo está vacío |
| `RegisterDateStepDefinitions` | Step Definitions de los escenarios Gherkin |

---

## 🧾 Ejemplo de Ejecución

Durante la ejecución verás pasos como:

```
[INFO] Usuario abre el calendario Datepicker
[INFO] Usuario selecciona la fecha 25/10/2025
[INFO] Validando formato de fecha en el campo de entrada
✅ Resultado: Fecha mostrada correctamente en el input
⚠️ No se puede hacer clic en una fecha deshabilitada (correcto)
```

---

## 📊 Reporte Serenity

Los reportes incluyen:
- Evidencia paso a paso con capturas de pantalla.
- Estado de cada escenario.
- Tiempo de ejecución por tarea.
- Métricas de cobertura y estabilidad.

---

## 👨‍💻 Autor

**Brian Saldaña**  
*Analista Automatizacion*  

