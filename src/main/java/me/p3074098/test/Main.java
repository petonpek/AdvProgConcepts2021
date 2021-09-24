package me.p3074098.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Main {
    
    private List<Contestant> contestants;
    
    public static void main(String[] args) {
        new Main().onEnable();
    }
    
    public void onEnable() {
        contestants = new ArrayList<>();
        
        contestants.add(new Contestant("John"));
        contestants.add(new Contestant("Sally"));
        
        serialize();
        deserialize();
        
        while (true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            System.out.println("Tick");
        }
    }
    
    public void deserialize() {
        try {
            File file = new File(new File(getClass().getProtectionDomain().getCodeSource().getLocation().getFile()).getParentFile(), "database.txt");
            
            if (!file.exists()) {
                file.createNewFile();
                this.contestants = new ArrayList<>();
                return;
            }
            
            InputStream stream = new FileInputStream(file);
            ObjectInputStream inputStream = new ObjectInputStream(stream);
            this.contestants = (List<Contestant>) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public void serialize() {
        try {
            File file = new File(new File(getClass().getProtectionDomain().getCodeSource().getLocation().getFile()).getParentFile(), "database.txt");
            if (!file.exists())
                file.createNewFile();
            ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(file));
            stream.writeObject(contestants);
            stream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
