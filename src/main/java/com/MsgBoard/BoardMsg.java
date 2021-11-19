package com.MsgBoard;

import java.util.ArrayList;
import java.util.Date;

public class BoardMsg {
    public ArrayList<Msg> list;
    public BoardMsg(){
        if(list==null){
            list=new ArrayList<Msg>();
        }
    }
    public int MsgAdd(String username,String title,Date date,String msg){
            Msg msg1 = new Msg();
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
