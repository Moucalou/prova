package prova_spring.prova.controllers;

import org.springframework.web.bind.annotation.*;
import prova_spring.prova.entities.Usuario;
import prova_spring.prova.repositories.UsuarioRepository;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    //POST
    @PostMapping
    public Usuario criarUsuario(@RequestBody Usuario usuario){
        this.usuarioRepository.save(usuario);
        return usuario;
    }

    //GET: Listar todos os usuarios
    @GetMapping
    public List<Usuario> listar() {
        return this.usuarioRepository.findAll();
    }

    //GET: Obeter detalhes de um usuario
    @GetMapping("/{id}")
    public Usuario buscarUsuario(@PathVariable Integer id) {
        return this.usuarioRepository.findById(id).get();
    }

    //PUT: Atualizar dados do usuario
    @PutMapping("/{id}")
    public Usuario alterarUsuario(@PathVariable Integer id,
                                  @RequestBody Usuario usuario
    ) {
        Usuario alterar = this.usuarioRepository.findById(id).get();

        alterar.setNome(usuario.getNome());
        alterar.setEmail(usuario.getEmail());

        this.usuarioRepository.save(alterar);
        return alterar;
    }

    //DELETE: Deletar Usuario
    @DeleteMapping("/{id}")
    public Usuario removerUsuario(@PathVariable Integer id) {
        Usuario usuario = this.usuarioRepository.findById(id).get();
        this.usuarioRepository.deleteById(id);
        return usuario;
    }
}
