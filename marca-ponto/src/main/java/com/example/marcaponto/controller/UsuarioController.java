package com.example.marcaponto.controller;


import com.example.marcaponto.exception.ResourceNotFoundException;
import com.example.marcaponto.model.Usuario;
import com.example.marcaponto.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public List<Usuario> getAllUsuarios(){
        return usuarioRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity< Usuario > getUsuarioById(@PathVariable(value = "id") Long usuarioId)
            throws ResourceNotFoundException {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario nao encontrado para esse id :: " + usuarioId));
        return ResponseEntity.ok().body(usuario);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario createUsuario(@Valid @RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @PutMapping("/usuarios/{id}")
    public ResponseEntity < Usuario > updateUsuario(@PathVariable(value = "id") Long usuarioId,
                                                      @Valid @RequestBody Usuario usuarioDetails) throws ResourceNotFoundException {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario nao encontrado pra esse id :: " + usuarioId));

        usuario.setNomeCompleto(usuarioDetails.getNomeCompleto());
        usuario.setCpf(usuarioDetails.getCpf());
        usuario.setEmail(usuarioDetails.getEmail());

        final Usuario updatedUsuario = usuarioRepository.save(usuario);
        return ResponseEntity.ok(updatedUsuario);
    }
}
