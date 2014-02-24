package rhino.project.disableconfigurationapp.view.adapter;

import java.util.ArrayList;
import java.util.Calendar;

import rhino.project.disableconfigurationapp.R;
import rhino.project.disableconfigurationapp.model.WeakRepeat;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ListAlarmsAdapter extends ArrayAdapter<Intent> {
	
	private int resourse;
	
	public ListAlarmsAdapter(Context context) {
		super(context, R.layout.item_list_alarm);
		this.resourse = R.layout.item_list_alarm;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		Intent item = getItem(position);
		
		RelativeLayout layout = null;
		if(convertView == null){
			LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			layout = (RelativeLayout) layoutInflater.inflate(resourse, null);
		} else {
			layout = (RelativeLayout) convertView;
		}
		
		ImageView imageView  = (ImageView) layout.findViewById(R.id.imageView);
		TextView alarmType   = (TextView) layout.findViewById(R.id.alarmType);
		TextView alarmTime   = (TextView) layout.findViewById(R.id.alarmTime);
		TextView alarmRepeat = (TextView) layout.findViewById(R.id.alarmRepeat);
		
		Calendar hour = Calendar.getInstance();
		hour.setTimeInMillis(item.getLongExtra("hour", 0));
		
		if(item.getBooleanExtra("active", false)){
			imageView.setImageResource(R.drawable.ic_wifi_habilitado);
			alarmType.setText(R.string.wifi_enabled);
		} else {
			imageView.setImageResource(R.drawable.ic_wifi_disabled);
			alarmType.setText(R.string.wifi_disabled);
		}
		
		alarmTime.setText(hour.get(Calendar.HOUR_OF_DAY)+":"+hour.get(Calendar.MINUTE));
		
		ArrayList<WeakRepeat> weakRepeats = new ArrayList<WeakRepeat>();
		weakRepeats = (ArrayList<WeakRepeat>) item.getSerializableExtra("weakRepeat");
		
		for(int i=0;i<weakRepeats.size();i++){
			if(i != weakRepeats.size()-1){
				alarmRepeat.append(weakRepeats.get(i).getResource() + ", ");
			} else {
				alarmRepeat.append(weakRepeats.get(i).getResource());
			}
		}
		
		return layout;
	}
}
