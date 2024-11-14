# Proyecto `eu.andreatt.ejercicioq_dein` (NO FUNCIONA)

## Descripción
Esta aplicación JavaFX implementa un temporizador visualizado en una interfaz gráfica usando `Temporizador.java` para la lógica y `Q.fxml` para el diseño de la interfaz.

## Estructura de Archivos
- `Temporizador.java`: Clase que maneja la lógica de conteo regresivo del temporizador.
- `fxml/Q.fxml`: Archivo FXML que define la estructura visual donde se muestra el temporizador.
- `module-info.java`: Configuración de módulos para habilitar JavaFX.
- `README.md`: Instrucciones de compilación y ejecución.

## Requisitos
- Java 11 o superior
- JavaFX configurado en el `module-path`

## Configuración y Ejecución

### Compilación
1. Configura el `module-path` para JavaFX.
2. Compila el proyecto ejecutando:
   ```sh
   javac --module-path /path/to/javafx/lib --add-modules javafx.controls,javafx.fxml -d out src/eu/andreatt/ejercicioq_dein/**/*.java
