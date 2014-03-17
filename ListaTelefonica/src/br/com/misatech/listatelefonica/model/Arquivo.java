package br.com.misatech.listatelefonica.model;

import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Classe responsável por gerar um arquivo no disco e gravar informações.
 * 
 * @author Misael C. Homem
 * @since 1.00
 */
public class Arquivo {
	
	private final String CAMINHO_ARQUIVO = "Dados\\listaTelefonica.txt";
	private FileReader arq;
	private BufferedReader lerArq;
	
	/**
	 * Construtor padrão da classe com inicializações.
	 */
	public Arquivo() throws HeadlessException, IOException {
		
		arq = new FileReader(CAMINHO_ARQUIVO);
		lerArq = new BufferedReader(arq);
		
	}

	/**
	 * Grava um registro no arquivo texto.
	 * 
	 * @param registroLinha O valor para se gravar em uma linha do arquivo texto.
	 * @throws IOException Disparado se caso houver falha de Entrada/Saída.
	 */
	public void gravar(String registroLinha) throws IOException  {
		
		FileWriter arq = new FileWriter(CAMINHO_ARQUIVO, true);
		PrintWriter gravaArq = new PrintWriter(arq);
		
		gravaArq.println(registroLinha);
		arq.close();
		
		System.out.println("Valor gravador com sucesso!");
		
	}
	
	/**
	 * Consulta o arquivo texto.
	 * 
	 * @throws HeadlessException Disparado quando o código que é dependente de um teclado, monitor ou mouse<br>
	 * é chamado em um ambiente que não suporta um teclado, monitor ou mouse.
	 * 
	 * @throws IOException Disparado se caso houver falha de Entrada/Saída.
	 */
	public String consultar() throws HeadlessException, IOException {
		
		String linha = lerArq.readLine();
	
		return linha;
		
	}
	
	public boolean excluiItemLista(String nome) throws IOException {
		
		boolean contatoLocalizado = false;
		
		FileReader arq = new FileReader(CAMINHO_ARQUIVO);
		BufferedReader lerArq = new BufferedReader(arq);
		String linhaArquivo;
		String conteudo = "";
		
		while( (linhaArquivo = lerArq.readLine())!= null) {

			String[] valores = linhaArquivo.split("\\|");
			
			// O valor informado é igual ao do contato (ignorando caixa alta ou baixa)
			if(valores[0].equalsIgnoreCase(nome)) {
				// Atualiza a linha
				conteudo += valores[0] + "|" + valores[1] + "|N,";
				contatoLocalizado = true;
				
			} else {
				conteudo += linhaArquivo + ",";
			}
			
	    }
		
		arq.close();
		
		String[] conteudonovo = conteudo.split("\\,");
		
		// Inicializar o conteúdo do arquivo.
		FileWriter zerarArquivo = new FileWriter(CAMINHO_ARQUIVO);
		PrintWriter gravaArqBranco = new PrintWriter(zerarArquivo);
		gravaArqBranco.print("");
		zerarArquivo.close();
		// Fim:  Inicializar o conteúdo do arquivo.
		
		// Itera sobre o arquivo, desta anexando todos os dados alterados!
		FileWriter arqnovo = new FileWriter(CAMINHO_ARQUIVO, true);
		PrintWriter gravaArq = new PrintWriter(arqnovo);
		
		for (int i = 0; i < conteudonovo.length; i++) {
			
			gravaArq.println(conteudonovo[i]);
			
		}
		
		arqnovo.close();
		
		return contatoLocalizado;
		
	}
	
}
