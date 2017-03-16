package GUI;

import BL.Player;
import BL.Team;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Created by Jonathan on 14-03-2017.
 */
public class createPlayer {

    private Scene scene;

    public createPlayer() {
        scene = null;
    }

    public void buttonClicked (Stage window){
        //Creating gridPane
        GridPane gp = new GridPane();
        gp.setHgap(15);

        //Making labels
        Label firstName = new Label("Player First Name:");
        Label lastName = new Label("PLayer Last Name:");
        Label age = new Label("Player Age:");

        //Making textFields and checkboxes
        TextField firstNameTF = new TextField("firstname");
        TextField lastNameTF = new TextField("lastname");
        TextField ageTF = new TextField("age");
        CheckBox first = new CheckBox("First Team?");
        CheckBox second = new CheckBox("Second Team?");

        //Adding the stuff to the gridpattern
        gp.addColumn(1,firstName,lastName,age);
        gp.addColumn(2,firstNameTF, lastNameTF, ageTF, first, second);

        //Submit and back button
        Button submit = new Button("Submit");
        Button back = new Button("Back");

        back.setOnAction(event -> {window.setScene(MainGUI.mainMenu);});
        submit.setOnAction(event -> {
            AlertBox.display(window,"Create Player", "Are you sure you want to add a player \nwith these attributes?");
            int realAge = Integer.parseInt(ageTF.getText());
            int team = -1;
            if (first.isSelected()){
                team = 1;
            }else {
                team = 2;
            }
            if (AlertBox.accept){
            //Player p = new Player(firstNameTF.getText(),lastNameTF.getText(),realAge,team);
            new Team().addPlayer(firstNameTF.getText(),lastNameTF.getText(),realAge,team);
            AlertBox.display(window,"ALERT",firstNameTF.getText() + " " + lastNameTF.getText() + " " + realAge + " " + team);
            window.setScene(MainGUI.mainMenu);
            }
        });
        gp.addRow(6,back,submit);

        scene = new Scene(gp, 500,600);
        window.setScene(scene);
    }
}
