package com.example.persoft;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;





import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint("NewApi") public class FindFragment extends Fragment{
	public ListView friendView;
	private LayoutInflater inflater;
	public BaseAdapter friendAdapter;
	public Button addFriend;
	public EditText un;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		this.inflater = inflater;
		View v = inflater.inflate(R.layout.addfriend, container,false);
		un = (EditText) v.findViewById(R.id.addFriendname);
		addFriend = (Button) v.findViewById(R.id.addFriend);
		
		
		addFriend.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String fn = un.getText().toString();
				checkUser(fn);
				un.setText("");
			}
		});
		
		
		return v;
	}
	protected void checkUser(String fn) {
		// TODO Auto-generated method stub
		AsyncTask<String, Void, String> task = new AsyncTask<String, Void, String>(){

			
			@SuppressLint("ShowToast") @Override
			protected String doInBackground(String... params) {
				// TODO Auto-generated method stub
				
				try {
					URL url = new URL("http://192.168.43.246:8080/project/findUserByUsername.jsp?username="+params[0]);
					BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
					StringBuffer buf = new StringBuffer();;
					String line;
					line = in.readLine();
					while((line=in.readLine()) != null){
						buf.append(line);
					}
					in.close();
				
					String json = buf.toString();
					Log.d("message",json);
					Gson gson = new GsonBuilder().setDateFormat("yyyyMMddHHmmss").create();
					Users users = gson.fromJson(json, Users.class);
					System.out.println("findfriend"+users.getUsername());
					//TODO： ① 判断朋友列表有没有这个人 ②没有的话发送添加消息机制
					
					for(int i=0;i<ConfigData.list.size();i++){
						if(users.getUsername().equals(ConfigData.list.get(i).getFriendname())){
							System.out.println("此用户已是好友");
							return "此用户已是好友";
						}
					}
					
					
					sendAddRes(ConfigData.username,params[0]);
					
					return "fail";
					
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return "没有此用户";
				}
				
				return null;
			}
			@SuppressLint("ShowToast") @Override
			protected void onPostExecute(String result){
				super.onPostExecute(result);
				    System.out.println(result);
					Toast.makeText(getActivity(), result, Toast.LENGTH_LONG).show();
//					Intent intent = new Intent(LoginActivity.this,IndexActivity.class);
//				    startActivity(intent);
		
			
			}
		};
		task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, fn);
		
		System.out.println("任务结束");
		
	}
	protected void sendAddRes(String UsN, String frN) {
		// TODO Auto-generated method stub
		
	}


	

}
