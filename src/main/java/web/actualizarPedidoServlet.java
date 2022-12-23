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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author artur
 */
@WebServlet(name = "actualizarPedidoServlet", urlPatterns = {"/actualizarPedidoServlet"})
public class actualizarPedidoServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PedidoDAO pedidoDAO = new PedidoDAO();

        String id = request.getParameter("id");
        String fecha = request.getParameter("fecha");
        String estado = request.getParameter("estado");
        String fechaEnvio = request.getParameter("fechaEnvio");
        String idCliente = request.getParameter("idCliente");
        String idVendedor = request.getParameter("idVendedor");

        try {
            int idInt = Integer.parseInt(id);
            int idClienteInt = Integer.parseInt(idCliente);
            int idVendedorInt = Integer.parseInt(idVendedor);
            Pedido pedidoUpdate = new Pedido(idInt, fecha, estado, fechaEnvio, idClienteInt, idVendedorInt);
            pedidoDAO.actualizar(pedidoUpdate);
        } catch (Exception e) {
            Logger.getLogger(actualizarPedidoServlet.class.getName()).log(Level.SEVERE, null, e);
        }

        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");

            out.println("<head>");
            out.println("<link href=\'https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css\' rel=\'stylesheet\' integrity=\'sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC\' crossorigin=\'anonymous\'>");
            out.println("<title>Actualizar Pedido</title>");
            out.println("</head>");
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
            out.println("<h1>Actualizar Pedido</h1>");
            out.print("<table class=\"table\">\n"
                    + "  <thead>\n"
                    + "    <tr>\n"
                    + "      <th scope=\"col\">ID Pedido</th>\n"
                    + "      <th scope=\"col\">Fecha</th>\n"
                    + "      <th scope=\"col\">Estado</th>\n"
                    + "      <th scope=\"col\">Fecha Envio</th>\n"
                    + "      <th scope=\"col\">ID Cliente</th>\n"
                    + "      <th scope=\"col\">ID Vendedor</th>\n"
                    + "    </tr>\n"
                    + "  </thead>\n"
                    + "  <tbody>\n");

            try {
                for (Pedido pedido : pedidoDAO.seleccionar()) {
                    out.println("<tr>");
                    out.println(" <th scope=\"row\">" + pedido.getIdPedido() + "</th>");
                    out.println("<td>" + pedido.getFecha() + "</td>");
                    out.println("<td>" + pedido.getEstado() + "</td>");
                    out.println("<td>" + pedido.getFechaEnvio() + "</td>");
                    out.println("<td>" + pedido.getIdCliente() + "</td>");
                    out.println("<td>" + pedido.getIdVendedor() + "</td>");
                    out.println("</tr>");
                }
            } catch (Exception e) {
                Logger.getLogger(actualizarPedidoServlet.class.getName()).log(Level.SEVERE, null, e);
            }

            out.print("</tbody></table><hr>");

            out.println("<form action=\"actualizarPedidoServlet\" method=\"post\">\n"
                    + "  <div class=\"mb-3\">\n"
                    + "    <label for=\"InputNombre\" class=\"form-label\">ID</label>\n"
                    + "    <input name=\"id\" type=\"number\" class=\"form-control\"pattern=\"^[0-9]+\" required>\n"
                    + "  <div class=\"mb-3\">\n"
                    + "    <label for=\"InputFecha\" class=\"form-label\">Fecha</label>\n"
                    + "    <input name=\"fecha\" type=\"date\" class=\"form-control\" required>\n"
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
                    + "    <input name=\"idCliente\" type=\"number\" class=\"form-control\" pattern=\"^[0-9]+\" required>\n"
                    + "  </div>\n"
                    + "  <div class=\"mb-3\">\n"
                    + "    <label for=\"InputNombre\" class=\"form-label\">ID Vendedor</label>\n"
                    + "    <input name=\"idVendedor\" type=\"number\" class=\"form-control\"pattern=\"^[0-9]+\" required>\n"
                    + "  </div>\n"
                    + "  <button type=\"submit\" class=\"btn btn-primary\">Actualizar datos</button>\n"
                    + "</form>");

            out.println("</body>");
            out.println("</html>");
        }
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
