package br.com.crescer.aula3.sql.utils;

import br.com.crescer.aula3.ConnectionUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author leonardo.alves
 *
 */
public final class SqlUtilsDAO {

    /** Executa a determinada query informada pelo parâmetro.
     * @param query Query a ser executada pelo método.
     * @throws SQLException     
    **/
    public final void runQuery(String query) {
        try (final Connection connection = ConnectionUtils.getConnection();
                final Statement statement = connection.createStatement()) {

            statement.executeQuery(query);

        } catch (SQLException e) {
            System.err.format("SQLEXCEPTION : %s", e);
        }
    }
    /** Transforma o resultado da query para String CSV. 
     *  @param query Query a ser executada pelo método.
     *  @return Tabela em formato Comma Separated Values.
    **/
    public final String toCSV(String query) {
        StringBuilder sb = null;
        ResultSetMetaData metaData;
        int columnNumbers;
        
        try (final Connection connection = ConnectionUtils.getConnection();
                final Statement statement = connection.createStatement();
                final ResultSet resultSet = statement.executeQuery(query)) {

            metaData = resultSet.getMetaData();
            columnNumbers = metaData.getColumnCount();            
            
            sb = new StringBuilder();         
            
            for(int i = 1; i <= columnNumbers; i++)
                sb.append(metaData.getColumnName(i)).append(",");  
            
            sb.deleteCharAt(sb.length() - 1);
            sb.append("\n");

            while (resultSet.next()) {
                for (int i = 1; i <= columnNumbers; i++) {
                    sb.append(resultSet.getString(i)).append(",");
                }
                sb.deleteCharAt(sb.length() - 1);
                sb.append("\n");
            }
            
            sb.deleteCharAt(sb.length() - 1);
            
        } catch (SQLException e) {
            System.err.format("SQLEXCEPTION : %s", e);
        }
        
        return sb.toString();
    }
    
    /**
     * Salva as informações do arquivo CSV no banco de dados.
     * @param tabela Nome da tabela no qual as informações serão salvas.
     * @param colunas Nome das colunas onde serão inseridos os valores.
     * @param valores Valores a serem inseridos.
     * @return True se foi salvo com sucesso.
     */
    public final boolean saveCSV (String tabela, String [] colunas, String [] valores) {       
        final int numColunas = colunas.length;
        final int numValores = valores.length;
        final String query = gerarQuery(colunas, tabela);
        
        try (final Connection connection = ConnectionUtils.getConnection();
                final PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            
            int pos = 0;
            
            for(int i = 0; i < numValores; i++){ 
                
                preparedStatement.setObject(++pos, valores[i]);
                
                if((i + 1) % numColunas == 0) {
                    preparedStatement.addBatch();
                    pos = 0;
                }
            }
            
           preparedStatement.executeBatch();
           connection.commit();
           return true;
        } catch (SQLException e) {
            System.err.format("SQLEXCEPTION : %s", e);
        }
        return false;
    }
    
    private String gerarQuery (String colunas[], String tabela) {
        StringBuilder bColunas = new StringBuilder();        
        StringBuilder bValores = new StringBuilder();

        String query;
        String valColunas;
        String coringas;
        
        for (String coluna : colunas) {
            bColunas.append(coluna).append(",");
            bValores.append("?,");
        }
        bColunas.deleteCharAt(bColunas.length() - 1);  
        bValores.deleteCharAt(bValores.length() - 1);     

        valColunas = bColunas.toString();
        coringas   = bValores.toString();
        
        query = String.format("INSERT INTO %1s (%2s) VALUES (%3s)", tabela, valColunas, coringas);
        
       return query;
    }
}
