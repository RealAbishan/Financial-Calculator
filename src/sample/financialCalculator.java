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

import static java.lang.Math.log;
import static java.lang.Math.pow;

public class financialCalculator extends Application
{
    public static void main(String[] args)
    {

        launch(args);
    }


    public static void savingsStage()
    {

        Stage windowSavings = new Stage();

        windowSavings.setTitle("Navigation");


//Future Value
        Label lblFutureTitle = new Label("Future Value Calculation");
        lblFutureTitle.setLayoutX(80);
        lblFutureTitle.setLayoutY(30);
        lblFutureTitle.setStyle("-fx-text-fill: white;"+
                "-fx-font-size:40px;"+
                "-fx-font-family: Papyrus");



        Button btnExitFuture = new Button("Exit");
        btnExitFuture.setLayoutX(550);
        btnExitFuture.setLayoutY(450);
        btnExitFuture.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 100px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;"+
                "-fx-pref-width: 150px;");
        btnExitFuture.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage loanStage = (Stage)btnExitFuture.getScene().getWindow();
                windowSavings.close();

            }
        });

        Label lblPeriods = new Label("N(# of periods)");
        lblPeriods.setLayoutX(50);
        lblPeriods.setLayoutY(100);
        lblPeriods.setStyle("-fx-text-fill: white;"+
                "-fx-font-size:16px;");

        Label lblInterestRate = new Label("Interest Rate");
        lblInterestRate.setLayoutX(50);
        lblInterestRate.setLayoutY(150);
        lblInterestRate.setStyle("-fx-text-fill: white;"+
                "-fx-font-size:16px;");

        Label lblPresentValue = new Label("Start Principal");
        lblPresentValue.setLayoutX(50);
        lblPresentValue.setLayoutY(200);
        lblPresentValue.setStyle("-fx-text-fill: white;"+
                "-fx-font-size:16px;");

        Label lblAnnuity = new Label("Annuity Payment");
        lblAnnuity.setLayoutX(50);
        lblAnnuity.setLayoutY(250);
        lblAnnuity.setStyle("-fx-text-fill: white;"+
                "-fx-font-size:16px;");

        Label lblFutureTxt = new Label("Future Value:");
        lblFutureTxt.setLayoutY(400);
        lblFutureTxt.setLayoutX(50);
        lblFutureTxt.setStyle("-fx-text-fill: white;"+
                "-fx-font-size:22px;"+
                "-fx-font-family:'Agency FB';");

        Label lblOutFutureValue = new Label("         ");
        lblOutFutureValue.setLayoutY(400);
        lblOutFutureValue.setLayoutX(200);
        lblOutFutureValue.setStyle("-fx-text-fill: white;"+
                "-fx-font-size:22px;");

        //text Fields

        TextField txtPeriods = new TextField(" ");
        txtPeriods.setLayoutY(100);
        txtPeriods.setLayoutX(200);
        txtPeriods.setStyle("-fx-pref-width:325px;"+
                "-fx-background-radius: 15px;");

        TextField txtInterestRate = new TextField("");
        txtInterestRate.setLayoutX(200);
        txtInterestRate.setLayoutY(150);
        txtInterestRate.setPromptText("%");
        txtInterestRate.setStyle("-fx-pref-width:325px;"+
                "-fx-background-radius: 15px;");


        TextField txtPresentValue= new TextField("");
        txtPresentValue.setPromptText("$");
        txtPresentValue.setLayoutX(200);
        txtPresentValue.setLayoutY(200);
        txtPresentValue.setStyle("-fx-pref-width:325px;"+
                "-fx-background-radius: 15px;");


        TextField txtAnnuity = new TextField("");
        txtAnnuity.setPromptText("$");
        txtAnnuity.setLayoutX(200);
        txtAnnuity.setLayoutY(250);
        txtAnnuity.setStyle("-fx-pref-width:325px;"+
                "-fx-background-radius: 15px;");


        //Buttons

        Button btnCalculate = new Button("Calculate");
        btnCalculate.setLayoutY(350);
        btnCalculate.setLayoutX(375);
        btnCalculate.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 100px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;"+
                "-fx-pref-width: 150px;");
        btnCalculate.setOnAction(e ->{
            try {
                double noOfMonth = 12;
                double numPeriods = Double.parseDouble(txtPeriods.getText());
                double interestRate = Double.parseDouble(txtInterestRate.getText());
                double presentValue = Double.parseDouble(txtPresentValue.getText());
                double annuity = Double.parseDouble(txtAnnuity.getText());

                double futureValue;
                futureValue= ( annuity * ((pow((1+(interestRate/noOfMonth)),(noOfMonth*numPeriods))-1)/(interestRate/noOfMonth))) + ( presentValue * ( pow(( 1 + ( interestRate / noOfMonth ) ), ( noOfMonth * numPeriods )) ) );

                lblOutFutureValue.setText(String.format("%.2f",futureValue));

            }
            catch (Exception text)
            {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("Integer Value Needed");
                alert.show();
            }

        });


        Button btnReset = new Button("Reset");
        btnReset.setLayoutX(200);
        btnReset.setLayoutY(350);
        btnReset.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 100px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;"+
                "-fx-pref-width: 150px;");
        btnReset.setOnAction(event -> {
            txtPeriods.clear();
            txtInterestRate.clear();
            txtPresentValue.clear();
            txtAnnuity.clear();

        });


        Button btnBackFuture = new Button("Back");
        btnBackFuture.setLayoutX(50);
        btnBackFuture.setLayoutY(450);
        btnBackFuture.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 100px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;"+
                "-fx-pref-width: 150px;");
        btnBackFuture.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage savingsStage = (Stage)btnBackFuture.getScene().getWindow();
                windowSavings.close();
                navigation.navigationStage();


            }
        });



        // On Screen Key Board Input for Future value

        Button btnSevenM = new Button("7");
        btnSevenM.setLayoutY(150);
        btnSevenM.setLayoutX(550);
        btnSevenM.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;");
        btnSevenM.setOnAction(event -> {
            txtPeriods.setText((txtPeriods.getText().concat("7")));

        });




        Button btnEightM = new Button("8");
        btnEightM.setLayoutX(600);
        btnEightM.setLayoutY(150);
        btnEightM.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;");
        btnEightM.setOnAction(event -> {
            txtPeriods.setText((txtPeriods.getText().concat("8")));

        });



        Button btnNineM = new Button("9");
        btnNineM.setLayoutY(150);
        btnNineM.setLayoutX(650);
        btnNineM.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;");
        btnNineM.setOnAction(event -> {
            txtPeriods.setText((txtPeriods.getText().concat("9")));

        });



        Button btnFourM = new Button("4");
        btnFourM.setLayoutY(200);
        btnFourM.setLayoutX(550);
        btnFourM.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;");
        btnFourM.setOnAction(event -> {
            txtPeriods.setText((txtPeriods.getText().concat("4")));

        });


        Button btnFiveM = new Button("5");
        btnFiveM.setLayoutX(600);
        btnFiveM.setLayoutY(200);
        btnFiveM.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;");
        btnFiveM.setOnAction(event -> {
            txtPeriods.setText((txtPeriods.getText().concat("5")));

        });

        Button btnSixM = new Button("6");
        btnSixM.setLayoutY(200);
        btnSixM.setLayoutX(650);
        btnSixM.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;");
        btnSixM.setOnAction(event -> {
            txtPeriods.setText((txtPeriods.getText().concat("6")));

        });




        Button btnOneM = new Button("1");
        btnOneM.setLayoutY(250);
        btnOneM.setLayoutX(550);
        btnOneM.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;");
        btnOneM.setOnAction(event -> {
            txtPeriods.setText((txtPeriods.getText().concat("1")));

        });


        Button btnTwoM = new Button("2");
        btnTwoM.setLayoutX(600);
        btnTwoM.setLayoutY(250);
        btnTwoM.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;");
        btnTwoM.setOnAction(event -> {
            txtPeriods.setText((txtPeriods.getText().concat("2")));

        });

        Button btnThreeM = new Button("3");
        btnThreeM.setLayoutY(250);
        btnThreeM.setLayoutX(650);
        btnThreeM.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;");
        btnThreeM.setOnAction(event -> {
            txtPeriods.setText((txtPeriods.getText().concat("3")));

        });


        Button btnZeroM = new Button("0");
        btnZeroM.setLayoutX(550);
        btnZeroM.setLayoutY(300);
        btnZeroM.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;"+
                "-fx-pref-width:75px;");
        btnZeroM.setOnAction(event -> {
            txtPeriods.setText((txtPeriods.getText().concat("0")));

        });

        Button btnDecimalM = new Button(".");
        btnDecimalM.setLayoutY(300);
        btnDecimalM.setLayoutX(650);
        btnDecimalM.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;");
        btnDecimalM.setOnAction(event -> {
            txtPeriods.setText((txtPeriods.getText().concat(".")));

        });


        Button btnPositiveM = new Button("+");
        btnPositiveM.setLayoutX(700);
        btnPositiveM.setLayoutY(150);
        btnPositiveM.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;"+
                "-fx-pref-height: 85px;");
        btnPositiveM.setOnAction(event -> {
            txtPeriods.setText((txtPeriods.getText().concat("+")));

        });


        Button btnNegativeM = new Button("-");
        btnNegativeM.setLayoutY(250);
        btnNegativeM.setLayoutX(700);
        btnNegativeM.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;"+
                "-fx-pref-height: 85px;");
        btnNegativeM.setOnAction(event -> {
            txtPeriods.setText((txtPeriods.getText().concat("-")));

        });


