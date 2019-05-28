/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package senac.uteis;

import javax.swing.JTextField;

/**
 * Classe para realizar validação de dados
 * @version 1.0
 * @author Renato Paranaguá
 */
public class Validacao {
     
    public static boolean campoVazio(JTextField tf){
        return tf.getText().trim().isEmpty();
    }
    
}
