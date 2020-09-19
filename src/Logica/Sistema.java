package Logica;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Sistema {	

	
	
	private Figura figura;	
	
	public Sistema(String tipoFigura) {
		crearFigura(0, 0, tipoFigura);
	}


	public void crearFigura(int posicionX1, int posicionY1, String tipo) {
		this.figura = new Figura(posicionX1, posicionY1, tipo);
	}
	
	public void calcularLadosFiguraCuadratica() {		
		int x = Math.min(this.figura.getPosicionX1(),this.figura.getAncho());
		int y = Math.min(this.figura.getPosicionY1(), this.figura.getAncho());
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



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
