package br.com.misatech.listatelefonica.model;

import java.util.Arrays;

/**
 * Classe representando a lista encadeada.
 * 
 * @author Misael C. Homem
 * @since 1.00
 *
 * @param <T>
 */
public class ListaEncadeada<T extends Comparable<T>> {
	
	protected No<T> head;
	protected No<T> tail;
	private String[] listaOrdenada;
	private long contBuscaSeq;
	private long contBuscaBin;
	
	/**
	 * Método de inserção do 1º nó.
	 * 
	 * @param novo o nó da lista.
	 */
	public void inserir(No<T> novo) {
		
		novo.setAnterior(head);
		novo.setProximo(head);
		
		head = novo;
		
		if (tail == null) {
			tail = novo;
		}
		
	}
	
	/**
	 * Inserção de nó no final da lista.
	 * 
	 * @param novo O nó propriamente dito.
	 * @param anterior O nó anterior.
	 */
	public void inserir(No<T> novo, No<T> anterior) {
		
		novo.setProximo(anterior.getProximo());
		anterior.setProximo(novo);
		
		novo.setAnterior(anterior);
		
		if (anterior == tail) {
			tail = novo;
		}
		
	}
	
	
	/**
	 * Exclui o nó de uma lista encadeada.
	 * 
	 * @param valor O valor do nó a ser excluido.
	 */
	public void excluir(T valor) {
		
		No<T> nodo = head;
		No<T> anterior = null;
		No<T> proximo = null;
		No<T> aux = null; 
		boolean encontrou = false;
		
		// Percorre a lista procurando o nodo que devera ser excluido
		while (nodo != null) {
			
			String[] valores = nodo.getDado().toString().split("\\|");
			
			if(valores[0].equals(valor)) {
		        
				encontrou = true;
				
				if(nodo.getAnterior() == null) {
					
					//se o nodo a excluir for o head
					proximo = nodo.getProximo();
					
				} else if(nodo.getProximo() == null) {
					
					//se o nodo a excluir for o tail
					anterior = nodo.getAnterior();
				} else {
					//se o nodo a excluir for do meio
					proximo = nodo.getProximo();
					anterior = nodo.getAnterior();
				}
				
				break;
			}
			
			anterior = nodo;
			nodo = nodo.getProximo();
		}
		
		if(encontrou) {
			
			if(nodo.getAnterior() == null) {
				
				//se o nodo a excluir for o head
				proximo.setAnterior(nodo.getAnterior());
				head = proximo;
				
			} else if(nodo.getProximo() == null) {
				
				//se o nodo a excluir for o tail
				anterior.setProximo(nodo.getProximo());
				tail = anterior;
				
			} else {
				
				//se o nodo a excluir for do meio
				aux = nodo.getAnterior();
				anterior.setProximo(nodo.getProximo());
				proximo.setAnterior(aux);
				
			}
			
		}
	}
	
	/**
	 * Faz a impressão dos valores de cada nó concatenandos com quebra de linha e retorno de carro.
	 * 
	 * @return Retorna uma String com os valores de cada nó.
	 */
	public String imprimir() {
		
		// Inicializa com o 1º nó.
		No<T> elem = head;
		
		String valores = "";
		
		do {
			
			valores += elem.getDado() + "\r\n";
			elem = elem.getProximo();
			
		} while (elem != null);
		
		return valores; 
		
	}
	
	/**
	 * Procura pelo valor inicial do nome do contato no nó da lista.
	 * 
	 * @param valor String representando a letra inicial pela qual se quer buscar o contato.
	 * @return Retorna o nó da lista. Caso no seja encontrado o valor, retorna null.
	 */
	public No<T> buscarValorInicial(T valor) {
		
		No<T> no = head;
		//No<T> anterior = null;
		
		while (no != null) {
			
			// Atribui a letraInicial a primeira String do valor do nó iterado.
			String letraInicial = String.valueOf( ((String) no.getDado()).charAt(0) );

			// Os dados de cada coluna do nó.
			String[] colunaNo = ((String) no.getDado()).split("\\|");
			
			// Compara as iniciais do valor (parâmetro) e do nó.
			int cmp = letraInicial.compareTo((String) valor);
			
			// Se as iniciais são iguais e se o nó não está excluido logicamente.
			if (cmp == 0 && colunaNo[2].equals("S")) {

				// Retorno o nó encontrado.
				return no;
				
			}
			
			// anterior = nodo;
			// Navega para o próximo nó.
			no = no.getProximo();
			
		}
		
		return no;
		
	}
	
	public String buscaSequencial(String valor) {
		
		No<T> no = head;
		
		while(no != null) {
			
			String[] colunaNo = ((String) no.getDado()).split("\\|");
			
			if(colunaNo[0].equals(valor)) {
				
				return no.getDado().toString();
				
			}
			
			no = no.getProximo();
			
		}
		
		return "";
	}
	
	public No<T> avancarNo(No<T> no) {
		
		// Implementação interrompida.
		if(no == null) {
			
			return head;
			
		} else {
			
			return no = no.getProximo();
			
		}
		
	}
	
	public void retrocederNo() {
		// Não implementado.
	}
	
	private void odernarLista() {
		
		No<T> no = head;
		listaOrdenada = new String[this.contarNo()];
		
		for(int idx = 0; no != null; idx++) {
			
			listaOrdenada[idx] = no.getDado().toString();
			no = no.getProximo();
			
		}
		
		Arrays.sort(listaOrdenada);
		
	}
	
	public String buscaBinaria(String chave) {
		
		this.odernarLista();
	    return buscaBinariaRecursiva(listaOrdenada, 0, listaOrdenada.length - 1, chave);
	    
	 }

	private String buscaBinariaRecursiva(String[] array, int primeiroIndice, int ultimoIndice, String nome) {
	
	    int indiceMeio = (primeiroIndice + ultimoIndice) / 2;
	    String[] nomeDoIndice = array[indiceMeio].split("\\|");
	     
	    if (primeiroIndice > ultimoIndice) {
	        
	    	return "";
	    
	    } else if(nomeDoIndice[0].toString().compareTo(nome) == 0) {
	    	
	        return array[indiceMeio];
	    
	    } else if (nomeDoIndice[0].toString().compareTo(nome) < 0) {
		   
	    	return buscaBinariaRecursiva(array, indiceMeio + 1, ultimoIndice, nome);
	    
	    } else {
	    	
	    	return buscaBinariaRecursiva(array, primeiroIndice, indiceMeio - 1, nome);
	        
	    }
	    
	}
	
	/**
	 * Faz a contagem de nós contidos em uma lista.
	 * @return
	 */
	public int contarNo() {
		
		// Inicia o nó com o 1º da lista.
		No<T> no = head;
		int qt = 0;
		
		while(no != null) {
			
			no = no.getProximo();
			qt++;
			
		}
		
		return qt;
		
	}
		
	/* Getters e Setters */
	public No<T> getHead() {
		return head;
	}

	public void setHead(No<T> head) {
		this.head = head;
	}

	public No<T> getTail() {
		return tail;
	}

	public void setTail(No<T> tail) {
		this.tail = tail;
	}
	/* Getters e Setters */

}
