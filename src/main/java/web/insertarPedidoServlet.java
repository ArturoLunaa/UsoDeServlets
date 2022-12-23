/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package web;

import datos.PedidoDAO;
import domain.Pedido;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author artur
 */
public class insertarPedidoServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        PedidoDAO pedidoDAO = new PedidoDAO();

        String fecha = request.getParameter("fecha");
        String estado = request.getParameter("estado");
        String fechaEnvio = request.getParameter("fechaEnvio");
        String idCliente = request.getParameter("idCliente");
        String idVendedor = request.getParameter("idVendedor");

        try {
            int idClienteInt = Integer.parseInt(idCliente);
            int idVendedorInt = Integer.parseInt(idVendedor);
            Pedido pedidoInsert = new Pedido(fecha, estado, fechaEnvio, idClienteInt, idVendedorInt);
            pedidoDAO.insertar(pedidoInsert);
           
        } catch (Exception ex) {
            Logger.getLogger(insertarPedidoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>\n"
                + "        <title>Alta de un Pedido</title>\n"
                + "        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n"
                + "        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi\" crossorigin=\"anonymous\">\n"
                + "        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3\" crossorigin=\"anonymous\"></script>\n"
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
        out.println("<body>");
        out.println("<h1>Insertar Pedido</h1>");
        out.println("<form action=\"insertarPedidoServlet\" method=\"post\">\n"
                + "  <div class=\"mb-3\">\n"
                + "    <label for=\"InputFecha\" class=\"form-label\">Fecha de Pedido</label>\n"
                + "    <input name=\"fecha\" type=\"date\" class=\"form-control\" required >\n"
                + "  </div>\n"
                + "  <div class=\"mb-3\">\n"
                + "    <label for=\"InputEstado\" class=\"form-label\">Estado</label>\n"
                + "    <input name=\"estado\" type=\"text\" class=\"form-control\" pattern=\"[a-z]{1,30}\" title=\"Solo puede ingresar letras minusculas y no exceder los 30 caracteres\" required>\n"
                + "  </div>\n"
                + "  <div class=\"mb-3\">\n"
                + "    <label for=\"InputNombre\" class=\"form-label\">Fecha de Envio</label>\n"
                + "    <input name=\"fechaEnvio\" type=\"date\" class=\"form-control\" required>\n"
                + "  </div>\n"
                + "  <div class=\"mb-3\">\n"
                + "    <label for=\"InputNombre\" class=\"form-label\">ID Cliente</label>\n"
                + "    <input name=\"idCliente\" type=\"number\" class=\"form-control\"pattern=\"^[0-9]+\" required>\n"
                + "  </div>\n"
                + "  <div class=\"mb-3\">\n"
                + "    <label for=\"InputNombre\" class=\"form-label\">ID Vendedor</label>\n"
                + "    <input name=\"idVendedor\" type=\"number\" class=\"form-control\" pattern=\"^[0-9]+\" required>\n"
                + "  </div>\n"
                + "  <button type=\"submit\" class=\"btn btn-primary\">Insertar datos</button>\n"
                + "</form>");
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
