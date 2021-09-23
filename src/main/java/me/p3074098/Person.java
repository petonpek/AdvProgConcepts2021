package me.p3074098;

public class Person {

    private String name;
    private int kills = 0;
    private int roundOut = 1;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getKills() {
        return kills;
    }

    public void addKill() {
        kills++;
    }

    public void setRoundOut(int roundOut) {
        this.roundOut = roundOut;
    }

    public int getRoundOut() {
        return roundOut;
    }

    public void serialize()
}
