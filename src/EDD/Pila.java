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
    private Object[] elementos;
    private int tope;
    private int capacidad;

    public Pila(int capacidad) {
        this.capacidad = capacidad;
        this.elementos = new Object[capacidad];
        this.tope = -1; 
    }

    public void push(Object elemento) { 
        if (estaLlena()) {
            System.err.println("Error: La pila está llena. No se puede hacer push.");
            return;
        }
        tope++;
        elementos[tope] = elemento;
    }

    public Object pop() { 
        if (estaVacia()) {
            System.err.println("Error: La pila está vacía. No se puede hacer pop.");
            return null;
        }
        Object elemento = elementos[tope];
        elementos[tope] = null; // Liberar referencia
        tope--;
        return elemento;
    }

    public Object peek() { 
        if (estaVacia()) {
            return null;
        }
        return elementos[tope];
    }

    public boolean estaVacia() {
        return tope == -1;
    }

    public boolean estaLlena() {
        return tope == capacidad - 1;
    }

    public int getTamano() {
        return tope + 1;
    }
}
