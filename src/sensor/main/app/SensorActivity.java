package sensor.main.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class SensorActivity extends Activity{

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Log.d("Entry-Log","Enter onStart() function on SensorActivity");
		setContentView(R.layout.main);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		Log.d("Entry-Log","Enter onCreate() function on SensorActivity");
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.d("Entry-Log","Enter onResume() function on SensorActivity");
	
	}
	
	public void sensorlistclick(View arg0){
		Log.d("Click-Event","Sensor List Event Clicked");
		Intent i = new Intent(this, SensorList.class);
		startActivity(i);
	}
	
	public void sensorproximityclick(View arg0){
		Log.d("Click-Event","Sensor Proximity Event Clicked");
		Intent i = new Intent(this, SensorProximity.class);
		startActivity(i);
	}
	
	public void sensoraccelerationclick(View arg0){
		Log.d("Click-Event","Sensor Acceleration Event Clicked");
		Intent i = new Intent(this, SensorAccelerometer.class);
		startActivity(i);
	}
	
	public void sensorlightclick(View arg0){
		Log.d("Click-Event","Sensor Light Event Clicked");
		Intent i = new Intent(this, SensorLight.class);
		startActivity(i);
	}
	
	public void sensormagneticclick(View arg0){
		Log.d("Click-Event","Sensor Magnetic Event Clicked");
		Intent i = new Intent(this, SensorMagnetic.class);
		startActivity(i);
	}
	
	public void sensorgyroscopeclick(View arg0){
		Log.d("Click-Event","Sensor gyroscope Event Clicked");
		Intent i = new Intent(this, SensorGyroscope.class);
		startActivity(i);
	}
	
	public void sensororientationclick(View arg0){
		Log.d("Click-Event","Sensor Orientation Event Clicked");
		Intent i = new Intent(this, SensorOrientation.class);
		startActivity(i);
	}
}
