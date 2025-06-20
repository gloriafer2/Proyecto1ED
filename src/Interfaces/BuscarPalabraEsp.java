/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;
import EDD.Grafo;
import Interfaces.Cargar;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField; 


/**
 * La clase `BuscarPalabraEsp` representa una ventana de la interfaz gráfica de usuario (GUI)
 * que permite al usuario buscar una palabra específica dentro del tablero de la sopa de letras
 * y, opcionalmente, agregarla al diccionario si se encuentra y no existe.
 *
 * Esta ventana interactúa con una instancia de `Grafo` (que representa el tablero)
 * y una instancia de `Cargar` (para acceder y modificar el diccionario persistente).
 *
 * @author Gloria
 */


public class BuscarPalabraEsp extends javax.swing.JFrame {
    public static Grafo grafo;
    public static char[][] tablero; 
    public static Cargar ventanaCargarOriginal;
    public String[] diccionario;
    
    
    /**
     * Constructor de la clase `BuscarPalabraEsp`.
     * Inicializa los componentes de la GUI y establece las referencias
     * a los objetos de datos compartidos (grafo, tablero, ventana de carga).
     *
     * @param g La instancia del `Grafo` que contiene la lógica de búsqueda en el tablero.
     * @param dict El arreglo de Strings que representa el diccionario (aunque no se usa directamente aquí,
     * se pasa para consistencia, y se accede a través de `ventanaCargarOriginal`).
     * @param tab La matriz de caracteres que representa el tablero.
     * @param v1 La instancia de la ventana `Cargar` desde la cual se invocó esta ventana.
     */

    public BuscarPalabraEsp(Grafo g, String[] dict, char[][] tab, Cargar v1) {
    initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        BuscarPalabraEsp.grafo = g;
        BuscarPalabraEsp.tablero = tab;
        BuscarPalabraEsp.ventanaCargarOriginal = v1;   
        this.diccionario = dict;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        campoPalabra = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaResultados = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabelTiempo = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        jLabel1.setText("Buscar palabra específica");

        jLabel2.setText("Palabra a buscar:");

        campoPalabra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoPalabraActionPerformed(evt);
            }
        });

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        textAreaResultados.setEditable(false);
        textAreaResultados.setColumns(20);
        textAreaResultados.setRows(5);
        jScrollPane1.setViewportView(textAreaResultados);

        jLabel3.setText("Resultados");

        jLabelTiempo.setText("Tiempo:");

        jButton2.setText("Regresar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(70, 70, 70)
                                .addComponent(campoPalabra, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(97, 97, 97)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jButton2)
                                .addGap(100, 100, 100)
                                .addComponent(jLabelTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 35, Short.MAX_VALUE)))
                .addContainerGap(95, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(12, 12, 12))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(campoPalabra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(118, 118, 118))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelTiempo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    /**
     * Maneja el evento de acción del botón "Regresar".
     * Oculta la ventana actual (`BuscarPalabraEsp`) y muestra la ventana del `Menu` principal,
     * pasando la referencia a la ventana `Cargar` original para mantener los datos cargados.
     * Finalmente, libera los recursos de esta ventana.
     * * @param evt El evento de acción generado por el botón.
     */
    private void botonRegresarActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        Menu menuNuevo = new Menu(this.ventanaCargarOriginal); 
        menuNuevo.setVisible(true);
        this.dispose();
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        textAreaResultados.setText("Buscando palabra...\n"); 
        jLabelTiempo.setText("Tiempo de búsqueda: ");
      
        if (BuscarPalabraEsp.grafo == null) {
            String mensajeError = "ERROR: El grafo no ha sido inicializado. Por favor, carga un tablero primero.";
            System.err.println(mensajeError);
            textAreaResultados.setText(mensajeError);
            return;
        }

        
        String palabraBuscada = campoPalabra.getText().trim().toUpperCase();

        if (palabraBuscada.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese una palabra para buscar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            textAreaResultados.setText("No se ingresó ninguna palabra.");
            return;
        }

        
        if (palabraBuscada.length() < 3) {
            JOptionPane.showMessageDialog(this, "La palabra debe tener al menos 3 letras para ser válida.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            textAreaResultados.setText("Palabra demasiado corta. Mínimo 3 letras.");
            return; 
        }
        
        long tiempoInicio = System.currentTimeMillis();
        StringBuilder rutaEncontrada = new StringBuilder(); //almecno la ruta aca

       
        boolean encontradaEnTablero = grafo.buscarPalabraEspecifica(palabraBuscada, rutaEncontrada);

        long tiempoFin = System.currentTimeMillis();
        long duracion = tiempoFin - tiempoInicio;

        if (encontradaEnTablero) {
            String resultadoTexto = "¡La palabra '" + palabraBuscada + "' fue encontrada!\n\n" +
                                    "Ruta:\n" + rutaEncontrada.toString();
            textAreaResultados.setText(resultadoTexto);

            
            
            
            boolean palabraEnDiccionario = false;
            String[] diccionarioActual = ventanaCargarOriginal.getDiccionario();
            int cantidadActualDiccionario = ventanaCargarOriginal.getCantidadPalabrasDiccionario();

            for (int i = 0; i < cantidadActualDiccionario; i++) {
                if (diccionarioActual[i] != null && diccionarioActual[i].equals(palabraBuscada)) {
                    palabraEnDiccionario = true;
                    break;
                }
            }

            if (!palabraEnDiccionario) {
                int confirmacion = JOptionPane.showConfirmDialog(this,
                    "La palabra '" + palabraBuscada + "' fue encontrada en el tablero pero no está en el diccionario.\n¿Desea agregarla al diccionario?",
                    "Palabra No Encontrada en Diccionario",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);

                if (confirmacion == JOptionPane.YES_OPTION) {
                    ventanaCargarOriginal.agregarPalabraAlDiccionario(palabraBuscada);
                }
            }
            
        } else {
            textAreaResultados.setText("La palabra '" + palabraBuscada + "' no fue encontrada en el tablero.");
        }

        jLabelTiempo.setText("Tiempo de búsqueda: " + duracion + " ms");
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void campoPalabraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoPalabraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoPalabraActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        Menu menuNuevo = new Menu(this.ventanaCargarOriginal);
        menuNuevo.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField campoPalabra;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelTiempo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea textAreaResultados;
    // End of variables declaration//GEN-END:variables
}
