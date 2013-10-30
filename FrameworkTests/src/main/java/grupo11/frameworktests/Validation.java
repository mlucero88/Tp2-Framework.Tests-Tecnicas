package grupo11.frameworktests;

/* Clase proveedora de metodos static que validan condiciones */

public abstract class Validation {

	public static void validateTrue(boolean condition) {
		if (!condition) {
			informFail(null);
		}
	}

	public static void validateFalse(boolean condition) {
		validateTrue(!condition);
	}

	public static void validateEquals(Object expected, Object actual) {
		if (!areEqual(expected, actual)) {
			informFail(generateFailedEqualsMessage(expected, actual));
		}
	}

	public static void validateEquals(boolean expected, boolean actual) {
		validateEquals(new Boolean(expected), new Boolean(actual));
	}

	public static void validateEquals(int expected, int actual) {
		validateEquals(new Integer(expected), new Integer(actual));
	}

	public static void validateEquals(short expected, short actual) {
		validateEquals(new Short(expected), new Short(actual));
	}

	public static void validateEquals(long expected, long actual) {
		validateEquals(new Long(expected), new Long(actual));
	}

	public static void validateEquals(float expected, float actual) {
		validateEquals(new Float(expected), new Float(actual));
	}

	public static void validateEquals(double expected, double actual) {
		validateEquals(new Double(expected), new Double(actual));
	}

	public static void validateEquals(byte expected, byte actual) {
		validateEquals(new Byte(expected), new Byte(actual));
	}

	public static void validateEquals(char expected, char actual) {
		validateEquals(new Character(expected), new Character(actual));
	}

	public static void validateNull(Object object) {
		validateTrue(object == null);
	}

	private static String generateFailedEqualsMessage(Object expected,
			Object actual) {
		String message =
				"expected:<" + expected + "> - actual:<" + actual + ">";
		return message;
	}

	private static void informFail(String message) {
		throw new AssertionError(message);
	}

	private static boolean areEqual(Object expected, Object actual) {
		return (expected == null && actual == null)
				|| (expected != null && expected.equals(actual));
	}

	protected Validation() {}
}