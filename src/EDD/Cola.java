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

   
    public int desencolar() {
        if (estaVacia()) {
            throw new IllegalStateException("La cola está vacía");
        }
        int elemento = elementos[frente];
        frente = (frente + 1) % capacidad; // Mueve el índice del frente de forma circular
        tamano--;
        return elemento;
    }

    public int peek() {
        if (estaVacia()) {
            throw new IllegalStateException("La cola está vacía");
        }
        return elementos[frente];
    }

    
    public boolean estaVacia() {
        return tamano == 0;
    }

    
    public boolean estaLlena() {
        return tamano == capacidad;
    }

    
    public int tamano() {
        return tamano;
    }
}
