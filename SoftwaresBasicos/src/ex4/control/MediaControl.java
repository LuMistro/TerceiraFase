/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex4.control;

import ex4.model.Media;
import ex4.view.FramePrincipal;
import java.awt.Color;

/**
 *
 * @author Luiza Mistro
 */
public class MediaControl {

    Media m = new Media();

    public void pegaNumeros() {
        m.setN1(new Double(FramePrincipal.tfNota1.getText()));
        m.setN2(new Double(FramePrincipal.tfNota2.getText()));
        m.setN3(new Double(FramePrincipal.tfNota3.getText()));
    }

    public void calculaMediaAction() {
        pegaNumeros();
        m.CalculaMedia();
        AlteraCorLabelDeAcordoComMedia();
    }

    public void AlteraCorLabelDeAcordoComMedia() {
        Double media = m.CalculaMedia();
        FramePrincipal.lbMediaFinal.setText(media.toString());

        FramePrincipal.lbSituacao.setOpaque(true);
        if (media >= 7) {
            FramePrincipal.lbSituacao.setText("Aprovado");
            FramePrincipal.lbSituacao.setBackground(Color.GREEN);
        } else {
            FramePrincipal.lbSituacao.setText("Reprovado");
            FramePrincipal.lbSituacao.setBackground(Color.RED);
        }
    }

}
