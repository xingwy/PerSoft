package com.example.persoft;

import java.util.ArrayList;
import java.util.Date;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

@SuppressLint("NewApi") public class ChatFragment extends Fragment{
	Button sendBtn;
	EditText chatET;
	ListView chatLV;
	BaseAdapter chatAdapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		//this.inflater = inflater;
		View v = inflater.inflate(R.layout.friendlist, container,false);
		//ап╠М
		//chatLV = (ListView) v.findViewById(R.id.chatLV);
		//initListView();
		//initLoopDownloadTask();
		return v;
	}
	
//	private void initLoopDownloadTask() {
//		AsyncTask<Integer, String, Void> task = new AsyncTask<Integer, String, Void>(){
//			@Override
//			protected Void doInBackground(Integer... arg0) {
//				try {
//					int lastChatLogID=100;
//					while(true){
//						Thread.sleep(5000);
//						//URL.....
//						//http://xxxxxx/getChatlog.jsp?userid1=1&userid2=2&lastChatLogID=100
//						//http://xxxxxx/getChatlog.jsp?userid1=1&userid2=2&lastChatLogID=107
//						//http://xxxxxx/getChatlog.jsp?userid1=1&userid2=2&lastChatLogID=109
//						Chatlog cl = new Chatlog(8,2,1,"hehe",new Date(),null);
//						chatLogList.add(cl);
//						publishProgress("success");
////						publishProgress("nothing");
//						
//					}
//					
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//				return null;
//			}
//			@Override
//			protected void onProgressUpdate(String... values) {
//				if("success".equals(values[0])){
//					chatAdapter.notifyDataSetChanged();
//				}
//			}
//		};
//		task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,1,2);
//	}
//	private void initListView() {
//		chatAdapter = new BaseAdapter() {
//			
//			@Override
//			public View getView(int position, View old, ViewGroup arg2) {
//				Chatlog log = chatLogList.get(position);
//				View v ;
//				if(log.getUserid1() == 1){
//					//me
//					v = inflater.inflate(R.layout.me_say, null);
//				}else{
//					//other
//					v = inflater.inflate(R.layout.other_say, null);
//				}
//				TextView tv = (TextView) v.findViewById(R.id.logTV);
//				tv.setText(log.getContent());
//				
//				return v;
//			}
//			
//			@Override
//			public long getItemId(int arg0) {
//				// TODO Auto-generated method stub
//				return 0;
//			}
//			
//			@Override
//			public Object getItem(int arg0) {
//				// TODO Auto-generated method stub
//				return null;
//			}
//			
//			@Override
//			public int getCount() {
//				// TODO Auto-generated method stub
//				return chatLogList.size();
//			}
//		};
//		
//		chatLV.setAdapter(chatAdapter);
//	}
//	protected void sendMessage(String content) {
//		AsyncTask<String, Void, String> task = new AsyncTask<String, Void, String>(){
//			@Override
//			protected String doInBackground(String... params) {
//				//URL.....
//				Chatlog cl = new Chatlog(8,1,2,params[0],new Date(),null);
//				chatLogList.add(cl);
//				return "success";
//			}
//			@Override
//			protected void onPostExecute(String result) {
//				chatAdapter.notifyDataSetChanged();
//			}
//		};
//		task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,content);
//	}
}
