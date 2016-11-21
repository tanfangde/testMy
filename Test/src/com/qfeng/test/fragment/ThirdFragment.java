package com.qfeng.test.fragment;


import com.qfeng.test.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ThirdFragment extends Fragment {
	
	private TextView tv;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View ret = inflater.inflate(
				R.layout.fragment_third, 
				container, false);
		tv = (TextView) ret.findViewById(R.id.tv);
		
		return ret;
	}
}
