package com.dxctraining.inventorymgt.controllers;

import com.dxctraining.inventorymgt.dto.CreateSupplier;
import com.dxctraining.inventorymgt.dto.SessionMaintain;
import com.dxctraining.inventorymgt.item.entities.Item;
import com.dxctraining.inventorymgt.item.services.IItemService;
import com.dxctraining.inventorymgt.supplier.entities.Supplier;
import com.dxctraining.inventorymgt.supplier.services.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
public class SupplierController {
    @Autowired
    private ISupplierService supplierService;
    @Autowired
    private SessionMaintain sessionData;
    @Autowired
    private IItemService iItemService;
    @PostConstruct
    public void run() {
        //Suppliers
        Supplier supplier1 = new Supplier("a1suppliers", "123");
        Supplier supplier2 = new Supplier("a2 suppliers", "1234");
        supplierService.addSupplier(supplier1);
        supplierService.addSupplier(supplier2);

    }

  @GetMapping("/addsupplier")
  public ModelAndView addSupplier()
  {
      ModelAndView modelAndView=new ModelAndView("addsupplier");
      return modelAndView;
  }
  @GetMapping("/processsupplier")
    public ModelAndView process(@RequestParam("supname")String name,@RequestParam("password") String password)
  {
      Supplier supplier=new Supplier(name,password);
      supplier=supplierService.addSupplier(supplier);
      System.out.println("inside process suppliers list");
      ModelAndView modelAndView=new ModelAndView("info","suppliers",supplier);
      return  modelAndView;
  }



    @GetMapping("/supplierlogin")
    public ModelAndView processLogin(@RequestParam("id") int id, @RequestParam("password") String password){
        boolean correct=supplierService.authenticate(id,password);
        if(!correct){
            ModelAndView modelAndView= new ModelAndView("login");
            return modelAndView;
        }
        sessionData.saveLogin(id);
        Supplier supplier=supplierService.findById(id);
        ModelAndView modelAndView=new ModelAndView("info","suppliers",supplier);
        return  modelAndView;
    }


    @GetMapping("/profile")
    public ModelAndView employeeDetails(@RequestParam("id")int id){
        if(!sessionData.isLoggedIn()){
            return new ModelAndView("login");
        }
        Supplier supplier=supplierService.findById(id);
        ModelAndView modelAndView=new ModelAndView("info","suppliers",supplier);
        return modelAndView;
    }


    @GetMapping("/login")
    public ModelAndView login(){
        ModelAndView modelAndView=new ModelAndView("login");
        return modelAndView;
    }
    @GetMapping("/logout")
    public ModelAndView logout(){
        sessionData.clear();
        ModelAndView modelAndView=new ModelAndView("login");
        return modelAndView;
    }



    @GetMapping("/allitems")
    public ModelAndView items()
    {
        if(!sessionData.isLoggedIn()){
            return new ModelAndView("login");
        }
        List<Item> itemslist=iItemService.itemList();
        System.out.println("Inside items list");
        ModelAndView modelAndView=new ModelAndView("itemslist","items",itemslist);
        return modelAndView;
    }
    @GetMapping("/postaddsupplier")
    public ModelAndView postRegisterPage(){
        CreateSupplier supplierData=new CreateSupplier();
        ModelAndView modelView=new ModelAndView("addpostsupplier","supplier",supplierData);
        return modelView;
    }
    @PostMapping("/processpostsupplier")
    public ModelAndView addPostSupplier(@ModelAttribute("supplier") CreateSupplier data)
    {
        String name= data.getName();
        String password=data.getPassword();
        Supplier supplier=new Supplier(name,password);
        supplier=supplierService.addSupplier(supplier);
        ModelAndView modelAndView=new ModelAndView("info","suppliers",supplier);
        return modelAndView;
    }
}
