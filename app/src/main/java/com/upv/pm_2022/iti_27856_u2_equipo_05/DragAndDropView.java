package com.upv.pm_2022.iti_27856_u2_equipo_05;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Class DragAndDropView
 * extends SurfaceView implements SurfaceHolder.Callback
 * Clase utilizada para el "tablero principal" donde se agregan los nodos de la lista doblemente
 * enlazada.
 */
public class DragAndDropView extends SurfaceView implements SurfaceHolder.Callback {

	/**
	 *
	 */
	private DragAndDropThread thread;
	public ArrayList<Figura> figuras;
	private int figuraActiva;

	/**
	 *
	 * @param context
	 */
	public DragAndDropView(Context context) {
		super(context);
		getHolder().addCallback(this);
	}

	/**
	 *
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 * @param arg3
	 */
	@Override
	public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {
		// nothing here
	}

	/**
	 *
	 * @param arg0
	 */
	@Override
	public void surfaceCreated(SurfaceHolder arg0) {
		int id = 0;

		figuras = new ArrayList<Figura>();
		figuras.add(new Circulo(id++,100,100,(getWidth()) / 12));
		//figuras.add(new Rectangulo(id++,200,500,200,200));
		figuraActiva = -1;
		
		thread = new DragAndDropThread(getHolder(), this);
		thread.setRunning(true);
		thread.start();
	}

	/**
	 *
	 * @param arg0
	 */
	@Override
	public void surfaceDestroyed(SurfaceHolder arg0) {
		boolean retry = true;
		thread.setRunning(false);
		while (retry) {
			try {
				thread.join();
				retry = false;
			} catch (InterruptedException e) {
				
			}
		}
	}

	/**
	 *
	 * @param canvas
	 */
	@Override
	public void onDraw(Canvas canvas) {
		Paint p = new Paint();
		p.setAntiAlias(true);

		canvas.drawColor(Color.WHITE);
		float lastX=-1, lastY=-1;

		for(Figura f : figuras) {
			if (f instanceof Circulo){
				Circulo c = (Circulo) f;
				p.setColor(Color.BLACK);
				canvas.drawCircle(c.getX(), c.getY(), c.getRadio(), p);
				p.setColor(Color.WHITE);
				p.setTextSize(50);
				canvas.drawText(""+c.getNumero(),c.getX(),c.getY(),p);

				if (lastX!=-1){//fix flechas
					p.setColor(Color.BLACK);
					canvas.drawLine(c.getX(),c.getY()-10,lastX + c.getRadio(),lastY-10,p);
					canvas.drawLine(lastX + c.getRadio(),lastY,lastX+40 + c.getRadio(),lastY-10,p);
					canvas.drawLine(lastX + c.getRadio(),lastY,lastX+40 + c.getRadio(),lastY+10,p);

					//canvas.drawLine(c.getX(),c.getY()+10,lastX - c.getRadio(),lastY+10,p);
					//canvas.drawLine(c.getX(),c.getY()+10,c.getX()+10 + c.getRadio(),c.getY()+20,p);
					//canvas.drawLine(c.getX(),c.getY()+10,c.getX()+10 + c.getRadio(),c.getY()-20,p);
				}
				lastX = c.getX();lastY = c.getY();
			} else {
				Rectangulo r = (Rectangulo) f;
				p.setColor(Color.RED);
				canvas.drawRect(r.getX(), r.getY(), r.getX()+r.getAncho(), r.getY()+r.getAlto(), p);
			}
		}
	}

	/**
	 *
	 * @param event
	 * @return
	 */
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		int x = (int) event.getX();
		int y = (int) event.getY();
		
		switch(event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			for(Figura f : figuras) {
				if(f instanceof Circulo) {
					Circulo c = (Circulo) f;
					int distanciaX = x - c.getX();
					int distanciaY = y - c.getY();
					if(Math.pow(c.getRadio(), 2) > (Math.pow(distanciaX, 2) + Math.pow(distanciaY, 2))) {
						figuraActiva = c.getId();
						//break; check blog entry for explanation on why this is commented
					}
				} else {	// in this context, only instanceof Rectangulo
					Rectangulo r = (Rectangulo) f;
					if(x > r.getX() && x < r.getX()+r.getAncho() && y > r.getY() && y < r.getY()+r.getAlto()) {
						figuraActiva = r.getId();
						//break; check blog entry for explanation on why this is commented
					}
				}
			}
			break;
		}
		
		return true;
	}

}