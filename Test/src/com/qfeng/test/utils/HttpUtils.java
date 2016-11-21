package com.qfeng.test.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.http.HttpStatus;

import android.util.Log;

public class HttpUtils {
	public static byte[] get(String url) {
		byte[] ret = null;
		try {
			URL urlobj = new URL(url);

			HttpURLConnection conn = (HttpURLConnection) urlobj
					.openConnection();
			conn.setRequestMethod("GET");
			if (conn.getResponseCode() == HttpStatus.SC_OK) {
				InputStream is = conn.getInputStream();
				ByteArrayOutputStream bos = new ByteArrayOutputStream();
				int len = 0;
				byte[] buffer = new byte[512];
				while ((len = is.read(buffer)) != -1) {
					bos.write(buffer, 0, len);
				}
				ret = bos.toByteArray();
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			Log.e("网络下载失败！", e.toString());
		}

		return ret;
	}
}
