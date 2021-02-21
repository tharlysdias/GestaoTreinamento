package model;

/**
 *
 * @author tharlys
 */
public class CoffeSpace {
    
    // Atributo do espaço de café
    private int id;
    private int idPerson; // chave estrangeira
    private String name;
    private int capacity;
    
    
    // Criando construtores
    public CoffeSpace(int id, int idPerson, String name, int capacity) {
        this.id = id;
        this.idPerson = idPerson;
        this.name = name;
        this.capacity = capacity;
    }
    
    public CoffeSpace() {
        
    }
    
    
    // Métodos de acesso
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    
}
