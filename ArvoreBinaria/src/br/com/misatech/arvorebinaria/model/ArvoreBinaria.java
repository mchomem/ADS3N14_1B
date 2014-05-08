package br.com.misatech.arvorebinaria.model;

/**
 * Implementa��o da �rvore bin�ria com suas opera��es.
 * 
 * @author Misael C. Homem
 * @since 1.00
 *
 * @param <T>
 */
public class ArvoreBinaria<T extends Comparable<T>> {

	private No  raiz;
	private String elemento;
	private long   comparacao;
	private long   qtNo;
	private long   altura;
	
	/**
	 * Construtor padr�o da classe.
	 */
	public ArvoreBinaria() {
		
		this.inicializaElemento();
		
	}
	
	/**
	 * Inser��o pela 1� vez.
	 * 
	 * @param novo O 1� n� a ser inserido na �rvore.
	 */
	public void inserir(No novo) {
		
		// Define o galho a esquerda e a direita do novo elemento.
		novo.setGalhoEsquerda(raiz);
		novo.setGalhoDireita(raiz);
		
		// A raiz da �rvore ir� receber o 1� n�. 
		raiz = novo;
		// A raiz n�o possui n� pai.
		raiz.setPai(null);
		// Contabiliza o n�.
		this.qtNo++;
		
	}

	/**
	 * Inser��o pela 2� vez. Insere um elemento baseado na implementa��o de �rvorne bin�ria de pesquisa/busca.
	 * 
	 * @param novo O novo n� que est� entrando na �rvore.
	 * @param atual O n� atual para inciar a compara��o.
	 */
	public void inserirFormaBST(No novo, No atual) {
		
		int cmp = 0;
		// Comparar os nomes do novo n� com o n� atual (j� existente na �rvore bin�ria).
		cmp = novo.getContato().getNome().compareTo(atual.getContato().getNome());
		
		// � menor?
		if(cmp < 0) {
			
			// O n� atual tem algum n� no galho a esquerda?
			if(atual.getGalhoEsquerda() != null) {
				
				/* Chama o m�todo recursivamente passando o novo n� e o
				 * galho esquerdo do n� atual para fazer a compara��o de
				 * valores do novo n� com o n� do galho esquerdo do n� atual. */  
				this.inserirFormaBST(novo, atual.getGalhoEsquerda());
				
				// Se n�o houver galho a esquerda
			} else {

				// Insere o novo n� a esquerda do n� atual.
				atual.setGalhoEsquerda(novo);
				// Configura o pai do novo n�.
				novo.setPai(atual);
				// Configura o nivel do n� obtendo o n�vel do pai mais um.
				novo.setNivel(atual.getNivel() + 1);
				// Contabiliza o n�.
				this.qtNo++;
				// Obt�m a altura do n� raiz em rela��o ao novo n� inserido.
				this.altura = novo.getNivel();
				// Informando estado do elemento.
				this.elemento = "Contato inserido";
				
			}
			
		// � maior?
		} else if(cmp > 0) {
			
			// O n� atual tem algum n� no galho a direita?
			if(atual.getGalhoDireita() != null) {
				
				/* Chama o m�todo recursivamente passando o novo n� e o
				 * galho direito do n� atual para fazer a compara��o de
				 * valores do novo n� com o n� do galho direito do n� atual. */
				this.inserirFormaBST(novo, atual.getGalhoDireita());
				
				// Se n�o houver galho a direita
			} else {
				
				// Insere o novo n� a direita do n� atual.
				atual.setGalhoDireita(novo);
				// Configura o pai do novo n�.
				novo.setPai(atual);
				// Configura o nivel do n� obtendo o n�vel do pai mais um.
				novo.setNivel(atual.getNivel() + 1);
				// Contabiliza o n�.
				this.qtNo++;
				// Obt�m a altura do n� raiz em rela��o ao novo n� inserido.
				this.altura = novo.getNivel();
				// Informando estado do elemento.
				this.elemento = "Contato inserido";
				
			}
			
		// Se for igual? N�o deixa inserir (na �rvore bin�ria de pesquisa n�o pode haver valores iguais).
		// OBS: aten��o para os seguintes casos: Palavra e palavra, pois o compareTo distingue a caixa alta da baixa.
		} else if(cmp == 0) {
			
			// Informando estado do elemento.
			this.elemento = "J� existe contato com este nome.";
			return;
			
		}
		
	}
	