//Setting
        txtPeriods.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                btnSevenM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPeriods.setText(txtPeriods.getText()+"7");
                    }
                });

                btnEightM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPeriods.setText(txtPeriods.getText()+"8");
                    }
                });

                btnNineM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPeriods.setText(txtPeriods.getText()+"9");
                    }
                });

                btnSixM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPeriods.setText(txtPeriods.getText()+"6");
                    }
                });

                btnFiveM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPeriods.setText(txtPeriods.getText()+"5");
                    }
                });

                btnFourM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPeriods.setText(txtPeriods.getText()+"4");
                    }
                });

                btnThreeM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPeriods.setText(txtPeriods.getText()+"3");
                    }
                });

                btnTwoM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPeriods.setText(txtPeriods.getText()+"2");
                    }
                });

                btnOneM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPeriods.setText(txtPeriods.getText()+"1");
                    }
                });

                btnZeroM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPeriods.setText(txtPeriods.getText()+"0");
                    }
                });

                btnNegativeM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPeriods.setText(txtPeriods.getText()+"-");
                    }
                });

                btnPositiveM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPeriods.setText(txtPeriods.getText()+"+");
                    }
                });

                btnDecimalM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPeriods.setText(txtPeriods.getText()+".");
                    }
                });
            }
        });


        txtInterestRate.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                btnSevenM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtInterestRate.setText(txtInterestRate.getText()+"7");
                    }
                });

                btnEightM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtInterestRate.setText(txtInterestRate.getText()+"8");
                    }
                });

                btnNineM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtInterestRate.setText(txtInterestRate.getText()+"9");
                    }
                });

                btnSixM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtInterestRate.setText(txtInterestRate.getText()+"6");
                    }
                });

                btnFiveM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtInterestRate.setText(txtInterestRate.getText()+"5");
                    }
                });

                btnFourM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtInterestRate.setText(txtInterestRate.getText()+"4");
                    }
                });

                btnThreeM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtInterestRate.setText(txtInterestRate.getText()+"3");
                    }
                });

                btnTwoM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtInterestRate.setText(txtInterestRate.getText()+"2");
                    }
                });

                btnOneM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtInterestRate.setText(txtInterestRate.getText()+"1");
                    }
                });

                btnZeroM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtInterestRate.setText(txtInterestRate.getText()+"0");
                    }
                });

                btnNegativeM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtInterestRate.setText(txtInterestRate.getText()+"-");
                    }
                });

                btnPositiveM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtInterestRate.setText(txtInterestRate.getText()+"+");
                    }
                });

                btnDecimalM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtInterestRate.setText(txtInterestRate.getText()+".");
                    }
                });
            }
        });


        txtPresentValue.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                btnSevenM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPresentValue.setText(txtPresentValue.getText()+"7");
                    }
                });

                btnEightM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPresentValue.setText(txtPresentValue.getText()+"8");
                    }
                });

                btnNineM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPresentValue.setText(txtPresentValue.getText()+"9");
                    }
                });

                btnSixM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPresentValue.setText(txtPresentValue.getText()+"6");
                    }
                });

                btnFiveM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPresentValue.setText(txtPresentValue.getText()+"5");
                    }
                });

                btnFourM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPresentValue.setText(txtPresentValue.getText()+"4");
                    }
                });

                btnThreeM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPresentValue.setText(txtPresentValue.getText()+"3");
                    }
                });

                btnTwoM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPresentValue.setText(txtPresentValue.getText()+"2");
                    }
                });

                btnOneM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPresentValue.setText(txtPresentValue.getText()+"1");
                    }
                });

                btnZeroM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPresentValue.setText(txtPresentValue.getText()+"0");
                    }
                });

                btnNegativeM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPresentValue.setText(txtPresentValue.getText()+"-");
                    }
                });

                btnPositiveM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPresentValue.setText(txtPresentValue.getText()+"+");
                    }
                });

                btnDecimalM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPresentValue.setText(txtPresentValue.getText()+".");
                    }
                });
            }
        });


        txtAnnuity.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                btnSevenM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtAnnuity.setText(txtAnnuity.getText()+"7");
                    }
                });

                btnEightM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtAnnuity.setText(txtAnnuity.getText()+"8");
                    }
                });

                btnNineM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtAnnuity.setText(txtAnnuity.getText()+"9");
                    }
                });

                btnSixM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtAnnuity.setText(txtAnnuity.getText()+"6");
                    }
                });

                btnFiveM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtAnnuity.setText(txtAnnuity.getText()+"5");
                    }
                });

                btnFourM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtAnnuity.setText(txtAnnuity.getText()+"4");
                    }
                });

                btnThreeM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtAnnuity.setText(txtAnnuity.getText()+"3");
                    }
                });

                btnTwoM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtAnnuity.setText(txtAnnuity.getText()+"2");
                    }
                });

                btnOneM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtAnnuity.setText(txtAnnuity.getText()+"1");
                    }
                });

                btnZeroM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtAnnuity.setText(txtAnnuity.getText()+"0");
                    }
                });

                btnNegativeM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtAnnuity.setText(txtAnnuity.getText()+"-");
                    }
                });

                btnPositiveM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtAnnuity.setText(txtAnnuity.getText()+"+");
                    }
                });

                btnDecimalM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtAnnuity.setText(txtAnnuity.getText()+".");
                    }
                });
            }
        });







//Payment Calculation
        Label lblPayTitle = new Label("Annuity Payment Calculation");
        lblPayTitle.setLayoutX(80);
        lblPayTitle.setLayoutY(30);
        lblPayTitle.setStyle("-fx-text-fill: white;"+
                "-fx-font-size:40px;"+
                "-fx-font-family: Papyrus");



        Button btnExitPay = new Button("Exit");
        btnExitPay.setLayoutX(550);
        btnExitPay.setLayoutY(450);
        btnExitPay.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 100px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;"+
                "-fx-pref-width: 150px;");
        btnExitPay.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage loanStage = (Stage)btnExitPay.getScene().getWindow();
                windowSavings.close();


            }
        });

        Label lblPeriodsPay = new Label("N(# of periods)");
        lblPeriodsPay.setLayoutX(50);
        lblPeriodsPay.setLayoutY(100);
        lblPeriodsPay.setStyle("-fx-text-fill: white;"+
                "-fx-font-size:16px;");

        Label lblPresentValuePay = new Label("Start Principal");
        lblPresentValuePay.setLayoutX(50);
        lblPresentValuePay.setLayoutY(150);
        lblPresentValuePay.setStyle("-fx-text-fill: white;"+
                "-fx-font-size:16px;");

        Label lblFuturePay = new Label("Future Value");
        lblFuturePay.setLayoutX(50);
        lblFuturePay.setLayoutY(200);
        lblFuturePay.setStyle("-fx-text-fill: white;"+
                "-fx-font-size:16px;");

        Label lblInterestRatePay = new Label("Interest Rate");
        lblInterestRatePay.setLayoutX(50);
        lblInterestRatePay.setLayoutY(250);
        lblInterestRatePay.setStyle("-fx-text-fill: white;"+
                "-fx-font-size:16px;");



        Label lblPayTxt = new Label("Annuity Payment:");
        lblPayTxt.setLayoutY(400);
        lblPayTxt.setLayoutX(50);
        lblPayTxt.setStyle("-fx-text-fill: white;"+
                "-fx-font-size:22px;"+
                "-fx-font-family:'Agency FB';");

        Label lblOutPay = new Label("         ");
        lblOutPay.setLayoutY(400);
        lblOutPay.setLayoutX(200);
        lblPayTxt.setStyle("-fx-text-fill: white;"+
                "-fx-font-size:22px;");


        //text Fields

        TextField txtPeriodsPay = new TextField("");
        txtPeriodsPay.setLayoutY(100);
        txtPeriodsPay.setLayoutX(200);
        txtPeriodsPay.setStyle("-fx-pref-width:325px;"+
                "-fx-background-radius: 15px;");

        TextField txtPresentValuePay = new TextField("");
        txtPresentValuePay.setPromptText("$");
        txtPresentValuePay.setLayoutX(200);
        txtPresentValuePay.setLayoutY(150);
        txtPresentValuePay.setStyle("-fx-pref-width:325px;"+
                "-fx-background-radius: 15px;");

        TextField txtFuturePay = new TextField("");
        txtFuturePay.setPromptText("$");
        txtFuturePay.setLayoutX(200);
        txtFuturePay.setLayoutY(200);
        txtFuturePay.setStyle("-fx-pref-width:325px;"+
                "-fx-background-radius: 15px;");

        TextField txtInterestRatePay = new TextField("");
        txtInterestRatePay.setPromptText("%");
        txtInterestRatePay.setLayoutX(200);
        txtInterestRatePay.setLayoutY(250);
        txtInterestRatePay.setStyle("-fx-pref-width:325px;"+
                "-fx-background-radius: 15px;");

        //Buttons


        Button btnCalculatePay = new Button("Calculate");
        btnCalculatePay.setLayoutY(350);
        btnCalculatePay.setLayoutX(375);
        btnCalculatePay.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 100px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;"+
                "-fx-pref-width: 150px;");
        btnCalculatePay.setOnAction(e -> {
            try {
                double noOf = 12;
                double periodsPay = Double.parseDouble(txtPeriodsPay.getText());
                double futurePay = Double.parseDouble(txtFuturePay.getText());
                double presentPay = Double.parseDouble(txtPresentValuePay.getText());
                double interestPay = Double.parseDouble(txtInterestRatePay.getText());

                double outPutPay = (futurePay-(presentPay*pow((1+(interestPay/noOf)),(noOf*periodsPay))))/((pow((1+(interestPay/noOf)),(noOf*periodsPay))-1)/(interestPay/noOf));

                lblOutPay.setText(String.valueOf(outPutPay));

            }
            catch (Exception text)
            {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("Integer Value Needed");
                alert.show();
            }

        });


        Button btnResetPay = new Button("Reset");
        btnResetPay.setLayoutX(200);
        btnResetPay.setLayoutY(350);
        btnResetPay.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 100px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;"+
                "-fx-pref-width: 150px;");
        btnResetPay.setOnAction(event -> {
            txtPeriodsPay.clear();
            txtInterestRatePay.clear();
            txtPresentValuePay.clear();
            txtFuturePay.clear();

        });


        Button btnBackPay = new Button("Back");
        btnBackPay.setLayoutX(50);
        btnBackPay.setLayoutY(450);
        btnBackPay.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 100px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;"+
                "-fx-pref-width: 150px;");
        btnBackPay.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage savingsStage = (Stage)btnBackPay.getScene().getWindow();
                windowSavings.close();
                navigation.navigationStage();


            }
        });



        // On Screen Key Board Input for Annuity Payment

        Button btnSeven = new Button("7");
        btnSeven.setLayoutY(150);
        btnSeven.setLayoutX(550);
        btnSeven.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;");
        btnSeven.setOnAction(event -> {
            txtPeriodsPay.setText((txtPeriodsPay.getText().concat("7")));

        });




        Button btnEight = new Button("8");
        btnEight.setLayoutX(600);
        btnEight.setLayoutY(150);
        btnEight.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;");
        btnEight.setOnAction(event -> {
            txtPeriodsPay.setText((txtPeriodsPay.getText().concat("8")));

        });



        Button btnNine = new Button("9");
        btnNine.setLayoutY(150);
        btnNine.setLayoutX(650);
        btnNine.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;");
        btnNine.setOnAction(event -> {
            txtPeriodsPay.setText((txtPeriodsPay.getText().concat("9")));

        });



        Button btnFour = new Button("4");
        btnFour.setLayoutY(200);
        btnFour.setLayoutX(550);
        btnFour.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;");
        btnFour.setOnAction(event -> {
            txtPeriodsPay.setText((txtPeriodsPay.getText().concat("4")));

        });


        Button btnFive = new Button("5");
        btnFive.setLayoutX(600);
        btnFive.setLayoutY(200);
        btnFive.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;");
        btnFive.setOnAction(event -> {
            txtPeriodsPay.setText((txtPeriodsPay.getText().concat("5")));

        });

        Button btnSix = new Button("6");
        btnSix.setLayoutY(200);
        btnSix.setLayoutX(650);
        btnSix.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;");
        btnSix.setOnAction(event -> {
            txtPeriodsPay.setText((txtPeriodsPay.getText().concat("6")));

        });




        Button btnOne = new Button("1");
        btnOne.setLayoutY(250);
        btnOne.setLayoutX(550);
        btnOne.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;");
        btnOne.setOnAction(event -> {
            txtPeriodsPay.setText((txtPeriodsPay.getText().concat("1")));

        });


        Button btnTwo = new Button("2");
        btnTwo.setLayoutX(600);
        btnTwo.setLayoutY(250);
        btnTwo.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;");
        btnTwo.setOnAction(event -> {
            txtPeriodsPay.setText((txtPeriodsPay.getText().concat("2")));

        });

        Button btnThree = new Button("3");
        btnThree.setLayoutY(250);
        btnThree.setLayoutX(650);
        btnThree.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;");
        btnThree.setOnAction(event -> {
            txtPeriodsPay.setText((txtPeriodsPay.getText().concat("3")));

        });


        Button btnZero = new Button("0");
        btnZero.setLayoutX(550);
        btnZero.setLayoutY(300);
        btnZero.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;"+
                "-fx-pref-width:75px;");
        btnZero.setOnAction(event -> {
            txtPeriodsPay.setText((txtPeriodsPay.getText().concat("0")));

        });

        Button btnDecimal = new Button(".");
        btnDecimal.setLayoutY(300);
        btnDecimal.setLayoutX(650);
        btnDecimal.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;");
        btnDecimal.setOnAction(event -> {
            txtPeriodsPay.setText((txtPeriodsPay.getText().concat(".")));

        });


        Button btnPositive = new Button("+");
        btnPositive.setLayoutX(700);
        btnPositive.setLayoutY(150);
        btnPositive.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;"+
                "-fx-pref-height: 85px;");
        btnPositive.setOnAction(event -> {
            txtPeriodsPay.setText((txtPeriodsPay.getText().concat("+")));

        });


        Button btnNegative = new Button("-");
        btnNegative.setLayoutY(250);
        btnNegative.setLayoutX(700);
        btnNegative.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;"+
                "-fx-pref-height: 85px;");
        btnNegative.setOnAction(event -> {
            txtPeriodsPay.setText((txtPeriodsPay.getText().concat("-")));

        });


