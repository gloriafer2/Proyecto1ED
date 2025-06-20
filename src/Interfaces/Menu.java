/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;
import EDD.Grafo; 

/**
 * La clase `Menu` representa la ventana principal de la interfaz gráfica de usuario (GUI)
 * de la aplicación de sopa de letras. Permite al usuario navegar a diferentes funcionalidades
 * como cargar un archivo, buscar una palabra específica o buscar todas las palabras del diccionario
 * en el tablero.
 *
 * Esta ventana actúa como un punto central de la aplicación, manteniendo referencias
 * a los datos principales (grafo, diccionario, tablero) que son compartidos entre las
 * diferentes vistas (ventanas).
 *
 * @author Gloria
 */
    
    public class Menu extends javax.swing.JFrame {

    
    public Grafo grafo;
    public String[] diccionario;
    public char[][] tablero;
    public Cargar ventanaCargarOriginal;

   
    /**
     * Constructor de la clase `Menu`.
     * Inicializa los componentes de la GUI y establece las referencias a los
     * objetos de datos compartidos, que se obtienen de la instancia de `Cargar`
     * pasada como parámetro. Oculta la ventana `Cargar` original y centra
     * esta nueva ventana en la pantalla, deshabilitando su redimensionamiento.
     *
     * @param v1 La instancia de la ventana `Cargar` desde la cual se invoca este menú.
     * Contiene los datos del grafo, diccionario y tablero ya cargados.
     */
    public Menu(Cargar v1) {
        initComponents();
        this.ventanaCargarOriginal = v1;
        this.grafo = v1.grafo;
        this.diccionario = v1.diccionario;
        this.tablero = v1.tablero;

        v1.setVisible(false); 
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        botonCargar = new javax.swing.JButton();
        botonBuscarEsp = new javax.swing.JButton();
        botonBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 0));
        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 204, 204));
        jLabel1.setText("Menú");

        jLabel2.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setText("Selecciona una opcion");

        botonCargar.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        botonCargar.setForeground(new java.awt.Color(0, 102, 102));
        botonCargar.setText("Cargar archivo");
        botonCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCargarActionPerformed(evt);
            }
        });

        botonBuscarEsp.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        botonBuscarEsp.setForeground(new java.awt.Color(0, 102, 102));
        botonBuscarEsp.setText("Buscar palabra especifica");
        botonBuscarEsp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarEspActionPerformed(evt);
            }
        });

        botonBuscar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        botonBuscar.setForeground(new java.awt.Color(0, 102, 102));
        botonBuscar.setText("Buscar todas las palabras");
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(botonBuscarEsp)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 182, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel1))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(botonCargar))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(botonBuscar)))
                .addGap(84, 84, 84))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonCargar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(botonBuscar)
                        .addGap(18, 18, 18)
                        .addComponent(botonBuscarEsp)
                        .addContainerGap(78, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
/**
     * Maneja el evento de acción del botón "Cargar archivo".
     * Oculta la ventana actual (`Menu`) y vuelve a hacer visible la ventana `Cargar`
     * que permitió la carga inicial de los datos. Esto permite al usuario cargar
     * un nuevo archivo si lo desea.
     *
     * @param evt El evento de acción generado por el botón.
     */
    private void botonCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCargarActionPerformed

        this.setVisible(false);
        this.ventanaCargarOriginal.setVisible(true);
    }//GEN-LAST:event_botonCargarActionPerformed

    private void botonBuscarEspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarEspActionPerformed
        
        this.setVisible(false);
        BuscarPalabraEsp buscarEspecifica = new BuscarPalabraEsp(this.grafo, this.diccionario, this.tablero, this.ventanaCargarOriginal);
        buscarEspecifica.setVisible(true); 
    }//GEN-LAST:event_botonBuscarEspActionPerformed

    /**
     * Maneja el evento de acción del botón "Buscar todas las palabras".
     * Oculta la ventana actual (`Menu`) y abre una nueva ventana `BuscarTodasLasPalabras`
     * para realizar una búsqueda exhaustiva de todas las palabras del diccionario
     * en el tablero. Pasa las referencias del grafo, diccionario, tablero y la ventana `Cargar`
     * a la nueva ventana.
     *
     * @param evt El evento de acción generado por el botón.
     */
    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
       
        this.setVisible(false);
        BuscarTodasLasPalabras buscarTodas = new BuscarTodasLasPalabras(this.grafo, this.diccionario, this.tablero, this.ventanaCargarOriginal);
        buscarTodas.setVisible(true);
    }//GEN-LAST:event_botonBuscarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            
            new Cargar().setVisible(true);

           
        }
    });
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonBuscarEsp;
    private javax.swing.JButton botonCargar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
