/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package cac.crud22034.controlador;

import cac.crud22034.modelo.ModeloFactory;
import cac.crud22034.modelo.ModeloP;
import cac.crud22034.modelo.Producto;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Pedro López
 */

@WebServlet(name = "SearchingServlet", urlPatterns = {"/Search"})
public class SearchingServlet extends HttpServlet {
    private ModeloP model;
    private final String URI_SEARCH = "InventarioSearch.jsp";
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
                elId= Integer.parseInt(request.getParameter("id"));
                p=model.getProducto(elId);
                request.setAttribute("productoABuscar",p);       
                request.getRequestDispatcher(URI_SEARCH).forward(request, response);
                
                break;
        
    }
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
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
