/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package senac.control;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import senac.dao.ProdutoDao;
import senac.model.Produto;
import senac.uteis.Mensagens;
import senac.uteis.Painel;
import senac.uteis.Validacao;
import senac.view.Gerenciar;

/**
 *
 * @author Alunos
 */
public class ProdutoControl {

    List<Produto> listProdutos;
    ProdutoDao produtoDao;
    Produto produto;

    public ProdutoControl() {
        produtoDao = new ProdutoDao();
    }

    public void listarAction() {
        listProdutos = produtoDao.listar();
        atualizarJTable();
    }

    public void atualizarJTable() {
        DefaultTableModel model = (DefaultTableModel) Gerenciar.tblProdutos.getModel();
        model.setNumRows(0);
        double total = 0;
        for (Produto p : listProdutos) {
            model.addRow(new Object[]{
                p.getId(),
                p.getNome(),
                p.getValor()
            });
            total += p.getValor();
        }
        atualizarLabelTotal(total);
    }

    public void atualizarLabelTotal(double total) {
        Gerenciar.jlblTotal.setText("R$: " + total);
    }

    public void cadastrarAction() {
        validacaoCampos();
        produto = new Produto();
        setValores();
        int res = produtoDao.cadastrar(produto);
        if (res > 0) {
            Painel.msg(Mensagens.SUCESSO_CADASTRO);
            listarAction();
        } else {
            Painel.msg(Mensagens.ERRO_CADASTRAR);
        }
        apagarCampos();
        produto = null;
    }

    private Produto getProdutoSelecionadoTable() {
        int i = Gerenciar.tblProdutos.getSelectedRow();
        if (i >= 0) {
            return listProdutos.get(i);
        }
        return null;
    }

    public void excluirAction() {
        //Resgatar indice da linha selecionada
        Produto p = getProdutoSelecionadoTable();
        if (p == null) {
            Painel.msg("Selecione um produto");
            return;
        }
        if (Painel.questao("Deseja excluir o produto " + p.getNome() + " ?") == JOptionPane.YES_OPTION) {
            if (produtoDao.deletar(p.getId())) {
                Painel.msg(Mensagens.SUCESSO_EXCLUIR);
                listarAction();
            } else {
                Painel.msg(Mensagens.ERRO_EXCLUIR);
            }
        }
    }

    public void popularFormAction() {
        produto = getProdutoSelecionadoTable();
        if (produto == null) {
            Painel.msg("Selecione um produto");
            return;
        }
        Gerenciar.tfNome.setText(produto.getNome());
        Gerenciar.tfValor.setText(String.valueOf(produto.getValor()));
        Gerenciar.tfNome.requestFocus();
    }

    public void editarAction() {
        validacaoCampos();
        //Extrair para um método
        setValores();
        if (produtoDao.alterar(produto)) {
            Painel.msg(Mensagens.SUCESSO_EDITAR);
            listarAction();
        } else {
            Painel.msg("Erro ao editar");
        }

        apagarCampos();
        produto = null;
    }

    public void salvarAction() {
        if (produto == null) {
            cadastrarAction();
        } else {
            editarAction();
        }
    }

    public void pesquisarAction() {
        listProdutos = produtoDao.pesquisar(Gerenciar.tfPesquisa.getText());
        atualizarJTable();
    }

    public void apagarCampos() {
        Gerenciar.tfValor.setText("");
        Gerenciar.tfNome.setText("");
    }

    public void validacaoCampos() {
        if (Validacao.campoVazio(Gerenciar.tfNome)) {
            Painel.msg(Mensagens.ERRO_NOME_INVALIDO);
            Gerenciar.tfNome.requestFocus();
            return;
        }
        if (Validacao.campoVazio(Gerenciar.tfValor)) {
            Painel.msg(Mensagens.ERRO_VALOR_INVALIDO);
            Gerenciar.tfValor.requestFocus();
            return;
        }
    }

    public void setValores() {
        produto.setNome(Gerenciar.tfNome.getText());
        produto.setValor(Gerenciar.tfValor.getText());
    }
}