//Setting
        txtPeriodsPay.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                btnSeven.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPeriodsPay.setText(txtPeriodsPay.getText()+"7");
                    }
                });

                btnEight.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPeriodsPay.setText(txtPeriodsPay.getText()+"8");
                    }
                });

                btnNine.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPeriodsPay.setText(txtPeriodsPay.getText()+"9");
                    }
                });

                btnSix.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPeriodsPay.setText(txtPeriodsPay.getText()+"6");
                    }
                });

                btnFive.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPeriodsPay.setText(txtPeriodsPay.getText()+"5");
                    }
                });

                btnFour.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPeriodsPay.setText(txtPeriodsPay.getText()+"4");
                    }
                });

                btnThree.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPeriodsPay.setText(txtPeriodsPay.getText()+"3");
                    }
                });

                btnTwo.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPeriodsPay.setText(txtPeriodsPay.getText()+"2");
                    }
                });

                btnOne.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPeriodsPay.setText(txtPeriodsPay.getText()+"1");
                    }
                });

                btnZero.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPeriodsPay.setText(txtPeriodsPay.getText()+"0");
                    }
                });

                btnNegative.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPeriodsPay.setText(txtPeriodsPay.getText()+"-");
                    }
                });

                btnPositive.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPeriodsPay.setText(txtPeriodsPay.getText()+"+");
                    }
                });

                btnDecimal.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPeriodsPay.setText(txtPeriodsPay.getText()+".");
                    }
                });
            }
        });


        txtPresentValuePay.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                btnSeven.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPresentValuePay.setText(txtPresentValuePay.getText()+"7");
                    }
                });

                btnEight.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPresentValuePay.setText(txtPresentValuePay.getText()+"8");
                    }
                });

                btnNine.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPresentValuePay.setText(txtPresentValuePay.getText()+"9");
                    }
                });

                btnSix.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPresentValuePay.setText(txtPresentValuePay.getText()+"6");
                    }
                });

                btnFive.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPresentValuePay.setText(txtPresentValuePay.getText()+"5");
                    }
                });

                btnFour.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPresentValuePay.setText(txtPresentValuePay.getText()+"4");
                    }
                });

                btnThree.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPresentValuePay.setText(txtPresentValuePay.getText()+"3");
                    }
                });

                btnTwo.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPresentValuePay.setText(txtPresentValuePay.getText()+"2");
                    }
                });

                btnOne.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPresentValuePay.setText(txtPresentValuePay.getText()+"1");
                    }
                });

                btnZero.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPresentValuePay.setText(txtPresentValuePay.getText()+"0");
                    }
                });

                btnNegative.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPresentValuePay.setText(txtPresentValuePay.getText()+"-");
                    }
                });

                btnPositive.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPresentValuePay.setText(txtPresentValuePay.getText()+"+");
                    }
                });

                btnDecimal.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPresentValuePay.setText(txtPresentValuePay.getText()+".");
                    }
                });
            }
        });


        txtFuturePay.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                btnSeven.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtFuturePay.setText(txtFuturePay.getText()+"7");
                    }
                });

                btnEight.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtFuturePay.setText(txtFuturePay.getText()+"8");
                    }
                });

                btnNine.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtFuturePay.setText(txtFuturePay.getText()+"9");
                    }
                });

                btnSix.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtFuturePay.setText(txtFuturePay.getText()+"6");
                    }
                });

                btnFive.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtFuturePay.setText(txtFuturePay.getText()+"5");
                    }
                });

                btnFour.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtFuturePay.setText(txtFuturePay.getText()+"4");
                    }
                });

                btnThree.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtFuturePay.setText(txtFuturePay.getText()+"3");
                    }
                });

                btnTwo.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtFuturePay.setText(txtFuturePay.getText()+"2");
                    }
                });

                btnOne.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtFuturePay.setText(txtFuturePay.getText()+"1");
                    }
                });

                btnZero.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtFuturePay.setText(txtFuturePay.getText()+"0");
                    }
                });

                btnNegative.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtFuturePay.setText(txtFuturePay.getText()+"-");
                    }
                });

                btnPositive.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtFuturePay.setText(txtFuturePay.getText()+"+");
                    }
                });

                btnDecimal.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtFuturePay.setText(txtFuturePay.getText()+".");
                    }
                });
            }
        });


        txtInterestRatePay.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                btnSeven.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtInterestRatePay.setText(txtInterestRatePay.getText()+"7");
                    }
                });

                btnEight.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtInterestRatePay.setText(txtInterestRatePay.getText()+"8");
                    }
                });

                btnNine.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtInterestRatePay.setText(txtInterestRatePay.getText()+"9");
                    }
                });

                btnSix.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtInterestRatePay.setText(txtInterestRatePay.getText()+"6");
                    }
                });

                btnFive.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtInterestRatePay.setText(txtInterestRatePay.getText()+"5");
                    }
                });

                btnFour.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtInterestRatePay.setText(txtInterestRatePay.getText()+"4");
                    }
                });

                btnThree.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtInterestRatePay.setText(txtInterestRatePay.getText()+"3");
                    }
                });

                btnTwo.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtInterestRatePay.setText(txtInterestRatePay.getText()+"2");
                    }
                });

                btnOne.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtInterestRatePay.setText(txtInterestRatePay.getText()+"1");
                    }
                });

                btnZero.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtInterestRatePay.setText(txtInterestRatePay.getText()+"0");
                    }
                });

                btnNegative.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtInterestRatePay.setText(txtInterestRatePay.getText()+"-");
                    }
                });

                btnPositive.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtInterestRatePay.setText(txtInterestRatePay.getText()+"+");
                    }
                });

                btnDecimal.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtInterestRatePay.setText(txtInterestRatePay.getText()+".");
                    }
                });
            }
        });



   //IY

        Label lblRateTitle = new Label("Interest Calculation");
        lblRateTitle.setLayoutX(80);
        lblRateTitle.setLayoutY(30);
        lblRateTitle.setStyle("-fx-text-fill: white;"+
                "-fx-font-size:40px;"+
                "-fx-font-family: Papyrus");



        Button btnExitRate = new Button("Exit");
        btnExitRate.setLayoutX(550);
        btnExitRate.setLayoutY(450);
        btnExitRate.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 100px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;"+
                "-fx-pref-width: 150px;");
        btnExitRate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage loanStage = (Stage)btnExitRate.getScene().getWindow();
                windowSavings.close();


            }
        });

        Label lblPeriodsRate = new Label("N(# of periods)");
        lblPeriodsRate.setLayoutX(50);
        lblPeriodsRate.setLayoutY(100);
        lblPeriodsRate.setStyle("-fx-text-fill: white;"+
                "-fx-font-size:16px;");

        Label lblPresentValueRate = new Label("Start Principal");
        lblPresentValueRate.setLayoutX(50);
        lblPresentValueRate.setLayoutY(150);
        lblPresentValueRate.setStyle("-fx-text-fill: white;"+
                "-fx-font-size:16px;");

        Label lblAnnuityRate = new Label("Annuity Payment");
        lblAnnuityRate.setLayoutX(50);
        lblAnnuityRate.setLayoutY(200);
        lblAnnuityRate.setStyle("-fx-text-fill: white;"+
                "-fx-font-size:16px;");

        Label lblFutureRate = new Label("Future Value");
        lblFutureRate.setLayoutX(50);
        lblFutureRate.setLayoutY(250);
        lblFutureRate.setStyle("-fx-text-fill: white;"+
                "-fx-font-size:16px;");


        Label lblRateTxt = new Label("Interest Rate:");
        lblRateTxt.setLayoutY(400);
        lblRateTxt.setLayoutX(50);
        lblRateTxt.setStyle("-fx-text-fill: white;"+
                "-fx-font-size:22px;"+
                "-fx-font-family:'Agency FB';");

        Label lblOutRate = new Label("         ");
        lblOutRate.setLayoutY(400);
        lblOutRate.setLayoutX(200);
        lblOutRate.setStyle("-fx-text-fill: white;"+
                "-fx-font-size:22px;");


        //text Fields

        TextField txtPeriodsRate = new TextField("");
        txtPeriodsRate.setLayoutY(100);
        txtPeriodsRate.setLayoutX(200);
        txtPeriodsRate.setStyle("-fx-pref-width:325px;"+
                "-fx-background-radius: 15px;");


        TextField txtPresentValueRate = new TextField("");
        txtPresentValueRate.setPromptText("$");
        txtPresentValueRate.setLayoutX(200);
        txtPresentValueRate.setLayoutY(150);
        txtPresentValueRate.setStyle("-fx-pref-width:325px;"+
                "-fx-background-radius: 15px;");


        TextField txtAnnuityRate = new TextField("");
        txtAnnuityRate.setPromptText("$");
        txtAnnuityRate.setLayoutX(200);
        txtAnnuityRate.setLayoutY(200);
        txtAnnuityRate.setStyle("-fx-pref-width:325px;"+
                "-fx-background-radius: 15px;");


        TextField txtFutureRate = new TextField("");
        txtFutureRate.setPromptText("$");
        txtFutureRate.setLayoutX(200);
        txtFutureRate.setLayoutY(250);
        txtFutureRate.setStyle("-fx-pref-width:325px;"+
                "-fx-background-radius: 15px;");


        //Buttons


        Button btnCalculateRate = new Button("Calculate");
        btnCalculateRate.setLayoutY(350);
        btnCalculateRate.setLayoutX(375);
        btnCalculateRate.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 100px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;"+
                "-fx-pref-width: 150px;");
        btnCalculateRate.setOnAction(e -> {
            try {
                double noOfRate = 12;
                double periodsRate = Double.parseDouble(txtPeriodsRate.getText());
                double futureRate = Double.parseDouble(txtFutureRate.getText());
                double presentRate = Double.parseDouble(txtPresentValueRate.getText());
                double annuityRate = Double.parseDouble(txtAnnuityRate.getText());

                double rate;
                rate= log((futureRate+(annuityRate*12/periodsRate))/(periodsRate+(presentRate*12/periodsRate)))/(log(1+(periodsRate/12))*12);

                lblOutRate.setText(String.format("%.2f",rate));

            }
            catch (Exception text)
            {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("Integer Value Needed");
                alert.show();
            }

        });


        Button btnResetRate = new Button("Reset");
        btnResetRate.setLayoutX(200);
        btnResetRate.setLayoutY(350);
        btnResetRate.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 100px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;"+
                "-fx-pref-width: 150px;");
        btnResetRate.setOnAction(event -> {
            txtPeriodsRate.clear();
            txtFutureRate.clear();
            txtPresentValueRate.clear();
            txtAnnuityRate.clear();

        });


        Button btnBackRate = new Button("Back");
        btnBackRate.setLayoutX(50);
        btnBackRate.setLayoutY(450);
        btnBackRate.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 100px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;"+
                "-fx-pref-width: 150px;");
        btnBackRate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage savingsStage = (Stage)btnBackRate.getScene().getWindow();
                windowSavings.close();
                navigation.navigationStage();


            }
        });


        // On Screen Key Board Input for Interest Rate

        Button btnSevenI = new Button("7");
        btnSevenI.setLayoutY(150);
        btnSevenI.setLayoutX(550);
        btnSevenI.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;");
        btnSevenI.setOnAction(event -> {
            txtPeriodsRate.setText((txtPeriodsRate.getText().concat("7")));

        });




        Button btnEightI = new Button("8");
        btnEightI.setLayoutX(600);
        btnEightI.setLayoutY(150);
        btnEightI.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;");
        btnEightI.setOnAction(event -> {
            txtPeriodsRate.setText((txtPeriodsRate.getText().concat("8")));

        });



        Button btnNineI = new Button("9");
        btnNineI.setLayoutY(150);
        btnNineI.setLayoutX(650);
        btnNineI.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;");
        btnNineI.setOnAction(event -> {
            txtPeriodsRate.setText((txtPeriodsRate.getText().concat("9")));

        });



        Button btnFourI = new Button("4");
        btnFourI.setLayoutY(200);
        btnFourI.setLayoutX(550);
        btnFourI.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;");
        btnFourI.setOnAction(event -> {
            txtPeriodsRate.setText((txtPeriodsRate.getText().concat("4")));

        });


        Button btnFiveI = new Button("5");
        btnFiveI.setLayoutX(600);
        btnFiveI.setLayoutY(200);
        btnFiveI.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;");
        btnFiveI.setOnAction(event -> {
            txtPeriodsRate.setText((txtPeriodsRate.getText().concat("5")));

        });

        Button btnSixI = new Button("6");
        btnSixI.setLayoutY(200);
        btnSixI.setLayoutX(650);
        btnSixI.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;");
        btnSixI.setOnAction(event -> {
            txtPeriodsRate.setText((txtPeriodsRate.getText().concat("6")));

        });




        Button btnOneI = new Button("1");
        btnOneI.setLayoutY(250);
        btnOneI.setLayoutX(550);
        btnOneI.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;");
        btnOneI.setOnAction(event -> {
            txtPeriodsRate.setText((txtPeriodsRate.getText().concat("1")));

        });


        Button btnTwoI = new Button("2");
        btnTwoI.setLayoutX(600);
        btnTwoI.setLayoutY(250);
        btnTwoI.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;");
        btnTwoI.setOnAction(event -> {
            txtPeriodsRate.setText((txtPeriodsRate.getText().concat("2")));

        });

        Button btnThreeI = new Button("3");
        btnThreeI.setLayoutY(250);
        btnThreeI.setLayoutX(650);
        btnThreeI.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;");
        btnThreeI.setOnAction(event -> {
            txtPeriodsRate.setText((txtPeriodsRate.getText().concat("3")));

        });


        Button btnZeroI = new Button("0");
        btnZeroI.setLayoutX(550);
        btnZeroI.setLayoutY(300);
        btnZeroI.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;"+
                "-fx-pref-width:75px;");
        btnZeroI.setOnAction(event -> {
            txtPeriodsRate.setText((txtPeriodsRate.getText().concat("0")));

        });

        Button btnDecimalI = new Button(".");
        btnDecimalI.setLayoutY(300);
        btnDecimalI.setLayoutX(650);
        btnDecimalI.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;");
        btnDecimalI.setOnAction(event -> {
            txtPeriodsRate.setText((txtPeriodsRate.getText().concat(".")));

        });


        Button btnPositiveI = new Button("+");
        btnPositiveI.setLayoutX(700);
        btnPositiveI.setLayoutY(150);
        btnPositiveI.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;"+
                "-fx-pref-height: 85px;");
        btnPositiveI.setOnAction(event -> {
            txtPeriodsRate.setText((txtPeriodsRate.getText().concat("+")));

        });


        Button btnNegativeI = new Button("-");
        btnNegativeI.setLayoutY(250);
        btnNegativeI.setLayoutX(700);
        btnNegativeI.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;"+
                "-fx-pref-height: 85px;");
        btnNegativeI.setOnAction(event -> {
            txtPeriodsRate.setText((txtPeriodsRate.getText().concat("-")));

        });


