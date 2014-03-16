package br.com.misatech.listatelefonica.model;

public class ListaEncadeada<T> {
	
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
	
	public void inserir(No<T> novo, No<T> anterior) {
		
		novo.setProximo(anterior.getProximo());
		anterior.setProximo(novo);
		
		novo.setAnterior(anterior);
		
		if (anterior == tail) {
			tail = novo;
		}
		
	}

}
