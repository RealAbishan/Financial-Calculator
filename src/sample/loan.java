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

public class loan extends Application
{
    public static void main(String[] args)
    {

        launch(args);
    }

    public static void loanStage()
    {

        Stage windowLoan= new Stage();

        windowLoan.setTitle("Loan");

//Menu bar with the some navigating functionalities

        MenuBar loanMenu = new MenuBar();
        loanMenu.setStyle("-fx-pref-width: 750;"+
                "-fx-background-color: white;"+
                "-fx-font-weight: bold");

        Menu file = new Menu("Files");
        MenuItem menuSave = new MenuItem("Save");
        MenuItem menuExit = new MenuItem("Exit");
        file.getItems().addAll(menuSave,menuExit);

        Menu history  = new Menu("History");
        MenuItem menuHistory = new MenuItem("View History");
        history.getItems().addAll(menuHistory);

        loanMenu.getMenus().addAll(file,history);

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
                windowLoan.close();
            }
        };

        menuSave.setOnAction(eventSave);
        menuExit.setOnAction(eventExit);
        menuHistory.setOnAction(eventHistory);


//Labels and Text Fields in the loan Window

        Label lblLoanTitle = new Label("Loan Calculation");
        lblLoanTitle.setLayoutY(20);
        lblLoanTitle.setLayoutX(150);
        lblLoanTitle.setStyle("-fx-text-fill: white;"+
                "-fx-font-size:40px;"+
                "-fx-font-family:Papyrus;");

        Label lblAmount = new Label("Loan Amount:");
        lblAmount.setLayoutY(100);
        lblAmount.setLayoutX(50);
        lblAmount.setStyle("-fx-text-fill: white;"+
                "-fx-font-size:16px;");

        TextField txtAmount = new TextField("");
        txtAmount.setLayoutY(100);
        txtAmount.setLayoutX(150);
        txtAmount.setStyle("-fx-pref-width:325px;"+
                "-fx-background-radius: 15px;");



        Label lblLoanTerm = new Label("Loan Term:");
        lblLoanTerm.setLayoutY(150);
        lblLoanTerm.setLayoutX(50);
        lblLoanTerm.setStyle("-fx-text-fill: white;"+
                "-fx-font-size:16px;");

        TextField txtLoanTerm = new TextField("");
        txtLoanTerm.setLayoutY(150);
        txtLoanTerm.setLayoutX(150);
        txtLoanTerm.setStyle("-fx-pref-width:325px;"+
                "-fx-background-radius: 15px;");



        Label lblInterestRate = new Label("Interest Rate:");
        lblInterestRate.setLayoutY(200);
        lblInterestRate.setLayoutX(50);
        lblInterestRate.setStyle("-fx-text-fill: white;"+
                "-fx-font-size:16px;");

        Label lblPaymentIn = new Label("Payment For Every Month");
        lblPaymentIn.setLayoutY(350);
        lblPaymentIn.setLayoutX(50);
        lblPaymentIn.setStyle("-fx-text-fill: white;"+
                "-fx-font-size:22px;"+
                "-fx-font-family:'Agency FB';");

        Label lblTotalIn = new Label("Total Payments");
        lblTotalIn.setLayoutX(50);
        lblTotalIn.setLayoutY(400);
        lblTotalIn.setStyle("-fx-text-fill: white;"+
                "-fx-font-size:22px;"+
                "-fx-font-family:'Agency FB';");

        Label lblInterestIn = new Label("Total Interest");
        lblInterestIn.setLayoutY(450);
        lblInterestIn.setLayoutX(50);
        lblInterestIn.setStyle("-fx-text-fill: white;"+
                "-fx-font-size:22px;"+
                "-fx-font-family:'Agency FB';");

        Label lblPaymentOut = new Label("          ");
        lblPaymentOut.setLayoutX(250);
        lblPaymentOut.setLayoutY(350);
        lblPaymentOut.setStyle("-fx-text-fill: white;"+
                "-fx-font-size:22px;");

        Label lblTotalOut = new Label("         ");
        lblTotalOut.setLayoutY(400);
        lblTotalOut.setLayoutX(250);
        lblTotalOut.setStyle("-fx-text-fill: white;"+
                "-fx-font-size:22px;");

        Label lblInterestOut = new Label("        ");
        lblInterestOut.setLayoutX(250);
        lblInterestOut.setLayoutY(450);
        lblInterestOut.setStyle("-fx-text-fill: white;"+
                "-fx-font-size:22px;");

        TextField txtInterestRate = new TextField("");
        txtInterestRate.setLayoutX(150);
        txtInterestRate.setLayoutY(200);
        txtInterestRate.setStyle("-fx-pref-width:325px;"+
                "-fx-background-radius: 15px;");

        Label lblKeyBoard = new Label("OnScreen Key Board");
        lblKeyBoard.setLayoutX(500);
        lblKeyBoard.setLayoutY(100);
        lblKeyBoard.setStyle("-fx-text-fill: white;"+
                "-fx-font-size:22px;");