//Setting
        txtPeriodsRate.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                btnSevenI.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPeriodsRate.setText(txtPeriodsRate.getText()+"7");
                    }
                });

                btnEightI.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPeriodsRate.setText(txtPeriodsRate.getText()+"8");
                    }
                });

                btnNineI.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPeriodsRate.setText(txtPeriodsRate.getText()+"9");
                    }
                });

                btnSixI.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPeriodsRate.setText(txtPeriodsRate.getText()+"6");
                    }
                });

                btnFiveI.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPeriodsRate.setText(txtPeriodsRate.getText()+"5");
                    }
                });

                btnFourI.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPeriodsRate.setText(txtPeriodsRate.getText()+"4");
                    }
                });

                btnThreeI.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPeriodsRate.setText(txtPeriodsRate.getText()+"3");
                    }
                });

                btnTwoI.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPeriodsRate.setText(txtPeriodsRate.getText()+"2");
                    }
                });

                btnOneI.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPeriodsRate.setText(txtPeriodsRate.getText()+"1");
                    }
                });

                btnZeroI.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPeriodsRate.setText(txtPeriodsRate.getText()+"0");
                    }
                });

                btnNegativeI.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPeriodsPay.setText(txtPeriodsPay.getText()+"-");
                    }
                });

                btnPositiveI.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPeriodsRate.setText(txtPeriodsRate.getText()+"+");
                    }
                });

                btnDecimalI.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPeriodsRate.setText(txtPeriodsRate.getText()+".");
                    }
                });
            }
        });


        txtPresentValueRate.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                btnSevenI.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPresentValueRate.setText(txtPresentValueRate.getText()+"7");
                    }
                });

                btnEightI.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPresentValueRate.setText(txtPresentValueRate.getText()+"8");
                    }
                });

                btnNineI.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPresentValueRate.setText(txtPresentValueRate.getText()+"9");
                    }
                });

                btnSixI.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPresentValuePay.setText(txtPresentValuePay.getText()+"6");
                    }
                });

                btnFiveI.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPresentValueRate.setText(txtPresentValueRate.getText()+"5");
                    }
                });

                btnFourI.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPresentValueRate.setText(txtPresentValueRate.getText()+"4");
                    }
                });

                btnThreeI.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPresentValueRate.setText(txtPresentValueRate.getText()+"3");
                    }
                });

                btnTwoI.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPresentValueRate.setText(txtPresentValueRate.getText()+"2");
                    }
                });

                btnOneI.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPresentValueRate.setText(txtPresentValueRate.getText()+"1");
                    }
                });

                btnZeroI.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPresentValueRate.setText(txtPresentValueRate.getText()+"0");
                    }
                });

                btnNegativeI.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPresentValueRate.setText(txtPresentValueRate.getText()+"-");
                    }
                });

                btnPositiveI.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPresentValueRate.setText(txtPresentValueRate.getText()+"+");
                    }
                });

                btnDecimalI.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPresentValueRate.setText(txtPresentValueRate.getText()+".");
                    }
                });
            }
        });


        txtAnnuityRate.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                btnSevenI.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtAnnuityRate.setText(txtAnnuityRate.getText()+"7");
                    }
                });

                btnEightI.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtAnnuityRate.setText(txtAnnuityRate.getText()+"8");
                    }
                });

                btnNineI.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtAnnuityRate.setText(txtAnnuityRate.getText()+"9");
                    }
                });

                btnSixI.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtAnnuityRate.setText(txtAnnuityRate.getText()+"6");
                    }
                });

                btnFiveI.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtAnnuityRate.setText(txtAnnuityRate.getText()+"5");
                    }
                });

                btnFourI.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtAnnuityRate.setText(txtAnnuityRate.getText()+"4");
                    }
                });

                btnThreeI.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtAnnuityRate.setText(txtAnnuityRate.getText()+"3");
                    }
                });

                btnTwoI.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtAnnuityRate.setText(txtAnnuityRate.getText()+"2");
                    }
                });

                btnOneI.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtAnnuityRate.setText(txtAnnuityRate.getText()+"1");
                    }
                });

                btnZeroI.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtAnnuityRate.setText(txtAnnuityRate.getText()+"0");
                    }
                });

                btnNegativeI.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtAnnuityRate.setText(txtAnnuityRate.getText()+"-");
                    }
                });

                btnPositiveI.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtAnnuityRate.setText(txtAnnuityRate.getText()+"+");
                    }
                });

                btnDecimal.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtAnnuityRate.setText(txtAnnuityRate.getText()+".");
                    }
                });
            }
        });


        txtFutureRate.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                btnSevenI.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtFutureRate.setText(txtFutureRate.getText()+"7");
                    }
                });

                btnEightI.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtFutureRate.setText(txtFutureRate.getText()+"8");
                    }
                });

                btnNineI.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtFutureRate.setText(txtFutureRate.getText()+"9");
                    }
                });

                btnSixI.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtFutureRate.setText(txtFutureRate.getText()+"6");
                    }
                });

                btnFiveI.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtFutureRate.setText(txtFutureRate.getText()+"5");
                    }
                });

                btnFourI.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtFutureRate.setText(txtFutureRate.getText()+"4");
                    }
                });

                btnThreeI.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtFutureRate.setText(txtFutureRate.getText()+"3");
                    }
                });

                btnTwoI.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtFutureRate.setText(txtFutureRate.getText()+"2");
                    }
                });

                btnOneI.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtInterestRatePay.setText(txtInterestRatePay.getText()+"1");
                    }
                });

                btnZeroI.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtFutureRate.setText(txtFutureRate.getText()+"0");
                    }
                });

                btnNegativeI.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtFutureRate.setText(txtFutureRate.getText()+"-");
                    }
                });

                btnPositiveI.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtFutureRate.setText(txtFutureRate.getText()+"+");
                    }
                });

                btnDecimalI.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtFutureRate.setText(txtFutureRate.getText()+".");
                    }
                });
            }
        });
