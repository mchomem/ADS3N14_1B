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
	
	/**
	 * Construtor padrão da classe.
	 */
	public ArvoreBinaria() {
		
		this.inicializaElemento();
		
	}
	
	/**
	 * Inserção pela 1º vez.
	 * @param novo O 1º nó a ser inserido na árvore.
	 */
	public void inserir(No<T> novo) {
		
		novo.setGalhoEsquerda(raiz);
		novo.setGalhoDireita(raiz);
		
		raiz = novo;
		
	}
	
	// Idéia da http://pt.wikipedia.org/wiki/%C3%81rvore_bin%C3%A1ria
	// mais a idéia do Jeffmann de usar o compareTo	
	/**
	 * Inserção de elemento com elemento já existente.
	 * 
	 * @param novo O novo nó de elemento.
	 * @param anterior O nó anterior que será guardado para a inserção.
	 * @return Um tipo nó
	 */
	public No<T> inserir(No<T> novo, No<T> anterior) {
		
		int cmp = 0;

		// Existe o nó anterior?
		if(anterior != null) {
			
			// Compara a nova inserção com a última inserção.
			cmp = novo.getContato().getNome().compareTo(anterior.getContato().getNome());
			
			// Se o valor é menor?
			if(cmp < 0) {
				anterior.setGalhoEsquerda(this.inserir(novo, anterior.getGalhoEsquerda()));
			} else {
				// Se é menor?
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
	
	// Testar, verificar se não terá que mudar a estrutra do campo raiz, que recebe valor do novo no método inserir 1º vez)
	public void inserirFormaBST(No<T> novo, No<T> atual) {
		
		int cmp = 0;
		// Comparar os nomes do novo nó com o nó atual (já existente).
		cmp = novo.getContato().getNome().compareTo(atual.getContato().getNome());
		
		// É menor?
		if(cmp < 0) {
			
			// O nó atual tem algum nó no galho a esquerda?
			if(atual.getGalhoEsquerda() != null) {
				
				/* Chamaa o método recursivamente passando o novo nó e o
				 * galho esquerdo do nó atual para fazer a comparação de
				 * valores do novo nó com o nó do galho esquerdo do nó atual. */  
				this.inserirFormaBST(novo, atual.getGalhoEsquerda());
				
				// Se não houver galho a esquerda
			} else {

				// Insere o novo nó a esquerda do nó atual.
				atual.setGalhoEsquerda(novo);
				
			}
			
		// É maior?
		} else if(cmp > 0) {
			
			// O nó atual tem algum nó no galho a direita?
			if(atual.getGalhoDireita() != null) {
				
				/* Chamaa o método recursivamente passando o novo nó e o
				 * galho direito do nó atual para fazer a comparação de
				 * valores do novo nó com o nó do galho direito do nó atual. */
				this.inserirFormaBST(novo, atual.getGalhoDireita());
				
				// Se não houver galho a direita
			} else {
				
				// Insere o novo nó a direita do nó atual.
				atual.setGalhoDireita(novo);
				
			}
		}
		
	}
	
	public void excluir(No<T> atual,  String nome) {
		
		// Existe nó na árvore?
		if(atual != null) {
			
			// O nó é folha ?
			if(atual.getGalhoEsquerda() == null && atual.getGalhoDireita() == null) {
				
				
				
			}
			
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
	 * @param no O nó inicial da árvore.
	 */
	public void inFixa(No<T> no) {
		 
		if(no != null) {
	    	 
			inFixa(no.getGalhoEsquerda());
	    	this.elemento += no.getContato().getNome() + " " +  no.getContato().getNumero() + "\n";
	        inFixa(no.getGalhoDireita());
	         
		}
	     
	}

	/**
	 * Travessia pré-fixada.
	 * @param no O nó inicial da árvore.
	 */
	public void preFixa(No<T> no) {
		 
	    if(no != null) {
	    	 
	    	this.elemento += no.getContato().getNome() + " " +  no.getContato().getNumero() + "\n";
	        preFixa(no.getGalhoEsquerda());
	        preFixa(no.getGalhoDireita());
	         
	    }
	     
	}
	
	/**
	 * Travessia pós-fixada.
	 * @param no O nó inicial da árvore.
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
	
}
