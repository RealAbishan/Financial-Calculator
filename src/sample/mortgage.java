package sample;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
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

public class mortgage extends Application
{



    public static void main(String[] args)
    {

        launch(args);
    }

    public static void mortgageStage()
    {
//Menu bar with the some navigating functionalities

        Stage windowMortgage = new Stage();

        windowMortgage.setTitle("Mortgage");

        MenuBar mortgageMenu = new MenuBar();
        mortgageMenu.setStyle("-fx-pref-width: 750;"+
                "-fx-background-color: white;"+
                "-fx-font-weight: bold");


        Menu file = new Menu("Files");
        MenuItem menuSave = new MenuItem("Save");
        MenuItem menuExit = new MenuItem("Exit");
        file.getItems().addAll(menuSave,menuExit);

        Menu history  = new Menu("History");
        MenuItem menuHistory = new MenuItem("View History");
        history.getItems().addAll(menuHistory);

        mortgageMenu.getMenus().addAll(file,history);


//Setting up events to the Menu Items

        EventHandler<ActionEvent> eventSave = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText("Process Has Been saved Successfully");
                alert.show();
            }
        };


        EventHandler<ActionEvent> eventHistory = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText("Please Wait!!! We're Redirecting you.");
                alert.show();
            }
        };

        EventHandler<ActionEvent> eventExit = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText("Thank You!");
                alert.show();
                windowMortgage.close();
            }
        };

        menuSave.setOnAction(eventSave);
        menuExit.setOnAction(eventExit);
        menuHistory.setOnAction(eventHistory);


//Labels and Text Fields in the Mortgage Window

        Label lblMortgageTitle = new Label("Mortgage Calculator");
        lblMortgageTitle.setLayoutY(20);
        lblMortgageTitle.setLayoutX(150);
        lblMortgageTitle.setStyle("-fx-text-fill: white;"+
                "-fx-font-size:40px;"+
                "-fx-font-family:Papyrus;");

        Label lblPrice = new Label("Home Price");
        lblPrice.setLayoutY(100);
        lblPrice.setLayoutX(30);
        lblPrice.setStyle("-fx-text-fill: white;"+
                "-fx-font-size:16px;");

        TextField txtPrice = new TextField("");
        txtPrice.setPromptText("$");
        txtPrice.setLayoutY(100);
        txtPrice.setLayoutX(150);
        txtPrice.setStyle("-fx-pref-width:325px;"+
                "-fx-background-radius: 15px;");


        Label lblDownPayment = new Label("Down Payment");
        lblDownPayment.setLayoutY(150);
        lblDownPayment.setLayoutX(30);
        lblDownPayment.setStyle("-fx-text-fill: white;"+
                "-fx-font-size:16px;");

        TextField txtDownPayment = new TextField("");
        txtDownPayment.setPromptText("$");
        txtDownPayment.setLayoutY(150);
        txtDownPayment.setLayoutX(150);
        txtDownPayment.setStyle("-fx-pref-width:325px;"+
                "-fx-background-radius: 15px;");



        Label lblLoanTerm = new Label("Loan Term");
        lblLoanTerm.setLayoutY(200);
        lblLoanTerm.setLayoutX(30);
        lblLoanTerm.setStyle("-fx-text-fill: white;"+
                "-fx-font-size:16px;");

        Label lblOutMortgageM = new Label("Mortgage Payment (Monthly):");
        lblOutMortgageM.setLayoutX(30);
        lblOutMortgageM.setLayoutY(400);
        lblOutMortgageM.setStyle("-fx-text-fill: white;"+
                "-fx-font-size:22px;"+
                "-fx-font-family:'Agency FB';");

        Label lblOutMortgage = new Label("");
        lblOutMortgage.setLayoutX(250);
        lblOutMortgage.setLayoutY(400);
        lblOutMortgage.setStyle("-fx-text-fill: white;"+
                "-fx-font-size:22px;");

        TextField txtLoanTerm = new TextField("");
        txtLoanTerm.setLayoutY(200);
        txtLoanTerm.setLayoutX(150);
        txtLoanTerm.setStyle("-fx-pref-width:325px;"+
                "-fx-background-radius: 15px;");



        Label lblInterestRateM = new Label("Interest Rate");
        lblInterestRateM.setLayoutY(250);
        lblInterestRateM.setLayoutX(30);
        lblInterestRateM.setStyle("-fx-text-fill: white;"+
                "-fx-font-size:16px;");

        TextField txtInterestRateM = new TextField("");
        txtInterestRateM.setPromptText("%");
        txtInterestRateM.setLayoutX(150);
        txtInterestRateM.setLayoutY(250);
        txtInterestRateM.setStyle("-fx-pref-width:325px;"+
                "-fx-background-radius: 15px;");


        Label lblKeyBoard = new Label("OnScreen Key Board");
        lblKeyBoard.setLayoutX(500);
        lblKeyBoard.setLayoutY(100);
        lblKeyBoard.setStyle("-fx-text-fill: white;"+
                "-fx-font-size:22px;");

