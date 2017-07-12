package com.hencoder.hencoderpracticedraw1.practice;

/**
 * Created by james on 2017/7/10.
 */

public class PhoneData {
    private  String phoneName;
    private Integer PhoneUseNum;

    public PhoneData(String phoneName, Integer phoneUseNum) {
        this.phoneName = phoneName;
        PhoneUseNum = phoneUseNum;
    }

    public String getPhoneName() {
        return phoneName;
    }

    public void setPhoneName(String phoneName) {
        this.phoneName = phoneName;
    }

    public Integer getPhoneUseNum() {
        return PhoneUseNum;
    }

    public void setPhoneUseNum(Integer phoneUseNum) {
        PhoneUseNum = phoneUseNum;
    }
}
