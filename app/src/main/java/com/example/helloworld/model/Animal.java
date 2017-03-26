package com.example.helloworld.model;

public class Animal {

    String name;
    int image;

    public Animal(String n, int i) {
        this.name = n;
        this.image = i;
    }

    public String getName(){
        return this.name;
    }

    public int getImage(){
        return this.image;
    }

}
