package rhino.project.disableconfigurationapp.controller.service;

import android.os.Binder;

public class StoreAlarmsBinder extends Binder {
	private StoreAlarmsService service;

	public StoreAlarmsBinder(StoreAlarmsService service) {
		this.service = service;
	}
	
	public StoreAlarmsService getService() {
		return service;
	}
	
}
