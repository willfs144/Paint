package Presentacion;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ComponentListener;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.AncestorListener;

public class VistaBotones extends JPanel{
	
	private JButton btnLimpiar, btnNegro, blueButton, greenButton, redButton,
	colorPicker, magentaButton, grayButton, orangeButton, yellowButton,
	pinkButton, cyanButton, lightGrayButton, btnDeshacer, btnRehacer;
	
	private Icon iconDeshacer = new ImageIcon(getClass().getResource("img/undo.png"));
	private Icon iconRehacer = new ImageIcon(getClass().getResource("img/redo.png"));
	private Icon iconlapiz = new ImageIcon(getClass().getResource("img/pencil.png"));
	private Icon iconRectangulo = new ImageIcon(getClass().getResource("img/rect.png"));
	private Icon iconLinea = new ImageIcon(getClass().getResource("img/line.png"));
	
	private JButton btnLinea;
	private JButton btnLapiz;
	private JButton btnBorrador;
	private JButton btnRectangulo;
	
	private JSlider jSliGrosor;
	private JLabel  jLabGrosor;
	
	private Modelo modelo;
	private ControladorBotones controlEventosBotones;
	
	public VistaBotones(Modelo modelo) {
		this.modelo = modelo;
		this.controlEventosBotones = new ControladorBotones(this);		
	
		this.setBorder(BorderFactory.createTitledBorder("Control Paint"));
		
		btnLapiz = new JButton(iconlapiz);
		btnLapiz.setPreferredSize(new Dimension(30, 30));
		this.add(btnLapiz);
		btnLapiz.addActionListener(controlEventosBotones);
		
		btnLinea = new JButton(iconLinea);
		btnLinea.setPreferredSize(new Dimension(30, 30));
		this.add(btnLinea);
		btnLinea.addActionListener(controlEventosBotones);
		
		btnRectangulo = new JButton(iconRectangulo);
		btnRectangulo.setPreferredSize(new Dimension(30, 30));
		this.add(btnRectangulo);
		btnRectangulo.addActionListener(controlEventosBotones);		
		
		btnDeshacer = new JButton(iconDeshacer);
		btnDeshacer.setPreferredSize(new Dimension(30, 30));
		this.add(btnDeshacer);
		btnDeshacer.addActionListener(controlEventosBotones);
		
		btnRehacer = new JButton(iconRehacer);
		btnRehacer.setPreferredSize(new Dimension(30, 30));
		this.add(btnRehacer);
		btnRehacer.addActionListener(controlEventosBotones);
		
		btnNegro = new JButton();
		btnNegro.setName("Negro");
		btnNegro.setBackground(Color.BLACK);
		btnNegro.setPreferredSize(new Dimension(40, 40));
		this.add(btnNegro);
		btnNegro.addActionListener(controlEventosBotones);
		
		blueButton = new JButton();
		blueButton.setBackground(Color.BLUE);
		blueButton.setPreferredSize(new Dimension(40, 40));
		this.add(blueButton);
		blueButton.addActionListener(controlEventosBotones);
		
		greenButton = new JButton();
		greenButton.setBackground(Color.GREEN);
		greenButton.setPreferredSize(new Dimension(40, 40));
		this.add(greenButton);
		greenButton.addActionListener(controlEventosBotones);
		
		redButton = new JButton();
		redButton.setBackground(Color.RED);
		redButton.setPreferredSize(new Dimension(40, 40));
		this.add(redButton);
		redButton.addActionListener(controlEventosBotones);
		
		magentaButton = new JButton();
		magentaButton.setBackground(Color.MAGENTA);
		magentaButton.setPreferredSize(new Dimension(40, 40));
		this.add(magentaButton);
		
		grayButton = new JButton();
		grayButton.setBackground(Color.GRAY);
		grayButton.setPreferredSize(new Dimension(40, 40));
		this.add(grayButton);
		grayButton.addActionListener(controlEventosBotones);
		
		orangeButton = new JButton();
		orangeButton.setBackground(Color.ORANGE);
		orangeButton.setPreferredSize(new Dimension(40, 40));
		this.add(orangeButton);
		orangeButton.addActionListener(controlEventosBotones);
		
		yellowButton = new JButton();
		yellowButton.setBackground(Color.YELLOW);
		yellowButton.setPreferredSize(new Dimension(40, 40));
		this.add(yellowButton);
		yellowButton.addActionListener(controlEventosBotones);
		
		pinkButton = new JButton();
		pinkButton.setBackground(Color.PINK);
		pinkButton.setPreferredSize(new Dimension(40, 40));
		this.add(pinkButton);
		pinkButton.addActionListener(controlEventosBotones);
		
		cyanButton = new JButton();
		cyanButton.setBackground(Color.CYAN);
		cyanButton.setPreferredSize(new Dimension(40, 40));
		this.add(cyanButton);
		cyanButton.addActionListener(controlEventosBotones);
		
		lightGrayButton = new JButton();
		lightGrayButton.setBackground(Color.LIGHT_GRAY);
		lightGrayButton.setPreferredSize(new Dimension(40, 40));
		this.add(lightGrayButton);
		lightGrayButton.addActionListener(controlEventosBotones);
		
		colorPicker = new JButton("Color Picker");
		this.add(colorPicker);
		colorPicker.addActionListener(controlEventosBotones);
		
		btnLimpiar = new JButton("Clear");
		this.add(btnLimpiar);
		btnLimpiar.addActionListener(controlEventosBotones);
		
		jSliGrosor = new JSlider(JSlider.HORIZONTAL, 0, 50, 1);
		jSliGrosor.setMajorTickSpacing(25);
		jSliGrosor.setPaintTicks(true);
		jSliGrosor.setPreferredSize(new Dimension(40, 40));
		this.add(jSliGrosor);
		jSliGrosor.addChangeListener(controlEventosBotones);
		
		jLabGrosor = new JLabel("1");
		this.add(jLabGrosor);

	}	

