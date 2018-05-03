package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoUtil {
    
    private static ConexaoUtil conexaoUtil;
    
    public static ConexaoUtil getInstance(){
        if(conexaoUtil == null){
            conexaoUtil = new ConexaoUtil();
        }
        return conexaoUtil;
    }
    
    public Connection getConnection() throws ClassNotFoundException, SQLException{
        //Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost/estoque";
        return DriverManager.getConnection(url,"root","33394812");
        
    }
    
    
}
