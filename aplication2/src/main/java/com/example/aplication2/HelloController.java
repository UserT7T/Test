package com.example.aplication2;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
public class HelloController {
    @FXML

    private Label result;

    private float number1=0;

    private float number2=0;

    private String operator="";

    private boolean start=true;

    private Calclulate calculate=new Calclulate();

    @FXML
    private Button btn1,btn2;



    @FXML
    private TextField aTextField;

    @FXML
    private TextField bTextField;

    @FXML
    private TextField cTextField;

    @FXML
    private Label resLabel;

    private void calc(double a, double b, double c){
        double discriminant =Math.pow(b, 2) - 4 * a * c;
        String filePath = "result";
        if (discriminant >= 0) {
            double x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            DecimalNumber root1 = new DecimalNumber(x1);
            DecimalNumber root2 = new DecimalNumber(x2);
            resLabel.setText("x1 = " + root1 + ", x2 = " + root2);


            try {
                FileWriter writer = new FileWriter(filePath, true);
                BufferedWriter bufferWriter = new BufferedWriter(writer);
                bufferWriter.write(String.valueOf(root1));
                bufferWriter.write(String.valueOf(root2));
                bufferWriter.write("\n");
                bufferWriter.close();
            }
            catch (IOException e) {
                System.out.println(e);
            }

        } else {
            double real = -b / (2 * a);
            double imaginary = Math.sqrt(-discriminant) / (2 * a);
            ComplexNumber root1 = new ComplexNumber(real, imaginary);
            ComplexNumber root2 = new ComplexNumber(real, -imaginary);
            resLabel.setText("x1 = " + root1 + ", x2 = " + root2);
            try {
                FileWriter writer = new FileWriter(filePath, true);
                BufferedWriter bufferWriter = new BufferedWriter(writer);
                bufferWriter.write(String.valueOf(root1));
                bufferWriter.write(String.valueOf(root2));
                bufferWriter.write("\n");
                bufferWriter.close();
            }
            catch (IOException e) {
                System.out.println(e);
            }

        }
    }

    @FXML
    public void CalcBtn(){
        double a = Double.parseDouble(aTextField.getText());
        double b = Double.parseDouble(bTextField.getText());
        double c = Double.parseDouble(cTextField.getText());
        calc(a,b,c);
    }


    @FXML
    public void processNumber(ActionEvent event){
        if(start){
            result.setText("");
            start=false;
        }
        String value=((Button)event.getSource()).getText();
        if((!result.getText().equals("Деление на ноль!"))&&(!result.getText().equals("Корень из отрицательного числа!"))){
        result.setText(result.getText()+ value);}
    }
    public void processComma(ActionEvent event){
        if(start){
            result.setText("");
            start=false;
        }
        String value=((Button)event.getSource()).getText();
        if(!result.getText().contains(".")&&(!result.getText().equals("Корень из отрицательного числа!"))&&(!result.getText().equals("Деление на ноль!"))&&(!result.getText().isEmpty())){
        result.setText(result.getText()+ value);}
    }
    @FXML
    public void processBinaryOperator(ActionEvent event) {
        String value=((Button)event.getSource()).getText();
        if(!value.equals("=")){
            if(!operator.isEmpty())
                return;
            operator = value;
            if((!result.getText().equals("Деление на ноль!"))&&(!result.getText().equals("Корень из отрицательного числа!"))&&(!result.getText().isEmpty())){
            number1=Float.parseFloat(result.getText());
            result.setText("");}
        }else {
            if(operator.isEmpty())
                return;
            if((!result.getText().equals("Деление на ноль!"))&&(!result.getText().equals("Корень из отрицательного числа!"))&&(!result.getText().isEmpty())) {
            number2=Float.parseFloat(result.getText());
                float output = calculate.calculateBinaryNumber(number1, number2, operator);
                if ((operator.equals("÷")) && (number2 == 0.0)) {
                    result.setText("Деление на ноль!");
                    operator = "";
                } else {
                    result.setText(String.valueOf(output));
                    operator = "";
                }
            }
        }

    }
    @FXML
    public void processUnaryOperator(ActionEvent event) {
        String value=((Button)event.getSource()).getText();
        if(!operator.isEmpty())
            return;
        operator = value;
        if((!result.getText().equals("Деление на ноль!"))&&(!result.getText().equals("Корень из отрицательного числа!"))&&(!result.getText().isEmpty())){
        number1=Float.parseFloat(result.getText());
        result.setText("");

        float output=calculate.calculateUnaryNumber(number1,operator);
        if((operator.equals("√"))&&(number1<0)){
            operator="";
            result.setText("Корень из отрицательного числа!");
        }

        else {
        result.setText(String.valueOf(output));
        operator="";}
        }
    }
    @FXML
    public void ClearFunction(ActionEvent event){
        operator="";
        start=true;
        result.setText("");
    }
   @FXML
    public void BackSpace(ActionEvent event){
       String value=((Button)event.getSource()).getText();
       String str=result.getText()+ value;
       if((result.getText().length()!=0)&&(!result.getText().equals("Деление на ноль!"))&&(!result.getText().equals("Корень из отрицательного числа!"))&&(!result.getText().isEmpty())){
       result.setText(str.substring(0,result.getText().length()-1));}
    }


    @FXML
    public void processNegate( ) {
        if((!result.getText().equals("Деление на ноль!"))&&(!result.getText().equals("Корень из отрицательного числа!"))&&(!result.getText().isEmpty())){
            number1=Float.parseFloat(result.getText());
            result.setText("");

            float output=calculate.calculateNegate(number1,operator);
                result.setText(String.valueOf(output));

        }



    }


    @FXML
    private void handleButtonAction (ActionEvent event) throws Exception {


        if(event.getSource()==btn1){
            Parent newRoot = FXMLLoader.load(getClass().getResource("FXML2.fxml"));
            btn1.getScene().setRoot(newRoot);

        }
        else{
            Parent newRoot = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
            btn2.getScene().setRoot(newRoot);

        }

    }



    }




