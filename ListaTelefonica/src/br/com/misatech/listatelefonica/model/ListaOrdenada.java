package br.com.misatech.listatelefonica.model;

import java.util.Arrays;

public class ListaOrdenada<T extends Comparable<T>> extends ListaEncadeada<T> {

	private String[] listaOrdenada;
	
	public ListaOrdenada() {}
	
	private void odernarLista() {
		
		No<T> no = head;
		
		for(int contador = 0; no != null; contador++) {
			
			listaOrdenada[contador] = no.getDado().toString();
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
	     
	    if (primeiroIndice > ultimoIndice)
	        return "";
	    else if(array[indiceMeio].compareTo(nome) == 0)
	        return array[indiceMeio];
	   else if (array[indiceMeio].compareTo(nome) > 0)
	        return buscaBinariaRecursiva(array, indiceMeio+1, ultimoIndice, nome);
	    else
	        return buscaBinariaRecursiva(array, primeiroIndice, indiceMeio-1, nome);
	    
	}
	
}
