/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstractTableModel;

import Dao.ObjetoGenericoDao;
import Model.ObjetoGenerico;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Luiza Mistro
 */
public class ObjetoTableModel extends AbstractTableModel{
    
    // Constantes representando o índice das colunas
    private static final int ID = 0;
    private static final int NOME = 1;
    private static final int ATIVO = 2;
    private static final int DEPENDENCIA = 3;

    // Lista de Objetos<Produtos> a serem exibidos na tela.
    private List<ObjetoGenerico> linhas;

    // Colunas da Tabela (View)
    private String[] colunas = {"ID", "NOME", "ATIVO", "DEPENDENCIA"}; 

    // Cria um ProdutoTableModel sem nenhuma linha
    public ObjetoTableModel() {
        linhas = new ArrayList<>();
    }

    // Cria um ProdutoTableModel contendo a lista recebida por parâmetro 
    public ObjetoTableModel(List<ObjetoGenerico> listObjeto) {
        linhas = listObjeto;
    }

    /**
     * Retorna quantidade de Linhas.
     *
     * @return
     */
    @Override
    public int getRowCount() {
        return linhas.size();
    }

    /**
     * Retorna a quantidade de colunas.
     *
     * @return
     */
    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    /**
     * Retorna o Nome das colunas.
     *
     * @param columnIndex
     * @return
     */
    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case ID:
                return Integer.class;
            case NOME:
                return String.class;
            case ATIVO:
                return String.class;
            case DEPENDENCIA:
                return String.class;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    /**
     * Pega o Valor de uma Coluna/Linha da Tabela
     *
     * @param linha
     * @param coluna
     * @return
     */
    @Override
    public Object getValueAt(int linha, int coluna) {
        ObjetoGenerico produto = linhas.get(linha);
        switch (coluna) {
            case ID:
                return produto.getId();
            case NOME:
                return produto.getAtributo1();
            case ATIVO:
                return produto.getAtributo2();
            case DEPENDENCIA:
//                return produto.getDependencia().getNome(); // CHAVE ESTRANGEIRA
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    /**
     * Altera Valor de uma Coluna / Linha da tabela
     *
     * @param valor
     * @param linha
     * @param coluna
     */
    @Override
    public void setValueAt(Object valor, int linha, int coluna) {
        ObjetoGenerico objeto = linhas.get(linha);
        switch (coluna) {
            case ID:
//                objeto.setId(Integer.valueOf((String) valor));
                break;
            case NOME:
//                objeto.setNome((String) valor);
                break;
            case ATIVO:
//                objeto.setAtivo((Boolean) valor);
                break;
            case DEPENDENCIA:
//                objeto.getDependencia().setNome((String) valor);
                break;
            default:
                // Não deve ocorrer, pois só existem 4 colunas
                throw new IndexOutOfBoundsException("columnIndex out of bounds");

        }
        this.fireTableCellUpdated(linha, coluna); // Atualiza Celula da tabela

    }

    public ObjetoGenerico pegarObjeto(int indiceLinha) {
        return linhas.get(indiceLinha);
    }

    public void adicionar(ObjetoGenerico obj) {
        linhas.add(obj);
        int ultimoIndice = getRowCount() - 1; // linhas -1
        fireTableRowsInserted(ultimoIndice, ultimoIndice); // atualiza insert
    }

    public void remover(int indiceLinha) {
        linhas.remove(indiceLinha);
        fireTableRowsDeleted(indiceLinha, indiceLinha); // atualiza delete
    }
    
    
    public void atualizar(int indiceLinha, ObjetoGenerico obj) {
        linhas.set(indiceLinha , obj);
        fireTableRowsUpdated(indiceLinha, indiceLinha); // atualiza delete
    }

    public void adicionar(List<ObjetoGenerico> produtos) {
        int indice = getRowCount();
        linhas.addAll(produtos);
        fireTableRowsInserted(indice, indice + produtos.size());
        fireTableDataChanged();
    }

    public void limpar() {
        linhas.clear();
        fireTableDataChanged(); // atualiza toda tabela.
    }
    
}
