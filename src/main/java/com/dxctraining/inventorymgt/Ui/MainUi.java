package com.dxctraining.inventorymgt.Ui;

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

    @PostConstruct
    public void runApp() {
        try {
            Supplier supplier1 = new Supplier("a1 suppliers", 1);
            Supplier supplier2 = new Supplier("a2 suppliers", 2);
            supplierService.addSupplier(supplier1);
            supplierService.addSupplier(supplier2);

             int id1=supplier1.getId();
            Supplier su1=supplierService.findById(id1);
            System.out.println(su1.getId()+"  "+su1.getName());
            //showSuppliers();
        } catch (InvalidArgumentException e) {
            e.printStackTrace();
        }


    }

    //private void showSuppliers() {
    //}
}
