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
	 * Construtor padrão da classe.
	 */
	public CtrPrograma() {
		
		this.console = new Console();
		this.arvoreBinaria = new ArvoreBinaria<String>();
		
	}
	
	/**
	 * Carrega a árvore binária com os dados obtidos do arquivo texto.
	 * 
	 * @throws HeadlessException
	 * @throws IOException
	 */
	private void carregarArvoreBinaria() throws HeadlessException, IOException {
		
		arquivo = new Arquivo();
		String linhaArquivo;
		
		// O arquivo está vazio?
		while((linhaArquivo = arquivo.consultar())!= null) {
			
			String[] valores = linhaArquivo.split("\\|");
			
			// A árvore está vazia?
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
		
		// A árvore está vazia?
		if(arvoreBinaria.getRaiz() == null) {

			// Insere o 1º nó.
			arvoreBinaria.inserir(no);
			
		} else {
			
			// Insere um nó com árvore não vazia.
			arvoreBinaria.inserir(no, anterior);
			
		}
		
		anterior = no;
		arquivo.gravar(linhaArquivo);
		
	}
	
	/**
	 * Trata o início da aplicação.
	 */
	public void iniciar() {

		try {
			
			this.carregarArvoreBinaria();
			
		} catch(IOException e) {
			
			console.imprimir("Erro: " + e.getMessage());
			
		}
		
		console.imprimir("*** Contato Telefônico ***");
		String opcao = "";
		
		do {
			
			console.imprimir("Menu");
			console.imprimir("1 - Inserir");
			console.imprimir("2 - Excluir");
			console.imprimir("3 - Consultar");
			console.imprimir("4 - Relatório (InFixa)");
			console.imprimir("5 - Relatório (PreFixa)");
			console.imprimir("6 - Relatório (PosFixa)");
			console.imprimir("7 - Sair\n");
			opcao = console.cursor("Escolha uma opção");
			
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
					
					console.imprimir("*** Relatório (InFixa) ***");
					this.arvoreBinaria.inFixa(this.arvoreBinaria.getRaiz());
					console.imprimir(this.arvoreBinaria.getElemento());
					this.arvoreBinaria.inicializaElemento();
					break;
					
				case "5":
					
					console.imprimir("*** Relatório (PreFixa) ***");
					this.arvoreBinaria.preFixa(this.arvoreBinaria.getRaiz());
					console.imprimir(this.arvoreBinaria.getElemento());
					this.arvoreBinaria.inicializaElemento();
					break;
					
				case "6":
					
					console.imprimir("*** Relatório (PosFixa) ***");
					this.arvoreBinaria.posFixa(this.arvoreBinaria.getRaiz());
					console.imprimir(this.arvoreBinaria.getElemento());
					this.arvoreBinaria.inicializaElemento();
					break;
					
				case "7":
					
					this.finalizar();
					break;
					
				default:
					
					console.imprimir("Escolha uma opção do menu.");
					break;
					
			}
			
		} while(true);
		
	}
	
	/**
	 * Finaliza a aplicação.
	 */
	private void finalizar() {
		
		console.imprimir("Aplicação encerrada.");
		System.exit(0);
		
	}
	
}
