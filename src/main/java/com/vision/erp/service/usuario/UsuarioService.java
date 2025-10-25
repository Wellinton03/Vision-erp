package com.vision.erp.service.usuario;

import ch.qos.logback.classic.spi.IThrowableProxy;
import com.vision.erp.model.entity.empresa.Empresa;
import com.vision.erp.model.entity.usuario.Usuario;
import com.vision.erp.model.entity.usuario.UsuarioDTO;
import com.vision.erp.model.repository.EmpresaRepository;
import com.vision.erp.model.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.module.FindException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRep;

    @Autowired
    private EmpresaRepository empresaRep;

    public UsuarioService() {
    }

    @Transactional
    public void criar(UsuarioDTO dto) {
        Optional<Empresa> empresa  = Optional.empty();
        if(dto.getEmpresaId() != null) {
            empresa = this.empresaRep.findById(Long.valueOf(dto.getEmpresaId()));
        }
        if(empresa.isEmpty()) {
            throw new FindException("Empresa não encontrada");
        }
        Usuario usuario = new Usuario(dto);
        if(usuario.getDtCriacao() == null) {
            usuario.setDtCriacao(LocalDateTime.now());
        }
        usuario.setEmpresa(empresa.get());
        usuario.setDtAtualizacao(LocalDateTime.now());
        usuario.setStatus(true);
        this.usuarioRep.save(usuario);
    }

    @Transactional
    public void atualizar(UsuarioDTO dto) {
        Usuario usuario = new Usuario(dto);
        this.usuarioRep.save(usuario);
    }

    @Transactional
    public void deletar(Long id) {
        this.usuarioRep.deleteById(id);
    }

    public UsuarioDTO buscarPorId(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID inválido: " + id);
        }
        return this.usuarioRep.findById(id).map(UsuarioDTO::new).orElseThrow(() -> new RuntimeException("Usuário não encontrado com o ID: " + id));
    }


    public List<UsuarioDTO> listarTodos() {
        List<UsuarioDTO> usuarios = this.usuarioRep.findAll().stream().map(UsuarioDTO::new).toList();
        if (usuarios.isEmpty()) {
            throw new RuntimeException("Nenhum usuário encontrado.");
        }
        return usuarios;
    }
}