//Buttons





        //No of Periods

        Label lblPeriodsTitle = new Label("Periods Calculation");
        lblPeriodsTitle.setLayoutX(80);
        lblPeriodsTitle.setLayoutY(30);
        lblPeriodsTitle.setStyle("-fx-text-fill: white;"+
                "-fx-font-size:40px;"+
                "-fx-font-family: Papyrus");


        Button btnExitPeriods = new Button("Exit");
        btnExitPeriods.setLayoutX(550);
        btnExitPeriods.setLayoutY(450);
        btnExitPeriods.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 100px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;"+
                "-fx-pref-width: 150px;");
        btnExitPeriods.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage loanStage = (Stage)btnExitPeriods.getScene().getWindow();
                windowSavings.close();


            }
        });

        Label lblInterestPeriods = new Label("Interest Rate");
        lblInterestPeriods.setLayoutX(50);
        lblInterestPeriods.setLayoutY(100);
        lblInterestPeriods.setStyle("-fx-text-fill: white;"+
                "-fx-font-size:16px;");

        Label lblPresentValuePeriods = new Label("Start Principal");
        lblPresentValuePeriods.setLayoutX(50);
        lblPresentValuePeriods.setLayoutY(150);
        lblPresentValuePeriods.setStyle("-fx-text-fill: white;"+
                "-fx-font-size:16px;");

        Label lblAnnuityPeriods = new Label("Annuity Payment");
        lblAnnuityPeriods.setLayoutX(50);
        lblAnnuityPeriods.setLayoutY(200);
        lblAnnuityPeriods.setStyle("-fx-text-fill: white;"+
                "-fx-font-size:16px;");

        Label lblFuturePeriods = new Label("Future Value");
        lblFuturePeriods.setLayoutX(50);
        lblFuturePeriods.setLayoutY(250);
        lblFuturePeriods.setStyle("-fx-text-fill: white;"+
                "-fx-font-size:16px;");


        Label lblPeriodsTxt = new Label("No.Of Periods:");
        lblPeriodsTxt.setLayoutY(400);
        lblPeriodsTxt.setLayoutX(50);
        lblPeriodsTxt.setStyle("-fx-text-fill: white;"+
                "-fx-font-size:22px;"+
                "-fx-font-family:'Agency FB';");

        Label lblOutPeriods = new Label("         ");
        lblOutPeriods.setLayoutY(400);
        lblOutPeriods.setLayoutX(200);
        lblOutPeriods.setStyle("-fx-text-fill: white;"+
                "-fx-font-size:22px;");


        //text Fields

        TextField txtInterestPeriods = new TextField("");
        txtInterestPeriods.setPromptText("%");
        txtInterestPeriods.setLayoutY(100);
        txtInterestPeriods.setLayoutX(200);
        txtInterestPeriods.setStyle("-fx-pref-width:325px;"+
                "-fx-background-radius: 15px;");


        TextField txtPresentValuePeriods = new TextField("");
        txtPresentValuePeriods.setPromptText("$");
        txtPresentValuePeriods.setLayoutX(200);
        txtPresentValuePeriods.setLayoutY(150);
        txtPresentValuePeriods.setStyle("-fx-pref-width:325px;"+
                "-fx-background-radius: 15px;");


        TextField txtAnnuityPeriods = new TextField("");
        txtAnnuityPeriods.setPromptText("$");
        txtAnnuityPeriods.setLayoutX(200);
        txtAnnuityPeriods.setLayoutY(200);
        txtAnnuityPeriods.setStyle("-fx-pref-width:325px;"+
                "-fx-background-radius: 15px;");


        TextField txtFuturePeriods = new TextField("");
        txtFuturePeriods.setPromptText("$");
        txtFuturePeriods.setLayoutX(200);
        txtFuturePeriods.setLayoutY(250);
        txtFuturePeriods.setStyle("-fx-pref-width:325px;"+
                "-fx-background-radius: 15px;");


        //Buttons


        Button btnCalculatePeriods = new Button("Calculate");
        btnCalculatePeriods.setLayoutY(350);
        btnCalculatePeriods.setLayoutX(375);
        btnCalculatePeriods.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 100px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;"+
                "-fx-pref-width: 150px;");
        btnCalculatePeriods.setOnAction(e -> {
            try {
                double noPeriods =12;
                double interestPeriod = Double.parseDouble(txtInterestPeriods.getText());
                double futurePeriods = Double.parseDouble(txtFuturePeriods.getText());
                double presentPeriods = Double.parseDouble(txtPresentValuePeriods.getText());
                double annuityPeriods = Double.parseDouble(txtAnnuityPeriods.getText());

                double periods;
                periods= log((futurePeriods+(annuityPeriods*12/interestPeriod))/(presentPeriods+(annuityPeriods*12/interestPeriod)))/(log(1+(interestPeriod/12))*12);

                lblOutPeriods.setText(String.format("%.2f",periods));

            }
            catch (Exception text)
            {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("Integer Value Needed");
                alert.show();
            }

        });


        Button btnResetPeriods = new Button("Reset");
        btnResetPeriods.setLayoutX(200);
        btnResetPeriods.setLayoutY(350);
        btnResetPeriods.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 100px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;"+
                "-fx-pref-width: 150px;");
        btnResetPeriods.setOnAction(event -> {
            txtFuturePeriods.clear();
            txtInterestPeriods.clear();
            txtPresentValuePeriods.clear();
            txtAnnuityPeriods.clear();

        });


        Button btnBackPeriods = new Button("Back");
        btnBackPeriods.setLayoutX(50);
        btnBackPeriods.setLayoutY(450);
        btnBackPeriods.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 100px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;"+
                "-fx-pref-width: 150px;");
        btnBackPeriods.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage savingsStage = (Stage)btnBackPeriods.getScene().getWindow();
                windowSavings.close();
                navigation.navigationStage();


            }
        });



        // On Screen Key Board Input for Periods

        Button btnSevenP = new Button("7");
        btnSevenP.setLayoutY(150);
        btnSevenP.setLayoutX(550);
        btnSevenP.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;");
        btnSevenP.setOnAction(event -> {
            txtPresentValuePeriods.setText((txtPresentValuePeriods.getText().concat("7")));

        });




        Button btnEightP = new Button("8");
        btnEightP.setLayoutX(600);
        btnEightP.setLayoutY(150);
        btnEightP.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;");
        btnEightP.setOnAction(event -> {
            txtPresentValuePeriods.setText((txtPresentValuePeriods.getText().concat("8")));

        });



        Button btnNineP = new Button("9");
        btnNineP.setLayoutY(150);
        btnNineP.setLayoutX(650);
        btnNineP.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;");
        btnNineI.setOnAction(event -> {
            txtPresentValuePeriods.setText((txtPresentValuePeriods.getText().concat("9")));

        });



        Button btnFourP = new Button("4");
        btnFourP.setLayoutY(200);
        btnFourP.setLayoutX(550);
        btnFourP.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;");
        btnFourP.setOnAction(event -> {
            txtPresentValuePeriods.setText((txtPresentValuePeriods.getText().concat("4")));

        });


        Button btnFiveP = new Button("5");
        btnFiveP.setLayoutX(600);
        btnFiveP.setLayoutY(200);
        btnFiveP.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;");
        btnFiveP.setOnAction(event -> {
            txtPresentValuePeriods.setText((txtPresentValuePeriods.getText().concat("5")));

        });

        Button btnSixP = new Button("6");
        btnSixP.setLayoutY(200);
        btnSixP.setLayoutX(650);
        btnSixP.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;");
        btnSixP.setOnAction(event -> {
            txtPresentValuePeriods.setText((txtPresentValuePeriods.getText().concat("6")));

        });




        Button btnOneP = new Button("1");
        btnOneP.setLayoutY(250);
        btnOneP.setLayoutX(550);
        btnOneP.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;");
        btnOneP.setOnAction(event -> {
            txtPresentValuePeriods.setText((txtPresentValuePeriods.getText().concat("1")));

        });


        Button btnTwoP = new Button("2");
        btnTwoP.setLayoutX(600);
        btnTwoP.setLayoutY(250);
        btnTwoP.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;");
        btnTwoP.setOnAction(event -> {
            txtPresentValuePeriods.setText((txtPresentValuePeriods.getText().concat("2")));

        });

        Button btnThreeP = new Button("3");
        btnThreeP.setLayoutY(250);
        btnThreeP.setLayoutX(650);
        btnThreeP.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;");
        btnThreeP.setOnAction(event -> {
            txtPresentValuePeriods.setText((txtPresentValuePeriods.getText().concat("3")));

        });


        Button btnZeroP = new Button("0");
        btnZeroP.setLayoutX(550);
        btnZeroP.setLayoutY(300);
        btnZeroP.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;"+
                "-fx-pref-width:75px;");
        btnZeroP.setOnAction(event -> {
            txtPresentValuePeriods.setText((txtPresentValuePeriods.getText().concat("0")));

        });

        Button btnDecimalP = new Button(".");
        btnDecimalP.setLayoutY(300);
        btnDecimalP.setLayoutX(650);
        btnDecimalP.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;");
        btnDecimalP.setOnAction(event -> {
            txtPresentValuePeriods.setText((txtPresentValuePeriods.getText().concat(".")));

        });


        Button btnPositiveP = new Button("+");
        btnPositiveP.setLayoutX(700);
        btnPositiveP.setLayoutY(150);
        btnPositiveP.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;"+
                "-fx-pref-height: 85px;");
        btnPositiveP.setOnAction(event -> {
            txtPresentValuePeriods.setText((txtPresentValuePeriods.getText().concat("+")));

        });


        Button btnNegativeP = new Button("-");
        btnNegativeP.setLayoutY(250);
        btnNegativeP.setLayoutX(700);
        btnNegativeP.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;"+
                "-fx-pref-height: 85px;");
        btnNegativeP.setOnAction(event -> {
            txtPresentValuePeriods.setText((txtPresentValuePeriods.getText().concat("-")));

        });