//Button Controls of the Mortgage Window


        Button btnCalculateMortgage = new Button("Calculate");
        btnCalculateMortgage.setLayoutX(325);
        btnCalculateMortgage.setLayoutY(350);
        btnCalculateMortgage.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 100px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;"+
                "-fx-pref-width: 150px;");
        btnCalculateMortgage.setOnAction(e -> {
                try {
                    double noOfMon = 12;
                    double homePrice=Double.parseDouble(txtPrice.getText());
                    double downPay = Double.parseDouble(txtDownPayment.getText());
                    double loanTerm =Double.parseDouble(txtLoanTerm.getText());
                    double interestRate =Double.parseDouble(txtInterestRateM.getText());

                    double resultMortgage;
                    resultMortgage = ((loanTerm / noOfMon) / 100 * (homePrice-interestRate)) / (1 - pow((1 + (loanTerm / noOfMon) / 100), -noOfMon * downPay));
                    lblOutMortgage.setText(String.format("%.2f",resultMortgage));

                }
                catch (Exception text)
                {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setContentText("Integer Value Needed");
                    alert.show();
                }
        });


        Button btnReset = new Button("Reset");
        btnReset.setLayoutY(350);
        btnReset.setLayoutX(150);
        btnReset.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 100px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;"+
                "-fx-pref-width: 150px;");
        btnReset.setOnAction(event -> {
            txtPrice.clear();
            txtDownPayment.clear();
            txtLoanTerm.clear();
            txtInterestRateM.clear();
            lblOutMortgage.setText("");
        });



        Button btnBack = new Button("Back");
        btnBack.setLayoutX(30);
        btnBack.setLayoutY(450);
        btnBack.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 100px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;"+
                "-fx-pref-width: 150px;");
        btnBack.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage mortgageStage = (Stage)btnBack.getScene().getWindow();
                windowMortgage.close();
                navigation.navigationStage();


            }
        });

        Button btnExitL = new Button("Exit");
        btnExitL.setLayoutY(450);
        btnExitL.setLayoutX(500);
        btnExitL.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 100px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;"+
                "-fx-pref-width: 150px;");
        btnExitL.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage loanStage = (Stage)btnExitL.getScene().getWindow();
                windowMortgage.close();


            }
        });



        // On Screen Key Board Input

        Button btnSevenM = new Button("7");
        btnSevenM.setLayoutY(150);
        btnSevenM.setLayoutX(500);
        btnSevenM.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;");
        btnSevenM.setOnAction(event -> {
                txtPrice.setText((txtPrice.getText().concat("7")));

        });




        Button btnEightM = new Button("8");
        btnEightM.setLayoutX(550);
        btnEightM.setLayoutY(150);
        btnEightM.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;");
        btnEightM.setOnAction(event -> {
            txtPrice.setText((txtPrice.getText().concat("8")));

        });



        Button btnNineM = new Button("9");
        btnNineM.setLayoutY(150);
        btnNineM.setLayoutX(600);
        btnNineM.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;");
        btnNineM.setOnAction(event -> {
            txtPrice.setText((txtPrice.getText().concat("9")));

        });



        Button btnFourM = new Button("4");
        btnFourM.setLayoutY(200);
        btnFourM.setLayoutX(500);
        btnFourM.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;");
        btnFourM.setOnAction(event -> {
            txtPrice.setText((txtPrice.getText().concat("4")));

        });


        Button btnFiveM = new Button("5");
        btnFiveM.setLayoutX(550);
        btnFiveM.setLayoutY(200);
        btnFiveM.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;");
        btnFiveM.setOnAction(event -> {
            txtPrice.setText((txtPrice.getText().concat("5")));

        });

        Button btnSixM = new Button("6");
        btnSixM.setLayoutY(200);
        btnSixM.setLayoutX(600);
        btnSixM.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;");
        btnSixM.setOnAction(event -> {
            txtPrice.setText((txtPrice.getText().concat("6")));

        });




        Button btnOneM = new Button("1");
        btnOneM.setLayoutY(250);
        btnOneM.setLayoutX(500);
        btnOneM.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;");
        btnOneM.setOnAction(event -> {
            txtPrice.setText((txtPrice.getText().concat("1")));

        });


        Button btnTwoM = new Button("2");
        btnTwoM.setLayoutX(550);
        btnTwoM.setLayoutY(250);
        btnTwoM.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;");
        btnTwoM.setOnAction(event -> {
            txtPrice.setText((txtPrice.getText().concat("2")));

        });

        Button btnThreeM = new Button("3");
        btnThreeM.setLayoutY(250);
        btnThreeM.setLayoutX(600);
        btnThreeM.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;");
        btnThreeM.setOnAction(event -> {
            txtPrice.setText((txtPrice.getText().concat("3")));

        });


        Button btnZeroM = new Button("0");
        btnZeroM.setLayoutX(500);
        btnZeroM.setLayoutY(300);
        btnZeroM.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;"+
                "-fx-pref-width:75px;");
        btnZeroM.setOnAction(event -> {
            txtPrice.setText((txtPrice.getText().concat("0")));

        });

        Button btnDecimalM = new Button(".");
        btnDecimalM.setLayoutY(300);
        btnDecimalM.setLayoutX(600);
        btnDecimalM.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;");
        btnDecimalM.setOnAction(event -> {
            txtPrice.setText((txtPrice.getText().concat(".")));

        });


        Button btnPositiveM = new Button("+");
        btnPositiveM.setLayoutX(650);
        btnPositiveM.setLayoutY(150);
        btnPositiveM.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;"+
                "-fx-pref-height: 85px;");
        btnPositiveM.setOnAction(event -> {
            txtPrice.setText((txtPrice.getText().concat("+")));

        });


        Button btnNegativeM = new Button("-");
        btnNegativeM.setLayoutY(250);
        btnNegativeM.setLayoutX(650);
        btnNegativeM.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;"+
                "-fx-pref-height: 85px;");
        btnNegativeM.setOnAction(event -> {
            txtPrice.setText((txtPrice.getText().concat("-")));

        });


