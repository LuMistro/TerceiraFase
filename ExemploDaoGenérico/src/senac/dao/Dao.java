/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package senac.dao;

import java.sql.Connection;
import java.util.List;
import senac.factory.Conexao;
import senac.interfaces.DaoI;
import senac.model.Produto;

/**
 *
 * @author Alunos
 */
public class Dao {
    protected Connection conexao;

    public Dao() {
        conexao = Conexao.getConexao();
    }
    
}
