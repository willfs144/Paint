package Logica;

import java.awt.Color;
import java.awt.Shape;

public class Figura extends Elemento{
	
	
	private String tipo;
	private Color color;
	private int grosorBorde;
	private int ancho;
	private int alto;
		
	
	public Figura() {
		super(0,0);
	}

	public Figura(int x1, int y1, String tipo) {
		super(x1, y1);
		this.tipo = tipo;
	}
	
	public int getGrosorBorde() {
		return grosorBorde;
	}
	public void setGrosorBorde(int grosorBorde) {
		this.grosorBorde = grosorBorde;
	}
	public int getAncho() {
		return ancho;
	}
	public void setAncho(int ancho) {
		this.ancho = ancho;
	}
	public int getAlto() {
		return alto;
	}
	public void setAlto(int alto) {
		this.alto = alto;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	
	
	
	
		

}
