package grupo11.pruebaframework;

/* Clase para probar el validateEquals(Object, Object) */
public class DummyClass {

	private String nombre;
	private int numero;
	private char caracter;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public char getCaracter() {
		return caracter;
	}

	public void setCaracter(char caracter) {
		this.caracter = caracter;
	}

	public DummyClass(String nombre, int numero, char caracter) {
		this.nombre = nombre;
		this.numero = numero;
		this.caracter = caracter;
	}

	@Override
	public boolean equals(Object objeto) {
		DummyClass obj = (DummyClass)objeto;
		return obj.nombre == this.nombre && obj.numero == this.numero
				&& obj.caracter == this.caracter;
	}
}