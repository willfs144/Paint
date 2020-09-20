package Presentacion;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;


public class VistaBotones extends JPanel{
	
	private static final byte DIMENBTNICONO = 30;
	private static final byte DIMENBTNCOLOR = 40;
	
	private JButton btnLimpiar, btnNegro, blueButton, greenButton, redButton,
	colorPicker, magentaButton, grayButton, orangeButton, yellowButton,
	pinkButton, cyanButton, lightGrayButton, btnDeshacer, btnRehacer, 
	btnLapiz,  btnLinea, btnOval,btnFuente, btnPicture, btnSinPicture, 
	btnRectangulo, btnBorrador;
	
	private Icon iconDeshacer = new ImageIcon(getClass().getResource("img/undo.png"));
	private Icon iconRehacer = new ImageIcon(getClass().getResource("img/redo.png"));
	private Icon iconlapiz = new ImageIcon(getClass().getResource("img/pencil.png"));
	private Icon iconRectangulo = new ImageIcon(getClass().getResource("img/rect.png"));
	private Icon iconLinea = new ImageIcon(getClass().getResource("img/line.png"));
	private Icon iconOvalo = new ImageIcon(getClass().getResource("img/oval.png"));
	private Icon iconFuente = new ImageIcon(getClass().getResource("img/fuente.png"));
	private Icon iconPicture = new ImageIcon(getClass().getResource("img/pintura.png"));
	private Icon iconSinPicture = new ImageIcon(getClass().getResource("img/sin-spray.png"));
		
	private JSlider jSliGrosor;
	private JLabel  jLabGrosor;
	private Color color;
	
	private Modelo modelo;
	private ControladorBotones controlEventosBotones;
	
