<!--
Este documento está hecho para que el estudiante pueda indicar lo que considere
oportuno. Usa el formato [Markdown](https://www.markdownguide.org/cheat-sheet/)
-->
# Recuperación de ágiles

## UT3. Modificaciones realizadas

# Recuperación de Ágiles - Unidad Temática 3

Este repositorio contiene la resolución de la recuperación de la asignatura **Arquitecturas y Modelos para el Desarrollo Web Ágil**. Se ha tomado un proyecto base de una calculadora y se ha transformado siguiendo estándares profesionales de ingeniería de software.

## UT3. Desarrollo de Aplicaciones Modulares

En esta unidad se ha realizado una refactorización profunda del código original para cumplir con los criterios de **división, modularidad y desacoplamiento**.

### 1. Implementación del Patrón de Diseño MVC
Se ha migrado la lógica de un único archivo de clase (`Main.java`) a una arquitectura **Modelo-Vista-Controlador (MVC)**.


* **Modelo (`modeloCalculadora.java`)**: Contiene exclusivamente la lógica de negocio y el estado de la aplicación (datos). Es independiente de la interfaz gráfica, lo que permite realizar pruebas unitarias más fáciles.
* **Vista (`vistaCalculadora.java`)**: Se encarga únicamente de la representación visual y la disposición de los componentes de Swing. No conoce la lógica de los cálculos.
* **Controlador (`contraoladorCalculadora.java`)**: Actúa como intermediario. Gestiona los eventos de usuario (clics en botones) y coordina la actualización del Modelo y la Vista.

### 2. Organización por Paquetes
Para mejorar la modularidad, se ha abandonado el "paquete por defecto" y se ha organizado el código en una estructura jerárquica:
* `com.recuperacion.modelo`
* `com.recuperacion.vista`
* `com.recuperacion.controlador`

**Motivo:** Esto evita colisiones de nombres, mejora la visibilidad de los componentes y facilita la escalabilidad del software.

### 3. Buenas Prácticas y Desacoplamiento
* **Encapsulamiento**: Se han definido atributos privados en el modelo, accediendo a ellos mediante *getters* y *setters*.
* **Single Responsibility Principle (SRP)**: Cada clase tiene ahora una única razón para cambiar. Por ejemplo, si queremos cambiar el diseño de la calculadora, solo editamos la Vista; si queremos añadir una operación matemática, solo editamos el Modelo.
* **Gestión de Hilos (EDT)**: Se ha implementado `SwingUtilities.invokeLater` en el punto de entrada para garantizar que la interfaz se ejecute de forma segura en el hilo de despacho de eventos de Java.

### 4. DevOps y Automatización
Se ha preparado el proyecto para ser gestionado con **Apache Maven** (opcional según el entorno) y se ha estructurado para facilitar la integración de linters como **CheckStyle**, asegurando que el código cumple con los estándares de formato de Java.

Se ha migrado el proyecto a **Apache Maven**.
- **Estandarización**: Se ha adoptado la estructura de carpetas `src/main/java`, lo que facilita la portabilidad del proyecto.
- **Automatización (DevOps)**: Se ha configurado el `pom.xml` con el plugin de **CheckStyle**. Esto permite automatizar la revisión de la calidad del código y asegurar que se siguen las convenciones de nombrado y formato de Java de manera consistente.

## Instrucciones de Ejecución
Para lanzar la aplicación, ejecuta la clase `CalculatorController` situada en el paquete `com.recuperacion.controller`, la cual contiene el método `main` que orquesta el arranque de todos los módulos.

## UT4. Ejecución de herramientas

<!-- Indica aquí cómo has ejecutado las herramientas y cuál ha sido la salida,
ejemplo: -->

### Testing

<!-- Puedes borrar este ejemplo, todo el apartado -->

#### Prerrequisitos

Se debe tener NodeJS instalado y haber descargado e instalado las dependencias,
que se hace mediante el siguiente comando, suponiendo que se encuentra en la
carpeta raíz del repositorio:

```
npm i
```

#### Ejecución

Para ejecutar los tests, usa el siguiente comando:

```
npm run test
```

#### Salida

La ejecución debe dar el siguiente resultado:

```
> test
> jest

FAIL ./sum.test.js
  ✕ adds 1 + 2 to equal 3 (4 ms)

  ● adds 1 + 2 to equal 3

    expect(received).toBe(expected) // Object.is equality

    Expected: 3
    Received: 4

      2 |
      3 | test('adds 1 + 2 to equal 3', () => {
    > 4 |   expect(sum(1, 2)).toBe(3);
        |                     ^
      5 | });
      6 |

      at Object.toBe (sum.test.js:4:21)

Test Suites: 1 failed, 1 total
Tests:       1 failed, 1 total
Snapshots:   0 total
Time:        0.378 s
Ran all test suites.
Error: Process completed with exit code 1.
```
