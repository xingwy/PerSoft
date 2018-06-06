package com.example.persoft;

import java.sql.Timestamp;

/**
 * ChatLog entity. @author MyEclipse Persistence Tools
 */
public class ChatLog implements java.io.Serializable {

	private Integer id;
	private String senderName;
	private String friendName;
	private Timestamp sendTime;
	private String sencContent;
	private String remo1;
	private String remo2;
	private String remo3;
	// Constructors

	@Override
	public String toString() {
		return "ChatLog [id=" + id + ", senderName=" + senderName
				+ ", friendName=" + friendName + ", sendTime=" + sendTime
				+ ", sencContent=" + sencContent + ", remo1=" + remo1
				+ ", remo2=" + remo2 + ", remo3=" + remo3 + "]";
	}

	public Integer getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((friendName == null) ? 0 : friendName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((remo1 == null) ? 0 : remo1.hashCode());
		result = prime * result + ((remo2 == null) ? 0 : remo2.hashCode());
		result = prime * result + ((remo3 == null) ? 0 : remo3.hashCode());
		result = prime * result
				+ ((sencContent == null) ? 0 : sencContent.hashCode());
		result = prime * result
				+ ((sendTime == null) ? 0 : sendTime.hashCode());
		result = prime * result
				+ ((senderName == null) ? 0 : senderName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChatLog other = (ChatLog) obj;
		if (friendName == null) {
			if (other.friendName != null)
				return false;
		} else if (!friendName.equals(other.friendName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (remo1 == null) {
			if (other.remo1 != null)
				return false;
		} else if (!remo1.equals(other.remo1))
			return false;
		if (remo2 == null) {
			if (other.remo2 != null)
				return false;
		} else if (!remo2.equals(other.remo2))
			return false;
		if (remo3 == null) {
			if (other.remo3 != null)
				return false;
		} else if (!remo3.equals(other.remo3))
			return false;
		if (sencContent == null) {
			if (other.sencContent != null)
				return false;
		} else if (!sencContent.equals(other.sencContent))
			return false;
		if (sendTime == null) {
			if (other.sendTime != null)
				return false;
		} else if (!sendTime.equals(other.sendTime))
			return false;
		if (senderName == null) {
			if (other.senderName != null)
				return false;
		} else if (!senderName.equals(other.senderName))
			return false;
		return true;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getFriendName() {
		return friendName;
	}

	public void setFriendName(String friendName) {
		this.friendName = friendName;
	}

	public Timestamp getSendTime() {
		return sendTime;
	}

	public void setSendTime(Timestamp sendTime) {
		this.sendTime = sendTime;
	}

	public String getSencContent() {
		return sencContent;
	}

	public void setSencContent(String sencContent) {
		this.sencContent = sencContent;
	}

	public String getRemo1() {
		return remo1;
	}

	public void setRemo1(String remo1) {
		this.remo1 = remo1;
	}

	public String getRemo2() {
		return remo2;
	}

	public void setRemo2(String remo2) {
		this.remo2 = remo2;
	}

	public String getRemo3() {
		return remo3;
	}

	public void setRemo3(String remo3) {
		this.remo3 = remo3;
	}

	/** default constructor */
	public ChatLog() {
	}

	/** minimal constructor */
	public ChatLog(String senderName, String friendName, Timestamp sendTime,String sencContent) {
		this.sencContent = senderName;
		this.friendName = friendName;
		this.sendTime = sendTime;
		this.sencContent = sencContent;
	}

	/** full constructor */
	public ChatLog(String senderName, String friendName, Timestamp sendTime,
			String sencContent, String remo1, String remo2, String remo3) {
		this.sencContent = senderName;
		this.friendName = friendName;
		this.sendTime = sendTime;
		this.sencContent = sencContent;
		this.remo1 = remo1;
		this.remo2 = remo2;
		this.remo3 = remo3;
	}

}
