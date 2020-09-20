package Presentacion;

import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Path2D;
import java.util.ArrayList;

import Logica.Figura;

public class VistaDibujo extends Canvas{
	
	private Figura figura;
	private ArrayList<Figura> figuras;
	private ArrayList<Shape> shapes;
	private Path2D forma;
	private Graphics2D draw;
	
	private String evento;
	
	private ControladorDibujo controlEventosDibujo;
	private Modelo modelo;
	
	
	public VistaDibujo(Modelo modelo) {
		this.modelo = modelo;
		this.controlEventosDibujo = new ControladorDibujo(this);
		this.addMouseListener(controlEventosDibujo);
		this.addMouseMotionListener(controlEventosDibujo);
		this.forma = new Path2D.Float();
	}

	public void paint(Graphics g ) {
		
		this.draw= (Graphics2D) g;
		draw.setColor(Color.WHITE);
		draw.fillRect(0, 0, this.getWidth(), this.getHeight());		
		
		if (!forma.equals(null)) {				
			draw.setStroke(new BasicStroke(figura.getGrosorBorde()));
			draw.setColor(figura.getColor());
			draw.draw(forma);					
		}
		
		int index=0;
		for (Figura figura: figuras) {
			
			if (figura.getTipo().equals(modelo.FIGURA_LAPIZ)) {				
				draw.setStroke(new BasicStroke(figura.getGrosorBorde()));
				draw.setColor(figura.getColor());
				draw.draw(shapes.get(index));
				index++;
			}
			
			if (figura.getTipo().equals(modelo.FIGURA_LINEA)) {	
				draw.setStroke(new BasicStroke(figura.getGrosorBorde()));
				draw.setColor(figura.getColor());
				draw.drawLine(figura.getPosicionX1(),figura.getPosicionY1(),figura.getAncho(), figura.getAlto());				
			}
			
			if (figura.getTipo() == modelo.FIGURA_RECTANGULO) {
				draw.setStroke(new BasicStroke(figura.getGrosorBorde()));
				draw.setColor(figura.getColor());
				draw.drawRect(figura.getPosicionX1(), figura.getPosicionY1(), 
							figura.getAncho(), figura.getAlto());
			}
			if (figura.getTipo() == modelo.FIGURA_CIRCULO) {
				draw.setStroke(new BasicStroke(figura.getGrosorBorde()));
				draw.setColor(figura.getColor());
				draw.drawOval(figura.getPosicionX1(), figura.getPosicionY1(), 
						figura.getAncho(), figura.getAlto());				
			}
		}
		
		if(this.evento == "Limpiar") {
			draw.setPaint(Color.white);
			draw.fillRect(0, 0, this.getWidth(), this.getHeight());
			this.forma = new Path2D.Float();
			this.evento = "";
		}		
		
	}

	public void moverLinea() {
		this.forma.lineTo(figura.getAncho(), figura.getAlto());
	}
	
	public void iniciarDibujo() {
		this.forma = new Path2D.Float();
		this.forma.moveTo(figura.getPosicionX1(), figura.getPosicionY1());		
	}
	
	public void limpiar() {
		this.evento = "Limpiar";
		this.repaint();
	}
	
	public ControladorDibujo getControl() {
		return controlEventosDibujo;
	}

	public Modelo getModelo() {
		return modelo;
	}
	
	public Path2D getForma() {
		return forma;
	}
	
	
	public void setForma(Path2D forma) {
		this.forma = forma;
	}

	public void setShapes(ArrayList<Shape> shapes) {
		this.shapes = shapes;
	}

	public void setFigura(Figura figura) {
		this.figura = figura;
		
	}

	public void setFigura(ArrayList<Figura> figuras) {
		this.figuras = figuras;		
	}
	

	
	
	
	


	
	
	
	
	

	
}
