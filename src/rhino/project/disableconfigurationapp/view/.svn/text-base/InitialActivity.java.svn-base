package rhino.project.disableconfigurationapp.view;

import java.util.ArrayList;

import rhino.project.disableconfigurationapp.R;
import rhino.project.disableconfigurationapp.controller.ManagerAlarm;
import rhino.project.disableconfigurationapp.model.Alarm;
import rhino.project.disableconfigurationapp.view.adapter.ListAlarmsAdapter;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class InitialActivity extends Activity {

	private Intent addNewAlarm;
	private ListAlarmsAdapter listAlarmsAdapters;
	private ListView listAlarm;
	private ManagerAlarm managerAlarm;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.initial_activity);
		
		Intent storeAlarmService = new Intent(getApplicationContext().getString(R.string.STORE_ALARM_SERVICE));
		startService(storeAlarmService);
		
		listAlarmsAdapters = new ListAlarmsAdapter(getApplicationContext());
		listAlarm = (ListView) findViewById(R.id.listAlarm);
		managerAlarm = new ManagerAlarm(getApplicationContext());
	}

	@Override
	protected void onResume() {
		super.onResume();
//		TODO: Continuar a verificacao dos alarms existentes
		ArrayList<Alarm> alarms = new ArrayList<Alarm>();
//		alarms = managerAlarm.checkExistingAlarms();
		
		if(alarms != null){
			for (Alarm alarm : alarms) {
				
				Intent intent = new Intent();
				intent.putExtra("hour", alarm.getAlarmTime());
				intent.putExtra("repeatWeak", alarm.getWeakRepeats());
			}
			
		}
		
	}
	
	public void addAlarm(View view) {
		addNewAlarm = new Intent("rhino.app.alarm_management");
		startActivityForResult(addNewAlarm, RequestCodes.SCREEN_CREATE_ALARM);
	}

	public void settings(View view) {
		Toast.makeText(getApplicationContext(), "Configuracoes", Toast.LENGTH_SHORT).show();
	}

	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
		if (requestCode == RequestCodes.SCREEN_CREATE_ALARM && resultCode == RESULT_OK) {
			
			managerAlarm.createNewAlarm(intent);
			
			listAlarmsAdapters.add(intent);
			listAlarm.setAdapter(listAlarmsAdapters);
			listAlarm.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
					Toast.makeText(getApplicationContext(), "Selecionou uma posicao: "+position, Toast.LENGTH_SHORT).show();
				}
			});

		}
	}
}
