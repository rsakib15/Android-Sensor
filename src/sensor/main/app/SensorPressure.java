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

public class SensorPressure extends Activity implements SensorEventListener{
	SensorManager mSensorManager;
	Sensor  mPressure;
	TextView textview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pressure);
		Log.d("Entry-Log","Enter onCreate() function on SensorPressure");
		mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
	    mPressure = mSensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE);
	}
	
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Log.d("Entry-Log","Enter onStart() function on SensorPressure");
	}
	

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.d("Entry-Log","Enter onResume() function on SensorPressure");
		mSensorManager.registerListener(this,  mPressure, SensorManager.SENSOR_DELAY_NORMAL);
		textview = (TextView) findViewById(R.id.textviewProximity);
		textview.setVisibility(View.GONE);
		
	}
	
	@Override
	protected void onPause() {
		// Be sure to unregister the sensor when the activity pauses.
	    super.onPause();
	    Log.d("Entry-Log","Enter onPause() function on SensorPressure");
	    mSensorManager.unregisterListener(this);
	}
	
	public final void onAccuracyChanged(Sensor sensor, int accuracy) {
	    // Do something here if sensor accuracy changes.
	}

	public final void onSensorChanged(SensorEvent event) {
	    // Do something with this sensor data.
		float p = event.values[0];
		String fp = String.format("%.02f", p);
		Log.d("Entry-Log","Enter Pressure onSensorChange() function on SensorPressure");
		Log.d("Entry-Log","Pressue Value = " + fp);
		textview.setVisibility(View.VISIBLE);
    	textview.setText("\n" + "Pressure " + "\n\n" +fp + "\n\n");
	}
}
