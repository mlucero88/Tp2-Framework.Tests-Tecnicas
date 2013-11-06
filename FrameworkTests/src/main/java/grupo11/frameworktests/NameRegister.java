package grupo11.frameworktests;

import java.util.TreeSet;

public class NameRegister {
	private static NameRegister instance = null;
	private TreeSet<String> registry;

	private NameRegister() {
		registry = new TreeSet<String>();
	}

	public static NameRegister getInstance() {
		if (instance == null) {
			instance = new NameRegister();
		}
		return instance;
	}

	public boolean registerName(String name) {
		return registry.add(name);
	}

	public boolean unregisterName(String name) {
		return registry.remove(name);
	}

	public void clear() {
		registry.clear();
	}
}