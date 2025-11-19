import heapq

class Nodo:
    def __init__(self, caracter, frec):
        self.caracter = caracter
        self.frec = frec
        self.izq = None
        self.der = None

    def leer_arch(self, nombre_archivo):
        frec = {}
        with open(nombre_archivo, 'ruta') as archivo:
            simbolos = archivo.readline().strip().split(' ')
            frec = list(map(int, archivo.readline().strip().split(' ')))
            texto = archivo.readline().strip()
        return simbolos, frec, texto

    #creamos una tabla

    def crear_tabla(simbolos, frec):
        tabla = []
        for s, f in zip(simbolos, frec):
            tabla.append(Nodo(s,f))

        tabla.sort(key=lambda x: x[1], reverse = True)
        
        return tabla
    
    def arbol_huffman(tabla):
        heap = []

        for simbolo, freq in tabla:
            heapq.heappush(heap, (freq, Nodo(simbolo, freq)))

        while len(heap) > 1:
            f1, nodo1 = heapq.heappop(heap)
            f2, nodo2 = heapq.heappop(heap)
            nuevo = Nodo(None, f1 + f2)
            nuevo.izq = nodo1
            nuevo.der = nodo2
            heapq.heappush(heap, (nuevo.frecuencia, nuevo))

        return heapq.heappop(heap)[1]
    
    def generar_codigos(nodo, prefijo="", codigos=None):
        if codigos is None:
            codigos = {}

        if nodo.simbolo is not None:   # hoja
            codigos[nodo.simbolo] = prefijo
            return codigos

        generar_codigos(nodo.izq, prefijo + "0", codigos)
        generar_codigos(nodo.der, prefijo + "1", codigos)

        return codigos


           