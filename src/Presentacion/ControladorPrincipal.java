package Presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	}
	
	

}
