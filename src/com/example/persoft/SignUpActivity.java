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
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends ActionBarActivity{
	
	private Button addUser;
	private EditText addUsername,addUserpassword,addUserphonenumber;
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        Init();
      
    }

	private void Init() {
		// TODO Auto-generated method stub
		
		addUser = (Button) findViewById(R.id.addUser);
		addUsername = (EditText) findViewById(R.id.addUsername);
		addUserpassword = (EditText) findViewById(R.id.addUserpassword);
		addUserphonenumber = (EditText) findViewById(R.id.addUserphonenumber);
		
		addUser.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				System.out.println("注册用户");
				checkUser(addUsername.getText().toString(),addUserpassword.getText().toString(),addUserphonenumber.getText().toString());
			}
		});
		
			
		
	}

	private void checkUser(String name, String password, String phoneNumber) {
		// TODO Auto-generated method stub
		System.out.println("进入检查");
		// TODO Auto-generated method stub
		AsyncTask<String, Void, String> task = new AsyncTask<String, Void, String>(){

			
			@SuppressLint("ShowToast") @Override
			protected String doInBackground(String... params) {
				// TODO Auto-generated method stub
				
				try {
					System.out.println("解析网址");
					URL url = new URL("http://192.168.43.246:8080/project/addUser.jsp?username="+params[0]+"&password="+params[1]+"&phoneNumber="+params[2]);
					System.out.println("获得用户名"+params[0]);
					System.out.println("解析成功");
					BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
					StringBuffer buf = new StringBuffer();;
					String line;
					line = in.readLine();
					while((line=in.readLine()) != null){
						buf.append(line);
					}
					in.close();
					
					String json = buf.toString();
					
					
					return json;
					
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return null;
			}
			@SuppressLint("ShowToast") @Override
			protected void onPostExecute(String result){
				super.onPostExecute(result);
				if(result.length() == 8){
					System.out.println("注册成功");
					Toast.makeText(SignUpActivity.this, "注册成功", Toast.LENGTH_LONG).show();
					Intent intent = new Intent(SignUpActivity.this,LoginActivity.class);
					startActivity(intent);
				}else{
					Toast.makeText(SignUpActivity.this, "用户名已存在", Toast.LENGTH_LONG).show();
					System.out.println("用户名已存在");
				}
				
				}
		};
		task.execute(name,password,phoneNumber);
		
		System.out.println("任务结束");
	}


	
}
