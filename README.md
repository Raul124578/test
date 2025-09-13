Proyecto 1 – Reconocedor de Tokens y Lexemas

Este proyecto implementa un analizador léxico para un lenguaje de programación asignado, utilizando JFlex como herramienta principal.

El sistema reconoce y clasifica tokens como:
- Palabras reservadas (if, while, for, etc.)
- Identificadores y variables
- Llaves { }
- Paréntesis ( )
- Errores léxicos (cadenas no reconocidas por el lenguaje)
Al finalizar, el programa genera un archivo de salida con el resumen de clasificación de tokens y, en caso de errores, reporta la línea y columna donde fueron encontrados.

Tecnologías utilizadas

Lenguaje de programación

- Java SE 17 (compatible con cualquier versión >= 8).
- Entorno de desarrollo: Visual Studio Code con la extensión Extension Pack for Java.

Librerías/Frameworks
- Swing (javax.swing): para la interfaz gráfica (ventana, botones, área de texto).
- AWT (java.awt): para gestión de paneles, layouts y eventos.
- Clases estándar de Java (⁠ java.io ⁠, ⁠ java.util ⁠, ⁠ java.lang ⁠): manejo de archivos, colecciones y cadenas.
No se usaron librerías externas, únicamente librerías estándar de Java.

Estructura de Carpetas

ProyectoTokens

- Main.java #Clase principal que inicia la aplicación
- VentanaPrincipal.java #Interfaz gráfica (botones, área de texto, eventos)
- AnalizadorLexico.java #Procesa el archivo, clasifica tokens y genera resultados
- Clasificador.java #Reglas para identificar tokens (reservadas, identificadores, etc.)
- Contadores.java #Manejo de conteos y generación de resúmenes
- test/ #Archivos de prueba (entrada1.txt, entrada2.txt, etc.)
- Salida.txt #Archivo generado con el resultado de la clasificación

Instrucciones de instalación y uso
1. *Clonar o descargar* el repositorio en tu computadora.
2. Abrir la carpeta en *Visual Studio Code*.
3. Instalar la extensión *Extension Pack for Java* (si no la tienes).
4. Ejecutar el archivo Main.java (clic derecho → Run Java).
5. En la ventana:
----Presionar *“Cargar archivo”* y seleccionar un archivo de entrada (.txt con un token por línea).
   - El resultado aparecerá en el área de texto.
   - Puedes guardar el resultado en Salida.txt con el botón *“Guardar Salida”*.
   - Salir con el botón *“Salir”*.

Capturas de pantalla del programa en funcionamiento

- *Ventana inicial:*
  ![Interfaz gráfica](https://github.com/user-attachments/assets/0bf02964-ecff-4433-9eb9-8465c540f6ac)

- *Archivo cargado
  ![Seleccionar archivo existente](https://github.com/user-attachments/assets/bbedc6a2-02c0-4679-9bb7-e9ebe5626e6a)

- tokens clasificados:*
  ![Archivo de salida](https://github.com/user-attachments/assets/c0e01632-6eb6-4d6a-985f-eff2db9d2961)
  
- *Resumen de conteos:*
  ![Aplicación en funcionamiento](https://github.com/user-attachments/assets/00f85f5f-b0e9-4fbd-9c28-174f5fb591d7)

