package presentacion;

import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Shape;
import java.awt.geom.Path2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import logica.Figura;

public class VistaDibujo extends Canvas{
	
	private Figura figura;
	private ArrayList<Figura> figuras;
	private ArrayList<Shape> shapes;
	private Path2D forma;
	private Graphics2D draw;
	private Image imagenPaint;
	
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
		
		g.drawImage(this.imagenPaint, 0 , 0, null);
		
		if (figura.getTipo().equals(Figura.LAPIZ)) {				
			draw.setStroke(new BasicStroke(figura.getGrosorBorde()));
			draw.setColor(figura.getColor());
			draw.draw(forma);					
		}		
		
		int index=0;
		for (Figura figura: figuras) {
			
			if (figura.getTipo().equals(Figura.LAPIZ)) {				
				draw.setStroke(new BasicStroke(figura.getGrosorBorde()));
				draw.setColor(figura.getColor());
				draw.draw(shapes.get(index));
				index++;
			}
			
			if (figura.getTipo().equals(Figura.LINEA)) {	
				draw.setStroke(new BasicStroke(figura.getGrosorBorde()));
				draw.setColor(figura.getColor());
				draw.drawLine(figura.getPosicionX1(),figura.getPosicionY1(),figura.getAncho(), figura.getAlto());				
			}
			
			if (figura.getTipo().equals(Figura.RECTANGULO)) {
				draw.setStroke(new BasicStroke(figura.getGrosorBorde()));
				draw.setColor(figura.getColor());
				if (figura.getContexto().equals(Figura.COLOR_PINTURA))
					draw.fillRect(figura.getPosicionX1(), figura.getPosicionY1(), 
							figura.getAncho(), figura.getAlto());
				else
					draw.drawRect(figura.getPosicionX1(), figura.getPosicionY1(), 
							figura.getAncho(), figura.getAlto());
			}
			if (figura.getTipo().equals(Figura.CIRCULO)) {
				draw.setStroke(new BasicStroke(figura.getGrosorBorde()));
				draw.setColor(figura.getColor());
				if (figura.getContexto().equals(Figura.COLOR_PINTURA))
					draw.fillOval(figura.getPosicionX1(), figura.getPosicionY1(), 
							figura.getAncho(), figura.getAlto());
				else
					draw.drawOval(figura.getPosicionX1(), figura.getPosicionY1(), 
							figura.getAncho(), figura.getAlto());				
			}
			if (figura.getTipo().equals(Figura.TEXTO)) {
				draw.setStroke(new BasicStroke(figura.getGrosorBorde()));
				draw.setColor(figura.getColor());
				draw.drawString(figura.getContexto(), figura.getPosicionX1(), figura.getPosicionY1());	
			}
		}
		
		if(this.evento == "Limpiar") {
			draw.setPaint(Color.white);
			draw.fillRect(0, 0, this.getWidth(), this.getHeight());
			this.forma = new Path2D.Float();
			this.evento = "";
			this.imagenPaint = null;
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
	
	public Image getImagenPaint() {			
		BufferedImage imagen = new BufferedImage(this.getWidth(),this.getHeight(),
				BufferedImage.TYPE_INT_RGB);		
		Graphics2D g2 = imagen.createGraphics(); 
		paint(g2);
		return imagen;
	}
	
	public void setImagenPaint(Image imagenPaint) {
		this.imagenPaint = imagenPaint;
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

	public void setFiguras(ArrayList<Figura> figuras) {
		this.figuras = figuras;		
	}
	

	
	
	
	


	
	
	
	
	

	
}