//Setting
        txtPrice.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                btnSevenM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPrice.setText(txtPrice.getText()+"7");
                    }
                });

                btnEightM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPrice.setText(txtPrice.getText()+"8");
                    }
                });

                btnNineM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPrice.setText(txtPrice.getText()+"9");
                    }
                });

                btnSixM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPrice.setText(txtPrice.getText()+"6");
                    }
                });

                btnFiveM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPrice.setText(txtPrice.getText()+"5");
                    }
                });

                btnFourM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPrice.setText(txtPrice.getText()+"4");
                    }
                });

                btnThreeM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPrice.setText(txtPrice.getText()+"3");
                    }
                });

                btnTwoM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPrice.setText(txtPrice.getText()+"2");
                    }
                });

                btnOneM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPrice.setText(txtPrice.getText()+"1");
                    }
                });

                btnZeroM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPrice.setText(txtPrice.getText()+"0");
                    }
                });

                btnNegativeM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPrice.setText(txtPrice.getText()+"-");
                    }
                });

                btnPositiveM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPrice.setText(txtPrice.getText()+"+");
                    }
                });

                btnDecimalM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPrice.setText(txtPrice.getText()+".");
                    }
                });
            }
        });


        txtDownPayment.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                btnSevenM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtDownPayment.setText(txtDownPayment.getText()+"7");
                    }
                });

                btnEightM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtDownPayment.setText(txtDownPayment.getText()+"8");
                    }
                });

                btnNineM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtDownPayment.setText(txtDownPayment.getText()+"9");
                    }
                });

                btnSixM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtDownPayment.setText(txtDownPayment.getText()+"6");
                    }
                });

                btnFiveM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPrice.setText(txtPrice.getText()+"5");
                    }
                });

                btnFourM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtDownPayment.setText(txtDownPayment.getText()+"4");
                    }
                });

                btnThreeM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPrice.setText(txtPrice.getText()+"3");
                    }
                });

                btnTwoM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtDownPayment.setText(txtDownPayment.getText()+"2");
                    }
                });

                btnOneM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtDownPayment.setText(txtDownPayment.getText()+"1");
                    }
                });

                btnZeroM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtPrice.setText(txtPrice.getText()+"0");
                    }
                });

                btnNegativeM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtDownPayment.setText(txtDownPayment.getText()+"-");
                    }
                });

                btnPositiveM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtDownPayment.setText(txtDownPayment.getText()+"+");
                    }
                });

                btnDecimalM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtDownPayment.setText(txtDownPayment.getText()+".");
                    }
                });
            }
        });


        txtLoanTerm.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                btnSevenM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtLoanTerm.setText(txtLoanTerm.getText()+"7");
                    }
                });

                btnEightM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtLoanTerm.setText(txtLoanTerm.getText()+"8");
                    }
                });

                btnNineM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtLoanTerm.setText(txtLoanTerm.getText()+"9");
                    }
                });

                btnSixM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtLoanTerm.setText(txtLoanTerm.getText()+"6");
                    }
                });

                btnFiveM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtLoanTerm.setText(txtLoanTerm.getText()+"5");
                    }
                });

                btnFourM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtDownPayment.setText(txtDownPayment.getText()+"4");
                    }
                });

                btnThreeM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtLoanTerm.setText(txtLoanTerm.getText()+"3");
                    }
                });

                btnTwoM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtLoanTerm.setText(txtLoanTerm.getText()+"2");
                    }
                });

                btnOneM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtLoanTerm.setText(txtLoanTerm.getText()+"1");
                    }
                });

                btnZeroM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtLoanTerm.setText(txtLoanTerm.getText()+"0");
                    }
                });

                btnNegativeM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtLoanTerm.setText(txtLoanTerm.getText()+"-");
                    }
                });

                btnPositiveM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtLoanTerm.setText(txtLoanTerm.getText()+"+");
                    }
                });

                btnDecimalM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtLoanTerm.setText(txtLoanTerm.getText()+".");
                    }
                });
            }
        });


        txtInterestRateM.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                btnSevenM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtInterestRateM.setText(txtInterestRateM.getText()+"7");
                    }
                });

                btnEightM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtInterestRateM.setText(txtInterestRateM.getText()+"8");
                    }
                });

                btnNineM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtInterestRateM.setText(txtInterestRateM.getText()+"9");
                    }
                });

                btnSixM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtInterestRateM.setText(txtInterestRateM.getText()+"6");
                    }
                });

                btnFiveM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtInterestRateM.setText(txtInterestRateM.getText()+"5");
                    }
                });

                btnFourM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtInterestRateM.setText(txtInterestRateM.getText()+"4");
                    }
                });

                btnThreeM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtInterestRateM.setText(txtInterestRateM.getText()+"3");
                    }
                });

                btnTwoM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtInterestRateM.setText(txtInterestRateM.getText()+"2");
                    }
                });

                btnOneM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtInterestRateM.setText(txtInterestRateM.getText()+"1");
                    }
                });

                btnZeroM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtInterestRateM.setText(txtInterestRateM.getText()+"0");
                    }
                });

                btnNegativeM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtInterestRateM.setText(txtInterestRateM.getText()+"-");
                    }
                });

                btnPositiveM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtInterestRateM.setText(txtInterestRateM.getText()+"+");
                    }
                });

                btnDecimalM.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtInterestRateM.setText(txtInterestRateM.getText()+".");
                    }
                });
            }
        });
        Pane layoutMortgage = new Pane(mortgageMenu);
        layoutMortgage.setId("mortgageStyle");
        layoutMortgage.getStylesheets().addAll("style.css");
        layoutMortgage.getChildren().addAll(lblMortgageTitle,lblPrice,lblDownPayment,lblLoanTerm,lblInterestRateM,lblOutMortgageM,lblKeyBoard,
                txtPrice,txtDownPayment,txtLoanTerm,txtInterestRateM,btnCalculateMortgage,btnReset,btnBack,btnExitL,lblOutMortgage,
                btnSevenM,btnEightM,btnNineM,btnSixM,btnFiveM,btnFourM,btnThreeM,btnTwoM,btnOneM,btnZeroM,btnNegativeM,btnPositiveM,btnDecimalM);
        windowMortgage.setScene(new Scene(layoutMortgage,750,550));
        windowMortgage.show();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

    }


}
