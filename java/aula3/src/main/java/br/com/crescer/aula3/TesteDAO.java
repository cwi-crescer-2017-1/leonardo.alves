/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import static java.util.stream.Collectors.toList;
import java.util.stream.LongStream;

/**
 *
 * @author leonardo.alves
 */
public final class TesteDAO {
   
    public final void drop(Connection connection, String query) {
        try (final Statement statement = connection.createStatement()) {
            statement.executeQuery(query);
        } catch (SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }

    public final void create(Connection connection, String query) {
        try (final Statement statement = connection.createStatement()) {
            statement.executeQuery(query);
        } catch (SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }

    public final void insert(Connection connection, String query) {
        try (final PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            final List<Long> list = LongStream.range(1, 1000).boxed().collect(toList());

            for (Long id : list) {
                preparedStatement.setLong(1, id);
                preparedStatement.setString(2, String.format("%s pessoa de 999", id));
                preparedStatement.executeUpdate();
            }

        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }
}
