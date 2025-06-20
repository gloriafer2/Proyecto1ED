/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author Gloria
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Clase que gestiona la carga, almacenamiento y búsqueda de palabras en un diccionario.
 * Implementación personalizada sin usar las colecciones de java.util.
 * Utiliza un arreglo dinámico (String[]) para almacenar las palabras y gestiona
 * su capacidad de forma manual.
 *
 * @author Gloria
 */
public class Diccionario {

    private String[] palabras;        // Arreglo para almacenar las palabras.
    private int tamanoActual;         // Número de palabras actualmente en el diccionario.
    private static final int CAPACIDAD_INICIAL = 1000; // Capacidad inicial del arreglo, se duplica si es necesario.

    /**
     * Constructor que inicializa el diccionario con una capacidad inicial.
     */
    public Diccionario() {
        this.palabras = new String[CAPACIDAD_INICIAL];
        this.tamanoActual = 0;
    }

    /**
     * Redimensiona el arreglo de palabras cuando está lleno.
     * Duplica la capacidad actual del arreglo.
     */
    private void redimensionar() {
        int nuevaCapacidad = palabras.length * 2;
        String[] nuevosElementos = new String[nuevaCapacidad];
        // Copiar los elementos existentes al nuevo arreglo
        for (int i = 0; i < tamanoActual; i++) {
            nuevosElementos[i] = palabras[i];
        }
        this.palabras = nuevosElementos; // Reemplazar el arreglo viejo por el nuevo
        System.out.println("Diccionario redimensionado a " + nuevaCapacidad + " palabras.");
    }

    /**
     * Carga palabras en el diccionario desde un archivo de texto.
     * Cada línea del archivo se considera una palabra.
     * Las palabras se procesan para ser consistentes (trim y mayúsculas) antes de ser agregadas.
     * Nota: Este método borra el contenido anterior del diccionario antes de cargar.
     *
     * @param rutaArchivo La ruta completa al archivo de texto del diccionario.
     * @throws IOException Si ocurre un error al leer el archivo.
     */
    public void cargarDiccionario(String rutaArchivo) throws IOException {
        this.palabras = new String[CAPACIDAD_INICIAL];
        this.tamanoActual = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String palabraLimpia = linea.trim().toUpperCase(); 
                if (!palabraLimpia.isEmpty()) {
                    agregarPalabra(palabraLimpia); 
                }
            }
        }
        System.out.println("Diccionario cargado con " + tamanoActual + " palabras.");
    }

    /**
     * Agrega una palabra al diccionario.
     * Si la palabra ya existe (después de ser limpiada y convertida a mayúsculas),
     * no se agrega nuevamente. Maneja el redimensionamiento del arreglo si es necesario.
     *
     * @param palabra La palabra a agregar.
     */
    public void agregarPalabra(String palabra) {
        if (palabra == null || palabra.isEmpty()) {
            return; // No agregar palabras nulas o vacías
        }
        String palabraMayus = palabra.trim().toUpperCase();

        
        for (int i = 0; i < tamanoActual; i++) {
            if (palabras[i].equals(palabraMayus)) {
                return; 
            }
        }

       
        if (tamanoActual == palabras.length) {
            redimensionar();
        }

        
        palabras[tamanoActual] = palabraMayus;
        tamanoActual++;
    }

    /**
     * Verifica si una palabra existe en el diccionario.
     * La palabra a buscar se limpia y se convierte a mayúsculas para la comparación.
     * Realiza una búsqueda lineal.
     *
     * @param palabra La palabra a buscar.
     * @return true si la palabra está en el diccionario, false en caso contrario.
     */
    public boolean existePalabra(String palabra) {
        if (palabra == null || palabra.isEmpty()) {
            return false; 
        }
        String palabraMayus = palabra.trim().toUpperCase();
        
        for (int i = 0; i < tamanoActual; i++) {
            if (palabras[i].equals(palabraMayus)) {
                return true; // Palabra encontrada
            }
        }
        return false; 
    }

    /**
     * Obtiene el número de palabras actualmente cargadas en el diccionario.
     *
     * @return El tamaño actual del diccionario.
     */
    public int getTamano() {
        return tamanoActual;
    }

    /**
     * Obtiene la palabra en una posición específica del diccionario.
     * Este método es útil para iterar sobre las palabras del diccionario
     * cuando no se pueden usar iteradores de java.util.
     *
     * @param index El índice de la palabra a obtener.
     * @return La palabra en la posición especificada, o null si el índice está fuera de rango.
     */
    public String getPalabra(int index) {
        if (index >= 0 && index < tamanoActual) {
            return palabras[index];
        }
        return null; // Índice fuera de los límites válidos
    }

    /**
     * Para propósitos de depuración o visualización:
     * Imprime todas las palabras contenidas en el diccionario a la consola.
     */
    public void imprimirPalabras() {
        System.out.println("Palabras en el diccionario (Total: " + tamanoActual + "):");
        for (int i = 0; i < tamanoActual; i++) {
            System.out.println("- " + palabras[i]);
        }
    }
}