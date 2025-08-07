package prova_spring.prova.controllers;

import org.springframework.web.bind.annotation.*;
import prova_spring.prova.entities.Comentario;
import prova_spring.prova.entities.Curtida;
import prova_spring.prova.entities.Postagem;
import prova_spring.prova.entities.Usuario;
import prova_spring.prova.repositories.PostagemRepository;
import prova_spring.prova.repositories.UsuarioRepository;

import java.util.List;

@RestController
@RequestMapping("/postagens")
public class PostagemController {

    private final PostagemRepository postagemRepository;
    private final UsuarioRepository usuarioRepository;

    public PostagemController(PostagemRepository postagemRepository, UsuarioRepository usuarioRepository) {
        this.postagemRepository = postagemRepository;
        this.usuarioRepository = usuarioRepository;
    }

    //POST criar nova postagem (vinculada a um usuário)
    @PostMapping("/{idUsuario}")
    public Postagem criarPostagem(@RequestBody Postagem postagem,
                                  @PathVariable Integer idUsuario
    ) {
        Usuario usuario = this.usuarioRepository.findById(idUsuario).orElseThrow();
        postagem.setUsuario(usuario);
        this.postagemRepository.save(postagem);
        return postagem;
    }

    //GET listar todas as postagens
    @GetMapping
    public List<Postagem> listarPostagens() {
        List<Postagem> postagens = this.postagemRepository.findAll();
        return postagens;
    }

    //GET Detalhar uma postagem
    @GetMapping("/{id}")
    public Postagem buscarPostagem(@PathVariable Integer id) {
        return this.postagemRepository.findById(id).get();
    }

    //GET Listar comentário de uma postagem
    @GetMapping("/{id}/comentarios")
    public List<Comentario> listarComentario(@PathVariable Integer id) {

        Postagem postagem = this.postagemRepository.findById(id).get();
        List<Comentario> coment = postagem.getComentarios();
        return postagem.getComentarios();
    }

    //GET Listar todos os usuários que curtiram uma postagem
    @GetMapping("/{id}/curtidas")
    public List<Curtida> listarCurtida(@PathVariable Integer id) {
        Postagem postagem = this.postagemRepository.findById(id).get();
        List<Curtida> curt = postagem.getCurtidas();
        return postagem.getCurtidas();
    }

}
