package model.estrutura;

public class No<T> {

	private No<T> next;
	private T content;
	private boolean bitR;

	public No(T content) {
		this.next = null;
		this.content = content;
		this.bitR = false;
	}

	public T getContent() {
		referenciar();
		return content;
	}

	public void setContent(T valor) {
		this.content = valor;
	}

	public No<T> getNext() {
		return next;
	}

	public void setNext(No<T> proximo) {
		this.next = proximo;
	}

	public boolean getBitR() {
		return this.bitR;
	}

	public void setBitR(boolean bitR) {
		this.bitR = bitR;
	}

	public void referenciar() {
		this.bitR = true;
	}

	public void clearNode() {
		this.bitR = false;
		this.content = null;
		this.next = null;
	}

	@Override
	public String toString() {
		return content.toString();
	}
}
