/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package senac.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import senac.interfaces.DaoI;
import senac.model.Produto;

/**
 *
 * @author Alunos
 */
public class ProdutoDao extends Dao implements DaoI<Produto>{

    public ProdutoDao() {
        //Contrutor da super classe Dao. Faz a conexão.
        super();
    }
    
    @Override
    public List<Produto> listar() {
        try{
            PreparedStatement stmt;
            stmt = conexao.prepareStatement("SELECT "
                    + "id, nome, valor FROM produto WHERE ativo=1 ORDER BY id ASC");
            ResultSet result = stmt.executeQuery();
            List<Produto> lista = new ArrayList<>();
            while(result.next()){
                Produto p = new Produto();
                p.setId(result.getInt("id"));
                p.setNome(result.getString("nome"));
                p.setValor(result.getDouble("valor"));
                lista.add(p);
            }
            return lista;
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }

    /**
     * Método para cadastrar um produto no banco de dados
     * <br>Retorna id do produto cadastrado
     * <br><b>Retorna 0 (zero) se houver erro</b>
     * @param obj
     * @return int
     */
    @Override
    public int cadastrar(Produto obj) {
        try{
            PreparedStatement stmt;
            stmt = conexao.prepareStatement(
                    "INSERT INTO produto(nome, valor)"
                            + " VALUES(?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, obj.getNome());
            stmt.setDouble(2, obj.getValor());
            ResultSet res;
            if (stmt.executeUpdate() > 0) {
                res = stmt.getGeneratedKeys();
                res.next();
                return res.getInt(1);
            } else {
                return 0;
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            return 0;
        }
    }

    @Override
    public boolean alterar(Produto obj) {
        try {
            PreparedStatement stmt = conexao.prepareStatement(""
                    + "UPDATE "
                    + "     produto "
                    + " SET "
                    + "     nome = ?, "
                    + "     valor = ? "
                    + " WHERE "
                    + "     id = ?");
            stmt.setString(1, obj.getNome());
            stmt.setDouble(2, obj.getValor());
            stmt.setInt(3, obj.getId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean deletar(int id) {
        try {
            PreparedStatement stmt = conexao.prepareStatement(""
                    + " UPDATE produto SET ativo = 0 "
                    + " WHERE id = ? ");
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public Produto lerPorId(int id) {
        try {
            PreparedStatement stmt = conexao.prepareStatement(""
                    + "SELECT id, nome, valor FROM produto "
                    + " WHERE ativo = 1 AND id = ?");
            stmt.setInt(1, id);
            ResultSet res = stmt.executeQuery();
            if(res.next()){
                Produto p = new Produto();
                p.setId(res.getInt("id"));
                p.setNome(res.getString("nome"));
                p.setValor(res.getDouble("valor"));
                return p;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        
        
    }

    @Override
    public List<Produto> pesquisar(String termo) {
        try {
            PreparedStatement stmt = conexao.prepareStatement(""
                    + "SELECT id, nome, valor FROM produto"
                    + " WHERE ativo=1 AND "
                    + " (id=? OR nome LIKE ? OR valor=?) ");
            stmt.setString(1, termo);
            stmt.setString(2, termo + "%");
            stmt.setString(3, termo);
            ResultSet res = stmt.executeQuery();
            List<Produto> lista = new ArrayList<>();
            while(res.next()){
                Produto p = new Produto();
                p.setId(res.getInt("id"));
                p.setNome(res.getString("nome"));
                p.setValor(res.getDouble("valor"));
                lista.add(p);
            }
            return lista;
        } catch (SQLException ex) {
            return null;
        }
        
    }
    
    
    
}
