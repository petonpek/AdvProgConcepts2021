package me.p3074098;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

public class Gotcha {

    public static void main(String[] args) {
        new Gotcha().load();
    }

    private LinkedList<Person> people;
    private List<Person> graveyard;

    public void load() {
        List<String> names = new ArrayList<>();
        try {
            URL url = getClass().getClassLoader().getResource("gotcha.txt");
            Scanner scanner = new Scanner(new File(url.getFile()));
            while (scanner.hasNextLine())
                names.add(scanner.nextLine());
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        makeList(names.stream().map(Person::new).collect(Collectors.toList()));
    }

    private void makeList(List<Person> names) {
        Collections.shuffle(names);

        people = new LinkedList<>();
        graveyard = new ArrayList<>();

        people.addAll(names);

        begin();
    }

    private void begin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Time to get got.");

        int round = 1;
        String input;
        do {

            if (people.size() <= 1) {
                System.out.println("Game over!");
                break;
            }

            LoopCommand command = null;
            while (command == null) {
                System.out.println("Enter a command.");
                System.out.println("Options: " + LoopCommand.toLine());
                String commandInput = scanner.nextLine();
                try {
                    command = LoopCommand.valueOf(commandInput.toUpperCase());
                } catch (IllegalArgumentException e) {
                    System.out.println(" > You entered an invalid command.");
                }
            }

            if (command == LoopCommand.RING) {
                printRing();
                continue;
            }

            if (command == LoopCommand.STOP) {
                System.out.println(" > Stopping the game...");
                break;
            }

            if (command == LoopCommand.GRAVEYARD) {
                printGraveyard(scanner);
                continue;
            }

            System.out.println("Who shall get got?");
            input = scanner.nextLine();

            final String name = input;
            Optional<Person> person = people.stream().filter(p -> p.getName().equalsIgnoreCase(name)).findFirst();

            if (!person.isPresent()) {
                System.out.println(" > You have not entered a valid (alive) player.");
                continue;
            }

            Person p = person.get();
            for (int i = 0; i < people.size(); i++) {
                Person current = people.get(i);
                Person next = i == people.size()-1 ? people.getFirst() : people.get(i+1);

                if (next.equals(p))
                    current.addKill();
                }

            p.setRoundOut(round);
            graveyard.add(p);
            people.removeFirstOccurrence(p);
            round++;

            System.out.println(" > " + p.getName() + " has been killed.");
            System.out.println();

        } while (true);

        display(scanner);
    }

    private void display(Scanner scanner) {
        Person winner = null;
        if (people.size() == 1)
            winner = people.getFirst();

        if (winner != null)
            System.out.println(winner.getName() + " is the winner with " + winner.getKills() + " kills.");
        else
            System.out.println("There is no winner...");

        printGraveyard(scanner);
    }

    private void printRing() {
        String contestants = "";
        for (Person p : people)
            contestants += p.getName() + " ";

        System.out.println(" > Current contestants: " + contestants);
    }

    private void printGraveyard(Scanner scanner) {
        if (graveyard.isEmpty()) {
            System.out.println(" > The graveyard is empty.");
            return;
        }

        LeaderboardSort sort = null;
        while (sort == null) {
            System.out.println("How would you like to sort the graveyard?");
            System.out.println("Options: " + LeaderboardSort.toLine());
            String input = scanner.nextLine();
            try {
                sort = LeaderboardSort.valueOf(input.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println(" > You entered an invalid sort method.");
            }
        }

        switch (sort) {
            case KILLS:
                graveyard.sort(Comparator.comparingInt(Person::getKills).reversed());
                break;
            case ROUND:
                graveyard.sort(Comparator.comparingInt(Person::getRoundOut).reversed());
                break;
            case ALPHABETICAL:
                graveyard.sort(Comparator.comparing(Person::getName));
                break;
        }

        System.out.println("Name           | Round | Kills");
        for (Person p : graveyard)
            System.out.println(convertSpacing(p.getName(), 14) + " | " + convertSpacing(p.getRoundOut(), 5) + " | " + convertSpacing(p.getKills(), 7));
        System.out.println();
    }

    private String convertSpacing(String s, int space) {
        String n = s;
        for (int i = 0; i < space-s.length(); i++)
            n += " ";

        return n;
    }

    private String convertSpacing(int i, int space) {
        return convertSpacing(String.valueOf(i), space);
    }

    private enum LeaderboardSort {
        ALPHABETICAL,
        KILLS,
        ROUND;

        public static String toLine() {
            String s = "";
            for (LeaderboardSort val : LeaderboardSort.values())
                s += val + " ";

            return s;
        }
    }

    private enum LoopCommand {
        KILL,
        RING,
        GRAVEYARD,
        STOP;

        public static String toLine() {
            String s = "";
            for (LoopCommand val : LoopCommand.values())
                s += val + " ";

            return s;
        }
    }
}
