/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author Gloria
 */
    
public class EstadoDFS {
    public int fila;
    public int columna;
    public int indicePalabraBuscada;
    public EstadoDFS anterior;

    public EstadoDFS(int fila, int columna, int indicePalabraBuscada,EstadoDFS anterior) {
        this.fila = fila;
        this.columna = columna;
        this.indicePalabraBuscada = indicePalabraBuscada;
        this.anterior = anterior;
    }
    public EstadoDFS(int fila, int columna, int indicePalabraBuscada) {
        this(fila, columna, indicePalabraBuscada, null); 
    }
}
