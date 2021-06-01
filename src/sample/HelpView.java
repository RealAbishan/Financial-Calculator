package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.layout.StackPane;
import static java.lang.Math.log;
import static java.lang.Math.pow;

import java.awt.*;
import java.awt.TextArea;

public class HelpView extends Application
{
    public static void main(String[] args)
    {

        launch(args);
    }

    public static void helpStage()
    {

        Stage windowHelp = new Stage();

        windowHelp.setTitle("Help");

        Label lblHelpTitle = new Label("Help Window");
        lblHelpTitle.setLayoutY(50);
        lblHelpTitle.setLayoutX(50);
        lblHelpTitle.setStyle("-fx-text-fill: white;"+
                "-fx-font-size:40px;"+
                "-fx-font-family:Papyrus;");

        Label lblSav = new Label("Savings Calculation");
        lblSav.setLayoutX(50);
        lblSav.setLayoutY(150);
        lblSav.setStyle("-fx-text-fill: white;"+
                "-fx-font-size:16px;"+
                "-fx-font-family:Papyrus;");

        Label lblSa = new Label("You can Calculate the Future value, Annuity Payment , Interest rate ," +
                "No of Periods and Start Value with the Saving Calculator ");
        lblSa.setLayoutY(200);
        lblSa.setLayoutX(50);
        lblSa.setStyle("-fx-text-fill: white;"+
            "-fx-font-size:16px;");


        Label lblCom = new Label("Compound Calculation");
        lblCom.setLayoutX(50);
        lblCom.setLayoutY(250);
        lblCom.setStyle("-fx-text-fill: white;"+
                "-fx-font-size:16px;"+
                "-fx-font-family:Papyrus;");

        Label lblCo = new Label("You Can Calculate the Compound Interest Rate");
        lblCo.setLayoutY(300);
        lblCo.setLayoutX(50);
        lblCo.setStyle("-fx-text-fill: white;"+
                "-fx-font-size:16px;");

        Label lblMo = new Label("Mortgage CAlculation");
        lblMo.setLayoutX(50);
        lblMo.setLayoutY(350);
        lblMo.setStyle("-fx-text-fill: white;"+
                "-fx-font-size:16px;"+
                "-fx-font-family:Papyrus;");

        Label lblM = new Label("You Can Calculate Mortgages" +
                "with Loan term and Interest Rate");
        lblM.setLayoutY(400);
        lblM.setLayoutX(50);
        lblM.setStyle("-fx-text-fill: white;"+
                "-fx-font-size:16px;");


        Label lblLo = new Label("Loan Calculation");
        lblLo.setLayoutX(50);
        lblLo.setLayoutY(450);
        lblLo.setStyle("-fx-text-fill: white;"+
                "-fx-font-size:16px;"+
                "-fx-font-family:Papyrus;");

        Label lblL = new Label("You can calculate the Loan Amounts");
        lblL.setLayoutY(500);
        lblL.setLayoutX(50);
        lblL.setStyle("-fx-text-fill: white;"+
                "-fx-font-size:16px;");

        Button btnBack = new Button("Back");
        btnBack.setLayoutY(550);
        btnBack.setLayoutX(50);
        btnBack.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 100px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;"+
                "-fx-pref-width: 150px;");
        btnBack.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage savingsStage = (Stage)btnBack.getScene().getWindow();
                windowHelp.close();
                navigation.navigationStage();

            }
        });

        Pane layoutHelp = new Pane();
        layoutHelp.setId("helpStyle");
        layoutHelp.getChildren().addAll(lblHelpTitle,lblSav,lblSa,lblCo,lblCom,lblM,lblMo,lblL,lblLo,btnBack);
        layoutHelp.getStylesheets().addAll("style.css");
        windowHelp.setScene(new Scene(layoutHelp,950,600));
        windowHelp.show();

    }

    @Override
    public void start(Stage primaryStage) throws Exception {

    }
}

