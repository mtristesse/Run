package tris.games.run;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.util.Log;

/**
 * Created by Tris on 5/10/2015.
 */
public class MoveListener implements Defines, SensorEventListener {

    public float fGravity[] = new float[3];
    public float fAccelerometer[] = new float[3];
    public float fLinearAccelerometer[] = new float[3];
    public float fMagneticField[] = new float[3];

    public float fOrientation[] = new float[3];

    public MoveListener() {
        fGravity[0] = fGravity[1] = fGravity[2] = 0;
    }



    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        Log.i(TAG, "onSensorChanged ");

        if (sensorEvent.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            Log.i(TAG, "Accelerometer sensor");
            System.arraycopy(sensorEvent.values, 0, fAccelerometer, 0, 3);
            Log.i(TAG, " x = " + fAccelerometer[0]);
            Log.i(TAG, " y = " + fAccelerometer[1]);
            Log.i(TAG, " z = " + fAccelerometer[2]);


        } else if (sensorEvent.sensor.getType() == Sensor.TYPE_GRAVITY) {
            Log.i(TAG, "Gravity sensor");
            System.arraycopy(sensorEvent.values, 0, fGravity, 0, 3);
            Log.i(TAG, " x = " + fGravity[0]);
            Log.i(TAG, " y = " + fGravity[1]);
            Log.i(TAG, " z = " + fGravity[2]);

        } else if (sensorEvent.sensor.getType() == Sensor.TYPE_LINEAR_ACCELERATION) {
            Log.i(TAG, "Linear accelerometer sensor");
            System.arraycopy(sensorEvent.values, 0, fLinearAccelerometer, 0, 3);
            Log.i(TAG, " x = " + fLinearAccelerometer[0]);
            Log.i(TAG, " y = " + fLinearAccelerometer[1]);
            Log.i(TAG, " z = " + fLinearAccelerometer[2]);

        } else if (sensorEvent.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD) {
            Log.i(TAG, "Magnetic field sensor");
            System.arraycopy(sensorEvent.values, 0, fMagneticField, 0, 3);
            Log.i(TAG, " x = " + fMagneticField[0]);
            Log.i(TAG, " y = " + fMagneticField[1]);
            Log.i(TAG, " z = " + fMagneticField[2]);
        } else if (sensorEvent.sensor.getType() == Sensor.TYPE_ORIENTATION) {
            Log.i(TAG, "Orientation sensor");
            System.arraycopy(sensorEvent.values, 0, fOrientation, 0, 3);
            Log.i(TAG, " x = " + fOrientation[0]);
            Log.i(TAG, " y = " + fOrientation[1]);
            Log.i(TAG, " z = " + fOrientation[2]);
        }



    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        Log.i(TAG, "onAccuracyChanged");

    }
}
