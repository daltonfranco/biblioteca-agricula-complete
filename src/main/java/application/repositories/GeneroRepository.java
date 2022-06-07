package application.repositories;

/*pacotes para o funcionamento do project*/

import org.springframework.data.repository.CrudRepository;
import application.models.Genero;

/* criação da interface que extende do repositório Crud */

public interface GeneroRepository extends CrudRepository<Genero, Integer>{
    
}
