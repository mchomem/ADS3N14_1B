package br.com.misatech.listatelefonica.controller;

import br.com.misatech.listatelefonica.view.ConListaTelefonica;

/**
 * Classe controladora
 * 
 * @author Misael C. Homem
 * @since 1.00
 */
public class CtrPrograma {
	
	private ConListaTelefonica clt;
	
	/**
	 * Construtor padr�o inicializando os campos.
	 */
	public CtrPrograma() {
		
		clt = new ConListaTelefonica();
		
	}
	
	/**
	 * Trata o in�cio da aplica��o, fazendo chamada dos m�todos que est�o no ConListaTelefonica.
	 */
	public void iniciar() {
		
		int operacao = 0;
		boolean finalizar = true;
		
		do {
			
			clt.exibirMenu();
			operacao = clt.capturarOperacao();
			
			switch(operacao) {
			
			case 1:
				
				clt.exibirTituloOpcao("Incluir um contato telef�nico");
				clt.exibirMensagem("Informe o nome: ", false);
				clt.capturarNome();
				clt.exibirMensagem("Informe o telef�ne: ", false);
				clt.capturarNumeroTel();
				
				clt.exibirMensagem("Contato adicionado", true);
				break;
				
			case 2:
				
				clt.exibirTituloOpcao("Excluir contato telef�nico");
				
				clt.exibirMensagem("Informe o nome: ", false);
				clt.capturarNome();
				
				clt.exibirMensagem("Contato excluido.", true);
				break;
				
			case 3:
				
				clt.exibirTituloOpcao("Consultar um contato telef�nico");
				
				clt.exibirMensagem("Informe o nome: ", false);
				clt.capturarNome();
				break;
				
			case 0:
				
				finalizar = false;
				break;
			
			}
			
		} while(finalizar);
		
		this.finalizar();
		
	}

	/**
	 * Trata a finaliza��o da aplica��o.
	 */
	public void finalizar() {
		
		clt.exibirTituloOpcao("Finalizando aplica��o");
		System.exit(1);
		
	}

}
