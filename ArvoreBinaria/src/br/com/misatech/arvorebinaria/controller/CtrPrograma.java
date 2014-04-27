package br.com.misatech.arvorebinaria.controller;

import java.awt.HeadlessException;
import java.io.IOException;

import br.com.misatech.arvorebinaria.model.Arquivo;
import br.com.misatech.arvorebinaria.model.ArvoreBinaria;
import br.com.misatech.arvorebinaria.model.Contato;
import br.com.misatech.arvorebinaria.model.No;
import br.com.misatech.arvorebinaria.view.Console;

/**
 * Classe controladora
 * 
 * @author Misael C. Homem
 * @param <T>
 * @since 1.00
 */
public class CtrPrograma<T> {
	
	private Console console;
	//private No<String> anterior;
	private ArvoreBinaria<String> arvoreBinaria;
	private Arquivo arquivo;
	
	/**
	 * Construtor padr�o da classe.
	 */
	public CtrPrograma() {
		
		this.console = new Console();
		this.arvoreBinaria = new ArvoreBinaria<String>();
		
	}
	
	/**
	 * Carrega a �rvore bin�ria com os dados obtidos do arquivo texto.
	 * 
	 * @throws HeadlessException
	 * @throws IOException
	 */
	private void carregarArvoreBinaria() throws HeadlessException, IOException {
		
		arquivo = new Arquivo();
		String linhaArquivo;
		
		// O arquivo est� vazio?
		while((linhaArquivo = arquivo.consultar())!= null) {
			
			String[] valores = linhaArquivo.split("\\|");
			
			// A �rvore est� vazia?
			if(arvoreBinaria.getRaiz() == null) {
				
				No<String> novo = new No<String>();
				novo.setContato(new Contato(valores[0], valores[1]));
				arvoreBinaria.inserir(novo);
				//anterior = novo; // <- Verificar a necessidade de uso do campo "anterior".
				
			} else {
				
				No<String> novo = new No<String>();
				novo.setContato(new Contato(valores[0], valores[1]));
				arvoreBinaria.inserirFormaBST(novo, this.arvoreBinaria.getRaiz());
				
			}
			
		}
		
	}
	
	public void inserirValor(String nome, String numero) throws Exception {
		
		arquivo = new Arquivo();
		
		// Grava o novo registro no arquivo utilizando a flag de cadastro ativo "S"
		String linhaArquivo = nome + "|" + numero + "|S";
		No<String> novo = new No<String>();
		novo.setContato(new Contato(nome, numero));
		
		// A �rvore possui algum n�?
		if(arvoreBinaria.getRaiz() == null) {

			// Insere o 1� n�.
			arvoreBinaria.inserir(novo);
			
		} else {
			
			// Insere um n� com �rvore n�o vazia.
			arvoreBinaria.inserirFormaBST(novo, this.arvoreBinaria.getRaiz());
			
		}
		
		//anterior = novo;
		
		if(!this.arvoreBinaria.getElemento().equals("J� existe contato com este nome.")) {
			arquivo.gravar(linhaArquivo);
		}
		
	}
	
	/**
	 * Trata o in�cio da aplica��o.
	 */
	public void iniciar() {

		try {
			
			this.carregarArvoreBinaria();
			
		} catch(IOException e) {
			
			console.imprimir("Erro: " + e.getMessage());
			
		}
		
		console.imprimir("*** Contato Telef�nico ***");
		String opcao = "";
		
		do {
			
			console.imprimir("Menu");
			console.imprimir("1 - Inserir");
			console.imprimir("2 - Excluir");
			console.imprimir("3 - Consultar");
			console.imprimir("4 - Relat�rio (InFixa)");
			console.imprimir("5 - Relat�rio (PreFixa)");
			console.imprimir("6 - Relat�rio (PosFixa)");
			console.imprimir("7 - Sair\n");
			opcao = console.cursor("Escolha uma op��o");
			
			switch(opcao) {
				
				case "1":
					
					console.imprimir("\n*** Inserindo ***\n");
					String nome = console.cursor("Informe o nome");
					String numero = console.cursor("Informe o numero");
					
					try {
						
						this.inserirValor(nome, numero);
						
					} catch(Exception e) {
						
						console.imprimir("Erro: " + e.getMessage());
						
					}
					
					console.imprimir(this.arvoreBinaria.getElemento());
					this.arvoreBinaria.inicializaElemento();
					console.imprimir("Qt. elementos atual: " + this.arvoreBinaria.getQtNo() + ((this.arvoreBinaria.getQtNo() > 1) ? " elementos" : "elemento"));
					console.imprimir("Altura do nodo raiz: " + this.arvoreBinaria.getAltura());
					break;
					
				case "2":
					
					console.imprimir("\n*** Excluindo ***\n");
					String nomeExclusao = console.cursor("Informe o valor a ser excluido");
					this.arvoreBinaria.excluir(this.arvoreBinaria.getRaiz() , null, nomeExclusao);
					console.imprimir(this.arvoreBinaria.getElemento());
					this.arvoreBinaria.inicializaElemento();
					break;
					
				case "3":
					
					console.imprimir("\n*** Consultando ***\n");
					String nomeContato = console.cursor("Informe o nome do contato");
					this.arvoreBinaria.consultar(this.arvoreBinaria.getRaiz(), nomeContato);
					console.imprimir("\n" + this.arvoreBinaria.getElemento());
					console.imprimir("Total de compara��es: " + this.arvoreBinaria.getComparacao());
					this.arvoreBinaria.setComparacao(0);
					this.arvoreBinaria.inicializaElemento();
					break;
					
				case "4":
					
					console.imprimir("\n*** Relat�rio (InFixa) ***\n");
					this.arvoreBinaria.inFixa(this.arvoreBinaria.getRaiz());
					console.imprimir(this.arvoreBinaria.getElemento());
					this.arvoreBinaria.inicializaElemento();
					break;
					
				case "5":
					
					console.imprimir("\n*** Relat�rio (PreFixa) ***\n");
					this.arvoreBinaria.preFixa(this.arvoreBinaria.getRaiz());
					console.imprimir(this.arvoreBinaria.getElemento());
					this.arvoreBinaria.inicializaElemento();
					break;
					
				case "6":
					
					console.imprimir("\n*** Relat�rio (PosFixa) ***\n");
					this.arvoreBinaria.posFixa(this.arvoreBinaria.getRaiz());
					console.imprimir(this.arvoreBinaria.getElemento());
					this.arvoreBinaria.inicializaElemento();
					break;
					
				case "7":
					
					this.finalizar();
					break;
					
				default:
					
					console.imprimir("Escolha uma op��o do menu.");
					break;
					
			}
			
		} while(true);
		
	}
	
	/**
	 * Finaliza a aplica��o.
	 */
	private void finalizar() {
		
		console.imprimir("Aplica��o encerrada.");
		System.exit(0);
		
	}
	
}
