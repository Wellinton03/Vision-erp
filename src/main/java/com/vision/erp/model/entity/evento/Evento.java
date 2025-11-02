package com.vision.erp.model.entity.evento;

import com.vision.erp.model.entity.item.Item;
import com.vision.erp.model.entity.usuario.Usuario;
import com.vision.erp.model.enun.StatusEvento;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "evento")
public class Evento {

    public Evento() {
    }

    public Evento(EventoDTO dto) {
        this.id = dto.getId();
        this.statusEvento = dto.getStatusEvento();
        this.tipoEvento = dto.getTipoEvento();
        this.descricao = dto.getDescricao();
        this.setorResponsavel = dto.getSetorResponsavel();
        this.dtAlteracao = dto.getDtAlteracao();
        this.dtInclusao = dto.getDtInclusao();

        if (dto.getItem() != null) {
            this.item = new Item(dto.getItem());
        }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "status_evento")
    private StatusEvento statusEvento;

    @Column(name = "tipo_evento")
    private String tipoEvento;

    @Column(name = "descricao")
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "relator")
    private Usuario relator;

    @ManyToOne
    @JoinColumn(name = "responsavel")
    private Usuario responsavel;

    @Column(name = "setor_responsavel")
    private String setorResponsavel;

    @Column(name = "dt_alt")
    private LocalDateTime dtAlteracao;

    @Column(name = "dt_inc")
    private LocalDateTime dtInclusao;

    @Column(name = "data_evento")
    private LocalDateTime dataEvento;

    @ManyToOne
    @JoinColumn(name = "item_id")
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

    public Usuario getRelator() {
        return relator;
    }

    public void setRelator(Usuario relator) {
        this.relator = relator;
    }

    public Usuario getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Usuario responsavel) {
        this.responsavel = responsavel;
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

    public LocalDateTime getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(LocalDateTime dataEvento) {
        this.dataEvento = dataEvento;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Evento evento = (Evento) o;
        return Objects.equals(id, evento.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
