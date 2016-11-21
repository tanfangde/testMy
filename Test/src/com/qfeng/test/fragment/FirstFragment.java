package com.qfeng.test.fragment;

import java.util.ArrayList;
import java.util.List;
import com.qfeng.test.R;
import com.qfeng.test.adapter.MyAdapter;
import com.qfeng.test.async.JSONAsyncTask;
import com.qfeng.test.async.JSONAsyncTask.OnFetchDataListener;
import com.qfeng.test.entity.Info;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;

public class FirstFragment extends Fragment implements OnScrollListener{
	
	private ListView lv;
	private MyAdapter adapter;
	private List<Info> data;
	private boolean isBottom = false;
	private int pageIndex = 1;
	private String url;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		data = new ArrayList<Info>();
		
		adapter = new MyAdapter(getActivity(), data);
		
		url = getArguments().getString("url");
		init();
	}
	
	private void init() {
		JSONAsyncTask task = new JSONAsyncTask(new OnFetchDataListener() {
			
			@Override
			public void onFetch(List<Info> info) {
				data.addAll(info);
				adapter.notifyDataSetChanged();
			}
		});
		String path = String.format(url, pageIndex + "");
		task.execute(path);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View tv = inflater.inflate(R.layout.fragment_first, container, false);
		lv = (ListView) tv.findViewById(R.id.lv);
		
		return tv;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		lv.setAdapter(adapter);
		lv.setOnScrollListener(this);
	}

	@Override
	public void onScrollStateChanged(AbsListView view, int scrollState) {
		if (isBottom && scrollState == OnScrollListener.SCROLL_STATE_IDLE) {
			pageIndex++;
			init();
		}
		
	}

	@Override
	public void onScroll(AbsListView view, int firstVisibleItem,
			int visibleItemCount, int totalItemCount) {
		isBottom = firstVisibleItem+visibleItemCount == totalItemCount;
		
	}
}
