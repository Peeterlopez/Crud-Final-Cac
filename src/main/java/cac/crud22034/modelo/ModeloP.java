
package cac.crud22034.modelo;

import java.util.List;

/**
 *
 * @author Charly Cimino
 * Aprendé más Java en mi canal: https://www.youtube.com/c/CharlyCimino
 * Encontrá más código en mi repo de GitHub: https://github.com/CharlyCimino
 */
public interface ModeloP {
    /**
     * Devuelve una lista de alumnos existentes
     * @return 
     */
    public List<Producto> getProductos();
    
    /**
     * Retorna un alumno por ID
     * @param id el id del alumno a retornar
     * @return El alumno encontrado por ID o null si no existe
     */
    public Producto getProducto(int id);
    
    /**
     * Agrega un producto al modelo
     * @param producto El Producto a agregar
     * @return La cantidad de registros modificados
     */
    public int addProducto (Producto producto);
    
    /**
     * Modifica un Producto del modelo
     * @param producto El producto que contiene los datos para modificar
     * @return La cantidad de registros modificados
     */
    public int updateProducto(Producto producto);
    
    /**
     * Borra un alumno por ID
     * @param id el id del alumno a borrar
     * @return La cantidad de registros modificados
     */
    public int removeProducto(int id);
}
