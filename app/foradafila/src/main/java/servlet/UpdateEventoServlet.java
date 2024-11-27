package servlet;

import dao.EventoDAO;
import model.Evento;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update-evento")
public class UpdateEventoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String eventoNome = req.getParameter("evento");
        String data = req.getParameter("data");
        String local = req.getParameter("local");
        String assento = req.getParameter("assento");
        String valor = req.getParameter("valor");

        Evento evento = new Evento(id, eventoNome, data, local, assento, valor);
        EventoDAO eventoDAO = new EventoDAO();
        eventoDAO.updateEvento(evento);
        resp.sendRedirect("/find-all-eventos");
    }
}
