package br.com.misatech.batalhanaval.controller;

import br.com.misatech.batalhanaval.model.Placar;
import br.com.misatech.batalhanaval.model.Tabuleiro;
import br.com.misatech.batalhanaval.view.Console;

/**
 * Classe para controlar 
 * 
 * @author Misael C. Homem
 * @since .1.00
 *
 */
public class CtrPrograma {
	
	private Console   console;
	private Tabuleiro tabuleiro;
	private Placar    placar;
	
	/**
	 * Construtor padr�o da classe.
	 */
	public CtrPrograma() {
		
		console   = new Console();
		tabuleiro = new Tabuleiro();
		placar    = new Placar();

	}
	
	/**
	 * Inclue as rotinas necess�rias para iniciar o programa.
	 */
	public void iniciar() {
	
		console.imprimir("Batalha Naval Java.\n");
		tabuleiro.iniciar();
		String opcao = "";
		
		do {
			
			tabuleiro.distribuirNavios();
			
			console.imprimir(tabuleiro.imprimir());
			console.imprimir("Placar: " + placar.getPontuacao() + " pontos\n");
			console.imprimir("*** Menu ***\n");
			console.imprimir("1 - Disparar torpedo.");
			console.imprimir("2 - Reiniciar partida.");
			console.imprimir("0 - Abandonar partirda.");
			opcao = console.cursor("Op��o");
			
			switch (opcao) {
			
			case "1":
				
				this.executarTurno();
				break;
			
			case "2":
				
				tabuleiro.iniciar();
				tabuleiro.inicializaCoordenadasUtilizadas();
				placar.setPontuacao(15);
				
				break;
				
			case "3":

				// Game cheat.
				console.imprimir("Revelando posi��o dos navios.");
				tabuleiro.revelarPosicaoNavios();
				break;

			case "0":
				
				this.finalizar();
				break;
				
			default:
				
				console.imprimir("Escolha uma das op��es do menu.");
				break;
				
			}
		
		} while(true);
		
	}

	/**
	 * Finaliza o programa.
	 */
	private void finalizar() {
		
		console.imprimir("Fim do jogo.");
		System.exit(0);
		
	}
	
