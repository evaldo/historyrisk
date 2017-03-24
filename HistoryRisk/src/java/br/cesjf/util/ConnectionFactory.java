package br.cesjf.util;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import static java.util.logging.Level.SEVERE;
import java.util.logging.Logger;

public class ConnectionFactory {

    public static Connection getConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            return (Connection) DriverManager.getConnection("jdbc:mysql://localhost/historyrisk", "root", "123456");
        
        }catch (SQLException ex){
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro SQLExcepection ao abrir a conexão em ConnectionFactory", ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
             throw new RuntimeException("Erro ClassNotFoundException em ConnectionFactory");
        }
        
    }
}
