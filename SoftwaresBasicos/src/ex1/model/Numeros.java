/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1.model;

/**
 *
 * @author Luiza Mistro
 */
public class Numeros {

    private double num1;
    private double num2;

    public Numeros() {
    }

    public Numeros(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public double getNum1() {
        return num1;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public double getNum2() {
        return num2;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    @Override
    public String toString() {
        return "Numero1: " + num1 + "  Numero2: " + num2; //To change body of generated methods, choose Tools | Templates.
    }

}
