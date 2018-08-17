/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UFJF;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/NewServlet.html"})

public class NewServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String aplicacao = (String) this.getServletContext().getInitParameter("aplicacao");
        String url = (String) this.getInitParameter("url");
        try (PrintWriter out = response.getWriter()) {
            String usuario = request.getParameter("usuario");
            String senha = request.getParameter("senha");
            if ("123".equals(senha)) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet NewServlet</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Bem Vindo " + usuario + "</h1>");
                //out.println("<p>Aplicacao: " + aplicacao + " URL:" + url + "</p>");
                out.println("<a href=\"http://localhost:8080/Lab-Web/\">Voltar</a>");
                out.println("</body>");
                out.println("</html>");
               response.sendRedirect(request.getContextPath()+"/menu.html");
            } else {/* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet NewServlet</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Exercicio 1</h1>");
                out.println("<p>Usuario ou senha inválido</p>");
                out.println("<a href=\"http://localhost:8080/Lab-Web/\">Voltar</a>");
                out.println("</body>");
                out.println("</html>");
            }
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
