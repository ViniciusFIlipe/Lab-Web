/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UFJF;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
        
        String usuario1 = request.getParameter("usuario");
        String senha1 = request.getParameter("senha");
        try (PrintWriter out = response.getWriter()) {
boolean result;
            String JDBC_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";

            Connection conn = null;
            Statement stmt = null;
            String resp = null;
// Set response content type
            try {
// Register JDBC driver
                Class.forName(JDBC_DRIVER);
// Open a connection
                conn = DriverManager.getConnection("jdbc:derby://localhost:1527/lp04", "admin1", "admin");
// Execute SQL query
                stmt = conn.createStatement();
                String sql;
                sql = "SELECT usuario, senha FROM usuarios where upper(usuario) ='" + usuario1.toUpperCase() + "' and senha='" + senha1 + "'";
                ResultSet rs = stmt.executeQuery(sql);
// Extract data from result set
                if (rs.next()) {
                    result = true;
                }
                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException e) {
//Handle errors for JDBC
//throw new ServletException(e);
                resp = e.getMessage();
                throw new ServletException(e);
            } catch (Exception e) {
//Handle errors for Class.forName
//throw new ServletException(e);
                resp = e.getMessage();
                throw new ServletException(e);
            } finally {
                System.out.printf(resp);
//finally block used to close resources
                try {
                    if (stmt != null) {
                        stmt.close();
                    }
                } catch (SQLException e) {
                    throw new ServletException(e);
                }// nothing we can do
                try {
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException e) {
                    throw new ServletException(e);
                }//end finally try
            }

            if (result = true) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet NewServlet</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Bem Vindo " + usuario1 + "</h1>");
                //out.println("<p>Aplicacao: " + aplicacao + " URL:" + url + "</p>");
                out.println("<a href=\"http://localhost:8080/Lab-Web/\">Voltar</a>");
                out.println("</body>");
                out.println("</html>");
                response.sendRedirect(request.getContextPath() + "/menu.html");
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
