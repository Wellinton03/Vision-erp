package com.vision.erp.controller.empresa;

import com.vision.erp.model.entity.empresa.EmpresaDTO;
import com.vision.erp.service.empresa.EmpresaService;
import org.hibernate.query.IllegalQueryOperationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empresa")
@CrossOrigin(origins = "http://localhost:8081")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @GetMapping("/listar")
    public ResponseEntity listarTodos() {
        try {
            List<EmpresaDTO> empresas = this.empresaService.listartodos();
            return ResponseEntity.ok(empresas);
        } catch (IllegalQueryOperationException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity listarPorId(@PathVariable Long id) {
        try {
            EmpresaDTO empresa = this.empresaService.buscarPorId(id);
            return ResponseEntity.ok(empresa);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/cadastrar")
    public ResponseEntity criar(@RequestBody EmpresaDTO empresa) {
        try {
            this.empresaService.criar(empresa);
            return ResponseEntity.status(201).build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/editar")
    public ResponseEntity atualizar(@RequestBody EmpresaDTO empresa) {
        try {
            this.empresaService.criar(empresa);
            return ResponseEntity.status(200).build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity deletar(@PathVariable Long id) {
        try {
            this.empresaService.deletar(id);
            return ResponseEntity.status(200).build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
