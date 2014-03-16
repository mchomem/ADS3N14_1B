package br.com.misatech.listatelefonica.view;

import java.util.Scanner;

import br.com.misatech.listatelefonica.model.No;

/**
 * Classe representando o Menu da aplicação em interface de console.
 * 
 * @author Misael
 * @since 1.00
 */
public class ConListaTelefonica {
	
	public ConListaTelefonica() {}
	
	/**
	 * Prepara a exibição do menu da aplicação.
	 */
	public void exibirMenu() {
		
		String textoMenu = "*** Menu ***\n\n";
		
		textoMenu += "1 - Incluir Contato.\n";
		textoMenu += "2 - Excluir Contato.\n";
		textoMenu += "3 - Consultar Contato.\n";
		textoMenu += "0 - Encerrar Aplicação.\n";
		
		System.out.println(textoMenu);
		System.out.print("Opção: ");
		
	}
	
	/**
	 *  Obtém o valor de operação do menu informado pelo usuário.
	 *  
	 * @return O valor da operação escolhida.
	 */
	public int capturarOperacao() {
		
		int valor = 0;
		@SuppressWarnings("resource")
		Scanner leitura = new Scanner(System.in);
		
		valor = leitura.nextInt();
		
		return valor;
		
	}
	
	/**
	 * Obtém o nome de contato telefônico informado pelo usuário.
	 * 
	 * @return Uma string contendo o nome do contato telefônico.
	 */
	public String capturarNome() {
		
		String nome = "";
		@SuppressWarnings("resource")
		Scanner leitura = new Scanner(System.in);
		nome = leitura.next();
		
		return nome;
		
	}
	
	/**
	 * Obtém o número telefônico do contato informado pelo usuário.
	 * 
	 * @return Uma string contendo o número telefônico.
	 */
	public String capturarNumeroTel() {
		
		String tel = "";
		@SuppressWarnings("resource")
		Scanner leitura = new Scanner(System.in);
		tel = leitura.next();
				
		return tel;
		
	}
	
	/**
	 * Método resposável por tratar os títulos de cada seção do console.
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
	 * @param quebraLinha Se true haverá quebra de linha ao final da mensagem. Caso false, a mensagem é exibida sem quebra de linha.
	 */
	public void exibirMensagem(String mensagem, boolean quebraLinha) {
		
		// Linha deve ser quebrada após mensagem?
		if(quebraLinha) {
			System.out.println(mensagem);
		} else {
			System.out.print(mensagem);
		}
		
		
	}
	
	/**
	 * Trata a impressão de um nó de lista encadeada.
	 * 
	 * @param no Um objeto do tipo nó de lista encadeada.
	 */
	public <T> void imprimirLista(No<T> no) {
		
		System.out.println(no);
		
	}

}
