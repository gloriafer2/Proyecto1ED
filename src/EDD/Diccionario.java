/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author Gloria
 */

    
/**
 * Esta clase guarda una lista de palabras, como un diccionario.
 * NO usa ninguna de las herramientas pre-hechas de Java (como ArrayList).
 * Solo usa un arreglo simple (String[]) para guardar las palabras.
 */
public class Diccionario {
    private String[] palabras; 
    private int cantidadPalabras; 
    private static final int capacidad_inicial = 100; 

    /**
     * Cuando creamos un Diccionario, le damos espacio para empezar.
     */
    public Diccionario() {
        this.palabras = new String[capacidad_inicial];
        this.cantidadPalabras = 0; 
    }

    /**
     * Agrega una palabra nueva a nuestro diccionario.
     * Antes de guardarla, la pone en MAYÚSCULAS y le quita espacios extras.
     * Si ya tenemos esa palabra, no hace nada.
     * Si se nos acaba el espacio, hace el arreglo más grande.
     * @param palabra La palabra que queremos guardar.
     */
    public void agregarPalabra(String palabra) {
       
        if (palabra == null || palabra.trim().isEmpty()) {
            return;
        }

        String palabraMayusculas = palabra.trim().toUpperCase(); 
        
        if (existePalabra(palabraMayusculas)) {
            
            return;
        }

       
        if (cantidadPalabras == palabras.length) {
            hacerArregloMasGrande(); 
        }

       
        palabras[cantidadPalabras] = palabraMayusculas;
        cantidadPalabras++; 
    }

    /**
     * Nos dice si una palabra está en nuestro diccionario.
     * También revisa la palabra en MAYÚSCULAS.
     * @param palabra La palabra que queremos buscar.
     * @return 'true' si la palabra está, 'false' si no está.
     */
    public boolean existePalabra(String palabra) {
       
        if (palabra == null || palabra.trim().isEmpty()) {
            return false;
        }

        String palabraMayusculas = palabra.trim().toUpperCase(); 

       
        for (int i = 0; i < cantidadPalabras; i++) {
            if (palabras[i].equals(palabraMayusculas)) {
                return true; 
            }
        }
        return false; 
    }

    /**
     * Nos dice cuántas palabras hay en total en nuestro diccionario.
     * @return El número de palabras guardadas.
     */
    public int getCantidadPalabras() {
        return cantidadPalabras;
    }

    /**
     * Este es un ayudante interno: hace el arreglo de palabras el doble de grande
     * cuando se llena.
     */
    private void hacerArregloMasGrande() {
        int nuevaCapacidad = palabras.length * 2; 
        String[] nuevoArreglo = new String[nuevaCapacidad];

       
        for (int i = 0; i < cantidadPalabras; i++) {
            nuevoArreglo[i] = palabras[i];
        }

        palabras = nuevoArreglo; 
    }

    /**
     * Para ver todas las palabras en el diccionario 
     * @return Un texto con todas las palabras, cada una en una línea.
     */
    @Override
    public String toString() {
        if (cantidadPalabras == 0) {
            return "El diccionario está vacío.";
        }
        StringBuilder textoCompleto = new StringBuilder();
        for (int i = 0; i < cantidadPalabras; i++) {
            textoCompleto.append(palabras[i]);
            if (i < cantidadPalabras - 1) {
                textoCompleto.append("\n"); 
            }
        }
        return textoCompleto.toString();
    }
}
