package com.example.recyclerview_iiiwe;

public class Employee {
    private String mName;
    private int mAge;
    private String mAddress;

    public Employee(String mName, int mAge, String mAddress) {
        this.mName = mName;
        this.mAge = mAge;
        this.mAddress = mAddress;
    }

    public String getmName() {
        return mName;
    }

    public int getmAge() {
        return mAge;
    }

    public String getmAddress() {
        return mAddress;
    }
}
