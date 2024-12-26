package com.sathya.springbootmvc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sathya.springbootmvc.entity.ProductEntity;
import com.sathya.springbootmvc.model.Productmodel;
import com.sathya.springbootmvc.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	public void saveProductDetails(Productmodel productmodel)
	{
		double discountprice;
		discountprice=productmodel.getPrice()*productmodel.getDiscountRate()/100;
		double offerprice;
		offerprice=productmodel.getPrice()-discountprice;
		double taxprice;
		taxprice=0.18*offerprice;
		double finalprice;
		finalprice=offerprice+taxprice;
		double stockvalue;
		stockvalue=finalprice*productmodel.getQuantity();
		ProductEntity entity=new ProductEntity();
		entity.setBrand(productmodel.getBrand());
		entity.setMadein(productmodel.getMadein());
		entity.setName(productmodel.getName());
		entity.setPrice(productmodel.getPrice());
		entity.setDiscountRate(productmodel.getDiscountRate());
		entity.setDiscountprice(discountprice);
		entity.setQuantity(productmodel.getQuantity());
		entity.setOfferprice(offerprice);
		entity.setTaxprice(taxprice);
		entity.setFinalprice(finalprice);
		entity.setStockvalue(stockvalue);
		productRepository.save( entity);
		
	}
	 public List<ProductEntity> getAllProducts()
	 {
		List<ProductEntity> products = productRepository.findAll();
		return products;
	 }
	public ProductEntity searchProductsById(Long id) {
		Optional<ProductEntity> optionalData = productRepository.findById(id);
		if(optionalData.isPresent())
		{
			ProductEntity product = optionalData.get();
			return product;
		}
		else
		{
			return null;
		}
 }
	public void deleteProductById(Long id) {
		
		productRepository.deleteById(id);
	}
	
	
	public Productmodel updateProductById(Long id) {
		Optional<ProductEntity> optionalData = productRepository.findById(id);
		if(optionalData.isPresent())
		{
			ProductEntity productEntity = optionalData.get();
			Productmodel productmodel=new Productmodel();
			productmodel.setName(productEntity.getName());
			productmodel.setBrand(productEntity.getBrand());
			productmodel.setMadein(productEntity.getMadein());
			productmodel.setQuantity(productEntity.getQuantity());
			productmodel.setPrice(productEntity.getPrice());
			productmodel.setDiscountRate(productEntity.getDiscountRate());
			return productmodel;
			
		}
		else
		{
			return null;
		}
		
	}
	public void update(Long id, Productmodel productmodel) {
		Optional <ProductEntity> optionalData =	productRepository.findById(id);
		if(optionalData.isPresent())
		{
			ProductEntity productEntity = optionalData.get();
			double discountprice;
			discountprice=productmodel.getPrice()*productmodel.getDiscountRate()/100;
			double offerprice;
			offerprice=productmodel.getPrice()-discountprice;
			double taxprice;
			taxprice=0.18*offerprice;
			double finalprice;
			finalprice=offerprice+taxprice;
			double stockvalue;
			stockvalue=finalprice*productmodel.getQuantity();
			productEntity.setName(productmodel.getName());
			productEntity.setBrand(productmodel.getBrand());
			productEntity.setMadein(productmodel.getMadein());
			productEntity.setName(productmodel.getName());
			productEntity.setPrice(productmodel.getPrice());
			productEntity.setDiscountRate(productmodel.getDiscountRate());
			productEntity.setDiscountprice(discountprice);
			productEntity.setQuantity(productmodel.getQuantity());
			productEntity.setOfferprice(offerprice);
			productEntity.setTaxprice(taxprice);
			productEntity.setFinalprice(finalprice);
			productEntity.setStockvalue(stockvalue);
			productRepository.save(productEntity);
		}
	}
	
}
