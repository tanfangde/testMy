package com.qfeng.test.async;

import com.qfeng.test.utils.HttpUtils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

public class ImageAsyncTask extends AsyncTask<String, Void, Bitmap>{
	private OnFetchBitmapListener listener;

	public ImageAsyncTask(OnFetchBitmapListener listener) {
		super();
		this.listener = listener;
	}

	@Override
	protected Bitmap doInBackground(String... params) {
		byte[] data = HttpUtils.get(params[0]);
		if (data!=null) {
			System.out.println("=====>"+data);
			return BitmapFactory.decodeByteArray(data, 0, data.length);
		}
		return null;
	}
	
	@Override
	protected void onPostExecute(Bitmap result) {
		super.onPostExecute(result);
		listener.onFetch(result);
	}
	
	public interface OnFetchBitmapListener {
		void onFetch(Bitmap bm);
	}
}
