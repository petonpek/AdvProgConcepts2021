package me.p3074098;

import sun.misc.ClassLoaderUtil;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Gotcha {

    private LinkedList<Person> list;

    public void load() {
        List<String> names;
        try {
            File file = new File("src/main/me.p3074098/gotcha.txt");
            System.out.println(file.getAbsolutePath());
            names = Files.readAllLines(Paths.get(file.getAbsolutePath()));
        }catch (IOException e){
            return;
        }

        names.forEach(n -> System.out.println(n));
    }

    public static void main(String[] args) {
        new Gotcha().load();
    }

    private static class Person {

        private String name;

        public Person(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
