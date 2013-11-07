package grupo11.frameworktests;

import java.util.HashMap;

/* Clase de patron Singleton que lleva la informacion del fixture, en la cual
 * el cliente puede agregar, modificar o quitar variables desde los metodos
 * setup, teardown y test. Tambien permite guardar fixtures para recuperarlos
 * posteriormente */

public class Fixture {
	private static Fixture instance = null;
	private FixtureData data;
	private HashMap<String, FixtureData> storage;

	private Fixture() {
		data = new FixtureData();
		storage = new HashMap<String, FixtureData>();
	}

	/* Reemplaza variable anterior si una variable con variableName ya
	 * existia */
	public void addVariable(String variableName, Object variable) {
		data.addData(variableName, variable);
	}

	public void removeVariable(String variableName) {
		data.removeData(variableName);
	}

	public void clear() {
		data.clear();
	}

	public boolean existsVariable(String variableName) {
		return data.existsData(variableName);
	}

	/* Retorna null si no existia una variable de nombre variableName */
	public Object getVariable(String variableName) {
		return data.getData(variableName);
	}
	
	/* Guarda el fixture con un nombre para ser recuperado posteriormente */
	public void save(String fixtureName) {
		storage.put(fixtureName, data);
	}
	
	/* Recupera un fixture, es decir la instacia actual se configura con los
	 * valores del fixture a recuperar. Retorna false si no existe un fixture
	 * almacenado de nombre fixtureName */
	public boolean restore(String fixtureName) {
		FixtureData context = storage.get(fixtureName);
		if (context != null) {
			data = context;
		}
		return false;
	}

	public static Fixture getInstance() {
		if (instance == null) {
			instance = new Fixture();
		}
		return instance;
	}
}