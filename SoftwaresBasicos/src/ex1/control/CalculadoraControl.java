/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1.control;

import ex1.model.Numeros;
import ex1.model.Operacoes;
import ex1.view.Calculadora;

/**
 *
 * @author Luiza Mistro
 */
public class CalculadoraControl {

    private double n1;
    private double n2;
    private Operacoes o;
    double resultado;

    public Numeros setarNumeros() {
        Numeros n = new Numeros(new Double(Calculadora.jTextField1.getText()), new Double(Calculadora.jTextField2.getText()));
        return n;
    }

    public void adicaoAction() {
        try {
            o = new Operacoes(setarNumeros());
            resultado = o.adicao();
            Calculadora.jLabel2.setText("" + resultado);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public void subtracaoAction() {
        try {
            o = new Operacoes(setarNumeros());
            resultado = o.subtracao();
            Calculadora.jLabel2.setText("" + resultado);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void multiplicacaoAction() {
        try {
            o = new Operacoes(setarNumeros());
            resultado = o.multiplicacao();
            Calculadora.jLabel2.setText("" + resultado);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void divisaoAction() {
        try {
            o = new Operacoes(setarNumeros());
            resultado = o.divisão();
            Calculadora.jLabel2.setText("" + resultado);

        } catch (Exception e) {
        }
    }
}
