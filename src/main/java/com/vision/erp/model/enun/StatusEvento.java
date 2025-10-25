package com.vision.erp.model.enun;

public enum StatusEvento {
    A_FAZER(1, "A Fazer"),
    EM_ANDAMENTO(2, "Em Andamento"),
    CONCLUIDO(3, "Conclu�do"),
    CANCELADO(4, "Cancelado");

    private final int codigo;
    private final String descricao;

    StatusEvento(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    // Utilit�rio para buscar enum pelo c�digo
    public static StatusEvento fromCodigo(int codigo) {
        for (StatusEvento status : StatusEvento.values()) {
            if (status.getCodigo() == codigo) {
                return status;
            }
        }
        throw new IllegalArgumentException("C�digo inv�lido: " + codigo);
    }
}

