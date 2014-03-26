package br.com.misatech.listatelefonica.controller;

import java.awt.HeadlessException;
import java.io.IOException;

import br.com.misatech.listatelefonica.model.Arquivo;
import br.com.misatech.listatelefonica.model.ListaEncadeada;
import br.com.misatech.listatelefonica.model.ListaOrdenada;
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
	private No<String> anterior;
	private Arquivo arquivo;
	
	/**
	 * Construtor padr�o inicializando os campos.
	 */
	public CtrPrograma() {
		
		clt   = new ConListaTelefonica();
		lista = new ListaEncadeada<String>();
		
		
	}
	
	/**
	 * Inicializa lista conforme valores gravados no arquivo listaTelefonica.txt<br>
	 * O arquivo segue o leiaute com separador de valores como o pipe. Colunas:<br>
	 * 
	 * NOME DO CONTATO - String representando o nome<br>
	 * N�MERO DE TELEFONE - String representando o n�mero de telefone<br>
	 * REGISTRO_ATIVO - String de uma posi��o representando uma falg do estado do registro<br>
	 * utilizando S para "sim" e N para "n�o"<br><br>
	 * 
	 * Ex:<br><br>
	 * 
	 * Misael|98882034|S
	 * 
	 * @throws HeadlessException
	 * @throws IOException
	 */
	public void inicializaLista() throws HeadlessException, IOException{
		
		try {
			
			arquivo = new Arquivo();
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
			
		} catch (Exception e) {
			
			clt.exibirMensagem("Erro: " + e.getMessage(), true);
			
		}
	}
	
	/**
	 * Insere o valor de um n�.
	 * 
	 * @param nome O nome do contato
	 * @param telefone o n�mero de telefone do contato.
	 * @throws IOException
	 */
	public void insereValor(String nome, String telefone) throws IOException {
		
		arquivo = new Arquivo();
		
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
	 * Busca um contato apenas utilizando a inicial do nome.
	 * 
	 * @param inicial Uma �nica String representando a inicial do nome do contato.
	 * @return O valor do registro. Caso n�o encontrado retorna mensagem: N�o poss�vel localizar contato.
	 */
	public String buscarIncial(String inicial) {
		
		No<String> no = lista.buscarValorInicial(inicial);
		
		if(no == null) {
			
			return "N�o poss�vel localizar contato.";
			
		} else {
			
			return no.getDado();
			
		}
		
	}
	
	public String buscarContatoPesquisaBinaria(String nome) {
		
		String valor = lista.buscaBinaria(nome);
		
		
		if(valor.equals("")) {
			
			return "N�o foi poss�vel localizar o contato";
			
		}
				
		return valor;
		
		
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
		
		int operacao      = 0;
		boolean finalizar = true;
		
		do {
			
			clt.exibirMenu();
			operacao = clt.capturarOperacao();
			
			switch(operacao) {
			
			case 1:
				
				String nome     = "";
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
				String capturarNome = clt.capturarNome();
				
				try {
					
					lista.excluir(capturarNome);
					
					try {
						
						if(arquivo.excluiItemLista(capturarNome)) {
							
							clt.exibirMensagem("Contato excluido.", true);
							
						} else {
							
							clt.exibirMensagem("Contato n�o localizado.", true);
							
						}
						
					} catch (Exception e) {
						
						clt.exibirMensagem("Erro: " + e.getMessage(), true);
						
					}
					
				} catch (Exception e) {
					
					clt.exibirMensagem("Erro: " + e.getMessage(), true);
				}
				
				
			case 3:
				
				clt.exibirTituloOpcao("Relat�rio de contato telef�nico");
				// Imprimindo toda a lista.
				clt.imprimirLista(lista.imprimir());
				
				break;
				
			case 4:
				
				clt.exibirTituloOpcao("Consultar contato");
				clt.exibirMensagem("Informe o nome do contato: ", false);
				String valorBusca = clt.capturarNome();
				String resultado = lista.buscaSequencial(valorBusca);
				clt.imprimirLista(resultado.equals("") ? "Valor n�o encontrado.": resultado);
				
				break;
				
			case 5:
				
				String inicial  = "";
				clt.exibirTituloOpcao("Consultar contato pela letra inicial");
				clt.exibirMensagem("Informe a letra inicial: ", false);
				inicial = String.valueOf(clt.capturarNome().charAt(0));
				clt.imprimirLista(buscarIncial(inicial));
				
				break;
				
			case 6:
				
				clt.exibirTituloOpcao("Avan�ar registro...");
				clt.imprimirLista("");
				
				break;
				
			case 7:
				
				clt.exibirTituloOpcao("Retroceder registro...");
				clt.imprimirLista("");
				
				break;
				
			case 8:
				
				clt.exibirMensagem("Informe o nome do contato: ", false);
				clt.imprimirLista(this.buscarContatoPesquisaBinaria(clt.capturarNome()));
				break;
				
			case 9:
				
				clt.exibirTituloOpcao("Pesquisa Bin�ria x Pesquisa Sequ�ncial");
				clt.exibirMensagem("Informe o valor para busca: ", false);
				String n = clt.capturarNome();
				
				lista.buscaSequencial(n);
				lista.buscaBinaria(n);
				
				clt.exibirMensagem("Resultado final:", true);
				clt.exibirMensagem("Quantidade de itera��es para realiza��o da busca:", true);
				clt.exibirMensagem("Pesquisa sequ�ncial: " + lista.getContBuscaSeq()  , true);
				clt.exibirMensagem("Pesquisa bin�ria: " + lista.getContBuscaBin()     , true);
				lista.setContBuscaSeq(0);
				lista.setContBuscaSeq(0);
				
				break;
				
			case 0:
				
				finalizar = false;
				break;
				
			default:
				
				clt.exibirMensagem("Op��o inv�lida", true);
				break;
			
			}
			
		} while(finalizar);
		
		this.finalizar();
		
	}

	/**
	 * Trata a finaliza��o da aplica��o.
	 */
	public void finalizar() {
		
		clt.exibirTituloOpcao("Aplica��o encerrada");
		System.exit(0);
		
	}

}
