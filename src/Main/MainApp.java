/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Main;
import Interfaces.Cargar; // Importa tu clase Cargar
/**
 *
 * @author Gloria
 */

public class MainApp {
    public static void main(String[] args) {
        // Esto asegura que la GUI se inicie en el hilo correcto de Swing
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cargar().setVisible(true); // Crea y muestra la ventana de Cargar
            }
        });
    }
}
