package com.vision.erp.model.repository;

import com.vision.erp.model.entity.evento.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<Evento, Long> {
}
