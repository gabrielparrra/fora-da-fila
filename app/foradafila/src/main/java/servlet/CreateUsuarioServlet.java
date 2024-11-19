package servlet;
import dao.UsuarioDAO;
import model.Cadastro;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/createUsuarioServlet")
public class CreateUsuarioServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("Id");
        String email = req.getParameter("email");
        String nome = req.getParameter("nome");
        String cpf = req.getParameter("cpf");
        String nascimentoStr = req.getParameter("nascimento");
        String password = req.getParameter("password");
        String tipo = req.getParameter("tipo");

        Date nascimento = null;
        try {
            nascimento = new SimpleDateFormat("yyyy-MM-dd").parse(nascimentoStr);
        } catch (ParseException e) {
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Data de nascimento inválida");
            return;
        }

        Cadastro cadastro = new Cadastro(id, email, nome, cpf, nascimento, password, tipo);

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        if (id != null && !id.isBlank()) {
            usuarioDAO.updateUsuario(cadastro);
        } else {
            usuarioDAO.createCadastro(cadastro);
        }
        resp.sendRedirect("/find-all-usuarios");
    }
}
