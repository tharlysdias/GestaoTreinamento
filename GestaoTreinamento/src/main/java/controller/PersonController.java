package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Person;
import util.ConnectionFactory;

/**
 *
 * @author tharlys
 */
public class PersonController {
    
    public void save(Person person) {
        
        // Cria o comando para executar no banco de dados
        String sql = "INSERT INTO persons (name, lastName) VALUES (?,?)";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            // Cria uma conexão com o banco
            connection = ConnectionFactory.getConnection();
            
            // Cria um PreparedStatement, classe usada para executar a query
            statement = connection.prepareStatement(sql);

            statement.setString(1, person.getName());
            statement.setString(2, person.getLastName());

            // Executa a sql para inserção dos dados
            statement.execute();
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao salvar o Projeto ", ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
    }
    
    public List<Person> getAll() {
        
        // Comando sql para fazer o SELECT dos projetos
        String sql = "SELECT * FROM persons";
        
        List<Person> persons = new ArrayList<>();
        
        Connection connection = null;
        PreparedStatement statement = null;

        // Classe que vai recuperar os dados do banco de dados
        ResultSet resultSet = null;

        try {
            connection = ConnectionFactory.getConnection();

            statement = connection.prepareStatement(sql);

            resultSet = statement.executeQuery();

            // Enquanto existir dados no banco de dados, faça
            while (resultSet.next()) {

                Person person = new Person();

                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setLastName(resultSet.getString("lastName"));

                // Adiciono o dado (id, name, lastName) recuperado, a lista de dados
                persons.add(person);
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao buscar os projetos", ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement, resultSet);
        }
        
        return persons;
    }
}
