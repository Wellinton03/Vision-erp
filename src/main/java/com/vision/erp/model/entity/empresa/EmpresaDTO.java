package com.vision.erp.model.entity.empresa;

import java.time.LocalDateTime;

public class EmpresaDTO {

    public EmpresaDTO() {
    }

    public EmpresaDTO(Empresa empresa) {
        this.id = empresa.getId();
        this.nome = empresa.getNome();
        this.cnpj = empresa.getCnpj();
        this.telefone = empresa.getTelefone();
        this.cidade = empresa.getCidade();
        this.email = empresa.getEmail();
        this.dtCriacao = empresa.getDtCriacao();
        this.dtAtualizacao = empresa.getDtAtualizacao();
        this.status = empresa.getStatus();
    }

    private Long id;
    private String nome;
    private String tipoEmpresa;
    private String cnpj;
    private String telefone;
    private String cidade;
    private String email;
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

    public String getTipoEmpresa() {
        return tipoEmpresa;
    }

    public void setTipoEmpresa(String tipoEmpresa) {
        this.tipoEmpresa = tipoEmpresa;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getDtAtualizacao() {
        return dtAtualizacao;
    }

    public void setDtAtualizacao(LocalDateTime dtAtualizacao) {
        this.dtAtualizacao = dtAtualizacao;
    }

    public LocalDateTime getDtCriacao() {
        return dtCriacao;
    }

    public void setDtCriacao(LocalDateTime dtCriacao) {
        this.dtCriacao = dtCriacao;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "EmpresaDTO{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", tipoEmpresa='" + tipoEmpresa + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", telefone='" + telefone + '\'' +
                ", cidade='" + cidade + '\'' +
                ", email='" + email + '\'' +
                ", dtCriacao=" + dtCriacao +
                ", dtAtualizacao=" + dtAtualizacao +
                ", status=" + status +
                '}';
    }
}
