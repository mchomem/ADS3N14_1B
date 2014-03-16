package br.com.misatech.listatelefonica.controller;

import java.awt.HeadlessException;
import java.io.IOException;

import br.com.misatech.listatelefonica.model.Arquivo;
import br.com.misatech.listatelefonica.model.ListaEncadeada;
import br.com.misatech.listatelefonica.model.No;
import br.com.misatech.listatelefonica.view.ConListaTelefonica;

/**
 * Classe controladora
 * 
 * @author Misael C. Homem
 * @param <T>
 * @since 1.00
 */
public class CtrPrograma<T> {
	
	private ConListaTelefonica clt;
	private ListaEncadeada<String> lista;
	private No<String> anterior = null;
	
	
	/**
	 * Construtor padr�o inicializando os campos.
	 */
	public CtrPrograma() {
		
		clt = new ConListaTelefonica();
		lista = new ListaEncadeada<String>();
		
	}
	
	/**
	 * Inicializa lista conforme valores gravados no arquivo listaTelefonica.txt
	 * 
	 * @throws HeadlessException
	 * @throws IOException
	 */
	public void inicializaLista() throws HeadlessException, IOException{
		
		try {
			
			Arquivo arquivo = new Arquivo();
			String linhaArquivo;
			
			while( (linhaArquivo = arquivo.consultar())!= null) {
			
				String[] valores = linhaArquivo.split("\\|");
				
				// O registro est� ativo? Se sim "S", considera para inserir na lista encadeada.
				if(valores[2].equals("S")) {
					
					// A lista est� vazia? Se sim, insere o 1� elemento.
					if(lista.getHead() == null) {
						
						No<String> nodo = new No<String>(linhaArquivo);
						lista.inserir(nodo);
						anterior = nodo;
						
				    } else {
				    	
				    	No<String> nodo = new No<String>(linhaArquivo);
				    	lista.inserir(nodo, anterior);
				    	anterior = nodo;
				    	
				    }
			    
				}
			}
		}catch (Exception e) {
			
			clt.exibirMensagem("Erro: " + e.getMessage(), true);
			
		}
	}
	
	public void insereValor(String nome, String telefone) throws IOException{
		
		Arquivo arquivo = new Arquivo();
		
		// Grava o novo registro no arquivo utilizando a flag de cadastro ativo "S"
		String linhaArquivo = nome + "|" + telefone + "|S";
		
		// A lista est� vazia? se sim insere o 1� n�.
		if(lista.getHead() == null) {
			
			No<String> nodo = new No<String>(linhaArquivo);
			lista.inserir(nodo);
			anterior = nodo;
			arquivo.gravar(linhaArquivo);
			
		} else {
			
			No<String> nodo = new No<String>(linhaArquivo);
	    	lista.inserir(nodo,anterior);
	    	anterior = nodo;
	    	arquivo.gravar(linhaArquivo);
	    	
		}

	}
	
	/**
	 * Trata o in�cio da aplica��o, fazendo chamada dos m�todos que est�o no ConListaTelefonica.
	 */
	public void iniciar() {
		
		try {
			
			this.inicializaLista();
			
		} catch(IOException e) {
			
			clt.exibirMensagem("Erro: " + e.getMessage(), true);
			
		}
		
		int operacao = 0;
		boolean finalizar = true;
		
		do {
			
			clt.exibirMenu();
			operacao = clt.capturarOperacao();
			
			switch(operacao) {
			
			case 1:
				
				String nome = "";
				String telefone = "";
				
				clt.exibirTituloOpcao("Incluir um contato telef�nico");
				clt.exibirMensagem("Informe o nome: ", false);
				nome = clt.capturarNome();
				clt.exibirMensagem("Informe o telef�ne: ", false);
				telefone = clt.capturarNumeroTel();
				
				try {
					
					insereValor(nome, telefone);
					
				} catch(IOException e) {
					
					clt.exibirMensagem("Erro: " + e.getMessage(), true);
					
				}
				
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
				
				// Imprimindo toda a lista.
				clt.imprimirLista(lista.imprimir());
				
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
