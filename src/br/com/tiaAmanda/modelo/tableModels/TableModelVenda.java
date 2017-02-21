package br.com.tiaAmanda.modelo.tableModels;

import br.com.tiaAmanda.modelo.bean.FormaPagamento;
import br.com.tiaAmanda.modelo.bean.PessoaFisica;
import br.com.tiaAmanda.modelo.bean.Produto;
import br.com.tiaAmanda.modelo.bean.Venda;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TableModelVenda extends AbstractTableModel {

    private final List<Venda> vendas = new ArrayList<>();
    
    private final String[] colunas = {"Nr Venda", "Cliente", "Produto", "Dt Venda",
        "Forma Pagamento", "Vl Venda"};

    public TableModelVenda(List<Venda> vendas) {
        addListaDeVendas(vendas);
    }

    public TableModelVenda() {
    }

    @Override
    public int getRowCount() {
        return vendas.size();
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
                return PessoaFisica.class;
            case 2:
                return Produto.class;
            case 3:
                return Date.class;
            case 4:
                return FormaPagamento.class;
            case 5:
                return Float.class;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    public void setValueAt(Venda vValue, int rowIndex) {
        Venda v = vendas.get(rowIndex);
        
        v.setNr_sequencia(vValue.getNr_sequencia());
        v.setPessoa_fisica(vValue.getPessoa_fisica());
        v.setProduto(vValue.getProduto());
        v.setDt_venda(vValue.getDt_venda());
        v.setFormaPagamento(vValue.getFormaPagamento());
        v.setVl_venda(vValue.getVl_venda());
        
        for (int i = 0; i < colunas.length; i++) {
            fireTableCellUpdated(rowIndex, i);
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Venda vSelecionada = vendas.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return vSelecionada.getNr_sequencia();
            case 1:
                return vSelecionada.getPessoa_fisica().getNm_pessoa_fisica();
            case 2:
                return vSelecionada.getProduto().getDs_produto();
            case 3:
                return vSelecionada.getDt_venda();
            case 4:
                return vSelecionada.getFormaPagamento().getDs_forma_pagamento();
            case 5:
                return vSelecionada.getVl_venda();
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Venda v = vendas.get(rowIndex);
        switch (columnIndex) {
            //"Nr Venda", "Cliente", "Produto", "Dt Venda","Forma Pagamento", "Vl Venda"};
            case 0:
                v.setNr_sequencia((Integer) aValue);
                break;
            case 1:
                v.setPessoa_fisica((PessoaFisica) aValue);
                break;
            case 2:
                v.setProduto((Produto) aValue);
                break;
            case 3:
                v.setDt_venda((Date) aValue);
                break;
            case 4:
                v.setFormaPagamento((FormaPagamento) aValue);
                break;
            case 5:
                v.setVl_venda((Float) aValue);
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

    public Venda getVenda(int indiceLinha) {
        if (indiceLinha >= 0) {
            return vendas.get(indiceLinha);
        }
        return null;
    }

    public void addVenda(Venda v) {
        vendas.add(v);
        int ultimoIndice = getRowCount() - 1;
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }

    public void removeVenda(int indiceLinha) {
        vendas.remove(indiceLinha);
        fireTableRowsDeleted(indiceLinha, indiceLinha);
    }

    public void addListaDeVendas(List<Venda> novasVendas) {
        int tamanhoAnterior = getRowCount();
        this.vendas.addAll(novasVendas);
        fireTableRowsInserted(tamanhoAnterior, getRowCount() - 1);
    }

    public void limpar() {
        vendas.clear();
        fireTableDataChanged();
    }

    public boolean isEmpty() {
        return vendas.isEmpty();
    }

}