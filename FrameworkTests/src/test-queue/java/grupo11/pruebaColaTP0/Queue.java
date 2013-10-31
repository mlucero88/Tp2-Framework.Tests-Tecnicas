package grupo11.pruebaColaTP0;

public interface Queue {
	boolean isEmpty();

	int size();

	void add(Object item); // Agregar un item

	Object top(); // Retornar el primer item, lanzar exception si está vacío.

	void remove(); // Remover el primer item, lanzar exception si está vacío.
}