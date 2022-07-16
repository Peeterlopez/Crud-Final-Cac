/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cac.crud22034.modelo;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author Pedro López
 */
public class Conexion {
    private static Connection con;
    private static BasicDataSource dataSource;
    
    private Conexion(){
    }
    
    public static DataSource getDataSource(){
        if (dataSource==null){
            try{
                String URL = "jdbc:mysql://root:Peetertv***98@localhost:3306/productos_crud?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
                Class.forName("com.mysql.jdbc.Driver");
            dataSource= new BasicDataSource();
            dataSource.setUrl(URL);
            dataSource.setInitialSize(50);
            }
            catch(Exception ex){
                throw new RuntimeException("Error al conectar con la base de datos.",ex);
            }
        }
        return dataSource;
    }

    public static Connection getConnection() throws SQLException {
        return getDataSource().getConnection();
    }
    
    
}
