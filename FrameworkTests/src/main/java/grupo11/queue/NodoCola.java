package grupo11.queue;

public class NodoCola {
	private Object elemento;
	private NodoCola siguienteNodo;

	public NodoCola(Object elemento, NodoCola siguienteNodo) {
		this.elemento = elemento;
		this.siguienteNodo = siguienteNodo;
	}

	public Object getElemento() {
		return elemento;
	}

	public NodoCola getSiguienteNodo() {
		return siguienteNodo;
	}

	public void setElemento(Object elemento) {
		this.elemento = elemento;
	}

	public void setSiguienteNodo(NodoCola siguienteNodo) {
		this.siguienteNodo = siguienteNodo;
	}

	public boolean existeSiguienteNodo() {
		if (siguienteNodo == null) {
			return false;
		}
		else {
			return true;
		}
	}
}