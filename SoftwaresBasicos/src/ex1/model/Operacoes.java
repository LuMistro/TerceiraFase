/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1.model;

import javax.swing.JOptionPane;

/**
 *
 * @author Luiza Mistro
 */
public class Operacoes {

    Numeros numeros;

    public Operacoes() {
    }

    public Operacoes(Numeros numeros) {
        this.numeros = numeros;
    }

    public Numeros getNumeros() {
        return numeros;
    }

    public void setNumeros(Numeros numeros) {
        this.numeros = numeros;
    }

    public double adicao() {
        double soma = numeros.getNum1() + numeros.getNum2();
        return soma;
    }

    public double subtracao() {
        return numeros.getNum1() - numeros.getNum2();
    }

    public double divisão() {

        if (numeros.getNum2() == 0) {
            JOptionPane.showMessageDialog(null, "Não existe divisão por 0");
        } else {
            return numeros.getNum1() / numeros.getNum2();

        }
        return 0;
    }

    public double multiplicacao() {
        return numeros.getNum1() * numeros.getNum2();
    }

}
