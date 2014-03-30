package br.com.misatech.batalhanaval.model;

/**
 * Representação do tabuleiro da batalha naval utilizando uma matriz de Strings 10 x 10..
 * 
 * @author Misael C. Homem
 * @since 1.00
 *
 */
public class Tabuleiro {
	
	private String[][]  tabCoord;
	private PortaAviao  portaAviao;
	private Destroyer   destroyer;
	private Fragata     fragata;
	private Torpedeiro  torpedeiro;
	private Submarino   submarino;
	
	/**
	 * Construtor padrão.
	 */
	public Tabuleiro() {
		
		tabCoord   = new String[10][10];
		portaAviao = new PortaAviao();
		destroyer  = new Destroyer();
		fragata    = new Fragata();
		torpedeiro = new Torpedeiro();
		submarino  = new Submarino();
		
	}
	
	/**
	 * Incia o tabuleiro preenchendo cada índice da matriz com pontos.
	 */
	public void iniciar() {
		
		for(int c = 0; c < tabCoord.length ; c++) {
			for(int l = 0; l < tabCoord[c].length ; l++) {
				tabCoord[c][l] = ".\t";
			}
		}
		
	}
	
	/**
	 * Imprime a matriz já formatando-a devidamente.
	 * 
	 * @return Uma String representando o contéudo da matriz.
	 */
	public String imprimir() {
		
		String tabuleiro = "";
		// Para imprimir a localização da linha.
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
		
		// Imprimindo a localização da coluna.
		tabuleiro += "A\tB\tC\tD\tE\tF\tG\tH\tI\tJ\n";
		return tabuleiro;
		
	}
	
