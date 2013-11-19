package grupo11.frameworktests;

import java.util.HashMap;

/* Clase utilizada para definir estructura de datos y forma en que se almacenan
 * los datos en un Fixture */

class FixtureData {
	private HashMap<String, Object> variables;

	public FixtureData() {
		variables = new HashMap<String, Object>();
	}

	public void addData(String variableName, Object variable) {
		variables.put(variableName, variable);
	}

	public void removeData(String variableName) {
		variables.remove(variableName);
	}

	public void clear() {
		variables.clear();
	}

	public boolean existsData(String variableName) {
		return variables.containsKey(variableName);
	}

	public Object getData(String variableName) {
		return variables.get(variableName);
	}
}