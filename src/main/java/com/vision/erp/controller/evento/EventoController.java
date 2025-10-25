package com.vision.erp.controller.evento;

import com.vision.erp.model.entity.evento.EventoDTO;
import com.vision.erp.service.evento.EventoService;
import org.hibernate.query.IllegalQueryOperationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/evento")
@CrossOrigin(origins = "http://localhost:8081")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @GetMapping("/listar")
    public ResponseEntity listarTodos() {
        try {
            List<EventoDTO> eventos = this.eventoService.listartodos();
            return ResponseEntity.ok(eventos);
        } catch (IllegalQueryOperationException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity listarPorId(@PathVariable Long id) {
        try {
            EventoDTO evento = this.eventoService.buscarPorId(id);
            return ResponseEntity.ok(evento);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/cadastrar")
    public ResponseEntity criar(@RequestBody EventoDTO evento) {
        try {
            this.eventoService.criar(evento);
            return ResponseEntity.status(201).build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/editar")
    public ResponseEntity atualizar(@RequestBody EventoDTO evento) {
        try {
            this.eventoService.atualizar(evento);
            return ResponseEntity.status(200).build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity deletar(@PathVariable Long id) {
        try {
            this.eventoService.deletar(id);
            return ResponseEntity.status(200).build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
