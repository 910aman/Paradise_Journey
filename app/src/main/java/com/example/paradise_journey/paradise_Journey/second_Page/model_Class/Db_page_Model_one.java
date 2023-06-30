package com.example.paradise_journey.paradise_Journey.second_Page.model_Class;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.paradise_journey.paradise_Journey.first_Page.model_Class.Model_One;

public class Db_page_Model_one implements Parcelable {
    String name;
    String description;
    String address;
    String height;

    String img;

    public Db_page_Model_one(Model_One one){
        this.name = one.getName();
        this.img = one.getImg();
    }

    Db_page_Model_one(){

    }

    protected Db_page_Model_one(Parcel in) {
        name = in.readString();
        description = in.readString();
        address = in.readString();
        height = in.readString();
        img = in.readString();
    }

    public static final Creator<Db_page_Model_one> CREATOR = new Creator<Db_page_Model_one>() {
        @Override
        public Db_page_Model_one createFromParcel(Parcel in) {
            return new Db_page_Model_one(in);
        }

        @Override
        public Db_page_Model_one[] newArray(int size) {
            return new Db_page_Model_one[size];
        }
    };

    @Override
    public String toString() {
        return
                "name =" + name +
                "\ndescription =" + description +
                "\naddress =" + address +
                "\nheight =" + height +
                "\nimg =" + img ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Db_page_Model_one(String name, String description, String address, String height, String img) {
        this.name = name;
        this.description = description;
        this.address = address;
        this.height = height;
        this.img = img;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(description);
        dest.writeString(address);
        dest.writeString(height);
        dest.writeString(img);
    }
}
