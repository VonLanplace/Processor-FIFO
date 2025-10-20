package model.estrutura;

public class FilaFifo<T> {
	private No<T> first;
	private int size;

	public FilaFifo() {
		this.first = null;
		this.size = 0;
	}

	public int getSize() {
		return size;
	}

	// enqueue: adiciona um elemento no final da fifo
	// dequeue: retira o first da fifo
	// last: retorna o ultimo elemento

	public No<T> last() throws IllegalArgumentException {
		if (this.first == null)
			throw new IllegalArgumentException("Não existe fila.");
		No<T> buffer = this.first;
		while (buffer.getNext() != null)
			buffer = buffer.getNext();
		return buffer;
	}

	public void enqueue(T elemento) {
		No<T> buffer = new No<>(elemento);
		if (this.first == null) {
			this.first = buffer;
		} else {
			this.last().setNext(buffer);
		}
		this.size++;
	}

	public void enqueue(No<T> node) {
		if (this.first == null) {
			this.first = node;
		} else {
			this.last().setNext(node);
			node.setNext(null);
		}
		this.size++;
	}

	public No<T> dequeue() {
		if (this.first == null) {
			return null;
		}
		No<T> first = this.first;
		this.first = first.getNext();
		this.size--;

		return first;
	}

	public void secondChance() {
		if (this.first == null) {
			return;
		}
		No<T> first = this.first;
		while (first != null) {
			No<T> second = this.first.getNext();
			this.first = second;
			this.size--;

			if (first.getBitR()) {
				first.setBitR(false);
				enqueue(first);
			} else {
				first.clearNode();
			}

			first = second;
		}
	}

	@Override
	public String toString() {
		if (this.first == null) {
			return "[]";
		}

		StringBuilder builder = new StringBuilder("[");
		No<T> buffer = this.first;
		builder.append(buffer.getContent());
		while (buffer.getNext() != null) {
			builder.append(",");
			buffer = buffer.getNext();
			builder.append(buffer.getContent());
		}
		builder.append("]");
		return builder.toString();
	}
}
