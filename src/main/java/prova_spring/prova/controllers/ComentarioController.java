package prova_spring.prova.controllers;

import org.springframework.web.bind.annotation.*;
import prova_spring.prova.dtos.ComentarioRequestDTO;
import prova_spring.prova.dtos.ComentarioResponseDTO;
import prova_spring.prova.entities.Comentario;
import prova_spring.prova.repositories.ComentarioRepository;
import prova_spring.prova.repositories.PostagemRepository;
import prova_spring.prova.repositories.UsuarioRepository;

@RestController
@RequestMapping("/comentarios")
public class ComentarioController {

    private final ComentarioRepository comentarioRepository;
    private final PostagemRepository postagemRepository;
    private final UsuarioRepository usuarioRepository;


    public ComentarioController(ComentarioRepository comentarioRepository, PostagemRepository postagemRepository, UsuarioRepository usuarioRepository) {
        this.comentarioRepository = comentarioRepository;
        this.postagemRepository = postagemRepository;
        this.usuarioRepository = usuarioRepository;
    }

    //POST
    @PostMapping
    public ComentarioResponseDTO criarComentario(
            @RequestBody ComentarioRequestDTO request
            ) {
        Comentario novo = new Comentario();

        novo.setTexto(request.getTexto());
        novo.setDatacriacao(request.getDatacriacao());

        novo.setUsuario(usuarioRepository.findById(request.getIdUsuario()).get());
        novo.setPostagem(postagemRepository.findById(request.getIdPostagem()).get());

        this.comentarioRepository.save(novo);

        return new ComentarioResponseDTO(novo);
    }
}
