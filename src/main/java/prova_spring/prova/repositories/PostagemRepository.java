package prova_spring.prova.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import prova_spring.prova.entities.Postagem;

public interface PostagemRepository extends JpaRepository<Postagem, Integer> {
}
