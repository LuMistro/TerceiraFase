/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex5.Model;

import java.sql.Time;

/**
 *
 * @author Luiza Mistro
 */
public class DadosViagem {

    private Double latInicial;
    private Double latFinal;
    private Double longInicial;
    private Double longFinal;
    private Double TempoViagem;
    private Double litrosGastos;

    public Double getLatInicial() {
        return latInicial;
    }

    public void setLatInicial(Double latInicial) {
        this.latInicial = latInicial;
    }

    public Double getLatFinal() {
        return latFinal;
    }

    public void setLatFinal(Double latFinal) {
        this.latFinal = latFinal;
    }

    public Double getLongInicial() {
        return longInicial;
    }

    public void setLongInicial(Double longInicial) {
        this.longInicial = longInicial;
    }

    public Double getLongFinal() {
        return longFinal;
    }

    public void setLongFinal(Double longFinal) {
        this.longFinal = longFinal;
    }

    public Double getTempoViagem() {
        return TempoViagem;
    }

    public void setTempoViagem(Double TempoViagem) {
        this.TempoViagem = TempoViagem;
    }

    public Double getLitrosGastos() {
        return litrosGastos;
    }

    public void setLitrosGastos(Double litrosGastos) {
        this.litrosGastos = litrosGastos;
    }

    public double distanciaPercorrida() {
        Double diminuelatitude = (latFinal - latInicial) * (latFinal - latInicial);
        Double diminuelongitude = (longFinal - longInicial) * (longFinal - longInicial);
        Double soma = diminuelatitude + diminuelongitude;
        return Math.sqrt(soma);
    }

    public double velocidadeMedia() {
        return distanciaPercorrida() / TempoViagem;
    }

    public Double autonomiaVeiculo() {
        return distanciaPercorrida() / litrosGastos;
    }

    
    
}
