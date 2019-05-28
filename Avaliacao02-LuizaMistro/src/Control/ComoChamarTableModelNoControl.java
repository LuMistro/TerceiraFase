/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import AbstractTableModel.ObjetoTableModel;
import Dao.ObjetoGenericoDao;
import Model.ObjetoGenerico;

/**
 *
 * @author Luiza Mistro
 */
public class ComoChamarTableModelNoControl {

    ObjetoTableModel objetoTableModel;
    ObjetoGenericoDao dao;
//    ObjetoGenericoDao2 dao2;

    public ComoChamarTableModelNoControl() {  /////CONSTRUTOR DA CLASSE
        dao = new ObjetoGenericoDao();
//      dao2 = new ObjetoGenericoDao2();
        objetoTableModel = new ObjetoTableModel();
//      carregarComboBox();
//      FramePrincipal.NomeTabela.setModel(objetoTableModel); ///Estou setando o modelo na tabela
        objetoTableModel.adicionar(dao.listar());
    }
}