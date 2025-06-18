package EDD;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Gloria
 */
  public class Grafo {
    private boolean[][] matrizAdyacencia;
    private int cantidadVertices;
    private char[][] tableroDeSopaLetras; 
    private int numFilasTablero;       
    private int numColumnasTablero;       

    

    public Grafo(char[][] tablero, int filas, int columnas) {
        this.numFilasTablero = filas;
        this.numColumnasTablero = columnas;
        this.cantidadVertices = filas * columnas; // El número total de vértices es el área del tablero
        this.matrizAdyacencia = new boolean[cantidadVertices][cantidadVertices];
        this.tableroDeSopaLetras = tablero;
        construirMatrizAdyacencia(); // Llama al método para establecer las conexiones
    }

   
    
    public void agregarArista(int verticeOrigen, int verticeDestino) {
        if (verticeOrigen >= 0 && verticeOrigen < cantidadVertices && verticeDestino >= 0 && verticeDestino < cantidadVertices) {
            matrizAdyacencia[verticeOrigen][verticeDestino] = true;
            matrizAdyacencia[verticeDestino][verticeOrigen] = true; // Para grafo no dirigido
        } else {
            System.err.println("Error: Vértices fuera de rango en agregarArista.");
        }
    }

    /**
     * Verifica si existe una arista entre dos vértices.
     * @param verticeOrigen El primer vértice.
     * @param verticeDestino El segundo vértice.
     * @return true si existe una arista entre verticeOrigen y verticeDestino, false en caso contrario.
     */
    public boolean existeArista(int verticeOrigen, int verticeDestino) {
        if (verticeOrigen >= 0 && verticeOrigen < cantidadVertices && verticeDestino >= 0 && verticeDestino < cantidadVertices) {
            return matrizAdyacencia[verticeOrigen][verticeDestino];
        }
        return false;
    }

    public int getCantidadVertices() {
        return cantidadVertices;
    }

 
    public int getNumFilasTablero() {
        return numFilasTablero;
    }

    public int getNumColumnasTablero() {
        return numColumnasTablero;
    }

    /**
     * Obtiene la fila de adyacencia para un vértice dado.
     * Esto te daría una vista de qué vértices son directamente accesibles desde 'vertice'.
     * @param vertice El vértice del que se desean obtener los adyacentes.
     * @return Un arreglo booleano donde true indica una conexión.
     */
    public boolean[] getAdyacentes(int vertice) {
        if (vertice >= 0 && vertice < cantidadVertices) {
            return matrizAdyacencia[vertice]; // Retorna la fila completa de la matriz
        }
        return new boolean[cantidadVertices]; // Retorna un arreglo vacío si el vértice es inválido
    }

    
    private void construirMatrizAdyacencia() {
       
        int[] despFilas = {-1, -1, -1, 0, 0, 1, 1, 1}; // Cambios en fila
        int[] despColumnas = {-1, 0, 1, -1, 1, -1, 0, 1}; // Cambios en columna

        for (int fila = 0; fila < numFilasTablero; fila++) {
            for (int columna = 0; columna < numColumnasTablero; columna++) {
               
                int verticeActual = fila * numColumnasTablero + columna;

                for (int i = 0; i < 8; i++) { 
                    int filaVecino = fila + despFilas[i]; 
                    int columnaVecino = columna + despColumnas[i]; 
                    
                    if (filaVecino >= 0 && filaVecino < numFilasTablero &&
                        columnaVecino >= 0 && columnaVecino < numColumnasTablero) {
                        
                        int verticeVecino = filaVecino * numColumnasTablero + columnaVecino;

                       
                        agregarArista(verticeActual, verticeVecino);
                    }
                }
            }
        }
    }

   
    public boolean buscarPalabraEnCelda(String palabraBuscada, int filaActual, int columnaActual, boolean[][] celdasVisitadas, int indiceLetra) {
        // Caso base 1: La palabra completa ha sido encontrada (se ha llegado al final de la palabra)
        if (indiceLetra == palabraBuscada.length()) {
            return true;
        }

        if (filaActual < 0 || filaActual >= numFilasTablero ||
            columnaActual < 0 || columnaActual >= numColumnasTablero ||
            celdasVisitadas[filaActual][columnaActual] ||
            Character.toUpperCase(this.tableroDeSopaLetras[filaActual][columnaActual]) != palabraBuscada.charAt(indiceLetra)) {
            return false;
        }

        
        celdasVisitadas[filaActual][columnaActual] = true;

        
        int verticeActual = filaActual * numColumnasTablero + columnaActual;

        
        for (int verticeVecino = 0; verticeVecino < cantidadVertices; verticeVecino++) {
           
            if (existeArista(verticeActual, verticeVecino)) {
                
                int proximaFila = verticeVecino / numColumnasTablero;
                int proximaColumna = verticeVecino % numColumnasTablero;

               
                if (buscarPalabraEnCelda(palabraBuscada, proximaFila, proximaColumna, celdasVisitadas, indiceLetra + 1)) {
                   
                    return true;
                }
            }
        }

       
        celdasVisitadas[filaActual][columnaActual] = false;

     
        return false;
    }

 
    public void imprimirMatrizAdyacencia() {
        System.out.println("DEBUG: Matriz de Adyacencia (" + cantidadVertices + "x" + cantidadVertices + "):");
        for (int i = 0; i < cantidadVertices; i++) {
            System.out.print(String.format("%2d: ", i)); // Formato para alinear números de dos dígitos
            for (int j = 0; j < cantidadVertices; j++) {
                System.out.print(matrizAdyacencia[i][j] ? "1 " : "0 ");
            }
            System.out.println();
        }
    }
 }




