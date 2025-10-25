package com.vision.erp.model.repository;

import com.vision.erp.model.entity.empresa.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

}
