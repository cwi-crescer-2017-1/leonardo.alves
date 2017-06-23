package br.com.crescer.aula3.sql.utils;

import java.io.File;

/**
 * @author carloshenrique
 */
public interface SqlUtils {

    void runFile(String filename);

    String executeQuery(String query);
    
    void importCSV(File file);
    
    File importCSV(String query);

}