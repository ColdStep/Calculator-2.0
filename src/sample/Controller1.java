package sample;


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.io.IOException;


public class Controller1 {





    @FXML
    TextField textField;
    @FXML
    Label label;


    static String copybuffer="";
    String historyArray ="";
    String array="";
    String result;
    String firstNumber="";
    String secondNumber="";

    

    double r = 0;


    //Scan numbers and add to history memory buffer
    public void initializeNumbers(ActionEvent event) {

        String scanner = ((Button) event.getSource()).getText().toString();
        history(scanner);
        textField.setText(textField.getText()+scanner);



    }



    //Scan operator plus and add to history memory buffer
    public void plus(ActionEvent event){

        if (textField.getText().isEmpty()==true){

        }else firstNumber=textField.getText();


        textField.setText("");
        String scanner = ((Button) event.getSource()).getText().toString();
        array=scanner;
        history(scanner);




    }

    //Scan operator minus and add to history memory buffer
    public void minus(ActionEvent event){
        if (textField.getText().isEmpty()==true){

        }else firstNumber=textField.getText();
        textField.setText("");
        String scanner = ((Button) event.getSource()).getText().toString();
        history(scanner);
        array=scanner;


    }
    //Scan operator multiply and add to history memory buffer
    public void multiply(ActionEvent event){
        if (textField.getText().isEmpty()==true){

        }else firstNumber=textField.getText();
        textField.setText("");
        String scanner = ((Button) event.getSource()).getText().toString();
        history(scanner);
        array=scanner;

    }
    //Scan operator divide and add to history memory buffer
    public void divide(ActionEvent event) {
        if (textField.getText().isEmpty()==true){

        }else firstNumber=textField.getText();
        textField.setText("");
        String scanner = ((Button) event.getSource()).getText().toString();
        history(scanner);
        array=scanner;


    }
    //Equal-finish operates
    public void equal(ActionEvent event){
        String scanner = ((Button) event.getSource()).getText().toString();
        matematika(array);
        history(scanner);
        labelView();
        switch (result){
            case "Can't divide by zero":
                textField.setText(result);
                clearHistory();
                break;
            default:
                String string = result;
                historyArray+=string;
                labelView();
                textField.setText(result);

                break;
        }

    }

    //Clean memory buffer and visual effects
    public void allDelete(){
        clearHistory();
        labelView();
        textField.setText("");

    }
    //Clean last symbols
    public void buttonDelete() {
        String temp = textField.getText();
        char[] charTemp= temp.toCharArray();
        temp="";
        for (int i=0; i<charTemp.length-1; i++){

            temp+=charTemp[i];
        }
        char[] charHistoryArray= historyArray.toCharArray();
        if (charHistoryArray[charHistoryArray.length-1]=='+'||charHistoryArray[charHistoryArray.length-1]=='-'||charHistoryArray[charHistoryArray.length-1]=='/'||charHistoryArray[charHistoryArray.length-1]=='*'){
            array="";
        }
        historyArray="";
        for ( int i=0; i<charHistoryArray.length-1; i++){
            history(String.valueOf(charHistoryArray[i]));
        }
        textField.setText(temp);

    }

    //Memory buffer
    public void history(String count) {
        historyArray += count;
        labelView();
    }

    //Logic of matematik operations
    private void matematika(String operator){
        secondNumber=textField.getText();
        switch (operator) {
            case "+":
                r = Double.parseDouble(firstNumber) + Double.parseDouble(secondNumber);
                result = String.valueOf(r);
                break;

            case "-":
                r = Double.parseDouble(firstNumber) - Double.parseDouble(secondNumber);
                result = String.valueOf(r);
                break;

            case "*":
                r =Double.parseDouble(firstNumber) * Double.parseDouble(secondNumber);
                result = String.valueOf(r);
                break;

            case "/":
                switch (secondNumber){
                   case "0":
                       result= "Can't divide by zero";
                       break;
                    default:
                        r = Double.parseDouble(firstNumber) / Double.parseDouble(secondNumber);
                        result = String.valueOf(r);
                        break;

                    }
               break;

           case "sin":
               if (firstNumber.isEmpty())
               {
                   r=Math.sqrt(Double.parseDouble(secondNumber));
               } else r=Math.sqrt(Double.parseDouble(firstNumber));
               result=String.valueOf(r);
               break;
           case "cos":
               if (firstNumber.isEmpty())
               {
                   r=Math.sqrt(Double.parseDouble(secondNumber));
               } else r=Math.sqrt(Double.parseDouble(firstNumber));
               result=String.valueOf(r);
               break;
           case "tan":
               if (firstNumber.isEmpty())
               {
                   r=Math.sqrt(Double.parseDouble(secondNumber));
               } else r=Math.sqrt(Double.parseDouble(firstNumber));
               result=String.valueOf(r);
               break;
           case "sqrt":
               if (firstNumber.isEmpty())
               {
                   r=Math.sqrt(Double.parseDouble(secondNumber));
               } else r=Math.sqrt(Double.parseDouble(firstNumber));
               result=String.valueOf(r);
               break;
           case "^":
               r=Math.pow(Double.parseDouble(firstNumber),Double.parseDouble(secondNumber));
               result=String.valueOf(r);
               break;
            case ">>1" :
                result=String.valueOf((Integer.parseInt(firstNumber)>>1));
               default:
               break;
       }
    }

    //Clear memory buffer
    public void clearHistory(){
        historyArray = "";
        firstNumber="";
        secondNumber="";
        result="";
        array="";

    }

    //Show history on the screen
    @FXML
    private void labelView(){
        label.setText(historyArray);
    }
    //Class simple and scientific work with menuitem button Simple and Scientific
    //and open calculator

    @FXML
    private void simple() throws Exception {
        setControl("simple.fxml");
    }
    @FXML
    private void scientific() throws Exception {
        setControl("scientific.fxml");
    }


        private void setControl(String fxmlFile) throws Exception {

        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource(fxmlFile));
        Scene scene = new Scene(root,400,533);
        stage.setTitle("Scientific calculator");
        stage.setScene(scene);
        stage.show();


    }
    //Open menuitem open
    @FXML
        private void fileOpener() throws IOException {
        File file = new File("C:\\Users\\fanto\\IdeaProjects\\2курс\\Rozrahunkova\\src\\files\\in.txt");
        Desktop.getDesktop().open(file);
        
    }
    //Copy data in  textfield
    @FXML
        private void copy() {
      //  textField.copy(); this method work incorrect
        copybuffer=textField.getText();
    }
    //Paste data in textfield
    @FXML
        private void paste(){
        //textField.paste();like this
        if(textField.getText().isEmpty()) textField.setText(copybuffer);

    }
    //Cut data in textfield
    @FXML
        private void cut(){
        //textField.cut(); and this
        copybuffer=textField.getText();
        textField.clear();

    }
    //This class open menuitem about
    @FXML
        private void about() throws Exception {

        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("about.fxml"));
        Scene scene = new Scene(root,600,400);
        stage.setTitle("About");
        stage.setScene(scene);
        stage.show();

    }
    //Close program
    public void closeButtonAction(){
        Platform.exit();
    }



}
