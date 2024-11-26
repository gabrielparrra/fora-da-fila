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
        String SQL = "INSERT INTO USUARIO (EMAIL, NOME, CPF, SENHA, TIPO) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {

            preparedStatement.setString(1, cadastro.getEmail());
            preparedStatement.setString(2, cadastro.getNome());
            preparedStatement.setString(3, cadastro.getCpf());
            preparedStatement.setString(4, cadastro.getPassword());
            preparedStatement.setString(5, cadastro.getTipo());
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
                        resultSet.getInt("id"),
                        resultSet.getString("email"),
                        resultSet.getString("nome"),
                        resultSet.getString("cpf"),
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
                        resultSet.getInt("id"),
                        resultSet.getString("email"),
                        resultSet.getString("nome"),
                        resultSet.getString("cpf"),
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
        String sql = "UPDATE USUARIO SET email = ?, nome = ?, cpf = ?, senha = ?, tipo = ? WHERE id = ?";

        try (Connection connection = getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, cadastro.getEmail());
            stmt.setString(2, cadastro.getNome());
            stmt.setString(3, cadastro.getCpf());
            stmt.setString(4, cadastro.getPassword());
            stmt.setString(5, cadastro.getTipo());
            stmt.setInt(6, cadastro.getId());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }



}
