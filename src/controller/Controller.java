package controller;

import model.estrutura.FilaFifo;
import model.estrutura.No;

public class Controller {
	public Controller() {
		super();
	}

	public String teste() throws Exception {
		FilaFifo<Integer> fila = new FilaFifo<>();

		fila.enqueue(1);
		fila.enqueue(2);

		System.out.println(fila.toString());

		No<Integer> nosn = fila.dequeue();
		nosn.getContent();

		nosn = fila.dequeue();

		System.out.println(fila.toString());
		nosn = fila.dequeue();
		nosn = fila.dequeue();

		System.out.println(fila.toString());

		return fila.toString();
	}
}
