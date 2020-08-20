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

import java.util.List;

@Controller
public class SupplierController {
    @Autowired
    private ISupplierService supplierService;
    @Autowired
    private SessionMaintain sessionData;
    @Autowired
    private IItemService iItemService;

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
      List<Supplier>supplierList=supplierService.supplierList();
      System.out.println("inside suppliers list");
      ModelAndView modelAndView=new ModelAndView("list","suppliers",supplierList);
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
        List<Supplier>supplierList=supplierService.supplierList();
        ModelAndView modelAndView=new ModelAndView("list","suppliers",supplierList);
        return  modelAndView;
    }


    @GetMapping("/profile")
    public ModelAndView employeeDetails(@RequestParam("id")int id){
        if(!sessionData.isLoggedIn()){
            return new ModelAndView("login");
        }
        Supplier supplier=supplierService.findById(id);
        List<Supplier>supplierList=supplierService.supplierList();
        ModelAndView modelAndView=new ModelAndView("list","items",supplier);
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


    @PostMapping("/postsupplierregister")
    public ModelAndView postSupplierRegister(@RequestParam("name") String name,@RequestParam("password")
                                             String password)
    {
        Supplier supplier=new Supplier(name,password);
        supplierService.addSupplier(supplier);
        List<Supplier>supplierList=supplierService.supplierList();
        ModelAndView modelAndView=new ModelAndView("list","items",supplier);
        return modelAndView;
    }

    @GetMapping("/register")
    public ModelAndView registerPage(){
        System.out.println("inside register post method");
        ModelAndView mv=new ModelAndView("supplierregister");
        return mv;
    }







}
