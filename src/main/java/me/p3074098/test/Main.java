package me.p3074098.test;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.net.URL;

public class Main {

    public static void main(String[] args) {
        Yaml yaml = new Yaml();
        URL url = getClass().getClassLoader().getResourceAsStream("gotcha.txt");
    }

    public void onEnable() {
        InputStream stream = getClass().getClassLoader().getResourceAsStream("gotcha.txt");
        Yaml yaml = new Yaml().load(stream);
        Constructor
    }
}
