package dao;

import model.Evento;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EventoDAO {
    private static final String URL = "jdbc:h2:~/test";
    private static final String USER = "sa";
    private static final String PASSWORD = "sa";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Método para criar um novo evento
    public void createEvento(Evento evento) {
        String SQL = "INSERT INTO EVENTO (EVENTO, DATA, LOCAL, ASSENTO, VALOR) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {

            preparedStatement.setString(1, evento.getEvento());
            preparedStatement.setString(2, evento.getData());
            preparedStatement.setString(3, evento.getLocal());
            preparedStatement.setString(4, evento.getAssento());
            preparedStatement.setString(5, evento.getValor());
            preparedStatement.executeUpdate();

            System.out.println("Evento cadastrado com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar evento: " + e.getMessage());
        }
    }

    // Método para buscar todos os eventos
    public List<Evento> findAllEventos() {
        List<Evento> eventos = new ArrayList<>();
        String SQL = "SELECT * FROM EVENTO";

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SQL)) {

            while (resultSet.next()) {
                Evento evento = new Evento(
                        resultSet.getInt("id"),
                        resultSet.getString("evento"),
                        resultSet.getString("data"),
                        resultSet.getString("local"),
                        resultSet.getString("assento"),
                        resultSet.getString("valor")
                );
                eventos.add(evento);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar eventos: " + e.getMessage());
        }

        return eventos;
    }

    // Método para buscar um evento pelo ID
    public Evento getEventoById(int id) {
        String SQL = "SELECT * FROM EVENTO WHERE ID = ?";
        Evento evento = null;

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                evento = new Evento(
                        resultSet.getInt("id"),
                        resultSet.getString("evento"),
                        resultSet.getString("data"),
                        resultSet.getString("local"),
                        resultSet.getString("assento"),
                        resultSet.getString("valor")
                );
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar evento por ID: " + e.getMessage());
        }

        return evento;
    }

    // Método para atualizar um evento existente
    public void updateEvento(Evento evento) {
        String SQL = "UPDATE EVENTO SET EVENTO = ?, DATA = ?, LOCAL = ?, ASSENTO = ?, VALOR = ? WHERE ID = ?";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {

            preparedStatement.setString(1, evento.getEvento());
            preparedStatement.setString(2, evento.getData());
            preparedStatement.setString(3, evento.getLocal());
            preparedStatement.setString(4, evento.getAssento());
            preparedStatement.setString(5, evento.getValor());
            preparedStatement.setInt(6, evento.getId());
            preparedStatement.executeUpdate();

            System.out.println("Evento atualizado com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar evento: " + e.getMessage());
        }
    }

    // Método para deletar um evento pelo ID
    public void deleteEventoById(int id) {
        String SQL = "DELETE FROM EVENTO WHERE ID = ?";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            System.out.println("Evento excluído com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao excluir evento: " + e.getMessage());
        }
    }
}
