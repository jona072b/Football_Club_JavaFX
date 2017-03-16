package GUI;

/**
 * Created by Jonathan on 14-03-2017.
 */
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox {
    public static boolean accept;
    public static void display(Stage window, String title, String message) {
        Stage alertBox = new Stage();
        BorderPane borderPane = new BorderPane();
        //Boolean end = null;

        alertBox.initModality(Modality.APPLICATION_MODAL); //block input with other windows
        alertBox.setTitle(title);
        alertBox.setMinWidth(250);

        Label label = new Label(message);

        Button yesBTN = new Button("Yes");
        Button noBTN = new Button("No");
        yesBTN.setOnAction(e -> {
            alertBox.close();
            accept = true;
        });

        noBTN.setOnAction(e -> {
            createPlayer cp1 = new createPlayer();
            window.setScene(MainGUI.mainMenu);
            alertBox.close();
            accept = false;
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label);
        layout.setAlignment(Pos.CENTER);

        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);
        hbox.setAlignment(Pos.CENTER);
        hbox.getChildren().addAll(yesBTN, noBTN);


        borderPane.setCenter(layout);
        borderPane.setBottom(hbox);



        Scene scene = new Scene(borderPane);

        alertBox.setScene(scene);

        alertBox.showAndWait();
        }
}
