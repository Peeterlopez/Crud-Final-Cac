/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cac.crud22034.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author Pedro López
 */
public class ModeloPMySQL implements ModeloP {
    
    private static final String GET_ALL_QUERY="SELECT * FROM productos";
    private static final String GET_BY_ID_QUERY = "SELECT * FROM productos WHERE id = ?";
    private static final String ADD_QUERY = "INSERT INTO productos VALUES (null, ?, ?, ?, ?, ?)";
    private static final String UPDATE_QUERY = "UPDATE productos SET nombre=?, apellido=?, fechaNacimiento = ?, mail=?, fotoBase64=? WHERE id=?";
    private static final String DELETE_QUERY = "DELETE FROM productos WHERE id = ?";
    

    @Override
    public List<Producto> getProductos() {
        List <Producto> productos = new ArrayList<>();
        
        try (Connection con = Conexion.getConnection();  PreparedStatement ps = con.prepareStatement(GET_ALL_QUERY);  ResultSet rs = ps.executeQuery();) {
            
            while(rs.next()){
                productos.add(rsToProducto(rs));
                               
            }
            
        } catch (SQLException ex) {
            throw new RuntimeException("Error de SQL",ex);
        } catch (Exception ex){
            throw new RuntimeException("Error al cargar producto con la BD", ex);
        }
        
        return productos;
    }

    @Override
    public Producto getProducto(int id) {
        Producto p = null;
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(GET_BY_ID_QUERY); ){
        ps.setInt(1, id);
        try(ResultSet rs =ps.executeQuery();){
            rs.next();
            p=rsToProducto(rs);
        }
                
        } catch (SQLException ex) {
            throw new RuntimeException("Error de SQL", ex);
        } catch (Exception ex){
            throw new RuntimeException("Error al leer alumno con ID " +id,ex);
        }
        return p;
    }

    @Override
    public int addProducto(Producto producto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int updateProducto(Producto producto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int removeProducto(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Producto buscarProducto(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private Producto rsToProducto (ResultSet rs) throws SQLException {
        int idP = rs.getInt ("id");
                String nombre = rs.getString ("nombre");
                float precio= rs.getFloat("precio");
                int cantidad = rs.getInt("cantidad");
                String foto = rs.getString("fotoBase64");
                Producto p = new Producto(idP, nombre, precio, cantidad, foto);
        return new Producto(idP, nombre, precio, cantidad, foto);
    }
    
    
}
