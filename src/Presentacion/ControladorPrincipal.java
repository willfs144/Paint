package Presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileFilter;

public class ControladorPrincipal  implements ActionListener{
	
	private VistaPrincipal vistaPrincipal;
	private Modelo modelo;

	public ControladorPrincipal(VistaPrincipal vistaPrincipal) {
		this.vistaPrincipal = vistaPrincipal;
		this.modelo = vistaPrincipal.getModelo();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		
		if (event.getSource() == vistaPrincipal.getMenuItemNuevo()) 
			this.modelo.iniciar();
		
		else if (event.getSource() == vistaPrincipal.getMenuItemAbrir()) 
			this.modelo.abrir();
		
		else if (event.getSource() == vistaPrincipal.getMenuItemGuardar()) 
			this.modelo.guardar();
		
	}
	
	

}
