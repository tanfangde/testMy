package com.qfeng.test.fragment;


import com.qfeng.test.R;
import com.qfeng.test.adapter.DBManager;
import android.app.Fragment;
import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class SecondFragment extends Fragment implements OnClickListener {
	private EditText etSno;
	private EditText etName;
	private Button btn;
	private ListView lv;
	private DBManager dbManager;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		dbManager = new DBManager(getActivity());
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_second, container,false);
		lv = (ListView) view.findViewById(R.id.lv_data);
		btn = (Button) view.findViewById(R.id.btn);
		btn.setOnClickListener(this);
		return view;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		ContentValues values;
		for (int i = 0; i < 10; i++) {
			values = new ContentValues();
			values.put("name", "聂兴德"+i+"号");
			dbManager.insert(values);
		}
		
		
		
	}


	@Override
	public void onClick(View v) {
		Cursor c = dbManager.query(null, null);
		SimpleCursorAdapter adapter =new SimpleCursorAdapter(
				getActivity(), 
				android.R.layout.simple_list_item_2, 
				c, 
				new String[]{"name","_id"}, 
				new int[]{android.R.id.text1,android.R.id.text2}, 
				SimpleCursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
		
		lv.setAdapter(adapter);
		
	}
	
	
}
