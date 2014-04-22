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
		
		if(anterior != null) {
			
			cmp = novo.getContato().getNome().compareTo(anterior.getContato().getNome());
			
			if(cmp < 0) {
				
				anterior.setGalhoEsquerda(this.inserir(novo, anterior.getGalhoEsquerda()));
				
			} else {
				
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
	
	public void excluir(String nome) {
		
		// Concluir implementação.
		
	}
	
	public void consulta(String nome) {

		// Concluir implementação.
		
	}
	
	/**
	 * Inicializa o valor do elemento.
	 */
	public void inicializaElemento() {
		
		this.elemento = "";
		
	}
	
	/**
	 * Travessia in-fixada.
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
	
}
