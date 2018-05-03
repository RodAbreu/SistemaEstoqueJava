package DAO;

import JDBC.ConexaoUtil;
import Src.Item;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ItemDAO {
    
    public ItemDAO(){}
        
    public void inserir(Item item) throws ClassNotFoundException, SQLException{
        try (Connection connection = ConexaoUtil.getInstance().getConnection()) {
            String sql = "insert into Item(nome,valor,quantidade,id_item) values (?,?,?,?);";
            PreparedStatement statement = (PreparedStatement) connection.prepareStatement(sql);
            statement.setString(1,item.get_Nome());
            statement.setFloat(2,item.get_Valor());
            statement.setInt(3,item.get_Quantidade());
            statement.setInt(4,item.get_Indice());
            
            statement.execute();
        }
        
    }
    
    public ResultSet listaItens() throws ClassNotFoundException, SQLException{
        Connection connection = ConexaoUtil.getInstance().getConnection();
        String sql = "SELECT * FROM Item;";
        PreparedStatement statement = (PreparedStatement) connection.prepareStatement(sql);
        ResultSet resultado = statement.executeQuery();
        return resultado;
    }
    
    public void remover(int id) throws SQLException, ClassNotFoundException{
        Connection connection = ConexaoUtil.getInstance().getConnection();
        String sql = "delete from Item where id_item = ?;";
        PreparedStatement statement = (PreparedStatement) connection.prepareStatement(sql);
        statement.setInt(1,id);
        statement.execute();
    }
    
    public void alteraQuant(int id,int quant) throws ClassNotFoundException, SQLException{
        Connection connection = ConexaoUtil.getInstance().getConnection();
        String sql = "UPDATE Item SET quantidade = ? WHERE id_item=?;";
        PreparedStatement statement = (PreparedStatement) connection.prepareStatement(sql);
        statement.setInt(1,quant);
        statement.setInt(2,id);
        statement.execute();
    }
    
     public void alteraValor(int id,float quant) throws ClassNotFoundException, SQLException{
        Connection connection = ConexaoUtil.getInstance().getConnection();
        String sql = "UPDATE Item SET valor = ? WHERE id_item=?;";
        PreparedStatement statement = (PreparedStatement) connection.prepareStatement(sql);
        statement.setFloat(1,quant);
        statement.setInt(2,id);
        statement.execute();
    }
    
}
