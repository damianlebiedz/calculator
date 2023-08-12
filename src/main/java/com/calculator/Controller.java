package com.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private TextField txtField;
    private double num1;
    private boolean isOperatorPressed = false;
    private String operator = "";

    @FXML
    private void number(ActionEvent event) {
        String numberPressed = ((Button) event.getSource()).getText();
        if(isOperatorPressed) {
            txtField.clear();
            isOperatorPressed = false;
        }
        if(!txtField.getText().equals("0")) {
            txtField.setText(txtField.getText()+numberPressed);
        }
        else txtField.setText(numberPressed);
    }

    @FXML
    private void operator(ActionEvent event) {
        String operatorPressed = ((Button) event.getSource()).getText();
        if(operatorPressed.equals("=")) {
            if(operator.isEmpty()) {
                return;
            }
            double num2 = Double.parseDouble(txtField.getText());
            txtField.setText(""+calculate(operator, num1, num2));
            operator = "";
        }
        if(operatorPressed.equals("C")) {
            txtField.setText("0");
            num1 = 0;
            operator = "";
        }
        else {
            num1 = Double.parseDouble(txtField.getText());
            operator = operatorPressed;
        }
        isOperatorPressed = true;
    }

    public double calculate(String operator, double num1, double num2) {
        double result = 0;
        switch(operator) {
            case "+" -> result = num1 + num2;
            case "-" -> result = num1 - num2;
            case "÷" -> result = num1 / num2;
            case "x" -> result = num1 * num2;
        }
        return result;
    }
}