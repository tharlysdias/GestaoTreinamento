package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.EventRoom;
import util.ConnectionFactory;

/**
 *
 * @author tharlys
 */
public class EventRoomController {
    
    // Criando 2 metodos, uma para cada operação que precisará ser feita
    // Vão receber a sala do evento(EventRoom) como parametro
    public void save(EventRoom eventRoom) {

        // Criar uma String com o script SQL que precisa ser executado
        String sql = "INSERT INTO rooms (idPerson, name, capacity) VALUES (?,?,?)";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            // Cria uma conexão com o banco
            connection = ConnectionFactory.getConnection();
            // Cria um PreparedStatment, classe usada para executar a query
            statement = connection.prepareStatement(sql);
            
            statement.setInt(1, eventRoom.getIdPerson());
            statement.setString(2, eventRoom.getName());
            statement.setInt(3, eventRoom.getCapacity());
            
            statement.execute();
            
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao salvar a tarefa " + ex.getMessage(), ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
    }
    
    
    public List<EventRoom> getAll(int idPerson) {
        
        String sql = "SELECT * FROM rooms WHERE idPerson = ?";

        Connection connection = null;
        PreparedStatement statement = null;
        
        // Guarda o que tivemos de resposta do banco de dados
        ResultSet resultSet = null;

        // Estrutura de lista (Estrutura de dados)
        List<EventRoom> rooms = new ArrayList<EventRoom>();
        
        
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
                EventRoom eventRoom = new EventRoom();
                
                // setando o valor
                eventRoom.setId(resultSet.getInt("id"));
                eventRoom.setIdPerson(resultSet.getInt("idPerson"));
                eventRoom.setName(resultSet.getString("name"));
                eventRoom.setCapacity(resultSet.getInt("capacity"));

                // Colocar a lista dentro das salas
                rooms.add(eventRoom);
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao inserir a sala ", ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement, resultSet);
        }
        
        // Retorna as salas que foram criadas e carregadas do banco de dados
        return rooms;
    }
}
