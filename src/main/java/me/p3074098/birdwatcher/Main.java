package me.p3074098.birdwatcher;

public class Main {

    public static void main(String[] args) {

        BirdWatcher[] array = new BirdWatcher[3];

        array[0] = new BirdWatcher("William Kirsch", "Blue Feathered Heron", 17);
        array[1] = new BirdWatcher("Peyton Peck", "Red Robin", 17);
        array[2] = new BirdWatcher("Adrian Janner", "Blue Jay", 17);

        for (BirdWatcher b : array) {
            System.out.println(b.getName() + " is a bird watcher whose favorite bird is the " + b.getFavoriteBird() + " and happens to be 17 years old.");
        }
    }
}
