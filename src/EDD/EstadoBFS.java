/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author Gloria
 */
public class EstadoBFS {
    private int fila;
    private int columna;
    private int indiceLetra;
    public EstadoBFS anterior;

    public EstadoBFS(int fila, int columna, int indiceLetra,EstadoBFS anterior) {
        this.fila = fila;
        this.columna = columna;
        this.indiceLetra = indiceLetra;
        this.anterior = anterior;
    }
     public EstadoBFS(int fila, int columna, int indiceLetra) {
        this(fila, columna, indiceLetra, null); 
    }


    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    public int getIndiceLetra() {
        return indiceLetra;
    }

    @Override
    public String toString() {
        return "EstadoBFS{fila=" + fila + ", columna=" + columna + ", indiceLetra=" + indiceLetra + '}';
    }
}
