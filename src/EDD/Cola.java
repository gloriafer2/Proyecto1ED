/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author Gloria
 */

public class Cola <T> {
    private T[] elementos;
    private int frente;
    private int finalCola; 
    private int tamano;    
    private int capacidad;

    public Cola(int capacidad) {
        this.capacidad = capacidad;
        this.elementos = (T[]) new Object[capacidad];
        this.frente = 0;
        this.finalCola = -1;
        this.tamano = 0;
    }

    
    public void encolar(T elemento) {
    if (estaLlena()) {
        throw new IllegalStateException("La cola está llena. No se puede encolar el elemento.");
    }
    finalCola = (finalCola + 1) % capacidad;
    elementos[finalCola] = elemento;
    tamano++;
}

    
   public T desencolar() {
    if (estaVacia()) {
        throw new IllegalStateException("La cola está vacía. No se puede desencolar.");
    }
    T elemento = elementos[frente];
    elementos[frente] = null;
    frente = (frente + 1) % capacidad;
    tamano--;
    return elemento;
}

    public boolean estaVacia() {
        return tamano == 0;
    }

    public boolean estaLlena() {
        return tamano == capacidad;
    }

    
    public int getTamano() {
        return tamano;
    }

    
}