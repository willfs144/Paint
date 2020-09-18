package Presentacion;

import java.awt.Canvas;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.Console;

import javax.swing.JComponent;
import javax.swing.JPanel;


public class ControladorDibujo extends JPanel implements MouseListener, MouseMotionListener{
	
	private VistaDibujo vista;
	private Modelo modelo;
	
	
	public ControladorDibujo(VistaDibujo vistaDibujo) {
		this.vista = vistaDibujo;
		this.modelo = vista.getModelo();
	}

	@Override
	public void mouseDragged(MouseEvent e) {		
		modelo.dibujarFigura(e.getX(), e.getY());
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {		
	
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		modelo.crearFigura(e.getX(), e.getY());
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		
	}

	

	

}
