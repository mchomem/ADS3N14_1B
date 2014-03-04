package br.com.misatech.hellowolrd;

/**
 * A classe possui um m�todo que exibe uma mensagem de sauda��o inicial no console. 
 * 
 * @author Misael C. Homem
 * @since Vers�o 1.00
 */
public class Programa {

	/**
	 * M�todo principal da classe.
	 * @param args argumento opcional de linha de comando.
	 */
	public static void main(String []args) {
		
		new Programa().exibirMensagem();
		
	}
	
	/**
	 * Exibe uma mensagem initial no console.
	 */
	public void exibirMensagem() {
		
		System.out.println("Ol� mundo, estou no GitHub");
		
	}
	
}
