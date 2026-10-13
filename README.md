# Gestor de Incidencias

## Descripción

Aplicación desarrollada en Java para gestionar y consultar incidencias de soporte técnico de un centro.

Permite visualizar todas las incidencias registradas, consultar las que permanecen abiertas, buscar incidencias por identificador o título y consultar los detalles de una incidencia concreta.

La aplicación puede utilizarse mediante un menú interactivo por consola o mediante argumentos de línea de comandos.

## Funcionalidades

- **Listar incidencias:** muestra todas las incidencias registradas.
- **Listar incidencias abiertas:** muestra únicamente las incidencias que permanecen abiertas.
- **Buscar incidencias:** permite buscar por identificador o título.
- **Consultar detalles:** muestra la información de una incidencia a partir de su identificador.
- **Mostrar ayuda:** presenta los comandos disponibles.
- **Control de errores:** utiliza una excepción personalizada cuando no se encuentra una incidencia.

## Tecnologías utilizadas

- Java.
- API de colecciones de Java (`List`).
- API de Streams para filtrar y buscar incidencias.
- `Scanner` para la entrada de datos por consola.
- Javadoc para la documentación del código.

## Estructura del proyecto

```text
src/
└── es/
    └── centro/
        └── incidencias/
            ├── App.java
            ├── GestorIncidencias.java
            ├── Incidencia.java
            └── IncidenciaNoEncontradaException.java
```

### Descripción de las clases

| Clase | Descripción |
|---|---|
| `App` | Punto de entrada de la aplicación. Gestiona el menú y los comandos. |
| `GestorIncidencias` | Inicializa, lista, filtra y busca incidencias. |
| `Incidencia` | Representa una incidencia con su identificador, título, prioridad y estado. |
| `IncidenciaNoEncontradaException` | Excepción personalizada para indicar que una incidencia no existe. |

## Requisitos

- Tener instalado el JDK de Java.
- Utilizar un entorno de desarrollo compatible con Java o una terminal.
- Disponer de los archivos fuente del proyecto.

Se recomienda Java 17 o superior, ya que el código utiliza expresiones `switch` modernas y el método `Stream.toList()`.

## Instalación y ejecución

### 1. Compilar el proyecto

Desde la raíz del proyecto, ejecuta:

```bash
javac -d out src/es/centro/incidencias/*.java
```

Este comando compila los archivos Java y guarda las clases generadas en el directorio `out`.

### 2. Iniciar el menú interactivo

Ejecuta la aplicación sin argumentos:

```bash
java -cp out es.centro.incidencias.App
```

Aparecerá un menú con las siguientes opciones:

```text
GESTOR DE INCIDENCIAS
Aplicación de consulta de avisos de soporte del centro.

----------------------------------------
1. Mostrar todas las incidencias
2. Mostrar las incidencias abiertas
3. Buscar incidencias
4. Consultar una incidencia por su ID
0. Salir
----------------------------------------
```

Introduce el número de la opción deseada y sigue las instrucciones de la consola.

## Uso mediante comandos

También puedes ejecutar la aplicación directamente indicando una operación.

### Mostrar la ayuda

```bash
java -cp out es.centro.incidencias.App ayuda
```

### Listar todas las incidencias

```bash
java -cp out es.centro.incidencias.App listar
```

### Listar las incidencias abiertas

```bash
java -cp out es.centro.incidencias.App abiertas
```

### Buscar incidencias

```bash
java -cp out es.centro.incidencias.App buscar impresora
```

La búsqueda permite introducir varias palabras:

```bash
java -cp out es.centro.incidencias.App buscar fallo de red
```

Se buscan coincidencias en el identificador y en el título de las incidencias, sin distinguir entre mayúsculas y minúsculas.

### Consultar una incidencia por su identificador

```bash
java -cp out es.centro.incidencias.App detalle INC-001
```

Si el identificador no existe, se muestra un mensaje indicando que no se ha encontrado la incidencia.

## Datos de ejemplo

La aplicación incluye cuatro incidencias precargadas:

| ID | Título | Prioridad | Estado |
|---|---|---|---|
| `INC-001` | No se puede iniciar sesión | Alta | Abierta |
| `INC-002` | Actualizar el navegador | Media | Cerrada |
| `INC-003` | Impresora sin conexión | Baja | Abierta |
| `INC-004` | Fallo de red en el aula | Alta | Abierta |

Los datos se inicializan en el constructor de `GestorIncidencias`. En la versión actual, no se guardan en una base de datos ni en archivos externos.

## Gestión de excepciones

La clase `IncidenciaNoEncontradaException` representa el caso en el que se intenta consultar una incidencia que no existe.

El método `buscarPorId()` lanza esta excepción cuando no encuentra el identificador solicitado. La aplicación captura la excepción y muestra el mensaje correspondiente por consola.

## Documentación Javadoc

El código fuente incluye comentarios Javadoc para describir las clases, sus atributos, constructores y métodos.

Para generar la documentación HTML, ejecuta desde la raíz del proyecto:

```bash
javadoc -d docs -sourcepath src -subpackages es.centro.incidencias
```

La documentación generada se encontrará en el directorio `docs`. Para consultarla, abre el archivo `docs/index.html` en un navegador.

## Limitaciones actuales

- Las incidencias están precargadas en el código.
- No se pueden crear, modificar ni eliminar incidencias desde el menú.
- Los datos no se conservan entre ejecuciones.
- No se utiliza una base de datos.

## Autor

Proyecto desarrollado como ejercicio de programación en Java.

**Versión:** 1.0
