/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex3.control;

import ex3.view.FramePrincipal;
import ex3.model.Tela;

/**
 *
 * @author Luiza Mistro
 */
public class Control {

    Tela tela;

    public Control() {
        tela = new Tela();
    }

    public void pegaDados() {
        tela.setCampo1(FramePrincipal.jTextArea1.getText());
    }

    public void filtroNumero() {
        String concatena = "";
        concatena += tela.getCampo1();
        tela.setCampo2(concatena.replaceAll("[^0-9]", ""));
        concatena = "";
    }

    public void mandaTela() {
        FramePrincipal.jTextArea2.setText(tela.getCampo2());
    }

    
    public void escreverAction() {
        pegaDados();
        filtroNumero();
        mandaTela();

    }
}
