/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.servlets;

import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ananicole
 */
@WebServlet(name = "ClientesServlet", urlPatterns = {"/ClientesServlet"})
public class ClientesServlet extends HttpServlet {

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
            throws ServletException, IOException, ClassNotFoundException, SQLException, ParseException {

        HttpSession session = request.getSession();

        if (session == null || session.getAttribute("user") == null) {

            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            request.setAttribute("msg", "Usuario deve se autenticar para acessar o sistema.");
            rd.forward(request, response);

        } else {

            String action = request.getParameter("action");
            RequestDispatcher rd = null;
            int id = 0;
            List<Cliente> lista = null;
            Cliente c = null;

            //Identificação da action
            if (!StringUtils.isNullOrEmpty(action)) {
                switch (action) {
                try {
                            lista = ClienteFacade.selectAll();
                        } catch (InstantiationException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }catch (IllegalAccessException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                rd = request.getRequestDispatcher("clientesListar.jsp");
                request.setAttribute("lista", lista);
                rd.forward(request, response);
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
            protected void doGet
            (HttpServletRequest request,
                    HttpServletResponse response
                        )
            throws ServletException
                        , IOException  {
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
            protected void doPost
            (HttpServletRequest request,
                    HttpServletResponse response
                        )
            throws ServletException
                        , IOException  {
                processRequest(request, response);
            }

            /**
             * Returns a short description of the servlet.
             *
             * @return a String containing servlet description
             */
            @Override
            public String getServletInfo
                         
                
            
            
                () {
        return "Short description";
            }// </editor-fold>

        }