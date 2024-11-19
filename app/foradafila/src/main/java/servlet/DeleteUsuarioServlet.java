package servlet;

import dao.UsuarioDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete-usuario")
public class DeleteUsuarioServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String usuarioId = req.getParameter("id"); // Certifique-se de que o parâmetro corresponde ao formulário

        if (usuarioId == null || usuarioId.isBlank()) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID do usuário não informado.");
            return;
        }

        try {
            new UsuarioDAO().deleteUsuarioById(usuarioId);
            resp.sendRedirect("/find-all-usuarios");
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao excluir usuário.");
        }
    }
}
