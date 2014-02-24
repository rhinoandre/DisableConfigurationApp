package rhino.project.disableconfigurationapp.view;

import java.util.ArrayList;
import java.util.Calendar;

import rhino.project.disableconfigurationapp.R;
import rhino.project.disableconfigurationapp.model.WeakRepeat;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class WeakRepeatAdapter extends Activity {
	ListView listView;
	
	ArrayList<WeakRepeat> weakChecks;
	ArrayList<WeakRepeat> arrayToReturn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list_weak_repaet);

		arrayToReturn = new ArrayList<WeakRepeat>();
		listView = (ListView) findViewById(R.id.listWeakRepeat);
		listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
		ArrayAdapter<WeakRepeat> cheboxAdapter = new ArrayAdapter<WeakRepeat>(
				getApplicationContext(),
				android.R.layout.simple_list_item_multiple_choice,
				getWeakButtons());
		listView.setAdapter(cheboxAdapter);
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

			}
		});
	}

	private ArrayList<WeakRepeat> getWeakButtons() {
		if (weakChecks == null) {
			weakChecks = new ArrayList<WeakRepeat>();

			WeakRepeat sunday = new WeakRepeat(getApplicationContext().getResources().getString(R.string.sunday), Calendar.SUNDAY);
			weakChecks.add(sunday);

			WeakRepeat monday = new WeakRepeat(getApplicationContext().getResources().getString(R.string.monday), Calendar.MONDAY);
			weakChecks.add(monday);

			WeakRepeat tuesday = new WeakRepeat(getApplicationContext().getResources().getString(R.string.tuesday), Calendar.TUESDAY);
			weakChecks.add(tuesday);

			WeakRepeat wednesday = new WeakRepeat(getApplicationContext().getResources().getString(R.string.wednesday), Calendar.WEDNESDAY);
			weakChecks.add(wednesday);

			WeakRepeat thrusday = new WeakRepeat(getApplicationContext().getResources().getString(R.string.thrusday), Calendar.THURSDAY);
			weakChecks.add(thrusday);

			WeakRepeat friday = new WeakRepeat(getApplicationContext().getResources().getString(R.string.friday), Calendar.FRIDAY);
			weakChecks.add(friday);

			WeakRepeat saturday = new WeakRepeat(getApplicationContext().getResources().getString(R.string.saturday), Calendar.SATURDAY);
			weakChecks.add(saturday);
		}

		return weakChecks;
	}
	
	@Override
	public void onBackPressed() {
		Intent result = new Intent();
		SparseBooleanArray checked = listView.getCheckedItemPositions();
		
		for(int i=0;i<checked.size();i++){
			arrayToReturn.add(weakChecks.get(checked.keyAt(i)));
		}
		
		result.putExtra("weakRepeat", arrayToReturn);
		
		setResult(RESULT_OK, result);
		finish();
	}
}