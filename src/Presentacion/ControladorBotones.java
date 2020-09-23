package Presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Logica.Figura;

public class ControladorBotones implements ActionListener,ChangeListener{

	private VistaBotones vistaBotones;
	private Modelo modelo;
	
	public ControladorBotones(VistaBotones vistaBotones) {
		this.vistaBotones = vistaBotones;
		this.modelo= vistaBotones.getModelo();
	}


	@Override
	public void actionPerformed(ActionEvent event) {
		
		 if (event.getSource() == vistaBotones.getbtnLimpiar()) 
			modelo.limpiarDibujo();
		 else if (event.getSource() == vistaBotones.getColorPicker())
			modelo.capturarPaletaColor();		
		 else if (event.getSource() == vistaBotones.getbtnRehacer()) 
			modelo.rehacerFigura();
		 else if (event.getSource() == vistaBotones.getbtnDeshacer())
			modelo.deshacerFigura();
		 else if (event.getSource() == vistaBotones.getBtnLapiz())
			modelo.tipoFigura(Figura.LAPIZ);
		 else if (event.getSource() == vistaBotones.getBtnLinea())			
			modelo.tipoFigura(Figura.LINEA);
		 else if (event.getSource() == vistaBotones.getBtnRectangulo())
			modelo.tipoFigura(Figura.RECTANGULO);
		 else if (event.getSource() == vistaBotones.getBtnOval())
			modelo.tipoFigura(Figura.CIRCULO);
		 else if (event.getSource() == vistaBotones.getBtnPicture())
			modelo.agregarCualidadFigura(Figura.COLOR_PINTURA);
		 else if (event.getSource() == vistaBotones.getBtnSinPicture())
				modelo.agregarCualidadFigura(Figura.COLOR_SIN_PINTURA);
		 else if (event.getSource() == vistaBotones.getBtnFuente())
				modelo.agregarTextoFigura(Figura.TEXTO);
		 else if (event.getSource() == vistaBotones.getbtnNegro()) 
			modelo.cambiarColor(Figura.COLOR_NEGRO);
		 else if (event.getSource() == vistaBotones.getBlueButton()) 
			modelo.cambiarColor(Figura.COLOR_AZUL);
		 else if (event.getSource() == vistaBotones.getGreenButton()) 
			modelo.cambiarColor(Figura.COLOR_VERDE);
		 else if (event.getSource() == vistaBotones.getRedButton()) 
			modelo.cambiarColor(Figura.COLOR_ROJO);
		 else if (event.getSource() == vistaBotones.getMagentaButton()) 
			modelo.cambiarColor(Figura.COLOR_MAGENTA);
		 else if (event.getSource() == vistaBotones.getGrayButton()) 
			modelo.cambiarColor(Figura.COLOR_GRIS);
		 else if (event.getSource() == vistaBotones.getOrangeButton())
			modelo.cambiarColor(Figura.COLOR_NARANJA);
		 else if (event.getSource() == vistaBotones.getYellowButton()) 
			modelo.cambiarColor(Figura.COLOR_AMARILLO);
		 else if (event.getSource() == vistaBotones.getPinkButton()) 
			modelo.cambiarColor(Figura.COLOR_ROSADO);
		 else if (event.getSource() == vistaBotones.getCyanButton()) 
			modelo.cambiarColor(Figura.COLOR_CIAN);
		 else if (event.getSource() == vistaBotones.getLightGrayButton()) 
			modelo.cambiarColor(Figura.COLOR_GRIS_CLARO);
		
	}


	@Override
	public void stateChanged(ChangeEvent evento) {		
		this.vistaBotones.getjLabGrosor().setText(String.format("%s",
				this.vistaBotones.getjSliGrosor().getValue()));
		this.modelo.grosorBordeFigura(this.vistaBotones.getjSliGrosor().getValue());
		
	}

}
