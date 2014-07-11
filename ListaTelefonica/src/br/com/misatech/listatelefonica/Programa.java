package br.com.misatech.listatelefonica;

import br.com.misatech.listatelefonica.controller.CtrPrograma;

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
