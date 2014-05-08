package br.com.misatech.arvorebinaria.model;

/**
 * Classe que define um nó para uma estrutura de dados.
 * 
 * @author Misael C. Homem
 * @since 1.00
 *
 * @param <T>
 */
public class No {
	
	private Contato contato;
	private No pai;
	private No galhoDireita;
	private No galhoEsquerda;
	private long nivel;
	
	public No() {}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public No getPai() {
		return pai;
	}

	public void setPai(No pai) {
		this.pai = pai;
	}

	public No getGalhoDireita() {
		return galhoDireita;
	}

	public void setGalhoDireita(No galhoDireita) {
		this.galhoDireita = galhoDireita;
	}

	public No getGalhoEsquerda() {
		return galhoEsquerda;
	}

	public void setGalhoEsquerda(No galhoEsquerda) {
		this.galhoEsquerda = galhoEsquerda;
	}

	public long getNivel() {
		return nivel;
	}

	public void setNivel(long nivel) {
		this.nivel = nivel;
	}

}
