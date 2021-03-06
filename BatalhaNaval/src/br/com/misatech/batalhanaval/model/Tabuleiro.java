package br.com.misatech.batalhanaval.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Representa��o do tabuleiro da batalha naval utilizando uma matriz de Strings 10 x 10..
 * 
 * @author Misael C. Homem
 * @since 1.00
 *
 */
public class Tabuleiro {
	
	private String[][]   tabCoord;
	private PortaAviao   portaAviao;
	private Destroyer    destroyer;
	private Fragata      fragata;
	private Torpedeiro   torpedeiro;
	private Submarino    submarino;
	private List<String> coordenadaUtilizada; 
	
	/**
	 * Construtor padr�o.
	 */
	public Tabuleiro() {
		
		tabCoord            = new String[10][10];
		portaAviao          = new PortaAviao();
		destroyer           = new Destroyer();
		fragata             = new Fragata();
		torpedeiro          = new Torpedeiro();
		submarino           = new Submarino();
		coordenadaUtilizada = new ArrayList<String>();
		
	}
	
	/**
	 * Incia o tabuleiro preenchendo cada �ndice da matriz com pontos.
	 */
	public void iniciar() {
		
		for(int c = 0; c < tabCoord.length ; c++) {
			for(int l = 0; l < tabCoord[c].length ; l++) {
				tabCoord[c][l] = ".\t";
			}
		}
		
	}
	
	/**
	 * Imprime a matriz j� formatando-a devidamente.
	 * 
	 * @return Uma String representando o cont�udo da matriz.
	 */
	public String imprimir() {
		
		String tabuleiro = "";
		// Para imprimir a localiza��o da linha.
		int cordLinha = 0;
		
		// Imprimir a coluna
		for(int c = 0; c < tabCoord.length; c++) {
			
			// Imprimir a linha
			for(int l = 0; l < tabCoord[c].length; l++) {
				tabuleiro += tabCoord[c][l];
			}
			
			tabuleiro += cordLinha + "\n";
			cordLinha++;
			
		}
		
		// Imprimindo a localiza��o da coluna.
		tabuleiro += "A\tB\tC\tD\tE\tF\tG\tH\tI\tJ\n";
		return tabuleiro;
		
	}
	
	
	/**
	 * Verifica se a coordenada j� foi utilizada.
	 * 
	 * @param coordenada A coordenada informada pelo jogador.
	 * @return Retorna true se a coordenada j� foi utilizada e false se ainda n�o foi utilizada.
	 */
	public boolean verificarCoordenadaUtilizada(String coordenada) {
		
		boolean coordUtilizada = false;
		
		// A lista est� vazia?
		if(coordenadaUtilizada.size() == 0) {
			
			// N�o tem elementos para comparar, retorna para o m�todo chamador.
			return coordUtilizada;
			
		}
		
		// Consultar na lista de coordenadas utilizadas, a coordenada informada.
		for(String coord : coordenadaUtilizada) {
			
			// A coordenada informada n�o existe?
			if(!coord.equals(coordenada)) {
				
				coordUtilizada = false;
				
			// Coordenada j� foi usada!
			} else {
				
				coordUtilizada = true;
				
				/* Se a coordenada foi utilizada n�o � mais necess�rio pesquisar na lista.
				 * Deste ponto retornamos para o m�todo chamador. */
				return coordUtilizada;
				
			}
			
		}
		
		return coordUtilizada;
		
	}
	
	
	/**
	 * Inicializa a lista;
	 */
	public void inicializaCoordenadasUtilizadas() {
		
		coordenadaUtilizada.clear();
		
	}
	
	/**
	 * Grava o valor da nova coordenada para se mantar controle do que j� foi utilizado.
	 * 
	 * @param coordenada A coordenada informada pelo usu�rio.
	 */
	private void insereCoordenadaUtilizadaNaLista(String coordenada) {

		// Grava a coordenada utilizada na lista de strings.
		coordenadaUtilizada.add(coordenada);
		
	}

