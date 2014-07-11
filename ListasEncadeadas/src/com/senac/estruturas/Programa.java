package com.senac.estruturas;

public class Programa {

	public static void main(String []args) {
		
		// criar lista
		ListaOrdenada<Integer> lista = new ListaOrdenada<Integer>();
		
        // Cria um novo Nó passando por parâmetro o valor inicial.
        Nodo<Integer> novo = new Nodo<Integer>(1);
        
        // insere no inicio da lista
		lista.insert(novo); 
		lista.insert(new Nodo<Integer>(2), novo);  // insere no fim da lista.
		lista.append(new Nodo<Integer>(3));
		lista.insert(new Nodo<Integer>(4), novo);
		
		lista.print();
		
	}
	
}
