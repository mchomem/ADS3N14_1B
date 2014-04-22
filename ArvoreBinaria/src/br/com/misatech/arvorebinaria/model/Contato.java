package br.com.misatech.arvorebinaria.model;

/**
 * Classe responsável que contém a definição de campos para um Contato telefônico.
 * 
 * @author Misael C. Homem
 * @since 1.00
 *
 */
public class Contato {

	private String nome;
	private String numero;
	
	/**
	 * Construtor padrão da classe.
	 */
	public Contato() {}
	
	/**
	 * Construtor da classe com parâmetros.
	 * 
	 * @param nome O Nome do contato.
	 * @param numero O número telefônico do contato.
	 */
	public Contato(String nome, String numero) {
		
		this.nome = nome;
		this.numero = numero;
		
	}
	
	// Getters e Setters.
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
}
