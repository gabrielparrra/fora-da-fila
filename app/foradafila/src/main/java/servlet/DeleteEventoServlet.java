package servlet;

import dao.EventoDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete-ingresso")
public class DeleteEventoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        EventoDAO eventoDAO = new EventoDAO();
        eventoDAO.deleteEventoById(id);
        resp.sendRedirect("/find-all-eventos");
    }
}
