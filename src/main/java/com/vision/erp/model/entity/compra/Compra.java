package com.vision.erp.model.entity.compra;

import com.vision.erp.model.entity.item.Item;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "compra")
public class Compra {

    public Compra() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="tipo_compra", nullable=false)
    private String tipoCompra;

    @ManyToOne
    @JoinColumn(name="item_id", nullable=false)
    private Item item;

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

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Compra compra = (Compra) o;
        return Objects.equals(id, compra.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
