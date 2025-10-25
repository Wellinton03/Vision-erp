package com.vision.erp.model.repository;

import com.vision.erp.model.entity.venda.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaRepostory extends JpaRepository<Venda, Long> {
}
