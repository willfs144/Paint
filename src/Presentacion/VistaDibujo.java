package Presentacion;

import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Path2D;
import java.awt.geom.Path2D.Float;

import Logica.Figura;

public class VistaDibujo extends Canvas{
	
	private Figura figura;
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
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		draw.setStroke(new BasicStroke(figura.getGrosorBorde()));
		draw.setColor(figura.getColor());
		
		if (figura.getTipo() == modelo.FIGURA_LAPIZ && forma != null) {			
				draw.draw(forma);				
		}
		
		if (figura.getTipo() == modelo.FIGURA_LINEA) {			
			draw.drawLine(figura.getPosicionX1(),figura.getPosicionY1(), figura.getAncho(), figura.getAlto());			
		}
		
		if (figura.getTipo() == modelo.FIGURA_RECTANGULO) {
			draw.draw(new Rectangle(figura.getPosicionX1(), figura.getPosicionY1(), figura.getAncho(), figura.getAlto()));
		}
		
		if(this.evento == "Limpiar") {
			draw.setPaint(Color.white);
			draw.fillRect(0, 0, this.getWidth(), this.getHeight());
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
	
	
	
	public ControladorDibujo getControl() {
		return controlEventosDibujo;
	}

	public Modelo getModelo() {
		return modelo;
	}
	
	
	public void limpiar() {
		this.evento = "Limpiar";
		repaint();
	}

	public void setFigura(Figura figura) {
		this.figura = figura;
		
	}


	
	
	
	
	

	
}
