package Listas;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Gloria
 */
public class Control {
    
    public static void main(String[] args){
        Lista mylist = new Lista();
        mylist.InsertarFinal(1);
        mylist.InsertarFinal(2);
        mylist.InsertarFinal(3);
        mylist.InsertarFinal(4);
        
        mylist.Imprimir();
        
        mylist.EliminarInicio();
        System.out.println("\n");
        mylist.Imprimir();
        
        
    }
    
}
