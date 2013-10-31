/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo11.pruebaColaTP0;

/**
 *
 * @author nmerino
 */
public class NodoCola {
    
    private Object elemento;
    private NodoCola siguienteNodo;
    
    public NodoCola (Object elemento, NodoCola siguienteNodo){
        this.elemento = elemento;
        this.siguienteNodo = siguienteNodo;
    }
    
    public Object getElemento (){
        return this.elemento;
    }
    
    public NodoCola getSiguienteNodo (){
        return this.siguienteNodo;
    }
        
    public void setElemento (Object elemento){
        this.elemento = elemento;
    }
    
    public void setSiguienteNodo (NodoCola siguienteNodo){
        this.siguienteNodo = siguienteNodo;
    }
    
    public boolean existeSiguienteNodo (){
        if (this.siguienteNodo == null)
            return false;
        else
            return true;
    }
    
}
