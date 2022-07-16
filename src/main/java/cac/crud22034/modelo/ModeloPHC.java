package cac.crud22034.modelo;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author Charly Cimino Aprendé más Java en mi canal:
 * https://www.youtube.com/c/CharlyCimino Encontrá más código en mi repo de
 * GitHub: https://github.com/CharlyCimino
 */

// Modelo HC (Hard Codeado): Los datos se guardan en la RAM. Solo sirve para testear la app.
public class ModeloPHC implements ModeloP {

    private List<Producto> productosGuardados;

    public ModeloPHC() {
        this.productosGuardados = new ArrayList<>();
        crearAlumnosFake();
    }

    @Override
    public List<Producto> getProductos() {
        return new ArrayList(this.productosGuardados); // Copia de la lista original
    }

    @Override
    public Producto getProducto(int id) {
        int i = 0;
        Producto encontrado = null;
        while (i < this.productosGuardados.size() && encontrado == null) {
            Producto a = this.productosGuardados.get(i);
            if (a.getId() == id) {
                encontrado = a;
            } else {
                i++;
            }
        }
        if (encontrado == null) {
            throw new RuntimeException("No se encontró alumno con ID " + id);
        }
        return encontrado;
    }

    @Override
    public int addProducto(Producto producto) {
        this.productosGuardados.add(producto);
        return 0;
    }

    @Override
    public int updateProducto(Producto a) {
        Producto target = getProducto(a.getId());
        int idx = this.productosGuardados.indexOf(target);
        this.productosGuardados.set(idx, a);
        return 0;
    }

    @Override
    public int removeProducto(int id) {
        Producto target = getProducto(id);
        this.productosGuardados.remove(target);
        return 0;
    }
    
    @Override
    public Producto buscarProducto (String nombre){
        int i = 0;
        String x;
        Producto encontrado = null;
        while (i < this.productosGuardados.size() && encontrado == null) {
            Producto a = this.productosGuardados.get(i);
            x= a.getNombre();
            System.out.println(x);
            if (nombre.equalsIgnoreCase(x)) {
                encontrado = a;
            } else {
                i++;
            }
        }
    
        if (encontrado == null) {
            throw new RuntimeException("No se encontró producto con nombre " + nombre);
        }
        return encontrado;
    }
    
    private void crearAlumnosFake() {
        try (InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("carasFake.properties")) {
            Properties props = new Properties();
            props.load(is);
            this.productosGuardados.add(new Producto(1, "Kouza",526, 40, (String) props.get("HOMBRE_1")));
            this.productosGuardados.add(new Producto(2, "Polo", 432, 51));
            this.productosGuardados.add(new Producto(3, "López",432, 25, (String) props.get("MUJER_1")));
            this.productosGuardados.add(new Producto(4, "García",432, 3, (String) props.get("HOMBRE_3")));
            this.productosGuardados.add(new Producto(5, "Gómez",432, 200, (String) props.get("MUJER_3")));
            this.productosGuardados.add(new Producto(6, "Ruiz",432, 35, (String) props.get("HOMBRE_2")));
            this.productosGuardados.add(new Producto(7, "Pérez",432, 15, (String) props.get("MUJER_2")));
            this.productosGuardados.add(new Producto(8, "Suárez",432, 0, (String) props.get("MUJER_4")));
            this.productosGuardados.add(new Producto(9, "Mohamed",432, 0, (String) props.get("HOMBRE_4")));
        } catch (IOException ex) {
            throw new RuntimeException("No se pudieron cargar las caras fake");
        }
    }

    }

