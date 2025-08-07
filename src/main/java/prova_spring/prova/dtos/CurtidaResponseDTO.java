package prova_spring.prova.dtos;

import prova_spring.prova.entities.Curtida;
import prova_spring.prova.entities.Postagem;
import prova_spring.prova.entities.Usuario;

public class CurtidaResponseDTO {

    private Integer id;
    private Postagem postagem;
    private Usuario usuario;

    public CurtidaResponseDTO(Curtida curtida) {
        this.id = curtida.getId();
        this.postagem = curtida.getPostagem();
        this.usuario = curtida.getUsuario();
    }

    public Integer getId() {
        return id;
    }

    public Postagem getPostagem() {
        return postagem;
    }

    public Usuario getUsuario() {
        return usuario;
    }
}
