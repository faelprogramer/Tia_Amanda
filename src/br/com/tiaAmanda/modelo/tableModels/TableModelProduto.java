package br.com.tiaAmanda.modelo.tableModels;

import br.com.tiaAmanda.modelo.bean.Produto;
import br.com.tiaAmanda.modelo.bean.Unidade;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TableModelProduto extends AbstractTableModel {

    private final List<Produto> produtos = new ArrayList<>();

    private final String[] colunas = {"CD", "CD Barras", "Descrição",
        "Unidade", "Vl. À vista", "Vl. Prazo"};

    public TableModelProduto(List<Produto> produtos) {
        addListaDeProdutos(produtos);
    }

    public TableModelProduto() {

    }

    @Override
    public int getRowCount() {
        return produtos.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return Integer.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return Unidade.class;
            case 4:
                return Float.class;
            case 5:
                return Float.class;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    public void setValueAt(Produto pValue, int rowIndex) {
        Produto pessoa = produtos.get(rowIndex);
        pessoa.setCd_produto(pValue.getCd_produto());
        pessoa.setCd_barras(pValue.getCd_barras());
        pessoa.setDs_produto(pValue.getDs_produto());
        pessoa.setUnidade(pValue.getUnidade());
        pessoa.setVl_aprazo(pValue.getVl_aprazo());
        pessoa.setVl_avista(pValue.getVl_avista());

        for (int i = 0; i < colunas.length; i++) {
            fireTableCellUpdated(rowIndex, i);
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Produto pSelecionado = produtos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return pSelecionado.getCd_produto();
            case 1:
                return pSelecionado.getCd_barras();
            case 2:
                return pSelecionado.getDs_produto();
            case 3:
                return pSelecionado.getUnidade();
            case 4:
                return pSelecionado.getVl_avista();
            case 5:
                return pSelecionado.getVl_aprazo();
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Produto p = produtos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                p.setCd_produto((Integer) aValue);
                break;
            case 1:
                p.setCd_barras((String) aValue);
                break;
            case 2:
                p.setDs_produto((String) aValue);
                break;
            case 3:
                p.setUnidade((Unidade) aValue);
                break;
            case 4:
                p.setVl_avista((Float) aValue);
                break;
            case 5:
                p.setVl_aprazo((Float) aValue);
                break;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public Produto getProduto(int indiceLinha) {
        if (indiceLinha >= 0) {
            return produtos.get(indiceLinha);
        }
        return null;
    }

    public void addProduto(Produto p) {
        produtos.add(p);
        int ultimoIndice = getRowCount() - 1;
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }

    public void removeProduto(int indiceLinha) {
        produtos.remove(indiceLinha);
        fireTableRowsDeleted(indiceLinha, indiceLinha);
    }

    public void addListaDeProdutos(List<Produto> novosProdutos) {
        int tamanhoAnterior = getRowCount();
        this.produtos.addAll(novosProdutos);
        fireTableRowsInserted(tamanhoAnterior, getRowCount() - 1);
    }

    public void limpar() {
        produtos.clear();
        fireTableDataChanged();
    }

    public boolean isEmpty() {
        return produtos.isEmpty();
    }

    public String[] getColunas() {
        return colunas;
    }

}
