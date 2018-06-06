package com.example.persoft;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends ActionBarActivity{
	private Button login;
	private EditText username,password;
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.login);
	        Init();
	      
	    }
	 public void Init(){
		 login = (Button) findViewById(R.id.login);
		 username = (EditText) findViewById(R.id.username);
		 password = (EditText) findViewById(R.id.password);
		 
	
		 login.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				//����˻�����ɹ������¼�ɹ� ��ת
				System.out.println("�����¼");
				String un=username.getText().toString(),pw=password.getText().toString();
				System.out.println(un);
				checkUser(un,pw);
			}
		 });  
		 
	 }
	protected boolean checkUser(String un, String pw) {
		System.out.println("������");
		// TODO Auto-generated method stub
		AsyncTask<String, Void, String> task = new AsyncTask<String, Void, String>(){

			
			@SuppressLint("ShowToast") @Override
			protected String doInBackground(String... params) {
				// TODO Auto-generated method stub
				
				try {
					System.out.println("������ַ");
					URL url = new URL("http://192.168.43.246:8080/project/findUserByUsername.jsp?username="+params[0]);
					System.out.println("����û���"+params[0]);
					System.out.println("�����ɹ�");
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
					System.out.println(users);
					
					
						
					if(users.getPassword().equals(params[1])){
						System.out.println("����˶Գɹ�");
						ConfigData.username = users.getUsername();
						findUserFriend(users.getUsername());
						
						return "��¼�ɹ�";
				    }else{
					    return "�������";
					}
					
					
					
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return "��ע���˺�";
				}
				
				return null;
			}
			@SuppressLint("ShowToast") @Override
			protected void onPostExecute(String result){
				super.onPostExecute(result);
				if(result.equals("��¼�ɹ�")){
					Toast.makeText(LoginActivity.this, "Loading������", Toast.LENGTH_LONG).show();
					Intent intent = new Intent(LoginActivity.this,IndexActivity.class);
				    startActivity(intent);
				}else{
					Toast.makeText(LoginActivity.this, "��¼ʧ��,"+result, Toast.LENGTH_LONG).show();
				}
			}
		};
		task.execute(un,pw);
		
		System.out.println("�������");
		return false;
	}
	@SuppressLint("NewApi") protected void findUserFriend(String un) {
		// TODO Auto-generated method stub
		AsyncTask<String, Void, String> findFriendTask = new AsyncTask<String, Void, String>(){

			@Override
			protected String doInBackground(String... params) {
				// TODO Auto-generated method stub
				try {
					URL url = new URL("http://192.168.43.246:8080/project/findFriend.jsp?username="+params[0]);
					BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
					StringBuffer buf = new StringBuffer();;
					String line;
					line = in.readLine();
					while((line=in.readLine()) != null){
						buf.append(line);
					}
					in.close();
					
					String json = buf.toString();
					
					System.out.println("�б�=    "+json);
					Gson gson = new GsonBuilder().setDateFormat("yyyyMMddHHmmss").create();
					Friends[] friends = gson.fromJson(json, Friends[].class);
					
					//���潫�õ���������Ϣ����ConfigData
					ConfigData.list.clear();
					for(int i=0;i<friends.length;i++){
						ConfigData.list.add(friends[i]);
					}
					for(int i=0; i<ConfigData.list.size();i++){
						System.out.println(ConfigData.list.get(i).getFriendname());
					}
					
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return null;
			}
			
		};
		
		//findFriendTask.execute(un);
		findFriendTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,un);
	}




















}
