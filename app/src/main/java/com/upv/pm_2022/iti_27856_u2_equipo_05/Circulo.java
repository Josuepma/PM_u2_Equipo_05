package com.upv.pm_2022.iti_27856_u2_equipo_05;

import java.util.Random;

/**
 *
 */
public class Circulo extends Figura {

	/**
	 *
	 */
	private float radio;

	private int numero;

	/**
	 *
	 * @param id
	 * @param x
	 * @param y
	 * @param radio
	 */
	public Circulo(int id, int x, int y, float radio) {
		this.id = id;
		this.x = x;
		this.y = y;
		this.radio = radio;
		Random r = new Random();
		this.numero = r.nextInt(100);
	}

	public Circulo(int id, int x, int y, int radio) {
		this.id = id;
		this.x = x;
		this.y = y;
		this.radio = radio;
		Random r = new Random();
		this.numero = r.nextInt(100);
	}

	public Circulo(int id, int x, int y, float radio, int numero) {
		this.id = id;
		this.x = x;
		this.y = y;
		this.radio = radio;
		this.numero = numero;
	}

	public Circulo(int id, int x, int y, int radio, int numero) {
		this.id = id;
		this.x = x;
		this.y = y;
		this.radio = radio;
		this.numero = numero;
	}

	/**
	 *
	 * @return
	 */
	public float getRadio() {
		return radio;
	}

	public int getNumero(){
		return numero;
	}
}
