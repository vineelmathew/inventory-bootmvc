package com.dxctraining.inventorymgt.item.services;

import com.dxctraining.inventorymgt.item.dao.IItemDao;
import com.dxctraining.inventorymgt.item.entities.Item;
import com.dxctraining.inventorymgt.supplier.Dao.ISupplierDao;
import com.dxctraining.inventorymgt.supplier.entities.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Service
public class ItemServiceImpleme implements IItemService{

    @Autowired
    private IItemDao itemDao;

    @Override
    public Item addItem(Item item) {
        itemDao.addItem(item);
        return item;
    }

    @Override
    public void removeItem(int id) {
        itemDao.removeItem(id);
    }
    @Override
    public Item findById(int id) {
        Item item=itemDao.findById(id);
        return item;
    }
    @Override
    public List<Item> itemList() {
        List<Item>result=itemDao.itemList();
        return result;
    }
}
