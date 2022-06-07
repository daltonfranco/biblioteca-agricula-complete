package application.repositories;

/*pacotes para o funcionamento do project*/

import org.springframework.data.repository.CrudRepository;
import application.models.Livro;

/* criação da interface que extende do repositório Crud */

public interface LivroRepository extends CrudRepository<Livro, Integer>{
    
}
