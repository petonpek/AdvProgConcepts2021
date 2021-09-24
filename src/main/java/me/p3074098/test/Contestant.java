package me.p3074098.test;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Contestant implements Serializable {
    
    
    private static final long serialVersionUID = 1L;
    
    private String name = "";
    private int kills = 0;
    private int round = 1;
    
    public Contestant(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public int getKills() {
        return kills;
    }
    
    public int getRound() {
        return round;
    }
    
    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();
    }
    
    private void readObject(ObjectInputStream ois) {
        try {
            ois.defaultReadObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error while loading Contestant class.");
            e.printStackTrace();
        }
    }
}
