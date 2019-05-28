/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex4.model;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Luiza Mistro
 */
public class Media {

    Double n1;
    Double n2;
    Double n3;

    public Media() {
    }

    public Media(Double n1, Double n2, Double n3) {
        this.n1 = n1;
        this.n2 = n2;
        this.n3 = n3;
    }

    public Double getN1() {
        return n1;
    }

    public void setN1(Double n1) {
        this.n1 = n1;
    }

    public Double getN2() {
        return n2;
    }

    public void setN2(Double n2) {
        this.n2 = n2;
    }

    public Double getN3() {
        return n3;
    }

    public void setN3(Double n3) {
        this.n3 = n3;
    }

    public Double CalculaMedia() {
        return (n1 + n2 + n3) / 3;
    }
}
