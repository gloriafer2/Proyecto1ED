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
    private boolean[][] matrizAdyacencia; // True si hay arista entre i y j
    private int numVertices;               // Número total de vértices en el grafo

    /**
     * Constructor para crear un nuevo Grafo con un número específico de vértices.
     * @param numVertices El número de vértices en el grafo.
     */
    public Grafo(int numVertices) {
        this.numVertices = numVertices;
        // Inicializa la matriz con todos los valores en false (sin conexiones)
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

    /**
     * Retorna un arreglo de booleanos indicando qué vértices son adyacentes a un vértice dado.
     * true en el índice 'i' significa que 'i' es adyacente.
     * @param u El vértice del que se quieren obtener los adyacentes.
     * @return Un arreglo de booleanos.
     */
    public boolean[] getAdyacentes(int u) {
        if (u >= 0 && u < numVertices) {
            return matrizAdyacencia[u]; // Retorna la fila completa de la matriz
        }
        return new boolean[numVertices]; // Retorna un arreglo vacío si el vértice es inválido
    }
    
    /**
     * Implementa el algoritmo de búsqueda DFS (Depth First Search) o backtracking
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
        // Caso base 1: Si charIndex es igual a la longitud de la palabra, significa que todas las letras
        // de la palabra han sido encontradas en secuencia válida.
        if (charIndex == palabra.length()) {
            return true;
        }

        // Caso base 2: Condiciones para detener la búsqueda en la ruta actual:
        // 1. Si las coordenadas (currentRow, currentCol) están fuera de los límites del tablero (4x4).
        // 2. Si la celda actual ya ha sido visitada en esta ruta de búsqueda (evita usar la misma letra dos veces).
        // 3. Si la letra en la celda actual del tablero no coincide con la letra esperada de la palabra.
        //    (Se convierte a mayúsculas para asegurar una comparación sin distinción entre mayúsculas y minúsculas).
        if (currentRow < 0 || currentRow >= 4 || currentCol < 0 || currentCol >= 4 ||
            visited[currentRow][currentCol] || Character.toUpperCase(tablero[currentRow][currentCol]) != palabra.charAt(charIndex)) {
            return false;
        }

        // Marcar la celda actual como visitada para la ruta de búsqueda actual.
        visited[currentRow][currentCol] = true;

        // Convierte las coordenadas (fila, columna) de la celda actual a un índice de vértice del grafo (0-15).
        int currentVertex = currentRow * 4 + currentCol;

        // Itera sobre todos los posibles vértices (de 0 a 15) para encontrar sus adyacencias en el grafo.
        // Esto cubre todas las 8 direcciones posibles (horizontal, vertical, diagonal) si el grafo
        // fue construido para representarlas.
        for (int neighborVertex = 0; neighborVertex < 16; neighborVertex++) {
            // Verifica si el 'neighborVertex' es adyacente al 'currentVertex' en el grafo.
            // USANDO EL MÉTODO EXISTENTE EN TU CLASE GRAFO: grafo.existeArista()
            if (grafo.existeArista(currentVertex, neighborVertex)) {
                // Convierte el índice del vértice vecino de nuevo a coordenadas de fila y columna.
                int nextRow = neighborVertex / 4;
                int nextCol = neighborVertex % 4;

                // Realiza una llamada recursiva para buscar la siguiente letra de la palabra
                // en la celda del vecino. Se incrementa el charIndex para buscar la siguiente letra.
                if (this.buscarPalabraEnCelda(palabra, nextRow, nextCol, visited, charIndex + 1, grafo, diccionario, tablero)) {
                    return true; // Si la llamada recursiva encuentra el resto de la palabra, retorna true.
                }
            }
        }
        System.out.println("DEBUG (BuscarPalabra-Constructor): Grafo recibido es null? " + (grafo == null));
        System.out.println("DEBUG (BuscarPalabra-Constructor): Diccionario recibido es null? " + (diccionario == null));
        System.out.println("DEBUG (BuscarPalabra-Constructor): Tablero recibido es null? " + (tablero == null));
        if (diccionario != null && diccionario.length > 0) {
            System.out.println("DEBUG (BuscarPalabra-Constructor): Cantidad de palabras en diccionario: " + diccionario.length);
            System.out.println("DEBUG (BuscarPalabra-Constructor): Primer palabra del diccionario: " + diccionario[0]);
        }
        if (tablero != null && tablero.length == 4 && tablero[0].length == 4) {
            System.out.println("DEBUG (BuscarPalabra-Constructor): Letra en (0,0): " + tablero[0][0]);
            // Puedes imprimir el tablero completo si quieres verificar:
            System.out.println("DEBUG (BuscarPalabra-Constructor): Contenido del tablero:");
            for (int r = 0; r < 4; r++) {
                for (int c = 0; c < 4; c++) {
                    System.out.print(tablero[r][c] + " ");
                }
                System.out.println();
            }

            // Backtrack: Si la búsqueda a través de todas las celdas adyacentes no encontró la palabra,
            // desmarca la celda actual como visitada. Esto es fundamental para que otras rutas de búsqueda
            // (que quizás comiencen en una celda diferente) puedan usar esta celda.
            visited[currentRow][currentCol] = false;
            return false; // La palabra no se encontró a partir de esta celda y esta ruta.

        }
        return false;
        
    }
}