/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cac.crud22034.modelo;

/**
 *
 * @author Pedro López
 */
public class Producto {
    private int id;
    private String nombre;
    private float precio;
    private int cantidad;
    private String foto;

    public Producto() {
    }

    public Producto(String nombre, float precio, int cantidad) {
        this(0,nombre,precio,cantidad,"");
    }
    
    public Producto(int id, String nombre, float precio, int cantidad) {
        this(id ,nombre,precio,cantidad,"");
    }

    public Producto(int id) {
        setId(id);
    }
    
    public Producto(int id, String nombre, float precio, int cantidad, String foto) {
        setId(id);
        setNombre(nombre);
        setPrecio(precio);
        setCantidad(cantidad);
        setFoto(foto);
    }

    
    

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        if (id < 0) {
            throw new RuntimeException("Valor para ID inconsistente");
        }
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if(nombre==null || nombre.trim().isEmpty()){
       throw new RuntimeException("No se ha provisto un nombre"); 
    }
       this.nombre = nombre.trim();
       
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        if(precio<0){
            throw new RuntimeException("No se ha provisto un precio real");
       }
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        
        this.cantidad = cantidad;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        if (foto == null || foto.trim().isEmpty()) {
            foto = "assets/noproduct.png";
        }
        if (!foto.contains("noproduct") || this.foto == null || this.foto.contains("noproduct")) {
            this.foto = foto.trim();
        }
    }

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", cantidad=" + cantidad + ", foto=" + foto + '}';
    }

      
      
           
    
}
