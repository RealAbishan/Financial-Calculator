package sample;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class Main extends Application {

    public static void main(String[] args)
    {

        launch(args);
    }


    public static void mainStage()
    {

        Stage windowMain = new Stage();
        windowMain.setTitle("Financial calculator");

// Creating Buttons And labels for the Main window

        Button btnGetStart = new Button("Get Start");
        btnGetStart.setLayoutY(300);
        btnGetStart.setLayoutX(400);
        btnGetStart.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 100px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;"+
                "-fx-pref-width: 150px;");
        btnGetStart.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage navigationStage = (Stage)btnGetStart.getScene().getWindow();
                windowMain.close();
                navigation.navigationStage();


            }
        });

        Label lblQuo = new Label("“A penny saved is worth two pennies earned . . . after taxes. ”");
        lblQuo.setMaxWidth(420);
        lblQuo.setWrapText(true);
        lblQuo.setLayoutX(25);
        lblQuo.setLayoutY(30);
        lblQuo.setStyle("-fx-text-fill: white;"+
                "-fx-font-size:40px;"+
                "-fx-font-family:Papyrus;");

        Pane layoutHome = new Pane();
        layoutHome.setId("homeStyle");
        layoutHome.getChildren().addAll(btnGetStart,lblQuo);
        layoutHome.getStylesheets().addAll("style.css");
        windowMain.setScene(new Scene(layoutHome,600,350));
        windowMain.show();


    }

    @Override
    public void start(Stage primaryStage) throws Exception {



        Pane layoutHomeSecondary = new Pane();
        Main.setScene(new Scene(layoutHomeSecondary,400,400));
        Main.mainStage();



    }
    private static void setScene(Scene scene) {
    }
}