package br.com.carstore.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/create-car")
public class ForaDaFilaServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String carName = request.getParameter("car-name");

        System.out.println(carName);

        request.getRequestDispatcher("index.html").forward(request, response);
    }
}