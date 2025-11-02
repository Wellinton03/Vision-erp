package com.vision.erp.service.evento;

import com.vision.erp.model.entity.empresa.Empresa;
import com.vision.erp.model.entity.evento.Evento;
import com.vision.erp.model.entity.evento.EventoDTO;
import com.vision.erp.model.entity.usuario.Usuario;
import com.vision.erp.model.repository.EventoRepository;
import com.vision.erp.model.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.module.FindException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EventoService {

    @Autowired
    private UsuarioRepository usuarioRep;

    @Autowired
    private EventoRepository eventoRep;

    public EventoService() {
    }

    @Transactional
    public void criar(EventoDTO dto) {
        Optional<Usuario> relator = Optional.empty();
        Optional<Usuario> responsavel = Optional.empty();
        if (dto.getRelatorId() != null || dto.getResponsavelId() != null) {
            relator = this.usuarioRep.findById(Long.valueOf(dto.getRelatorId()));
            responsavel = this.usuarioRep.findById((Long.valueOf(dto.getResponsavelId())));
        }
        if (relator.isEmpty() || responsavel.isEmpty()) {
            throw new FindException("Relator e Responsável não foram encontrados");
        }
        Evento evento = new Evento(dto);
        if (evento.getDtInclusao() == null) {
            evento.setDtInclusao(LocalDateTime.now());
        }
        evento.setRelator(relator.get());
        evento.setResponsavel(responsavel.get());
        evento.setDtAlteracao(LocalDateTime.now());
        this.eventoRep.save(evento);
    }

    @Transactional
    public void atualizar(EventoDTO dto) {
        Evento evento = new Evento(dto);
        this.eventoRep.save(evento);
    }

    @Transactional
    public void deletar(Long id) {
        this.eventoRep.deleteById(id);
    }

    public EventoDTO buscarPorId(Long id) {
        if(id == null) {
            throw new IllegalArgumentException("ID inválido: " + id);
        }
        return this.eventoRep.findById(id).map(EventoDTO::new)
                .orElseThrow(() -> new RuntimeException("Evento não encontrado com o ID: " + id));
    }

    public List<EventoDTO> listartodos() {
        List<EventoDTO> eventos = this.eventoRep.findAll().stream().map(EventoDTO::new).toList();
        if(eventos.isEmpty()) {
            throw new RuntimeException("Nenhum evento encontrado.");
        }
        return eventos;
    }
}
