package rhino.project.disableconfigurationapp.controller;

import java.util.ArrayList;
import java.util.Calendar;

import rhino.project.disableconfigurationapp.R;
import rhino.project.disableconfigurationapp.boadcast.DisableAlarmBroadcast;
import rhino.project.disableconfigurationapp.controller.service.StoreAlarmsBinder;
import rhino.project.disableconfigurationapp.controller.service.StoreAlarmsService;
import rhino.project.disableconfigurationapp.model.Alarm;
import rhino.project.disableconfigurationapp.model.WeakRepeat;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;

public class ManagerAlarm {
	
	private Context context;
	private AlarmManager alarmManager;
	private StoreAlarmsService storeAlarmsService;
	
	private ServiceConnection conn;
	
	public ManagerAlarm(Context context) {
		this.context = context;
		alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
		
		conn = new ServiceConnection() {
			
			@Override
			public void onServiceConnected(ComponentName name, IBinder binder) {
				storeAlarmsService = ((StoreAlarmsBinder) binder).getService();
			}
			
			@Override
			public void onServiceDisconnected(ComponentName name) {}
			
		};
		
		Intent service = new Intent(context.getString(R.string.STORE_ALARM_SERVICE));
		context.bindService(service, conn, 0);
	}
	
	public boolean createNewAlarm(Intent information){
		
		boolean active = information.getBooleanExtra("active", false);
		Calendar alarmTime = Calendar.getInstance();
		alarmTime.setTimeInMillis(information.getLongExtra("hora", 0));

		Intent i = new Intent(context, DisableAlarmBroadcast.class);
		i.putExtra("active", active);
		PendingIntent pi = PendingIntent.getBroadcast(context, 0, i, PendingIntent.FLAG_ONE_SHOT);

		@SuppressWarnings("unchecked")
		ArrayList<WeakRepeat> weakRepeats = (ArrayList<WeakRepeat>) information.getSerializableExtra("weakRepeat");
		
		Alarm alarm = new Alarm(pi, alarmTime.getTimeInMillis(), weakRepeats, active);
		
		if(storeAlarmsService.getStoreAlarmsThread().isRunning()){
			storeAlarmsService.getStoreAlarmsThread().insertNewAlarm(alarm);
			alarmManager.set(AlarmManager.RTC, alarmTime.getTimeInMillis(), pi);
			
			return true;
		}
		
		return false;
	}
	
	public ArrayList<Alarm> checkExistingAlarms(){
		
		if(storeAlarmsService.getStoreAlarmsThread().isRunning()){
			return storeAlarmsService.getStoreAlarmsThread().getAlarms();
		}
		
		return null;
	}
}