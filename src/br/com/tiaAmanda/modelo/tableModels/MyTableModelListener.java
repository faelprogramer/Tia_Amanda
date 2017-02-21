package br.com.tiaAmanda.modelo.tableModels;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

public class MyTableModelListener implements TableModelListener {

    @Override
    public void tableChanged(TableModelEvent e) {
        int primeiraLinha = e.getFirstRow();
        int ultimaLinha = e.getLastRow();
        int coluna = e.getColumn();

        String acao = "";
        switch (e.getType()) {
            case TableModelEvent.INSERT:
                acao = "inseriu";
                break;
            case TableModelEvent.UPDATE:
                acao = "alterou";
                break;
            default:
                acao = "deletou";
                break;
        }

        if (primeiraLinha == TableModelEvent.HEADER_ROW) {
            System.out.println("Você " + acao + " a META-DATA da tabela");
        } else {
            System.out.println("Você " + acao + " da linha " + primeiraLinha + " até " + ultimaLinha);
        }

        if (coluna == TableModelEvent.ALL_COLUMNS) {
            System.out.println("Você " + acao + " todas as colunas");
        } else {
            System.out.println("Você " + acao + " a coluna " + coluna);
        }

    }

}
