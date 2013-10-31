package grupo11.frameworktests;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import grupo11.pruebaColaTP0.Cola;
import junit.framework.TestCase;

import org.junit.Before;


/**
 *
 * @author nmerino
 */
public class ColaTest extends TestCase {
    
    private Cola colaDePrueba;
    
    @Before
    public void setUp() throws Exception {
        super.setUp();
	this.colaDePrueba = new Cola();
    }
    
    public void testColaVacia(){
        assertTrue (this.colaDePrueba.isEmpty());
    }
    
    public void testColaLlena(){
        int elem = 4;
        this.colaDePrueba.add(elem);
        assertFalse (this.colaDePrueba.isEmpty());
    }
    
    public void testSize(){
        assertEquals (this.colaDePrueba.size(), 0, 0.0);
        this.agregarElementos(3);
        assertEquals (this.colaDePrueba.size(), 3, 0.0);
        this.agregarElementos(5);
        assertEquals (this.colaDePrueba.size(), 8, 0.0);
    }
    
    public void testTop(){
        this.agregarElementos (3);
        int tope = (Integer) this.colaDePrueba.top();
        assertEquals (tope, 1, 0.0);
    }
    
    public void testTopConColaVacia(){
        try{
            int elem = (Integer) this.colaDePrueba.top();
        }
        catch (AssertionError e){
            assertTrue (true);
        }
    }
    
    public void testRemoveConColaVacia(){
        try{
            this.colaDePrueba.remove();
        }
        catch (AssertionError e){
            assertTrue (true);
        }
    }
    
    public void testRemoveConColaLlena(){
        this.agregarElementos (3);
        int tope = (Integer) this.colaDePrueba.top();
        assertEquals (tope, 1, 0.0);
    }
    
    public void testLlenaryVaciarCola (){
        this.agregarElementos (3);
        int tope = (Integer) this.colaDePrueba.top();
        assertEquals (tope, 1, 0.0);
        this.colaDePrueba.remove();
        tope = (Integer) this.colaDePrueba.top();
        assertEquals (tope, 2, 0.0);
        this.colaDePrueba.remove();
        tope = (Integer) this.colaDePrueba.top();
        assertEquals (tope, 3, 0.0);
        this.colaDePrueba.remove();
        assertTrue (this.colaDePrueba.isEmpty());
    }
    
    private void agregarElementos(int cantidad){
        for (int i = 1; i <= cantidad ; i++){
            this.colaDePrueba.add(new Integer(i));
        }
    }
}
