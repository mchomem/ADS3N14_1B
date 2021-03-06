package br.com.misatech.batalhanaval.model;

/**
 * Representa o Torpedeiro.
 * 
 * @author Misael C. Homem
 * @since 1.00
 *
 */
public class Torpedeiro extends Navio {

	private String posPart1;
	private String posPart2;
	
	/**
	 * Construtor padr�o.
	 */
	public Torpedeiro() {
		
		super(2);
		
	}

	public String getPosPart1() {
		return posPart1;
	}

	public void setPosPart1(String posPart1) {
		this.posPart1 = posPart1;
	}

	public String getPosPart2() {
		return posPart2;
	}

	public void setPosPart2(String posPart2) {
		this.posPart2 = posPart2;
	}
	
}
