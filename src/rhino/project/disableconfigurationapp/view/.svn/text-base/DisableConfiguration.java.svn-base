package rhino.project.disableconfigurationapp.view;

import java.util.ArrayList;
import java.util.Calendar;

import rhino.project.disableconfigurationapp.R;
import rhino.project.disableconfigurationapp.model.WeakRepeat;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TimePicker;

public class DisableConfiguration extends Activity {
	AlarmManager alarmManager;
	PendingIntent pi;
	TimePicker alarmTimeTP;
	ArrayList<WeakRepeat> weakRepeats = null;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disable_configuration);

        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmTimeTP = (TimePicker) findViewById(R.id.timeDisableTP);
        alarmTimeTP.setIs24HourView(true);
    }

    public void setAlarmDisbleWifi(View view){
    	alarmTimeTP = (TimePicker) findViewById(R.id.timeDisableTP);
    	CheckBox activeCB = (CheckBox) findViewById(R.id.activeCB);

    	Calendar alarmCalendar = Calendar.getInstance();
    	alarmCalendar.set(Calendar.HOUR_OF_DAY, alarmTimeTP.getCurrentHour());
    	alarmCalendar.set(Calendar.MINUTE, alarmTimeTP.getCurrentMinute());
        alarmCalendar.set(Calendar.SECOND, 0);

    	Intent intent = new Intent();
    	intent.putExtra("hour", alarmCalendar.getTimeInMillis());
		intent.putExtra("active", activeCB.isChecked());
		intent.putExtra("weakRepeat", weakRepeats);

    	setResult(RESULT_OK, intent);
    	finish();
    }

    @SuppressWarnings("unchecked")
	@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    	if(requestCode == RequestCodes.WEAK_REPEAT && resultCode == RESULT_OK){
    		weakRepeats = new ArrayList<WeakRepeat>();
    		weakRepeats = (ArrayList<WeakRepeat>) data.getSerializableExtra("weakRepeat");
    	}
    }
    
    
    public void openRepeatList(View view){
    	
    	Intent intent = new Intent(getApplicationContext(), WeakRepeatAdapter.class);
    	startActivityForResult(intent, RequestCodes.WEAK_REPEAT);
    	
    }
    
    public void cancelAlarm() {
		finish();
	}
}