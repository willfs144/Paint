package Presentacion;

import java.awt.Color;
import Logica.Sistema;

public class Modelo {
	
	public final static String COLOR_NEGRO = "negro";
	public final static String COLOR_AZUL = "azul";	
	public final static String COLOR_VERDE = "verde";
	public final static String COLOR_ROJO = "rojo";
	public final static String COLOR_MAGENTA = "magenta";
	public final static String COLOR_GRIS = "gris";
	public final static String COLOR_NARANJA = "naranja";
	public final static String COLOR_AMARILLO = "amarillo";
	public final static String COLOR_ROSADO = "rosado";
	public final static String COLOR_CIAN = "cian";
	public final static String COLOR_GRIS_CLARO = "gris claro";
	
	public final static String FIGURA_LINEA = "linea";
	public final static String FIGURA_RECTANGULO = "rectangulo";
	public final static String FIGURA_LAPIZ = "lapiz";
			
	private VistaDibujo vistaDibujo;
	private VistaPrincipal vistaPrincipal;
	private Sistema sistema;
	
	private String tipoFigura;
	private Color color;
	private int grosorLinea;

	public void iniciar() {
		this.tipoFigura = FIGURA_LAPIZ;
		this.color = Color.black;

		this.vistaPrincipal = new VistaPrincipal(this);
		this.vistaPrincipal.setSize(980, 700);
		this.vistaPrincipal.setVisible(true);		
		this.vistaDibujo = vistaPrincipal.getVistaDibujo();
		this.sistema = new Sistema(FIGURA_LAPIZ);
		this.vistaDibujo.setFigura(sistema.getFigura());
		
	}	
	
	public void colorear(String Evento) {
		
	}
	
	
	
	public void crearFigura(int posicionX1, int posicionY1) {
		this.sistema.crearFigura(posicionX1, posicionY1, this.tipoFigura);
			if(tipoFigura ==  FIGURA_LAPIZ ){
				this.vistaDibujo.setFigura(this.sistema.getFigura());
				this.vistaDibujo.iniciarDibujo();				
			}
		this.sistema.getFigura().setColor(this.color);
		this.sistema.getFigura().setGrosorBorde(this.grosorLinea);
	}
	
	public void dibujarFigura(int ancho, int alto) {
		this.sistema.getFigura().setAncho(ancho);
		this.sistema.getFigura().setAlto(alto);
		if(tipoFigura == FIGURA_RECTANGULO )
			this.sistema.calcularLadosFiguraCuadratica();
		else if(tipoFigura == FIGURA_LAPIZ) {
			this.vistaDibujo.moverLinea();
		}		
		this.vistaDibujo.setFigura(this.sistema.getFigura());
		this.vistaDibujo.repaint(); 
	
	}
	
	
	
	public void grosorBordeFigura(int grosorBorde) {
		this.grosorLinea = grosorBorde;
	}
	
	public void tipoFigura(String tipoFigura) {
		this.tipoFigura = tipoFigura;		
	}
	
	public void cambiarColor(String color) {
		switch (color) {
			case COLOR_NEGRO:
				this.color = Color.BLACK;
				break;
			case COLOR_AZUL:
				this.color = Color.BLUE;
				break;
			case COLOR_VERDE:
				this.color = Color.GREEN;
				break;
			case COLOR_ROJO:
				this.color = Color.RED;
				break;
			case COLOR_MAGENTA:
				this.color = Color.MAGENTA;
				break;
			case COLOR_GRIS:
				this.color = Color.GRAY;
				break;
			case COLOR_NARANJA:
				this.color = Color.ORANGE;
				break;
			case COLOR_AMARILLO:
				this.color = Color.YELLOW;
				break;
			case COLOR_ROSADO:
				this.color = Color.PINK;
				break;
			case COLOR_CIAN:
				this.color = Color.CYAN;
				break;
			case COLOR_GRIS_CLARO:
				this.color = Color.LIGHT_GRAY;
				break;
			default:
				this.color = Color.BLACK;
				break;
		}
	}
	
	//PRINCIPIO DE OCULTACION DE INFORMACION

	public VistaPrincipal getVistaPrincipal() {		
		return vistaPrincipal;
	}
	
	

	public Sistema getSistema() {
		return sistema;
	}


	public void limpiarDibujo() {
		this.vistaDibujo.limpiar();	
	}


	public void rehacerFigura() {
		// TODO Auto-generated method stub
		
	}


	public void deshacerFigura() {
		// TODO Auto-generated method stub
		
	}

	
	
		

}
