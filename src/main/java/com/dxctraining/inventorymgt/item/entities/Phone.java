package com.dxctraining.inventorymgt.item.entities;

import com.dxctraining.inventorymgt.supplier.entities.Supplier;

public class Phone extends Item {
    private int storageSize;
    public Phone(String name, Supplier supplier, int storageSize) {
        super(name, supplier);
        this.storageSize=storageSize;
    }
    public Phone()
    {

    }
    public int getStorageSize() {
        return storageSize;
    }

    public void setStorageSize(int storageSize) {
        this.storageSize = storageSize;
    }
}
