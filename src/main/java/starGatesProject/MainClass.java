package starGatesProject;

import java.io.*;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        boolean startCheck = true;

        Scanner in = new Scanner(System.in);
        try {
            startCheck = FileLogChecker(in);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (!startCheck) {
            System.out.println("Hello. As you're here first time, we need to know some information. Write please:");
            firstAddInfo(in);
        } else {
            //чтение кэш-файлов
            //вывод из них PlanetarySystem, Planets & info about them
            //Testing capability of my project
            PlanetarySystem SolarSystem = new PlanetarySystem("Solarii", Location.NorthEast);

            Planet Earth = new Planet("Earth", true, -15, 9.8f, "kel");
            SolarSystem.addPlanet(Earth);
            Earth.addCountry("Russia", "Monarchy", Location.NorthEast, "Russians", false);
            Earth.addCountry("Ukraine", "Dictatorship", Location.SouthWest, "Ukranian", true);
            SolarSystem.removePlanet("Earth");
            Earth.addCountry("USA", "Freedom", Location.North, "American", true);
            Earth.getCountries().get(0).addRace("Mongolian");

            Planet Mars = new Planet("Mars", false, -29f, 6.3f, "lol");
            SolarSystem.addPlanet(Mars);
            Mars.addCountry("Persepopolis", "Republic", Location.South, "Aliens", false);
            Mars.addCountry("Loyersk", "Presidential republic", Location.NorthEast, "Nordic", false);


            Traveller Alex = new Traveller("Alex", Earth);
            Alex.searchForTraveling(SolarSystem);
            System.out.println(Alex.moveToOtherPlanet(Earth));
            System.out.println(Alex.getLocation());
            System.out.println(Alex.moveToOtherPlanet(Mars));
            //Testing ends here

            //int choice = menuChoice(in); - Archive for some time until tests will end
            menuChoice(in); //Especially for test
            /*switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    exit (0);
                    break;
            }*/
        }

    }

    private static int menuChoice(Scanner in) {
        System.out.println("Menu.");
        System.out.println("1.Get all info about ur place of living");
        System.out.println("2.Add new planet to planet system");
        System.out.println("3.Teleport to another planet");
        System.out.println("4.Remove planet from your planet system");
        System.out.println("5.Update some information about one of the planets");
        System.out.println("6.Leave from this boring text simulator :)");
        int choice = in.nextInt();
        return choice;
    }

    private static void firstAddInfo(Scanner in) {
        String startInfo = "";
        System.out.println("PlanetarySystem: ");
        startInfo += in.nextLine() + System.getProperty("line.separator");
        System.out.println("Planet: ");
        startInfo += in.nextLine() + System.getProperty("line.separator");
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("C:/Users/User/Documents/JavaProject/FileLog.txt", true));
            System.out.println(startInfo);
            writer.write(startInfo);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean FileLogChecker(Scanner in) throws FileNotFoundException {

        String directoryPath = "C:/Users/User/Documents/JavaProject";
        File dir1 = new File(directoryPath);
        directoryPath = "C:/Users/User/Documents/JavaProject/FileLog.txt";
        File dir2 = new File(directoryPath);
        dir1.mkdirs();
        try {
            dir2.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        in = new Scanner(new FileReader(directoryPath));
        if (dir2.length() == 0) return false;
        String line = in.nextLine();
        if (line.isEmpty())
            return false;
        else return true;

    }
}