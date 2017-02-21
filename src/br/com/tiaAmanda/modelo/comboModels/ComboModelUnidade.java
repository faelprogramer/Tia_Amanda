package br.com.tiaAmanda.modelo.comboModels;

import br.com.tiaAmanda.modelo.bean.Unidade;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

public final class ComboModelUnidade extends AbstractListModel<Unidade> implements ComboBoxModel<Unidade> {

    private List<Unidade> unidades;
    private Unidade selectedUnidade;
    private final static int FIRSTINDEX = 0;

    public ComboModelUnidade() {
        this.unidades = new ArrayList<>();
    }

    public ComboModelUnidade(List<Unidade> unidades) {
        this();
        this.unidades.addAll(unidades);
        if (getSize() > 0) {
            setSelectedItem(this.unidades.get(FIRSTINDEX));
        }
    }

    @Override
    public int getSize() {
        return unidades.size();
    }

    @Override
    public Unidade getElementAt(int index) {
        return unidades.get(index);
    }

    @Override
    public Object getSelectedItem() {
        return selectedUnidade;
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selectedUnidade = (Unidade) anItem;
    }

    public void addUnidade(Unidade u) {
        unidades.add(u);
        fireIntervalAdded(this, getSize() - 1, getSize() - 1);
        setSelectedItem(unidades.get(getSize() - 1));
    }

    public void addListUnidades(List<Unidade> unidades) {
        int primeiraLinha = getSize();
        this.unidades.addAll(unidades);
        fireIntervalAdded(this, primeiraLinha, primeiraLinha + unidades.size());
        setSelectedItem(this.unidades.get(getSize() - 1));
    }

    public void removeUnidade() {
        unidades.remove(getSelectedItem());
        fireIntervalRemoved(this, FIRSTINDEX, getSize() - 1);
        setSelectedItem(unidades.get(FIRSTINDEX));
    }

    public void clear() {
        unidades.clear();
        fireContentsChanged(this, FIRSTINDEX, getSize() - 1);
    }
    
}
