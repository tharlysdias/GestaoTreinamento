package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Essa classe é responsavel por uma conexão com o Banco de
 * dados, que irá devolver pra alguma parte do código ao qual precise fazer uma
 * consulta no banco de dados, uma inserção no banco, consultar e etc.
 * 
 * @author tharlys
 */
public class ConnectionFactory {
    
    // Atributos para conectar com o banco
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    // Caminho de conexão até o banco de dados - onde está o banco
    public static final String URL = "jdbc:mysql://localhost:3306/gestaotreinamento";
    // Informar ao user será utilizado, normalmente o MySql vem com o root
    public static final String USER = "root";
    // e com o password fazio, sem segurança. Podendo ser alterado
    public static final String PASS = "";
    
    // Esse metodo devolve/retorna uma conexão static
    public static Connection getConnection() {
        // try - catch: Pega erros que podem acontecer, para fazer um tratamento
        // Tratamento de exceção e erro
        try {
            // Carrega o driver da nossa aplicação
            Class.forName(DRIVER);
            // Faz uma conexão com esses parametros
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception ex) {
            throw new RuntimeException("Erro na conexão com o banco de dados ", ex);
        }
    }

    public static void closeConnection(Connection connection) {
        try {
            // Se a conexão existir, feche-a
            if (connection != null) {
                connection.close();
            }
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao fechar a conexão com o banco de dados ", ex);
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
            throw new RuntimeException("Erro ao fechar a conexão com o banco de dados ", ex);
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
            throw new RuntimeException("Erro ao fechar a conexão com o banco de dados ", ex);
        }
    }
    
}
