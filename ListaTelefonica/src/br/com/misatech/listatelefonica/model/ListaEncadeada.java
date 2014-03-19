package br.com.misatech.listatelefonica.model;

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
	
	/**
	 * M�todo de inser��o do 1� n�.
	 * 
	 * @param novo o n� da lista.
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
	 * Inser��o de n� no final da lista.
	 * 
	 * @param novo O n� propriamente dito.
	 * @param anterior O n� anterior.
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
	 * Exclui o n� de uma lista encadeada.
	 * 
	 * @param valor O valor do n� a ser excluido.
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
	 * Faz a impress�o dos valores de cada n� concatenandos com quebra de linha e retorno de carro.
	 * 
	 * @return Retorna uma String com os valores de cada n�.
	 */
	public String imprimir() {
		
		// Inicializa com o 1� n�.
		No<T> elem = head;
		
		String valores = "";
		
		do {
			
			valores += elem.getDado() + "\r\n";
			elem = elem.getProximo();
			
		} while (elem != null);
		
		return valores; 
		
	}
	
	/**
	 * Procura pelo valor inicial do nome do contato no n� da lista.
	 * 
	 * @param valor String representando a letra inicial pela qual se quer buscar o contato.
	 * @return Retorna o n� da lista. Caso no seja encontrado o valor, retorna null.
	 */
	public No<T> procurarNoPorValorInicial(T valor) {
		
		No<T> nodo = head;
		//No<T> anterior = null;
		
		while (nodo != null) {
			
			// Atribui a letraInicial a primeira String do valor do n� iterado.
			String letraInicial = String.valueOf( ((String) nodo.getDado()).charAt(0) );

			// Os dados de cada coluna do n�.
			String[] colunaNo = ((String) nodo.getDado()).split("\\|");
			
			// Compara as iniciais do valor (par�metro) e do n�.
			int cmp = letraInicial.compareTo((String) valor);
			
			// Se as iniciais s�o iguais e se o n� n�o est� excluido logicamente.
			if (cmp == 0 && colunaNo[2].equals("S")) {

				// Retorno o n� encontrado.
				return nodo;
				
			}
			
			// anterior = nodo;
			// Navega para o pr�ximo n�.
			nodo = nodo.getProximo();
			
		}
		
		return nodo;
		
	}
	
	public No<T> avancarNo(No<T> no) {
		
		// Implementa��o interrompida.
		if(no == null) {
			
			return head;
			
		} else {
			
			return no = no.getProximo();
			
		}
		
	}
	
	public void retrocederNo() {
		// N�o implementado.
	}
	
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

}
