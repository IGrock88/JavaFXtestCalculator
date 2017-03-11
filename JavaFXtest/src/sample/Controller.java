package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class Controller {

    final static int MAX_NUMBERS_IN_DISPLAY = 20;
    final static int STATE_0 = 0;
    final static int STATE_1 = 1;
    final static int STATE_2 = 2;
    final static int STATE_3 = 3;

    static double tmpNumber = 0.0d;
    static double result = 0.0d;
    static String operand;

    static int state = STATE_0;

    public Label display;
    public static Button button1;

    public void insertNumber1(ActionEvent actionEvent) {
        insertNumber("1");
    }
    public void insertNumber2(ActionEvent actionEvent) {
        insertNumber("2");
    }
    public void insertNumber3(ActionEvent actionEvent) {
        insertNumber("3");
    }
    public void insertNumber4(ActionEvent actionEvent) {
        insertNumber("4");
    }
    public void insertNumber5(ActionEvent actionEvent) {
        insertNumber("5");
    }
    public void insertNumber6(ActionEvent actionEvent) {
        insertNumber("6");
    }
    public void insertNumber7(ActionEvent actionEvent) {
        insertNumber("7");
    }
    public void insertNumber8(ActionEvent actionEvent) {
        insertNumber("8");
    }
    public void insertNumber9(ActionEvent actionEvent) {
        insertNumber("9");
    }
    public void insertNumber0(ActionEvent actionEvent) {
        insertNumber("0");
    }
    public void insertAdd(ActionEvent actionEvent) {
        insertOperand("+");
    }
    public void insertSub(ActionEvent actionEvent) {
        insertOperand("-");
    }
    public void insertMul(ActionEvent actionEvent) {
        insertOperand("*");
    }
    public void insertDev(ActionEvent actionEvent) {
        insertOperand("/");
    }
    public void insertResult(ActionEvent actionEvent) {
        if(state != STATE_0){
            calculation();
            state = STATE_0;
        }

    }
    public void insertDot(ActionEvent actionEvent) {
        insertNumber(".");
    }
    public void reset(ActionEvent actionEvent){
        display.setText("0");
        tmpNumber = 0.0d;
        result = 0.0d;
        state = STATE_0;
    }
    public void insertNumber(String insertingBut){
        if(state == STATE_1){
            display.setText("");
            state = STATE_2;
        }
        String displayText = display.getText();
        if(displayText.equals("0")) {
            if (insertingBut.equals(".")) {
                putInDisplay(displayText, insertingBut);
            }else{
                display.setText(insertingBut);
            }
        }else if (displayText.contains(".")){
            if(!insertingBut.equals(".")){
                putInDisplay(displayText, insertingBut);
            }
        }else {
            putInDisplay(displayText, insertingBut);
        }
    }
    public void putInDisplay(String displayText, String insertingBut){

        if(displayText.length() < MAX_NUMBERS_IN_DISPLAY){
            display.setText(displayText + insertingBut);
        }
    }

    public void insertOperand(String tmpOperand){
        if(state == STATE_0){
            try {
                tmpNumber = Double.parseDouble(display.getText());
                display.setText(tmpOperand);
                operand = tmpOperand;
                state = STATE_1;
            }catch (NumberFormatException e){
            }
        }
        if(state == STATE_1){
            operand = tmpOperand;
            display.setText(tmpOperand);
        }
        if(state == STATE_2){

             calculation();
            operand = tmpOperand;
        }



    }

    public void calculation() throws NumberFormatException{
        if(operand.equals("+")){
            if(state == STATE_1){
                result = tmpNumber + tmpNumber;
                tmpNumber = result;
            }
            if(state == STATE_2){
                result = tmpNumber + Double.parseDouble(display.getText());
                tmpNumber = result;
                state = STATE_1;
            }
            if(state == STATE_3){
                tmpNumber = Double.parseDouble(display.getText());
                result = tmpNumber + result;
            }
        }
        if(operand.equals("-")){
            if(state == STATE_1){
                result = tmpNumber - tmpNumber;
                tmpNumber = result;
            }
            if(state == STATE_2){
                result = tmpNumber - Double.parseDouble(display.getText());
                tmpNumber = result;
                state = STATE_1;
            }
            if(state == STATE_3){
                tmpNumber = Double.parseDouble(display.getText());
                result = tmpNumber - result;
            }

        }
        if(operand.equals("*")){
            if(state == STATE_1){
                result = tmpNumber * tmpNumber;
                tmpNumber = result;
            }
            if(state == STATE_2){
                result = tmpNumber * Double.parseDouble(display.getText());
                tmpNumber = result;
                state = STATE_1;
            }
            if(state == STATE_3){
                tmpNumber = Double.parseDouble(display.getText());
                result = tmpNumber * result;
            }

        }
        if(operand.equals("/")){
            if(state == STATE_1){
                result = tmpNumber / tmpNumber;
                tmpNumber = result;
            }
            if(state == STATE_2){
                try {
                    result = tmpNumber / Double.parseDouble(display.getText());
                    tmpNumber = result;
                }catch (ArithmeticException e){
                    display.setText("На ноль делить нельзя");
                    state = STATE_0;
                }

            }
            if(state == STATE_3){
                tmpNumber = Double.parseDouble(display.getText());
                result = tmpNumber / result;
            }

        }

        display.setText(String.valueOf(result));
    }





}
