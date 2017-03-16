package BL;

/**
 * Created by Jonathan on 14-03-2017.
 */
public class Player {
    private String firstName;
    private String lastName;
    private int age;
    private int team;

    public Player(String firstName, String lastName, int age, int team) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.team = team;
    }

    @Override
    public String toString() {
        return "Name = " + firstName + " " + lastName + "\nAge = " + age + "\nTeam = " + team;
    }

    public String print(){
        return firstName + " " + lastName + " " + age + " " + team + "\n";
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getTeam() {
        return team;
    }

    public void setTeam(int team) {
        this.team = team;
    }
}
