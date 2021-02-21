package model;

/**
 *
 * @author tharlys
 */
public class CoffeSpace {
    
    // Atributo do espaço de café
    private int id;
    private int idPessoa; // chave estrangeira
    private String name;
    private int capacity;
    
    
    // Criando construtor
    public CoffeSpace(int id, int idPessoa, String name, int capacity) {
        this.id = id;
        this.idPessoa = idPessoa;
        this.name = name;
        this.capacity = capacity;
    }
    
    
    // Métodos de acesso
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
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
