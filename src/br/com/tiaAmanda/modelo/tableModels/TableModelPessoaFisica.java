package br.com.tiaAmanda.modelo.tableModels;

import br.com.tiaAmanda.modelo.bean.PessoaFisica;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TableModelPessoaFisica extends AbstractTableModel {

    private final List<PessoaFisica> pessoas = new ArrayList<>();
    
    private final String[] colunas = {"CD", "Nome", "Telefone", "Fidelidade",
        "Endereço", "Número", "Complemento", "Bairro", "Observação"};

    public TableModelPessoaFisica(List<PessoaFisica> pessoas) {
        addListaDePessoas(pessoas);
    }

    public TableModelPessoaFisica() {

    }

    @Override
    public int getRowCount() {
        return pessoas.size();
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
                return Integer.class;
            case 4:
                return String.class;
            case 5:
                return String.class;
            case 6:
                return String.class;
            case 7:
                return String.class;
            case 8:
                return String.class;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    public void setValueAt(PessoaFisica pValue, int rowIndex) {
        PessoaFisica pessoa = pessoas.get(rowIndex);

        pessoa.setCd_pessoa_fisica(pValue.getCd_pessoa_fisica());
        pessoa.setDs_bairro(pValue.getDs_bairro());
        pessoa.setDs_complemento(pValue.getDs_complemento());
        pessoa.setDs_endereco(pValue.getDs_endereco());
        pessoa.setDs_observacao(pValue.getDs_observacao());
        pessoa.setDs_telefone(pValue.getDs_telefone());
        pessoa.setNm_pessoa_fisica(pValue.getNm_pessoa_fisica());
        pessoa.setNr_compra_fidelidade(pValue.getNr_compra_fidelidade());
        pessoa.setNr_endereco(pValue.getNr_endereco());

        for (int i = 0; i < colunas.length; i++) {
            fireTableCellUpdated(rowIndex, i);
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        PessoaFisica pSelecionada = pessoas.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return pSelecionada.getCd_pessoa_fisica();
            case 1:
                return pSelecionada.getNm_pessoa_fisica();
            case 2:
                return pSelecionada.getDs_telefone();
            case 3:
                return pSelecionada.getNr_compra_fidelidade();
            case 4:
                return pSelecionada.getDs_endereco();
            case 5:
                return pSelecionada.getNr_endereco();
            case 6:
                return pSelecionada.getDs_complemento();
            case 7:
                return pSelecionada.getDs_bairro();
            case 8:
                return pSelecionada.getDs_observacao();
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        PessoaFisica p = pessoas.get(rowIndex);
        switch (columnIndex) {
            case 0:
                p.setCd_pessoa_fisica((Integer) aValue);
                break;
            case 1:
                p.setNm_pessoa_fisica((String) aValue);
                break;
            case 2:
                p.setDs_telefone((String) aValue);
                break;
            case 3:
                p.setNr_compra_fidelidade((Integer) aValue);
                break;
            case 4:
                p.setDs_endereco((String) aValue);
                break;
            case 5:
                p.setNr_endereco((String) aValue);
                break;
            case 6:
                p.setDs_complemento((String) aValue);
                break;
            case 7:
                p.setDs_bairro((String) aValue);
                break;
            case 8:
                p.setDs_observacao((String) aValue);
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

    public PessoaFisica getPessoaFisica(int indiceLinha) {
        if (indiceLinha >= 0) {
            return pessoas.get(indiceLinha);
        }
        return null;
    }

    public void addPessoaFisica(PessoaFisica p) {
        pessoas.add(p);
        int ultimoIndice = getRowCount() - 1;
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }

    public void removePessoaFisica(int indiceLinha) {
        pessoas.remove(indiceLinha);
        fireTableRowsDeleted(indiceLinha, indiceLinha);
    }

    public void addListaDePessoas(List<PessoaFisica> novasPessoas) {
        int tamanhoAnterior = getRowCount();
        this.pessoas.addAll(novasPessoas);
        fireTableRowsInserted(tamanhoAnterior, getRowCount() - 1);
    }

    public void limpar() {
        pessoas.clear();
        fireTableDataChanged();
    }

    public boolean isEmpty() {
        return pessoas.isEmpty();
    }

    public String[] getColunas() {
        return colunas;
    }
    
}