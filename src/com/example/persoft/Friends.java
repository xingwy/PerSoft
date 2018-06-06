package com.example.persoft;



/**
 * Friends entity. @author MyEclipse Persistence Tools
 */

public class Friends  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String username;
     private String friendname;
     private String memo1;
     private String memo2;


    // Constructors

    /** default constructor */
    public Friends() {
    }

	/** minimal constructor */
    public Friends(String username, String friendname) {
        this.username = username;
        this.friendname = friendname;
    }
    
    /** full constructor */
    public Friends(String username, String friendname, String memo1, String memo2) {
        this.username = username;
        this.friendname = friendname;
        this.memo1 = memo1;
        this.memo2 = memo2;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    public String getFriendname() {
        return this.friendname;
    }
    
    public void setFriendname(String friendname) {
        this.friendname = friendname;
    }

    public String getMemo1() {
        return this.memo1;
    }
    
    public void setMemo1(String memo1) {
        this.memo1 = memo1;
    }

    public String getMemo2() {
        return this.memo2;
    }
    
    public void setMemo2(String memo2) {
        this.memo2 = memo2;
    }
   








}