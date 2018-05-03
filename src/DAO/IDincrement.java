
package DAO;

import JDBC.ConexaoUtil;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IDincrement {
    public IDincrement(){}
 
    public int maxID() throws SQLException, ClassNotFoundException{
        Connection connection = ConexaoUtil.getInstance().getConnection();
        String sql = "select max(id_item) as id_item FROM Item;";
        PreparedStatement statement = (PreparedStatement) connection.prepareStatement(sql);
        ResultSet resultado = statement.executeQuery();
        resultado.next();
        return(resultado.getInt("id_item"));
    }

    public int minID() throws SQLException, ClassNotFoundException{
        Connection connection = ConexaoUtil.getInstance().getConnection();
        String sql = "SELECT min(id_item) as id_item FROM Item;";
        PreparedStatement statement = (PreparedStatement) connection.prepareStatement(sql);
        ResultSet resultado = statement.executeQuery();
        resultado.next();
        return(resultado.getInt("id_item"));
    }
 
    public void reorganizaGeral() throws SQLException, ClassNotFoundException{
        Connection connection = ConexaoUtil.getInstance().getConnection();
        String sql1 = "SELECT * FROM Item;";
        String sql2 = "UPDATE Item SET id_item = ? WHERE nome=?;";
        PreparedStatement statement = (PreparedStatement) connection.prepareStatement(sql1);
        ResultSet resultado = statement.executeQuery();
        int cont = 0;
        while(resultado.next()){
            cont++;
            statement = (PreparedStatement) connection.prepareStatement(sql2);
            statement.setInt(1,cont);
            statement.setString(2,resultado.getString("nome"));
            statement.execute();
        }
    }
    

    
}
