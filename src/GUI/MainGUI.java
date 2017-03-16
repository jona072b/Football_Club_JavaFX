package GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
/**
 * Created by Jonathan on 14-03-2017.
 */
public class MainGUI extends Application{
            //Laver dem uden for det hele, sådan at de kan kaldes fra de andre GUI klasser
            public static Scene mainMenu;
            public static Stage window;

            @Override
            public void start(Stage primaryStage) throws Exception{
            window = primaryStage;
            primaryStage.setTitle("The Football Club");
            //Laver label som header
            Label lb1 = new Label("Football Club");
            //Laver HBox til indhold
            HBox hb = new HBox();
            Button btnCreate = new Button("Create Player");
            //Sætter action på button
            btnCreate.setOnAction(event -> {
                //Kalder CreatePlayer scene
                createPlayer cp1 = new createPlayer();
                cp1.buttonClicked(window);
            });
            Button btnView = new Button("View all Players");
            btnView.setOnAction(event -> {
                ShowPlayers sp1 = new ShowPlayers();
                 sp1.buttonClicked(window);
            });

            hb.getChildren().addAll(lb1, btnCreate, btnView);

            mainMenu = new Scene(hb,500,600);

            window.setScene(mainMenu);
            window.show();
        }


        public static void main(String[] args) {
            launch(args);
        }
}
