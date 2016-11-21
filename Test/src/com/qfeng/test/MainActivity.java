package com.qfeng.test;

import java.util.ArrayList;
import java.util.List;
import com.qfeng.test.fragment.FirstFragment;
import com.qfeng.test.fragment.SecondFragment;
import com.qfeng.test.fragment.ThirdFragment;
import com.qfeng.test.utils.Conastance;

import android.os.Bundle;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class MainActivity extends Activity implements OnCheckedChangeListener{
	
	private List<Fragment> fragments;
	private RadioGroup rg;
	private int lastShowPosition = -1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		rg = (RadioGroup) findViewById(R.id.rg);
		rg.setOnCheckedChangeListener(this);
		
		fragments = new ArrayList<Fragment>();
		Fragment f01 = new FirstFragment();
		Fragment f02 = new SecondFragment();
		Fragment f03 = new ThirdFragment();
		
		Bundle args = new Bundle();
		args.putString("url", Conastance.PATH);
		f01.setArguments(args);
		
		
		fragments.add(f01);
		fragments.add(f02);
		fragments.add(f03);
	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		for (int i = 0; i < group.getChildCount(); i++) {
			RadioButton button = (RadioButton) group.getChildAt(i);
			if (button.isChecked()) {
				showFragment(i);
				break;
			}
		}
	}

	private void showFragment(int position) {
		Fragment f = fragments.get(position);
		FragmentTransaction ft = getFragmentManager().beginTransaction();
		if (lastShowPosition!=-1) {
			Fragment lastF = fragments.get(lastShowPosition);
			ft.hide(lastF);
		}
		if (f.isAdded()) {
			ft.show(f);
		}else {
			ft.add(R.id.fl_container, f);
		}
		ft.commit();
		lastShowPosition = position;
	}
}
