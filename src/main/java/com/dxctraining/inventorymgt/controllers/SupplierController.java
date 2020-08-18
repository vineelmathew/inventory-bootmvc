package com.dxctraining.inventorymgt.controllers;

import com.dxctraining.inventorymgt.supplier.entities.Supplier;
import com.dxctraining.inventorymgt.supplier.services.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
public class SupplierController {

    @Autowired
    private ISupplierService supplierservice;

    @PostConstruct
    public void run()
    {
        Supplier supplier1 = new Supplier("a1suppliers");
        Supplier supplier2 = new Supplier("a2 suppliers");
        supplierservice.addSupplier(supplier1);
        supplierservice.addSupplier(supplier2);
    }
    @GetMapping("/suppliers")
    public ModelAndView all()
    {
        List<Supplier>supplierList=supplierservice.supplierList();
        System.out.println("inside suppliers list");
        ModelAndView modelAndView=new ModelAndView("list","suppliers",supplierList);
        return  modelAndView;
    }



}
