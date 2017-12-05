package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Controller2 extends Controller1 {

    @FXML
            Button button1;
    @FXML
            Button button2;
    @FXML
            Button ok;
    @FXML
            TextField textField1;
    @FXML
            TextField textField2;



    ArrayList<String> integerArrayList = new ArrayList();
    ArrayList<String> floatArrayList = new ArrayList<>();
    ArrayList<String> doubleArrayList = new ArrayList<>();
    char[] charsMassive = new char[11];

   private Integer buffer=0;
    //Scan operator sin and add to history memory buffer
    @FXML
    private void sin(ActionEvent event){
        if (textField.getText().isEmpty()==true){

        }else firstNumber=textField.getText();

        textField.setText("");
        String scanner = ((Button) event.getSource()).getText().toString();
        array=scanner;
        history(scanner);
    }
    //Scan operator cos and add to history memory buffer
    @FXML
    private void cos(ActionEvent event){
        if (textField.getText().isEmpty()==true){

        }else firstNumber=textField.getText();

        textField.setText("");
        String scanner = ((Button) event.getSource()).getText().toString();
        array=scanner;
        history(scanner);
    }
    //Scan operator tan and add to history memory buffer
    @FXML
    private void tan(ActionEvent event){
        if (textField.getText().isEmpty()==true){

        }else firstNumber=textField.getText();


        textField.setText("");
        String scanner = ((Button) event.getSource()).getText().toString();
        array=scanner;
        history(scanner);
    }
    //Scan operator ^ and add to history memory buffer
    @FXML
        private void pow(ActionEvent event){
        if (textField.getText().isEmpty()==true){

        }else firstNumber=textField.getText();


        textField.setText("");
        String scanner = ((Button) event.getSource()).getText().toString();
        array=scanner;
        history(scanner);
    }
    //Scan operator sqrt and add to history memory buffer
    @FXML
    private void sqrt(ActionEvent event){
        if (textField.getText().isEmpty()==true){

        }else firstNumber=textField.getText();


        textField.setText("");
        String scanner = ((Button) event.getSource()).getText().toString();
        array=scanner;
        history(scanner);
    }
    @FXML
    private void piNumber(ActionEvent event){
        String temp = textField.getText();
        temp+=3.14;
        textField.setText(temp);
        history("3.14");
    }
    //Scan operator M+ and copy to buffer named - buffer
    //Everytime when we use this operator we increment the number
    @FXML
    private   void mPlus() throws Exception {

        try {
            buffer+= Integer.parseInt(textField.getText());
        }catch (Exception e){
            System.out.println("Exception:"+e);
        }

      if (buffer!=0){
          button1.setDisable(false);
          button2.setDisable(false);
      }
    }
    //Scan operator M- and
    //This decrement number in buffer
    @FXML
    private void mMinus(){
        try {
            buffer-= Integer.parseInt(textField.getText());
        }catch (Exception e){
            System.out.println("Exception:"+e);
        }
    }
    //Show us number in this buffer
    @FXML
    private void mR(){
        textField.setText(buffer.toString());
    }
    //Clear this buffer
    @FXML
    private void mC(){
        buffer=0;
        if (buffer==0){
            button1.setDisable(true);
            button2.setDisable(true);
        }
    }
    //Work with button min(x,y)
    @FXML
    private void minimumOfNumbers() throws IOException {
        allDelete();
        label.setText("Please enter two numbers x and y and press ok ");
        textField.setVisible(false);
        textField1.setVisible(true);
        textField2.setVisible(true);
        ok.setVisible(true);
    }

    //this button appear when we click on button min(x,y)
    @FXML
    private void buttonOK(){
        if (textField1.getText()=="x"|| textField2.getText()=="y"){
            textField.setVisible(true);
            textField1.setVisible(false);
            textField2.setVisible(false);
            ok.setVisible(false);
            System.out.println("work");
        }else if(textField1.getText()!="x"|| textField2.getText()!="y"){
            Integer x = Integer.parseInt(textField1.getText());
            Integer y = Integer.parseInt(textField2.getText());
            label.setText("This is minimum of this numbers");
            textField1.setText("x");
            textField2.setText("y");
            textField.setVisible(true);
            textField1.setVisible(false);
            textField2.setVisible(false);
            ok.setVisible(false);
            if (x > y) {
                textField.setText(y.toString());
            } else if (x < y) {
                textField.setText(x.toString());
            }
        }
    }
    //Work with button in menu
    @FXML
    private void additionalTask() throws Exception{
        String  resulting = "Result is = {";
        File file = new File("C:\\Users\\fanto\\IdeaProjects\\2курс\\Rozrahunkova\\src\\files\\in.txt");
        Scanner scanner= new Scanner(file);
        int i=0;
        while (scanner.hasNext()){
            integerArrayList.add(scanner.next());
            doubleArrayList.add(scanner.next());
            floatArrayList.add((scanner.next()));
            charsMassive[i] = scanner.next().charAt(0);
            i++;
        }
        scanner.close();
        int[] intMassive = new int[integerArrayList.size()];
       for (int j = 1 ; j<integerArrayList.size(); j++){
            intMassive[j]= Integer.parseInt(integerArrayList.get(j));
       }
        Arrays.sort(intMassive);

        for (int a:intMassive){
            resulting+=a+",";
        }
        resulting+="}";


        File file1 = new File("C:\\Users\\fanto\\IdeaProjects\\2курс\\Rozrahunkova\\src\\files\\out.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(file1));
        writer.write(resulting);
        writer.close();
        label.setText("Result is saved in out.txt file");

        integerArrayList.clear();
        floatArrayList.clear();
        doubleArrayList.clear();

    }

}
