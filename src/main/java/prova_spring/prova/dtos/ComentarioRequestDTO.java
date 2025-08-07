package prova_spring.prova.dtos;

import java.time.LocalDateTime;

public class ComentarioRequestDTO {

    private String texto;
    private LocalDateTime datacriacao;
    private Integer idUsuario;
    private Integer idPostagem;

    public String getTexto() {
        return texto;
    }

    public LocalDateTime getDatacriacao() {
        return datacriacao;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public Integer getIdPostagem() {
        return idPostagem;
    }
}
