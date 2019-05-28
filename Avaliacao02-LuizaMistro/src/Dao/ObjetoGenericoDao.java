/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.ObjetoGenerico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import Dao.BaseDao;
import Factory.Conexao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luiza Mistro
 */
public class ObjetoGenericoDao implements BaseDao<ObjetoGenerico> {
    
//  Exemplo de sintaxe correta de inner join  
//    
//    SELECT 
//    a.idAluno, 
//    a.nomeAluno, 
//    a.ativo, 
//    a.nomeDisciplina 
//FROM Aluno a
//    INNER JOIN Disciplina d
//        ON a.idDisciplina = d.idDisciplina
//        AND a.nomeDisciplina = d.nomeDisciplina
    
    

    private Connection con = Conexao.getConexao();
    private ResultSet rs;
    private PreparedStatement ps;

    @Override
    public List<ObjetoGenerico> listar() {
        return listar("atributo1", "asc");

    }

    public List<ObjetoGenerico> listar(String orderby, String ordenacao) {
        String sql = "Select atributos from nomeDaTabela where ativo = 1 order by " + orderby + " " + ordenacao;
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            List<ObjetoGenerico> list = new ArrayList<>();
            while (rs.next()) {
                ObjetoGenerico c = new ObjetoGenerico();
                c.setId(rs.getInt("id"));
                //   c.set[Atributo](rs.get[tipoVariavel]("nomeDaColunaNaTabela"));
                list.add(c);

            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int cadastrar(ObjetoGenerico obj) {
        String sql = "Insert into nomeTabela (atributo1, atributo2) values (?,?)";
        try {
            ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            // ps.setString(1, obj.getAtributo1());
            // ps.setString(2, obj.getAtributo2());
            ResultSet rs;
            if (ps.executeUpdate() > 0) {
                rs = ps.getGeneratedKeys();
                rs.next();
                return rs.getInt(1);
            } else {
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1;
    }

    @Override
    public boolean alterar(ObjetoGenerico obj) {
        try {
            ps = con.prepareStatement("update nomeTabela set atributo1 = ?, atributo2 = ? ,atributo3 = ? where id = ?");
//            ps.setString(1, obj.getatributo1());
//            ps.setString(4, obj.atributo1());
//            ps.setDate(5, new java.sql.Date(obj.getAtributo.getTime()));
            ps.setInt(7, obj.getId());
            int executeUpdate = ps.executeUpdate();
            return executeUpdate != 0;
        } catch (SQLException e) {
            System.out.println("Erro ao fazer update: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deletar(int id) {
        try {
            ps = con.prepareStatement("UPDATE nomeDaTabela SET ativo = 0 WHERE id = ? ");
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.out.println("Erro ao alterar 'ativo' para 0(Deletar objeto) " + ex.getMessage());
            return false;
        }

    }

    @Override
    public ObjetoGenerico procurarPorId(int id) {
        try {
            ps = con.prepareStatement("Select * from nomeDaTabela where id = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
  
            while (rs.next()) {
// Aqui é pegar os atributos do objeto pesquisado e por em variaveis
//                String placa = rs.getString("placa");
//                String cor = rs.getString("cor");
//                String modelo = rs.getString("modelo");
//                String marca = rs.getString("marca");
//                Date horaEntrada = rs.getDate("horaEntrada");
//                Date horaSaida = rs.getDate("horaSaida");

                
//Aqui criar novo objeto e setar os atributos pesquisados nele
//                Carro c = new Carro();
//                c.setId(id);
//                c.setMarca(marca);
//                c.setCor(cor);
//                c.setModelo(modelo);
//                c.setPlaca(placa);
//                c.setHoraEntrada(horaEntrada);
//                c.setHoraSaida(horaSaida);

//                return c;
            }
            return null;
        } catch (Exception e) {
            System.out.println("Erro ao pesquisar por id " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<ObjetoGenerico> pesquisar(String termo) {
         try {
            ps = con.prepareStatement("SELECT * FROM carro");
            rs = ps.executeQuery();
            List<ObjetoGenerico> lista = new ArrayList<>();
            while (rs.next()) {
                ObjetoGenerico c = new ObjetoGenerico();
                c.setId(rs.getInt("id"));
//            Aqui o programa cria novo objeto com os atributos do que ja ta no BD e adiciona na lista
//                c.setPlaca(rs.getString("placa"));
//                c.setCor(rs.getString("cor"));
//                c.setModelo(rs.getString("modelo"));
//                c.setMarca(rs.getString("marca"));
//                c.setHoraEntrada(rs.getDate("horaEntrada"));
//                c.setHoraSaida(rs.getDate("horaSaida"));
                lista.add(c);
            }
            return lista;
        } catch (SQLException ex) {
            System.out.println("Erro ao pesquisar todos " + ex.getMessage());
            return null;
    }
    }
}