	/**
	 * Exclui um n� da �rvore, adimitindo os cen�rios: n� folha, n� com um fiho e n� com dois filhos.<br>
	 * Utilizando a id�ia do link http://pt.wikipedia.org/wiki/%C3%81rvore_bin%C3%A1ria_de_busca
	 * 
	 * @param atual O n� a ser excluido onde ser� comparado o seu valor para ser exclu�do da �rvore bin�ria.
	 * @param anterior O n� anterior ao n� atual.
	 * @param nome O valor do nome pelo qual ser� feita a busca nos n�s da �rvore para exclus�o.
	 */
	public void excluir(No atual, No anterior ,String nome) {
		
		int cmp = 0;
		
		// Existe n� na �rvore?
		if(atual != null) {
			
			cmp = nome.compareTo(atual.getContato().getNome());

			// Valor para exclus�o foi localizado?
			if(cmp == 0) {
				
				// O n� para exclus�o (atual) � folha (n�o tem galhos)?
				if(atual.getGalhoEsquerda() == null && atual.getGalhoDireita() == null) {
					
					// Eliminar a refer�ncia do galho esquerda do n� anterior ao atual.
					if(anterior.getGalhoEsquerda() != null) {
						// O n� anterior aponta para o n� a ser excluido pelo galho da esquerda?
						if(anterior.getGalhoEsquerda().getContato().getNome().equals(nome)) {
							anterior.setGalhoEsquerda(null);
						}
					}
					
					// Eliminar a refer�ncia do galho direita do n� anterior ao atual.
					if(anterior.getGalhoDireita() != null) {
						// O n� anterior aponta para o n� a ser excluido pelo galho da direita?
						if(anterior.getGalhoDireita().getContato().getNome().equals(nome)) {
							anterior.setGalhoDireita(null);
						}
					}
					
					// Elimina o n�.
					atual = null;
					this.qtNo--;
					this.elemento = "Registro exclu�do";
					return;
					
				}
				
				
				/* Duas situa��es para n� de exclus�o ter filho a esquerda:
				 * Legenda: A - n� anterior
				 *          E - n� de exlus�o
				 *          F - n� filho
				 *
				 *
				 *       A
				 *      /
				 *     E
				 *    /
				 *   F
				 *
				 *       A
				 *        \
				 *         E
				 *        /
				 *       F
				 */
				// O n� de exclus�o (atual) tem um filho a esquerda?
				if(atual.getGalhoEsquerda() != null && atual.getGalhoDireita() == null) {
					
					// Alterar a refer�ncia do galho esquerda do n� anterior ao atual.
					if(anterior.getGalhoEsquerda() != null) {
						// O n� anterior aponta para o n� a ser excluido pelo galho da esquerda?
						if(anterior.getGalhoEsquerda().getContato().getNome().equals(nome)) {
							// O n� anteior recebe o n� filho do n� atual.
							anterior.setGalhoEsquerda(atual.getGalhoEsquerda());
							// O n� filho recebe o n�vel do n� aterior mais 1.
							atual.getGalhoEsquerda().setNivel(anterior.getNivel() + 1);
							// Configura o pai do n� filho.
							atual.getGalhoEsquerda().setPai(anterior);
						}
					}
					
					// Alterar a refer�ncia do galho direita do n� anterior ao atual.
					if(anterior.getGalhoDireita() != null) {
						// O n� anterior aponta para o n� a ser excluido pelo galho da direita?
						if(anterior.getGalhoDireita().getContato().getNome().equals(nome)) {
							// O n� anteior recebe o n� filho do n� atual.
							anterior.setGalhoDireita(atual.getGalhoEsquerda());
							// O n� filho recebe o n�vel do n� aterior mais 1.
							atual.getGalhoEsquerda().setNivel(anterior.getNivel() + 1);
							// Configura o pai do n� filho.
							atual.getGalhoEsquerda().setPai(anterior);
						}
					}
					
					// Elimina o n�.
					atual = null;
					this.qtNo--;
					this.elemento = "Registro exclu�do";
					return;
					
				}
				
				
				/* Duas situa��es para n� de exclus�o ter filho a direita:
				 *  Legenda: A - n� anterior
				 *           E - n� de exlus�o
				 *           F - n� filho
				 *
				 *
				 *        A
				 *         \
				 *          E
				 *           \
				 *            F
				 *    
				 *          A
				 *         /
				 *        E
				 *         \
				 *          F
				 */
				// O n� de exclus�o (atual) tem um filho a direita?
				if(atual.getGalhoEsquerda() == null && atual.getGalhoDireita() != null) {
					
					// Alterar a refer�ncia do galho esquerda do n� anterior ao atual.
					if(anterior.getGalhoEsquerda() != null) {
						// O n� anterior aponta para o n� a ser excluido pelo galho da esquerda?
						if(anterior.getGalhoEsquerda().getContato().getNome().equals(nome)) {
							// O n� anteior recebe o n� filho do n� atual.
							anterior.setGalhoEsquerda(atual.getGalhoDireita());
							// O n� filho recebe o n�vel do n� aterior mais 1.
							atual.getGalhoDireita().setNivel(anterior.getNivel() + 1);
							// Configura o pai do n� filho.
							atual.getGalhoDireita().setPai(anterior);
						}
					}
					
					// Alterar a refer�ncia do galho direita do n� anterior ao atual.
					if(anterior.getGalhoDireita() != null) {
						// O n� anterior aponta para o n� a ser excluido pelo galho da direita?
						if(anterior.getGalhoDireita().getContato().getNome().equals(nome)) {
							// O n� anteior recebe o n� filho do n� atual.
							anterior.setGalhoDireita(atual.getGalhoDireita());
							// O n� filho recebe o n�vel do n� aterior mais 1.
							atual.getGalhoDireita().setNivel(anterior.getNivel() + 1);
							// Configura o pai do n� filho.
							atual.getGalhoDireita().setPai(anterior);
						}
					}
					
					// Elimina o n�.
					atual = null;
					this.qtNo--;
					this.elemento = "Registro exclu�do";
					return;
					
				}
				
				// O n� tem dois filhos?
				if(atual.getGalhoEsquerda() != null && atual.getGalhoDireita() != null) {
					
					// Por implementar.
					
				}
				
			} else if(cmp < 0) {
				
				this.excluir(atual.getGalhoEsquerda(), atual, nome);
				
			} else {
				
				this.excluir(atual.getGalhoDireita(), atual, nome);
				
			}
			
		} else {
			
			this.elemento = "Valor n�o localizado.";
			
		}
		
		
	}
	
