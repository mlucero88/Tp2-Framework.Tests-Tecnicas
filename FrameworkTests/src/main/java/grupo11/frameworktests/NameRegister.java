package grupo11.frameworktests;

public class NameRegister {

	private static NameRegister instancia = null;
	
	private NameRegister(){
		
	}
	
	public static NameRegister getInstancia(){
		if(instancia == null){
			instancia = new NameRegister();
		}
		return instancia;
	}
	
	public boolean registerName(String name){
		return true;
	}

	public boolean unregisterName(String name){
		return true;
	}
	
	private boolean exists(String name){
		return true;
	}

}
