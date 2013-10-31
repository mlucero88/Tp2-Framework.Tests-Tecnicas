/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo11.pruebaColaTP0;

/**
 *
 * @author nmerino
 */
public class Cola implements Queue {
    
    private NodoCola primerNodo;
    private int tamanio;
          
    
    public Cola (){
       this.tamanio = 0;
       this.primerNodo = null;
    }
    
       
    public boolean isEmpty(){
        return (this.tamanio == 0);
    }
    
    public int size(){        
        return this.tamanio;
    }
    
    public void add(Object item){
        if (this.isEmpty()){
            this.primerNodo = new NodoCola (item, null);
        }
        else{
            NodoCola punteroNodo = this.primerNodo;
            while (punteroNodo.existeSiguienteNodo()){
                punteroNodo = punteroNodo.getSiguienteNodo();
            }
            punteroNodo.setSiguienteNodo(new NodoCola (item, null));
        }
        this.tamanio++;
    }
 
    public Object top(){   
        if (this.isEmpty())
            throw new AssertionError();
        return primerNodo.getElemento();
    }
    
    public void remove(){
        if (this.isEmpty())
            throw new AssertionError();
        this.primerNodo = this.primerNodo.getSiguienteNodo(); 
        this.tamanio--;
    }
    
   
}
