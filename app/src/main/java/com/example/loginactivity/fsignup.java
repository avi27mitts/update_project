package com.example.loginactivity;

public class fsignup {


    //String cid;
    String cname;
    String cemail;
    String cpassword;
    String cphone;

    public fsignup(){

    }

    public fsignup( String cname, String cemail, String cpassword, String cphone) {
        //this.cid = cid;
        this.cname = cname;
        this.cemail = cemail;
        this.cpassword = cpassword;
        this.cphone = cphone;
    }

    /*public String getCid() {
        return cid;
    }*/

    public String getCname() {
        return cname;
    }

    public String getCemail() {
        return cemail;
    }

    public String getCpassword() {
        return cpassword;
    }

    public String getCphone() {
        return cphone;
    }
}
