/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ananicole
 */
@WebServlet(urlPatterns = {"/PortalServlet"})
public class PortalServlet extends HttpServlet {
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Formulario</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<form action=\"CadastrarUsuarioServlet\" method=\"POST\">");
            out.println("<div class=\"form-group\">");
            out.println("<label for=\"formGroupExampleInput\">Nome</label>");
            out.println("<input type=\"text\" class=\"form-control\" id=\"formGroupExampleInput\" placeholder=\"Nome\">");
            out.println("</div>");
            out.println("<div class=\"form-group\">");
            out.println("<label for=\"formGroupExampleInput2\">Login</label>");
            out.println("<input type=\"text\" class=\"form-control\" id=\"formGroupExampleInput2\" placeholder=\"Login\">");
            out.println("</div>");
            out.println("<div class=\"form-group\">");
            out.println("<label for=\"formGroupExampleInput2\">Senha</label>");
            out.println("<input type=\"password\" class=\"form-control\" id=\"formGroupExampleInput2\" placeholder=\"Senha\">");
            out.println("</div>");
            out.println("<div>");
            out.println("<a href=\"CadastrarUsuarioServlet\">Salvar</a>");
            out.println("<a href=\"LogoutServlet\">Deslogar</a>");
            out.println("</div>");
            out.println("</form>");
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
