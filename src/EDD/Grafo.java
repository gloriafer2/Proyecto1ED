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
    private int numVertices;               // Número total de vértices en el grafo
    
    /**
     * Constructor para crear un nuevo Grafo con un número específico de vértices.
     * @param numVertices El número de vértices en el grafo.
     */
    public Grafo(int numVertices) {
        this.numVertices = numVertices;
        this.matrizAdyacencia = new boolean[numVertices][numVertices];
    }

    /**
     * Agrega una arista entre dos vértices. Dado que es un grafo no dirigido,
     * la arista se añade en ambas direcciones.
     * @param u El primer vértice.
     * @param v El segundo vértice.
     */
    public void agregarArista(int u, int v) {
       
        if (u >= 0 && u < numVertices && v >= 0 && v < numVertices) {
            matrizAdyacencia[u][v] = true;
            matrizAdyacencia[v][u] = true; 
        } else {
            System.err.println("Error: Vértices fuera de rango.");
        }
    }

    /**
    
     * @param u El primer vértice.
     * @param v El segundo vértice.
     * @return true si existe una arista entre u y v, false en caso contrario.
     */
    public boolean existeArista(int u, int v) {
        if (u >= 0 && u < numVertices && v >= 0 && v < numVertices) {
            return matrizAdyacencia[u][v];
        }
        return false;
    }

    /**
     * Obtiene el número total de vértices en el grafo.
     * @return El número de vértices.
     */
    public int getNumVertices() {
        return numVertices;
    }

    public boolean[] getAdyacentes(int u) {
        if (u >= 0 && u < numVertices) {
            return matrizAdyacencia[u]; // Retorna la fila completa de la matriz
        }
        return new boolean[numVertices]; // Retorna un arreglo vacío si el vértice es inválido
    }
    
    /**
     * Implementa el algoritmo de búsqueda DFS o backtracking
     * para encontrar una secuencia de letras que formen una palabra en el tablero.
     * Se mueve recursivamente a celdas adyacentes hasta encontrar la palabra completa.
     *
     * @param palabra La palabra (en mayúsculas) que se está buscando.
     * @param currentRow Fila actual en la que se encuentra la búsqueda.
     * @param currentCol Columna actual en la que se encuentra la búsqueda.
     * @param visited Matriz booleana para marcar las celdas ya visitadas en la ruta actual de la palabra.
     * Esto evita ciclos y el uso repetido de la misma letra para la misma palabra.
     * @param charIndex El índice de la letra actual que se busca en la 'palabra' (ej. 0 para la primera letra).
     * @return true si la 'palabra' se encuentra a partir de la celda (currentRow, currentCol), false en caso contrario.
     */
    public boolean buscarPalabraEnCelda(String palabra, int currentRow, int currentCol, boolean[][] visited, int charIndex, Grafo grafo, String[] diccionario, char[][] tablero) {
    if (charIndex == palabra.length()) {
        return true;
    }

    if (currentRow < 0 || currentRow >= 4 || currentCol < 0 || currentCol >= 4 ||
        visited[currentRow][currentCol] || Character.toUpperCase(tablero[currentRow][currentCol]) != palabra.charAt(charIndex)) {
        return false;
    }

   
    visited[currentRow][currentCol] = true;

    int currentVertex = currentRow * 4 + currentCol;

    for (int neighborVertex = 0; neighborVertex < 16; neighborVertex++) {
        if (grafo.existeArista(currentVertex, neighborVertex)) {
            int nextRow = neighborVertex / 4;
            int nextCol = neighborVertex % 4;

   
            if (this.buscarPalabraEnCelda(palabra, nextRow, nextCol, visited, charIndex + 1, grafo, diccionario, tablero)) {
                return true;
            }
        }
    }

    
    visited[currentRow][currentCol] = false; 

    
    return false; 
    }
   }