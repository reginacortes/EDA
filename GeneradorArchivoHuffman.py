import random
import string


class GeneradorArchivoTextoHuffman:

    def __init__(self, carpeta_destino):
        self.carpeta_destino = carpeta_destino


    def generar_archivo_huffman(self, nombre="random.txt", simbolos = 6, longitud_texto=40, frec_min=1, frec_max=20):
        #generamos simbolos aleatorios
        simbolos = random.sample(string.ascii_letters + string.digits, simbolos)
        
        ##generamos frecuencias
        frec = [random.randint(frec_min, frec_max) for _ in range(len(simbolos))]

        #generamos el texto
        texto = "".join(random.choices(simbolos, k=longitud_texto))

        ruta_completa = f"{self.carpeta_destino}/{nombre}"

        #escribimos el archivo
        with open(ruta_completa, "w") as archivo:
            archivo.write(" ".join(simbolos) + "\n")
            archivo.write(" ".join(str(f) for f in frec) + "\n")
            archivo.write(texto + "\n")

        print(f"Archivo generado: {ruta_completa}")

# Ejemplo de uso

generador = GeneradorArchivoTextoHuffman(carpeta_destino="/Users/reginacortes/NetBeansProjects/EDA/")
generador.generar_archivo_huffman(nombre="archivo_huffman.txt", simbolos=8, longitud_texto=40, frec_min=1, frec_max=15)
