package com.vision.erp.model.entity.relatoriaIA;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

public class RelatorioIA {

	public RelatorioIA() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "eventos_analis")
	private List<Integer> eventos;

	@Lob
	@Column(name = "relatorio", columnDefinition = "TEXT")
	private String relatorio;

	@Column(name = "dt_inicio_pesq")
	private LocalDate dtInicioPesq;

	@Column(name = "dt_final_pesq")
	private LocalDate dtFinalPesq;

	@Column( name = "dt_criacao")
	private LocalDate dtCriacao;

	public Integer getId() {
		return id;
	}

	public void setId( Integer id ) {
		this.id = id;
	}

	public List< Integer > getEventos() {
		return eventos;
	}

	public void setEventos( List< Integer > eventos ) {
		this.eventos = eventos;
	}

	public String getRelatorio() {
		return relatorio;
	}

	public void setRelatorio( String relatorio ) {
		this.relatorio = relatorio;
	}

	public LocalDate getDtInicioPesq() {
		return dtInicioPesq;
	}

	public void setDtInicioPesq( LocalDate dtInicioPesq ) {
		this.dtInicioPesq = dtInicioPesq;
	}

	public LocalDate getDtFinalPesq() {
		return dtFinalPesq;
	}

	public void setDtFinalPesq( LocalDate dtFinalPesq ) {
		this.dtFinalPesq = dtFinalPesq;
	}

	public LocalDate getDtCriacao() {
		return dtCriacao;
	}

	public void setDtCriacao( LocalDate dtCriacao ) {
		this.dtCriacao = dtCriacao;
	}

	@Override
	public String toString() {
		return "RelatorioIA{" +
				"id=" + id +
				", eventos=" + eventos +
				", relatorio='" + relatorio + '\'' +
				", dtInicioPesq=" + dtInicioPesq +
				", dtFinalPesq=" + dtFinalPesq +
				", dtCriacao=" + dtCriacao +
				'}';
	}
}
