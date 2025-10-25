package com.vision.erp.model.entity.empresa;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "empresa")
public class Empresa {

    public Empresa() {
    }

    public Empresa(EmpresaDTO dto) {
        this.id = dto.getId();
        this.nome = dto.getNome();
        this.tipoEmpresa = dto.getTipoEmpresa();
        this.cnpj = dto.getCnpj();
        this.telefone = dto.getTelefone();
        this.cidade = dto.getCidade();
        this.email = dto.getEmail();
        this.dtCriacao = dto.getDtCriacao();
        this.dtAtualizacao = dto.getDtAtualizacao();
        this.status = dto.getStatus();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nome", nullable=false)
    private String nome;

    @Column(name="tipoEmpresa", nullable=false)
    private String tipoEmpresa;

    @Column(name="cnpj", nullable=false, unique=true)
    private String cnpj;

    @Column(name="telefone", nullable=false)
    private String telefone;

    @Column(name="cidade", nullable=false)
    private String cidade;

    @Column(name="email", nullable=false)
    private String email;

    @Column(name="dt_criacao", nullable=false)
    private LocalDateTime dtCriacao;

    @Column(name="dt_atualizacao", nullable=false)
    private LocalDateTime dtAtualizacao;

    @Column(name = "status", nullable = false)
    private Boolean status;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Empresa empresa = (Empresa) o;
        return Objects.equals(id, empresa.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Empresa{" +
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
