/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex5.control;

import ex5.Model.DadosViagem;
import ex5.view.TelaViagem;

/**
 *
 * @author Luiza Mistro
 */
public class ViagemControl {

    DadosViagem dados = new DadosViagem();

    public void pegaDados() {
        dados.setLatFinal(new Double(TelaViagem.jtLatitudeFinal.getText()));
        dados.setTempoViagem(new Double(TelaViagem.tfTempoViagem.getText()));
        dados.setLongFinal(new Double(TelaViagem.tfLongitudeFinal.getText()));
        dados.setLatInicial(new Double(TelaViagem.tfLatidudeInicial.getText()));
        dados.setLitrosGastos(new Double(TelaViagem.tfLitrosGasolina.getText()));
        dados.setLongInicial(new Double(TelaViagem.tfLongitudeInicial.getText()));
    }

    public void calculaDistanciaAction() {
        pegaDados();
        Double distancia = dados.distanciaPercorrida();
        TelaViagem.lbOpcaoEscolhida.setText("Distância Percorrida:");
        TelaViagem.lbResultadoOpcao.setText(distancia.toString());
    }

    public void velocidadeMediaAcion() {
        pegaDados();
        Double velocidade = dados.velocidadeMedia();
        TelaViagem.lbOpcaoEscolhida.setText("Velocidade média:");
        TelaViagem.lbResultadoOpcao.setText(velocidade.toString());
    }

    public void autonomiaVeiculo() {
        pegaDados();
        Double autonomia = dados.autonomiaVeiculo();
        TelaViagem.lbOpcaoEscolhida.setText("Autonomia do veículo:");
        TelaViagem.lbResultadoOpcao.setText(autonomia.toString());
    }
}