	/**
	 * Executa um turno na jogada.
	 */
	private void executarTurno() {
		
		String coordenada  = "";
		String coordLinha  = "";
		String coordColuna = "";
		String infoTorpedo = "";
		
		boolean portaAviaoDestruido, detroyerDestruido, fragataDestruido, torpedeiroDestruido, submarinoDestruido;
		portaAviaoDestruido = detroyerDestruido = fragataDestruido = torpedeiroDestruido = submarinoDestruido = false;
		
		// Garantir que a coordenada obede�a ao formato 01 n�mero[0-9] + 01 letra[A-J].
		do {
			
			coordenada = console.cursor("Escolha a coordenada onde linha [0-9] e coluna [A-J]");
			
			// Consist�ncia: o tamanho da String deve ser de dois caracteres.
			if(coordenada.length() != 2) {
				
				console.imprimir("Valor inv�lido para coordenada.");
				continue;
				
			}
			
			// Obter a 1� parte da coordenada.
			coordLinha = String.valueOf(coordenada.charAt(0));
			
			// Obter a 2� parte da coordenada tratando o valor para CAIXA ALTA (para reduzir n�mero de testes)			
			coordColuna = String.valueOf(coordenada.charAt(1)).toUpperCase();

			// Devolvovemos a coordenda com o 2� informa��o tratada.
			coordenada = coordLinha + coordColuna;
			
			// Consist�ncia: A coordenada j� foi utilizada?
			if(tabuleiro.verificarCoordenadaUtilizada(coordenada)) {
				
				console.imprimir("A coordenada " + coordenada + " j� foi utilizada por favor escolha outra.");
				continue;
				
			}

			// Validar o dado da 1� parte da coordenada.
			if(!coordLinha.equals("0") &&
				!coordLinha.equals("1") &&
				!coordLinha.equals("2") &&
				!coordLinha.equals("3") &&
				!coordLinha.equals("4") &&
				!coordLinha.equals("5") &&
				!coordLinha.equals("6") &&
				!coordLinha.equals("7") &&
				!coordLinha.equals("8") &&
				!coordLinha.equals("9")) {
				
				console.imprimir("Valor inv�lido para coordenada.");
				continue;
				
			}
				
			// Validar o dado da 2� parte da coordenada.
			if(!coordColuna.equals("A") &&
				!coordColuna.equals("B") &&
				!coordColuna.equals("C") &&
				!coordColuna.equals("D") &&
				!coordColuna.equals("E") &&
				!coordColuna.equals("F") &&
				!coordColuna.equals("G") &&
				!coordColuna.equals("H") &&
				!coordColuna.equals("I") &&
				!coordColuna.equals("J")) {
				
				console.imprimir("Valor inv�lido para coordenada.");
				continue;
				
			}
			
			// Se est� tudo OK com a coordenada, prossegue a aplica��o, sai do la�o.
			break;

		} while(true);
		
		// Envia as coordenadas escolhidas pelo jogador para o tabuleiro.
		tabuleiro.receberCoordenadaNavio(coordenada);
		
		// Se qualquer parte do Porta Avi�es foi atingida.
		if(tabuleiro.getPortaAviao().getPosPart1().equals("") ||
		   tabuleiro.getPortaAviao().getPosPart2().equals("") ||
		   tabuleiro.getPortaAviao().getPosPart3().equals("") ||
		   tabuleiro.getPortaAviao().getPosPart4().equals("") ||
		   tabuleiro.getPortaAviao().getPosPart5().equals("")) {
			 
			placar.setPontuacao(placar.getPontuacao() + 3);
			infoTorpedo = "Porta avi�es atingido";
			
		}
		
		// Se qualquer parte do Destroyer foi atingida.
		if(tabuleiro.getDestroyer().getPosPart1().equals("") ||
		   tabuleiro.getDestroyer().getPosPart2().equals("") ||
		   tabuleiro.getDestroyer().getPosPart3().equals("") ||
		   tabuleiro.getDestroyer().getPosPart4().equals("")) {
			
			placar.setPontuacao(placar.getPontuacao() + 3);
			infoTorpedo = "Destroyer atingido";
			
		}
		
		// Se qualquer parte da Fragata foi atingida.
		if(tabuleiro.getFragata().getPosPart1().equals("") ||
     	   tabuleiro.getFragata().getPosPart2().equals("") ||
		   tabuleiro.getFragata().getPosPart3().equals("")) {
			
			placar.setPontuacao(placar.getPontuacao() + 3);
			infoTorpedo = "Fragata atingida";
			
		}
		
		// Se qualquer parte do Torpedeiro foi atingida.
		if(tabuleiro.getTorpedeiro().getPosPart1().equals("") ||
		   tabuleiro.getTorpedeiro().getPosPart1().equals("")) {
			
			placar.setPontuacao(placar.getPontuacao() + 3);
			infoTorpedo = "Fragata atingida";
			
		}
		
		
		// Se todo o Porta Avi�es foi destruido.
		if(tabuleiro.getPortaAviao().getPosPart1().equals("") &&
		   tabuleiro.getPortaAviao().getPosPart2().equals("") &&
		   tabuleiro.getPortaAviao().getPosPart3().equals("") &&
		   tabuleiro.getPortaAviao().getPosPart4().equals("") &&
		   tabuleiro.getPortaAviao().getPosPart5().equals("")) {
			
			placar.setPontuacao(placar.getPontuacao() + 5);
			portaAviaoDestruido = true;
			infoTorpedo = "Porta Avi�es foi destru�do";
			
		}
		
		// Se todo o Destroyer foi destruido.
		if(tabuleiro.getDestroyer().getPosPart1().equals("") &&
		   tabuleiro.getDestroyer().getPosPart2().equals("") &&
		   tabuleiro.getDestroyer().getPosPart3().equals("") &&
		   tabuleiro.getDestroyer().getPosPart4().equals("")) {
			
			placar.setPontuacao(placar.getPontuacao() + 5);
			detroyerDestruido = true;
			infoTorpedo = "Destroyer foi destru�do";
			
		}
		
		// Se toda a Fragata foi destruida.
		if(tabuleiro.getFragata().getPosPart1().equals("") &&
		   tabuleiro.getFragata().getPosPart2().equals("") &&
		   tabuleiro.getFragata().getPosPart3().equals("")) {
			
			placar.setPontuacao(placar.getPontuacao() + 5);
			fragataDestruido = true;
			infoTorpedo = "Fragata foi destru�da";
			
		}
		
		// Se todo o Torpedeiro foi destruido.
		if(tabuleiro.getTorpedeiro().getPosPart1().equals("") &&
		   tabuleiro.getTorpedeiro().getPosPart2().equals("")) {
			
			placar.setPontuacao(placar.getPontuacao() + 5);
			torpedeiroDestruido = true;
			infoTorpedo = "Torpedeiro foi destru�do";
			
		}
		
		
		// Se o Submarino foi destruido.
		if(tabuleiro.getSubmarino().getPosPart1().equals("")) {
			
			placar.setPontuacao(placar.getPontuacao() + 5);
			submarinoDestruido = true;
			infoTorpedo = "Submarino foi destru�do";
		}
		
		// Perde um ponto a cada disparo.
		placar.setPontuacao(placar.getPontuacao() - 1);
		
		console.imprimir("Torpedo disparado na coordenada " + coordenada + ": " + (infoTorpedo.equals("") ? "O torpedo foi pela �gua." : infoTorpedo)  + ".\n");
		
		// Todos os navios foram destruidos?
		if(portaAviaoDestruido && detroyerDestruido && fragataDestruido && torpedeiroDestruido && submarinoDestruido) {
			
			console.imprimir("Voc� venceu o jogo.");
			this.finalizar();
			
			// O placar est� zerado?
		} else if(placar.getPontuacao() == 0) {
			
			console.imprimir("Voc� perdeu o jogo.");
			this.finalizar();
			
		}
		
	}
	
}
