package servlet;
import dao.UsuarioDAO;
import model.Cadastro;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;


@WebServlet("/createUsuarioServlet")
public class CreateUsuarioServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("Id");
        String email = req.getParameter("email");
        String nome = req.getParameter("nome");
        String cpf = req.getParameter("cpf");
        Date nascimento = null;

        try {
            nascimento = Date.valueOf(req.getParameter("nascimento"));
        } catch (IllegalArgumentException e) {
            // Trate o erro de data inválida aqui
            e.printStackTrace();
        }

        String password = req.getParameter("password");
        String passwordConfirm = req.getParameter("password_confirm");
        String tipo = req.getParameter("tipo");

// Criando o objeto Cadastro
        Cadastro cadastro = new Cadastro(id, email, nome, cpf, nascimento, password, tipo);

// Instanciando o DAO de usuário
        UsuarioDAO usuarioDAO = new UsuarioDAO();

// Verificando se é uma atualização ou criação de usuário
        if (id != null && !id.isBlank()) {
            usuarioDAO.updateUsuario(cadastro);
        } else {
            usuarioDAO.createCadastro(cadastro);
        }


        resp.sendRedirect("/find-all-usuarios");
    }
}


