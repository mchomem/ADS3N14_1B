package br.com.misatech.listatelefonica.model;

public class ListaEncadeada<T extends Comparable<T>> {
	
	protected No<T> head;
	protected No<T> tail;
	
	/**
	 * M�todo de inser��o do 1� n�.
	 * 
	 * @param novo o n� da lista.
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
	 * Inser��o de n� no final da lista.
	 * 
	 * @param novo O n� propriamente dito.
	 * @param anterior O n� anterior.
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
	 * Faz a impress�o dos valores de cada n� concatenandos com quebra de linha e retorno de carro.
	 * 
	 * @return Retorna uma String com os valores de cada n�.
	 */
	public String imprimir() {
		
		// Inicializa com o 1� n�.
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
