package sensor.main.app;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class SensorLight extends Activity implements SensorEventListener{
	SensorManager mSensorManager;
	Sensor mLight;
	TextView textview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.light);
		Log.d("Entry-Log","Enter onCreate() function on SensorLight");
		mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
	    mLight = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
	}
	
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Log.d("Entry-Log","Enter onStart() function on SensorLight");
	}
	

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.d("Entry-Log","Enter onResume() function on SensorLight");
	    mSensorManager.registerListener(this, mLight, SensorManager.SENSOR_DELAY_NORMAL);
		textview = (TextView) findViewById(R.id.textviewLight);
		textview.setVisibility(View.GONE);
	}
	
	@Override
	protected void onPause() {
		// Be sure to unregister the sensor when the activity pauses.
	    super.onPause();
	    Log.d("Entry-Log","Enter onPause() function on SensorProximity");
	    mSensorManager.unregisterListener(this);
	}
	
	public final void onAccuracyChanged(Sensor sensor, int accuracy) {
	    // Do something here if sensor accuracy changes.
	}

	public final void onSensorChanged(SensorEvent event) {
	    // Do something with this sensor data.
		float distance = event.values[0];
		String lux = String.format("%.02f", distance);
		Log.d("Entry-Log","Enter Light onSensorChange() function on SensorLight");
		Log.d("Entry-Log","Light Value = " + lux);
		textview.setVisibility(View.VISIBLE);
    	textview.setText("\n" + "Light " + "\n\n" +lux + "\n\n");
	}
}
