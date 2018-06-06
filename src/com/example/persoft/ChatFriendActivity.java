package com.example.persoft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class ChatFriendActivity extends ActionBarActivity{
	
	public Button sendMessage;
	public ListView chatlogList;
	public EditText txv;
	public BaseAdapter chatAdapter;
	public int lastChatId = 0;

	public ArrayList<ChatLog> contentChat = new ArrayList<ChatLog>();
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chatfriend);
        
        sendMessage = (Button) findViewById(R.id.send);
		chatlogList = (ListView) findViewById(R.id.chatlog_list_view);
		txv =  (EditText) findViewById(R.id.sendcontent);
        
		getChatLog();
		listViewInit();
		loopDownData();
		sendMessage.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String content = txv.getText().toString();
				sendMessage(content);
			}
		});
        
    }

	@SuppressLint("NewApi") private void loopDownData() {
		// TODO Auto-generated method stub
		AsyncTask<Integer, String, Void> loopTask = new AsyncTask<Integer, String, Void>(){

			@Override
			protected Void doInBackground(Integer... arg0) {
				// TODO Auto-generated method stub
				
				try {
					while(true){
						Thread.sleep(5000);
						
						URL url = new URL("http://192.168.43.246:8080/project/findChatLog.jsp?sender="+ConfigData.username+"&friend="+ConfigData.chatName);
						BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
						StringBuffer buf = new StringBuffer();;
						String line;
						line = in.readLine();
						while((line=in.readLine()) != null){
							buf.append(line);
						}
						in.close();
						
						String json = buf.toString();
						Gson gson = new GsonBuilder().setDateFormat("yyyyMMddHHmmss").create();
						ChatLog[] chatlog = gson.fromJson(json, ChatLog[].class);
						//contentChat.clear();
						for(int i=0;i<chatlog.length;i++){
							if(chatlog[i].getId()>lastChatId){
								contentChat.add(chatlog[i]);
								lastChatId = chatlog[i].getId();
							}	
						}		
						publishProgress("success");
						
					}
					
				} catch (Exception e) {
					// TODO: handle exception
				}
				return null;
			}
			@Override
			protected void onProgressUpdate(String... values) {
				if("success".equals(values[0])){
					chatAdapter.notifyDataSetChanged();
				}
			}
		};
		
		loopTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
		
	}

	private void listViewInit() {
		// TODO Auto-generated method stub
		chatAdapter = new BaseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public View getView(int position, View arg1, ViewGroup arg2) {
				// TODO Auto-generated method stub
				ChatLog log = contentChat.get(position);
				View v ;
				System.out.println(log.getSenderName()+" =?"+ConfigData.username);
				if(log.getSenderName().equals(ConfigData.username)){
					//me
				
					v = getLayoutInflater().inflate(R.layout.mechat, null);
					
					TextView tv = (TextView) v.findViewById(R.id.meSayText);
					tv.setText(log.getSencContent());
					
					TextView datv = (TextView) v.findViewById(R.id.meSayDate);
					datv.setText(log.getSendTime().getHours()+":"+log.getSendTime().getMinutes());
		
				}else{
					//other
					
					v = getLayoutInflater().inflate(R.layout.friendchat, null);
					TextView tv = (TextView) v.findViewById(R.id.otherSayText);
					tv.setText(log.getSencContent());
					
					TextView datv = (TextView) v.findViewById(R.id.otherSayDate);
					datv.setText(log.getSendTime().getHours()+":"+log.getSendTime().getMinutes());
				}
				
				
				return v;
			
			}
			
			@Override
			public long getItemId(int arg0) {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public Object getItem(int arg0) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return contentChat.size();
			}
		};
		chatlogList.setAdapter(chatAdapter);
		
	}

	@SuppressLint("NewApi") protected void getChatLog() {
		// TODO Auto-generated method stub
		AsyncTask<String, String, String> getLogTask = new AsyncTask<String, String, String>(){

			@Override
			protected String doInBackground(String... arg0) {
				// TODO Auto-generated method stub
				try {
					URL url = new URL("http://192.168.43.246:8080/project/findChatLog.jsp?sender="+ConfigData.username+"&friend="+ConfigData.chatName);
					BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
					StringBuffer buf = new StringBuffer();;
					String line;
					line = in.readLine();
					while((line=in.readLine()) != null){
						buf.append(line);
					}
					in.close();
					
					String json = buf.toString();
					Gson gson = new GsonBuilder().setDateFormat("yyyyMMddHHmmss").create();
					ChatLog[] chatlog = gson.fromJson(json, ChatLog[].class);
					//contentChat.clear();
					for(int i=0;i<chatlog.length;i++){
						if(chatlog[i].getId()>lastChatId){
							contentChat.add(chatlog[i]);
							lastChatId = chatlog[i].getId();
						}	
					}		
					
					publishProgress("success");
					
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return null;
			}	
			
			@Override
			protected void onProgressUpdate(String... values) {
				if("success".equals(values[0])){
					chatAdapter.notifyDataSetChanged();
				}
			}
			@Override
			protected void onPostExecute(String result) {
				
			}
			
		};
		getLogTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
	}

	//发送消息
	@SuppressLint("NewApi") private void sendMessage(String content) {
		// TODO Auto-generated method stub
		//先往数据库里存数据
		AsyncTask<String, Void, String> task = new AsyncTask<String, Void, String>(){

			@Override
			protected String doInBackground(String... params) {
				// TODO Auto-generated method stub
				try {
					//将聊天的记录推送到数据库里面
					System.out.println(ConfigData.username+"  "+ConfigData.chatName+" "+params[0]);
					URL url = new URL("http://192.168.43.246:8080/project/publishChat.jsp?sender="+ConfigData.username+"&friend="+ConfigData.chatName+"&content="+params[0]);
					
					
					BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
					StringBuffer buf = new StringBuffer();;
					String line;
					line = in.readLine();
					while((line=in.readLine()) != null){
						buf.append(line);
					}
					in.close();
					//System.out.println(users);
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
				return null;
			}
			@Override
			protected void onPostExecute(String result) {
				
				getChatLog();
			}
		};
		
		task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,content);
		txv.setText("");
	}
	
	

	
}
