package servlet;

import dao.EventoDAO;
import model.Evento;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@WebServlet("/find-all-eventos")
public class ListEventosServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EventoDAO eventoDAO = new EventoDAO();
        List<Evento> eventos = eventoDAO.findAllEventos();
        req.setAttribute("ingresso", eventos);
        req.getRequestDispatcher("/telas/dashboard-ingressos.jsp").forward(req, resp);
    }
}
