package sensor.main.app;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class SensorList extends Activity{
	TextView textview;
	private SensorManager mSensorManager;
	
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Log.d("Entry-Log","Enter onStart() function on SensorList");
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		Log.d("Entry-Log","Enter onCreate() function on SensorList");
		setContentView(R.layout.sensorlist);
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.d("Entry-Log","Enter onResume() function on SensorList");
		textview = (TextView) findViewById(R.id.textview1);
		textview.setVisibility(View.GONE);
	    
	    mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
	    List<Sensor> mList= mSensorManager.getSensorList(Sensor.TYPE_ALL);
	      
	    for (int i = 1; i < mList.size(); i++) {
	    	textview.setVisibility(View.VISIBLE);
	    	textview.append("\n" + "Sensor Name: " + mList.get(i).getName() + "\n" + "Vendor: " + mList.get(i).getVendor() + "\n" + "Version: " + mList.get(i).getVersion() + "\n\n");
	    }
	}
}