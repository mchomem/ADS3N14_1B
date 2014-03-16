package br.com.misatech.listatelefonica.model;

public class ListaEncadeada<T extends Comparable<T>> {
	
	protected No<T> head;
	protected No<T> tail;
	
	/**
	 * M�todo de inser��o do 1� n�.
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
	 * @param novo
	 * @param anterior
	 */
	public void inserir(No<T> novo, No<T> anterior) {
		
		novo.setProximo(anterior.getProximo());
		anterior.setProximo(novo);
		
		novo.setAnterior(anterior);
		
		if (anterior == tail) {
			tail = novo;
		}
		
	}
	
	public void remover() {
		
		
		
	}
	
	/**
	 * Faz a impress�o dos valores de cada n� concatenandos com quebra de linha e retorno de carro.
	 * 
	 * @return Retorna uma String com os valores de cada n�.
	 */
	public String imprimir() {
		
		No<T> elem = head;
		String valores = "";
		
		do {
			
			valores += elem.getDado() + "\r\n";
			elem = elem.getProximo();
			
		} while (elem != null);
		
		return valores; 
		
	}
	
	public No<T> procurarNoPorValor(T valor) {
		
		No<T> nodo = head;
		No<T> anterior = null;
		No<T> proximo = null;
		
		while (nodo != null) {
			
			int cmp = nodo.getDado().compareTo(valor);
			
			if (cmp == 0) {
				return nodo;
			}
			
			if (cmp > 0) {
				return anterior;
			}
			
			anterior = nodo;
			nodo = nodo.getProximo();
			proximo.setAnterior(anterior);
			
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
