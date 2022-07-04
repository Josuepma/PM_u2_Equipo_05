package com.upv.pm_2022.iti_27856_u2_equipo_05;

/**
 *
 */
public abstract class Figura {

	/**
	 *
	 */
	protected int id;
	protected int x;
	protected int y;

	/**
	 *
	 * @return
	 */
	public int getX() {
		return x;
	}

	/**
	 *
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 *
	 * @return
	 */
	public int getY() {
		return y;
	}

	/**
	 *
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 *
	 * @return
	 */
	public int getId() {
		return id;
	}
}
