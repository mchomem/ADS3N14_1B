package br.com.misatech.batalhanaval.model;

/**
 * Representa��o do placar do jogo para guardar a pontua��o do obtida durante a partida.
 * 
 * @author Misael C. Homem
 * @since 1.00
 *
 */
public class Placar {

	private int pontuacao = 0;

	/**
	 * Construtor padr�o.
	 */
	public Placar() {
		
		// Inicia a pontua��o com 15 pontos.
		this.pontuacao = 15;
		
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}
	
}
