package br.com.crescer.aula3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import static java.util.stream.Collectors.toList;
import java.util.stream.LongStream;
import static br.com.crescer.aula3.ConnectionUtils.getConnection;
/**
 * @author carloshenrique
 */
public class ExemploDDL {

    private static final String DROP_TABLE = "DROP TABLE TESTE";

    private static final String CREATE_TABLE = "CREATE TABLE TESTE ( \n"
            + "  ID NUMBER(8) NOT NULL,\n"
            + "  NOME VARCHAR2(60) DEFAULT NULL, \n"
            + "  CONSTRAINT TESTE_PK PRIMARY KEY (ID)  ENABLE \n"
            + ")";

    private static final String INSERT_TESTE = " INSERT INTO TESTE (ID, NOME) VALUES (?,?)";

    public static void main(String[] args) {   

        try (final Connection connection = getConnection()) {
            TesteDAO dao = new TesteDAO();
            // DROP
            dao.drop(connection, DROP_TABLE);

            // CREATE
            dao.create(connection, CREATE_TABLE);

            //INSERT
            dao.insert(connection, INSERT_TESTE);
    
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }
}
