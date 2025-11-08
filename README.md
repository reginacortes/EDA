# EDA

## Práctica 4: Programación Dinámica
Equipo: Regina Cortes, Mely Delado, Layla Bonilla


### Problema

En un curso de bachillerato el profesor esta preocupado de que en algunas tareas los estudiantes
han entregado documentos sorprendentemente similares. El profesor tiene la curiosidad de cuantificar la similitud entre estos documentos, pero dado que son ensayos que pueden tener de 5,000 a 10,000 palabras lo que puede hacerlos que tengan hasta 50,000 caracteres cada uno. En este proyecto vas a escribir un programa que calcule la distancia de edicion entre los textos considerando que el costo de insertar un caracter es de 1 y el costo de reemplazar un caracter x por y es 2. 

Entrada: los nombres de los dos archivos A y B con los documentos a comparar.

Los archivos estan en formato de texto plano UTF-8. Cada archivo tiene una longitud maxima de Len(A) = Len(B) = 50, 000 caracteres (alrededor de 10,000 palabras o 10 p ́aginas de texto)

Salida: 
  - Una lınea de texto que indique el numero de caracteres del documento A y del documento B
  - La distancia de edicion entre los documentos D(A, B) y D(B, A)
  - El tiempo utilizado para el calculo de la distancia de edicion
  - Si el tiempo para resolver el problema excede 10 segundos, muestre el mensaje ”tiempo lımite para resolver el problema excedido”


Implemente tres versiones de este programa:
Una version recursiva sin memoizacion
Una version recursiva con memoizacion
Una version iterativa con programacion dinamica

Se presentan graficas de desempeño de las tres versiones para las siguientes longitudes maximas de los textos: [5, 50, 500, 5000, 50000]


### Metodología

Se creo un método que genera de forma aleatoria dos archivos diferentes de cada una de las siguientes longitudes de texto: [5, 50, 500, 5000, 50000] para que sean comparados en los siguientes metodos. Se agregan saltos de línea de vez en cuando para que parezca un archivo de texto real. Estos archivos pueden ser descargados directamente de la clase y son los mismos que se pueden utilizar para implementar los metodos siguientes.

La versión iterativa:
Utiliza una matriz d[i][j] que representa el número mínimo de operaciones necesarias para transformar los primeros i caracteres de Sn en los primeros j caracteres de Sn+1. En el método se va considerando el costo de insertar y reemplazar cada caracter. 
La complejidad seria Tiempo: O(m x n). También se mide el tiempo en el que se tarda en ejecutar el método dependiendo de la longitud del archivo de texto con el que se trabaja.

Versión con Memoización: 
Esta versión evita recalcular las mismas combinaciones de subcadenas una y otra vez, lo cual reduce el tiempo de ejecución drásticamente, utiliza una tabla de tamaño (m+1)(n+1) en la cual se almacenan los datos del calculo de una sola vez de distancia.

Versión con Programación Dinámica:
Ésta versión llena la tabla paso a paso, sin recursión, por lo tanto es más rápida y eficiente para entradas grandes. El orden de cálculo está predefinido (de abajo hacia arriba). 

### Resultados

Gráfica - Método Iterativo

<img width="600" height="371" alt="Versión Iterativa_ Distancia de Edición  and Tiempo" src="https://github.com/user-attachments/assets/8f4c852c-8a17-408e-866c-0a97d8016393" />
