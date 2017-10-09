package br.com.tiaAmanda.modelo.bean.dao.factory;

import br.com.tiaAmanda.modelo.bean.dao.DAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class RelatoriosDAO extends DAO<String> {

    @Override
    public void save(Connection conn, String obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Connection conn, String obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<String> getAll(Connection conn) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getObject(Connection conn, String obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getResult(Connection conn) throws SQLException {
        sql = "select 'Mês/Ano: ' || DATE_PART('MONTH', dt_venda) || '/' || date_part('year', dt_venda) || ' - Qt Vedas: ' || count(vl_venda) || ' - Vl Vendas: R$' || sum(vl_venda) ds "
                + "from venda "
                + "group by DATE_PART('MONTH', dt_venda), date_part('year', dt_venda) "
                + "order by date_part('year', dt_venda), DATE_PART('MONTH', dt_venda)";
        StringBuilder sb = new StringBuilder();
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                sb.append(InstantObjectFromResultSet()).append("\n");
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            closeAll();
        }
        return sb.toString();
    }

    private String InstantObjectFromResultSet() throws SQLException {
        return rs.getString("ds");
    }
}
