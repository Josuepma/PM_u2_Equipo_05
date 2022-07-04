package com.upv.pm_2022.iti_27856_u2_equipo_05;

public class Rectangulo extends Figura {

	private int ancho;
	private int alto;
	
	public Rectangulo(int id, int x, int y, int ancho, int alto) {
		this.id = id;
		this.x = x;
		this.y = y;
		this.ancho = ancho;
		this.alto = alto;
	}

	public int getAncho() {
		return ancho;
	}

	public int getAlto() {
		return alto;
	}
}
