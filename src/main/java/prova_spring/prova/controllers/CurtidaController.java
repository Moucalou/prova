package prova_spring.prova.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import prova_spring.prova.dtos.ComentarioRequestDTO;
import prova_spring.prova.dtos.ComentarioResponseDTO;
import prova_spring.prova.dtos.CurtidaRequestDTO;
import prova_spring.prova.dtos.CurtidaResponseDTO;
import prova_spring.prova.entities.Comentario;
import prova_spring.prova.entities.Curtida;
import prova_spring.prova.repositories.CurtidaRepository;
import prova_spring.prova.repositories.PostagemRepository;
import prova_spring.prova.repositories.UsuarioRepository;

@RestController
@RequestMapping("/curtidas")
public class CurtidaController {

    private final CurtidaRepository curtidaRepository;
    private final UsuarioRepository usuarioRepository;
    private final PostagemRepository postagemRepository;

    public CurtidaController(CurtidaRepository curtidaRepository, UsuarioRepository usuarioRepository, PostagemRepository postagemRepository) {
        this.curtidaRepository = curtidaRepository;
        this.usuarioRepository = usuarioRepository;
        this.postagemRepository = postagemRepository;
    }

    @PostMapping
    public CurtidaResponseDTO criarComentario(
            @RequestBody CurtidaRequestDTO request
    ) {
        Curtida novo = new Curtida();

        novo.setUsuario(usuarioRepository.findById(request.getIdUsuario()).get());
        novo.setPostagem(postagemRepository.findById(request.getIdPostagem()).get());

        this.curtidaRepository.save(novo);

        return new CurtidaResponseDTO(novo);
    }


}
