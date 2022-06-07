package application.models;

/*pacotes para o funcionamento do project*/

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//import org.hibernate.annotations.ManyToAny;

/* criação da tabela livros no banco de dados*/

@Entity
@Table(name="livros")
public class Livro{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    /* criação dos atributos da tabela*/

    private int id;
    private String titulo;

    /* relacionamento entre as tebelas */
    @ManyToOne
    @JoinColumn(name="id_genero")
    private Genero genero;

    @ManyToOne
    @JoinColumn(name="id_autor")
    private Autor autor;

    /* getters e setters dos atributos da tabela*/

    public Genero getGenero() {
        return genero;
    }
    public void setGenero(Genero genero) {
        this.genero = genero;
    }
    public Autor getAutor() {
        return autor;
    }
    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public int getId() {
        return id;
    }public void setId(int id) {
        this.id = id;
    }
    
    public String getTitulo() {
        return titulo;
    }public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}