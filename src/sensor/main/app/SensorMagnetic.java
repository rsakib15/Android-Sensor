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

public class SensorMagnetic extends Activity implements SensorEventListener{
	SensorManager mSensorManager;
	Sensor mMegnetic;
	TextView textview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.magnetic);
		Log.d("Entry-Log","Enter onCreate() function on SensorMagnetic");
		mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
	    mMegnetic = mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
	}
	
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Log.d("Entry-Log","Enter onStart() function on SensorMagnetic");
	}
	

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.d("Entry-Log","Enter onResume() function on SensorMagnetic");
		mSensorManager.registerListener(this,mMegnetic,SensorManager.SENSOR_DELAY_NORMAL);
		textview = (TextView) findViewById(R.id.textviewMagnetic);
		textview.setVisibility(View.GONE);
		
	}
	
	@Override
	protected void onPause() {
		// Be sure to unregister the sensor when the activity pauses.
	    super.onPause();
	    Log.d("Entry-Log","Enter onPause() function on SensorMagnetic");
	    mSensorManager.unregisterListener(this);
	}
	
	public final void onAccuracyChanged(Sensor sensor, int accuracy) {
	    // Do something here if sensor accuracy changes.
	}

	public final void onSensorChanged(SensorEvent event) {
	    // Do something with this sensor data.
		float x = event.values[0];
		float y = event.values [1];
		float z = event.values[2];
		
		String fx = String.format("%.02f", x);
		String fy = String.format("%.02f", y);
		String fz = String.format("%.02f", z);
		
		
		Log.d("Entry-Log","Enter Magnetic onSensorChange() function on SensorMagnetic");
		Log.d("Values","x = " + fx + "y="  + fy + "z= " + fz);
		textview.setVisibility(View.VISIBLE);
    	textview.setText("\n" + "Magnetic " + "\n\nx : " + fx + "\ny : " + fy + "\nz : " + fz);
	}
}
