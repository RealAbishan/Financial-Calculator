package sample;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import static java.lang.Math.log;
import static java.lang.Math.pow;

public class navigation extends Application {


    public static void navigationStage()
    {

        Stage windowNavigation = new Stage();

        windowNavigation.setTitle("Navigation");



//Button For the  Back Button

        Button btnBack = new Button("Back");
        btnBack.setLayoutX(30);
        btnBack.setLayoutY(400);
        btnBack.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 100px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;"+
                "-fx-pref-width: 150px;");
        btnBack.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage savingsStage = (Stage)btnBack.getScene().getWindow();
                windowNavigation.close();
                Main.mainStage();


            }
        });




        Label lblTitle = new Label("Financial Calculator");
        lblTitle .setLayoutY(30);
        lblTitle .setLayoutX(30);
        lblTitle.setStyle("-fx-font-size: 40px;"+
                "-fx-font-family: 'Bodoni MT Black';"+
                "-fx-text-fill: white;");

// Button for Navigate to the Savings Window

        Button btnSavings = new Button("Savings");
        btnSavings.setLayoutY(100);
        btnSavings.setLayoutX(30);
        btnSavings.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 100px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;"+
                "-fx-pref-width: 150px;");
        btnSavings.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage savingsStage = (Stage)btnSavings.getScene().getWindow();
                windowNavigation.close();
                financialCalculator.savingsStage();


            }
        });







//Button for Navigate to the Compound Interest Window

        Button btnCompound = new Button("Compound Interest");
        btnCompound.setLayoutY(150);
        btnCompound.setLayoutX(30);
        btnCompound.setStyle("-fx-background-color: white;"+
                     "-fx-background-radius: 100px;"+
                     "-fx-font-family: Papyrus;"+
                     "-fx-text-alignment: center;"+
                     "-fx-pref-width: 150px;");

        btnCompound.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage compoundStage = (Stage)btnCompound.getScene().getWindow();
                windowNavigation.close();
                compoundInterest.compoundStage();


            }
        });



        Button btnMortgage = new Button("Mortgages");
        btnMortgage.setLayoutY(200);
        btnMortgage.setLayoutX(30);
        btnMortgage.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 100px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;"+
                "-fx-pref-width: 150px;");
        btnMortgage.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage mortgageStage = (Stage)btnMortgage.getScene().getWindow();
                windowNavigation.close();
                mortgage.mortgageStage();


            }
        });



        Button btnLoans = new Button("Loans");
        btnLoans.setLayoutY(250);
        btnLoans.setLayoutX(30);
        btnLoans.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 100px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;"+
                "-fx-pref-width: 150px;");
        btnLoans.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage loanStage = (Stage)btnLoans.getScene().getWindow();
                windowNavigation.close();
                loan.loanStage();


            }
        });



        Button btnHelp = new Button("Help");
        btnHelp.setLayoutX(30);
        btnHelp.setLayoutY(300);
        btnHelp.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 100px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;"+
                "-fx-pref-width: 150px;");
        btnHelp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage savingsStage = (Stage)btnHelp.getScene().getWindow();
                windowNavigation.close();
                HelpView.helpStage();


            }
        });



        Label quotes = new Label("“Do not save what is left after spending; instead spend what is left after saving.”");
        quotes.setMaxWidth(150);
        quotes.setWrapText(true);
        quotes.setLayoutY(100);
        quotes.setLayoutX(260);
        quotes.setStyle("-fx-text-fill: white;"+
                "-fx-font-size:22.5px;"+
                "-fx-font-family:Papyrus;");


        Pane layoutNavigate = new Pane();
        layoutNavigate.setId("navigateWindow");
        layoutNavigate.setId("navigateStyle");
        layoutNavigate.getChildren().addAll(lblTitle,btnSavings,btnCompound,btnMortgage,btnLoans,btnBack,btnHelp,quotes);
        layoutNavigate.getStylesheets().addAll("style.css");
        windowNavigation.setScene(new Scene(layoutNavigate,475,450));
        windowNavigation.show();






    }
    public static void main(String[] args)
    {

        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {



    }
}