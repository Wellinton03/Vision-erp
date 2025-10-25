package com.vision.erp.model.entity.venda;

import com.vision.erp.model.entity.item.ItemDTO;

public class VendaDTO {

    public VendaDTO() {
    }

    private Long id;
    private String tipoVenda;
    private ItemDTO item;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoVenda() {
        return tipoVenda;
    }

    public void setTipoVenda(String tipoVenda) {
        this.tipoVenda = tipoVenda;
    }

    public ItemDTO getItem() {
        return item;
    }

    public void setItem(ItemDTO item) {
        this.item = item;
    }
}