	public Modelo getModelo() {
		return modelo;
	}

	public ControladorBotones getControlEventosBotones() {
		if (controlEventosBotones == null) {
			this.controlEventosBotones = new ControladorBotones(this);
		}
		return controlEventosBotones;
	}

	public JButton getbtnLimpiar() {
		return btnLimpiar;
	}

	public JButton getbtnNegro() {
		return btnNegro;
	}

	public JButton getBlueButton() {
		return blueButton;
	}

	public JButton getGreenButton() {
		return greenButton;
	}

	public JButton getRedButton() {
		return redButton;
	}

	public JButton getColorPicker() {
		return colorPicker;
	}

	public JButton getMagentaButton() {
		return magentaButton;
	}

	public JButton getGrayButton() {
		return grayButton;
	}

	public JButton getOrangeButton() {
		return orangeButton;
	}

	public JButton getYellowButton() {
		return yellowButton;
	}

	public JButton getPinkButton() {
		return pinkButton;
	}

	public JButton getCyanButton() {
		return cyanButton;
	}

	public JButton getLightGrayButton() {
		return lightGrayButton;
	}

	public JButton getbtnDeshacer() {
		return btnDeshacer;
	}

	public JButton getbtnRehacer() {
		return btnRehacer;
	}

	public JButton getbBorrador() {
		return btnBorrador;
	}

	public JButton getBtnLimpiar() {
		return btnLimpiar;
	}

	public JButton getBtnDeshacer() {
		return btnDeshacer;
	}

	public JButton getBtnLinea() {
		return btnLinea;
	}

	public JButton getBtnLapiz() {
		return btnLapiz;
	}

	public JButton getBtnRectangulo() {
		return btnRectangulo;
	}

	public JSlider getjSliGrosor() {
		return jSliGrosor;
	}

	
	public JLabel getjLabGrosor() {
		return jLabGrosor;
	}

	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	


}
