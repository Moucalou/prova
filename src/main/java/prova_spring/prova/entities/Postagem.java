package prova_spring.prova.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Postagem {

    @Id
    private Integer id;
    private String conteudo;
    private LocalDateTime dataCriacao;
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    @JsonIgnore
    private Usuario usuario;

    @OneToMany(mappedBy = "postagem", cascade = CascadeType.ALL)
    private List<Curtida> curtidas = new ArrayList<>();

    @OneToMany(mappedBy = "postagem", cascade = CascadeType.ALL)
    private List<Comentario> comentarios = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public List<Curtida> getCurtidas() {
        return curtidas;
    }

    public void setCurtidas(List<Curtida> curtidas) {
        this.curtidas = curtidas;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }
}
