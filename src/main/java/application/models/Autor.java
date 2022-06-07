package application.models;

/*pacotes para o funcionamento do project*/

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/* criação da tabela autores no banco de dados*/

@Entity
@Table(name="autores")

public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /* criação dos atributos da tabela*/
    private int id;
    private String nome;

    /* getters e setters dos atributos da tabela*/
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    


}
