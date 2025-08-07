package prova_spring.prova.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
    public Comentario criarComentario() {

    }



}
