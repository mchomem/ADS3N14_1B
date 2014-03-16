package br.com.misatech.listatelefonica.view;

import java.util.Scanner;

import br.com.misatech.listatelefonica.model.No;

/**
 * Classe representando o Menu da aplica��o em interface de console.
 * 
 * @author Misael
 * @since 1.00
 */
public class ConListaTelefonica {
	
	public ConListaTelefonica() {}
	
	/**
	 * Prepara a exibi��o do menu da aplica��o.
	 */
	public void exibirMenu() {
		
		String textoMenu = "*** Menu ***\n\n";
		
		textoMenu += "1 - Incluir Contato.\n";
		textoMenu += "2 - Excluir Contato.\n";
		textoMenu += "3 - Consultar Contato.\n";
		textoMenu += "0 - Encerrar Aplica��o.\n";
		
		System.out.println(textoMenu);
		System.out.print("Op��o: ");
		
	}
	
	/**
	 *  Obt�m o valor de opera��o do menu informado pelo usu�rio.
	 *  
	 * @return O valor da opera��o escolhida.
	 */
	public int capturarOperacao() {
		
		int valor = 0;
		@SuppressWarnings("resource")
		Scanner leitura = new Scanner(System.in);
		
		valor = leitura.nextInt();
		
		return valor;
		
	}
	
	/**
	 * Obt�m o nome de contato telef�nico informado pelo usu�rio.
	 * 
	 * @return Uma string contendo o nome do contato telef�nico.
	 */
	public String capturarNome() {
		
		String nome = "";
		@SuppressWarnings("resource")
		Scanner leitura = new Scanner(System.in);
		nome = leitura.next();
		
		return nome;
		
	}
	
	/**
	 * Obt�m o n�mero telef�nico do contato informado pelo usu�rio.
	 * 
	 * @return Uma string contendo o n�mero telef�nico.
	 */
	public String capturarNumeroTel() {
		
		String tel = "";
		@SuppressWarnings("resource")
		Scanner leitura = new Scanner(System.in);
		tel = leitura.next();
				
		return tel;
		
	}
	
	/**
	 * M�todo respos�vel por tratar os t�tulos de cada se��o do console.
	 * 
	 * @param titulo
	 */
	public void exibirTituloOpcao(String titulo) {
		
		System.out.println("*** " + titulo + " ***\n\n");
		
	}

	/**
	 * Exibe uma mensagem a ser definida pelo programador.
	 * 
	 * @param mensagem String represetando uma mensagem.
	 * @param quebraLinha Se true haver� quebra de linha ao final da mensagem. Caso false, a mensagem � exibida sem quebra de linha.
	 */
	public void exibirMensagem(String mensagem, boolean quebraLinha) {
		
		// Linha deve ser quebrada ap�s mensagem?
		if(quebraLinha) {
			System.out.println(mensagem);
		} else {
			System.out.print(mensagem);
		}
		
		
	}
	
	/**
	 * Trata a impress�o de um n� de lista encadeada.
	 * 
	 * @param no Um objeto do tipo n� de lista encadeada.
	 */
	public <T> void imprimirLista(No<T> no) {
		
		System.out.println(no);
		
	}

}
