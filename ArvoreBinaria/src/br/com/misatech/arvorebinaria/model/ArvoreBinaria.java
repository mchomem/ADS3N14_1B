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

	private No<T>  raiz;
	private String elemento;
	private long comparacao;
	private long qtNo;
	
	/**
	 * Construtor padr�o da classe.
	 */
	public ArvoreBinaria() {
		
		this.inicializaElemento();
		
	}
	
	/**
	 * Inser��o pela 1� vez.
	 * @param novo O 1� n� a ser inserido na �rvore.
	 */
	public void inserir(No<T> novo) {
		
		novo.setGalhoEsquerda(raiz);
		novo.setGalhoDireita(raiz);
		
		raiz = novo;
		this.qtNo++;
		
	}
	
	// Id�ia da http://pt.wikipedia.org/wiki/%C3%81rvore_bin%C3%A1ria
	// mais a id�ia do Jeffmann de usar o compareTo	
	/**
	 * Inser��o de elemento com elemento j� existente.
	 * 
	 * @param novo O novo n� de elemento.
	 * @param anterior O n� anterior que ser� guardado para a inser��o.
	 * @return Um tipo n�
	 */
	public No<T> inserir(No<T> novo, No<T> anterior) {
		
		int cmp = 0;

		// Existe o n� anterior?
		if(anterior != null) {
			
			// Compara a nova inser��o com a �ltima inser��o.
			cmp = novo.getContato().getNome().compareTo(anterior.getContato().getNome());
			
			// Se o valor � menor?
			if(cmp < 0) {
				anterior.setGalhoEsquerda(this.inserir(novo, anterior.getGalhoEsquerda()));
			} else {
				// Se � menor?
				if(cmp > 0) {
					anterior.setGalhoDireita(this.inserir(novo, anterior.getGalhoDireita()));
				} else {
					return null;
				}
			}
		} else {
			anterior = novo;
		}
		return anterior;
		
	}
	
	/**
	 * Insere um elemento baseado na implementa��o de �rvorne bin�ria de pesquisa/busca.
	 * 
	 * @param novo O novo n� que est� entrando na �rvore.
	 * @param atual O n� atual para inciar a compara��o.
	 */
	public void inserirFormaBST(No<T> novo, No<T> atual) {
		
		int cmp = 0;
		// Comparar os nomes do novo n� com o n� atual (j� existente).
		cmp = novo.getContato().getNome().compareTo(atual.getContato().getNome());
		
		// � menor?
		if(cmp < 0) {
			
			// O n� atual tem algum n� no galho a esquerda?
			if(atual.getGalhoEsquerda() != null) {
				
				/* Chamaa o m�todo recursivamente passando o novo n� e o
				 * galho esquerdo do n� atual para fazer a compara��o de
				 * valores do novo n� com o n� do galho esquerdo do n� atual. */  
				this.inserirFormaBST(novo, atual.getGalhoEsquerda());
				
				// Se n�o houver galho a esquerda
			} else {

				// Insere o novo n� a esquerda do n� atual.
				atual.setGalhoEsquerda(novo);
				this.qtNo++;
				
			}
			
		// � maior?
		} else if(cmp > 0) {
			
			// O n� atual tem algum n� no galho a direita?
			if(atual.getGalhoDireita() != null) {
				
				/* Chamaa o m�todo recursivamente passando o novo n� e o
				 * galho direito do n� atual para fazer a compara��o de
				 * valores do novo n� com o n� do galho direito do n� atual. */
				this.inserirFormaBST(novo, atual.getGalhoDireita());
				
				// Se n�o houver galho a direita
			} else {
				
				// Insere o novo n� a direita do n� atual.
				atual.setGalhoDireita(novo);
				this.qtNo++;
				
			}
		}
		
	}
	
	// Exclus�o utilizando a id�ia do link http://pt.wikipedia.org/wiki/%C3%81rvore_bin%C3%A1ria_de_busca
	// REVISAR!!! -> fez apenas um dos cen�rios de exclus�o (n� com um filho)
	public void excluir(No<T> atual, No<T> anterior ,String nome) {
		
		int cmp = 0;
		
		// Existe n� na �rvore?
		if(atual != null) {
			
			cmp = nome.compareTo(atual.getContato().getNome());

			// Valor para exclus�o foi localizado?
			if(cmp == 0) {
				
				// O n� � folha (n�o tem galhos)?
				if(atual.getGalhoEsquerda() == null && atual.getGalhoDireita() == null) {
					
					// Eliminar a refer�ncia do galho (esquerda ou direita) do n� anterior a este.
					if(anterior.getGalhoEsquerda() != null) {
						// O n� anterior aponta para o n� a ser excluido pelo galho da esquerda?
						if(anterior.getGalhoEsquerda().getContato().getNome().equals(nome)) {
							anterior.setGalhoEsquerda(null);
						}
					}
					
					if(anterior.getGalhoDireita() != null) {
						// O n� anterior aponta para o n� a ser excluido pelo galho da direita?
						if(anterior.getGalhoDireita().getContato().getNome().equals(nome)) {
							anterior.setGalhoDireita(null);
						}
					}
					
					// Elimina o n�.
					atual = null;
					return;
					
				}
				
				// O n� tem um filho a esquerda?
				if(atual.getGalhoEsquerda() != null && atual.getGalhoDireita() == null) {
					
					// Alterar a refer�ncia do galho (esquerda ou direita) do n� anterior a este.
					if(anterior.getGalhoEsquerda() != null) {
						// O n� anterior aponta para o n� a ser excluido pelo galho da esquerda?
						if(anterior.getGalhoEsquerda().getContato().getNome().equals(nome)) {
							anterior.setGalhoEsquerda(atual.getGalhoEsquerda());
						}
					}
					
					if(anterior.getGalhoDireita() != null) {
						// O n� anterior aponta para o n� a ser excluido pelo galho da direita?
						if(anterior.getGalhoDireita().getContato().getNome().equals(nome)) {
							anterior.setGalhoDireita(atual.getGalhoEsquerda());
						}
					}
					
					// Elimina o n�.
					atual = null;
					this.elemento = "Registro exclu�do";
					return;
					
				}
				
				// O n� tem um filho a direita?
				if(atual.getGalhoEsquerda() == null && atual.getGalhoDireita() != null) {
					
					// Alterar a refer�ncia do galho (esquerda ou direita) do n� anterior a este.
					if(anterior.getGalhoEsquerda() != null) {
						// O n� anterior aponta para o n� a ser excluido pelo galho da esquerda?
						if(anterior.getGalhoEsquerda().getContato().getNome().equals(nome)) {
							anterior.setGalhoEsquerda(atual.getGalhoDireita());
						}
					}
					
					if(anterior.getGalhoDireita() != null) {
						// O n� anterior aponta para o n� a ser excluido pelo galho da direita?
						if(anterior.getGalhoDireita().getContato().getNome().equals(nome)) {
							anterior.setGalhoDireita(atual.getGalhoDireita());
						}
					}
					
					// Elimina o n�.
					atual = null;
					this.elemento = "Registro exclu�do";
					return;
					
				}
				
				// O n� tem dois filhos?
				if(atual.getGalhoEsquerda() != null && atual.getGalhoDireita() != null) {
					
					
					
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
	
	public void consultar(No<T> atual, String nome) {

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
	 * @param no O n� inicial da �rvore.
	 */
	public void inFixa(No<T> no) {
		 
		if(no != null) {
	    	 
			inFixa(no.getGalhoEsquerda());
	    	this.elemento += no.getContato().getNome() + " " +  no.getContato().getNumero() + "\n";
	        inFixa(no.getGalhoDireita());
	         
		}
	     
	}

	/**
	 * Travessia pr�-fixada.
	 * @param no O n� inicial da �rvore.
	 */
	public void preFixa(No<T> no) {
		 
	    if(no != null) {
	    	 
	    	this.elemento += no.getContato().getNome() + " " +  no.getContato().getNumero() + "\n";
	        preFixa(no.getGalhoEsquerda());
	        preFixa(no.getGalhoDireita());
	         
	    }
	     
	}
	
	/**
	 * Travessia p�s-fixada.
	 * @param no O n� inicial da �rvore.
	 */
	public void posFixa(No<T> no) {
		 
	    if(no != null) {
	    	 
	        posFixa(no.getGalhoEsquerda());
	        posFixa(no.getGalhoDireita());
	        this.elemento += no.getContato().getNome() + " " +  no.getContato().getNumero() + "\n";
	         
	    }
	     
	}

	// Getters e Setters
	public No<T> getRaiz() {
		return raiz;
	}
	
	public void setRaiz(No<T> raiz) {
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

	public void setQtNo(long qtNo) {
		this.qtNo = qtNo;
	}
	
}
