package com.vision.erp.model.entity.evento;

import com.vision.erp.model.entity.item.Item;
import com.vision.erp.model.entity.usuario.Usuario;
import com.vision.erp.model.entity.usuario.UsuarioDTO;
import com.vision.erp.model.enun.StatusEvento;

import java.time.LocalDateTime;

public class EventoDTO {

    public EventoDTO() {
    }

    public EventoDTO(Evento evento) {
        this.id = evento.getId();
        this.statusEvento = evento.getStatusEvento();
        this.tipoEvento = evento.getTipoEvento();
        this.descricao = evento.getDescricao();
        this.dtAlteracao = evento.getDtAlteracao();
        this.setorResponsavel = evento.getSetorResponsavel();
        this.dtInclusao = evento.getDtInclusao();
        this.item = evento.getItem();
        if(evento.getRelator() != null) {
            this.relator = new UsuarioDTO(evento.getRelator());
        }
        if(evento.getResponsavel() != null) {
            this.responsavel = new UsuarioDTO(evento.getResponsavel());
        }
    }

    private Long id;
    private StatusEvento statusEvento;
    private String tipoEvento;
    private String descricao;
    private UsuarioDTO relator;
    private String relatorId;
    private UsuarioDTO responsavel;
    private String responsavelId;
    private String setorResponsavel;
    private LocalDateTime dtAlteracao;
    private LocalDateTime dtInclusao;
    private Item item;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StatusEvento getStatusEvento() {
        return statusEvento;
    }

    public void setStatusEvento(StatusEvento statusEvento) {
        this.statusEvento = statusEvento;
    }

    public String getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public UsuarioDTO getRelator() {
        return relator;
    }

    public void setRelator(UsuarioDTO relator) {
        this.relator = relator;
    }

    public String getRelatorId() {
        return relatorId;
    }

    public void setRelatorId(String relatorId) {
        this.relatorId = relatorId;
    }

    public UsuarioDTO getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(UsuarioDTO responsavel) {
        this.responsavel = responsavel;
    }

    public String getResponsavelId() {
        return responsavelId;
    }

    public void setResponsavelId(String responsavelId) {
        this.responsavelId = responsavelId;
    }

    public String getSetorResponsavel() {
        return setorResponsavel;
    }

    public void setSetorResponsavel(String setorResponsavel) {
        this.setorResponsavel = setorResponsavel;
    }

    public LocalDateTime getDtAlteracao() {
        return dtAlteracao;
    }

    public void setDtAlteracao(LocalDateTime dtAlteracao) {
        this.dtAlteracao = dtAlteracao;
    }

    public LocalDateTime getDtInclusao() {
        return dtInclusao;
    }

    public void setDtInclusao(LocalDateTime dtInclusao) {
        this.dtInclusao = dtInclusao;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "EventoDTO{" +
                "id=" + id +
                ", statusEvento=" + statusEvento +
                ", tipoEvento='" + tipoEvento + '\'' +
                ", descricao='" + descricao + '\'' +
                ", relator=" + relator +
                ", relatorId='" + relatorId + '\'' +
                ", responsavel=" + responsavel +
                ", responsavelId='" + responsavelId + '\'' +
                ", setorResponsavel='" + setorResponsavel + '\'' +
                ", dtAlteracao=" + dtAlteracao +
                ", dtInclusao=" + dtInclusao +
                ", item=" + item +
                '}';
    }
}
