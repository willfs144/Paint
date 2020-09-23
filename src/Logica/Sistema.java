package Logica;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Shape;
import java.util.ArrayList;

public class Sistema {	
	
	private Figura figura;
	private ArrayList<Figura> figuras;
	private ArrayList<Shape> shapes;
	private ArrayList<Figura> figurasRespaldo;
	private ArrayList<Shape> shapesRespaldo;
	

	
	public Sistema() {
		this.figura = new Figura();
		this.figuras = new ArrayList<Figura>();
		this.shapes = new ArrayList<Shape>();
		this.figurasRespaldo = new ArrayList<Figura>();
		this.shapesRespaldo = new ArrayList<Shape>();
		
	}


	public void crearFigura(int posicionX1, int posicionY1, String tipo) {
		this.figura = new Figura(posicionX1, posicionY1, tipo);
	}
	
	public void calcularLadosFiguraCuadratica() {		
		int x = Math.min(this.figura.getPosicionX1(),this.figura.getAncho());
		int y = Math.min(this.figura.getPosicionY1(), this.figura.getAlto());
		int width = Math.abs(this.figura.getPosicionX1() -this.figura.getAncho());
		int height = Math.abs(this.figura.getPosicionY1() -this.figura.getAlto());
		
		this.figura.setPosicionX1(x);
		this.figura.setPosicionY1(y);
		this.figura.setAncho(width);
		this.figura.setAlto(height);
	}


	public Figura getFigura() {
		return figura;
	}


	public void setFigura(Figura figura) {
		this.figura = figura;
	}


	public ArrayList<Figura> getFiguras() {
		return figuras;
	}


	public void setFiguras(ArrayList<Figura> figuras) {
		this.figuras = figuras;
	}


	public ArrayList<Shape> getShapes() {
		return shapes;
	}


	public void setShapes(ArrayList<Shape> shapes) {
		this.shapes = shapes;
	}


	public ArrayList<Figura> getFigurasRespaldo() {
		return figurasRespaldo;
	}


	public void setFigurasRespaldo(ArrayList<Figura> figurasRespaldo) {
		this.figurasRespaldo = figurasRespaldo;
	}


	public ArrayList<Shape> getShapesRespaldo() {
		return shapesRespaldo;
	}


	public void setShapesRespaldo(ArrayList<Shape> shapesRespaldo) {
		this.shapesRespaldo = shapesRespaldo;
	}		

	
	
	
	
	
	



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
