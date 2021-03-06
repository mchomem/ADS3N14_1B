package br.com.misatech.ordenacao.model;

import java.util.Random;

/**
 * Classe contendo os algorimos para ordena��o: Insert Sort e Heap Sort.
 * 
 * @author Misael C. Homem
 * @since 1.00
 *
 */
public class Ordenacao {
	
	private long countInsertSort;
	private long countHeapSort;
	private long countChangeInsertSort;
	private long countChangeHeapSort;
	private int[] arranjo;
	
	/**
	 * Construtor da classe.
	 */
	public Ordenacao() {}
	
	/**
	 * Gera um array de inteiros aleat�rios. 
	 * 
	 * @param num O tamanho do array 
	 * @return Um tipo array de inteiros aleat�rios.
	 */
	public int[] gerarArray(int num) {
		
		Random random = new Random();
		arranjo = new int[num];
		
		for(int i = 0; i < arranjo.length; i++) {
			
			arranjo[i] = random.nextInt(num + 1);
			
		}
		
		return arranjo;
		
	}
	
	/**
	 * Implementa��o do InsertSort.
	 */
	public void InsertSort() {
		
		// Inicia o arrayauxilizar com o tamanho do original.
		int[] arrayInsert = new int[arranjo.length];
		
		// ALimentando o array auxiliar indice a indice do array original.
		for(int i = 0; i < arranjo.length; i++) {
			
			arrayInsert[i] = arranjo[i];
			
		}
		
        for(int fixo = 1; fixo <= arrayInsert.length; fixo++) {
        	 
        	int x = fixo - 1;
        	int y = fixo;
 
        	while(y != 0 && y != arrayInsert.length && arrayInsert[x] > arrayInsert[y]) {
    			
        		this.countInsertSort++;
        		this.countChangeInsertSort++;
        		
        		int a = arrayInsert[x];
        		arrayInsert[x] = arrayInsert[y];
        		arrayInsert[y] = a;
        		x--;
        		y--;
        		
           }
        	
        }
		
	}
	
	/**
	 * Implementa��o do HeapSort.
	 */
	public void HeapSort() {
		
		// Inicia o arrayauxilizar com o tamanho do original.
		int[] arrayHeapSort = new int[arranjo.length];
		
		// ALimentando o array auxiliar indice a indice do array original.
		for(int i = 0; i < arranjo.length; i++) {
			
			arrayHeapSort[i] = arranjo[i];
			
		}
		
        buildMaxHeap(arrayHeapSort);
        int n = arrayHeapSort.length;

        for (int i = arrayHeapSort.length - 1; i > 0; i--) {
        	
           swap(arrayHeapSort, i , 0);
           maxHeapify(arrayHeapSort, 0, --n);
           
        }
       
	}

	/**
	 * M�todo auxiliar para HeapSort().
	 * 
	 * @param v O array de aleat�rios.
	 */
	private void buildMaxHeap(int[] v) {
		
		for (int i = v.length / 2 - 1; i >= 0; i--) {
			
			maxHeapify(v, i, v.length);
			
		}
		
	}
	
	/**
	 * M�todo auxiliar para HeapSort().
	 * 
	 * @param v
	 * @param pos
	 * @param n
	 */
	private void maxHeapify(int[] v, int pos, int n) {
		
		int maxi  = 0;
        int l     = 2 * pos + 1;
        int right = 2 * pos + 2;
         
        if ((l < n) && (v[l] > v[pos])) {
        	
            maxi = l;
            this.countHeapSort++;
            
        } else {

    		maxi = pos;
    		this.countHeapSort++;
    		
        }
         
        if (right < n && v[right] > v[maxi]) {
            
        	maxi = right;
        	this.countHeapSort++;
        	
        }
         
        if (maxi != pos) {
        	 
        	swap(v, pos, maxi);
            maxHeapify(v, maxi, n);
            this.countHeapSort++;
            
        }
         
	}
	
	/**
	 * M�todo auxilaiar para HeapSort().
	 * 
	 * @param v
	 * @param j
	 * @param aposJ
	 */
	private void swap (int[] v, int j, int aposJ) {
		
		this.countChangeHeapSort++;
		int aux  = v[j];
		v[j]     = v[aposJ];
		v[aposJ] = aux;

	}
	
	// Getter's and Setter's
	public long getCountInsertSort() {
		return countInsertSort;
	}

	public void setCountInsertSort(long countInsertSort) {
		this.countInsertSort = countInsertSort;
	}

	public long getCountHeapSort() {
		return countHeapSort;
	}

	public void setCountHeapSort(long countHeapSort) {
		this.countHeapSort = countHeapSort;
	}

	public long getCountChangeInsertSort() {
		return countChangeInsertSort;
	}

	public void setCountChangeInsertSort(long countChangeInsertSort) {
		this.countChangeInsertSort = countChangeInsertSort;
	}

	public long getCountChangeHeapSort() {
		return countChangeHeapSort;
	}

	public void setCountChangeHeapSort(long countChangeHeapSort) {
		this.countChangeHeapSort = countChangeHeapSort;
	}

}
