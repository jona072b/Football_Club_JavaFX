package BL;

import data.ReadPlayers;
import data.WritePlayers;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Jonathan on 14-03-2017.
 */
public class Team {
    ArrayList<Player> allPlayers;

    public Team() {
        this.allPlayers = getAllPlayers();
    }

    public void addPlayer(Player p){
        allPlayers.add(p);
        new WritePlayers().save(allPlayers);
    }

    public void addPlayer(String firstName, String lastName, int age, int team){
        Player p = new Player(firstName, lastName, age, team);
        addPlayer(p);
    }

    public ArrayList<Player> getAllPlayers() {
        return ReadPlayers.readAll();
    }

    public Player getPlayer(String fullName){
        Scanner lineScan = new Scanner (fullName);
        String firstName = lineScan.next();
        String lastName = lineScan.next();
        for(Player p: getAllPlayers()){
            if(p.getFirstName().equals(firstName) && p.getLastName().equals(lastName)){
                return p;
            }
        }
        return null;
    }

    public int getIndex(Player p){
        int index = 0;
        for(Player pl: allPlayers){
            if(pl.getFirstName().equals(p.getFirstName()) && pl.getLastName().equals(p.getLastName()) && pl.getAge() == p.getAge() && pl.getTeam() == p.getTeam()){
                return index;
            }
            index ++;
        }
        return -1;
    }

    public void deletePlayer(Player p){
        allPlayers.remove(getIndex(p));
        new WritePlayers().save(allPlayers);
    }

    public ArrayList<Player> getTeam(int teamNumber){
        ArrayList<Player> end = new ArrayList<>();
        for (Player p: allPlayers){
            if (p.getTeam() == teamNumber){
                end.add(p);
            }
        }
        return end;
    }
}
