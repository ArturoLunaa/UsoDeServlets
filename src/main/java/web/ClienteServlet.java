/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author artur
 */
public class ClienteServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        /* TODO output your page here. You may use following sample code. */
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>\n"
                + "        <title>Cliente</title>\n"
                + "        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n"
                + "        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi\" crossorigin=\"anonymous\"><link rel=\"stylesheet\" href=\"pruebaJava.css\">\n"
                + "</head>");
        out.println("<header>\n"
                + "        <nav class=\"navbar navbar-expand-lg bg-light\">\n"
                + "            <div class=\"container-fluid\">\n"
                + "                <a class=\"navbar-brand\" href=\"index.html\">Programamigos</a>\n"
                + "                <button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n"
                + "                    <span class=\"navbar-toggler-icon\"></span>\n"
                + "                </button>\n"
                + "                <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\n"
                + "                    <ul class=\"navbar-nav me-auto mb-2 mb-lg-0\">\n"
                + "                        <li class=\"nav-item\">\n"
                + "                            <a class=\"nav-link active\" aria-current=\"page\" href=\"ClienteServlet\">Clientes</a>\n"
                + "                        </li>\n"
                + "                        <li class=\"nav-item\">\n"
                + "                            <a class=\"nav-link active\" aria-current=\"page\" href=\"PedidoServlet\">Pedidos</a>\n"
                + "                        </li>\n"
                + "                        <li class=\"nav-item\">\n"
                + "                            <a class=\"nav-link active\" aria-current=\"page\" href=\"ProductoServlet\">Productos</a>\n"
                + "                        </li>\n"
                + "                        <li class=\"nav-item\">\n"
                + "                            <a class=\"nav-link active\" aria-current=\"page\" href=\"VendedorServlet\">Vendedor</a>\n"
                + "                        </li>\n"
                + "                        </header>");
        out.println("<title>Cliente Servlet</title>");
        out.println("<body>");
        out.println("<h1 class=\"text-center\">Clientes</h1><div class=\"container\">\n"
                + "        <div class=\"row my-4\">\n"
                + "            <div class=\"col-md-12 col-lg-6\">\n"
                + "                <div class=\"card\">\n"
                + "                    <div class=\"card-body\">\n"
                + "                        <h5 class=\"card-title\">Dar de alta un registro</h5>\n"
                + "                        <p class=\"card-text\">Inserte un registro en la tabla de Clientes</p>\n"
                + "                        <a href=\"InsertarCliente\" class=\"btn btn-primary\">Insertar</a>\n"
                + "                    </div>\n"
                + "                </div>\n"
                + "            </div>\n"
                + "            <div class=\"col-md-12 col-lg-6\">\n"
                + "                <div class=\"card\">\n"
                + "                    <div class=\"card-body\">\n"
                + "                        <h5 class=\"card-title\">Consultar un registro</h5>\n"
                + "                        <p class=\"card-text\">Consulte un registro en la tabla de Clientes</p>\n"
                + "                        <a href=\"ConsultarCliente\" class=\"btn btn-primary\">Consultar</a>\n"
                + "                    </div>\n"
                + "                </div>\n"
                + "            </div>\n"
                + "        </div>\n"
                + "        <div class=\"row\">\n"
                + "            <div class=\"col-md-12 col-lg-6\">\n"
                + "                <div class=\"card\">\n"
                + "                    <div class=\"card-body\">\n"
                + "                        <h5 class=\"card-title\">Actualizar un registro</h5>\n"
                + "                        <p class=\"card-text\">Actualice un registro en la tabla de Clientes</p>\n"
                + "                        <a href=\"actualizarClienteServlet\" class=\"btn btn-primary\">Actualizar</a>\n"
                + "                    </div>\n"
                + "                </div>\n"
                + "            </div>\n"
                + "            <div class=\"col-md-12 col-lg-6\">\n"
                + "                <div class=\"card\">\n"
                + "                    <div class=\"card-body\">\n"
                + "                        <h5 class=\"card-title\">Eliminar un registro</h5>\n"
                + "                        <p class=\"card-text\">Elimine un registro en la tabla de Clientes</p>\n"
                + "                        <a href=\"eliminarClienteServlet\" class=\"btn btn-primary\">Eliminar</a>\n"
                + "                    </div>\n"
                + "                </div>\n"
                + "            </div>\n"
                + "        </div>\n"
                + "    </div>\n"
                + "    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3\" crossorigin=\"anonymous\">       \n"
                + "    </script>");
        out.println("</body>");
        out.println("</html>");

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
