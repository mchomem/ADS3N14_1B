package br.com.misatech.arvorebinaria.model;

/**
 * Classe que define um n� para uma estrutura de dados.
 * 
 * @author Misael C. Homem
 * @since 1.00
 *
 * @param <T>
 */
public class No<T> {
	
	private Contato contato;
	private No<T> raiz;
	private No<T> galhoDireita;
	private No<T> galhoEsquerda;
	
	public No() {}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public No<T> getRaiz() {
		return raiz;
	}

	public void setRaiz(No<T> raiz) {
		this.raiz = raiz;
	}

	public No<T> getGalhoDireita() {
		return galhoDireita;
	}

	public void setGalhoDireita(No<T> galhoDireita) {
		this.galhoDireita = galhoDireita;
	}

	public No<T> getGalhoEsquerda() {
		return galhoEsquerda;
	}

	public void setGalhoEsquerda(No<T> galhoEsquerda) {
		this.galhoEsquerda = galhoEsquerda;
	}

}
