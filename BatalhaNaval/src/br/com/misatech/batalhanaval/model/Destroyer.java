package br.com.misatech.batalhanaval.model;

/**
 * Representa o Destroyer.
 * 
 * @author Misael C. Homem
 * @since 1.00
 *
 */
public class Destroyer extends Navio {
	
	private String posPart1;
	private String posPart2;
	private String posPart3;
	private String posPart4;
	
	/**
	 * Construtor padrão.
	 */
	public Destroyer() {
		
		super(4);
		
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

	public String getPosPart3() {
		return posPart3;
	}

	public void setPosPart3(String posPart3) {
		this.posPart3 = posPart3;
	}

	public String getPosPart4() {
		return posPart4;
	}

	public void setPosPart4(String posPart4) {
		this.posPart4 = posPart4;
	}

}
