package com.example.myapplication;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class RickLocations {

    @SerializedName("id")
    @Expose
    private int Id;
    @SerializedName("name")
    @Expose
    private String Name;
   private ArrayList<String> residents;

    public ArrayList<String> getResidents() {
        return residents;
    }

    public void setResidents(ArrayList<String> residents) {
        this.residents = residents;
    }

    public int getId() {
        return Id;
    }

    public void setNumber(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }



}
