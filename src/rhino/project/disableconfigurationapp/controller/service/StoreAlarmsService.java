package rhino.project.disableconfigurationapp.controller.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class StoreAlarmsService extends Service {

	private StoreAlarmsBinder storeAlarmsBinder = new StoreAlarmsBinder(this);
	private static StoreAlarmsThread storeAlarmsThread;
	
	private boolean startThread;

	@Override
	public void onCreate() {
		super.onCreate();
		Log.i("Alarme", "Service Iniciado");
		
		startThread = true;
	}
	
	@Override
	public IBinder onBind(Intent intent) {
		Log.i("Alarme", "Alguém conectou!");
		return storeAlarmsBinder;
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.i("Alarme", "Método onStartComando() Chamado");
		
		if(startThread){
			storeAlarmsThread = new StoreAlarmsThread();
			new Thread(storeAlarmsThread).start();
			startThread = false;
		}
		
		return START_STICKY;
	}
	
	@Override
	public void onDestroy() {
		Log.i("Alarme", "Serviço destruido");

		storeAlarmsThread.stop();
	}
	
	public StoreAlarmsThread getStoreAlarmsThread(){
		return storeAlarmsThread;
	}
}
