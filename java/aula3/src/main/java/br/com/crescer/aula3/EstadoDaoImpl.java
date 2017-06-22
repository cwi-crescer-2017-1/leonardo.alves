/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula3;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author leonardo.alves
 */
public class EstadoDaoImpl implements Dao<Estado> {
    
    private static final String INSERT_ESTADO = "INSERT INTO ESTADO (ID,NOME, UF, PAIS) VALUES (?,?,?,?)";
    private static final String UPDATE_ESTADO = "UPDATE ESTADO SET NOME = ?, UF = ?, PAIS = ? WHERE ID = ?";
    private static final String DELETE_ESTADO = "DELETE FROM ESTADO WHERE ID = ?";
    private static final String LOAD_ESTADO = "SELECT * FROM ESTADO WHERE ID = ?";

    @Override
    public void insert(Estado estado) {
        try(final PreparedStatement statement = ConnectionUtils.getConnection().prepareStatement(INSERT_ESTADO)){
            
            statement.setLong(1, estado.getId());
            statement.setString(2, estado.getNome());
            statement.setString(3, estado.getUf());
            statement.setString(4, estado.getPais());
            
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }

    @Override
    public void update(Estado estado) {
        try(final PreparedStatement statement = ConnectionUtils.getConnection().prepareStatement(UPDATE_ESTADO)) {
            
            statement.setString(1, estado.getNome());
            statement.setString(2, estado.getUf());
            statement.setString(3, estado.getPais());
            statement.setLong(4, estado.getId());
            
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }

    @Override
    public void delete(Estado estado) {
        try(final PreparedStatement statement = ConnectionUtils.getConnection().prepareStatement(DELETE_ESTADO)) {
            statement.setLong(1, estado.getId());
            
            statement.executeUpdate();
        } catch(SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }

    @Override
    public Estado loadBy(Long id) {
        Estado estado = new Estado();
        try(final PreparedStatement statement = ConnectionUtils.getConnection().prepareStatement(LOAD_ESTADO)) {
            statement.setLong(1, id);
            try(final ResultSet resultSet = statement.executeQuery()){
                while(resultSet.next()){
                    estado.setId(resultSet.getLong("Id"));
                    estado.setNome(resultSet.getString("Nome"));
                    estado.setPais(resultSet.getString("Pais"));
                    estado.setUf(resultSet.getString("Uf"));
                }
            } catch(SQLException e) {
                System.err.format("SQLException: %s", e);
            }
            
            
        } catch(SQLException e) {
            System.err.format("SQLException: %s", e);
        }
        return estado;
    }    
}
