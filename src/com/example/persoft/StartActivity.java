package com.example.persoft;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class StartActivity extends ActionBarActivity{
	
	
	private Button signup;
	private Button signin;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);
        Init();
      
    }
	
	public void Init(){
		signup = (Button) findViewById(R.id.signUp);
		signin = (Button) findViewById(R.id.signIn);
		
		
		//µÇÂ¼
		signin.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(StartActivity.this,LoginActivity.class);
				startActivity(intent);
			}
		});
		
		signup.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(StartActivity.this,SignUpActivity.class);
				startActivity(intent);
				
			}
		});
		
	}
}
