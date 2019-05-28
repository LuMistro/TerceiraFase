/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package senac.control;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import senac.Interface.CarroDao;
import senac.Interface.CarroDaoImpl;
import senac.model.Carro;
import senac.view.Principal;

/**
 *
 * @author Luiza Mistro
 */
public class CarroControl {

    List<Carro> listaCarros = new ArrayList<>();
    CarroDaoImpl carroDaoImpl = new CarroDaoImpl();
    Carro carro = new Carro();

    public CarroControl() {
        preencherTabela();
        sethoraEntrada();

    }

    public void sethoraEntrada() {
        carro.setHoraEntrada(new java.sql.Date(Date.parse(Principal.jblRelogio.getText())));
    }

    public void pegaDados() {
        carro.setCor(Principal.tfCor.getText());
        carro.setMarca(Principal.tfMarca.getText());
        carro.setModelo(Principal.tfModelo.getText());
        carro.setPlaca(Principal.tfPlaca.getText());
        if (Principal.cbEntrou.isSelected()) {
            carro.setHoraEntrada(new Date(Principal.jblRelogio.getText()));
        }
    }

    public void limpaCampos() {
        Principal.tfCor.setText("");
        Principal.tfMarca.setText("");
        Principal.tfModelo.setText("");
        Principal.tfPlaca.setText("");
        Principal.cbEntrou.setSelected(false);
        Principal.cbSaiu.setSelected(false);
    }

    public void preencheCampos() {

        int linhaSelecionada = Principal.TabelaPrincipal.getSelectedRow(); // Pega a linha selecionada pelo usuário
        Integer intCarro = (Integer) Principal.TabelaPrincipal.getValueAt(linhaSelecionada, 0); // Pega o id do carro que foi selecionado pelo usuário

        Carro c = new Carro();
        c = (Carro) carroDaoImpl.pesquisar(intCarro);
        carroDaoImpl.pesquisar(c.getId());
        Principal.tfCor.setText(c.getCor());
        Principal.tfMarca.setText(c.getMarca());
        Principal.tfModelo.setText(c.getModelo());
        Principal.tfPlaca.setText(c.getPlaca());
        Principal.cbEntrou.setSelected(true);
    }

    public final void preencherTabela() {
        try {
            String[] colunas = {"Id", "Placa", "Cor", "Modelo", "Marca", "Hora Entrada", "Hora Saída"};
            DefaultTableModel model = new DefaultTableModel(colunas, 0);
            Principal.TabelaPrincipal.setModel(model);

            listaCarros = carroDaoImpl.listar();

            for (Carro c : listaCarros) {
                model.addRow(new Object[]{c.getId(), c.getPlaca(), c.getCor(), c.getModelo(),
                    c.getMarca(), c.getHoraEntrada(), c.getHoraSaida()});
            }
        } catch (Exception e) {
            System.out.println("Não foi possível preencher tabela: " + e.getMessage());
            e.printStackTrace();
        }
        {
        }
    }

    public void SalvarAction() {
        pegaDados();
        seJaExisteNoBanco();
        limpaCampos();
        preencherTabela();
        Principal.BotaoEditar.setEnabled(true);
    }

    public void editarAction() {
        preencheCampos();
        Principal.BotaoEditar.setEnabled(false);
    }

    public boolean seJaExisteNoBanco() {

        Object carroPesquisa = carroDaoImpl.pesquisar(carro.getId());
        if (carroPesquisa != null) {
            int opcao = JOptionPane.showConfirmDialog(null, "Deseja salvar Alterações?");
            if (opcao == JOptionPane.YES_OPTION) {
                if (Principal.cbSaiu.isSelected()) {
                    carroDaoImpl.updatehoraSaida(carro);
                }
                carroDaoImpl.update(carro);
            } else {
                limpaCampos();
                Principal.BotaoEditar.setEnabled(true);
            }
        } else {
            carroDaoImpl.inserir(carro);
        }
        return false;
    }
}
