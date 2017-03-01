package br.com.tiaAmanda.controle;

import br.com.tiaAmanda.modelo.bean.dao.factory.ConnectionFactory;
import br.com.tiaAmanda.modelo.bean.dao.factory.PostgresConnectionFactory;
import br.com.tiaAmanda.modelo.exception.CamposObrigatoriosNaoPreenchidosException;
import java.awt.Component;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import javax.swing.JTextField;

public abstract class Control {

    protected ConnectionFactory connectionFactory = new PostgresConnectionFactory();
    protected Connection connection;

    protected void habilitarComponentes(boolean habilitar, Component... componentes) {
        for (Component componente : componentes) {
            componente.setEnabled(habilitar);
        }
    }

    protected void limparJTextfields(JTextField... jTextfields) {
        for (JTextField jTextfield : jTextfields) {
            jTextfield.setText("");
        }
    }

    protected void beginTransaction() throws SQLException, ClassNotFoundException {
        connection = connectionFactory.getConnection();
        connection.setAutoCommit(false);
    }

    protected void endTransaction() throws SQLException {
        try {
            connection.commit();
        } catch (SQLException ex) {
            roolback();
        } finally {
            closeConnection();
        }
    }

    protected void roolback() throws SQLException {
        try {
            connection.rollback();
        } catch (SQLException ex) {
            throw ex;
        } finally {
            closeConnection();
        }
    }

    private void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    protected abstract void validarCampos() throws CamposObrigatoriosNaoPreenchidosException;
    
}