	public void consultar(No atual, String nome) {

		int cmp = 0;
		
		// Existe n� na �rvore bin�ria?
		if(atual != null) {
			
			// Comparar o valor(nome) informado pelo usu�rio com o valor do n� atual.
			cmp = nome.compareTo(atual.getContato().getNome());
			this.comparacao++;
			
			// O valor(nome) da consulta � igual ao valor no n�?
			if(cmp == 0) {
				
				this.elemento = atual.getContato().getNome() + " " + atual.getContato().getNumero();
				
			// O valor � menor?
			} else if(cmp < 0) {
				
				this.consultar(atual.getGalhoEsquerda(), nome);
				
			// O valor � maior?
			} else {
				
				this.consultar(atual.getGalhoDireita(), nome);
				
			}
			
		} else {
			
			this.elemento = "Valor n�o localizado.";
			this.comparacao = 0;
			
		}
		
	}
	
	/**
	 * Inicializa o valor do elemento.
	 */
	public void inicializaElemento() {
		
		this.elemento = "";
		
	}
	
	/**
	 * Travessia in-fixada.<br><br>Observa��o: se a inser��o de n�s na �rvore, foi uma inser��o respeitando a regra de �rvore bin�ria de pesquisa<br>
	 * o resultado desse m�todo � imprimir todos os elementos de forma ordenada.
	 * 
	 * @param no O n� raiz da �rvore.
	 */
	public void inFixa(No no) {
		 
		if(no != null) {
	    	 
			this.inFixa(no.getGalhoEsquerda());
	    	this.elemento += no.getContato().getNome() + " " +  no.getContato().getNumero() + "\n";
	    	this.inFixa(no.getGalhoDireita());
	    	
		}
		
	}

