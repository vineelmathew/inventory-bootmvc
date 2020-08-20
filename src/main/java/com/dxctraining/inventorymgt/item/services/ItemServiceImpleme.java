package com.dxctraining.inventorymgt.item.services;

import com.dxctraining.inventorymgt.item.dao.IItemDao;
import com.dxctraining.inventorymgt.item.entities.Item;
import org.springframework.beans.factory.annotation.Autowired;
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

    /*@Override
    public List<Item> phoneList() {
        List<Item>phones=itemDao.itemList();
        List<Item>phoneslist=null;
        for(Item item:phones)
        {
            Boolean isPhone=phones instanceof Phone;
            if(isPhone)
            {
                   phoneslist.add((Item) phones);
            }
        }
        return phoneslist;
    }*/


    /*@Override
    public List<Item> computerList() {
        List<Item>itemList=itemDao.itemList();
        List<Item>computerlist=null;
        for(Item item:itemList)
        {
            Boolean isCom=item instanceof Computer;
            if(isCom)
            {
                computerlist.add((Item) itemList);
            }
        }
        return computerlist;
    }*/
}
