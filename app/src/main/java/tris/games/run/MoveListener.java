package tris.games.run;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.util.Log;

/**
 * Created by Tris on 5/10/2015.
 */
public class MoveListener implements SensorEventListener {

    public static final String TAG = Config.TAG;

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        Log.i(TAG, "onSensorChanged " + sensorEvent.sensor.getName());
        float acceleratorX = sensorEvent.values[0];
        float acceleratorY = sensorEvent.values[1];
        float acceleratorZ = sensorEvent.values[2];
        Log.i(TAG, " x = " + acceleratorX);
        Log.i(TAG, " y = " + acceleratorY);
        Log.i(TAG, " z = " + acceleratorZ);

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        Log.i(TAG, "onAccuracyChanged");

    }
}
