package br.com.foradafila.dao;

import br.com.foradafila.modal.Ingresso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class IngressoDAO {

    public void createIngresso(Ingresso ingresso) {

        String SQL= "INSERT INTO INGRESSO (ID_INGRESSO_PK) VALUES (?)";

        try {

            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa","sa");

            System.out.println("success in database connection");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, ingresso.getName());
            preparedStatement.execute();

            System.out.println("successo!");

            connection.close();

        } catch (Exception e) {

            System.out.println("erro!");

        }

    }
}