//Button controls of loan window

        Button btnBack = new Button("Back");
        btnBack.setLayoutY(500);
        btnBack.setLayoutX(50);
        btnBack.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 100px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;"+
                "-fx-pref-width: 150px;");
        btnBack.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage loanStage = (Stage)btnBack.getScene().getWindow();
                windowLoan.close();
                navigation.navigationStage();


            }
        });

        Button btnExit = new Button("Exit");
        btnExit.setLayoutY(500);
        btnExit.setLayoutX(500);
        btnExit.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 100px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;"+
                "-fx-pref-width: 150px;");
        btnExit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage loanStage = (Stage)btnExit.getScene().getWindow();
                windowLoan.close();


            }
        });

        Button btnReset = new Button("Reset");
        btnReset.setLayoutY(300);
        btnReset.setLayoutX(150);
        btnReset.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 100px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;"+
                "-fx-pref-width: 150px;");
        btnReset.setOnAction(event -> {
            txtAmount.clear();
            txtLoanTerm.clear();
            txtInterestRate.clear();
            lblPaymentOut.setText("");
            lblTotalOut.setText("");
            lblInterestOut.setText("");
        });

        Button btnCalculateLoan = new Button("Calculate");
        btnCalculateLoan.setLayoutX(325);
        btnCalculateLoan.setLayoutY(300);
        btnCalculateLoan.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 100px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;"+
                "-fx-pref-width: 150px;");
        btnCalculateLoan.setOnAction(e ->
        {
          try {
              double monthNo =12;
              double loanAmount = Double.parseDouble(txtAmount.getText());
              double loanTerm = Double.parseDouble(txtLoanTerm.getText());
              double loanInterest = Double.parseDouble(txtInterestRate.getText());

            //  double loanInterestOut = (loanInterest/12)/100;
              double paymentEveryMonth = ((loanInterest/12)/100* loanAmount)/(1 - Math.pow((1 +(loanInterest/12)/100 ), -monthNo*loanTerm));
              lblPaymentOut.setText(String.format("%.2f",paymentEveryMonth));

              double totalPayment =(paymentEveryMonth*loanTerm*12);
              lblTotalOut.setText(String.format("%.2f",totalPayment));

              double totalInterest =totalPayment-loanAmount;
              lblInterestOut.setText(String.format("%.2f",totalInterest));
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
        btnSevenL.setLayoutY(150);
        btnSevenL.setLayoutX(500);
        btnSevenL.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;");
        btnSevenL.setOnAction(event -> {
            txtAmount.setText((txtAmount.getText().concat("7")));

        });




        Button btnEightL = new Button("8");
        btnEightL.setLayoutX(550);
        btnEightL.setLayoutY(150);
        btnEightL.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;");
        btnEightL.setOnAction(event -> {
            txtAmount.setText((txtAmount.getText().concat("8")));

        });



        Button btnNineL = new Button("9");
        btnNineL.setLayoutY(150);
        btnNineL.setLayoutX(600);
        btnNineL.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;");
        btnNineL.setOnAction(event -> {
            txtAmount.setText((txtAmount.getText().concat("9")));

        });



        Button btnFourL = new Button("4");
        btnFourL.setLayoutY(200);
        btnFourL.setLayoutX(500);
        btnFourL.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;");
        btnFourL.setOnAction(event -> {
            txtAmount.setText((txtAmount.getText().concat("4")));

        });


        Button btnFiveL = new Button("5");
        btnFiveL.setLayoutX(550);
        btnFiveL.setLayoutY(200);
        btnFiveL.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;");
        btnFiveL.setOnAction(event -> {
            txtAmount.setText((txtAmount.getText().concat("5")));

        });

        Button btnSixL = new Button("6");
        btnSixL.setLayoutY(200);
        btnSixL.setLayoutX(600);
        btnSixL.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;");
        btnSixL.setOnAction(event -> {
            txtAmount.setText((txtAmount.getText().concat("6")));

        });




        Button btnOneL = new Button("1");
        btnOneL.setLayoutY(250);
        btnOneL.setLayoutX(500);
        btnOneL.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;");
        btnOneL.setOnAction(event -> {
            txtAmount.setText((txtAmount.getText().concat("1")));

        });


        Button btnTwoL = new Button("2");
        btnTwoL.setLayoutX(550);
        btnTwoL.setLayoutY(250);
        btnTwoL.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;");
        btnTwoL.setOnAction(event -> {
            txtAmount.setText((txtAmount.getText().concat("2")));

        });

        Button btnThreeL = new Button("3");
        btnThreeL.setLayoutY(250);
        btnThreeL.setLayoutX(600);
        btnThreeL.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;");
        btnThreeL.setOnAction(event -> {
            txtAmount.setText((txtAmount.getText().concat("3")));

        });


        Button btnZeroL = new Button("0");
        btnZeroL.setLayoutX(500);
        btnZeroL.setLayoutY(300);
        btnZeroL.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;"+
                "-fx-pref-width:75px;");
        btnZeroL.setOnAction(event -> {
            txtAmount.setText((txtAmount.getText().concat("0")));

        });

        Button btnDecimalL = new Button(".");
        btnDecimalL.setLayoutY(300);
        btnDecimalL.setLayoutX(600);
        btnDecimalL.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;");
        btnDecimalL.setOnAction(event -> {
            txtAmount.setText((txtAmount.getText().concat(".")));

        });


        Button btnPositiveL = new Button("+");
        btnPositiveL.setLayoutX(650);
        btnPositiveL.setLayoutY(150);
        btnPositiveL.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;"+
                "-fx-pref-height: 85px;");
        btnPositiveL.setOnAction(event -> {
            txtAmount.setText((txtAmount.getText().concat("+")));

        });


        Button btnNegativeL = new Button("-");
        btnNegativeL.setLayoutY(250);
        btnNegativeL.setLayoutX(650);
        btnNegativeL.setStyle("-fx-background-color: white;"+
                "-fx-background-radius: 200px;"+
                "-fx-font-family: Papyrus;"+
                "-fx-text-alignment: center;"+
                "-fx-pref-height: 85px;");
        btnNegativeL.setOnAction(event -> {
            txtAmount.setText((txtAmount.getText().concat("-")));

        });


//Event Handling For the On Screen Key Board
        //for Loan Amount
        txtAmount.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                btnSevenL.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtAmount.setText(txtAmount.getText()+"7");
                    }
                });

                btnEightL.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtAmount.setText(txtAmount.getText()+"8");
                    }
                });

                btnNineL.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtAmount.setText(txtAmount.getText()+"9");
                    }
                });

                btnSixL.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtAmount.setText(txtAmount.getText()+"6");
                    }
                });

                btnFiveL.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtAmount.setText(txtAmount.getText()+"5");
                    }
                });

                btnFourL.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtAmount.setText(txtAmount.getText()+"4");
                    }
                });

                btnThreeL.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtAmount.setText(txtAmount.getText()+"3");
                    }
                });

                btnTwoL.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtAmount.setText(txtAmount.getText()+"2");
                    }
                });

                btnOneL.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtAmount.setText(txtAmount.getText()+"1");
                    }
                });

                btnZeroL.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtAmount.setText(txtAmount.getText()+"0");
                    }
                });

                btnNegativeL.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtAmount.setText(txtAmount.getText()+"-");
                    }
                });

                btnPositiveL.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtAmount.setText(txtAmount.getText()+"+");
                    }
                });

                btnDecimalL.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtAmount.setText(txtAmount.getText()+".");
                    }
                });
            }
        });

