package com.example.paradise_journey.paradise_Journey.second_Page.model_Class;

import java.util.ArrayList;

public class Db_page_Model_two extends ArrayList<Db_page_Model_two> {

    String name;
    String address;
    String description;
    String ideals;
    String img;

    Db_page_Model_two(){

    }

    @Override
    public String toString() {
        return
                "name=" + name +
                "\naddress= " + address +
                "\ndescription= " + description +
                "\nideals= " + ideals +
                "\nimg= " + img ;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIdeals() {
        return ideals;
    }

    public void setIdeals(String ideals) {
        this.ideals = ideals;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Db_page_Model_two(String name, String address, String description, String ideals, String img) {
        this.name = name;
        this.address = address;
        this.description = description;
        this.ideals = ideals;
        this.img = img;
    }

}
