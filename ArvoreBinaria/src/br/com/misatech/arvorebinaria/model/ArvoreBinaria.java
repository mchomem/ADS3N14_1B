package br.com.misatech.arvorebinaria.model;

/**
 * Implementação da árvore binária com suas operações.
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
	private long altura;
	
	/**
	 * Construtor padrão da classe.
	 */
	public ArvoreBinaria() {
		
		this.inicializaElemento();
		
	}
	
	/**
	 * Inserção pela 1º vez.
	 * 
	 * @param novo O 1º nó a ser inserido na árvore.
	 */
	public void inserir(No<T> novo) {
		
		// Define o galho a esquerda e a direita do novo elemento.
		novo.setGalhoEsquerda(raiz);
		novo.setGalhoDireita(raiz);
		
		// A raiz da árvore irá receber o 1º nó. 
		raiz = novo;
		// Contabiliza o nó.
		this.qtNo++;
		
	}

	/**
	 * Inserção pela 2º vez. Insere um elemento baseado na implementação de árvorne binária de pesquisa/busca.
	 * 
	 * @param novo O novo nó que está entrando na árvore.
	 * @param atual O nó atual para inciar a comparação.
	 */
	public void inserirFormaBST(No<T> novo, No<T> atual) {
		
		int cmp = 0;
		// Comparar os nomes do novo nó com o nó atual (já existente).
		cmp = novo.getContato().getNome().compareTo(atual.getContato().getNome());
		
		// É menor?
		if(cmp < 0) {
			
			// O nó atual tem algum nó no galho a esquerda?
			if(atual.getGalhoEsquerda() != null) {
				
				/* Chama o método recursivamente passando o novo nó e o
				 * galho esquerdo do nó atual para fazer a comparação de
				 * valores do novo nó com o nó do galho esquerdo do nó atual. */  
				this.inserirFormaBST(novo, atual.getGalhoEsquerda());
				
				// Se não houver galho a esquerda
			} else {

				// Insere o novo nó a esquerda do nó atual.
				atual.setGalhoEsquerda(novo);
				// Configura o nivel do nó.
				novo.setNivel(atual.getNivel() + 1);
				// Contabiliza o nó.
				this.qtNo++;
				// Obtém a altura do nôdo raiz em relação ao novo nó inserido.
				this.altura = novo.getNivel();
				// Informando estado do elemento.
				this.elemento = "Contato inserido";
				
			}
			
		// É maior?
		} else if(cmp > 0) {
			
			// O nó atual tem algum nó no galho a direita?
			if(atual.getGalhoDireita() != null) {
				
				/* Chama o método recursivamente passando o novo nó e o
				 * galho direito do nó atual para fazer a comparação de
				 * valores do novo nó com o nó do galho direito do nó atual. */
				this.inserirFormaBST(novo, atual.getGalhoDireita());
				
				// Se não houver galho a direita
			} else {
				
				// Insere o novo nó a direita do nó atual.
				atual.setGalhoDireita(novo);
				// Configura o nivel do nó.
				novo.setNivel(atual.getNivel() + 1);
				// Contabiliza o nó.
				this.qtNo++;
				// Obtém a altura do nôdo raiz em relação ao novo nó inserido.
				this.altura = novo.getNivel();
				// Informando estado do elemento.
				this.elemento = "Contato inserido";
				
			}
			
		// Se for igual? Não deixa inserir (na árvore binária de pesquisa não pode haver valores iguais).
		// OBS: atenção para os seguintes casos: Palavra e palavra, pois o compareTo distingue a caixa alta da baixa.
		} else if(cmp == 0) {
			
			// Informando estado do elemento.
			this.elemento = "Já existe contato com este nome.";
			return;
			
		}
		
	}
	
	// Exclusão utilizando a idéia do link http://pt.wikipedia.org/wiki/%C3%81rvore_bin%C3%A1ria_de_busca
	// Decrementar o nível dos nós na exclusão.
	// REVISAR!!! -> fez apenas um dos cenários de exclusão (nó com um filho)
	public void excluir(No<T> atual, No<T> anterior ,String nome) {
		
		int cmp = 0;
		
		// Existe nó na árvore?
		if(atual != null) {
			
			cmp = nome.compareTo(atual.getContato().getNome());

			// Valor para exclusão foi localizado?
			if(cmp == 0) {
				
				// O nó é folha (não tem galhos)?
				if(atual.getGalhoEsquerda() == null && atual.getGalhoDireita() == null) {
					
					// Eliminar a referência do galho (esquerda ou direita) do nó anterior a este.
					if(anterior.getGalhoEsquerda() != null) {
						// O nó anterior aponta para o nó a ser excluido pelo galho da esquerda?
						if(anterior.getGalhoEsquerda().getContato().getNome().equals(nome)) {
							anterior.setGalhoEsquerda(null);
						}
					}
					
					if(anterior.getGalhoDireita() != null) {
						// O nó anterior aponta para o nó a ser excluido pelo galho da direita?
						if(anterior.getGalhoDireita().getContato().getNome().equals(nome)) {
							anterior.setGalhoDireita(null);
						}
					}
					
					// Elimina o nó.
					atual = null;
					return;
					
				}
				
				// O nó tem um filho a esquerda?
				if(atual.getGalhoEsquerda() != null && atual.getGalhoDireita() == null) {
					
					// Alterar a referência do galho (esquerda ou direita) do nó anterior a este.
					if(anterior.getGalhoEsquerda() != null) {
						// O nó anterior aponta para o nó a ser excluido pelo galho da esquerda?
						if(anterior.getGalhoEsquerda().getContato().getNome().equals(nome)) {
							anterior.setGalhoEsquerda(atual.getGalhoEsquerda());
						}
					}
					
					if(anterior.getGalhoDireita() != null) {
						// O nó anterior aponta para o nó a ser excluido pelo galho da direita?
						if(anterior.getGalhoDireita().getContato().getNome().equals(nome)) {
							anterior.setGalhoDireita(atual.getGalhoEsquerda());
						}
					}
					
					// Elimina o nó.
					atual = null;
					this.elemento = "Registro excluído";
					return;
					
				}
				
				// O nó tem um filho a direita?
				if(atual.getGalhoEsquerda() == null && atual.getGalhoDireita() != null) {
					
					// Alterar a referência do galho (esquerda ou direita) do nó anterior a este.
					if(anterior.getGalhoEsquerda() != null) {
						// O nó anterior aponta para o nó a ser excluido pelo galho da esquerda?
						if(anterior.getGalhoEsquerda().getContato().getNome().equals(nome)) {
							anterior.setGalhoEsquerda(atual.getGalhoDireita());
						}
					}
					
					if(anterior.getGalhoDireita() != null) {
						// O nó anterior aponta para o nó a ser excluido pelo galho da direita?
						if(anterior.getGalhoDireita().getContato().getNome().equals(nome)) {
							anterior.setGalhoDireita(atual.getGalhoDireita());
						}
					}
					
					// Elimina o nó.
					atual = null;
					this.elemento = "Registro excluído";
					return;
					
				}
				
				// O nó tem dois filhos?
				if(atual.getGalhoEsquerda() != null && atual.getGalhoDireita() != null) {
					
					
					
				}
				
			} else if(cmp < 0) {
				
				this.excluir(atual.getGalhoEsquerda(), atual, nome);
				
			} else {
				
				this.excluir(atual.getGalhoDireita(), atual, nome);
				
			}
			
		} else {
			
			this.elemento = "Valor não localizado.";
			
		}
		
		
	}
	
	public void consultar(No<T> atual, String nome) {

		int cmp = 0;
		
		// Existe nó na árvore binária?
		if(atual != null) {
			
			// Comparar o valor(nome) informado pelo usuário com o valor do nó atual.
			cmp = nome.compareTo(atual.getContato().getNome());
			this.comparacao++;
			
			// O valor(nome) da consulta é igual ao valor no nó?
			if(cmp == 0) {
				
				this.elemento = atual.getContato().getNome() + " " + atual.getContato().getNumero();
				
			// O valor é menor?
			} else if(cmp < 0) {
				
				this.consultar(atual.getGalhoEsquerda(), nome);
				
			// O valor é maior?
			} else {
				
				this.consultar(atual.getGalhoDireita(), nome);
				
			}
			
		} else {
			
			this.elemento = "Valor não localizado.";
			
		}
		
	}
	
	/**
	 * Inicializa o valor do elemento.
	 */
	public void inicializaElemento() {
		
		this.elemento = "";
		
	}
	
	/**
	 * Travessia in-fixada.<br><br>Observação: se a inserção de nós na árvore, foi uma inserção respeitando a regra de árvore binária de pesquisa<br>
	 * o resultado desse método é imprimir todos os elementos de forma ordenada.
	 * 
	 * @param no O nó raiz da árvore.
	 */
	public void inFixa(No<T> no) {
		 
		if(no != null) {
	    	 
			this.inFixa(no.getGalhoEsquerda());
	    	this.elemento += no.getContato().getNome() + " " +  no.getContato().getNumero() + "\n";
	    	this.inFixa(no.getGalhoDireita());
	         
		}
	     
	}

	/**
	 * Travessia pré-fixada.
	 * @param no O nó raiz da árvore.
	 */
	public void preFixa(No<T> no) {
		 
	    if(no != null) {
	    	 
	    	this.elemento += no.getContato().getNome() + " " +  no.getContato().getNumero() + "\n";
	    	this.preFixa(no.getGalhoEsquerda());
	    	this.preFixa(no.getGalhoDireita());
	         
	    }
	     
	}
	
	/**
	 * Travessia pós-fixada.
	 * @param no O nó raiz da árvore.
	 */
	public void posFixa(No<T> no) {
		 
	    if(no != null) {
	    	
	    	this.posFixa(no.getGalhoEsquerda());
	    	this.posFixa(no.getGalhoDireita());
	        this.elemento += no.getContato().getNome() + " " +  no.getContato().getNumero() + "\n";
	        
	    }
	     
	}
	
	/**
	 * Obtém os dados da árvore binária utlizando a travessia pré-fixa e formata para arquivo de texto.
	 * 
	 * @param no O nó raiz da árvore.
	 */
	public void formatarDadosArquivo(No<T> no) {
		
		if(no != null ) {
			
			this.elemento += no.getContato().getNome() + "|" +  no.getContato().getNumero() + "\n";
			this.formatarDadosArquivo(no.getGalhoEsquerda());
			this.formatarDadosArquivo(no.getGalhoDireita());
			
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

	public long getAltura() {
		return altura;
	}
	
}