//Setting
        txtPresentValuePeriods.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                btnSevenP.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPresentValuePeriods.setText(txtPresentValuePeriods.getText()+"7");
                    }
                });

                btnEightP.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPresentValuePeriods.setText(txtPresentValuePeriods.getText()+"8");
                    }
                });

                btnNineP.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPresentValuePeriods.setText(txtPresentValuePeriods.getText()+"9");
                    }
                });

                btnSixP.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPresentValuePeriods.setText(txtPresentValuePeriods.getText()+"6");
                    }
                });

                btnFiveP.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPresentValuePeriods.setText(txtPresentValuePeriods.getText()+"5");
                    }
                });

                btnFourP.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPresentValuePeriods.setText(txtPresentValuePeriods.getText()+"4");
                    }
                });

                btnThreeP.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPresentValuePeriods.setText(txtPresentValuePeriods.getText()+"3");
                    }
                });

                btnTwoP.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPresentValuePeriods.setText(txtPresentValuePeriods.getText()+"2");
                    }
                });

                btnOneP.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPresentValuePeriods.setText(txtPresentValuePeriods.getText()+"1");
                    }
                });

                btnZeroP.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPresentValuePeriods.setText(txtPresentValuePeriods.getText()+"0");
                    }
                });

                btnNegativeP.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPresentValuePeriods.setText(txtPresentValuePeriods.getText()+"-");
                    }
                });

                btnPositiveP.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPresentValuePeriods.setText(txtPresentValuePeriods.getText()+"+");
                    }
                });

                btnDecimalP.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPresentValuePeriods.setText(txtPresentValuePeriods.getText()+".");
                    }
                });
            }
        });


        txtAnnuityPeriods.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                btnSevenP.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtAnnuityPeriods.setText(txtAnnuityPeriods.getText()+"7");
                    }
                });

                btnEightP.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtAnnuityPeriods.setText(txtAnnuityPeriods.getText()+"8");
                    }
                });

                btnNineP.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtAnnuityPeriods.setText(txtAnnuityPeriods.getText()+"9");
                    }
                });

                btnSixP.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtAnnuityPeriods.setText(txtAnnuityPeriods.getText()+"6");
                    }
                });

                btnFiveP.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtAnnuityPeriods.setText(txtAnnuityPeriods.getText()+"5");
                    }
                });

                btnFourP.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtAnnuityPeriods.setText(txtAnnuityPeriods.getText()+"4");
                    }
                });

                btnThreeP.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtAnnuityPeriods.setText(txtAnnuityPeriods.getText()+"3");
                    }
                });

                btnTwoP.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtAnnuityPeriods.setText(txtAnnuityPeriods.getText()+"2");
                    }
                });

                btnOneP.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtAnnuityPeriods.setText(txtAnnuityPeriods.getText()+"1");
                    }
                });

                btnZeroP.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtAnnuityPeriods.setText(txtAnnuityPeriods.getText()+"0");
                    }
                });

                btnNegativeP.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtAnnuityPeriods.setText(txtAnnuityPeriods.getText()+"-");
                    }
                });

                btnPositiveP.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtAnnuityPeriods.setText(txtAnnuityPeriods.getText()+"+");
                    }
                });

                btnDecimalP.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtAnnuityPeriods.setText(txtAnnuityPeriods.getText()+".");
                    }
                });
            }
        });


        txtFuturePeriods.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                btnSevenP.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtFuturePeriods.setText(txtFuturePeriods.getText()+"7");
                    }
                });

                btnEightP.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtFuturePeriods.setText(txtFuturePeriods.getText()+"8");
                    }
                });

                btnNineP.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtFuturePeriods.setText(txtFuturePeriods.getText()+"9");
                    }
                });

                btnSixP.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtFuturePeriods.setText(txtFuturePeriods.getText()+"6");
                    }
                });

                btnFiveP.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtFuturePeriods.setText(txtFuturePeriods.getText()+"5");
                    }
                });

                btnFourP.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtFuturePeriods.setText(txtFuturePeriods.getText()+"4");
                    }
                });

                btnThreeP.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtFuturePeriods.setText(txtFuturePeriods.getText()+"3");
                    }
                });

                btnTwoP.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtFuturePeriods.setText(txtFuturePeriods.getText()+"2");
                    }
                });

                btnOneP.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtFuturePeriods.setText(txtFuturePeriods.getText()+"1");
                    }
                });

                btnZeroP.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtFuturePeriods.setText(txtFuturePeriods.getText()+"0");
                    }
                });

                btnNegativeP.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtFuturePeriods.setText(txtFuturePeriods.getText()+"-");
                    }
                });

                btnPositiveP.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtFuturePeriods.setText(txtFuturePeriods.getText()+"+");
                    }
                });

                btnDecimalP.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtFuturePeriods.setText(txtFuturePeriods.getText()+".");
                    }
                });
            }
        });


        txtInterestPeriods.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                btnSevenP.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtInterestPeriods.setText(txtInterestPeriods.getText()+"7");
                    }
                });

                btnEightP.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtInterestPeriods.setText(txtInterestPeriods.getText()+"8");
                    }
                });

                btnNineP.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtInterestPeriods.setText(txtInterestPeriods.getText()+"9");
                    }
                });

                btnSixP.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtInterestPeriods.setText(txtInterestPeriods.getText()+"6");
                    }
                });

                btnFiveP.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtInterestPeriods.setText(txtInterestPeriods.getText()+"5");
                    }
                });

                btnFourP.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtInterestPeriods.setText(txtInterestPeriods.getText()+"4");
                    }
                });

                btnThreeP.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtInterestPeriods.setText(txtInterestPeriods.getText()+"3");
                    }
                });

                btnTwoP.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtInterestPeriods.setText(txtInterestPeriods.getText()+"2");
                    }
                });

                btnOneP.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtInterestPeriods.setText(txtInterestPeriods.getText()+"1");
                    }
                });

                btnZeroP.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtInterestPeriods.setText(txtInterestPeriods.getText()+"0");
                    }
                });

                btnNegativeP.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtInterestPeriods.setText(txtInterestPeriods.getText()+"-");
                    }
                });

                btnPositiveP.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtInterestPeriods.setText(txtInterestPeriods.getText()+"+");
                    }
                });

                btnDecimalP.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtInterestPeriods.setText(txtInterestPeriods.getText()+".");
                    }
                });
            }
        });






