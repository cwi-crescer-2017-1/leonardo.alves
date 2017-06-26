package br.com.crescer.aula5;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author leonardo.alves
 */
public class PessoaServlet extends HttpServlet {

    private List<String> nomes = new ArrayList<>();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        try (final PrintWriter out = resp.getWriter();) {
            out.append("Renato russo removed");
            
            nomes.forEach(n -> out.append(n).append("<br/>"));
        }
    }
    
    @Override    
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        nomes.add(req.getParameter("nome"));
        
        resp.sendRedirect("pessoa");
    }

}
