package com.example.marcaponto.controller;

import com.example.marcaponto.exception.ResourceNotFoundException;
import com.example.marcaponto.model.BatePonto;
import com.example.marcaponto.model.Usuario;
import com.example.marcaponto.repository.BatePontoRepository;
import com.example.marcaponto.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/batePonto")
public class BatePontoController {

    @Autowired
    private BatePontoRepository batePontoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public Iterable<BatePonto> getAllPontos(){
        return batePontoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity< BatePonto > getPontoById(@PathVariable(value = "id") Long pontoId)
            throws ResourceNotFoundException {
        BatePonto batePonto = batePontoRepository.findById(pontoId)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario nao encontrado para esse id :: " + pontoId));
        return ResponseEntity.ok().body(batePonto);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BatePonto createPonto(@Valid @RequestBody BatePonto batePonto) {
        return batePontoRepository.save(batePonto);
    }

    @PutMapping("/{id}")
    public ResponseEntity < BatePonto > updatePonto(@PathVariable(value = "id") Long pontoId,
                                                    @Valid @RequestBody BatePonto pontoDetails) throws ResourceNotFoundException {
        BatePonto batePonto = batePontoRepository.findById(pontoId)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario nao encontrado pra esse id :: " + pontoId));

        batePonto.setUsuarioId(pontoDetails.getUsuarioId());
        batePonto.setTipoBatida(pontoDetails.getTipoBatida());
        batePonto.setDate(pontoDetails.getDate());

        final BatePonto updatedPonto = batePontoRepository.save(batePonto);
        return ResponseEntity.ok(updatedPonto);
    }
}
