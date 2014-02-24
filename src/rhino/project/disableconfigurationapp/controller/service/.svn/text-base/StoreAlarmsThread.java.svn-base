package rhino.project.disableconfigurationapp.controller.service;

import java.util.ArrayList;

import rhino.project.disableconfigurationapp.model.Alarm;

import android.util.Log;

public class StoreAlarmsThread implements Runnable {
	ArrayList<Alarm> alarms;
	
	private boolean running = false;

	@Override
	public void run() {
		Log.i("Alarme", "Thread iniciada");
		
		alarms = new ArrayList<Alarm>();
		setRunning(true);
	
		//TODO: Verificar dados do banco
		
		while (running) {}
	}

	public synchronized boolean isRunning() {
		return running;
	}

	public synchronized void setRunning(boolean running) {
		this.running = running;
	}

	@SuppressWarnings("unchecked")
	public synchronized ArrayList<Alarm> getAlarms() {
		return (ArrayList<Alarm>) alarms.clone();
	}

	public synchronized void setAlarms(ArrayList<Alarm> alarms) {
		this.alarms = alarms;
	}
	
	public void insertNewAlarm(Alarm alarm){
		alarms.add(alarm);
	}
	
	public void stop(){
		setRunning(false);
	}
}
