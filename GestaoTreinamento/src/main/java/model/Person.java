package model;

import java.util.logging.Logger;

/**
 *
 * @author tharlys
 */
public class Person {
    
    // Atributos da pessoa (Est�o privados para garantir o encapsulamento das informa��es de cada objeto).
    private int id;
    private String name;
    private String lastName;
    private static final Logger LOG = Logger.getLogger(Person.class.getName());
    
    
    // Criando Construtor
    public Person(int id, String name, String lastName) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
    }
    
    public Person() {
        
    }
    
    
    // Getters and Setters
    // M�todos de acesso
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lasName) {
        this.lastName = lasName;
    }

    // M�todo publico que retorna uma String, a qual recebe o nome da classe e o valor que esta armazenado no atributo
    @Override
    public String toString() {
        return this.name;
    }
    
}
