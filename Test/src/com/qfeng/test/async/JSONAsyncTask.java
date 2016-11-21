package com.qfeng.test.async;

import java.util.List;

import android.os.AsyncTask;
import com.qfeng.test.entity.Info;
import com.qfeng.test.utils.HttpUtils;
import com.qfeng.test.utils.JSONParser;


public class JSONAsyncTask extends AsyncTask<String, Void, String>{
	private OnFetchDataListener listener;
	
	public JSONAsyncTask(OnFetchDataListener listener) {
		super();
		this.listener = listener;
	}


	@Override
	protected String doInBackground(String... params) {
		byte[] data = HttpUtils.get(params[0]);
		if (data!=null) {
			System.out.println("=====>"+data);
			return new String(data);
		}
		return null;
	}
	
	@Override
	protected void onPostExecute(String result) {
		super.onPostExecute(result);
		List<Info> parse = JSONParser.parse(result);
		listener.onFetch(parse);
	}
	
	public interface OnFetchDataListener {
		void onFetch(List<Info> info);
	}
}
