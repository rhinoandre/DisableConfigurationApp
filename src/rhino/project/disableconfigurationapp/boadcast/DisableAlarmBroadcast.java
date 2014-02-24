package rhino.project.disableconfigurationapp.boadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.util.Log;
import android.widget.*;

public class DisableAlarmBroadcast extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		Log.i("Alarme", "Alterar Wifi");
		
		Boolean active = intent.getBooleanExtra("active", false);
		Toast.makeText(context, "Alarme:"+intent.getBooleanExtra("active", false), Toast.LENGTH_SHORT).show();
		Log.i("Alarme", "Ativar? "+active);
		
		WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
		if(wifiManager.isWifiEnabled() != active){
			wifiManager.setWifiEnabled(active);
		}
	}
}
