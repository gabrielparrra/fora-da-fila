package servlet;

import dao.CadastroDAO;
import model.Cadastro;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/find-all-usuarios")
public class ListUsuariosServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Cadastro> usuarios = new CadastroDAO().findAllUsuarios();
        req.setAttribute("usuarios", usuarios);


        usuarios.forEach(usuario -> System.out.println("Usuário: " + usuario));
        req.getRequestDispatcher("/telas/dashboard.jsp").forward(req, resp);
    }
}
