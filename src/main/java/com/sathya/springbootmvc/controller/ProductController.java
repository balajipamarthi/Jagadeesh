package com.sathya.springbootmvc.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sathya.springbootmvc.entity.ProductEntity;
import com.sathya.springbootmvc.model.Productmodel;
import com.sathya.springbootmvc.service.ProductService;


@Controller
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	
	@GetMapping("/test")
	public String greet()
	{
		return "myview";
	}
	
	@GetMapping("/productform")
	public String getProductForm() 
	{
		return "app-product";
	}
	
	@PostMapping("/saveproduct")
	public String saveproductData(Productmodel promodel)
	{
		productService.saveProductDetails(promodel);
		return "success";
	}
	@GetMapping("/Productlist")
	public String getAllProducts( Model model)
	{
		List<ProductEntity> product = productService.getAllProducts();
		model.addAttribute("products", product);
		return "product-list";
	}
	
	@GetMapping("/searchform")
	public String serchform()
	{
		return "product-get";
	}
	
   @PostMapping("/searchbyid")
	public String searchProductById( @RequestParam Long id,Model model)
	{
		ProductEntity  product =productService.searchProductsById(id);
		model.addAttribute("product", product);
		return "product-get";
	}
   
   @GetMapping("/delete/{id}")
   public String deleteProductById(@PathVariable  Long id) {
	   productService.deleteProductById(id);
	   return "redirect:/Productlist";
   }
   @GetMapping("/edit/{id}")
   public String updateProductById(@PathVariable  Long id,Model model)
   {
	    Productmodel promodel   =  productService.updateProductById(id);
	    model.addAttribute("promodel", promodel);
	    model.addAttribute("id", id);
	   return "edit";
   }
   
   
   @PostMapping("/editproductsave/{id}")
   public String update(@PathVariable  Long id , Productmodel productmodel)
   {
	   productService.update(id,productmodel);
	   return "redirect:/Productlist";
   }
  
   
}
