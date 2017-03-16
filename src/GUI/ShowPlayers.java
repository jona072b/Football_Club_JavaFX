package GUI;

import BL.Player;
import BL.Team;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

import static GUI.MainGUI.window;

/**
 * Created by Jonathan on 14-03-2017.
 */
public class ShowPlayers {
    private Scene scene;
    String teamShow = " ";

    public ShowPlayers() {
        this.scene = null;
    }

    public void buttonClicked(Stage window){
        GridPane gp = new GridPane();
        gp.setHgap(15);
        gp.setVgap(2);
        Label name = new Label("Name");
        Label age = new Label("Age");
        Label team = new Label("Team");

        gp.addRow(1,name,age,team);
        int count = 2;
        for(Player p: new Team().getAllPlayers()){
            addLToGP(gp,count, p);
            count++;
        }

        Button btnBack = new Button("Back");
        btnBack.setOnAction(event -> {window.setScene(MainGUI.mainMenu);});

        Button btnDel = new Button("Delete Player");
        btnDel.setOnAction(event -> {
            DeletePlayer dp = new DeletePlayer();
            dp.buttonClicked(window);
        });

        Button btnDif = new Button("See Specific Team");
        btnDif.setOnAction(event -> {

            specificTeam();
        });


        gp.add(btnBack,4,2);
        gp.add(btnDel, 4,3);
        gp.add(btnDif, 4,4);

        gp.setStyle("-fx-border-color: black; -fx-vertical-grid-lines-visible: true");


        scene = new Scene(gp,600,800);
        window.setScene(scene);

    }

    public void specificTeam(){
        GridPane gp = new GridPane();
        gp.setHgap(15);
        gp.setVgap(2);
        Label name = new Label("Name");
        Label age = new Label("Age");
        Label team = new Label("Team");

        gp.addRow(1,name,age,team);
        addCB(gp);

        Button btnSee = new Button("See Team");
        btnSee.setOnAction(event -> {
            //ArrayList<Player> list = new Team().getTeam(team);
            gp.getChildren().clear();
            startShow(gp);

            int count = 2;
            int teamNumber = 0;
            if (teamShow.equals("Team 1")){
                teamNumber = 1;
            } else {
                teamNumber = 2;
            }
            for(Player p: new Team().getTeam(teamNumber)){
                addLToGP(gp,count, p);
                count++;
            }
            gp.add(btnSee, 3,3);
            addCB(gp);
        });
        gp.add(btnSee,3,3);

        scene = new Scene(gp, 600,800);
        window.setScene(scene);

    }

    public void addLToGP(GridPane gp, int count, Player p){
        Text nameFL = new Text(p.getFirstName() + " " + p.getLastName());
        Text ageFL = new Text(String.valueOf(p.getAge()));
        Text teamFL = new Text(String.valueOf(p.getTeam()));
        gp.addRow(count, nameFL, ageFL, teamFL);
        //count++;
    }
    public void startShow(GridPane gp){
        gp.setHgap(15);
        gp.setVgap(2);
        Label name = new Label("Name");
        Label age = new Label("Age");
        Label team = new Label("Team");

        gp.addRow(1,name,age,team);
    }

    public void addCB (GridPane gp){
        ObservableList<String> choose = FXCollections.observableArrayList("Team 1", "Team 2");
        final ComboBox comboBox = new ComboBox(choose);

        gp.add(comboBox, 3,2);
        comboBox.setEditable(true);
        comboBox.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue ov, String t, String t1) {
                teamShow = t1;
            }
        });
    }
}
