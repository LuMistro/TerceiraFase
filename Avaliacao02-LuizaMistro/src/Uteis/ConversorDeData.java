/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Uteis;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Clony
 */
public class ConversorDeData {

    public static java.sql.Date dataUtilParaSql(java.util.Date data) {
        return new java.sql.Date(data.getTime());
    }

    /**
     * Converte uma data vinda no formato do banco de dados
     *
     * @param data
     * @return data no formato dd/MM/yyyy
     */
    public static String dataBancoParaUsuario(java.sql.Date data) {
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        return formatador.format(data);
    }

    /**
     * Converte uma data vinda no formato de string do usuário
     *
     * @param data
     * @return data no formato do banco de dados
     */
    public static java.sql.Date dataUsuarioParaBanco(String data) {
        try {
            SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date dataUtil = formatador.parse(data);
            return new java.sql.Date(dataUtil.getTime());
        } catch (ParseException ex) {
            System.out.println("Erro ao converter data");
            return null;
        }

    }

    /**
     * Retorna a data atual convertida em String no formato dd/MM/yyyy
     *
     * @return
     */
    public static String dataAtual() {
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date dataUtil = new java.util.Date();
        return formatador.format(dataUtil);
    }

}