//Start Principal

        Label lblPresentTitle = new Label("Start Principal Calculation");
        lblPresentTitle.setLayoutX(80);
        lblPresentTitle.setLayoutY(30);
        lblPresentTitle.setStyle("-fx-text-fill: white;"+
                "-fx-font-size:40px;"+
                "-fx-font-family: Papyrus");


        Label lblInterestPresent = new Label("Interest Rate");
        lblInterestPresent.setLayoutX(50);
        lblInterestPresent.setLayoutY(100);
        lblInterestPresent.setStyle("-fx-text-fill: white;"+
                "-fx-font-size:16px;");

        Label lblPeriodsPresent = new Label("N(# of periods)");
        lblPeriodsPresent.setLayoutX(50);
        lblPeriodsPresent.setLayoutY(150);
        lblPeriodsPresent.setStyle("-fx-text-fill: white;"+
                "-fx-font-size:16px;");

        Label lblAnnuityPresent = new Label("Annuity Payment");
        lblAnnuityPresent.setLayoutX(50);
        lblAnnuityPresent.setLayoutY(200);
        lblAnnuityPresent.setStyle("-fx-text-fill: white;"+
                "-fx-font-size:16px;");

        Label lblFuturePresent = new Label("Future Value");
        lblFuturePresent.setLayoutX(50);
        lblFuturePresent.setLayoutY(250);
        lblFuturePresent.setStyle("-fx-text-fill: white;"+
                "-fx-font-size:16px;");

        Label lblPresentTxt = new Label("Start Principal:");
        lblPresentTxt.setLayoutY(400);
        lblPresentTxt.setLayoutX(50);
        lblPresentTxt.setStyle("-fx-text-fill: white;"+
                "-fx-font-size:22px;"+
                "-fx-font-family:'Agency FB';");

        Label lblPresentTxtOut = new Label("");
        lblPresentTxtOut.setLayoutY(400);
        lblPresentTxtOut.setLayoutX(200);
        lblPresentTxtOut.setStyle("-fx-text-fill: white;"+
                "-fx-font-size:22px;");

        Label lblOutPresent = new Label("         ");
        lblOutPresent.setLayoutY(400);
        lblOutPresent.setLayoutX(200);
        lblOutPresent.setStyle("-fx-text-fill: white;"+
                "-fx-font-size:22px;");


        //text Fields

        TextField txtInterestPresent = new TextField("");
        txtInterestPresent.setPromptText("%");
        txtInterestPresent.setLayoutY(100);
        txtInterestPresent.setLayoutX(200);
        txtInterestPresent.setStyle("-fx-pref-width:325px;"+
                "-fx-background-radius: 15px;");


        TextField txtPeriodsPresent = new TextField("");
        txtPeriodsPresent.setLayoutX(200);
        txtPeriodsPresent.setLayoutY(150);
        txtPeriodsPresent.setStyle("-fx-pref-width:325px;"+
                "-fx-background-radius: 15px;");


        TextField txtAnnuityPresent = new TextField("");
        txtAnnuityPresent.setPromptText("$");
        txtAnnuityPresent.setLayoutX(200);
        txtAnnuityPresent.setLayoutY(200);
        txtAnnuityPresent.setStyle("-fx-pref-width:325px;"+
                "-fx-background-radius: 15px;");


        TextField txtFuturePresent = new TextField("");
        txtFuturePresent.setPromptText("$");
        txtFuturePresent.setLayoutX(200);
        txtFuturePresent.setLayoutY(250);
        txtFuturePresent.setStyle("-fx-pref-width:325px;"+
                "-fx-background-radius: 15px;");


        //Buttons
        Button btnExitPresent = new Button("Exit");
        btnExitPresent.setLayoutX(550);
        btnExitPresent.setLayoutY(450);
        btnExitPresent.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 100px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;"+
                "-fx-pref-width: 150px;");
        btnExitPresent.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage loanStage = (Stage)btnExitPresent.getScene().getWindow();
                windowSavings.close();


            }
        });


        Button btnCalculatePresent = new Button("Calculate");
        btnCalculatePresent.setLayoutY(350);
        btnCalculatePresent.setLayoutX(375);
        btnCalculatePresent.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 100px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;"+
                "-fx-pref-width: 150px;");
        btnCalculatePresent.setOnAction(e -> {
            try {
                double noOfMonth = 12;
                double numPeriods = Double.parseDouble(txtInterestPresent.getText());
                double interestRate = Double.parseDouble(txtInterestPresent.getText());
                double futureVal = Double.parseDouble(txtFuturePresent.getText());
                double annuity = Double.parseDouble(txtAnnuityPresent.getText());

                double startPrincipal;
                startPrincipal= (futureVal-(annuity*((pow((1+(interestRate/noOfMonth)),(noOfMonth*numPeriods))-1)/(interestRate/noOfMonth))))/(pow((1+(interestRate/noOfMonth)),(noOfMonth*numPeriods)));

                lblOutPresent.setText(String.format("%.2f",startPrincipal));

            }
            catch (Exception text)
            {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("Integer Value Needed");
                alert.show();
            }

        });

        Button btnResetPresent = new Button("Reset");
        btnResetPresent.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 100px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;"+
                "-fx-pref-width: 150px;");
        btnResetPresent.setLayoutX(200);
        btnResetPresent.setLayoutY(350);
        btnResetPresent.setOnAction(event -> {
            txtPeriodsPresent.clear();
            txtInterestPresent.clear();
            txtFuturePresent.clear();
            txtAnnuityPresent.clear();

        });


        Button btnBackPresent = new Button("Back");
        btnBackPresent.setLayoutX(50);
        btnBackPresent.setLayoutY(450);
        btnBackPresent.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 100px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;"+
                "-fx-pref-width: 150px;");
        btnBackPresent.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage savingsStage = (Stage)btnBackPresent.getScene().getWindow();
                windowSavings.close();
                navigation.navigationStage();


            }
        });


        // On Screen Key Board Input for Start Pricipal

        Button btnSevenA = new Button("7");
        btnSevenA.setLayoutY(150);
        btnSevenA.setLayoutX(550);
        btnSevenA.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;");
        btnSevenA.setOnAction(event -> {
            txtInterestPresent.setText((txtInterestPresent.getText().concat("7")));

        });




        Button btnEightA = new Button("8");
        btnEightA.setLayoutX(600);
        btnEightA.setLayoutY(150);
        btnEightA.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;");
        btnEightA.setOnAction(event -> {
            txtInterestPresent.setText((txtInterestPresent.getText().concat("8")));

        });



        Button btnNineA = new Button("9");
        btnNineA.setLayoutY(150);
        btnNineA.setLayoutX(650);
        btnNineA.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;");
        btnNineA.setOnAction(event -> {
            txtInterestPresent.setText((txtInterestPresent.getText().concat("9")));

        });



        Button btnFourA = new Button("4");
        btnFourA.setLayoutY(200);
        btnFourA.setLayoutX(550);
        btnFourA.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;");
        btnFourA.setOnAction(event -> {
            txtInterestPresent.setText((txtInterestPresent.getText().concat("4")));

        });


        Button btnFiveA = new Button("5");
        btnFiveA.setLayoutX(600);
        btnFiveA.setLayoutY(200);
        btnFiveA.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;");
        btnFiveA.setOnAction(event -> {
            txtInterestPresent.setText((txtInterestPresent.getText().concat("5")));

        });

        Button btnSixA = new Button("6");
        btnSixA.setLayoutY(200);
        btnSixA.setLayoutX(650);
        btnSixA.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;");
        btnSixA.setOnAction(event -> {
            txtInterestPresent.setText((txtInterestPresent.getText().concat("6")));

        });




        Button btnOneA = new Button("1");
        btnOneA.setLayoutY(250);
        btnOneA.setLayoutX(550);
        btnOneA.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;");
        btnOneA.setOnAction(event -> {
            txtInterestPresent.setText((txtInterestPresent.getText().concat("1")));

        });


        Button btnTwoA = new Button("2");
        btnTwoA.setLayoutX(600);
        btnTwoA.setLayoutY(250);
        btnTwoA.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;");
        btnTwoA.setOnAction(event -> {
            txtInterestPresent.setText((txtInterestPresent.getText().concat("2")));

        });

        Button btnThreeA = new Button("3");
        btnThreeA.setLayoutY(250);
        btnThreeA.setLayoutX(650);
        btnThreeA.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;");
        btnThreeA.setOnAction(event -> {
            txtInterestPresent.setText((txtInterestPresent.getText().concat("3")));

        });


        Button btnZeroA = new Button("0");
        btnZeroA.setLayoutX(550);
        btnZeroA.setLayoutY(300);
        btnZeroA.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;"+
                "-fx-pref-width:75px;");
        btnZeroA.setOnAction(event -> {
            txtInterestPresent.setText((txtInterestPresent.getText().concat("0")));

        });

        Button btnDecimalA = new Button(".");
        btnDecimalA.setLayoutY(300);
        btnDecimalA.setLayoutX(650);
        btnDecimalA.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;");
        btnDecimalA.setOnAction(event -> {
            txtInterestPresent.setText((txtInterestPresent.getText().concat(".")));

        });


        Button btnPositiveA = new Button("+");
        btnPositiveA.setLayoutX(700);
        btnPositiveA.setLayoutY(150);
        btnPositiveA.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;"+
                "-fx-pref-height: 85px;");
        btnPositiveA.setOnAction(event -> {
            txtInterestPresent.setText((txtInterestPresent.getText().concat("+")));

        });


        Button btnNegativeA = new Button("-");
        btnNegativeA.setLayoutY(250);
        btnNegativeA.setLayoutX(700);
        btnNegativeA.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;"+
                "-fx-pref-height: 85px;");
        btnNegativeA.setOnAction(event -> {
            txtInterestPresent.setText((txtInterestPresent.getText().concat("-")));

        });


