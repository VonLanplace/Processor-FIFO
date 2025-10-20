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

    if (first.getBitR()) {
      first.setNext(null);
      first.setBitR(false);
      this.enqueue(first);
    }

    return first;
  }

  public void secondChance() {
    if (this.first == null) {
      return;
    }

    No<T> previous = this.first;
    No<T> buffer = previous.getNext();

    while (buffer != null) {
      if (!buffer.getBitR()) {
        previous.setNext(buffer.getNext());

        buffer.clearNode();
        this.size--;
      }
    }

    if (!this.first.getBitR()) {
      buffer = this.first;
      this.first = this.first.getNext();

      buffer.clearNode();
      this.size--;
    }
  }

  @Override
  public String toString() {
    if (this.first == null) {
      return "[]";
    }

    StringBuilder builder = new StringBuilder("[");
    No<T> buffer = this.first;
    builder.append(buffer.toString());
    while (buffer.getNext() != null) {
      builder.append(",");
      buffer = buffer.getNext();
      builder.append(buffer.toString());
    }
    builder.append("]");
    return builder.toString();
  }
}
