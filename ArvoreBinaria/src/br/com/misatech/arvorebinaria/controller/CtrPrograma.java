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
	private No<String> anterior;
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
				
				No<String> no = new No<String>();
				no.setContato(new Contato(valores[0], valores[1]));
				arvoreBinaria.inserir(no);
				anterior = no;
				
			} else {
				
				No<String> no = new No<String>();
				no.setContato(new Contato(valores[0], valores[1]));
				arvoreBinaria.inserir(no, anterior);
				anterior = no;
				
			}
			
		}
		
	}
	
	public void inserirValor(String nome, String numero) throws Exception {
		
		arquivo = new Arquivo();
		
		// Grava o novo registro no arquivo utilizando a flag de cadastro ativo "S"
		String linhaArquivo = nome + "|" + numero + "|S";
		No<String> no = new No<String>();
		no.setContato(new Contato(nome, numero));
		
		// A �rvore est� vazia?
		if(arvoreBinaria.getRaiz() == null) {

			// Insere o 1� n�.
			arvoreBinaria.inserir(no);
			
		} else {
			
			// Insere um n� com �rvore n�o vazia.
			arvoreBinaria.inserir(no, anterior);
			
		}
		
		anterior = no;
		arquivo.gravar(linhaArquivo);
		
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
					
					console.imprimir("*** Inserindo ***");
					String nome = console.cursor("Informe o nome");
					String numero = console.cursor("Informe o numero");
					
					try {
						
						this.inserirValor(nome, numero);
						
					} catch(Exception e) {
						
						console.imprimir("Erro: " + e.getMessage());
						
					}
					
					console.imprimir("Contato adicionado.");
					break;
					
				case "2":
					
					console.imprimir("*** Excluindo ***");
					String nomeExclusao = console.cursor("Informe o valor a ser excluido");
					this.arvoreBinaria.excluir(nomeExclusao);
					break;
					
				case "3":
					
					console.imprimir("*** Consultando ***");
					String nomeContato = console.cursor("Informe o nome do contato");
					this.arvoreBinaria.consulta(nomeContato);
					break;
					
				case "4":
					
					console.imprimir("*** Relat�rio (InFixa) ***");
					this.arvoreBinaria.inFixa(this.arvoreBinaria.getRaiz());
					console.imprimir(this.arvoreBinaria.getElemento());
					this.arvoreBinaria.inicializaElemento();
					break;
					
				case "5":
					
					console.imprimir("*** Relat�rio (PreFixa) ***");
					this.arvoreBinaria.preFixa(this.arvoreBinaria.getRaiz());
					console.imprimir(this.arvoreBinaria.getElemento());
					this.arvoreBinaria.inicializaElemento();
					break;
					
				case "6":
					
					console.imprimir("*** Relat�rio (PosFixa) ***");
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