//For Loan term

        txtLoanTerm.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                btnSevenL.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtLoanTerm.setText(txtLoanTerm.getText()+"7");
                    }
                });

                btnEightL.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtLoanTerm.setText(txtLoanTerm.getText()+"8");
                    }
                });

                btnNineL.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtLoanTerm.setText(txtLoanTerm.getText()+"9");
                    }
                });

                btnSixL.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtLoanTerm.setText(txtLoanTerm.getText()+"6");
                    }
                });

                btnFiveL.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtLoanTerm.setText(txtLoanTerm.getText()+"5");
                    }
                });

                btnFourL.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtLoanTerm.setText(txtLoanTerm.getText()+"4");
                    }
                });

                btnThreeL.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtLoanTerm.setText(txtLoanTerm.getText()+"3");
                    }
                });

                btnTwoL.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtLoanTerm.setText(txtLoanTerm.getText()+"2");
                    }
                });

                btnOneL.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtLoanTerm.setText(txtLoanTerm.getText()+"1");
                    }
                });

                btnZeroL.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtLoanTerm.setText(txtLoanTerm.getText()+"0");
                    }
                });

                btnNegativeL.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtLoanTerm.setText(txtLoanTerm.getText()+"-");
                    }
                });

                btnPositiveL.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtLoanTerm.setText(txtLoanTerm.getText()+"+");
                    }
                });

                btnDecimalL.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtLoanTerm.setText(txtLoanTerm.getText()+".");
                    }
                });
            }
        });

