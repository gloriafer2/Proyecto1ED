package Listas;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Gloria
 */
public class Nodo {
    
    private Nodo pnext;
    private Object dato;

    
    
    /// Get accede a la info
    ///set modifcia lo que hay
    
    public Nodo(Object dato){
        this.pnext = null;
        this.dato = dato;
               
    }
    
    public Nodo(Nodo pnext, Object dato) {
        this.pnext = pnext;
        this.dato = dato;
    } 
    
    
    
    
    
    

    /**
     * @return the pnext
     */
    public Nodo getPnext() {
        return pnext;
    }

    /**
     * @param pnext the pnext to set
     */
    public void setPnext(Nodo pnext) {
        this.pnext = pnext;
    }

    /**
     * @return the dato
     */
    public Object getDato() {
        return dato;
    }

    /**
     * @param dato the dato to set
     */
    public void setDato(Object dato) {
        this.dato = dato;
    }

   
    
}
