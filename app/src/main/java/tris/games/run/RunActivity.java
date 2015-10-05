package tris.games.run;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class RunActivity extends ActionBarActivity {

	public static final String TAG = Config.TAG;
	
	private MainView mainView;
	public MainThread thread;
	public MainThread getThread() { return thread; }
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Config.init(this);

        if (mainView == null)
			mainView = new MainView(this);
		setContentView(mainView);

        //Thread
		thread = new MainThread(mainView);
		thread.start();


        //register listener
        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        Sensor sensorAccelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(new MoveListener(), sensorAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);


	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_quit) {
			finish();
			System.exit(0);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
