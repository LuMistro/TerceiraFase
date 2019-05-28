/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex2.control;

import ex2.model.Texto;
import ex2.view.FramePrincipal;

/**
 *
 * @author Luiza Mistro
 */
public class TextoAction {

    Texto tela;

    public TextoAction() {
        tela = new Texto();
    }

    public void pegaDados() {
        tela.setCampo1(FramePrincipal.tfcampo1.getText());
    }

    public void mandaTela() {
        FramePrincipal.tfcampo2.setText(tela.getCampo1());
    }

    public void escreverAction() {
        pegaDados();
        mandaTela();

    }

}
