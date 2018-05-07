package com.example.basmet.recyclerview;

import java.io.Serializable;

/**
 * Created by basmet on 3/23/2018.
 */

public class Person implements Serializable{
    private String name;
    private int age;
    private int height;
    public Person(String Name, int Age,int Height){
        name = Name;
        age = Age;
        height = Height;
    }

    public Person() {

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String toString(){
        return getName() + " " + getAge() + " " + getHeight();
    }



}
