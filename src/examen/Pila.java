/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen;

/**
 *
 * @author danny
 */
public class Pila {
    float numero;
    Pila siguiente;
    
    Pila (float i){ 
        numero = i;
        siguiente = null;
    }
}

class pilaList{
    private Pila primeroEntrar;

    public pilaList() { //Constructor
        primeroEntrar = null;
    }
    
    public boolean pilaVacia(){ 
        if(primeroEntrar==null) return true;
        else return false;
    }
    
    public void agregarPila(float numero){ 
        Pila nuevo;                 
        nuevo = new Pila(numero); 
        nuevo.siguiente = primeroEntrar; //
        primeroEntrar = nuevo;
    }
    
    public float quitarPila(){
        if(pilaVacia()){ 
            return -1; 
        }
        float auxiliar = primeroEntrar.numero;
        primeroEntrar = primeroEntrar.siguiente;
        return auxiliar;
    }
    
    public void limpiarPila(){
        Pila pila;
        while (!pilaVacia()){ //Mientras no sea null
            pila = primeroEntrar;
            primeroEntrar = primeroEntrar.siguiente;
            pila.siguiente = null;
        }
        
    }
    
}
