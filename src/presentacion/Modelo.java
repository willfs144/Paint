package presentacion;

import java.awt.Color;

import logica.Figura;
import logica.Sistema;

public class Modelo {
					
	private VistaDibujo vistaDibujo;
	private VistaBotones vistaBotones;
	private VistaPrincipal vistaPrincipal;
	
	private Sistema sistema;
	
	private String tipoFigura;
	private String contextoFigura;
	private Color color;
	private int grosorLinea;

	public void iniciar() {
		
		this.tipoFigura = Figura.LAPIZ;
		this.contextoFigura = Figura.COLOR_SIN_PINTURA;
		this.color = Color.black;		
		
		this.vistaPrincipal = new VistaPrincipal(this);
		this.vistaPrincipal.setSize(980, 700);
		this.vistaPrincipal.setVisible(true);		
		this.vistaDibujo = vistaPrincipal.getVistaDibujo();
		this.vistaBotones = vistaPrincipal.getVistaBotones();
		this.sistema = new Sistema();
		this.sistema.crearFigura(0, 0, Figura.LAPIZ);
		this.vistaDibujo.setFigura(sistema.getFigura());
		this.vistaDibujo.setFiguras(sistema.getFiguras());
		
	}

	
	
	public void abrir() {
		this.vistaPrincipal.showDialogAbrir();
		this.vistaDibujo.setImagenPaint(this.vistaPrincipal.getImagen());
		this.vistaDibujo.repaint();
	}

	public void guardar() {
		this.vistaPrincipal.setImagen(this.vistaDibujo.getImagenPaint());
		this.vistaPrincipal.showDialogGuardar();		
	}
	
	
	public void agregarCualidadFigura(String elementoColor) {
		if(this.tipoFigura == Figura.RECTANGULO || this.tipoFigura == Figura.CIRCULO) {
			if (elementoColor.equals(Figura.COLOR_PINTURA)) {
				this.vistaBotones.getBtnPicture().setVisible(false);
				this.vistaBotones.getBtnSinPicture().setVisible(true);			
			}
			else if(elementoColor.equals(Figura.COLOR_SIN_PINTURA)) {
				this.vistaBotones.getBtnSinPicture().setVisible(false);
				this.vistaBotones.getBtnPicture().setVisible(true);			
			}		
			this.contextoFigura = elementoColor;
		}
	}
	
	public void agregarTextoFigura(String elementoTexto) {
		String texto = this.vistaBotones.capturarTextoDialog();
		if (texto != null) {
			this.tipoFigura = elementoTexto;
			this.contextoFigura = texto;
		}
		if (texto == "") {
			this.tipoFigura = "";
		}
	}	
	
	public void crearFigura(int posicionX1, int posicionY1) {		
		this.sistema.crearFigura(posicionX1, posicionY1, this.tipoFigura);
		this.sistema.getFigura().setColor(this.color);
		this.sistema.getFigura().setGrosorBorde(this.grosorLinea);
		this.sistema.getFigura().setContexto(this.contextoFigura);
		
		if(tipoFigura ==  Figura.LAPIZ){		
			actualizarTablero();			
			this.vistaDibujo.iniciarDibujo();			
		}
		else if (tipoFigura == Figura.TEXTO) 
			actualizarTablero();		
		
		if(tipoFigura !=  Figura.LAPIZ)
			guardarFigura();		
	}

	public void dibujarFigura(int ancho, int alto) {
		this.sistema.getFigura().setAncho(ancho);
		this.sistema.getFigura().setAlto(alto);
		if(tipoFigura == Figura.RECTANGULO || tipoFigura == Figura.CIRCULO )
			this.sistema.calcularLadosFiguraCuadratica();
		else if(tipoFigura == Figura.LAPIZ) {
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
			
			if (tipoFiguraRespaldo.equals(Figura.LAPIZ)) {
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
			
			if (tipoFigura.equals(Figura.LAPIZ)) {
				int indexShape = this.sistema.getShapes().size()-1;			
				this.sistema.getShapesRespaldo().add(this.sistema.getShapes().get(indexShape));
				this.sistema.getShapes().remove(indexShape);
			}
			actualizarTablero();
		}
		
	}	

	private void actualizarTablero() {		
		this.vistaDibujo.setFiguras(this.sistema.getFiguras());
		this.vistaDibujo.setFigura(this.sistema.getFigura());
		this.vistaDibujo.setShapes(this.sistema.getShapes());
		this.vistaDibujo.repaint();	
		
	}	
	
	public void grosorBordeFigura(int grosorBorde) {
		this.grosorLinea = grosorBorde;
	}
	
	public void tipoFigura(String tipoFigura) {
		this.tipoFigura = tipoFigura;		
	}
	
	public void guardarDibujoLapiz() {
		if(tipoFigura ==  Figura.LAPIZ) {
			guardarFigura();
			this.sistema.getShapes().add(this.vistaDibujo.getForma());
			System.out.println("Tamaño: Shapes"+sistema.getShapes().size());
		}
	}
	
	public void guardarFigura() {
		this.sistema.getFiguras().add(sistema.getFigura());
		System.out.println("Tamaño Figuras: "+sistema.getFiguras().size());		
	}
	
	public void limpiarDibujo() {
		this.sistema = new Sistema();
		this.vistaDibujo.limpiar();	
	}
		
	public void cambiarColor(String color) {
		switch (color) {
			case Figura.COLOR_NEGRO:
				this.color = Color.BLACK;
				break;
			case Figura.COLOR_AZUL:
				this.color = Color.BLUE;
				break;
			case Figura.COLOR_VERDE:
				this.color = Color.GREEN;
				break;
			case Figura.COLOR_ROJO:
				this.color = Color.RED;
				break;
			case Figura.COLOR_MAGENTA:
				this.color = Color.MAGENTA;
				break;
			case Figura.COLOR_GRIS:
				this.color = Color.GRAY;
				break;
			case Figura.COLOR_NARANJA:
				this.color = Color.ORANGE;
				break;
			case Figura.COLOR_AMARILLO:
				this.color = Color.YELLOW;
				break;
			case Figura.COLOR_ROSADO:
				this.color = Color.PINK;
				break;
			case Figura.COLOR_CIAN:
				this.color = Color.CYAN;
				break;
			case Figura.COLOR_GRIS_CLARO:
				this.color = Color.LIGHT_GRAY;
				break;
			default:
				this.color = Color.BLACK;
				break;
		}
	}
	
	public void capturarPaletaColor() {
		this.vistaBotones.getPaletaColores();
		this.color = this.vistaBotones.getColor();		
	}
	//PRINCIPIO DE OCULTACION DE INFORMACION

	public VistaPrincipal getVistaPrincipal() {		
		return vistaPrincipal;
	}	

	public Sistema getSistema() {
		return sistema;
	}

	


	

	


	



	


	

	
	
		

}
