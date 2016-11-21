package com.qfeng.test.utils;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.qfeng.test.entity.Info;

public class JSONParser {
	public static List<Info> parse(String json){
		List<Info> datas = null;
		datas = new ArrayList<Info>();
		try {
			JSONObject Obj = new JSONObject(json);
			JSONArray array = Obj.getJSONArray("data");
			Info info = null;
			for (int i = 0; i < array.length(); i++) {
				JSONObject jsonObj = array.getJSONObject(i);
				
				info = new Info();
				
				info.setTitle(jsonObj.getString("title"));
				info.setPic(jsonObj.getString("pic"));
				info.setFood_str(jsonObj.getString("food_str"));
				datas.add(info);
			}
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return datas;
		
	}
}
