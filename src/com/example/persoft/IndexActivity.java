package com.example.persoft;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class IndexActivity extends ActionBarActivity{
	
Button chatBtn,findBtn,friendBtn,configBtn;
	
	Fragment chatFragment = new ChatFragment();
	FindFragment findFragment = new FindFragment();
	FriendFragment friendFragment = new FriendFragment();
	//ConfigFragment configFragment = new ConfigFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initBtn();
        getSupportFragmentManager().beginTransaction().replace(R.id.container, friendFragment).commit();
    }
	private void initBtn() {
		chatBtn = (Button) findViewById(R.id.chatBtn);
		findBtn = (Button) findViewById(R.id.findBtn);
		friendBtn = (Button) findViewById(R.id.friendBtn);
		configBtn = (Button) findViewById(R.id.configBtn);
		
		chatBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				getSupportFragmentManager().beginTransaction().replace(R.id.container, friendFragment).commit();
				
			}
		});
		findBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				getSupportFragmentManager().beginTransaction().replace(R.id.container, findFragment).commit();
				
			}
		});
		configBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				//getSupportFragmentManager().beginTransaction().replace(R.id.container, configFragment).commit();
				
			}
		});
		friendBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				getSupportFragmentManager().beginTransaction().replace(R.id.container, friendFragment).commit();
				
			}
		});
		
	}

	
}
