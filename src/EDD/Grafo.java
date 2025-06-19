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
    /**
     * Matriz booleana que almacena las adyacencias entre los vértices.
     * Si matrizAdyacencia[i][j] es true, existe una arista entre el vértice i y el vértice j.
     */  
     
    private boolean[][] matrizAdyacencia;
    private int cantidadVertices;
    private char[][] tableroDeSopaLetras; 
    private int numFilasTablero;       
    private int numColumnasTablero;       
    
    
     private static final int[] despFilas = {-1, -1, -1, 0, 0, 1, 1, 1}; 
    private static final int[] despColumnas = {-1, 0, 1, -1, 1, -1, 0, 1}; 
    
    /**
     * Constructor para crear un nuevo Grafo basado en un tablero de sopa de letras.
     * Inicializa la matriz de adyacencia y construye las conexiones entre las celdas adyacentes.
     *
     * @param tablero La matriz de caracteres que representa el tablero de la sopa de letras.
     * @param filas El número de filas del tablero.
     * @param columnas El número de columnas del tablero.
     */

    public Grafo(char[][] tablero, int filas, int columnas) {
        this.numFilasTablero = filas;
        this.numColumnasTablero = columnas;
        this.cantidadVertices = filas * columnas; // El número total de vértices es el área del tablero
        this.matrizAdyacencia = new boolean[cantidadVertices][cantidadVertices];
        this.tableroDeSopaLetras = tablero;
        construirMatrizAdyacencia(); // Llama al método para establecer las conexiones
    }

   /**
     * Agrega una arista no dirigida entre dos vértices en la matriz de adyacencia.
     *
     * @param verticeOrigen El índice del primer vértice (0-based).
     * @param verticeDestino El índice del segundo vértice (0-based).
     */
    
    public void agregarArista(int verticeOrigen, int verticeDestino) {
        if (verticeOrigen >= 0 && verticeOrigen < cantidadVertices && verticeDestino >= 0 && verticeDestino < cantidadVertices) {
            matrizAdyacencia[verticeOrigen][verticeDestino] = true;
            matrizAdyacencia[verticeDestino][verticeOrigen] = true; 
        } else {
            System.err.println("Error: Vértices fuera de rango en agregarArista.");
        }
    }

    /**
     * Verifico si existe una arista entre dos vértices.
     * @param verticeOrigen El primer vértice.
     * @param verticeDestino El segundo vértice.
     * @return true si existe una arista entre verticeOrigen y verticeDestino, false en caso contrario.
     */
    public boolean existeArista(int verticeOrigen, int verticeDestino) {
        if (verticeOrigen >= 0 && verticeOrigen < cantidadVertices && verticeDestino >= 0 && verticeDestino < cantidadVertices) {
            return matrizAdyacencia[verticeOrigen][verticeDestino];
        }
        return false;
    }
    
     /**
     * Obtiene el número total de vértices en el grafo.
     *
     * @return El número de vértices.
     */
    public int getCantidadVertices() {
        return cantidadVertices;
    }

    
    /**
     * Obtiene el número de filas del tablero asociado a este grafo.
     *
     * @return El número de filas del tablero.
     */
    public int getNumFilasTablero() {
        return numFilasTablero;
    }
   
    
     /**
     * Obtiene el número de columnas del tablero asociado a este grafo.
     *
     * @return El número de columnas del tablero.
     */
    public int getNumColumnasTablero() {
        return numColumnasTablero;
    }

    /**
     * Obtiene la fila de adyacencia para un vértice dado.
     * Esto te daría una vista de qué vértices son directamente accesibles desde 'vertice'.
     * @param vertice El vértice del que se desean obtener los adyacentes.
     * @return Un arreglo booleano donde true indica una conexión.
     */
    public boolean[] getAdyacentes(int vertice) {
        if (vertice >= 0 && vertice < cantidadVertices) {
            return matrizAdyacencia[vertice]; 
        }
        return new boolean[cantidadVertices]; 
    }

      /**
     * Construye la matriz de adyacencia del grafo.
     * Cada celda del tablero se conecta con sus 8 vecinas (horizontal, vertical y diagonalmente),
     * siempre y cuando las celdas vecinas estén dentro de los límites del tablero.
     */
    private void construirMatrizAdyacencia() {
       
        int[] despFilas = {-1, -1, -1, 0, 0, 1, 1, 1}; 
        int[] despColumnas = {-1, 0, 1, -1, 1, -1, 0, 1}; 
        for (int fila = 0; fila < numFilasTablero; fila++) {
            for (int columna = 0; columna < numColumnasTablero; columna++) {
               
                int verticeActual = fila * numColumnasTablero + columna;

                for (int i = 0; i < 8; i++) { 
                    int filaVecino = fila + despFilas[i]; 
                    int columnaVecino = columna + despColumnas[i]; 
                    
                    if (filaVecino >= 0 && filaVecino < numFilasTablero &&
                        columnaVecino >= 0 && columnaVecino < numColumnasTablero) {
                        
                        int verticeVecino = filaVecino * numColumnasTablero + columnaVecino;

                       
                        agregarArista(verticeActual, verticeVecino);
                    }
                }
            }
        }
    }
    /**
     * Reconstruye la ruta a partir del último estado encontrado por DFS
     * y la guarda en un StringBuilder.
     *
     * @param ultimoEstado El EstadoDFS de la última letra de la palabra encontrada.
     * @param pathResult El StringBuilder donde se construirá la ruta.
     */
    private void reconstruirRuta(EstadoDFS ultimoEstado, StringBuilder pathResult) {
        if (ultimoEstado == null) {
            return;
        }

        // Usamos una Pila temporal para invertir el orden de los estados
        Pila tempPilaRuta = new Pila(cantidadVertices); // Maximo vertices para la ruta
        EstadoDFS current = ultimoEstado;
        while (current != null) {
            tempPilaRuta.push(current);
            current = current.anterior; // Ir hacia atrás usando el atributo 'anterior'
        }

        // Construir la cadena de la ruta
        while (!tempPilaRuta.estaVacia()) {
            EstadoDFS estado = (EstadoDFS) tempPilaRuta.pop();
            char caracter = tableroDeSopaLetras[estado.fila][estado.columna];
            pathResult.append("(").append(estado.fila).append(",").append(estado.columna).append(")[")
                      .append(caracter).append("]");
            if (!tempPilaRuta.estaVacia()) {
                pathResult.append(" -> ");
            }
        }
    }
    
    /**
     * Reconstruye la ruta a partir del último estado encontrado por BFS
     * y la guarda en un StringBuilder. Es similar a reconstruirRuta para DFS.
     *
     * @param ultimoEstado El EstadoBFS de la última letra de la palabra encontrada.
     * @param pathResult El StringBuilder donde se construirá la ruta.
     */
    private void reconstruirRutaBFS(EstadoBFS ultimoEstado, StringBuilder pathResult) {
        if (ultimoEstado == null) {
            return;
        }

        Pila tempPilaRuta = new Pila(cantidadVertices); // Usamos Pila para invertir el orden
        EstadoBFS current = ultimoEstado;
        while (current != null) {
            tempPilaRuta.push(current);
            current = current.anterior; // Ir hacia atrás usando el atributo 'anterior'
        }

        while (!tempPilaRuta.estaVacia()) {
            EstadoBFS estado = (EstadoBFS) tempPilaRuta.pop();
            char caracter = tableroDeSopaLetras[estado.getFila()][estado.getColumna()];
            pathResult.append("(").append(estado.getFila()).append(",").append(estado.getColumna()).append(")[")
                      .append(caracter).append("]");
            if (!tempPilaRuta.estaVacia()) {
                pathResult.append(" -> ");
            }
        }
    }
    
    /**
     * Implementa el algoritmo de búsqueda en profundidad (DFS) de forma iterativa
     * para encontrar si una palabra puede ser formada en el tablero.
     * La búsqueda comienza desde una celda específica del tablero.
     * Utiliza una Pila (Stack) para gestionar el orden de exploración de las celdas.
     *
     * @param palabraBuscada La palabra (cadena de caracteres) que se desea encontrar.
     * @param inicioFila La fila de la celda inicial desde donde se comienza la búsqueda.
     * @param inicioColumna La columna de la celda inicial desde donde se comienza la búsqueda.
     * @return true si la palabra es encontrada en el tablero a partir de la celda de inicio, false en caso contrario.
     * @see EDD.Pila
     * @see EDD.EstadoDFS
     */
   
    public boolean buscarPalabraEnCeldaDFS(String palabraBuscada, int inicioFila, int inicioColumna) {
        
        if (palabraBuscada == null || palabraBuscada.isEmpty()) {
            return false;
        }
        if (inicioFila < 0 || inicioFila >= numFilasTablero ||
            inicioColumna < 0 || inicioColumna >= numColumnasTablero ||
            Character.toUpperCase(tableroDeSopaLetras[inicioFila][inicioColumna]) != Character.toUpperCase(palabraBuscada.charAt(0))) {
            return false; 
        }

        Pila pila = new Pila(numFilasTablero * numColumnasTablero);
        boolean[][] celdasVisitadas = new boolean[numFilasTablero][numColumnasTablero];

        EstadoDFS estadoInicial = new EstadoDFS(inicioFila, inicioColumna, 0); 
        pila.push(estadoInicial);
        celdasVisitadas[inicioFila][inicioColumna] = true;

        while (!pila.estaVacia()) {
            EstadoDFS actual = (EstadoDFS) pila.pop();
       
            if (actual.indicePalabraBuscada == palabraBuscada.length() - 1) {
               
                if (Character.toUpperCase(tableroDeSopaLetras[actual.fila][actual.columna]) == Character.toUpperCase(palabraBuscada.charAt(actual.indicePalabraBuscada))) {
                    return true; 
                }
            }

         
            int siguienteIndice = actual.indicePalabraBuscada + 1;
           
            if (siguienteIndice >= palabraBuscada.length()) {
                continue;
            }
            
            char siguienteCaracterEsperado = Character.toUpperCase(palabraBuscada.charAt(siguienteIndice));

            
            for (int i = 0; i < 8; i++) {
                int nuevaFila = actual.fila + despFilas[i];     
                int nuevaColumna = actual.columna + despColumnas[i]; 

                if (nuevaFila >= 0 && nuevaFila < numFilasTablero &&
                    nuevaColumna >= 0 && nuevaColumna < numColumnasTablero &&
                    !celdasVisitadas[nuevaFila][nuevaColumna] &&
                    Character.toUpperCase(tableroDeSopaLetras[nuevaFila][nuevaColumna]) == siguienteCaracterEsperado) {

                   
                    EstadoDFS nuevoEstado = new EstadoDFS(nuevaFila, nuevaColumna, siguienteIndice);
                    pila.push(nuevoEstado); 
                    celdasVisitadas[nuevaFila][nuevaColumna] = true; 
                }
            }
        }
        return false; 
    }
    /**
     * Implementa el algoritmo de búsqueda en profundidad (DFS) de forma iterativa
     * para encontrar si una palabra puede ser formada en el tablero y, si es así,
     * reconstruir la ruta.
     * La búsqueda comienza desde una celda específica del tablero.
     * Utiliza una Pila (Stack) para gestionar el orden de exploración de las celdas.
     *
     * @param palabraBuscada La palabra (cadena de caracteres) que se desea encontrar.
     * @param inicioFila La fila de la celda inicial desde donde se comienza la búsqueda.
     * @param inicioColumna La columna de la celda inicial desde donde se comienza la búsqueda.
     * @param pathResult El StringBuilder donde se almacenará la ruta si la palabra es encontrada.
     * @return true si la palabra es encontrada en el tablero a partir de la celda de inicio, false en caso contrario.
     * @see EDD.Pila
     * @see EDD.EstadoDFS
     */
    public boolean buscarPalabraEnCeldaDFS(String palabraBuscada, int inicioFila, int inicioColumna, StringBuilder pathResult) {

        if (palabraBuscada == null || palabraBuscada.isEmpty()) {
            return false;
        }
        if (inicioFila < 0 || inicioFila >= numFilasTablero ||
            inicioColumna < 0 || inicioColumna >= numColumnasTablero ||
            Character.toUpperCase(tableroDeSopaLetras[inicioFila][inicioColumna]) != Character.toUpperCase(palabraBuscada.charAt(0))) {
            return false;
        }

        Pila pila = new Pila(numFilasTablero * numColumnasTablero);
        boolean[][] celdasVisitadas = new boolean[numFilasTablero][numColumnasTablero];

        EstadoDFS estadoInicial = new EstadoDFS(inicioFila, inicioColumna, 0);
        pila.push(estadoInicial);
        celdasVisitadas[inicioFila][inicioColumna] = true;

        EstadoDFS ultimoEstadoEncontrado = null; // Para guardar el último estado si se encuentra la palabra

        while (!pila.estaVacia()) {
            EstadoDFS actual = (EstadoDFS) pila.pop();

            // Si la letra actual no coincide con la esperada, retroceder (solo si no es el primer caracter)
            if (Character.toUpperCase(tableroDeSopaLetras[actual.fila][actual.columna]) != Character.toUpperCase(palabraBuscada.charAt(actual.indicePalabraBuscada))) {
                continue; // No debería suceder si las condiciones previas son correctas, pero como seguridad
            }

            // Si encontramos la última letra de la palabra
            if (actual.indicePalabraBuscada == palabraBuscada.length() - 1) {
                ultimoEstadoEncontrado = actual;
                reconstruirRuta(ultimoEstadoEncontrado, pathResult);
                return true;
            }

            int siguienteIndice = actual.indicePalabraBuscada + 1;

            // Si ya hemos encontrado todas las letras (esto es una condición de salida prematura)
            if (siguienteIndice >= palabraBuscada.length()) {
                continue;
            }

            char siguienteCaracterEsperado = Character.toUpperCase(palabraBuscada.charAt(siguienteIndice));


            for (int i = 0; i < 8; i++) {
                int nuevaFila = actual.fila + despFilas[i];
                int nuevaColumna = actual.columna + despColumnas[i];

                if (nuevaFila >= 0 && nuevaFila < numFilasTablero &&
                    nuevaColumna >= 0 && nuevaColumna < numColumnasTablero &&
                    !celdasVisitadas[nuevaFila][nuevaColumna] && // Solo visita si no ha sido visitada en ESTA RUTA
                    Character.toUpperCase(tableroDeSopaLetras[nuevaFila][nuevaColumna]) == siguienteCaracterEsperado) {

                    // Crear un nuevo estado, manteniendo la referencia al estado anterior
                    EstadoDFS nuevoEstado = new EstadoDFS(nuevaFila, nuevaColumna, siguienteIndice, actual);
                    pila.push(nuevoEstado);
                    // IMPORTANTE: Para DFS en sopa de letras, NO marcamos como visitado PERMANENTEMENTE aquí.
                    // Se marca como visitado para la RUTA ACTUAL en el estado, pero otras rutas pueden visitarla.
                    // La lógica del problema es que una celda no se puede reutilizar en la MISMA palabra.
                    // Sin embargo, para la iteración actual del DFS (buscando una palabra),
                    // si ya pasamos por una celda en el camino actual, no la volvemos a visitar.
                    // Si el problema permite reutilizar celdas en la misma palabra, se quitaría `!celdasVisitadas[...]`
                    // y el `celdasVisitadas[...] = true;` en el push.
                    // Pero dado el contexto de una "sopa de letras", lo más común es que una letra no se reutilice.
                    // Si se permite, la lógica de `celdasVisitadas` necesita ser más sofisticada
                    // (por ejemplo, pasarse en el EstadoDFS y resetearla al retroceder).
                    // Para este tipo de DFS iterativo, la matriz `celdasVisitadas` global
                    // es adecuada para evitar ciclos infinitos y revisitar caminos redundantes
                    // DENTRO DE UNA RAMA DE BÚSQUEDA.
                }
            }
        }
        return false;
    }

    /**
     * Implementa el algoritmo de búsqueda en amplitud (BFS) para encontrar si una palabra
     * puede ser formada en el tablero. La búsqueda comienza desde una celda específica del tablero.
     * Utiliza una Cola (Queue) para gestionar el orden de exploración de las celdas.
     *
     * @param palabraBuscada La palabra (cadena de caracteres) que se desea encontrar.
     * @param filaInicio La fila de la celda inicial desde donde se comienza la búsqueda.
     * @param columnaInicio La columna de la celda inicial desde donde se comienza la búsqueda.
     * @return true si la palabra es encontrada en el tablero a partir de la celda de inicio, false en caso contrario.
     * @see EDD.Cola
     * @see EDD.EstadoBFS
     */

    
    
    public boolean buscarPalabraEnCeldaBFS(String palabraBuscada, int filaInicio, int columnaInicio) {
        
        if (filaInicio < 0 || filaInicio >= this.numFilasTablero ||
            columnaInicio < 0 || columnaInicio >= this.numColumnasTablero ||
            Character.toUpperCase(this.tableroDeSopaLetras[filaInicio][columnaInicio]) != Character.toUpperCase(palabraBuscada.charAt(0))) {
            return false;
        }

       
        int capacidadCola = this.cantidadVertices * palabraBuscada.length();
        Cola cola = new Cola(capacidadCola > 0 ? capacidadCola : 16);

        boolean[][] celdasVisitadasEnBusqueda = new boolean[this.numFilasTablero][this.numColumnasTablero];

        // Encolar el estado inicial usando la nueva clase EstadoBFS
        EstadoBFS estadoInicial = new EstadoBFS(filaInicio, columnaInicio, 0);
        cola.encolar(estadoInicial);
        celdasVisitadasEnBusqueda[filaInicio][columnaInicio] = true; 

        
        while (!cola.estaVacia()) {
            EstadoBFS estadoActual = (EstadoBFS) cola.desencolar(); 
            int filaActual = estadoActual.getFila();
            int columnaActual = estadoActual.getColumna();
            int indiceLetraActual = estadoActual.getIndiceLetra();

           
            if (indiceLetraActual == palabraBuscada.length() - 1) {
                
                if (Character.toUpperCase(this.tableroDeSopaLetras[filaActual][columnaActual]) == Character.toUpperCase(palabraBuscada.charAt(indiceLetraActual))) {
                    return true; 
                }
            }
            
           
            if (indiceLetraActual + 1 >= palabraBuscada.length()) {
                 continue; 
            }


            
            int siguienteIndiceLetra = indiceLetraActual + 1;
            char letraSiguienteEsperada = Character.toUpperCase(palabraBuscada.charAt(siguienteIndiceLetra));

            
            int verticeActual = filaActual * numColumnasTablero + columnaActual;

           
            for (int verticeVecino = 0; verticeVecino < cantidadVertices; verticeVecino++) {
                if (existeArista(verticeActual, verticeVecino)) { 
                    int proximaFila = verticeVecino / numColumnasTablero;
                    int proximaColumna = verticeVecino % numColumnasTablero;

                
                    if (proximaFila >= 0 && proximaFila < this.numFilasTablero &&
                        proximaColumna >= 0 && proximaColumna < this.numColumnasTablero &&
                        !celdasVisitadasEnBusqueda[proximaFila][proximaColumna] &&
                        Character.toUpperCase(this.tableroDeSopaLetras[proximaFila][proximaColumna]) == letraSiguienteEsperada) {

                        
                        EstadoBFS siguienteEstado = new EstadoBFS(proximaFila, proximaColumna, siguienteIndiceLetra);
                        cola.encolar(siguienteEstado);
                        celdasVisitadasEnBusqueda[proximaFila][proximaColumna] = true; 
                    }
                }
            }
        }
        return false; 
    
    }
    
    /**
     * Método público para buscar una palabra específica en todo el tablero (usando DFS).
     * Itera sobre cada celda del tablero como punto de inicio.
     *
     * @param palabra La palabra a buscar.
     * @param pathResult StringBuilder donde se guardará la ruta si se encuentra la palabra.
     * @return true si la palabra fue encontrada, false en caso contrario.
     */
    public boolean buscarPalabraEspecifica(String palabra, StringBuilder pathResult) {
        if (palabra == null || palabra.isEmpty()) {
            return false;
        }

        // Normalizar la palabra a mayúsculas para la búsqueda consistente
        String palabraMayus = palabra.trim().toUpperCase();

        // Limpiar el StringBuilder de resultados antes de cada búsqueda
        pathResult.setLength(0);

        for (int r = 0; r < numFilasTablero; r++) {
            for (int c = 0; c < numColumnasTablero; c++) {
                // Si la primera letra de la palabra coincide con la celda actual
                if (Character.toUpperCase(tableroDeSopaLetras[r][c]) == palabraMayus.charAt(0)) {
                    // Llama al DFS interno que ahora maneja la ruta
                    if(buscarPalabraEnCeldaDFS(palabraMayus, r, c, pathResult)) {
                        return true; // Se encontró la palabra y la ruta ya está en pathResult
                    }
                }
            }
        }
        return false; // No se encontró la palabra en ninguna celda
    }
    /**
     * Imprime la matriz de adyacencia del grafo en la consola para depuración.
     * Muestra las conexiones entre todos los vértices.
     */
    

    public void imprimirMatrizAdyacencia() {
        System.out.println("DEBUG: Matriz de Adyacencia (" + cantidadVertices + "x" + cantidadVertices + "):");
        for (int i = 0; i < cantidadVertices; i++) {
            System.out.print(String.format("%2d: ", i)); 
            for (int j = 0; j < cantidadVertices; j++) {
                System.out.print(matrizAdyacencia[i][j] ? "1 " : "0 ");
            }
            System.out.println();
        }
    }
 }