	public VistaBotones(Modelo modelo) {
		this.modelo = modelo;
		this.controlEventosBotones = new ControladorBotones(this);		
	
		this.setBorder(BorderFactory.createTitledBorder("Control Paint"));
		
		btnLapiz = new JButton(iconlapiz);
		btnLapiz.setPreferredSize(new Dimension(DIMENBTNICONO, DIMENBTNICONO));
		this.add(btnLapiz);
		btnLapiz.addActionListener(controlEventosBotones);
		
		btnLinea = new JButton(iconLinea);
		btnLinea.setPreferredSize(new Dimension(DIMENBTNICONO, DIMENBTNICONO));
		this.add(btnLinea);
		btnLinea.addActionListener(controlEventosBotones);
		
		btnRectangulo = new JButton(iconRectangulo);
		btnRectangulo.setPreferredSize(new Dimension(DIMENBTNICONO, DIMENBTNICONO));
		this.add(btnRectangulo);
		btnRectangulo.addActionListener(controlEventosBotones);		
		
		btnOval = new JButton(iconOvalo);
		btnOval.setPreferredSize(new Dimension(DIMENBTNICONO, DIMENBTNICONO));
		this.add(btnOval);
		btnOval.addActionListener(controlEventosBotones);		
		
		btnFuente = new JButton(iconFuente);
		btnFuente.setPreferredSize(new Dimension(DIMENBTNICONO, DIMENBTNICONO));
		this.add(btnFuente);
		btnFuente.addActionListener(controlEventosBotones);
		
		btnPicture = new JButton(iconPicture);
		btnPicture.setPreferredSize(new Dimension(DIMENBTNICONO, DIMENBTNICONO));
		this.add(btnPicture);
		btnPicture.addActionListener(controlEventosBotones);
		
		btnSinPicture = new JButton(iconSinPicture);
		btnSinPicture.setPreferredSize(new Dimension(DIMENBTNICONO, DIMENBTNICONO));
		this.add(btnSinPicture);
		btnSinPicture.setVisible(false);
		btnSinPicture.addActionListener(controlEventosBotones);
		
		btnNegro = new JButton();
		btnNegro.setName("Negro");
		btnNegro.setBackground(Color.BLACK);
		btnNegro.setPreferredSize(new Dimension(DIMENBTNCOLOR, DIMENBTNCOLOR));
		this.add(btnNegro);
		btnNegro.addActionListener(controlEventosBotones);
		
		blueButton = new JButton();
		blueButton.setBackground(Color.BLUE);
		blueButton.setPreferredSize(new Dimension(DIMENBTNCOLOR, DIMENBTNCOLOR));
		this.add(blueButton);
		blueButton.addActionListener(controlEventosBotones);
		
		greenButton = new JButton();
		greenButton.setBackground(Color.GREEN);
		greenButton.setPreferredSize(new Dimension(DIMENBTNCOLOR, DIMENBTNCOLOR));
		this.add(greenButton);
		greenButton.addActionListener(controlEventosBotones);
		
		redButton = new JButton();
		redButton.setBackground(Color.RED);
		redButton.setPreferredSize(new Dimension(DIMENBTNCOLOR, DIMENBTNCOLOR));
		this.add(redButton);
		redButton.addActionListener(controlEventosBotones);
		
		magentaButton = new JButton();
		magentaButton.setBackground(Color.MAGENTA);
		magentaButton.setPreferredSize(new Dimension(DIMENBTNCOLOR, DIMENBTNCOLOR));
		this.add(magentaButton);
		magentaButton.addActionListener(controlEventosBotones);
		
		grayButton = new JButton();
		grayButton.setBackground(Color.GRAY);
		grayButton.setPreferredSize(new Dimension(DIMENBTNCOLOR, DIMENBTNCOLOR));
		this.add(grayButton);
		grayButton.addActionListener(controlEventosBotones);
		
		orangeButton = new JButton();
		orangeButton.setBackground(Color.ORANGE);
		orangeButton.setPreferredSize(new Dimension(DIMENBTNCOLOR, DIMENBTNCOLOR));
		this.add(orangeButton);
		orangeButton.addActionListener(controlEventosBotones);
		
		yellowButton = new JButton();
		yellowButton.setBackground(Color.YELLOW);
		yellowButton.setPreferredSize(new Dimension(DIMENBTNCOLOR, DIMENBTNCOLOR));
		this.add(yellowButton);
		yellowButton.addActionListener(controlEventosBotones);
		
		pinkButton = new JButton();
		pinkButton.setBackground(Color.PINK);
		pinkButton.setPreferredSize(new Dimension(DIMENBTNCOLOR, DIMENBTNCOLOR));
		this.add(pinkButton);
		pinkButton.addActionListener(controlEventosBotones);
		
		cyanButton = new JButton();
		cyanButton.setBackground(Color.CYAN);
		cyanButton.setPreferredSize(new Dimension(DIMENBTNCOLOR, DIMENBTNCOLOR));
		this.add(cyanButton);
		cyanButton.addActionListener(controlEventosBotones);
		
		lightGrayButton = new JButton();
		lightGrayButton.setBackground(Color.LIGHT_GRAY);
		lightGrayButton.setPreferredSize(new Dimension(DIMENBTNCOLOR, DIMENBTNCOLOR));
		this.add(lightGrayButton);
		lightGrayButton.addActionListener(controlEventosBotones);
		
		colorPicker = new JButton("Color Picker");
		this.add(colorPicker);
		colorPicker.addActionListener(controlEventosBotones);
		
		btnLimpiar = new JButton("Clear");
		this.add(btnLimpiar);
		btnLimpiar.addActionListener(controlEventosBotones);
		
		btnDeshacer = new JButton(iconDeshacer);
		btnDeshacer.setPreferredSize(new Dimension(DIMENBTNICONO, DIMENBTNICONO));
		this.add(btnDeshacer);
		btnDeshacer.addActionListener(controlEventosBotones);
		
		btnRehacer = new JButton(iconRehacer);
		btnRehacer.setPreferredSize(new Dimension(DIMENBTNICONO, DIMENBTNICONO));
		this.add(btnRehacer);
		btnRehacer.addActionListener(controlEventosBotones);
		
		jSliGrosor = new JSlider(JSlider.HORIZONTAL, 0, 50, 1);
		jSliGrosor.setMajorTickSpacing(25);
		jSliGrosor.setPaintTicks(true);
		jSliGrosor.setPreferredSize(new Dimension(DIMENBTNCOLOR, DIMENBTNCOLOR));
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

	public JButton getBtnOval() {
		return btnOval;
	}

	public JSlider getjSliGrosor() {
		return jSliGrosor;
	}

	
	public JLabel getjLabGrosor() {
		return jLabGrosor;
	}

	public void getPaletaColores() {
		color = JColorChooser.showDialog(null, "Pick your color!",
				color);
		if (color == null)
			color = (Color.WHITE);	
		System.out.println("Paleta");
	}

	public Color getColor() {
		return color;
	}

	public JButton getBtnFuente() {
		return btnFuente;
	}

	public JButton getBtnPicture() {
		return btnPicture;
	}

	public JButton getBtnSinPicture() {
		return btnSinPicture;
	}

	public String capturarTextoDialog() {		
		return JOptionPane.showInputDialog(this, "Escribe texto");
	}
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	


}
