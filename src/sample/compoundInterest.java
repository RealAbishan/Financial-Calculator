package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.*;
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

public class compoundInterest extends Application
{
    public static void main(String[] args)
    {

        launch(args);
    }

    public static void compoundStage()
    {

        Stage windowCompound= new Stage();

        windowCompound.setTitle("Compound Interest");



//Label and Text Fields with Button controls for Compound Window

        Label lblComRate = new Label("Interest Rate:");
        lblComRate.setLayoutY(50);
        lblComRate.setLayoutX(40);
        lblComRate.setStyle("-fx-text-fill: white;"+
                "-fx-font-size:16px;");

        TextField txtComRate = new TextField("");
        txtComRate.setPromptText("%");
        txtComRate.setLayoutY(50);
        txtComRate.setLayoutX(150);
        txtComRate.setStyle("-fx-pref-width:325px;"+
                "-fx-background-radius: 15px;");


        Label lblComDown = new Label("Down Payment:");
        lblComDown.setLayoutY(100);
        lblComDown.setLayoutX(40);
        lblComDown.setStyle("-fx-text-fill: white;"+
                "-fx-font-size:16px;");

        TextField txtComDown = new TextField("");
        txtComDown.setLayoutY(100);
        txtComDown.setLayoutX(150);
        txtComDown.setStyle("-fx-pref-width:325px;"+
                "-fx-background-radius: 15px;");



        Label lblComLoan= new Label("Loan Term:");
        lblComLoan.setLayoutY(150);
        lblComLoan.setLayoutX(40);
        lblComLoan.setStyle("-fx-text-fill: white;"+
                "-fx-font-size:16px;");

        TextField txtComLoan = new TextField("");
        txtComLoan.setLayoutY(150);
        txtComLoan.setLayoutX(150);
        txtComLoan.setStyle("-fx-pref-width:325px;"+
                "-fx-background-radius: 15px;");


        Label lblRateOut = new Label("Output:");
        lblRateOut.setLayoutX(40);
        lblRateOut.setLayoutY(250);
        lblRateOut.setStyle("-fx-text-fill: white;"+
                "-fx-font-size:22px;"+
                "-fx-font-family:'Agency FB';");

        Label lblRateOutCom = new Label("         ");
        lblRateOutCom.setLayoutY(250);
        lblRateOutCom.setLayoutX(150);
        lblRateOutCom.setStyle("-fx-text-fill: white;"+
                "-fx-font-size:22px;");


        Button btnBackCom = new Button("Back");
        btnBackCom.setLayoutY(300);
        btnBackCom.setLayoutX(40);
        btnBackCom.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 100px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;"+
                "-fx-pref-width: 150px;");
        btnBackCom.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage savingsStage = (Stage)btnBackCom.getScene().getWindow();
                windowCompound.close();
                navigation.navigationStage();

            }
        });


        Button btnResetCom = new Button("Reset");
        btnResetCom.setLayoutY(200);
        btnResetCom.setLayoutX(150);
        btnResetCom.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 100px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;"+
                "-fx-pref-width:150px;");
        btnResetCom.setOnAction(event -> {
            txtComRate.clear();
            txtComDown.clear();
            txtComLoan.clear();
            lblRateOutCom.setText("");
        });

        Button btnCalculateCom = new Button("Calculate");
        btnCalculateCom.setLayoutX(325);
        btnCalculateCom.setLayoutY(200);
        btnCalculateCom.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 100px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;"+
                "-fx-pref-width: 150px;");
        btnCalculateCom.setOnAction(e ->
        {
            try {
                double monthNo =12;
                double cDown = Double.parseDouble(txtComDown.getText());
                double cRate = Double.parseDouble(txtComRate.getText())/100;
                double cTerm = Double.parseDouble(txtComLoan.getText());


                double out = cDown * (Math.pow((1 + cRate / monthNo), monthNo * cTerm));
                double outPut = out - cDown;
                lblRateOutCom.setText(String.format("%.2f",outPut));
            }
            catch (Exception text)
            {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("Integer Value Needed");
                alert.show();
            }

        });


        //Setting Up On Screen Key board

        Button btnSevenL = new Button("7");
        btnSevenL.setLayoutY(100);
        btnSevenL.setLayoutX(500);
        btnSevenL.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;");
        btnSevenL.setOnAction(event -> {
            txtComDown.setText((txtComDown.getText().concat("7")));

        });

        Button btnEightL = new Button("8");
        btnEightL.setLayoutX(550);
        btnEightL.setLayoutY(100);
        btnEightL.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;");
        btnEightL.setOnAction(event -> {
            txtComDown.setText((txtComDown.getText().concat("8")));

        });



        Button btnNineL = new Button("9");
        btnNineL.setLayoutY(100);
        btnNineL.setLayoutX(600);
        btnNineL.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;");
        btnNineL.setOnAction(event -> {
            txtComDown.setText((txtComDown.getText().concat("9")));

        });



        Button btnFourL = new Button("4");
        btnFourL.setLayoutY(150);
        btnFourL.setLayoutX(500);
        btnFourL.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;");
        btnFourL.setOnAction(event -> {
            txtComDown.setText((txtComDown.getText().concat("4")));

        });


        Button btnFiveL = new Button("5");
        btnFiveL.setLayoutX(550);
        btnFiveL.setLayoutY(150);
        btnFiveL.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;");
        btnFiveL.setOnAction(event -> {
            txtComDown.setText((txtComDown.getText().concat("5")));

        });

        Button btnSixL = new Button("6");
        btnSixL.setLayoutY(150);
        btnSixL.setLayoutX(600);
        btnSixL.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;");
        btnSixL.setOnAction(event -> {
            txtComDown.setText((txtComDown.getText().concat("6")));

        });




        Button btnOneL = new Button("1");
        btnOneL.setLayoutY(200);
        btnOneL.setLayoutX(500);
        btnOneL.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;");
        btnOneL.setOnAction(event -> {
            txtComDown.setText((txtComDown.getText().concat("1")));

        });


        Button btnTwoL = new Button("2");
        btnTwoL.setLayoutX(550);
        btnTwoL.setLayoutY(200);
        btnTwoL.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;");
        btnTwoL.setOnAction(event -> {
            txtComDown.setText((txtComDown.getText().concat("2")));

        });

        Button btnThreeL = new Button("3");
        btnThreeL.setLayoutY(200);
        btnThreeL.setLayoutX(600);
        btnThreeL.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;");
        btnThreeL.setOnAction(event -> {
            txtComDown.setText((txtComDown.getText().concat("3")));

        });


        Button btnZeroL = new Button("0");
        btnZeroL.setLayoutX(500);
        btnZeroL.setLayoutY(250);
        btnZeroL.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;"+
                "-fx-pref-width:75px;");
        btnZeroL.setOnAction(event -> {
            txtComDown.setText((txtComDown.getText().concat("0")));

        });

        Button btnDecimalL = new Button(".");
        btnDecimalL.setLayoutY(250);
        btnDecimalL.setLayoutX(600);
        btnDecimalL.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;");
        btnDecimalL.setOnAction(event -> {
            txtComDown.setText((txtComDown.getText().concat(".")));

        });


        Button btnPositiveL = new Button("+");
        btnPositiveL.setLayoutX(650);
        btnPositiveL.setLayoutY(100);
        btnPositiveL.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;"+
                "-fx-pref-height: 85px;");
        btnPositiveL.setOnAction(event -> {
            txtComDown.setText((txtComDown.getText().concat("+")));

        });


        Button btnNegativeL = new Button("-");
        btnNegativeL.setLayoutY(200);
        btnNegativeL.setLayoutX(650);
        btnNegativeL.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;"+
                "-fx-pref-height: 85px;");
        btnNegativeL.setOnAction(event -> {
            txtComDown.setText((txtComDown.getText().concat("-")));

        });


