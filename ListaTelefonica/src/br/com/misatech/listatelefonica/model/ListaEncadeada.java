package br.com.misatech.listatelefonica.model;

public class ListaEncadeada<T extends Comparable<T>> {
	
	protected No<T> head;
	protected No<T> tail;
	
	/**
	 * Método de inserção do 1º nó.
	 * 
	 * @param novo o nó da lista.
	 */
	public void inserir(No<T> novo) {
		
		novo.setAnterior(head);
		novo.setProximo(head);
		
		head = novo;
		
		if (tail == null) {
			tail = novo;
		}
		
	}
	
	/**
	 * Inserção de nó no final da lista.
	 * 
	 * @param novo O nó propriamente dito.
	 * @param anterior O nó anterior.
	 */
	public void inserir(No<T> novo, No<T> anterior) {
		
		novo.setProximo(anterior.getProximo());
		anterior.setProximo(novo);
		
		novo.setAnterior(anterior);
		
		if (anterior == tail) {
			tail = novo;
		}
		
	}
	
	/**
	 * Faz a impressão dos valores de cada nó concatenandos com quebra de linha e retorno de carro.
	 * 
	 * @return Retorna uma String com os valores de cada nó.
	 */
	public String imprimir() {
		
		// Inicializa com o 1º nó.
		No<T> elem = head;
		
		String valores = "";
		
		do {
			
			valores += elem.getDado() + "\r\n";
			elem = elem.getProximo();
			
		} while (elem != null);
		
		return valores; 
		
	}
	
	public No<T> procurarNoPorValorInicial(T valor) {
		
		No<T> nodo = head;
		No<T> anterior = null;
		
		while (nodo != null) {
			
			String letraInicial = String.valueOf( ((String) nodo.getDado()).charAt(0) ); 
			
			int cmp = letraInicial.compareTo((String) valor);
			
			if (cmp == 0) {
				return nodo;
			}			
			
			anterior = nodo;
			nodo = nodo.getProximo();
			
		}
		
		return nodo;
		
	}

	public No<T> getHead() {
		return head;
	}

	public void setHead(No<T> head) {
		this.head = head;
	}

	public No<T> getTail() {
		return tail;
	}

	public void setTail(No<T> tail) {
		this.tail = tail;
	}

}
