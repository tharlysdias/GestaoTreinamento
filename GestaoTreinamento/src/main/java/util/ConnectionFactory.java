package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Essa classe � responsavel por uma conex�o com o Banco de
 * dados, que ir� devolver pra alguma parte do c�digo ao qual precise fazer uma
 * consulta no banco de dados, uma inser��o no banco, consultar e etc.
 * 
 * @author tharlys
 */
public class ConnectionFactory {
    
    // Atributos para conectar com o banco
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    // Caminho de conex�o at� o banco de dados - onde est� o banco
    public static final String URL = "jdbc:mysql://localhost:3306/gestaotreinamento";
    // Informar ao user ser� utilizado, normalmente o MySql vem com o root
    public static final String USER = "root";
    // e com o password fazio, sem seguran�a. Podendo ser alterado
    public static final String PASS = "";
    
    // Esse metodo devolve/retorna uma conex�o static
    public static Connection getConnection() {
        // try - catch: Pega erros que podem acontecer, para fazer um tratamento
        // Tratamento de exce��o e erro
        try {
            // Carrega o driver da nossa aplica��o
            Class.forName(DRIVER);
            // Faz uma conex�o com esses parametros
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception ex) {
            throw new RuntimeException("Erro na conex�o com o banco de dados ", ex);
        }
    }

    public static void closeConnection(Connection connection) {
        try {
            // Se a conex�o existir, feche-a
            if (connection != null) {
                connection.close();
            }
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao fechar a conex�o com o banco de dados ", ex);
        }
    }

    public static void closeConnection(Connection connection, PreparedStatement statement) {
        try {
            if (connection != null) {
                connection.close();
            }

            if (statement != null) {
                statement.close();
            }
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao fechar a conex�o com o banco de dados ", ex);
        }
    }

    public static void closeConnection(Connection connection, PreparedStatement statement, ResultSet resultSet) {
        try {
            if (connection != null) {
                connection.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (resultSet != null) {
                resultSet.close();
            }
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao fechar a conex�o com o banco de dados ", ex);
        }
    }
    
}
