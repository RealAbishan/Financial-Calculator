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
public class keyBoard extends Application
{
    public static void main(String[] args)
    {

        launch(args);
    }

    public static void boardStage()
    {

        Stage windowKeyboard= new Stage();

        windowKeyboard.setTitle("On Screen Keyboard");

        Button btnSeven = new Button("7");
        btnSeven.setLayoutY(50);
        btnSeven.setLayoutX(50);
        btnSeven.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 300px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;");




        Button btnEight = new Button("8");
        btnEight.setLayoutX(100);
        btnEight.setLayoutY(50);
        btnEight.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 300px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;");

        Button btnNine = new Button("9");
        btnNine.setLayoutY(50);
        btnNine.setLayoutX(150);
        btnNine.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 300px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;");



        Button btnFour = new Button("4");
        btnFour.setLayoutY(100);
        btnFour.setLayoutX(50);
        btnFour.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 300px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;");


        Button btnFive = new Button("5");
        btnFive.setLayoutX(100);
        btnFive.setLayoutY(100);
        btnFive.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 300px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;");

        Button btnSix = new Button("6");
        btnSix.setLayoutY(100);
        btnSix.setLayoutX(150);
        btnSix.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 300px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;");




        Button btnOne = new Button("1");
        btnOne.setLayoutY(150);
        btnOne.setLayoutX(50);
        btnOne.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 300px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;");


        Button btnTwo = new Button("2");
        btnTwo.setLayoutX(100);
        btnTwo.setLayoutY(150);
        btnTwo.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 300px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;");

        Button btnThree = new Button("3");
        btnThree.setLayoutY(150);
        btnThree.setLayoutX(150);
        btnThree.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 300px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;");


        Button btnZero = new Button("0");
        btnZero.setLayoutX(50);
        btnZero.setLayoutY(200);
        btnZero.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 300px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;"+
                "-fx-pref-width:75px;");

        Button btnDecimal = new Button(".");
        btnDecimal.setLayoutY(200);
        btnDecimal.setLayoutX(150);
        btnDecimal.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 300px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;");


        Button btnPositive = new Button("+");
        btnPositive.setLayoutX(200);
        btnPositive.setLayoutY(50);
        btnPositive.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 300px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;"+
                "-fx-pref-height: 85px;");


        Button btnNegative = new Button("-");
        btnNegative.setLayoutY(150);
        btnNegative.setLayoutX(200);
        btnNegative.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 300px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;"+
                "-fx-pref-height: 85px;");






        Pane layoutKeyBoard = new Pane();
        layoutKeyBoard.getChildren().addAll(btnSeven,btnEight,btnNine,btnFour,btnFive,
                btnSix,btnOne,btnTwo,btnThree,btnDecimal,btnZero,btnNegative,btnPositive);
        layoutKeyBoard.setId("keyBoardStyle");
        layoutKeyBoard.getStylesheets().addAll("style.css");

        windowKeyboard.setScene(new Scene(layoutKeyBoard,275,275));
        windowKeyboard.show();


    }

    @Override
    public void start(Stage primaryStage) throws Exception {

    }


}
