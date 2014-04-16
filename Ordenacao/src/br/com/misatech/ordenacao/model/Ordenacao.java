package br.com.misatech.ordenacao.model;

import java.util.Random;

/**
 * Classe contendo os algorimos para ordenação: Insert Sort e Heap Sort.
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
	private int[] array;
	
	public Ordenacao() {}
	
	/**
	 * Gera um array de inteiros aleatórios. 
	 * 
	 * @param num O tamanho do array 
	 * @return Um tipo array de inteiros aleatórios.
	 */
	public int[] gerarArray(int num) {
		
		Random random = new Random();
		array = new int[num];
		
		for(int i = 0; i < array.length; i++) {
			
			array[i] = random.nextInt(num + 1);
			
		}
		
		return array;
		
	}
	
	/**
	 * Implementação do InsertSort.
	 */
	public void InsertSort() {
		
		int[] arrayInsert = array;
		
        for(int fixo = 1; fixo <= arrayInsert.length; fixo++) {
        	 
        	int x = fixo - 1;
        	int y = fixo;
 
        	while(y != 0 && y != arrayInsert.length && arrayInsert[x] > arrayInsert[y]) {
    			
        		countInsertSort++;
        		
        		int a = arrayInsert[x];
        		arrayInsert[x] = arrayInsert[y];
        		arrayInsert[y] = a;
        		x--;
        		y--;
        		
           }
        	
        }
		
	}
	
	/**
	 * Implementação do HeapSort.
	 */
	public void HeapSort() {
		
		int[] arrayHeapSort = array;
        buildMaxHeap(arrayHeapSort);
        int n = arrayHeapSort.length;

        for (int i = arrayHeapSort.length - 1; i > 0; i--) {
        	
           swap(arrayHeapSort, i , 0);
           maxHeapify(arrayHeapSort, 0, --n);
           
        }
       
	}

	/**
	 * Método auxiliar para HeapSort().
	 * 
	 * @param v O array de aleatórios.
	 */
	private void buildMaxHeap(int[] v) {
		
		for (int i = v.length/2 - 1; i >= 0; i--) {
			
			maxHeapify(v, i , v. length );
			
		}
		
	}
	
	/**
	 * Método auxilaiar para HeapSort().
	 * 
	 * @param v
	 * @param pos
	 * @param n
	 */
	private void maxHeapify(int[] v, int pos, int n) {
		
		int maxi  = 0;
        int l     = 2 * pos + 1;
        int right = 2 * pos + 2;
         
        if ( (l < n) && (v[l] > v[pos]) ) {
        	
            maxi = l;
            
        } else {

    		maxi = pos;
            
        }
         
        if (right < n && v[right] > v[maxi]) {
            
        	maxi = right;
        	 
        }
         
        if (maxi != pos) {
        	 
        	swap(v, pos, maxi);
            maxHeapify(v, maxi, n);
            
        }
         
	}
	
	/**
	 * Método auxilaiar para HeapSort().
	 * 
	 * @param v
	 * @param j
	 * @param aposJ
	 */
	private void swap (int[] v, int j, int aposJ) {
		
		countHeapSort++;
		int aux  = v[j];
		v[j]     = v[aposJ];
		v[aposJ] = aux;

	}
	
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
