/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package senac.uteis;

import javax.swing.JOptionPane;

/**
 *
 * @author Alunos
 */
public class Painel {
    
    public static void msg(String texto){
        JOptionPane.showMessageDialog(null, texto);
    }
    
    public static Integer questao(String pergunta){
    return JOptionPane.showConfirmDialog(null, pergunta);
    }
}
