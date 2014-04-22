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
		
		// Concluir implementa��o.
		
	}
	
	public void consulta(String nome) {

		// Concluir implementa��o.
		
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
	
}
