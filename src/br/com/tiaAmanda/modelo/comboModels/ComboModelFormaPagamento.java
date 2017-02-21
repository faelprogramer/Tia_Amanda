package br.com.tiaAmanda.modelo.comboModels;

import br.com.tiaAmanda.modelo.bean.FormaPagamento;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

public final class ComboModelFormaPagamento<String> extends AbstractListModel<FormaPagamento> implements ComboBoxModel<FormaPagamento> {

    private List<FormaPagamento> formasPagamento;
    private FormaPagamento formaPagamento;
    private final static int FIRSTINDEX = 0;

    public ComboModelFormaPagamento() {
        this.formasPagamento = new ArrayList<>();
    }

    public ComboModelFormaPagamento(List<FormaPagamento> formaPagamentos) {
        this();
        this.formasPagamento.addAll(formaPagamentos);
        setSelectedItem(this.formasPagamento.get(FIRSTINDEX));
    }

    @Override
    public int getSize() {
        return formasPagamento.size();
    }

    @Override
    public FormaPagamento getElementAt(int index) {
        return formasPagamento.get(index);
    }

    @Override
    public Object getSelectedItem() {
        return formaPagamento;
    }

    @Override
    public void setSelectedItem(Object anItem) {
        if (formasPagamento.size() > 0) {
            formaPagamento = (FormaPagamento) anItem;
        }
    }

    public void addUnidade(FormaPagamento fp) {
        formasPagamento.add(fp);
        fireIntervalAdded(this, getSize() - 1, getSize() - 1);
        setSelectedItem(formasPagamento.get(getSize() - 1));
    }

    public void addListUnidades(List<FormaPagamento> formaPagamentos) {
        int primeiraLinha = getSize();
        this.formasPagamento.addAll(formaPagamentos);
        fireIntervalAdded(this, primeiraLinha, primeiraLinha + formaPagamentos.size());
        setSelectedItem(this.formasPagamento.get(getSize() - 1));
    }

    public void removeFormaPagamento() {
        formasPagamento.remove(getSelectedItem());
        fireIntervalRemoved(this, FIRSTINDEX, getSize() - 1);
        setSelectedItem(formasPagamento.get(FIRSTINDEX));
    }

    public void clear() {
        formasPagamento.clear();
        fireContentsChanged(this, FIRSTINDEX, getSize() - 1);
    }

}
