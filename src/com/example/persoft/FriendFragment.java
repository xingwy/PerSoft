package com.example.persoft;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

@SuppressLint("NewApi") public class FriendFragment extends Fragment{
	public ListView friendView;
	private LayoutInflater inflater;
	public BaseAdapter friendAdapter;
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		this.inflater = inflater;
		View v = inflater.inflate(R.layout.friendlist, container,false);
		friendView = (ListView) v.findViewById(R.id.friendListView);
		
		initListView();
		return v;
	}

	
	private void initListView() {
		
		
		friendAdapter = new BaseAdapter() {
			
			@Override
			public View getView(int post, View old, ViewGroup arg2) {
				// TODO Auto-generated method stub
				View v ;
				v = inflater.inflate(R.layout.friend, null);
				
				final TextView tv = (TextView) v.findViewById(R.id.firendNm);
				tv.setText(ConfigData.list.get(post).getFriendname());
				
				Button friendBtn = (Button) v.findViewById(R.id.button1);
				
				ImageView friendImg = (ImageView) v.findViewById(R.id.friendImage);
				if(post%4 == 0){
					friendImg.setBackgroundResource(R.drawable.user1);
				}else if(post%4 == 1){
					friendImg.setBackgroundResource(R.drawable.user2);
				}else if(post%4 == 2){
					friendImg.setBackgroundResource(R.drawable.user3);
				}else{
					friendImg.setBackgroundResource(R.drawable.user4);
				}
				
				friendBtn.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						System.out.println(tv.getText());
						//设点击鼠标是得到当前的聊天对象
						ConfigData.chatName = tv.getText().toString();
						//跳转到聊天页面
						Intent intent = new Intent(getActivity(),ChatFriendActivity.class);
						startActivity(intent);
						
					}
				});
				
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
				
				int count = ConfigData.list.size();
				System.out.println("getcount"+count);
				return count;
			}
		};
		
		friendView.setAdapter(friendAdapter);
		
	}


}