	/**
	 * Recebe a coordenada informada pelo usuário.
	 * @param coordenada A coordenada no formato número mais letra.
	 */
	public void receberCoordenadaNavio(String coordenada) {
		
		int cordLinha = Integer.valueOf(String.valueOf(coordenada.charAt(0)));
		int cordColuna = 0;
		
		// Traduzir a coordenada recebida nos indices da matriz
		// Fazer um de-para no 2º caractere da coordenada:
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
		
		// Atingiu a 1º parte do porta aviões ?
		if(coordenada.equals(portaAviao.getPosPart1())) {
			
			// Marca na coordena do tabuleiro uma explosão.
			tabCoord[cordLinha][cordColuna] = "O\t";
			
			// "Elimina" a coordenada do navio.
			portaAviao.setPosPart1("");
			return;
			
		}
		
		// Atingiu a 2º parte do porta aviões ?
		if(coordenada.equals(portaAviao.getPosPart2())) {
			
			// Marca na coordena do tabuleiro uma explosão.
			tabCoord[cordLinha][cordColuna] = "O\t";
			
			// "Elimina" a coordenada do navio.
			portaAviao.setPosPart1("");
			return;
			
		}
		
		// Atingiu a 3º parte do porta aviões ?
		if(coordenada.equals(portaAviao.getPosPart3())) {
			
			// Marca na coordena do tabuleiro uma explosão.
			tabCoord[cordLinha][cordColuna] = "O\t";
			
			// "Elimina" a coordenada do navio.
			portaAviao.setPosPart1("");
			return;
			
		}
		
		// Atingiu a 4º parte do porta aviões ?
		if(coordenada.equals(portaAviao.getPosPart4())) {
			
			// Marca na coordena do tabuleiro uma explosão.
			tabCoord[cordLinha][cordColuna] = "O\t";
			
			// "Elimina" a coordenada do navio.
			portaAviao.setPosPart1("");
			return;
			
		}
		
		// Atingiu a 5º parte do porta aviões ?
		if(coordenada.equals(portaAviao.getPosPart5())) {
			
			// Marca na coordena do tabuleiro uma explosão.
			tabCoord[cordLinha][cordColuna] = "O\t";
			
			// "Elimina" a coordenada do navio.
			portaAviao.setPosPart1("");
			return;
			
		}
		
		
		// Atingiu a 1º parte do destroyer ?
		if(coordenada.equals(destroyer.getPosPart1())) {
			
			// Marca na coordena do tabuleiro uma explosão.
			tabCoord[cordLinha][cordColuna] = "O\t";
			
			// "Elimina" a coordenada do navio.
			destroyer.setPosPart1("");
			return;
			
		}
		
		// Atingiu a 2º parte do destroyer ?
		if(coordenada.equals(destroyer.getPosPart2())) {
			
			// Marca na coordena do tabuleiro uma explosão.
			tabCoord[cordLinha][cordColuna] = "O\t";
			
			// "Elimina" a coordenada do navio.
			destroyer.setPosPart1("");
			return;
			
		}
		
		// Atingiu a 3º parte do destroyer ?
		if(coordenada.equals(destroyer.getPosPart3())) {
			
			// Marca na coordena do tabuleiro uma explosão.
			tabCoord[cordLinha][cordColuna] = "O\t";
			
			// "Elimina" a coordenada do navio.
			destroyer.setPosPart1("");
			return;
			
		}
		
		// Atingiu a 4º parte do destroyer ?
		if(coordenada.equals(destroyer.getPosPart4())) {
			
			// Marca na coordena do tabuleiro uma explosão.
			tabCoord[cordLinha][cordColuna] = "O\t";
			
			// "Elimina" a coordenada do navio.
			destroyer.setPosPart1("");
			return;
			
		}
		
		
		// Atingiu a 1º parte da fragata ?
		if(coordenada.equals(fragata.getPosPart1())) {
			
			// Marca na coordena do tabuleiro uma explosão.
			tabCoord[cordLinha][cordColuna] = "O\t";
			
			// "Elimina" a coordenada do navio.
			fragata.setPosPart1("");
			return;
			
		}
		
		// Atingiu a 2º parte da fragata ?
		if(coordenada.equals(fragata.getPosPart2())) {
			
			// Marca na coordena do tabuleiro uma explosão.
			tabCoord[cordLinha][cordColuna] = "O\t";
			
			// "Elimina" a coordenada do navio.
			fragata.setPosPart1("");
			return;
			
		}
		
		// Atingiu a 3º parte da fragata ?
		if(coordenada.equals(fragata.getPosPart3())) {
			
			// Marca na coordena do tabuleiro uma explosão.
			tabCoord[cordLinha][cordColuna] = "O\t";
			
			// "Elimina" a coordenada do navio.
			fragata.setPosPart1("");
			return;
			
		}
		
		
		// Atingiu a 1º parte da torpedeiro ?
		if(coordenada.equals(torpedeiro.getPosPart1())) {
			
			// Marca na coordena do tabuleiro uma explosão.
			tabCoord[cordLinha][cordColuna] = "O\t";
			
			// "Elimina" a coordenada do navio.
			torpedeiro.setPosPart1("");
			return;
			
		}
		
		// Atingiu a 2º parte da torpedeiro ?
		if(coordenada.equals(torpedeiro.getPosPart2())) {
			
			// Marca na coordena do tabuleiro uma explosão.
			tabCoord[cordLinha][cordColuna] = "O\t";
			
			// "Elimina" a coordenada do navio.
			torpedeiro.setPosPart1("");
			return;
			
		}
		
		// Atingiu o submarino ?
		if(coordenada.equals(submarino.getPosPart1())) {
			
			// Marca na coordena do tabuleiro uma explosão.
			tabCoord[cordLinha][cordColuna] = "O\t";
			
			// "Elimina" a coordenada do navio.
			submarino.setPosPart1("");
			return;
			
		}
		
		// Não atingiu nenhum navio nas coordenadas do tabuleiro.
		tabCoord[cordLinha][cordColuna] = "-\t";
		
	}

	/**
	 * Distribui coordenadas a cada parte dos navios.
	 */
	public void distribuirNavios() {
		
		// Considerar 1º digito a linha e o 2º a coluna.
		
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
		
	}
	
	/**
	 * CHEAT CODE - Esse método serve para revelar as posições dos navios no tabuleiro.
	 */
	public void revelarPosicaoNavios() {
		
		int coordLinha       = 0;
		int coordColuna      = 0;
		String revPortaAviao = "P\t";
		String revDestroyer  = "D\t";
		String revFragata    = "F\t";
		String revTorpedeiro = "T\t";
		String revSubmarino  = "S\t";
		
		// Porta Aviões.
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
