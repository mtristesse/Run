package tris.games.run;

import java.util.*;

import android.content.*;
import android.graphics.*;
import android.util.*;
import android.view.*;

public class MainThread extends Thread {

	public static final String TAG = "TAGRUN";
	
	private MainView view;
	
	public MainThread(MainView v) {
		super();
		view = v;
	}	
	
    @Override
    public void run() {
          while (true) {
                 Canvas c = null;
                 try {
                        c = view.getHolder().lockCanvas();
                        update();
                        synchronized (view.getHolder()) {
                               draw(c);	//not use SurfaceView.draw()
                        }
                 } finally {
                        if (c != null) {
                               view.getHolder().unlockCanvasAndPost(c);
                        }
                 }
          }
    }	
    
    private void draw(Canvas c)
    {
		if (c != null) {
			Paint paint = new Paint();
			paint.setColor(Color.BLACK);
			c.drawRect(new Rect(0, 0, view.screenWidth, view.screenHeight), paint);

            paint.setColor(Color.WHITE);
			String strInstruction = "MOTION SENSORS";
			paint.setTextSize(48);
			c.drawText(strInstruction, 100, 100, paint);
		}
    }
    
    private void update()
    {
    	//TODO
    }
    
	public boolean onTouchEvent(MotionEvent event)
	{
		Log.i(TAG, "MainThread onTouchEvent");
		int eventAction = event.getAction();
		int ex = (int)event.getX();
		int ey = (int) event.getY();
		
		switch (eventAction)
		{
		case MotionEvent.ACTION_UP:
			break;
		case MotionEvent.ACTION_DOWN:
			break;
		case MotionEvent.ACTION_MOVE:
			break;
		}
		return true;
	}

}