//Setting
        txtInterestPresent.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                btnSevenA.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtInterestPresent.setText(txtInterestPresent.getText()+"7");
                    }
                });

                btnEightA.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPresentValuePeriods.setText(txtPresentValuePeriods.getText()+"8");
                    }
                });

                btnNineA.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtInterestPresent.setText(txtInterestPresent.getText()+"9");
                    }
                });

                btnSixA.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtInterestPresent.setText(txtInterestPresent.getText()+"6");
                    }
                });

                btnFiveA.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtInterestPresent.setText(txtInterestPresent.getText()+"5");
                    }
                });

                btnFourA.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtInterestPresent.setText(txtInterestPresent.getText()+"4");
                    }
                });

                btnThreeA.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtInterestPresent.setText(txtInterestPresent.getText()+"3");
                    }
                });

                btnTwoA.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtInterestPresent.setText(txtInterestPresent.getText()+"2");
                    }
                });

                btnOneA.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtInterestPresent.setText(txtInterestPresent.getText()+"1");
                    }
                });

                btnZeroA.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtInterestPresent.setText(txtInterestPresent.getText()+"0");
                    }
                });

                btnNegativeA.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtInterestPresent.setText(txtInterestPresent.getText()+"-");
                    }
                });

                btnPositiveA.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtInterestPresent.setText(txtInterestPresent.getText()+"+");
                    }
                });

                btnDecimalA.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtInterestPresent.setText(txtInterestPresent.getText()+".");
                    }
                });
            }
        });


        txtPeriodsPresent.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                btnSevenA.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPeriodsPresent.setText(txtPeriodsPresent.getText()+"7");
                    }
                });

                btnEightA.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPeriodsPresent.setText(txtPeriodsPresent.getText()+"8");
                    }
                });

                btnNineA.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPeriodsPresent.setText(txtPeriodsPresent.getText()+"9");
                    }
                });

                btnSixA.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPeriodsPresent.setText(txtPeriodsPresent.getText()+"6");
                    }
                });

                btnFiveA.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPeriodsPresent.setText(txtPeriodsPresent.getText()+"5");
                    }
                });

                btnFourA.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPeriodsPresent.setText(txtPeriodsPresent.getText()+"4");
                    }
                });

                btnThreeA.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPeriodsPresent.setText(txtPeriodsPresent.getText()+"3");
                    }
                });

                btnTwoA.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPeriodsPresent.setText(txtPeriodsPresent.getText()+"2");
                    }
                });

                btnOneA.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPeriodsPresent.setText(txtPeriodsPresent.getText()+"1");
                    }
                });

                btnZeroA.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPeriodsPresent.setText(txtPeriodsPresent.getText()+"0");
                    }
                });

                btnNegativeA.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPeriodsPresent.setText(txtPeriodsPresent.getText()+"-");
                    }
                });

                btnPositiveA.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPeriodsPresent.setText(txtPeriodsPresent.getText()+"+");
                    }
                });

                btnDecimalA.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPeriodsPresent.setText(txtPeriodsPresent.getText()+".");
                    }
                });
            }
        });


        txtAnnuityPresent.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                btnSevenA.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtAnnuityPresent.setText(txtAnnuityPresent.getText()+"7");
                    }
                });

                btnEightA.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtAnnuityPresent.setText(txtAnnuityPresent.getText()+"8");
                    }
                });

                btnNineA.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtAnnuityPresent.setText(txtAnnuityPresent.getText()+"9");
                    }
                });

                btnSixA.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtAnnuityPresent.setText(txtAnnuityPresent.getText()+"6");
                    }
                });

                btnFiveA.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtAnnuityPresent.setText(txtAnnuityPresent.getText()+"5");
                    }
                });

                btnFourA.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtAnnuityPresent.setText(txtAnnuityPresent.getText()+"4");
                    }
                });

                btnThreeA.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtAnnuityPresent.setText(txtAnnuityPresent.getText()+"3");
                    }
                });

                btnTwoA.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtAnnuityPresent.setText(txtAnnuityPresent.getText()+"2");
                    }
                });

                btnOneA.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtAnnuityPresent.setText(txtAnnuityPresent.getText()+"1");
                    }
                });

                btnZeroA.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtAnnuityPresent.setText(txtAnnuityPresent.getText()+"0");
                    }
                });

                btnNegativeA.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtAnnuityPresent.setText(txtAnnuityPresent.getText()+"-");
                    }
                });

                btnPositiveA.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtAnnuityPresent.setText(txtAnnuityPresent.getText()+"+");
                    }
                });

                btnDecimalA.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtAnnuityPresent.setText(txtAnnuityPresent.getText()+".");
                    }
                });
            }
        });


        txtInterestPresent.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                btnSevenA.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtInterestPresent.setText(txtInterestPresent.getText()+"7");
                    }
                });

                btnEightA.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtInterestPresent.setText(txtInterestPresent.getText()+"8");
                    }
                });

                btnNineA.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtInterestPresent.setText(txtInterestPresent.getText()+"9");
                    }
                });

                btnSixA.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtInterestPresent.setText(txtInterestPresent.getText()+"6");
                    }
                });

                btnFiveA.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtInterestPresent.setText(txtInterestPresent.getText()+"5");
                    }
                });

                btnFourA.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtInterestPresent.setText(txtInterestPresent.getText()+"4");
                    }
                });

                btnThreeA.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtInterestPresent.setText(txtInterestPresent.getText()+"3");
                    }
                });

                btnTwoA.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtInterestPresent.setText(txtInterestPresent.getText()+"2");
                    }
                });

                btnOneA.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtInterestPresent.setText(txtInterestPresent.getText()+"1");
                    }
                });

                btnZeroA.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtInterestPresent.setText(txtInterestPresent.getText()+"0");
                    }
                });

                btnNegativeA.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtInterestPresent.setText(txtInterestPresent.getText()+"-");
                    }
                });

                btnPositiveA.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtInterestPresent.setText(txtInterestPresent.getText()+"+");
                    }
                });

                btnDecimalA.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtInterestPresent.setText(txtInterestPresent.getText()+".");
                    }
                });
            }
        });


//History Financial

        Button btnBackHistorySa = new Button("Back");
        btnBackHistorySa.setLayoutX(50);
        btnBackHistorySa.setLayoutY(450);
        btnBackHistorySa.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 100px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;"+
                "-fx-pref-width: 150px;");
        btnBackHistorySa.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage savingsStage = (Stage)btnBackHistorySa.getScene().getWindow();
                windowSavings.close();
                navigation.navigationStage();


            }
        });



        TabPane savingsTab = new TabPane();
        savingsTab.setStyle("-fx-background-color: white;"+
                "-fx-font-weight: bold;");

        Tab futureValue = new Tab("FV");
        Tab payment = new Tab("PMT");
        Tab interestRate = new Tab("I/Y");
        Tab periods = new Tab("N");
        Tab startPrincipal = new Tab("Start Principal");


        savingsTab.getTabs().addAll(futureValue,payment,interestRate,periods,startPrincipal);

        Group futureValueGr = new Group();
        futureValueGr.getChildren().addAll();


        VBox vBoxLayout = new VBox(savingsTab);
        Scene sceneLayout = new Scene(vBoxLayout);



        Pane layoutFutureValue = new Pane();
        layoutFutureValue.setId("financialStyle");
        layoutFutureValue.getChildren().addAll(btnCalculate,btnReset,btnBackFuture,btnExitFuture,lblFutureTitle,lblPeriods,lblPresentValue,lblAnnuity,lblInterestRate,lblOutFutureValue,
                lblFutureTxt,txtPeriods,txtPresentValue,txtAnnuity,txtInterestRate,btnNineM,btnEightM,btnSevenM,btnSixM,btnFiveM,
                btnFourM,btnThreeM,btnTwoM,btnOneM,btnZeroM,btnPositiveM,btnNegativeM,btnDecimalM);
        layoutFutureValue.getStylesheets().addAll("style.css");
        futureValue.setContent(layoutFutureValue);
        layoutFutureValue.setPrefHeight(575);



        Pane layoutPayment = new Pane();
        layoutPayment.setId("financialStyle");
        layoutPayment.getChildren().addAll(btnCalculatePay,btnResetPay,btnBackPay,btnExitPay,lblPayTitle,lblPresentValuePay,lblPeriodsPay,lblFuturePay,lblInterestRatePay,
                lblPayTxt,lblOutPay,txtPeriodsPay,txtPresentValuePay,txtFuturePay,txtInterestRatePay,btnNine,btnEight,btnSeven,btnSix,btnFive,
                btnFour,btnThree,btnTwo,btnOne,btnZero,btnPositive,btnNegative,btnDecimal);
        layoutPayment.getStylesheets().addAll("style.css");
        payment.setContent(layoutPayment);



        Pane layoutInterest = new Pane();
        layoutInterest.setId("financialStyle");
        layoutInterest.getChildren().addAll(btnCalculateRate,btnBackRate,btnResetRate,btnExitRate,lblRateTitle,lblPresentValueRate,lblPeriodsRate,lblAnnuityRate,lblFutureRate,
                lblRateTxt,lblOutRate,txtPresentValueRate,txtPeriodsRate,txtAnnuityRate,txtFutureRate,btnNineI,btnEightI,btnSevenI,btnSixI,btnFiveI,
                btnFourI,btnThreeI,btnTwoI,btnOneI,btnZeroI,btnPositiveI,btnNegativeI,btnDecimalI);
        layoutInterest.getStylesheets().addAll("style.css");
        interestRate.setContent(layoutInterest);


        Pane layoutPeriods = new Pane();
        layoutPeriods.setId("financialStyle");
        layoutPeriods.getChildren().addAll(btnCalculatePeriods,btnBackPeriods,btnResetPeriods,btnExitPeriods,lblPeriodsTitle,lblInterestPeriods,lblPresentValuePeriods,lblAnnuityPeriods,lblFuturePeriods,
                lblPeriodsTxt,lblOutPeriods,txtInterestPeriods,txtPresentValuePeriods,txtAnnuityPeriods,txtFuturePeriods,btnNineP,btnEightP,btnSevenP,btnSixP,btnFiveP,
                btnFourP,btnThreeP,btnTwoP,btnOneP,btnZeroP,btnPositiveP,btnNegativeP,btnDecimalP);
        layoutPeriods.getStylesheets().addAll("style.css");
        periods.setContent(layoutPeriods);


        Pane layoutPresentValue = new Pane();
        layoutPresentValue.setId("financialStyle");
        layoutPresentValue.getChildren().addAll(btnCalculatePresent,btnResetPresent,btnBackPresent,btnExitPresent,lblPresentTitle,lblInterestPresent,lblAnnuityPresent,lblFuturePresent,lblPeriodsPresent,
                lblPresentTxt,lblOutPresent,txtInterestPresent,txtAnnuityPresent,txtFuturePresent,txtPeriodsPresent,btnNineA,btnEightA,btnSevenA,btnSixA,btnFiveA,
                btnFourA,btnThreeA,btnTwoA,btnOneA,btnZeroA,btnPositiveA,btnNegativeA,btnDecimalA);
        layoutPresentValue.getStylesheets().addAll("style.css");
        startPrincipal.setContent(layoutPresentValue);



        windowSavings.setScene(sceneLayout);
        windowSavings.setWidth(775);
        windowSavings.setHeight(575);
        windowSavings.show();

    }

    @Override
    public void start(Stage primaryStage) throws Exception {

    }
}
