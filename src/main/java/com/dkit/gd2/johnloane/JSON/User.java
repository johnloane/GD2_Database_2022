package com.dkit.gd2.johnloane.JSON;

public class User
{
    private String name;
    private int age;
    private String town;

    public User(String name, int age, String town)
    {
        this.name = name;
        this.age = age;
        this.town = town;
    }

    public String getName()
    {
        return name;
    }

    public int getAge()
    {
        return age;
    }

    public String getTown()
    {
        return town;
    }

    @Override
    public String toString()
    {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", town='" + town + '\'' +
                '}';
    }
}
