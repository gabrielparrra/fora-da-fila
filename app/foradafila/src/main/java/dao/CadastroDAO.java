package dao;

import model.Cadastro;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CadastroDAO {

     public void createCadastro(Cadastro cadastro){
         String SQL = "INSERT INTO USUARIO (EMAIL, NOME, CPF, DATA_NASCIMENTO, SENHA, TIPO) VALUES (?,?,?,?,?,?)";

         try {
               Connection connection =  DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

              System.out.println("sucesso na conexão com o banco de dados");

              PreparedStatement preparedStatement = connection.prepareStatement(SQL);
              preparedStatement.setString(1, cadastro.getEmail());
              preparedStatement.setString(2, cadastro.getNome());
              preparedStatement.setString(3, cadastro.getCpf());
              preparedStatement.setString(4,cadastro.getNascimento());
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

                String email = resultSet.getString("email");
                String nome = resultSet.getString("nome");
                String cpf = resultSet.getString("cpf");
                String nascimento = resultSet.getString("Data_Nascimento");
                String password = resultSet.getString("Senha");
                String tipo = resultSet.getString("Tipo");


                Cadastro cadastro = new Cadastro(email, nome, cpf, nascimento, password, tipo);
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
}

