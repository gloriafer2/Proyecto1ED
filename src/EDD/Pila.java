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
     
     * @param elemento El elemento a agregar.
     * @throws IllegalStateException Si la pila está llena.
     */
    public void apilar(int elemento) {
        if (estaLlena()) {
            throw new IllegalStateException("La pila está llena");
        }
        elementos[++tope] = elemento; // Incrementa tope y luego asigna
    }

    
     
    public int desapilar() {
        if (estaVacia()) {
            throw new IllegalStateException("La pila está vacía");
        }
        return elementos[tope--]; // Devuelve el elemento y luego decrementa tope
    }

   
    public int peek() {
        if (estaVacia()) {
            throw new IllegalStateException("La pila está vacía");
        }
        return elementos[tope];
    }

    
    public boolean estaVacia() {
        return tope == -1;
    }

    
    public boolean estaLlena() {
        return tope == capacidad - 1;
    }

   
    public int tamano() {
        return tope + 1;
    }
}
