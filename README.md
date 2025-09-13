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
ProyectoTokens/
├── Main.java #Clase principal que inicia la aplicación
├── VentanaPrincipal.java #Interfaz gráfica (botones, área de texto, eventos)
├── AnalizadorLexico.java #Procesa el archivo, clasifica tokens y genera resultados
├── Clasificador.java #Reglas para identificar tokens (reservadas, identificadores, etc.)
├── Contadores.java #Manejo de conteos y generación de resúmenes
├── test/ #Archivos de prueba (entrada1.txt, entrada2.txt, etc.)
└── Salida.txt #Archivo generado con el resultado de la clasificación

