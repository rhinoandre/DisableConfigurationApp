package rhino.project.disableconfigurationapp.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;

public class WeakRepeatAdapter extends ArrayAdapter<CheckBox>{

	public WeakRepeatAdapter(Context context, int textViewResourceId) {
		super(context, textViewResourceId);
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		CheckBox checkBox = (CheckBox) getItem(position);
		
		ListView listView = null;
		if(convertView == null){
			LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			listView = (ListView) inflater.inflate(android.R.layout.simple_list_item_1, null);
		} else {
			listView = (ListView) convertView;
		}
		
		
		
		return super.getView(position, convertView, parent);
	}
}
