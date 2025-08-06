package prova_spring.prova.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import prova_spring.prova.entities.Comentario;

public interface ComentarioRepository extends JpaRepository<Comentario, Integer> {
}
