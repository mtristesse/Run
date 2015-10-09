package tris.games.run;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.util.Log;
import android.view.Display;

/**
 * Created by Tris on 8/10/2015.
 * Where everything shared by the app's class is put
 */
public class App implements Defines{
    public static Context context;


    public static int screenWidth;
    public static int screenHeight;

    public static void log(String s) {
        Log.i(TAG, s);
    }

    public static void init(Context c) {
        App.context = c;

        Display display = ((Activity)App.context).getWindowManager().getDefaultDisplay();
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            Point size = new Point();
            display.getSize(size);
            screenWidth = size.x;
            screenHeight = size.y;
            Log.i(TAG, "screen size = " + screenWidth + ", " + screenHeight);
        } else {
            screenWidth = display.getWidth();
            screenHeight = display.getHeight();
        }
    }
}
