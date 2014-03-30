package br.com.misatech.batalhanaval.model;

/**
 * Representação do placar do jogo para guardar a pontuação do obtida durante a partida.
 * 
 * @author Misael C. Homem
 * @since 1.00
 *
 */
public class Placar {

	private int pontuacao = 0;

	/**
	 * Construtor padrão.
	 */
	public Placar() {
		
		// Inicia a pontuação com 15 pontos.
		this.pontuacao = 15;
		
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}
	
}
