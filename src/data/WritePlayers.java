package data;

import BL.Player;

import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;

/**
 * Created by Jonathan on 14-03-2017.
 */
public class WritePlayers {
    public WritePlayers(){

    }
    public void save(ArrayList<Player> list){
        try {
            PrintStream output = new PrintStream(new File("C:\\Users\\Jonathan\\IdeaProjects\\Football_Club_JavaFX\\src\\data\\player.txt"));
            for (Player p : list) {
                output.print(p.print());
            }
            output.close();
        } catch (Exception e){
            System.out.println("Failed: " + e);
        }
    }
}
