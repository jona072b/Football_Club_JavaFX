package data;

import BL.Player;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Jonathan on 14-03-2017.
 */
public class ReadPlayers {

    public static ArrayList<Player> readAll() {
        ArrayList<Player> list = new ArrayList<>();
        try {
            Scanner filereader = new Scanner(new File("C:\\Users\\Jonathan\\IdeaProjects\\Football_Club_JavaFX\\src\\data\\player.txt"));
            while (filereader.hasNextLine()) {
                String line = filereader.nextLine();
                Scanner linereader = new Scanner(line);
                String firstName = linereader.next();
                String lastName = linereader.next();
                int age = linereader.nextInt();
                int team = linereader.nextInt();
                Player s1 = new Player(firstName, lastName, age, team);
                list.add(s1);
            }
        }
        catch (Exception e){
            System.out.println("Failed: " + e);
        }
        return list;
    }
}
