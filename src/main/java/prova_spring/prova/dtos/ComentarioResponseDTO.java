package prova_spring.prova.dtos;

import prova_spring.prova.entities.Comentario;
import prova_spring.prova.entities.Postagem;
import prova_spring.prova.entities.Usuario;

import java.time.LocalDateTime;

public class ComentarioResponseDTO {

    private Integer id;
    private String texto;
    private LocalDateTime datacriacao;
    private Usuario usuario;
    private Postagem postagem;

    public ComentarioResponseDTO(Comentario comentario) {
        this.id = comentario.getId();
        this.postagem = comentario.getPostagem();
        this.usuario = comentario.getUsuario();
        this.datacriacao = comentario.getDatacriacao();
        this.texto = comentario.getTexto();
    }

    public Integer getId() {
        return id;
    }

    public String getTexto() {
        return texto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public LocalDateTime getDatacriacao() {
        return datacriacao;
    }

    public Postagem getPostagem() {
        return postagem;
    }
}
