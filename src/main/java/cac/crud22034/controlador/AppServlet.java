
package cac.crud22034.controlador;

import cac.crud22034.modelo.Alumno;
import cac.crud22034.modelo.Modelo;
import cac.crud22034.modelo.ModeloFactory;
import cac.crud22034.modelo.ModeloP;
import cac.crud22034.modelo.Producto;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Properties;

/**
 *
 * @author Charly Cimino Aprendé más Java en mi canal:
 * https://www.youtube.com/c/CharlyCimino Encontrá más código en mi repo de
 * GitHub: https://github.com/CharlyCimino
 */
@WebServlet(name = "AppServlet", urlPatterns = {"/inventario"})
public class AppServlet extends HttpServlet {

    private ModeloP model;
    private final String URI_INVENTORY = "inventarioProductos.jsp";
    private final String URI_REMOVE = "WEB-INF/pages/alumnos/borrarAlumno.jsp";
    private final String URI_EDIT = "WEB-INF/pages/alumnos/editarAlumno.jsp";
    @Override
    public void init() throws ServletException {
        this.model = getModelo();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                 
        String accion = request.getParameter("accion");
        accion = accion == null ? "":accion;
        int elId;
        Producto p;
        switch(accion){
            case"remove":
                elId = Integer.parseInt(request.getParameter("id"));
                p = model.getProducto(elId);
                request.setAttribute("productoABorrar", p);
                request.getRequestDispatcher(URI_REMOVE).forward(request, response);
                
                break;
                
            case "edit":
                
                elId = Integer.parseInt(request.getParameter("id"));
                p = model.getProducto(elId);
                request.setAttribute("productoAEditar", p);
                request.setAttribute("yaTieneFoto",!p.getFoto().contains("noproduct"));
                request.getRequestDispatcher(URI_EDIT).forward(request, response);
                
                break;
                
            default:
                request.setAttribute("Productos",model.getProductos());       
                request.getRequestDispatcher(URI_INVENTORY).forward(request, response);
                break;    
        
        }
        
        
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        Producto p;
        int elId;
        accion = accion == null ? "":accion;
        switch(accion){
            case "add":
                p = new Producto();
                cargarProducto(p, request);
                System.out.println(p);
                model.addProducto(p);
                break;
            case "update":
                elId = Integer.parseInt(request.getParameter("id"));
                p = model.getProducto(elId);
                cargarProducto(p, request);
                model.updateProducto(p);
                
                break;
            case "delete":
                elId = Integer.parseInt(request.getParameter("id"));
                model.removeProducto(elId);
                break;
            
        }                
        doGet(request, response);
    }
    
    private void cargarProducto(Producto p, HttpServletRequest request){
        p.setNombre(request.getParameter("nombre"));
        p.setPrecio(Float.parseFloat(request.getParameter("precio")));
        p.setCantidad(Integer.parseInt(request.getParameter("cantidad")));
        p.setFoto(request.getParameter("fotoBase64"));       
        
    }
    
    private ModeloP getModelo() throws ServletException {
        ModeloP m = null;
        try (InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties")) {
            Properties props = new Properties();
            props.load(is);
            String tipoModelo = props.getProperty("tipoModelo");
            m = ModeloFactory.getInstance().crearModelo(tipoModelo);
        } catch (IOException ex) {
            throw new ServletException("Error de E/S al al leer 'config' para iniciar el Servlet", ex);
        }
        return m;
    }
}
