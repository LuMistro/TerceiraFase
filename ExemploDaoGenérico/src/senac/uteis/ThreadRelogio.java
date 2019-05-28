/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package senac.uteis;

import java.text.SimpleDateFormat;
import java.util.Date;
import senac.view.Gerenciar;

/**
 *
 * @author Luiza Mistro
 */
public class ThreadRelogio {

    public static boolean play = true;

    public static void start() {
        new Thread() {
            public void run() {
                while (play) {
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy H:m:s");
                    Date data = new Date();
                    Gerenciar.lblHorario.setText(sdf.format(data));
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                    }
                }
                run();
            }
        }.start();
    }
}
