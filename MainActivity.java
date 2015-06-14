package com.nkcs.softer.activity;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.example.seastar.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.view.Menu;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.chinasofti.seastar.internet.WebAccessUtils;
import com.chinasofti.seastar.po.Ienroll;
import com.chinasofti.seastar.po.Showienroll;
@TargetApi(Build.VERSION_CODES.GINGERBREAD)
@SuppressLint("NewApi")
public class ServiceActivity extends Activity {

	private List<Map<String, ?>> lstData;
	private ListView lstcourse;
	@TargetApi(Build.VERSION_CODES.GINGERBREAD)
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		StrictMode.setThreadPolicy(policy);
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_service);
		this.lstcourse = (ListView) this.findViewById(R.id.lstcourse);
		this.lstData = fetchData();
		SimpleAdapter adapter = new SimpleAdapter(this, this.lstData,
				R.layout.activity_service, new String[] { "course", "invitation",
						"coursefile" }, new int[] { R.id.course,
						R.id.invitation, R.id.coursefile });
		this.lstcourse.setAdapter(adapter);
	}

	private List<Map<String, ?>> fetchData() {
		// TODO Auto-generated method stub
		// 步骤4-1：创建一个空集合对象
		List<Map<String, ?>> lst = new ArrayList<Map<String, ?>>();
		
		// 步骤4-2：调用方法实现对网络服务的请求
		String response = WebAccessUtils.httpRequest("ShowCourseServiceServlet");
		
		// 步骤4-3：设置一个全新的类型Type
		Type ListShowienroll = new TypeToken<ArrayList<Showienroll>>() {
		}.getType();
		
		// 步骤4-4：创建并实例化一个Gson对象
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss").create();
		// 步骤4-5：解析JSon数据
		List<Showienroll> lstShowienroll = gson.fromJson(response, ListShowienroll);
		
		for(Showienroll showienroll:lstShowienroll){
		Map<String, Object> item = new HashMap<String, Object>();
		item.put("course", showienroll.getCname());
		item.put("invitation", "登录");
		item.put("coursefile", "注册");
		

		lst.add(item);
		}
		return lst;
	}

}
