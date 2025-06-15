/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author Gloria
 */
public class Cola {
    private int[] elementos; // Array para almacenar los elementos de la cola
    private int frente;      // Índice del frente de la cola (primer elemento)
    private int fin;         // Índice del final de la cola (último elemento)
    private int tamano;      // Número actual de elementos en la cola
    private int capacidad;   // Capacidad máxima de la cola

    /**
     * Constructor para crear una nueva Cola con una capacidad específica.
     * @param capacidad La capacidad máxima de la cola.
     */
    public Cola(int capacidad) {
        this.capacidad = capacidad;
        this.elementos = new int[capacidad];
        this.frente = 0;
        this.fin = -1; // Usamos -1 para indicar que la cola está vacía inicialmente
        this.tamano = 0;
    }

    /**
     * Agrega un elemento al final de la cola.
     * @param elemento El elemento a agregar.
     * @throws IllegalStateException Si la cola está llena.
     */
    public void encolar(int elemento) {
        if (estaLlena()) {
            throw new IllegalStateException("La cola está llena");
        }
        fin = (fin + 1) % capacidad; // Mueve el índice del final de forma circular
        elementos[fin] = elemento;
        tamano++;
    }

    /**
     * Elimina y devuelve el elemento del frente de la cola.
     * @return El elemento del frente de la cola.
     * @throws IllegalStateException Si la cola está vacía.
     */
    public int desencolar() {
        if (estaVacia()) {
            throw new IllegalStateException("La cola está vacía");
        }
        int elemento = elementos[frente];
        frente = (frente + 1) % capacidad; // Mueve el índice del frente de forma circular
        tamano--;
        return elemento;
    }

    /**
     * Devuelve (sin eliminar) el elemento del frente de la cola.
     * @return El elemento del frente de la cola.
     * @throws IllegalStateException Si la cola está vacía.
     */
    public int peek() {
        if (estaVacia()) {
            throw new IllegalStateException("La cola está vacía");
        }
        return elementos[frente];
    }

    /**
     * Verifica si la cola está vacía.
     * @return true si la cola está vacía, false en caso contrario.
     */
    public boolean estaVacia() {
        return tamano == 0;
    }

    /**
     * Verifica si la cola está llena.
     * @return true si la cola está llena, false en caso contrario.
     */
    public boolean estaLlena() {
        return tamano == capacidad;
    }

    /**
     * Devuelve el número actual de elementos en la cola.
     * @return El tamaño actual de la cola.
     */
    public int tamano() {
        return tamano;
    }
}