//Event Handling For the On Screen Key Board
        //for Loan Amount
        txtComDown.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                btnSevenL.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtComDown.setText(txtComDown.getText()+"7");
                    }
                });

                btnEightL.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtComDown.setText(txtComDown.getText()+"8");
                    }
                });

                btnNineL.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtComDown.setText(txtComDown.getText()+"9");
                    }
                });

                btnSixL.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtComDown.setText(txtComDown.getText()+"6");
                    }
                });

                btnFiveL.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtComDown.setText(txtComDown.getText()+"5");
                    }
                });

                btnFourL.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtComDown.setText(txtComDown.getText()+"4");
                    }
                });

                btnThreeL.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtComDown.setText(txtComDown.getText()+"3");
                    }
                });

                btnTwoL.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtComDown.setText(txtComDown.getText()+"2");
                    }
                });

                btnOneL.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtComDown.setText(txtComDown.getText()+"1");
                    }
                });

                btnZeroL.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtComDown.setText(txtComDown.getText()+"0");
                    }
                });

                btnNegativeL.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtComDown.setText(txtComDown.getText()+"-");
                    }
                });

                btnPositiveL.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtComDown.setText(txtComDown.getText()+"+");
                    }
                });

                btnDecimalL.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtComDown.setText(txtComDown.getText()+".");
                    }
                });
            }
        });

