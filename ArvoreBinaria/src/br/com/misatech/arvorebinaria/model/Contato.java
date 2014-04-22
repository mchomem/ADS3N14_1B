package br.com.misatech.arvorebinaria.model;

/**
 * Classe respons�vel que cont�m a defini��o de campos para um Contato telef�nico.
 * 
 * @author Misael C. Homem
 * @since 1.00
 *
 */
public class Contato {

	private String nome;
	private String numero;
	
	/**
	 * Construtor padr�o da classe.
	 */
	public Contato() {}
	
	/**
	 * Construtor da classe com par�metros.
	 * 
	 * @param nome O Nome do contato.
	 * @param numero O n�mero telef�nico do contato.
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