	/**
	 * Recebe a coordenada informada pelo usu�rio.
	 * @param coordenada A coordenada no formato n�mero mais letra.
	 */
	public void receberCoordenadaNavio(String coordenada) {
		
		this.insereCoordenadaUtilizadaNaLista(coordenada);
		
		int cordLinha = Integer.valueOf(String.valueOf(coordenada.charAt(0)));
		int cordColuna = 0;
		
		// Traduzir a coordenada recebida nos indices da matriz
		// Fazer um de-para no 2� caractere da coordenada:
		//
		// A - 0    F - 5
		// B - 1    G - 6
		// C - 2    H - 7
		// D - 3    I - 8
		// E - 4    J - 9
 
		switch (coordenada.charAt(1)) {
		case 'A':
			cordColuna = 0;
			break;
		
		case 'B':
			cordColuna = 1;
			break;
		
		case 'C':
			cordColuna = 2;
			break;
			
		case 'D':
			cordColuna = 3;
			break;
		
		case 'E':
			cordColuna = 4;
			break;
		
		case 'F':
			cordColuna = 5;
			break;
			
		case 'G':
			cordColuna = 6;
			break;
		
		case 'H':
			cordColuna = 7;
			break;
		
		case 'I':
			cordColuna = 8;
			break;
			
		case 'J':
			cordColuna = 9;
			break;
			
		}
		
		coordenada = String.valueOf(cordLinha) + String.valueOf(cordColuna);
		
		// Atingiu a 1� parte do porta avi�es ?
		if(coordenada.equals(portaAviao.getPosPart1())) {
			
			// Marca na coordena do tabuleiro uma explos�o.
			tabCoord[cordLinha][cordColuna] = "O\t";
			
			// "Elimina" a coordenada do navio.
			portaAviao.setPosPart1("");
			return;
			
		}
		
		// Atingiu a 2� parte do porta avi�es ?
		if(coordenada.equals(portaAviao.getPosPart2())) {
			
			// Marca na coordena do tabuleiro uma explos�o.
			tabCoord[cordLinha][cordColuna] = "O\t";
			
			// "Elimina" a coordenada do navio.
			portaAviao.setPosPart1("");
			return;
			
		}
		
		// Atingiu a 3� parte do porta avi�es ?
		if(coordenada.equals(portaAviao.getPosPart3())) {
			
			// Marca na coordena do tabuleiro uma explos�o.
			tabCoord[cordLinha][cordColuna] = "O\t";
			
			// "Elimina" a coordenada do navio.
			portaAviao.setPosPart1("");
			return;
			
		}
		
		// Atingiu a 4� parte do porta avi�es ?
		if(coordenada.equals(portaAviao.getPosPart4())) {
			
			// Marca na coordena do tabuleiro uma explos�o.
			tabCoord[cordLinha][cordColuna] = "O\t";
			
			// "Elimina" a coordenada do navio.
			portaAviao.setPosPart1("");
			return;
			
		}
		
		// Atingiu a 5� parte do porta avi�es ?
		if(coordenada.equals(portaAviao.getPosPart5())) {
			
			// Marca na coordena do tabuleiro uma explos�o.
			tabCoord[cordLinha][cordColuna] = "O\t";
			
			// "Elimina" a coordenada do navio.
			portaAviao.setPosPart1("");
			return;
			
		}
		
		
		// Atingiu a 1� parte do destroyer ?
		if(coordenada.equals(destroyer.getPosPart1())) {
			
			// Marca na coordena do tabuleiro uma explos�o.
			tabCoord[cordLinha][cordColuna] = "O\t";
			
			// "Elimina" a coordenada do navio.
			destroyer.setPosPart1("");
			return;
			
		}
		
		// Atingiu a 2� parte do destroyer ?
		if(coordenada.equals(destroyer.getPosPart2())) {
			
			// Marca na coordena do tabuleiro uma explos�o.
			tabCoord[cordLinha][cordColuna] = "O\t";
			
			// "Elimina" a coordenada do navio.
			destroyer.setPosPart1("");
			return;
			
		}
		
		// Atingiu a 3� parte do destroyer ?
		if(coordenada.equals(destroyer.getPosPart3())) {
			
			// Marca na coordena do tabuleiro uma explos�o.
			tabCoord[cordLinha][cordColuna] = "O\t";
			
			// "Elimina" a coordenada do navio.
			destroyer.setPosPart1("");
			return;
			
		}
		
		// Atingiu a 4� parte do destroyer ?
		if(coordenada.equals(destroyer.getPosPart4())) {
			
			// Marca na coordena do tabuleiro uma explos�o.
			tabCoord[cordLinha][cordColuna] = "O\t";
			
			// "Elimina" a coordenada do navio.
			destroyer.setPosPart1("");
			return;
			
		}
		
		
		// Atingiu a 1� parte da fragata ?
		if(coordenada.equals(fragata.getPosPart1())) {
			
			// Marca na coordena do tabuleiro uma explos�o.
			tabCoord[cordLinha][cordColuna] = "O\t";
			
			// "Elimina" a coordenada do navio.
			fragata.setPosPart1("");
			return;
			
		}
		
		// Atingiu a 2� parte da fragata ?
		if(coordenada.equals(fragata.getPosPart2())) {
			
			// Marca na coordena do tabuleiro uma explos�o.
			tabCoord[cordLinha][cordColuna] = "O\t";
			
			// "Elimina" a coordenada do navio.
			fragata.setPosPart1("");
			return;
			
		}
		
		// Atingiu a 3� parte da fragata ?
		if(coordenada.equals(fragata.getPosPart3())) {
			
			// Marca na coordena do tabuleiro uma explos�o.
			tabCoord[cordLinha][cordColuna] = "O\t";
			
			// "Elimina" a coordenada do navio.
			fragata.setPosPart1("");
			return;
			
		}
		
		
		// Atingiu a 1� parte da torpedeiro ?
		if(coordenada.equals(torpedeiro.getPosPart1())) {
			
			// Marca na coordena do tabuleiro uma explos�o.
			tabCoord[cordLinha][cordColuna] = "O\t";
			
			// "Elimina" a coordenada do navio.
			torpedeiro.setPosPart1("");
			return;
			
		}
		
		// Atingiu a 2� parte da torpedeiro ?
		if(coordenada.equals(torpedeiro.getPosPart2())) {
			
			// Marca na coordena do tabuleiro uma explos�o.
			tabCoord[cordLinha][cordColuna] = "O\t";
			
			// "Elimina" a coordenada do navio.
			torpedeiro.setPosPart1("");
			return;
			
		}
		
		// Atingiu o submarino ?
		if(coordenada.equals(submarino.getPosPart1())) {
			
			// Marca na coordena do tabuleiro uma explos�o.
			tabCoord[cordLinha][cordColuna] = "O\t";
			
			// "Elimina" a coordenada do navio.
			submarino.setPosPart1("");
			return;
			
		}
		
		// N�o atingiu nenhum navio nas coordenadas do tabuleiro.
		tabCoord[cordLinha][cordColuna] = "-\t";
		
	}