	/**
	 * Travessia pr�-fixada.
	 * @param no O n� raiz da �rvore.
	 */
	public void preFixa(No no) {
		
	    if(no != null) {
	    	
	    	this.elemento += no.getContato().getNome() + " " +  no.getContato().getNumero() + "\n";
	    	this.preFixa(no.getGalhoEsquerda());
	    	this.preFixa(no.getGalhoDireita());
	    	
	    }
	    
	}
	
	/**
	 * Travessia p�s-fixada.
	 * @param no O n� raiz da �rvore.
	 */
	public void posFixa(No no) {
		
	    if(no != null) {
	    	
	    	this.posFixa(no.getGalhoEsquerda());
	    	this.posFixa(no.getGalhoDireita());
	        this.elemento += no.getContato().getNome() + " " +  no.getContato().getNumero() + "\n";
	        
	    }
	    
	}
	
	/**
	 * Obt�m os dados da �rvore bin�ria utlizando a travessia pr�-fixa e formata para arquivo de texto.
	 * 
	 * @param no O n� raiz da �rvore.
	 */
	public void formatarDadosArquivo(No no) {
		
		if(no != null ) {
			
			this.elemento += no.getContato().getNome() + "|" +  no.getContato().getNumero() + "\n";
			this.formatarDadosArquivo(no.getGalhoEsquerda());
			this.formatarDadosArquivo(no.getGalhoDireita());
			
		}
		
	}
	
	public void consultarTudoSobreNo(No no) {
		
		if(no != null) {
	    	 
			this.consultarTudoSobreNo(no.getGalhoEsquerda());
	    	this.elemento += "No.Contato.Nome: " + no.getContato().getNome() + "\n"
	    			+ "No.Contato.N�mero: " + no.getContato().getNumero() + "\n"
	    			+ "No.N�vel: " + no.getNivel() + "\n"
	    			+ "No.Pai: " + ((no.getPai() != null) ? no.getPai().getContato().getNome() : "N�o tem pai pois � raiz.") + "\n"
	    			+ "No.Qt. filhos: " + ((no.getGalhoDireita() != null && no.getGalhoEsquerda() != null) ? "2" : (no.getGalhoDireita() != null || no.getGalhoEsquerda() != null) ? "1" : "0"  ) + "\n\n";
	    	this.consultarTudoSobreNo(no.getGalhoDireita());
	    	
		}
		
	}

	// Getters e Setters
	public No getRaiz() {
		return raiz;
	}
	
	public void setRaiz(No raiz) {
		this.raiz = raiz;
	}
	
	public String getElemento() {
		return elemento;		
	}

	public long getComparacao() {
		return comparacao;
	}

	public void setComparacao(long comparacao) {
		this.comparacao = comparacao;
	}

	public long getQtNo() {
		return qtNo;
	}

	public long getAltura() {
		return altura;
	}
	
}
