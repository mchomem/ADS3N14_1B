// http://pt.wikipedia.org/wiki/%C3%81rvore_bin%C3%A1ria
// http://manfred.com.br/index.php/bsi/estrutura-de-dados-i/141-aula-10-arvore-binaria-em-java
// http://pt.wikipedia.org/wiki/%C3%81rvore_bin%C3%A1ria_de_busca
// http://www.devmedia.com.br/trabalhando-com-arvores-binarias-em-java/25749

package br.com.misatech.arvorebinaria;

import br.com.misatech.arvorebinaria.controller.CtrPrograma;

/**
 * Classe contendo o método principal para execução do programa.
 * 
 * @author Misael C. Homem.
 * @since 1.00
 */
public class Programa {

	/**
	 * Método principal da aplicação.
	 * @param <T>
	 * 
	 * @param args argumento de linha de comando (sem uso).
	 */
	public static <T> void main(String []args) {
		
		new CtrPrograma<T>().iniciar();
		
	}
	
}
