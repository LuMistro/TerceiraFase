/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex6.control;

import ex6.model.Botao;
import ex6.view.Tela1Botao;
import java.util.Random;

/**
 *
 * @author Luiza Mistro
 */
public class BotaoAction {

    Botao b = new Botao();
    Random r = new Random();

    public void pegaDados() {
        b.setX(Tela1Botao.botao.getX());
        b.setY(Tela1Botao.botao.getY());
    }

    public void geraPosicaoAleatoria() {
        pegaDados();
        int x = r.nextInt(1297);
        int y = r.nextInt(679);
        b.setX(x);
        b.setY(y);

        Tela1Botao.botao.setLocation(b.getX(), b.getY());
        System.out.println("x = " + b.getX() + " y: " + b.getY());
    }
}
