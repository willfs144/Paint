package Presentacion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.MenuBar;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.WindowConstants;


public class VistaPrincipal extends JFrame {
	
	private JMenuBar menuBar;
	private JMenu menuAyuda;
	private JMenuItem menuItemNuevo;
	private JMenuItem menuItemCerrar;
	private JSeparator separador;
	private JMenu menuArchivo;
		
	private VistaDibujo vistaDibujo;
	private VistaBotones vistaBotones;
	
	private Modelo modelo;
	private ControladorPrincipal controladorPrincipal;
	
	
	
	public VistaPrincipal(Modelo modelo) {
		this.modelo = modelo;
		this.controladorPrincipal = new ControladorPrincipal(this);
		iniciarInterfaz();		
	}


	private void iniciarInterfaz() {
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setTitle("Paint");
		{
			this.menuBar= new JMenuBar();
			this.setJMenuBar(menuBar);
			{
				this.menuArchivo = new JMenu();
				this.menuBar.add(menuArchivo);
				this.menuArchivo.setText("Archivo");
				{
					this.menuItemNuevo = new JMenuItem();
					this.menuArchivo.add(menuItemNuevo);
					this.menuItemNuevo.setText("Nuevo");
					this.menuItemNuevo.addActionListener(controladorPrincipal);
				}
			}
		}
		
		this.setLayout(new BorderLayout(5,5));
		this.vistaDibujo = new VistaDibujo(this.modelo);
		this.getContentPane().add(vistaDibujo, BorderLayout.CENTER);
		this.vistaBotones = new VistaBotones(modelo);
		this.getContentPane().add(vistaBotones, BorderLayout.NORTH);
		this.vistaBotones.setLayout(new FlowLayout());
		
	}
	
	
	

	public JMenuItem getMenuItemNuevo() {
		return menuItemNuevo;
	}

	public VistaDibujo getVistaDibujo() {
		return vistaDibujo;
	}

	public VistaBotones getVistaBotones() {
		return vistaBotones;
	}


	public Modelo getModelo() {		
		return modelo;
	}
	
	
	
	
	
	
	

}
