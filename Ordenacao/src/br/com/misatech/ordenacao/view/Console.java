package br.com.misatech.ordenacao.view;

import java.util.Scanner;

/**
 * Representa o Console.
 * 
 * @author Misael C. Homem
 * @since 1..00
 *
 */
public class Console {
	
	/**
	 * Construtor padrão.
	 */
	public Console() { }
	
	/**
	 * Imprime valores informados definidos.
	 * 
	 * @param valor Um valor a ser definido, uma mensagem, etc.
	 */
	public void imprimir(String valor) {
		
		System.out.println(valor);
		
	}
	
	/**
	 * Cursor para console, recebendo a entrada do teclado. 
	 * 
	 * @param dialogo Uma mensagem de diálogo para o usuário.
	 * @return Retorna uma String representando o valor que o usuário informou.
	 */
	public String cursor(String dialogo) {
		
		String valor = "";
		System.out.print(dialogo + ": ");
		@SuppressWarnings("resource")
		Scanner cursor = new Scanner(System.in);
		valor = cursor.next();
		return valor;
		
	}

}