	/**
	 * Distribui coordenadas a cada parte dos navios.
	 */
	public void distribuirNavios() {
		
		// Considerar 1� digito a linha e o 2� a coluna para o valor de coordenada.
		
		// Randomizar posi��es.
		int n = 0;
		Random r = new Random();
		n = r.nextInt(3) + 1; // de 1 a 3;
		
		switch (n) {
		
			case 1:
				// linha x coluna
				portaAviao.setPosPart1("10");
				portaAviao.setPosPart2("20");
				portaAviao.setPosPart3("30");
				portaAviao.setPosPart4("40");
				portaAviao.setPosPart5("50");
				
				destroyer.setPosPart1("38");
				destroyer.setPosPart2("48");
				destroyer.setPosPart3("58");
				destroyer.setPosPart4("68");
				
				fragata.setPosPart1("43");
				fragata.setPosPart2("44");
				fragata.setPosPart3("45");
				
				torpedeiro.setPosPart1("72");
				torpedeiro.setPosPart2("73");
				
				submarino.setPosPart1("14");
				break;
				
			case 2:
				// linha x coluna
				portaAviao.setPosPart1("51");
				portaAviao.setPosPart2("61");
				portaAviao.setPosPart3("71");
				portaAviao.setPosPart4("81");
				portaAviao.setPosPart5("91");
				
				destroyer.setPosPart1("94");
				destroyer.setPosPart2("95");
				destroyer.setPosPart3("96");
				destroyer.setPosPart4("97");
				
				fragata.setPosPart1("19");
				fragata.setPosPart2("29");
				fragata.setPosPart3("39");
				
				torpedeiro.setPosPart1("00");
				torpedeiro.setPosPart2("10");
				
				submarino.setPosPart1("90");
				break;
				
			case 3:
				// linha x coluna
				portaAviao.setPosPart1("00");
				portaAviao.setPosPart2("01");
				portaAviao.setPosPart3("02");
				portaAviao.setPosPart4("03");
				portaAviao.setPosPart5("04");
				
				destroyer.setPosPart1("35");
				destroyer.setPosPart2("45");
				destroyer.setPosPart3("55");
				destroyer.setPosPart4("65");
				
				fragata.setPosPart1("79");
				fragata.setPosPart2("89");
				fragata.setPosPart3("99");
				
				torpedeiro.setPosPart1("52");
				torpedeiro.setPosPart2("53");
				
				submarino.setPosPart1("28");
				break;
	
			default:
				break;
				
		}
		
	}
	
