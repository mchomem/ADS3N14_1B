package br.com.misatech.hellowolrd;

/**
 * A classe possui um método que exibe uma mensagem de saudação inicial no console. 
 * 
 * @author Misael C. Homem
 * @since Versão 1.00
 */
public class Programa {

	/**
	 * Método principal da classe.
	 * @param args argumento opcional de linha de comando.
	 */
	public static void main(String []args) {
		
		new Programa().exibirMensagem();
		
	}
	
	/**
	 * Exibe uma mensagem initial no console.
	 */
	public void exibirMensagem() {
		
		System.out.println("Olá mundo, estou no GitHub");
		
	}
	
}
