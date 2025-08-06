package prova_spring.prova.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import prova_spring.prova.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
