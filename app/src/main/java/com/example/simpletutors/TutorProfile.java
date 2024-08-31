package com.example.simpletutors;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class TutorProfile{
    private Bitmap avatar;
    private String name = "";
    private String desc = "";
    private int id = -1;
    private ArrayList<String> courses;
    private String pricing = "";


    public TutorProfile() {
        courses = new ArrayList<String>();
    }

    public TutorProfile copy() {
        TutorProfile newProfile = new TutorProfile();
        newProfile.avatar = this.avatar.copy(Bitmap.Config.ARGB_8888, true);
        newProfile.name = this.name;
        newProfile.desc = this.desc;
        newProfile.id = this.id;
        //noinspection unchecked
        newProfile.courses = (ArrayList<String>) this.courses.clone();
        newProfile.pricing = this.pricing;
        return newProfile;
    }


    public Bitmap getAvatar() {
        return avatar;
    }
    public void setAvatar(Bitmap avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }
    public void setName(String newName) {
        name = newName;
    }

    public String getDesc() {
        return desc;
    }
    public void setDesc(String newDesc) {
        desc = newDesc;
    }

    public int getId() {
        return id;
    }
    public void setId(int newId) {
        id = newId;
    }

    public ArrayList<String> getCourses() {
        return courses;
    }
    public void addCourse(String course) {
        courses.add(course);
    }
    public String popCourse() {
        if(courses.size() > 0)
            return courses.remove(courses.size()-1);
        return null;
    }

    public String getPricing() {
        return pricing;
    }

    public void setPricing(String pricing) {
        this.pricing = pricing;
    }
}