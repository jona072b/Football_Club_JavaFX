package GUI;

import BL.Player;
import BL.Team;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * Created by Jonathan on 15-03-2017.
 */
public class DeletePlayer {
    public Scene scene;
    String fullName = " ";

    public DeletePlayer(){
        this.scene = scene;
    }

    public void buttonClicked (Stage window){
        GridPane gp = new GridPane();
        gp.setHgap(15);
        gp.setVgap(15);

        ObservableList<String> players = FXCollections.observableArrayList();

        for(Player p : new Team().getAllPlayers()){
            players.add(p.getFirstName() + " " + p.getLastName());

        }

        final ComboBox comboBox = new ComboBox(players);
        comboBox.setPromptText("Player");

        gp.add(comboBox, 1,1);
        comboBox.setEditable(true);
        comboBox.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue ov, String t, String t1) {
                fullName = t1;
            }
        });
        Button bntBack = new Button("Main Menu");
        bntBack.setOnAction(event -> window.setScene(MainGUI.mainMenu));
        Button btnDel = new Button("Delete player");
        btnDel.setOnAction(event -> {
            Player p = new Team().getPlayer(fullName);
            new Team().deletePlayer(p);
            window.setScene(MainGUI.mainMenu);
        });

        gp.add(bntBack,2,2);
        gp.add(btnDel,2,1);

        scene = new Scene(gp,600,800);

        window.setScene(scene);
        }


}
