package Logica;

import java.awt.Color;

public class Elemento {
	
	public static final String TEXTO = "texto";
	public static final String COLOR_PINTURA = "lleno";
	public static final String COLOR_SIN_PINTURA = "libre";

	private int posicionX1;
	private int posicionY1;
	private String contexto;
	
	public Elemento(int posicionX1, int posicionY1) {
		this.posicionX1 = posicionX1;
		this.posicionY1 = posicionY1;
	}

	public int getPosicionX1() {
		return posicionX1;
	}

	public void setPosicionX1(int posicionX1) {
		this.posicionX1 = posicionX1;
	}

	public int getPosicionY1() {
		return posicionY1;
	}

	public void setPosicionY1(int posicionY1) {
		this.posicionY1 = posicionY1;
	}

	public String getContexto() {
		return contexto;
	}

	public void setContexto(String contexto) {
		this.contexto = contexto;
	}

	

	

	
	

	
	
	
	
	
	
	
	

}
