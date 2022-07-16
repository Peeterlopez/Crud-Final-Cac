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
    private static final String ADD_QUERY = "INSERT INTO productos VALUES (null, ?, ?, ?, ?)";
    private static final String UPDATE_QUERY = "UPDATE productos SET nombre=?, precio=?, cantidad = ?, fotoBase64=? WHERE id=?";
    private static final String DELETE_QUERY = "DELETE FROM productos WHERE id = ?";
    private static final String GET_BY_NAME_QUERY="SELECT * FROM productos WHERE nombre = ?";
    

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
        int regsAgregados = 0;
    try ( Connection con = Conexion.getConnection();  PreparedStatement ps = con.prepareStatement(ADD_QUERY);) {
            fillPreparedStatement(ps, producto);
            regsAgregados = ps.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Error de SQL", ex);
        } catch (Exception ex) {
            throw new RuntimeException("Error al agregar producto " + producto.getNombre(), ex);
        }
        return regsAgregados;
    }

    @Override
    public int updateProducto(Producto producto) {
        int regsActualizados = 0;
        try ( Connection con = Conexion.getConnection();  PreparedStatement ps = con.prepareStatement(UPDATE_QUERY);) {
            fillPreparedStatement(ps, producto);
            ps.setInt(5, producto.getId());
            regsActualizados = ps.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Error de SQL", ex);
        } catch (Exception ex) {
            throw new RuntimeException("Error al editar alumno " + producto.getNombre(), ex);
        }
        return regsActualizados;
    }

    @Override
    public int removeProducto(int id) {
       int regsBorrados = 0;
        try ( Connection con = Conexion.getConnection();  PreparedStatement ps = con.prepareStatement(DELETE_QUERY);) {
            ps.setInt(1, id);
            regsBorrados = ps.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Error de SQL", ex);
        } catch (Exception ex) {
            throw new RuntimeException("Error al borrar alumno con ID " + id, ex);
        }
        return regsBorrados;
    }

    @Override
    public Producto buscarProducto(String nombre) {
       Producto p = null;
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(GET_BY_NAME_QUERY); ){
        ps.setString(1, nombre);
        try(ResultSet rs =ps.executeQuery();){
            rs.next();
            p=rsToProducto(rs);
        }
                
        } catch (SQLException ex) {
            throw new RuntimeException("Error de SQL", ex);
        } catch (Exception ex){
            throw new RuntimeException("Error al leer alumno con ID " +nombre,ex);
        }
        return p;
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
    
    private void fillPreparedStatement(PreparedStatement ps, Producto producto) throws SQLException {
        ps.setString(1, producto.getNombre());
        ps.setFloat(2, producto.getPrecio());
        ps.setInt(3, producto.getCantidad());
        ps.setString(4, producto.getFoto());
        }
    
    
}
