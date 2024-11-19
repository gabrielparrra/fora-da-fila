package dao;

import model.Cadastro;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class UsuarioDAO {

    private static final String URL = "jdbc:h2:~/test";
    private static final String USER = "sa";
    private static final String PASSWORD = "sa";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Método para criar um novo cadastro
    public void createCadastro(Cadastro cadastro) {
        String SQL = "INSERT INTO USUARIO (EMAIL, NOME, CPF, DATA_NASCIMENTO, SENHA, TIPO) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {

            preparedStatement.setString(1, cadastro.getEmail());
            preparedStatement.setString(2, cadastro.getNome());
            preparedStatement.setString(3, cadastro.getCpf());
            preparedStatement.setDate(4, new Date(cadastro.getNascimento().getTime())); // Conversão para SQL Date
            preparedStatement.setString(5, cadastro.getPassword());
            preparedStatement.setString(6, cadastro.getTipo());
            preparedStatement.executeUpdate();

            System.out.println("Cadastro realizado com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao criar cadastro: " + e.getMessage());
        }
    }

    // Método para buscar todos os usuários
    public List<Cadastro> findAllUsuarios() {
        String SQL = "SELECT * FROM USUARIO";
        List<Cadastro> cadastros = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Cadastro cadastro = new Cadastro(
                        resultSet.getString("id"),
                        resultSet.getString("email"),
                        resultSet.getString("nome"),
                        resultSet.getString("cpf"),
                        resultSet.getDate("data_nascimento"), // Converte SQL Date para Date
                        resultSet.getString("senha"),
                        resultSet.getString("tipo")
                );
                cadastros.add(cadastro);
            }

            System.out.println("Lista de usuários obtida com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao buscar usuários: " + e.getMessage());
        }

        return cadastros.isEmpty() ? Collections.emptyList() : cadastros;
    }

    // Método para deletar um usuário pelo ID
    public void deleteUsuarioById(String usuarioId) {
        String SQL = "DELETE FROM USUARIO WHERE ID = ?";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {

            preparedStatement.setString(1, usuarioId);
            preparedStatement.executeUpdate();

            System.out.println("Usuário excluído com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao excluir usuário: " + e.getMessage());
        }
    }
    // Método para buscar um usuário pelo ID
    public Cadastro getUsuarioById(String id) {
        String SQL = "SELECT * FROM USUARIO WHERE ID = ?";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {

            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return new Cadastro(
                        resultSet.getString("id"),
                        resultSet.getString("email"),
                        resultSet.getString("nome"),
                        resultSet.getString("cpf"),
                        resultSet.getDate("data_nascimento"), // Conversão para SQL Date
                        resultSet.getString("senha"),
                        resultSet.getString("tipo")
                );
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar usuário por ID: " + e.getMessage());
        }

        return null;
    }

    // Método para atualizar um cadastro existente
    public boolean updateUsuario(Cadastro cadastro) {
        String SQL = "UPDATE USUARIO SET EMAIL = ?, NOME = ?, CPF = ?, DATA_NASCIMENTO = ?, SENHA = ?, TIPO = ? WHERE ID = ?";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {

            // Verifique os valores antes de definir no PreparedStatement
            System.out.println("Dados enviados para atualização:");
            System.out.println("Email: " + cadastro.getEmail());
            System.out.println("Nome: " + cadastro.getNome());
            System.out.println("CPF: " + cadastro.getCpf());
            System.out.println("Data Nascimento: " + cadastro.getNascimento());
            System.out.println("Senha: " + cadastro.getPassword());
            System.out.println("Tipo: " + cadastro.getTipo());
            System.out.println("ID: " + cadastro.getId());

            // Definindo os valores
            preparedStatement.setString(1, cadastro.getEmail());
            preparedStatement.setString(2, cadastro.getNome());
            preparedStatement.setString(3, cadastro.getCpf());
            if (cadastro.getNascimento() != null) {
                preparedStatement.setDate(4, new java.sql.Date(cadastro.getNascimento().getTime()));
            } else {
                preparedStatement.setNull(4, java.sql.Types.DATE);
            }
            preparedStatement.setString(5, cadastro.getPassword());
            preparedStatement.setString(6, cadastro.getTipo());
            preparedStatement.setString(7, cadastro.getId());

            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Linhas afetadas: " + rowsAffected);
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar usuário: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }



}
