package application.repositories;

/*pacotes para o funcionamento do project*/

import org.springframework.data.repository.CrudRepository;
import application.models.Autor;

/* criação da interface que extende do repositório Crud */

public interface AutorRepository extends CrudRepository<Autor, Integer>{
    
}
