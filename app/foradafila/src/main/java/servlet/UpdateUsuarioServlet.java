package servlet;

import dao.UsuarioDAO;
import model.Cadastro;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateUsuarioServlet")
public class UpdateUsuarioServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Capturar e validar o ID
        String idParam = req.getParameter("id");
        int id;

        try {
            if (idParam != null && !idParam.trim().isEmpty()) {
                id = Integer.parseInt(idParam); // Convertendo o ID para inteiro
            } else {
                throw new IllegalArgumentException("ID não fornecido ou inválido."); // Mensagem de erro clara
            }
        } catch (IllegalArgumentException e) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Erro no ID: " + e.getMessage());
            return; // Encerrar execução caso o ID seja inválido
        }

        // Capturar outros parâmetros
        id = Integer.parseInt(req.getParameter("id"));
        String email = req.getParameter("email");
        String nome = req.getParameter("nome");
        String cpf = req.getParameter("cpf");
        String password = req.getParameter("password");
        String tipo = req.getParameter("tipo");

        // Criar o objeto Cadastro
        Cadastro cadastro = new Cadastro(id, email, nome, cpf, password, tipo);

        // Atualizar o usuário no banco de dados
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        boolean isUpdated = usuarioDAO.updateUsuario(cadastro);

        // Verificar se a atualização foi bem-sucedida
        if (isUpdated) {
            resp.sendRedirect("/find-all-usuarios"); // Redirecionar para a listagem de usuários
        } else {
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao atualizar o usuário.");
        }
    }
}
