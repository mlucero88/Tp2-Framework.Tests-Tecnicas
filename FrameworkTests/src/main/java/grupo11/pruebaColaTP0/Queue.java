/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo11.pruebaColaTP0;

/**
 *
 * @author nmerino
 */
public interface Queue {
    boolean isEmpty();
    int size();
    void add(Object item); //Agregar un item
    Object top(); //Retornar el primer item, lanzar exception si está vacío.
    void remove(); //Remover el primer item, lanzar exception si está vacío.
    
}
