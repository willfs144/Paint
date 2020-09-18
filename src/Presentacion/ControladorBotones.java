package Presentacion;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JColorChooser;

public class ControladorBotones implements ActionListener{

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
		 else if (event.getSource() == vistaBotones.getBtnLapiz())
			 modelo.tipoFigura(modelo.FIGURA_LAPIZ);
		 else if (event.getSource() == vistaBotones.getBtnLinea())
			 modelo.tipoFigura(modelo.FIGURA_LINEA);
		 else if (event.getSource() == vistaBotones.getBtnRectangulo())
			 modelo.tipoFigura(modelo.FIGURA_RECTANGULO);
		 else if (event.getSource() == vistaBotones.getbtnRehacer()) //Falta implementacion
			modelo.rehacerFigura();
		 else if (event.getSource() == vistaBotones.getbtnDeshacer())  //Falta implementacion
			modelo.deshacerFigura();
		 else if (event.getSource() == vistaBotones.getbtnNegro()) 
			modelo.cambiarColor(modelo.COLOR_NEGRO);
		 else if (event.getSource() == vistaBotones.getBlueButton()) 
			modelo.cambiarColor(modelo.COLOR_AZUL);
		 else if (event.getSource() == vistaBotones.getGreenButton()) 
			modelo.cambiarColor(modelo.COLOR_VERDE);
		 else if (event.getSource() == vistaBotones.getRedButton()) 
			modelo.cambiarColor(modelo.COLOR_ROJO);
		 else if (event.getSource() == vistaBotones.getMagentaButton()) 
			modelo.cambiarColor(modelo.COLOR_MAGENTA);
		 else if (event.getSource() == vistaBotones.getGrayButton()) 
			modelo.cambiarColor(modelo.COLOR_GRIS);
		 else if (event.getSource() == vistaBotones.getOrangeButton())
			modelo.cambiarColor(modelo.COLOR_NARANJA);
		 else if (event.getSource() == vistaBotones.getYellowButton()) 
			modelo.cambiarColor(modelo.COLOR_AMARILLO);
		 else if (event.getSource() == vistaBotones.getPinkButton()) 
			modelo.cambiarColor(modelo.COLOR_ROSADO);
		 else if (event.getSource() == vistaBotones.getCyanButton()) 
			modelo.cambiarColor(modelo.COLOR_CIAN);
		 else if (event.getSource() == vistaBotones.getLightGrayButton()) 
			modelo.cambiarColor(modelo.COLOR_GRIS_CLARO);		 
		 		
	     /*else if (event.getSource() == colorPicker) {
			color = JColorChooser.showDialog(null, "Pick your color!",
					color);
			if (color == null)
				color = (Color.WHITE);
			modelo.picker(color);
		}*/
		
	}

}
