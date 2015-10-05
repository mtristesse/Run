package tris.games.run;

import java.util.*;

import android.content.*;
import android.graphics.*;
import android.graphics.drawable.Drawable;
import android.util.*;
import android.view.*;

public class MainThread extends Thread {

	public static final String TAG = Config.TAG;


	private MainView view;
    private RunActivity context;
	
	public MainThread(MainView v) {
		super();
		view = v;
        context = view.context;
	}

    Drawable d;
    Bitmap bitmap;
    @Override
    public void run() {
        d = context.getResources().getDrawable(R.drawable.compass);

        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.compass_needle);

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
			paint.setColor(Color.WHITE);
			c.drawRect(new Rect(0, 0, view.screenWidth, view.screenHeight), paint);

            d.setBounds(50, 50, 600, 600);
            d.draw(c);

            paint.setColor(Color.BLUE);
//            c.drawRect();

            Rect src = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
            c.drawBitmap(bitmap, src, src, null);

            paint.setColor(Color.RED);
			String strInstruction = "MOTION SENSORS";
			paint.setTextSize(48);
			c.drawText(strInstruction, 100, 500, paint);
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
