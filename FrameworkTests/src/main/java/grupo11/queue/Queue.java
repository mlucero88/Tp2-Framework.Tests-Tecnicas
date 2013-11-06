package grupo11.queue;

public interface Queue {
	boolean isEmpty();

	int size();

	void add(Object item); // Agregar un item

	Object top(); // Retornar el primer item, lanzar exception si está vacío.

	void remove(); // Remover el primer item, lanzar exception si está vacío.
}