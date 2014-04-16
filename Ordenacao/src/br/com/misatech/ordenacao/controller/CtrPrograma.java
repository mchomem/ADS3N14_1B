package br.com.misatech.ordenacao.controller;

import br.com.misatech.ordenacao.model.Ordenacao;
import br.com.misatech.ordenacao.view.Console;

public class CtrPrograma {
	
	private Console   console;
	private Ordenacao ordenacao;
	
	public CtrPrograma() {
		
		console   = new Console();
		ordenacao = new Ordenacao();
		
	}
	
	public void iniciar() {
		
		String opcao = "";
		
		do {
			
			console.imprimir("*** Menu ***\n");
			console.imprimir("1 - Executar ordena��o.");
			console.imprimir("0 - Encerrar programa.");
			
			opcao = console.cursor("Op��o");
			
			switch (opcao) {
			
			case "1":
						
				ordenacao.gerarArray(Integer.parseInt(console.cursor("Informe o tamanho do array")));		
				ordenacao.InsertSort();
				ordenacao.HeapSort();
				
				console.imprimir("Quantidade de compara��es:");
				console.imprimir("Insert Sort:\t" + ordenacao.getCountInsertSort());
				console.imprimir("Heap Sort:\t"   + ordenacao.getCountHeapSort());
				
				// Inicia o valor dos campos da Ordena��o.
				ordenacao.setCountInsertSort(0);
				ordenacao.setCountHeapSort(0);
				
				console.imprimir("Quantidade de trocas:");
				console.imprimir("Insert Sort:\t" + ordenacao.getCountChangeInsertSort());
				console.imprimir("Heap Sort:\t"   + ordenacao.getCountChangeHeapSort());
				
				// Inicia o valor dos campos da Ordena��o.
				ordenacao.setCountChangeInsertSort(0);
				ordenacao.setCountChangeHeapSort(0);
				
				break;

			case "0":
				
				this.finalizar();
				break;
				
			default:
				
				console.imprimir("Escolha uma das op��es do menu.");
				break;
				
			}
		
		} while(true);
		
	}
	
	public void finalizar() {
		
		console.imprimir("Programa encerrado.");
		System.exit(0);
		
	}

}
