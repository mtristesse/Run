package tris.games.run;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.util.Log;
import android.view.Display;

/**
 * Created by Tris on 3/10/2015.
 */
public class Config {

    public static final String TAG = "TAGRUN";

    public static Context context;
    public static int screenWidth;
    public static int screenHeight;

    public static void init(Context c) {
        context = c;

        Display display = ((Activity)context).getWindowManager().getDefaultDisplay();
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            Point size = new Point();
            display.getSize(size);
            Config.screenWidth = size.x;
            Config.screenHeight = size.y;
            Log.i(TAG, "screen size = " + Config.screenWidth + ", " + Config.screenHeight);
        } else {
            Config.screenWidth = display.getWidth();
            Config.screenHeight = display.getHeight();
        }
    }
}
