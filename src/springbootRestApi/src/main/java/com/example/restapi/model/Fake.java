package com.example.restapi.model;

public class Fake {

    private String name;
    private int age;

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


public Fake(String name, int age){
    this.name = name;
    this.age = age;
}


}