	/**
	 * CHEAT CODE - Esse m�todo serve para revelar as posi��es dos navios no tabuleiro.
	 */
	public void revelarPosicaoNavios() {
		
		int coordLinha       = 0;
		int coordColuna      = 0;
		String revPortaAviao = "P\t";
		String revDestroyer  = "D\t";
		String revFragata    = "F\t";
		String revTorpedeiro = "T\t";
		String revSubmarino  = "S\t";
		
		// Porta Avi�es.
		coordLinha  = Integer.parseInt(String.valueOf(portaAviao.getPosPart1().charAt(0)));
		coordColuna = Integer.parseInt(String.valueOf(portaAviao.getPosPart1().charAt(1)));
		tabCoord[coordLinha][coordColuna] = revPortaAviao;
		
		coordLinha  = Integer.parseInt(String.valueOf(portaAviao.getPosPart2().charAt(0)));
		coordColuna = Integer.parseInt(String.valueOf(portaAviao.getPosPart2().charAt(1)));
		tabCoord[coordLinha][coordColuna] = revPortaAviao;
		
		coordLinha  = Integer.parseInt(String.valueOf(portaAviao.getPosPart3().charAt(0)));
		coordColuna = Integer.parseInt(String.valueOf(portaAviao.getPosPart3().charAt(1)));
		tabCoord[coordLinha][coordColuna] = revPortaAviao;
		
		coordLinha  = Integer.parseInt(String.valueOf(portaAviao.getPosPart4().charAt(0)));
		coordColuna = Integer.parseInt(String.valueOf(portaAviao.getPosPart4().charAt(1)));
		tabCoord[coordLinha][coordColuna] = revPortaAviao;
		
		coordLinha  = Integer.parseInt(String.valueOf(portaAviao.getPosPart5().charAt(0)));
		coordColuna = Integer.parseInt(String.valueOf(portaAviao.getPosPart5().charAt(1)));
		tabCoord[coordLinha][coordColuna] = revPortaAviao;
		
		
		// Destroyer.
		coordLinha  = Integer.parseInt(String.valueOf(destroyer.getPosPart1().charAt(0)));
		coordColuna = Integer.parseInt(String.valueOf(destroyer.getPosPart1().charAt(1)));
		tabCoord[coordLinha][coordColuna] = revDestroyer;
		
		coordLinha  = Integer.parseInt(String.valueOf(destroyer.getPosPart2().charAt(0)));
		coordColuna = Integer.parseInt(String.valueOf(destroyer.getPosPart2().charAt(1)));
		tabCoord[coordLinha][coordColuna] = revDestroyer;
		
		coordLinha  = Integer.parseInt(String.valueOf(destroyer.getPosPart3().charAt(0)));
		coordColuna = Integer.parseInt(String.valueOf(destroyer.getPosPart3().charAt(1)));
		tabCoord[coordLinha][coordColuna] = revDestroyer;
		
		coordLinha  = Integer.parseInt(String.valueOf(destroyer.getPosPart4().charAt(0)));
		coordColuna = Integer.parseInt(String.valueOf(destroyer.getPosPart4().charAt(1)));
		tabCoord[coordLinha][coordColuna] = revDestroyer;
		
		
		// Fragata.
		coordLinha  = Integer.parseInt(String.valueOf(fragata.getPosPart1().charAt(0)));
		coordColuna = Integer.parseInt(String.valueOf(fragata.getPosPart1().charAt(1)));
		tabCoord[coordLinha][coordColuna] = revFragata;
		
		coordLinha  = Integer.parseInt(String.valueOf(fragata.getPosPart2().charAt(0)));
		coordColuna = Integer.parseInt(String.valueOf(fragata.getPosPart2().charAt(1)));
		tabCoord[coordLinha][coordColuna] = revFragata;
		
		coordLinha  = Integer.parseInt(String.valueOf(fragata.getPosPart3().charAt(0)));
		coordColuna = Integer.parseInt(String.valueOf(fragata.getPosPart3().charAt(1)));
		tabCoord[coordLinha][coordColuna] = revFragata;
		
		
		// Torpedeiro.
		coordLinha  = Integer.parseInt(String.valueOf(torpedeiro.getPosPart1().charAt(0)));
		coordColuna = Integer.parseInt(String.valueOf(torpedeiro.getPosPart1().charAt(1)));
		tabCoord[coordLinha][coordColuna] = revTorpedeiro;
		
		coordLinha  = Integer.parseInt(String.valueOf(torpedeiro.getPosPart2().charAt(0)));
		coordColuna = Integer.parseInt(String.valueOf(torpedeiro.getPosPart2().charAt(1)));
		tabCoord[coordLinha][coordColuna] = revTorpedeiro;
		
		
		// Submarino.
		coordLinha  = Integer.parseInt(String.valueOf(submarino.getPosPart1().charAt(0)));
		coordColuna = Integer.parseInt(String.valueOf(submarino.getPosPart1().charAt(1)));
		tabCoord[coordLinha][coordColuna] = revSubmarino;
		
		
	}


	// Getters e Setters.
	public String[][] getTabCoord() {
		return tabCoord;
	}

	public PortaAviao getPortaAviao() {
		return portaAviao;
	}

	public Destroyer getDestroyer() {
		return destroyer;
	}

	public Fragata getFragata() {
		return fragata;
	}

	public Torpedeiro getTorpedeiro() {
		return torpedeiro;
	}

	public Submarino getSubmarino() {
		return submarino;
	}

}
