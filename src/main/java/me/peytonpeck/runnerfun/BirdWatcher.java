package me.peytonpeck.runnerfun;

public class BirdWatcher {

    private String name;
    private int age;
    private String favoriteBird;

    public BirdWatcher(String name, String favoriteBird, int age) {
        this.name = name;
        this.favoriteBird = favoriteBird;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getFavoriteBird() {
        return favoriteBird;
    }
}
