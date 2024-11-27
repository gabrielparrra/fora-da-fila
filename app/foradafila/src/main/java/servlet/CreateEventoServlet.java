package servlet;

import dao.EventoDAO;
import model.Evento;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/createEventoServlet")
public class CreateEventoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Obter parâmetros do formulário
        String eventoNome = req.getParameter("evento");
        String data = req.getParameter("data");
        String local = req.getParameter("local");
        String assento = req.getParameter("assento");
        String valor = req.getParameter("valor");

        // Criar objeto Evento
        Evento evento = new Evento(eventoNome, data, local, assento, valor);

        // Salvar no banco
        EventoDAO eventoDAO = new EventoDAO();
        eventoDAO.createEvento(evento);

        // Redirecionar
        resp.sendRedirect("/find-all-eventos");
    }
}
