package rhino.project.disableconfigurationapp.model;

import java.util.ArrayList;

import android.app.PendingIntent;

public class Alarm {
	private PendingIntent pendingIntent;
	private long alarmTime;
	private ArrayList<WeakRepeat> weakRepeats;
	private boolean active;
	
	public Alarm(PendingIntent pendingIntent, long alarmTime,
			ArrayList<WeakRepeat> weakRepeats, boolean active) {
		super();
		this.pendingIntent = pendingIntent;
		this.alarmTime = alarmTime;
		this.weakRepeats = weakRepeats;
		this.active = active;
	}

	public synchronized PendingIntent getPendingIntent() {
		return pendingIntent;
	}

	public synchronized void setPendingIntent(PendingIntent pendingIntent) {
		this.pendingIntent = pendingIntent;
	}

	public synchronized long getAlarmTime() {
		return alarmTime;
	}

	public synchronized void setAlarmTime(long alarmTime) {
		this.alarmTime = alarmTime;
	}

	public synchronized ArrayList<WeakRepeat> getWeakRepeats() {
		return weakRepeats;
	}

	public synchronized void setWeakRepeats(ArrayList<WeakRepeat> weakRepeats) {
		this.weakRepeats = weakRepeats;
	}

	public synchronized boolean isActive() {
		return active;
	}

	public synchronized void setActive(boolean active) {
		this.active = active;
	}
	
	
}
