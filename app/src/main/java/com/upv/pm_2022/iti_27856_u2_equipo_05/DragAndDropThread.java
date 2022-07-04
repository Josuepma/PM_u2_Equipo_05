package com.upv.pm_2022.iti_27856_u2_equipo_05;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

/**
 *
 */
public class DragAndDropThread extends Thread {

	/**
	 *
	 */
	private SurfaceHolder sh;
	private DragAndDropView view;
	private boolean run;

	/**
	 *
	 * @param sh
	 * @param view
	 */
	public DragAndDropThread(SurfaceHolder sh, DragAndDropView view) {
		this.sh = sh;
		this.view = view;
		run = false;
	}

	/**
	 *
	 * @param run
	 */
	public void setRunning(boolean run) {
		this.run = run;
	}

	/**
	 *
	 */
	@Override
	public void run() {
		Canvas canvas;
		while(run) {
			canvas = null;
			try {
				canvas = sh.lockCanvas(null);
				synchronized(sh) {
					view.onDraw(canvas);
				}
			} finally {
				if(canvas != null)
					sh.unlockCanvasAndPost(canvas);		// return to a stable state
			}
		}
	}
}
