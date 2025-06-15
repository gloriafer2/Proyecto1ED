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
        // Asegúrate de que los vértices estén dentro de los límites
        if (u >= 0 && u < numVertices && v >= 0 && v < numVertices) {
            matrizAdyacencia[u][v] = true;
            matrizAdyacencia[v][u] = true; // Para grafo no dirigido
        } else {
            System.err.println("Error: Vértices fuera de rango."); // Puedes manejar esto con una excepción
        }
    }

    /**
     * Verifica si existe una arista entre dos vértices.
     * @param u El primer vértice.
     * @param v El segundo vértice.
     * @return true si existe una arista entre u y v, false en caso contrario.
     */
    public boolean existeArista(int u, int v) {
        if (u >= 0 && u < numVertices && v >= 0 && v < numVertices) {
            return matrizAdyacencia[u][v];
        }
        return false; // Si los vértices están fuera de rango, no hay arista
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
}