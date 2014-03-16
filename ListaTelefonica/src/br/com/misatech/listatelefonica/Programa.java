package br.com.misatech.listatelefonica;

import br.com.misatech.listatelefonica.controller.CtrPrograma;

/**
 * Classe contendo o m�todo principal para execu��o do programa.
 * 
 * @author Misael C. Homem.
 * @since 1.00
 */
public class Programa {
	
	/**
	 * M�todo principal da aplica��o.
	 * @param <T>
	 * 
	 * @param args argumento de linha de comando (sem uso).
	 */
	public static <T> void main(String []args) {
		
		new CtrPrograma<T>().iniciar();
		
	}
	
}
