package grupo11.ColaTp0;

public class Cola implements Queue {
	private NodoCola primerNodo;
	private int tamanio;

	public Cola() {
		tamanio = 0;
		primerNodo = null;
	}

	public boolean isEmpty() {
		return tamanio == 0;
	}

	public int size() {
		return tamanio;
	}

	public void add(Object item) {
		if (isEmpty()) {
			primerNodo = new NodoCola(item, null);
		}
		else {
			NodoCola punteroNodo = primerNodo;
			while (punteroNodo.existeSiguienteNodo()) {
				punteroNodo = punteroNodo.getSiguienteNodo();
			}
			punteroNodo.setSiguienteNodo(new NodoCola(item, null));
		}
		tamanio++;
	}

	public Object top() {
		if (isEmpty()) throw new AssertionError();
		return primerNodo.getElemento();
	}

	public void remove() {
		if (isEmpty()) throw new AssertionError();
		primerNodo = primerNodo.getSiguienteNodo();
		tamanio--;
	}
}