//For the Interest Rate

        txtInterestRate.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                btnSevenL.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtInterestRate.setText(txtInterestRate.getText()+"7");
                    }
                });

                btnEightL.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtInterestRate.setText(txtInterestRate.getText()+"8");
                    }
                });

                btnNineL.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtInterestRate.setText(txtInterestRate.getText()+"9");
                    }
                });

                btnSixL.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtInterestRate.setText(txtInterestRate.getText()+"6");
                    }
                });

                btnFiveL.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtInterestRate.setText(txtLoanTerm.getText()+"5");
                    }
                });

                btnFourL.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtInterestRate.setText(txtInterestRate.getText()+"4");
                    }
                });

                btnThreeL.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtInterestRate.setText(txtInterestRate.getText()+"3");
                    }
                });

                btnTwoL.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtInterestRate.setText(txtInterestRate.getText()+"2");
                    }
                });

                btnOneL.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtInterestRate.setText(txtInterestRate.getText()+"1");
                    }
                });

                btnZeroL.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtInterestRate.setText(txtInterestRate.getText()+"0");
                    }
                });

                btnNegativeL.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtInterestRate.setText(txtInterestRate.getText()+"-");
                    }
                });

                btnPositiveL.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtInterestRate.setText(txtInterestRate.getText()+"+");
                    }
                });

                btnDecimalL.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtInterestRate.setText(txtInterestRate.getText()+".");
                    }
                });
            }
        });


//Layout of the Loan Window Pane has been used to contain the layout

        Pane layoutLoans = new Pane(loanMenu);
        layoutLoans.setId("loanStyle");
        layoutLoans.getChildren().addAll(lblLoanTitle,lblAmount,lblLoanTerm,lblInterestRate,lblPaymentOut,lblTotalOut,lblKeyBoard,
                lblInterestOut,lblInterestIn,lblPaymentIn,lblTotalIn,txtAmount,txtLoanTerm,txtInterestRate,btnBack,btnCalculateLoan,
                btnReset,btnExit,btnNineL,btnEightL,btnSevenL,btnSixL,btnFiveL,btnFourL,btnThreeL,btnTwoL,btnOneL,
                btnZeroL,btnNegativeL,btnPositiveL,btnDecimalL);
        layoutLoans.getStylesheets().addAll("style.css");
        windowLoan.setScene(new Scene(layoutLoans,750,550));
        windowLoan.show();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

    }
}
