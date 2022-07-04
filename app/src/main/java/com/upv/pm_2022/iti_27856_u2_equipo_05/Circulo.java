package com.upv.pm_2022.iti_27856_u2_equipo_05;

/**
 *
 */
public class Circulo extends Figura {

	/**
	 *
	 */
	private int radio;

	/**
	 *
	 * @param id
	 * @param x
	 * @param y
	 * @param radio
	 */
	public Circulo(int id, int x, int y, int radio) {
		this.id = id;
		this.x = x;
		this.y = y;
		this.radio = radio;
	}

	/**
	 *
	 * @return
	 */
	public int getRadio() {
		return radio;
	}
}
