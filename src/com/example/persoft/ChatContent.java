package com.example.persoft;

import java.util.ArrayList;

public class ChatContent {
	//
	public String friendNmae;
	public ArrayList<ChatLog> chatlog = new ArrayList<ChatLog>();
	
	
	public ChatContent() {
		// TODO Auto-generated constructor stub
	}


	public String getFriendNmae() {
		return friendNmae;
	}

	//������������˵������¼
	public void pushLog(ChatLog log){
		chatlog.add(log);
	}

	public void setFriendNmae(String friendNmae) {
		this.friendNmae = friendNmae;
	}


	public ArrayList<ChatLog> getChatlog() {
		return chatlog;
	}

	
	public void setChatlog(ArrayList<ChatLog> chatlog) {
		this.chatlog = chatlog;
	}

}
