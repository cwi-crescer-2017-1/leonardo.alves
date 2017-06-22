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
public class CidadeDaoImpl implements Dao<Cidade> {
    private static final String INSERT_CIDADE = "INSERT INTO CIDADE (ID,NOME, ESTADO) VALUES (?,?,?)";
    private static final String UPDATE_CIDADE = "UPDATE CIDADE SET NOME = ?, ESTADO = ? WHERE ID = ?";
    private static final String DELETE_CIDADE = "DELETE FROM CIDADE WHERE ID = ?";
    private static final String LOAD_CIDADE = "SELECT * FROM CIDADE WHERE ID = ?";

    @Override
    public void insert(Cidade cidade) {
        try(PreparedStatement statement = ConnectionUtils.getConnection().prepareStatement(INSERT_CIDADE)){
            statement.setLong(1, cidade.getId());
            statement.setString(2, cidade.getNome());
            statement.setString(3, cidade.getEstado());
            
            statement.executeUpdate();
        } catch(SQLException e) {
            System.err.format("SQLEXCEPTION: %s", e);
        }
    }

    @Override
    public void update(Cidade cidade) {
        try(PreparedStatement statement = ConnectionUtils.getConnection().prepareStatement(UPDATE_CIDADE)){
            statement.setString(1, cidade.getNome());
            statement.setString(3, cidade.getEstado());
            statement.setLong(3, cidade.getId());
            
            statement.executeUpdate();
        } catch(SQLException e) {
            System.err.format("SQLEXCEPTION: %s", e);
        }
        
    }

    @Override
    public void delete(Cidade cidade) {
        try(PreparedStatement statement = ConnectionUtils.getConnection().prepareStatement(DELETE_CIDADE)){
            statement.setLong(1, cidade.getId());
           
            statement.executeUpdate();
        } catch(SQLException e) {
            System.err.format("SQLEXCEPTION: %s", e);
        }
    }

    @Override
    public Cidade loadBy(Long id) {
        Cidade cidade = new Cidade();
        try(PreparedStatement statement = ConnectionUtils.getConnection().prepareStatement(LOAD_CIDADE)){
            statement.setLong(1, id);
           
            try(ResultSet resultSet = statement.executeQuery()) {
                while(resultSet.next()){
                    cidade.setEstado(resultSet.getString("Estado"));
                    cidade.setNome(resultSet.getString("Nome"));
                    cidade.setId(resultSet.getLong("Id"));
                }
            } catch (SQLException e) {
                System.err.format("SQLEXCEPTION: %s", e);
            }
        } catch(SQLException e) {
            System.err.format("SQLEXCEPTION: %s", e);
        }
        
        return cidade;
    }    
}
