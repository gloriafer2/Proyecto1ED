/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author Gloria
 */
public class Pila {
    private int[] elementos; // Array para almacenar los elementos de la pila
    private int tope;        // Índice del elemento superior de la pila
    private int capacidad;   // Capacidad máxima de la pila

    /**
     * Constructor para crear una nueva Pila con una capacidad específica.
     * @param capacidad La capacidad máxima de la pila.
     */
    public Pila(int capacidad) {
        this.capacidad = capacidad;
        this.elementos = new int[capacidad];
        this.tope = -1; // Usamos -1 para indicar que la pila está vacía inicialmente
    }

    /**
     * Agrega un elemento a la cima de la pila.
     * @param elemento El elemento a agregar.
     * @throws IllegalStateException Si la pila está llena.
     */
    public void apilar(int elemento) {
        if (estaLlena()) {
            throw new IllegalStateException("La pila está llena");
        }
        elementos[++tope] = elemento; // Incrementa tope y luego asigna
    }

    /**
     * Elimina y devuelve el elemento de la cima de la pila.
     * @return El elemento de la cima de la pila.
     * @throws IllegalStateException Si la pila está vacía.
     */
    public int desapilar() {
        if (estaVacia()) {
            throw new IllegalStateException("La pila está vacía");
        }
        return elementos[tope--]; // Devuelve el elemento y luego decrementa tope
    }

    /**
     * Devuelve (sin eliminar) el elemento de la cima de la pila.
     * @return El elemento de la cima de la pila.
     * @throws IllegalStateException Si la pila está vacía.
     */
    public int peek() {
        if (estaVacia()) {
            throw new IllegalStateException("La pila está vacía");
        }
        return elementos[tope];
    }

    /**
     * Verifica si la pila está vacía.
     * @return true si la pila está vacía, false en caso contrario.
     */
    public boolean estaVacia() {
        return tope == -1;
    }

    /**
     * Verifica si la pila está llena.
     * @return true si la pila está llena, false en caso contrario.
     */
    public boolean estaLlena() {
        return tope == capacidad - 1;
    }

    /**
     * Devuelve el número actual de elementos en la pila.
     * @return El tamaño actual de la pila.
     */
    public int tamano() {
        return tope + 1;
    }
}
