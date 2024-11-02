package dao;

import model.Cadastro;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UsuarioDAO {

     public void createCadastro(Cadastro cadastro){
         String SQL;
         SQL = "INSERT INTO USUARIO (,EMAIL, NOME, CPF, DATA_NASCIMENTO, SENHA, TIPO) VALUES (?,?,?,?,?,?)";

         try {
               Connection connection =  DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

              System.out.println("sucesso na conexão com o banco de dados");

              PreparedStatement preparedStatement = connection.prepareStatement(SQL);
              preparedStatement.setString(1, cadastro.getEmail());
              preparedStatement.setString(2, cadastro.getNome());
              preparedStatement.setString(3, cadastro.getCpf());
              preparedStatement.setDate(4, Date.valueOf(cadastro.getNascimento()));
              preparedStatement.setString(5, cadastro.getPassword());
              preparedStatement.setString(6, cadastro.getTipo());
              preparedStatement.execute();
              System.out.println("Cadastrado com sucesso");
              connection.close();


         } catch (Exception e) {
              System.out.println("Não foi possivel executar o banco de dados");
         }
     }

    public List<Cadastro> findAllUsuarios() {

        String SQL = "SELECT * FROM USUARIO";

        try {

            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("Sucesso na conexão com o banco de dados");


            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Cadastro> cadastros = new ArrayList<>();


            while (resultSet.next()) {
                String Id = resultSet.getString("id");
                String email = resultSet.getString("email");
                String nome = resultSet.getString("nome");
                String cpf = resultSet.getString("cpf");
                Date nascimento = Date.valueOf(resultSet.getString("Data_Nascimento"));
                String password = resultSet.getString("Senha");
                String tipo = resultSet.getString("Tipo");


                Cadastro cadastro = new Cadastro(Id,email, nome, cpf, nascimento, password, tipo);
                cadastros.add(cadastro);
            }

            System.out.println("Sucesso ao selecionar lista de cadastros");
            connection.close();
            return cadastros;


        } catch (Exception e) {
            System.out.println("Erro ao selecionar lista de cadastros");

        return Collections.emptyList();
        }


    }

    public void deleteUsuarioById(String usuarioId) {

         String SQL = "DELETE USUARIO WHERE ID = ?";

         try{
             Connection connection =  DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

             System.out.println("sucesso na conexão com o banco de dados");

             PreparedStatement preparedStatement = connection.prepareStatement(SQL);
             preparedStatement.setString(1,usuarioId);
             preparedStatement.execute();
             System.out.println("Usuario excluido com sucesso");
             connection.close();
         } catch (Exception e) {
             System.out.println("Erro ao excluir usuario");
         }
    }

    public void updateUsuario(Cadastro cadastro) {
        String SQL = "UPDATE USUARIO SET EMAIL = ?, NOME = ?, CPF = ?, DATA_NASCIMENTO = ?, SENHA = ?, TIPO = ? WHERE id = ?";

        try (Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {

            preparedStatement.setString(1, cadastro.getEmail());
            preparedStatement.setString(2, cadastro.getNome());
            preparedStatement.setString(3, cadastro.getCpf());
            preparedStatement.setDate(4, java.sql.Date.valueOf(cadastro.getNascimento()));
            preparedStatement.setString(5, cadastro.getPassword());
            preparedStatement.setString(6, cadastro.getTipo());
            preparedStatement.setString(7, cadastro.getId());
            System.out.println("Sucesso ao atualizar usuario");
            connection.close();
        } catch (Exception e) {
            System.out.println("Erro ao atualizar usuário: " + e.getMessage());
        }

    }
}

