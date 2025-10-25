package com.vision.erp.controller.item;

import com.vision.erp.model.entity.item.ItemDTO;
import com.vision.erp.service.item.ItemService;
import org.hibernate.query.IllegalQueryOperationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/item")
@CrossOrigin(origins = "http://localhost:8081")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/listar")
    public ResponseEntity listarTodos() {
        try {
            List<ItemDTO> itens = this.itemService.listartodos();
            return ResponseEntity.ok(itens);
        } catch (IllegalQueryOperationException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity listarPorId(@PathVariable Long id) {
        try {
            ItemDTO item = this.itemService.buscarPorId(id);
            return ResponseEntity.ok(item);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/cadastrar")
    public ResponseEntity criar(@RequestBody ItemDTO item) {
        try {
            this.itemService.criar(item);
            return ResponseEntity.status(201).build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/editar")
    public ResponseEntity atualizar(@RequestBody ItemDTO item) {
        try {
            this.itemService.atualizar(item);
            return ResponseEntity.status(200).build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity deletar(@PathVariable Long id) {
        try {
            this.itemService.deletar(id);
            return ResponseEntity.status(200).build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
