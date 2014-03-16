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
	 * 
	 * @param args argumento de linha de comando (sem uso).
	 */
	public static void main(String []args) {
		
		new CtrPrograma().iniciar();
		
	}
	
}
