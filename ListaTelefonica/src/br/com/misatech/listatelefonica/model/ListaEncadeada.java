package br.com.misatech.listatelefonica.model;

public class ListaEncadeada<T> {
	
	protected No<T> head;
	protected No<T> tail;
	
	/**
	 * Método de inserção do 1º nó.
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
	
	public void inserir(No<T> novo, No<T> anterior) {
		
		novo.setProximo(anterior.getProximo());
		anterior.setProximo(novo);
		
		novo.setAnterior(anterior);
		
		if (anterior == tail) {
			tail = novo;
		}
		
	}

}
