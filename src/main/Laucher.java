 package main;

import presentacion.Modelo;

public class Laucher {
	
	private Modelo miApp;

	public Laucher() {
		miApp = new Modelo();
		miApp.iniciar();
	}
	
	
	public static void main(String[] args) {
		new Laucher();
	}
	
	

}
