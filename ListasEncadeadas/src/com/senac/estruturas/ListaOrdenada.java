package com.senac.estruturas;

public class ListaOrdenada<T extends Comparable<T>> extends ListaEncadeada<T> {

	private Nodo<T> procuraNodo(T data) {
		
		Nodo<T> nodo = head;
		Nodo<T> anterior = null;
		
		while (nodo != null) {
			
			int cmp = nodo.getData().compareTo(data);
			
			if (cmp == 0) {
				return nodo;
			}
			
			if (cmp > 0) {
				return anterior;
			}
			
			anterior = nodo;
			nodo = nodo.getNext();
			
		}
		
		return nodo;
		
	}

	@Override
	public void insert(Nodo<T> novo) {
		
		// Atribui a "anterior" o valor da busca passado por parâmetro do nó.
		Nodo<T> anterior = procuraNodo(novo.getData());
		
		// Existe elemento na anterior?
		if (anterior != null) {
			
			novo.setNext(anterior.getNext());
			anterior.setNext(novo);
			
			if (anterior == tail) {
				tail = novo;
			}
			
		} else {
			
			// É o fim da lista?
			if (tail != null) {
				tail.setNext(novo);
			} else {
				head = novo;
			}
			
			// O novo elemento que entra fica como sendo a "cauda" (tail).
			tail = novo;
		}
		
	}
	
	@Override
	public void insert(Nodo<T> novo, Nodo<T> anterior) {
		
		insert(novo);
		
	}
	
	@Override
	public void append(Nodo<T> novo) {
		
		insert(novo);
		
	}
	
}
