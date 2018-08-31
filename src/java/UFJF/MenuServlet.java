/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UFJF;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ice
 */
@WebServlet(name = "MenuServlet", urlPatterns = {"/menu.html"})
public class MenuServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession(false);
        boolean logado = (boolean) session.getAttribute("login");
        //verificar se a sessao ta ativa
        if (logado == true) {
            try (PrintWriter out = response.getWriter()) {

                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet NewServlet</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Bem Vindo </h1>");
                out.println("<p>Esse é o menu: <p>");
                out.println("<p>"+session.getId()+"<p>");
                //out.println("<p>Esse é o menu: "+session.getAttribute("login")+"<p>");
                out.println("<a href=\"http://localhost:8080/Lab-Web/lista.html\">Lista</a><BR>");
                out.println("<a href=\"google.com\">Google</a><BR>");
                out.println("<a href=\"ufjf.br\">UFJF</a><BR><BR><BR>");
                session.invalidate();
                out.println("<a href=\"http://localhost:8080/Lab-Web/sair.html\">Voltar</a>");
                out.println("</body>");
                out.println("</html>");
            }
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
            dispatcher.forward(request, response);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
