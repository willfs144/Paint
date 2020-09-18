package Presentacion;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.WindowConstants;


public class VistaPrincipal extends JFrame {
	
	
	private VistaDibujo vistaDibujo;
	private VistaBotones vistaBotones;
	
	private Modelo modelo;
	
	
	
	public VistaPrincipal(Modelo modelo) {
		this.modelo = modelo;
		iniciarInterfaz();		
	}


	private void iniciarInterfaz() {
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setTitle("Paint");
		this.setLayout(new BorderLayout());
		this.vistaDibujo = new VistaDibujo(this.modelo);
		this.getContentPane().add(vistaDibujo, BorderLayout.CENTER);
		this.vistaBotones = new VistaBotones(modelo);
		this.getContentPane().add(vistaBotones, BorderLayout.NORTH);		
	}


		
	

	public VistaDibujo getVistaDibujo() {
		return vistaDibujo;
	}

	public VistaBotones getVistaBotones() {
		if (vistaBotones == null) {
			
		}
		return vistaBotones;
	}


	public Modelo getModelo() {
		if (this.modelo == null) {
			modelo = new Modelo();
		}
		return modelo;
	}
	
	
	

}
