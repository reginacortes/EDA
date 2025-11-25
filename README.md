# Programación Dinámica

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

La versión recursiva:

Versión con Memoización: 
Esta versión evita recalcular las mismas combinaciones de subcadenas una y otra vez, lo cual reduce el tiempo de ejecución drásticamente, utiliza una tabla de tamaño (m+1)(n+1) en la cual se almacenan los datos del calculo de una sola vez de distancia.

Versión con Programación Dinámica:
Ésta versión llena la tabla paso a paso, sin recursión, por lo tanto es más rápida y eficiente para entradas grandes. El orden de cálculo está predefinido (de abajo hacia arriba). Utiliza una matriz d[i][j] que representa el número mínimo de operaciones necesarias para transformar los primeros i caracteres de Sn en los primeros j caracteres de Sn+1. En el método se va considerando el costo de insertar y reemplazar cada caracter. La complejidad seria Tiempo: O(m x n). También se mide el tiempo en el que se tarda en ejecutar el método dependiendo de la longitud del archivo de texto con el que se trabaja.


### Resultados

Gráfica - Método Recursivo
<img width="600" height="371" alt="Distancia entre Cadenas and Tiempo de ejecución" src="https://github.com/user-attachments/assets/1835142d-6f48-4721-9d0a-e0053ac4a841" />
Como podemos observar en ésta gráfica, unicamente contamos con los datos de la diferencia entre cadenas de longitud 5, aquellas cadenas con longitud mayor e igual a 50, en el método recursivo, hacen que el algoritmo tenga que resolver demasiadas operaciones por lo que el programa se tarda en terminar. Éste comportamiento confirma que la recursión si funciona pero es complicado ejecutarla en textos grandes y para resolver esto se necesita implementar memoización o programación dinámica. 

Gráfica - Método Iterativo

<img width="600" height="371" alt="Versión Iterativa_ Distancia de Edición  and Tiempo" src="https://github.com/user-attachments/assets/8f4c852c-8a17-408e-866c-0a97d8016393" />



# Algoritmos Codiciosos

## Práctica 5: Algoritmos Codiciosos
Equipo: Regina Cortes, Mely Delado, Layla Bonilla

### Problema

Se te encarga desarrollar un algoritmo para comprimir textos alfanumericos de hasta 5000 caracteres para guardarlos en un campo de una base de datos y recuperarlos en forma simple y
eficiente. Te acuerdas que el algoritmo de Huffman genera un codigo que es muy eficiente y decides implementarlo para este proposito. Entrada: un archivo con los sımbolos a codificar y su frecuencia.

Buscaremos implementar los siguientes algoritmos:
- Algoritmo codicioso para producir el codigo de Huffman
- Algoritmo para codificar el texto de entrada
- Algoritmo para decodificar un texto codificado

Algoritmo de Huffman

El algoritmo de Huffman provee un método que permite comprimir información mediante la recodifi cación de los bytes que la componen. En particular, si los bytes que se van a
comprimir están almacenados en un archivo, al recodifi carlos con secuencias de bits más cortas diremos que lo comprimimos. La técnica consiste en asignar a cada byte del archivo que vamos a comprimir un código binario compuesto por una cantidad de bits tan corta como sea posible. Esta cantidad será variable y dependerá de la probabilidad de ocurrencia del byte. Los códigos binarios que utilizaremos para reemplazar a cada byte del archivo original se llaman “códigos Huffman”. 

Para obtener estas combinaciones de bits únicas, el algoritmo de Huffman propone seguir una serie de pasos a través de los cuales obtendremos un árbol binario llamado “arbol Huffman”. Luego, las hojas del árbol representarán a los diferentes caracteres que aparecen en el archivo y los caminos que se deben recorrer para llegar a esas hojas representarán la nueva codificación del carácter. 

