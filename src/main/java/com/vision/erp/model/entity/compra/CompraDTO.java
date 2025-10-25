package com.vision.erp.model.entity.compra;

import com.vision.erp.model.entity.item.ItemDTO;

public class CompraDTO {

    public CompraDTO() {
    }

    private Long id;
    private String tipoCompra;
    private ItemDTO item;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoCompra() {
        return tipoCompra;
    }

    public void setTipoCompra(String tipoCompra) {
        this.tipoCompra = tipoCompra;
    }

    public ItemDTO getItem() {
        return item;
    }

    public void setItem(ItemDTO item) {
        this.item = item;
    }
}
