package br.com.carstore.servlet;

import br.com.foradafila.dao.IngressoDAO;
import br.com.foradafila.modal.Ingresso;

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


        Ingresso ingresso = new Ingresso();
        ingresso.setName(nomeIngresso);
        new IngressoDAO().createIngresso(ingresso);

        request.getRequestDispatcher("index.html").forward(request, response);
    }


}
