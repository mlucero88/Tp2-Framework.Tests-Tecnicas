package Grupo11.FrameworkTest;

public abstract class TestCase {
	
	public abstract void test();
	
	private boolean run(){
		//hacer correr los test para que el runAll de TestSuite haga lo suyo
		return true;
	}
	
}