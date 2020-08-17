package com.dxctraining.inventorymgt.Ui;

import com.dxctraining.inventorymgt.item.entities.Computer;
import com.dxctraining.inventorymgt.item.entities.Item;
import com.dxctraining.inventorymgt.item.entities.Phone;
import com.dxctraining.inventorymgt.item.services.IItemService;
import com.dxctraining.inventorymgt.supplier.entities.Supplier;
import com.dxctraining.inventorymgt.supplier.exceptions.InvalidArgumentException;
import com.dxctraining.inventorymgt.supplier.services.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class MainUi {
    @Autowired
    private ISupplierService supplierService;
@Autowired
private IItemService iItemService;
    @PostConstruct
    public void runApp() {
        try {
            //SUPPLIERS
            Supplier supplier1 = new Supplier("a1suppliers");
            Supplier supplier2 = new Supplier("a2 suppliers");
            supplierService.addSupplier(supplier1);
            supplierService.addSupplier(supplier2);
           //ITEMS VALUES
            Phone item1=new Phone("nokia",supplier1,20);
            Phone item2=new Phone("samsung",supplier2,40);
            Computer item3=new Computer("dell",supplier1,1000);
            Computer item4=new Computer("dell",supplier1,1000);
            iItemService.addItem(item1);
            iItemService.addItem(item2);
            iItemService.addItem(item3);
            iItemService.addItem(item4);
        } catch (InvalidArgumentException e) {
            e.printStackTrace();
        }


    }
}
