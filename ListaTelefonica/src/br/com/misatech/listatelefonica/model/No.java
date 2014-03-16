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
	 * @param i
	 */
	public No(T i) {
		dado = i;
		proximo = null;
		anterior = null;
	}
	
	public void setData(T i) {
		dado = i;
		proximo = null;
		anterior = null;
	}
	
	public T getData() {
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
