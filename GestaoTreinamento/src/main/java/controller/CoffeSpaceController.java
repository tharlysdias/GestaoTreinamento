package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.CoffeSpace;
import util.ConnectionFactory;

/**
 *
 * @author tharlys
 */
public class CoffeSpaceController {
    
    // Criando 2 metodos, uma para cada operação que precisará ser feita
    // Vão receber a sala do evento(EventRoom) como parametro
    public void save(CoffeSpace coffeSpace) {

        // Criar uma String com o script SQL que precisa ser executado
        String sql = "INSERT INTO spaces (idPerson, name, capacity) VALUES (?,?,?)";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            // Cria uma conexão com o banco
            connection = ConnectionFactory.getConnection();
            
            // Cria um PreparedStatment, classe usada para executar a query
            statement = connection.prepareStatement(sql);
            
            statement.setInt(1, coffeSpace.getIdPerson());
            statement.setString(2, coffeSpace.getName());
            statement.setInt(3, coffeSpace.getCapacity());
            
            statement.execute();
            
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao salvar a tarefa " + ex.getMessage(), ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
    }
    
    
    public List<CoffeSpace> getAll(int idPerson) {
        
        String sql = "SELECT * FROM spaces WHERE idPerson = ?";

        Connection connection = null;
        PreparedStatement statement = null;
        
        // Guarda o que tivemos de resposta do banco de dados
        ResultSet resultSet = null;

        // Estrutura de lista (Estrutura de dados)
        List<CoffeSpace> spaces = new ArrayList<CoffeSpace>();
        
        
        try {
            // Criação da conexão
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);

            // Setando o valor que corresponde ao filtro de busca
            statement.setInt(1, idPerson);

            // Valor retornado pela execução da query
            resultSet = statement.executeQuery(); // Devolve o valor de resposta do SELECT feito no db

            // Enquanto houverem valores a serem percorridos no meu resultSet
            while (resultSet.next()) {

                // Criar uma nova tarefa
                CoffeSpace coffeSpace = new CoffeSpace();
                
                // setando o valor
                coffeSpace.setId(resultSet.getInt("id"));
                coffeSpace.setIdPerson(resultSet.getInt("idPerson"));
                coffeSpace.setName(resultSet.getString("name"));
                coffeSpace.setCapacity(resultSet.getInt("capacity"));

                // Colocar a lista dentro das salas
                spaces.add(coffeSpace);
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao inserir o espaço de café ", ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement, resultSet);
        }
        
        // Retorna os espaços de café que foram criadas e carregadas do banco de dados
        return spaces;
    }
}
