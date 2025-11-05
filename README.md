# EDA

## Práctica 4: Programación Dinámica

### Problema

En un curso de bachillerato el profesor esta preocupado de que en algunas tareas los estudiantes
han entregado documentos sorprendentemente similares. El profesor tiene la curiosidad de cuantificar la similitud entre estos documentos, pero dado que son ensayos que pueden tener de 5,000 a 10,000 palabras lo que puede hacerlos que tengan hasta 50,000 caracteres cada uno. En este proyecto vas a escribir un programa que calcule la distancia de edicion entre los textos considerando que el costo de insertar un car ́acter es de 1 y el costo de reemplazar un caracter x por y es 2. 

Entrada: los nombres de los dos archivos A y B con los documentos a comparar.

Los archivos estan en formato de texto plano UTF-8. Cada archivo tiene una longitud maxima de Len(A) = Len(B) = 50, 000 caracteres (alrededor de 10,000 palabras o 10 p ́aginas de texto)

Salida: 
  - Una lınea de texto que indique el numero de caracteres del documento A y del documento B
  - La distancia de edicion entre los documentos D(A, B) y D(B, A)
  - El tiempo utilizado para el c ́alculo de la distancia de edicion
  - Si el tiempo para resolver el problema excede 10 segundos, muestre el mensaje ”tiempo lımite para resolver el problema excedido”


Implemente tres versiones de este programa:
Una version recursiva sin memoizacion
Una version recursiva con memoizacion
Una version iterativa con programacion dinamica

Se presentan graficas de desempeño de las tres versiones para las siguientes longitudes maximas de los textos: [5, 50, 500, 5000, 50000]


