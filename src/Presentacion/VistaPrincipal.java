package Presentacion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.WindowConstants;
import javax.swing.filechooser.FileNameExtensionFilter;


public class VistaPrincipal extends JFrame {
	
	public static final String FORMATO_IMAGEN = "png";
	
	private JMenuBar menuBar;
	private JMenuItem menuItemNuevo;
	private JMenuItem menuItemAbrir;
	private JMenuItem menuItemGuardar;
	private JMenu menuArchivo;
	
	private Image imagen;
	   		
	private VistaDibujo vistaDibujo;
	private VistaBotones vistaBotones;
	
	private Modelo modelo;
	private ControladorPrincipal controladorPrincipal;	
	
	
	public VistaPrincipal(Modelo modelo) {
		this.modelo = modelo;
		this.controladorPrincipal = new ControladorPrincipal(this);
		
		this.setLayout(new BorderLayout());
		this.vistaDibujo = new VistaDibujo(modelo);
		this.getContentPane().add(vistaDibujo, BorderLayout.CENTER);
		this.vistaBotones = new VistaBotones(modelo);
		this.getContentPane().add(vistaBotones, BorderLayout.NORTH);
		this.vistaBotones.setLayout(new FlowLayout());	

		agregarArchivoMenuInterfaz();		
	}


	private void agregarArchivoMenuInterfaz() {
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
				{
					this.menuItemAbrir = new JMenuItem();
					this.menuArchivo.add(menuItemAbrir);
					this.menuItemAbrir.setText("Abrir");
					this.menuItemAbrir.addActionListener(controladorPrincipal);
				}
				{
					this.menuItemGuardar = new JMenuItem();
					this.menuArchivo.add(menuItemGuardar);
					this.menuItemGuardar.setText("Guardar");
					this.menuItemGuardar.addActionListener(controladorPrincipal);
				}
			}
		}
		
			
	}
	
	public void showDialogAbrir() {
		FileNameExtensionFilter extJpg = new FileNameExtensionFilter(".jpg","JPG");				
		FileNameExtensionFilter extPng = new FileNameExtensionFilter(".png","PNG");		
		JFileChooser ventana = new JFileChooser();
		ventana.setFileFilter(extJpg);
		ventana.setFileFilter(extPng);
		int seleccion = ventana.showOpenDialog(null);
		if (seleccion == JFileChooser.APPROVE_OPTION) {
			try {
				File file = ventana.getSelectedFile();
				BufferedImage foto = ImageIO.read(file);
				this.imagen = foto;
			} catch (IOException e) {
				System.out.println(e.toString());
				e.printStackTrace();
			}			
		}
	}
	
	public void showDialogGuardar() {
		FileNameExtensionFilter extPng = new FileNameExtensionFilter(FORMATO_IMAGEN,"Archivo imagen");		
		JFileChooser ventana = new JFileChooser();
		ventana.setFileFilter(extPng);
		int seleccion = ventana.showSaveDialog(this);
		if (seleccion == JFileChooser.APPROVE_OPTION) {
			File file = ventana.getSelectedFile();
			BufferedImage image =(BufferedImage) this.imagen;
			try {
				if (file.getAbsolutePath().endsWith(".png"))								
					ImageIO.write(image, FORMATO_IMAGEN, new File(file.getAbsolutePath()));
				else
					ImageIO.write(image, FORMATO_IMAGEN, new File(file.getAbsolutePath()+".png"));				
			} catch (IOException e) {
				System.out.println(e.toString());
				e.printStackTrace();
			};
		}
	}		

	public Image getImagen() {
		return imagen;
	}


	public void setImagen(Image imagen) {
		this.imagen = imagen;
	}


	public JMenuItem getMenuItemAbrir() {
		return menuItemAbrir;
	}


	public JMenuItem getMenuItemGuardar() {
		return menuItemGuardar;
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
