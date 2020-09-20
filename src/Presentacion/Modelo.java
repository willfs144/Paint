package Presentacion;

import java.awt.Color;
import Logica.Sistema;

public class Modelo {
	
	public static final String COLOR_NEGRO = "negro";
	public static final String COLOR_AZUL = "azul";	
	public static final String COLOR_VERDE = "verde";
	public static final String COLOR_ROJO = "rojo";
	public static final String COLOR_MAGENTA = "magenta";
	public static final String COLOR_GRIS = "gris";
	public static final String COLOR_NARANJA = "naranja";
	public static final String COLOR_AMARILLO = "amarillo";
	public static final String COLOR_ROSADO = "rosado";
	public static final String COLOR_CIAN = "cian";
	public static final String COLOR_GRIS_CLARO = "gris claro";
	public static final String COLORPICKER = "colorPicker";
	
	public static final String ELEMENTO_TEXTO = "texto";
	public static final String ELEMENTO_COLOR_PINTURA = "lleno";
	public static final String ELEMENTO_COLOR_SIN_PINTURA = "libre";
	
	public static final String FIGURA_LINEA = "linea";
	public static final String FIGURA_RECTANGULO = "rectangulo";
	public static final String FIGURA_CIRCULO = "circulo";
	public static final String FIGURA_LAPIZ = "lapiz";
	
	
	
			
	private VistaDibujo vistaDibujo;
	private VistaPrincipal vistaPrincipal;
	private Sistema sistema;
	
	private String tipoFigura;
	private String contextoFigura;
	private Color color;
	private int grosorLinea;

	public void iniciar() {
		
		this.tipoFigura = FIGURA_LAPIZ;
		this.contextoFigura = ELEMENTO_COLOR_SIN_PINTURA;
		this.color = Color.black;		
		
		this.vistaPrincipal = new VistaPrincipal(this);
		this.vistaPrincipal.setSize(980, 700);
		this.vistaPrincipal.setVisible(true);		
		this.vistaDibujo = vistaPrincipal.getVistaDibujo();
		this.sistema = new Sistema();
		this.sistema.crearFigura(0, 0, FIGURA_LAPIZ);
		this.vistaDibujo.setFigura(sistema.getFigura());
		this.vistaDibujo.setFiguras(sistema.getFiguras());
		
	}

	public void cerrarPaint() {		
	 this.vistaPrincipal.setVisible(false);	
	 this.vistaPrincipal.dispose();		
	}
	
	
	public void agregarCualidadFigura(String elementoColor) {
		if(this.tipoFigura == FIGURA_RECTANGULO || this.tipoFigura == FIGURA_CIRCULO) {
			if (elementoColor.equals(ELEMENTO_COLOR_PINTURA)) {
				this.vistaPrincipal.getVistaBotones().getBtnPicture().setVisible(false);
				this.vistaPrincipal.getVistaBotones().getBtnSinPicture().setVisible(true);			
			}
			else if(elementoColor.equals(ELEMENTO_COLOR_SIN_PINTURA)) {
				this.vistaPrincipal.getVistaBotones().getBtnSinPicture().setVisible(false);
				this.vistaPrincipal.getVistaBotones().getBtnPicture().setVisible(true);			
			}		
			this.contextoFigura = elementoColor;
		}
	}
	
	public void agregarTextoFigura(String elementoTexto) {
		String texto = this.vistaPrincipal.getVistaBotones().capturarTextoDialog();
		if (texto != null) {
			this.tipoFigura = elementoTexto;
			this.contextoFigura = texto;
		}			
	}
	
	
	public void crearFigura(int posicionX1, int posicionY1) {		
		this.sistema.crearFigura(posicionX1, posicionY1, this.tipoFigura);
			if(tipoFigura ==  FIGURA_LAPIZ){				
				gurdarDibujoLapiz();
				actualizarTablero();
				this.vistaDibujo.setForma(null);
				this.vistaDibujo.iniciarDibujo();				
			}
			else if (tipoFigura == ELEMENTO_TEXTO) 
				actualizarTablero();	
			
		this.sistema.getFigura().setColor(this.color);
		this.sistema.getFigura().setGrosorBorde(this.grosorLinea);
		this.sistema.getFigura().setContexto(this.contextoFigura);
		guardarFigura();
		
	}	


