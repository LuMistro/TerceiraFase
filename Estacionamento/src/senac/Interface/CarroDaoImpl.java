/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package senac.Interface;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import senac.Interface.CarroDao;
import senac.model.Carro;

/**
 *
 * @author Luiza Mistro
 */
public class CarroDaoImpl implements CarroDao {

    Carro carro;
    List<Carro> carros;
    CarroDao carrodao;
    Connection con;
    PreparedStatement statement;
    ResultSet rs;
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public CarroDaoImpl() {
    }

    private static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost/estacionamento?zeroDateTimeBehavior=round", "root", "");
    }

    @Override
    public boolean inserir(Object objeto) {
        Carro c = (Carro) objeto;
        try {
            con = getConnection();
            statement = con.prepareStatement("insert into carro(placa,cor,marca, modelo ,horaEntrada, ativo) values(?,?,?,?,?, ?)", Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, c.getPlaca());
            statement.setString(2, c.getCor());
            statement.setString(3, c.getMarca());
            statement.setString(4, c.getModelo());
            statement.setDate(5, new java.sql.Date(c.getHoraEntrada().getTime()));
            statement.setInt(6, c.getAtivo());
            statement.executeUpdate();

            rs = statement.getGeneratedKeys();

            if (rs.next()) {
                Integer idInserido = rs.getInt(1);
                c.setId(idInserido);
                return true;
            }
        } catch (Exception e) {
            System.out.println("Erro ao inserir: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Object objeto) {
        Carro c = (Carro) objeto;
        try {
            con = getConnection();
            statement = con.prepareStatement("update carro set placa = ?, cor = ?, marca  = ?, modelo = ? , horaEntrada = ? ,horaSaida = ? where id = ?");
            statement.setString(1, c.getPlaca());
            statement.setString(2, (c.getCor()));
            statement.setString(3, c.getMarca());
            statement.setString(4, c.getModelo());
            statement.setDate(5, new java.sql.Date(c.getHoraEntrada().getTime()));
//            statement.setDate(6, new java.sql.Date(c.getHoraSaida().getTime()));
            statement.setInt(7, c.getId());
            int executeUpdate = statement.executeUpdate();
            return executeUpdate != 0;

        } catch (Exception e) {
            System.out.println("Erro ao fazer update: " + e.getMessage());
            e.printStackTrace();

        }

        return false;
    }

    public boolean updatehoraSaida(Object objeto) {
        Carro c = (Carro) objeto;
        try {
            con = getConnection();
            statement = con.prepareStatement("update carro set horaSaida = ? where id = ?");
            statement.setDate(1, new java.sql.Date(c.getHoraSaida().getTime()));
            statement.setInt(2, c.getId());
            int executeUpdate = statement.executeUpdate();
            return executeUpdate != 0;

        } catch (Exception e) {
            System.out.println("Erro ao fazer update de horaSaida: " + e.getMessage());
            e.printStackTrace();

        }
        return false;
    }

    @Override
    public Object pesquisar(Integer id
    ) {
        try {
            con = getConnection();
            statement = con.prepareStatement("Select * from carro where id = ?");
            statement.setInt(1, id);
            rs = statement.executeQuery();
            while (rs.next()) {
                String placa = rs.getString("placa");
                String cor = rs.getString("cor");
                String modelo = rs.getString("modelo");
                String marca = rs.getString("marca");
                Date horaEntrada = rs.getDate("horaEntrada");
                Date horaSaida = rs.getDate("horaSaida");

                Carro c = new Carro();
                c.setId(id);
                c.setMarca(marca);
                c.setCor(cor);
                c.setModelo(modelo);
                c.setPlaca(placa);
                c.setHoraEntrada(horaEntrada);
                c.setHoraSaida(horaSaida);

                return c;
            }
            return null;
        } catch (Exception e) {
            System.out.println("Erro ao pesquisar por carro " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Carro> pesquisarTermo(String termo
    ) {
        try {
            con = getConnection();
            statement = con.prepareStatement(""
                    + "SELECT * FROM carro"
                    + " WHERE ativo = 1 AND "
                    + " (id = ? OR placa LIKE ? OR modelo = ?) ");
            statement.setString(1, termo);
            statement.setString(2, termo + "%");
            statement.setString(3, termo);
            rs = statement.executeQuery();
            List<Carro> lista = new ArrayList<>();
            while (rs.next()) {
                Carro c = new Carro();
                c.setId(rs.getInt("id"));
                c.setPlaca(rs.getString("placa"));
                c.setCor(rs.getString("cor"));
                c.setModelo(rs.getString("modelo"));
                c.setMarca(rs.getString("marca"));
                c.setHoraEntrada(rs.getDate("horaEntrada"));
                c.setHoraSaida(rs.getDate("horaSaida"));
                lista.add(c);
            }
            return lista;
        } catch (SQLException ex) {
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CarroDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Carro> listar() {
        try {
            con = getConnection();
            statement = con.prepareStatement("SELECT * FROM carro");
            rs = statement.executeQuery();
            List<Carro> lista = new ArrayList<>();
            while (rs.next()) {
                Carro c = new Carro();
                c.setId(rs.getInt("id"));
                c.setPlaca(rs.getString("placa"));
                c.setCor(rs.getString("cor"));
                c.setModelo(rs.getString("modelo"));
                c.setMarca(rs.getString("marca"));
                c.setHoraEntrada(rs.getDate("horaEntrada"));
                c.setHoraSaida(rs.getDate("horaSaida"));
                lista.add(c);

            }
            return lista;
        } catch (SQLException ex) {
            System.out.println("Erro ao listar todos " + ex.getMessage());

            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CarroDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean excluir(Integer id
    ) {
        try {
            statement = con.prepareStatement("UPDATE carro SET ativo = 0 WHERE id = ? ");
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

}
