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
	 * Construtor padrão inicializando os campos.
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
				
				// O registro está ativo? Se sim "S", considera para inserir na lista encadeada.
				if(valores[2].equals("S")) {
					
					// A lista está vazia? Se sim, insere o 1º elemento.
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
	
	/**
	 * Insere o valor de um nó.
	 * 
	 * @param nome
	 * @param telefone
	 * @throws IOException
	 */
	public void insereValor(String nome, String telefone) throws IOException{
		
		Arquivo arquivo = new Arquivo();
		
		// Grava o novo registro no arquivo utilizando a flag de cadastro ativo "S"
		String linhaArquivo = nome + "|" + telefone + "|S";
		
		// A lista está vazia? se sim insere o 1º nó.
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
	 * Busca um contato apenas utilizando a inicial do nome.
	 * 
	 * @param inicial Uma única String representando a inicial do nome do contato.
	 * @return O valor do registro. Caso não encontrado retorna mensagem: Não possível localizar contato.
	 */
	public String buscarIncial(String inicial) {
		
		No<String> no = lista.procurarNoPorValorInicial(inicial);
		
		if(no == null) {
			return "Não possível localizar contato.";
		} else {
			return no.getDado();
		}
		
	}
	
	/**
	 * Trata o início da aplicação, fazendo chamada dos métodos que estão no ConListaTelefonica.
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
			
			String nome = "";
			String telefone = "";
			String inicial = "";
			
			clt.exibirMenu();
			operacao = clt.capturarOperacao();
			
			switch(operacao) {
			
			case 1:
				
				clt.exibirTituloOpcao("Incluir um contato telefônico");
				clt.exibirMensagem("Informe o nome: ", false);
				nome = clt.capturarNome();
				clt.exibirMensagem("Informe o telefône: ", false);
				telefone = clt.capturarNumeroTel();
				
				try {
					
					insereValor(nome, telefone);
					
				} catch(IOException e) {
					
					clt.exibirMensagem("Erro: " + e.getMessage(), true);
					
				}
				
				clt.exibirMensagem("Contato adicionado", true);
				break;
				
			case 2:
				
				clt.exibirTituloOpcao("Excluir contato telefônico");
				clt.exibirMensagem("Informe o nome: ", false);
				clt.capturarNome();
				
				clt.exibirMensagem("Contato excluido.", true);
				break;
				
			case 3:
				
				clt.exibirTituloOpcao("Relatório de contato telefônico");

				// Imprimindo toda a lista.
				clt.imprimirLista(lista.imprimir());
				
				break;
				
			case 4:
				
				clt.exibirTituloOpcao("Consultar contato pela letra inicial");
				clt.exibirMensagem("Informe a letra inicial: ", false);
				inicial = String.valueOf(clt.capturarNome().charAt(0));
				
				clt.imprimirLista(buscarIncial(inicial));
				
				break;
				
			case 0:
				
				finalizar = false;
				break;
			
			}
			
		} while(finalizar);
		
		this.finalizar();
		
	}

	/**
	 * Trata a finalização da aplicação.
	 */
	public void finalizar() {
		
		clt.exibirTituloOpcao("Finalizando aplicação");
		System.exit(1);
		
	}

}
