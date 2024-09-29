package br.com.carstore.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/fora-da-fila")
public class CreateForaDaFilaServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nomeIngresso = request.getParameter("nome_ingresso");
        String nIngresso = request.getParameter("n_ingresso");

        System.out.println(nomeIngresso);
        System.out.println(nIngresso);

        request.getRequestDispatcher("index.html").forward(request, response);
    }


}
