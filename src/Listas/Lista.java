package Listas;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Gloria
 */
public class Lista {
    private Nodo pFirst;
    private Nodo pLast;
    private int size;

    public Lista() {
        this.pFirst = null;
        this.pLast = null;
        this.size = 0;
    }
      
    //Metodo clase lista
    
    public boolean EsVacio(){
        return getpFirst() == null;
        
    }
    
    public void InsertarFinal(Object data){
        Nodo nuevo = new Nodo(data);
        
        if (EsVacio()){
            
            pFirst = nuevo;
            pLast = nuevo;
        }else{
             Nodo aux= pLast;
             aux.setPnext(nuevo);
             pLast = nuevo;
             
        }
        size+=1;
           
        
        
    }
    
    public void Imprimir(){
        if (!EsVacio()){
            Nodo aux = pFirst;
            for (int i = 0 ; i< size; i++){
                System.out.println(aux.getDato()+ " ");
                aux= aux.getPnext();
            }
                
            }else{
            System.out.println("La lista eesta vacia");
        }
    }
    
    public void EliminarInicio(){
        if(!EsVacio()){
            pFirst = pFirst.getPnext();
            size = size-1;
        } 
    }
    /**
     * @return the pFirst
     */
    public Nodo getpFirst() {
        return pFirst;
    }

    /**
     * @param pFirst the pFirst to set
     */
    public void setpFirst(Nodo pFirst) {
        this.pFirst = pFirst;
    }

    /**
     * @return the pLast
     */
    public Nodo getpLast() {
        return pLast;
    }

    /**
     * @param pLast the pLast to set
     */
    public void setpLast(Nodo pLast) {
        this.pLast = pLast;
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }
    

    
    
    
}