//45454

        txtComLoan.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                btnSevenL.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtComLoan.setText(txtComLoan.getText()+"7");
                    }
                });

                btnEightL.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtComLoan.setText(txtComLoan.getText()+"8");
                    }
                });

                btnNineL.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtComLoan.setText(txtComLoan.getText()+"9");
                    }
                });

                btnSixL.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtComLoan.setText(txtComLoan.getText()+"6");
                    }
                });

                btnFiveL.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtComLoan.setText(txtComLoan.getText()+"5");
                    }
                });

                btnFourL.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtComLoan.setText(txtComLoan.getText()+"4");
                    }
                });

                btnThreeL.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtComLoan.setText(txtComLoan.getText()+"3");
                    }
                });

                btnTwoL.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtComLoan.setText(txtComLoan.getText()+"2");
                    }
                });

                btnOneL.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtComLoan.setText(txtComLoan.getText()+"1");
                    }
                });

                btnZeroL.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtComLoan.setText(txtComLoan.getText()+"0");
                    }
                });

                btnNegativeL.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtComLoan.setText(txtComLoan.getText()+"-");
                    }
                });

                btnPositiveL.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtComLoan.setText(txtComLoan.getText()+"+");
                    }
                });

                btnDecimalL.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtComLoan.setText(txtComLoan.getText()+".");
                    }
                });
            }
        });




        txtComRate.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                btnSevenL.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtComRate.setText(txtComRate.getText()+"7");
                    }
                });

                btnEightL.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtComRate.setText(txtComRate.getText()+"8");
                    }
                });

                btnNineL.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtComRate.setText(txtComRate.getText()+"9");
                    }
                });

                btnSixL.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtComRate.setText(txtComRate.getText()+"6");
                    }
                });

                btnFiveL.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtComRate.setText(txtComRate.getText()+"5");
                    }
                });

                btnFourL.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtComRate.setText(txtComRate.getText()+"4");
                    }
                });

                btnThreeL.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtComRate.setText(txtComRate.getText()+"3");
                    }
                });

                btnTwoL.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtComRate.setText(txtComRate.getText()+"2");
                    }
                });

                btnOneL.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtComRate.setText(txtComRate.getText()+"1");
                    }
                });

                btnZeroL.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtComRate.setText(txtComRate.getText()+"0");
                    }
                });

                btnNegativeL.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtComRate.setText(txtComRate.getText()+"-");
                    }
                });

                btnPositiveL.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtComRate.setText(txtComRate.getText()+"+");
                    }
                });

                btnDecimalL.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtComRate.setText(txtComRate.getText()+".");
                    }
                });
            }
        });




        Pane layoutCompound = new Pane();
        layoutCompound.setId("loanStyle");
        layoutCompound.getChildren().addAll(lblComRate,lblRateOut,lblRateOutCom,txtComRate,lblComDown,txtComDown,lblComLoan,txtComLoan,btnBackCom,btnResetCom,btnCalculateCom,
                btnNineL,btnEightL,btnSevenL,btnSixL,btnFiveL,btnFourL,btnThreeL,btnTwoL,btnOneL,btnZeroL,btnPositiveL,btnNegativeL,btnDecimalL);
        layoutCompound.getStylesheets().addAll("style.css");
        windowCompound.setScene(new Scene(layoutCompound,750,400));
        windowCompound.show();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

    }
}
