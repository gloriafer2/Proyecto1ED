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
    private int finalCola; // Cambiado de 'fin' a 'finalCola'
    private int tamano;    // Cambiado de 'tamanoActual' a 'tamano'
    private int capacidad;

    public Cola(int capacidad) {
        this.capacidad = capacidad;
        this.elementos = (T[]) new Object[capacidad];
        this.frente = 0;
        this.finalCola = -1;
        this.tamano = 0;
    }

    // Método encolar: Cambiar 'Object elemento' a 'T elemento'
    public void encolar(T elemento) { // <--- CAMBIO AQUÍ
        if (estaLlena()) {
            System.err.println("Error: La cola está llena. No se puede encolar el elemento.");
            return;
        }
        finalCola = (finalCola + 1) % capacidad;
        elementos[finalCola] = elemento;
        tamano++;
    }

    // Método desencolar: Cambiar 'Object desencolar()' a 'T desencolar()'
    public T desencolar() { // <--- CAMBIO AQUÍ
        if (estaVacia()) {
            System.err.println("Error: La cola está vacía. No se puede desencolar.");
            return null; // O lanzar una excepción si prefieres
        }
        T elemento = elementos[frente]; // <--- CAMBIO AQUÍ
        elementos[frente] = null; // Liberar referencia
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

    // Método getTamano: Coincide con 'getTamanoActual()' de discusiones previas, pero el nombre 'getTamano()' es el que usas
    public int getTamano() {
        return tamano;
    }

    // Si también tenías un método 'verFrente()', su firma sería:
    // public T verFrente() {
    //     if (estaVacia()) {
    //         return null;
    //     }
    //     return elementos[frente];
    // }
}