	public void dibujarFigura(int ancho, int alto) {
		this.sistema.getFigura().setAncho(ancho);
		this.sistema.getFigura().setAlto(alto);
		if(tipoFigura == FIGURA_RECTANGULO || tipoFigura == FIGURA_CIRCULO )
			this.sistema.calcularLadosFiguraCuadratica();
		else if(tipoFigura == FIGURA_LAPIZ) {
			this.vistaDibujo.moverLinea();
		}
		actualizarTablero();
	}
	
	public void rehacerFigura() {
		int indexFiguraRespaldo = this.sistema.getFigurasRespaldo().size()-1;		
		
		if (indexFiguraRespaldo >= 0) {
			String tipoFiguraRespaldo = this.sistema.getFigurasRespaldo().get(indexFiguraRespaldo).getTipo();
			this.sistema.getFiguras().add(this.sistema.getFigurasRespaldo().get(indexFiguraRespaldo));
			this.sistema.getFigurasRespaldo().remove(indexFiguraRespaldo);
			
			if (tipoFiguraRespaldo.equals(FIGURA_LAPIZ)) {
				int indexShape = this.sistema.getShapesRespaldo().size()-1;			
				this.sistema.getShapes().add(this.sistema.getShapesRespaldo().get(indexShape));
				this.sistema.getShapesRespaldo().remove(indexShape);
			}
			actualizarTablero();
		}
		
	}


	public void deshacerFigura() {
		int indexFigura = this.sistema.getFiguras().size()-1;
				
		if (indexFigura >= 0) {
			String tipoFigura = this.sistema.getFiguras().get(indexFigura).getTipo();
			this.sistema.getFigurasRespaldo().add(this.sistema.getFiguras().get(indexFigura));
			this.sistema.getFiguras().remove(indexFigura);
			
			if (tipoFigura.equals(FIGURA_LAPIZ)) {
				int indexShape = this.sistema.getShapes().size()-1;			
				this.sistema.getShapesRespaldo().add(this.sistema.getShapes().get(indexShape));
				this.sistema.getShapes().remove(indexShape);
			}
			actualizarTablero();
		}
		
	}
	

	private void actualizarTablero() {
		this.vistaDibujo.setShapes(this.sistema.getShapes());
		this.vistaDibujo.setFiguras(this.sistema.getFiguras());
		this.vistaDibujo.setFigura(this.sistema.getFigura());
		this.vistaDibujo.repaint();	
		
	}
	
	
	public void grosorBordeFigura(int grosorBorde) {
		this.grosorLinea = grosorBorde;
	}
	
	public void tipoFigura(String tipoFigura) {
		this.tipoFigura = tipoFigura;		
	}
	
	private void gurdarDibujoLapiz() {
		this.sistema.getShapes().add(this.vistaDibujo.getForma());
		System.out.println("Tamaño: Shapes"+sistema.getShapes().size());		
	}
	
	private void guardarFigura() {
		this.sistema.getFiguras().add(sistema.getFigura());
		System.out.println("Tamaño Figuras: "+sistema.getFiguras().size());		
	}
	
	public void limpiarDibujo() {
		this.sistema = new Sistema();
		this.vistaDibujo.limpiar();	
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
	
	public void capturarPaletaColor() {
		this.vistaPrincipal.getVistaBotones().getPaletaColores();
		this.color = this.vistaPrincipal.getVistaBotones().getColor();		
	}
	//PRINCIPIO DE OCULTACION DE INFORMACION

	public VistaPrincipal getVistaPrincipal() {		
		return vistaPrincipal;
	}	

	public Sistema getSistema() {
		return sistema;
	}


	

	


	



	


	

	
	
		

}
