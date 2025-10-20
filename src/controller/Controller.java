package controller;

import model.estrutura.FilaFifo;
import model.estrutura.No;

public class Controller{
	public Controller(){
		super();
	}
	
	public String teste() throws Exception{
		FilaFifo<Integer> fila = new FilaFifo<>();
		
		fila.enqueue(1);
		fila.enqueue(2);
		fila.enqueue(3);
		fila.dequeue();
		
		return fila.toString();
	}
}
