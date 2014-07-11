package br.com.misatech.batalhanaval.model;

/**
 * Representa um navio genéricamente. Não podendo ser instanciado.
 * 
 * @author Misael C. Homem
 * @since 1.00
 *
 */
public abstract class Navio {
	
	private int tamanho = 0;
	
	/**
	 * Construtor padrão.
	 */
	public Navio() {}
	
	public Navio(int tamanho) {
		this.tamanho = tamanho;
	}

	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

}
