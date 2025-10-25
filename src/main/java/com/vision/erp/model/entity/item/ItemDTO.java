package com.vision.erp.model.entity.item;

import java.time.LocalDateTime;

public class ItemDTO {

    public ItemDTO() {
    }

    public ItemDTO(Item item) {
        this.id = item.getId();
        this.nome = item.getNome();
        this.descricao = item.getDescricao();
        this.valor = item.getValor();
        this.quantidade = item.getQuantidade();
        this.dtCriacao = item.getDtCriacao();
        this.dtAtualizacao = item.getDtAtualizacao();
        this.status = item.getStatus();
    }

    private Long id;
    private String nome;
    private String descricao;
    private Double valor;
    private Integer quantidade;
    private LocalDateTime dtCriacao;
    private LocalDateTime dtAtualizacao;
    private Boolean status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double preco) {
        this.valor = preco;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public LocalDateTime getDtCriacao() {
        return dtCriacao;
    }

    public void setDtCriacao(LocalDateTime dtCriacao) {
        this.dtCriacao = dtCriacao;
    }

    public LocalDateTime getDtAtualizacao() {
        return dtAtualizacao;
    }

    public void setDtAtualizacao(LocalDateTime dtAtualizacao) {
        this.dtAtualizacao = dtAtualizacao;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
