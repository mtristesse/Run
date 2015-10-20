package tris.games.run;

import java.text.DecimalFormat;
import java.util.*;

import android.content.*;
import android.graphics.*;
import android.graphics.drawable.Drawable;
import android.hardware.SensorManager;
import android.util.*;
import android.view.*;

public class MainThread extends Thread implements Defines {

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

//            d.setBounds(50, 50, 600, 600);
//            d.draw(c);

            paint.setColor(Color.BLUE);
//            c.drawRect();

            float rotationMatrix[] = new float[9];
            boolean success = SensorManager.getRotationMatrix(rotationMatrix,
                    null, context.listener.fGravity, context.listener.fMagneticField);
            float mRotationInDegrees = 0;
            if (success) {
                float orientationMatrix[] = new float[3];
                SensorManager.getOrientation(rotationMatrix, orientationMatrix);
                float rotationInRadians = orientationMatrix[0];
                mRotationInDegrees = (float) Math.toDegrees(rotationInRadians);
                App.log("mRotationInDegrees = " + mRotationInDegrees);
            }

            c.save();
            //c.rotate(45);
//            c.rotate(-mRotationInDegrees, App.screenWidth / 2, App.screenHeight / 2);
            c.rotate(-mRotationInDegrees, bitmap.getWidth() / 2, bitmap.getHeight() / 2);

            Rect src = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());

            Rect dest = new Rect(App.screenWidth / 1 - bitmap.getWidth() / 10,
                    App.screenHeight /2 - bitmap.getHeight() / 10,
                    App.screenWidth / 2 + bitmap.getWidth() / 10,
                    App.screenHeight /2 + bitmap.getHeight() / 10);
//            c.drawRect(src, paint);
            c.drawBitmap(bitmap, src, src, null);
//            c.drawBitmap(bitmap, src, src, null);
            c.restore();

            paint.setColor(Color.RED);
            paint.setTextSize(24);

            String str = "MOTION SENSORS";
            c.drawText(str, 20, 500, paint);

            str = "Accelerate = [" +
                    format.format(context.listener.fAccelerometer[0]) + ", " +
                            format.format(context.listener.fAccelerometer[1]) + ", " +
                                    format.format(context.listener.fAccelerometer[2]) + "]";
            c.drawText(str, 20, 600, paint);

            str = "Gravity = [" +
                    format.format(context.listener.fGravity[0]) + ", " +
                            format.format(context.listener.fGravity[1]) + ", " +
                                    format.format(context.listener.fGravity[2]) + "]";
            c.drawText(str, 20, 700, paint);

            str = "Magnetic = [" +
                    format.format(context.listener.fMagneticField[0]) + ", " +
                            format.format(context.listener.fMagneticField[1]) + ", " +
                                    format.format(context.listener.fMagneticField[2]) + "]";
            c.drawText(str, 20, 800, paint);

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
