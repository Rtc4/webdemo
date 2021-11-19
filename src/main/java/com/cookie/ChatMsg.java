package com.cookie;



import java.util.ArrayList;
import java.util.Date;

public class ChatMsg {
    public ArrayList<ChatMsg.Msg> list;
    public ChatMsg(){
        if(list==null){
            list=new ArrayList<ChatMsg.Msg>();
        }
    }
    public int MsgAdd(String username, String title, Date date, String msg){
        ChatMsg.Msg msg1 = new ChatMsg.Msg();
        msg1.setMsg(username,title,date,msg);
        list.add(msg1);
        return 0;
    }
    public static class Msg{
        private String username;
        private String title;
        private Date date;
        private String msg;
        public Msg(){

        }
        public int setMsg(String username,String title,Date date,String msg){
            this.username=username;
            this.title=title;
            this.date=date;
            this.msg=msg;
            return 0;
        }


        public String getUsername(){return this.username;}
        public Date getDate(){return this.date;}
        public String getMsg(){return this.msg;}
        public String getTitle(){return this.title;}
    }
}
