package com.example.loginactivity;

public class worker_details {

    String name , aadhar , work ;

    public worker_details() {
    }

    public worker_details(String name, String aadhar, String work) {
        this.name = name;
        this.aadhar = aadhar;
        this.work = work;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAadhar() {
        return aadhar;
    }

    public void setAadhar(String aadhar) {
        this.aadhar = aadhar;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }
}
