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

public class SensorAccelerometer extends Activity implements SensorEventListener {
	
	SensorManager mSensorManager;
	Sensor mAccelerometer;
	TextView textview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		Log.d("Entry-Log","Enter onCreate() function on SensorAccelerometer");
		setContentView(R.layout.accelerometer);
		mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
	    mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
	}
	
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Log.d("Entry-Log","Enter onStart() function on SensorAccelerometer");
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.d("Entry-Log","Enter onResume() function on SensorAccelerometer");
		mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
		textview = (TextView) findViewById(R.id.textviewProximity);
		textview.setVisibility(View.GONE);
	}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		mSensorManager.unregisterListener(this);
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub
		Log.d("Entry-Log","Enter Accelerometer onAccuracyChanged() function on SensorAccelerometer");
	}

	@Override
	public void onSensorChanged(SensorEvent event) {
		// TODO Auto-generated method stub
		Log.d("Entry-Log","Enter Accelerometer onSensorChanged() function on SensorAccelerometer");
		
		float x = event.values[0];
		float y = event.values[1];
		float z = event.values[2];
		
		String fx = String.format("%.02f", x);
		String fy = String.format("%.02f", y);
		String fz = String.format("%.02f", z);
		
		Log.d("Entry-Log","Enter Proximity onSensorChange() function on SensorProximity");
		Log.d("Entry-Log","Accelarate Value x= " + fx +"ms^2 y = " + fy + "ms^2 z = " + fz + "ms^2");
		textview.setVisibility(View.VISIBLE);
    	textview.setText("Accelaration " + "\n\nX: " + fx + " m/s^2\nY: " + fy + " m/s^2\nZ: " + fz + " m/s^2\n");
	}

}