El algoritmo codicioso para producir el código de Huffman consiste en construir un árbol binario de forma iterativa, combinando los dos nodos (o árboles) de menor frecuencia hasta que solo quede uno. En cada paso, se unen los dos nodos con las frecuencias más bajas, se les asigna un 0 y un 1 en sus ramas y se reemplazan por un nuevo nodo padre cuya frecuencia es la suma de las frecuencias de los dos nodos unidos.


### Metodología

Primero debemos contar la cantidad de ocurrencias de cada caracter, en este caso, la segunda linea de entrada nos indica las veces que se repite cada caracter en la primera linea, por lo tanto, haremos uso de una tabla para indicar la correspondencia a cada caracter. Conociendo la cantidad de ocurrencias de cada carácter, tenemos que crear una lista enlazada y ordenada ascendentemente por dicha cantidad. Primero los caracteres menos frecuentes y luego los que tienen mayor probabilidad de aparecer y, si dos caracteres ocurren igual cantidad de veces, entonces colocaremos primero al que tenga menor valor numérico.

Vamos a generar el árbol Huffman tomando “de a pares” los nodos de la lista. Esto lo haremos de la siguiente manera: sacamos los dos primeros nodos y los utilizamos para
crear un pequeño árbol binario cuya raíz será un nuevo nodo que identificaremos con un carácter ficticio *1 y una cantidad de ocurrencias igual a la
suma de las cantidades de los dos nodos que estamos procesando. En la rama derecha colocamos al nodo menos ocurrente (el primero); el otro nodo lo colocaremos en la rama
izquierda. Luego insertamos en la lista al nuevo nodo (raíz) respetando el criterio de ordenamiento que mencionamos más arriba. Si en la lista existe un nodo con la misma cantidad de ocurrencias (que en este caso es 2), la inserción la haremos a continuación de este. 

Luego continuamos con este proceso hasta que la lista se haya convertido en un árbol binario cuyo nodo raíz tenga una cantidad de ocurrencias igual al tamaño del archivo que
queremos comprimir.

El siguiente paso será asignar un código Huffman a cada uno de los caracteres reales que se encuentran ubicados en las hojas del árbol. Para esto, consideraremos el camino
que se debe recorrer para llegar a cada hoja. El código se forma concatenando un 0 por cada tramo que avanzamos hacia la izquierda y un 1 cada vez que avanzamos hacia la derecha.

NodoHuffman

Representa un nodo dentro del árbol de Huffman. Puede ser un nodo hoja o un nodo interno. Almacena un símbolo y su frecuencia. Guarda referencias a los nodos izquierdo y derecho. Permite saber si es hoja.


DatosHuffman

Es una clase contenedora que almacena la información leída del archivo. Guarda el arreglo de símbolos, la lista de frecuencias asociadas y el texto que se va a codificar.

LectorArchivosHuffman
 Lee el archivo de entrada.

ArbolHuffman

Construye el árbol de Huffman y genera el diccionario de códigos. Crea la cola de prioridad con cada símbolo y su frecuencia, combina nodos hasta formar el árbol binario de Huffman y recorre el árbol y asigna los códigos binarios a cada símbolo (usando 0 para izquierda y 1 para derecha).

CodificadorHuffman

Convierte el texto original en una cadena de bits usando los códigos generados. Recibe el texto original, reemplaza cada carácter con su código correspondiente y
devuelve el texto codificado como un string de 0s y 1s.

DecodificadorHuffman

Reconstruye el texto original a partir del texto binario codificado. Recorre el árbol de Huffman siguiendo los bits del mensaje, cada que llega a un nodo hoja, recupera el símbolo original, y reconstruye el texto exactamente como era antes.

MainHuffman

Es el programa principal que ejecuta todo el proceso.


### Resultados

Los resultados se pueden obtener mediante las clases "GeneradosArchivosHuffman.py" que te arroja un archivo de texto en el orden en el que el proyecto lo pide, el cual se puede leer por medio de la clase "Huffman.py". 
