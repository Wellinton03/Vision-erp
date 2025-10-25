package com.vision.erp.service.evento;

import com.vision.erp.model.entity.evento.Evento;
import com.vision.erp.model.entity.evento.EventoDTO;
import com.vision.erp.model.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRep;

    public EventoService() {
    }

    @Transactional
    public void criar(EventoDTO dto) {
        Evento evento = new Evento(dto);
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
