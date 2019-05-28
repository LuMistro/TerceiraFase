/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package senac.model;

import java.util.Date;

/**
 *
 * @author Luiza Mistro
 */
public class Carro {

    private int id;
    private String placa;
    private String cor;
    private String modelo;
    private String marca;
    private Date horaEntrada;
    private Date horaSaida = null;
    private int ativo = 1;

    public Carro() {
    }

    public Carro(int id, String placa, String cor, String modelo, String marca, Date horaEntrada, int ativo) {
        this.id = id;
        this.placa = placa;
        this.cor = cor;
        this.modelo = modelo;
        this.marca = marca;
        this.horaEntrada = horaEntrada;
        this.ativo = ativo;
    }

    public Carro(int id, String placa, String cor, String modelo, String marca, Date horaEntrada, Date horaSaida, int ativo) {
        this.id = id;
        this.placa = placa;
        this.cor = cor;
        this.modelo = modelo;
        this.marca = marca;
        this.horaEntrada = horaEntrada;
        this.horaSaida = horaSaida;
        this.ativo = ativo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Date getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(Date horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public Date getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(Date horaSaida) {
        this.horaSaida = horaSaida;
    }

    public int getAtivo() {
        return ativo;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
    }

    @Override
    public String toString() {
        return "Carro{" + "id=" + id + ", placa=" + placa + ", cor=" + cor + ", modelo=" + modelo + ", marca=" + marca + ", horaEntrada=" + horaEntrada + ", horaSaida=" + horaSaida + ", ativo=" + ativo + '}';
    }



}
