package br.com.misatech.arvorebinaria.model;

/**
 * Classe que define um nó para uma estrutura de dados.
 * 
 * @author Misael C. Homem
 * @since 1.00
 *
 * @param <T>
 */
public class No<T> {
	
	private Contato contato;
	private No<T> pai;
	private No<T> galhoDireita;
	private No<T> galhoEsquerda;
	
	public No() {}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public No<T> getPai() {
		return pai;
	}

	public void setPai(No<T> pai) {
		this.pai = pai;
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
