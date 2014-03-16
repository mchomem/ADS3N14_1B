package br.com.misatech.listatelefonica.model;

/**
 * Classe representando um nó de lista encadeada.
 * 
 * @author Rafael Jeffmann, Misael C. Homem
 * @param <T> Genérico
 * @since 1.00
 */
public class No<T> {

	private T dado;
	private No<T> proximo;
	private No<T> anterior;

	/**
	 * Construtor de classe.
	 * 
	 * @param dado
	 */
	public No(T dado) {
		
		this.dado = dado;
		proximo = null;
		anterior = null;
		
	}
	
	public void setDado(T dado) {
		
		this.dado = dado;
		proximo = null;
		anterior = null;
		
	}
	
	public T getDado() {
		return dado;
	}

	public No<T> getProximo() {
		return proximo;
	}
	
	public void setProximo(No<T> proximo) {
		this.proximo = proximo;
	}

	public No<T> getAnterior() {
		return anterior;
	}

	public void setAnterior(No<T> anterior) {
		this.anterior = anterior;
	}
	
}
