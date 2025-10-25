package com.vision.erp.service.item;

import com.vision.erp.model.entity.item.Item;
import com.vision.erp.model.entity.item.ItemDTO;
import com.vision.erp.model.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ItemService{

    @Autowired
    private ItemRepository itemRep;

    public ItemService() {
    }

    @Transactional
    public void criar(ItemDTO dto) {
        Item item = new Item(dto);
        this.itemRep.save(item);
    }

    @Transactional
    public void atualizar(ItemDTO dto) {
        Item item = new Item(dto);
        this.itemRep.save(item);
    }

    @Transactional
    public void deletar(Long id) {
        this.itemRep.deleteById(id);
    }

    public ItemDTO buscarPorId(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID inválido: " + id);
        }
        return this.itemRep.findById(id).map(ItemDTO::new)
                .orElseThrow(() -> new RuntimeException("Item não encontrado com o ID: " + id));
    }

    public List<ItemDTO> listartodos() {
        List<ItemDTO> items = this.itemRep.findAll().stream().map(ItemDTO::new).toList();
        if (items.isEmpty()) {
            throw new RuntimeException("Nenhum item encontrado.");
        }
        return items;
    }
}
