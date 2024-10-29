package servlet;
import dao.CadastroDAO;
import model.Cadastro;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet("/createForaDaFila")
public class CreateForaDaFila extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String email = req.getParameter("email");
        String nome = req.getParameter("nome");
        String cpf = req.getParameter("cpf");
        String nascimento = req.getParameter("nascimento");
        String password = req.getParameter("password");
        String password_confirm = req.getParameter("password_confirm");
        String tipo = req.getParameter("tipo");



        Cadastro cadastro = new Cadastro(email, nome, cpf, nascimento, password, tipo);

        new CadastroDAO().createCadastro(cadastro);



        resp.sendRedirect("/find-all-usuarios");
    }
}


