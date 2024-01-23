package com.example.pregapp;

public class createData {
    String gender;
    String age;
    String weight;
    String height;
    String activity;
    String howCycle;
    String howPeriod;
    String device;
    String pragnet;

    public createData(String gender, String age, String weight, String height, String activity, String howCycle, String howPeriod, String device, String pragnet) {
        this.gender = gender;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.activity = activity;
        this.howCycle = howCycle;
        this.howPeriod = howPeriod;
        this.device = device;
        this.pragnet = pragnet;
    }

    public String getGender() {
        return gender;
    }

    public String getAge() {
        return age;
    }

    public String getWeight() {
        return weight;
    }

    public String getHeight() {
        return height;
    }

    public String getActivity() {
        return activity;
    }

    public String getHowCycle() {
        return howCycle;
    }

    public String getHowPeriod() {
        return howPeriod;
    }

    public String getDevice() {
        return device;
    }

    public String getPragnet() {
        return pragnet;
    }
}
