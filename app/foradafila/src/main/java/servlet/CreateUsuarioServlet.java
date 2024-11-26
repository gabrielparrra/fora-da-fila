package servlet;

import dao.UsuarioDAO;
import model.Cadastro;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/createUsuarioServlet")
public class CreateUsuarioServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Obter o parâmetro "Id" e tratar valores vazios ou nulos
        String idParam = req.getParameter("Id");
        Integer id = (idParam != null && !idParam.isEmpty()) ? Integer.valueOf(idParam) : 0;

        // Obter os outros parâmetros do formulário
        String email = req.getParameter("email");
        String nome = req.getParameter("nome");
        String cpf = req.getParameter("cpf");
        String password = req.getParameter("password");
        String tipo = req.getParameter("tipo");

        // Criar o objeto de cadastro com os dados obtidos
        Cadastro cadastro = new Cadastro(id, email, nome, cpf, password, tipo);

        // Instanciar o DAO e realizar a operação de criação ou atualização
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        if (id != 0) {
            usuarioDAO.updateUsuario(cadastro); // Atualizar usuário existente
        } else {
            usuarioDAO.createCadastro(cadastro); // Criar novo usuário
        }

        // Redirecionar para a página de listagem de usuários
        resp.sendRedirect("/find-all-usuarios");
    }
}
