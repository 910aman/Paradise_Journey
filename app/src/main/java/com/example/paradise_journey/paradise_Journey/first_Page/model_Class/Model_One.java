package com.example.paradise_journey.paradise_Journey.first_Page.model_Class;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Model_One implements Parcelable {
    String img;
    String name;

    Model_One()
    {

    }

    protected Model_One(Parcel in) {
        img = in.readString();
        name = in.readString();
    }

    public static final Creator<Model_One> CREATOR = new Creator<Model_One>() {
        @Override
        public Model_One createFromParcel(Parcel in) {
            return new Model_One(in);
        }

        @Override
        public Model_One[] newArray(int size) {
            return new Model_One[size];
        }
    };

    @Override
    public String toString() {
        return "img=" + img +
                "name = " + name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Model_One(String img, String name) {
        this.img = img;
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(img);
        parcel.writeString(name);
    }
}
