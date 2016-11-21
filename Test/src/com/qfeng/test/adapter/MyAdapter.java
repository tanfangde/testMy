package com.qfeng.test.adapter;

import java.util.List;
import com.qfeng.test.R;
import com.qfeng.test.async.ImageAsyncTask;
import com.qfeng.test.async.ImageAsyncTask.OnFetchBitmapListener;
import com.qfeng.test.entity.Info;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter{
	private Context context;
	private List<Info> data;
	
	public MyAdapter(Context context, List<Info> data) {
		super();
		this.context = context;
		this.data = data;
	}

	@Override
	public int getCount() {
		return data==null?0:data.size();
	}

	@Override
	public Object getItem(int position) {
		return data.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder vh = null;
		if (convertView==null) {
			convertView = LayoutInflater.from(context).inflate(
					R.layout.first_item, parent,false);
			vh = new ViewHolder();
			vh.ivPic = (ImageView) convertView.findViewById(R.id.iv_pic);
			vh.tvTitle = (TextView) convertView.findViewById(R.id.tv_title);
			vh.tvSummary = (TextView) convertView.findViewById(R.id.tv_summary);
			
			convertView.setTag(vh);
		}else {
			vh = (ViewHolder) convertView.getTag();
		}
		
		Info info = data.get(position);
		
		final ImageView iv = vh.ivPic;
		iv.setImageResource(R.drawable.ic_launcher);
		iv.setTag(info.getPic());
		
		final String pic = info.getPic();
		ImageAsyncTask task = new ImageAsyncTask(new OnFetchBitmapListener() {
			
			@Override
			public void onFetch(Bitmap bm) {
				if (pic.equals(iv.getTag())) {
					iv.setImageBitmap(bm);
				}
			}
		});
		
		task.execute(pic);
		
		vh.tvTitle.setText(info.getTitle());
		vh.tvSummary.setText(info.getFood_str());
		
		return convertView;
	}
	
	private class ViewHolder{
		public ImageView ivPic;
		public TextView tvTitle;
		public TextView tvSummary;
	}
	
}
