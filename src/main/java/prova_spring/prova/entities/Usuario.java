package prova_spring.prova.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Usuario {

    @Id
    private Integer id;
    private String nome;
    private String email;
    private LocalDate dataCadastro;

    @OneToMany(mappedBy = "Usuario", cascade = CascadeType.ALL)
    List<Postagem> postagens = new ArrayList<>();

    @OneToMany(mappedBy = "Usuario", cascade = CascadeType.ALL)
    List<Comentario> comentarios = new ArrayList<>();

    @OneToMany(mappedBy = "Usuario", cascade = CascadeType.ALL)
    List<Curtida> curtidas = new ArrayList<>();

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

    public List<Postagem> getPostagens() {
        return postagens;
    }

    public void setPostagens(List<Postagem> postagens) {
        this.postagens = postagens;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
