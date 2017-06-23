
package br.com.crescer.aula3.sql.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
/** 
 * @author leonardo.alves
 **/
public class SqlUtilsImpl implements SqlUtils {

    /** Executa várias instruções SQL.
     * @param filename nome do arquivo a ser carregado.
     */
    @Override
    public void runFile(String filename) {
        String querys [] = null;
        final SqlUtilsDAO dao;
        final StringBuilder sb;
        final File file = new File(filename);  
        
        if(!filename.endsWith(".sql")) throw new RuntimeException("ERRO: Informe um arquivo .sql");
        
        try (final Reader reader = new FileReader(file);
             final BufferedReader bufferedReader = new BufferedReader(reader)) {
            
            sb = new StringBuilder();            
            bufferedReader.lines().forEach(sb::append);            
            querys = sb.toString().split(";");            
            
        } catch (IOException e) {
            System.err.format("IOException: %s", e);
        }
        
        dao = new SqlUtilsDAO();
        
        Arrays.asList(querys).forEach(dao::runQuery);
        
    }

    /**
     * Com base na query, transforma os dados relacionais em CSV.
     * @param query Query a ser executada.
     * @return Retorna a tabela com o nome das colunas e as linhas.
     */
    @Override
    public String executeQuery(String query) {
        SqlUtilsDAO dao = new SqlUtilsDAO();
        String csvTabela = dao.toCSV(query);
        
        return csvTabela;
    }

    /**
     *  Importa os dados CSV de um arquivo CSV no banco.
     *  O nome do arquivo será a tabela referenciada.
     *  A primeira linha será as colunas da tabela, e as restantes os dados.
     * @param file arquivo CSV a ser importado.
     */
    @Override
    public void importCSV(File file) {
        final StringBuilder sb;
        final SqlUtilsDAO dao;
        String tabela, colunas [], valores [];        
        
        if(!file.getName().endsWith(".csv")) throw new RuntimeException("Apenas .csv permitido");
        
        try (final Reader reader = new FileReader(file);
             final BufferedReader bufferedReader = new BufferedReader(reader)) {
            String primeiraLinha = bufferedReader.readLine();
            
            sb = new StringBuilder();
            colunas = primeiraLinha.split(",");
            tabela = file.getName().split("\\.")[0];
            
            bufferedReader.lines().forEach(sb::append);            
            valores = sb.toString().split(",");
            
            dao = new SqlUtilsDAO();
            dao.saveCSV(tabela, colunas, valores);
        } catch (IOException e) {
            System.err.format("IOEXCEPTION : %s", e);
        }  
    }

    /**
     * Exporta uma tabela para arquivo no formato CSV.
     * @param query Query a ser salva no arquivo.
     * @return File .csv
     */
    @Override
    public File importCSV(String query) {
       final String conteudoCsv = executeQuery(query);
       final Date dataCriacao = new Date();
       final SimpleDateFormat formato = new SimpleDateFormat("dd.MM.yyyy hh-mm-ss");
       final String fileName = "csv-file-".concat(formato.format(dataCriacao)).concat(".csv");
       final File file = new File(fileName);
       
        try (final Writer writer = new FileWriter(file);
                final BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            
            bufferedWriter.append(conteudoCsv);
            bufferedWriter.flush();
            
        } catch (IOException e) {
            System.err.format("IOEXCEPTION: %s",e);
        }
        return file;  
    }

}
