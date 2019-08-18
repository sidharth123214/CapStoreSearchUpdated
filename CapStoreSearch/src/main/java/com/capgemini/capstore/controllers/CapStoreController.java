package com.capgemini.capstore.controllers;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.capstore.beans.Merchant;
import com.capgemini.capstore.beans.Product;
import com.capgemini.capstore.beans.User1;
import com.capgemini.capstore.services.CapStoreService;


       @CrossOrigin()
       @RestController
       @RequestMapping("/CapStore")
	   public class CapStoreController {
		
		@Autowired
		CapStoreService service;
		
		
		//only admin can search through productId
		@GetMapping(value="/findByProductId/{productId}")
		public List<Product> findByProductId(@PathVariable Integer productId){
			return service.SearchProductId(productId);
		}
		
		//user and admin searching products
		@GetMapping(value="/AllProduct")
		public List<Product> findAllProduct(){
			return service.getAllProduct();
		}
		
		@GetMapping(value = "/findByName/{ProductName}")
	    public List<Product> findByProductName(@PathVariable String ProductName) {
		   return service.SearchProduct(ProductName);
		}
		
		@GetMapping(value = "/findByCompany/{Company}")
		public List<Product>  findByCompany(@PathVariable String Company) {
		   return service.SearchCompany(Company);
		}
		
		@GetMapping(value = "/findByCategory/{Category}")
		public List<Product>  findByCategory(@PathVariable String Category) {
			return service.SearchCategory( Category);
		}
		
		@GetMapping(value = "/findBySubcategory/{subcategory}")
		public List<Product>  findBySubCategory(@PathVariable String subcategory) {
			return service.SearchSubCategory( subcategory);
		}
		
		@PostMapping(value = "/newProduct", consumes = { "application/json" })
		public String save(@RequestBody Product product) {
			service.createProduct(product);
			return "Product added!";
		}

		@PutMapping(value = "/updateProduct", consumes = { "application/json" })
		public String update(@RequestBody Product product) {
			service.updateProduct(product);
			return "Product updated!";
		}
		
		
		
		
		//admin searching merchant deatails
		
		@GetMapping(value="/AllMerchant")
		public List<Merchant> findAllMerchant(){
			return service.getAllMerchant();
		}
		
		
		@GetMapping(value= "/findMerchant/{MerchantId}")
		public List<Merchant> findByMerchantId(@PathVariable int MerchantId){
			return service.SearchMerchantId(MerchantId);
		}
		
		
		@PostMapping(value = "/newMerchant", consumes = { "application/json" })
		public String save(@RequestBody Merchant merchant) {
			service.createMerchant(merchant);
			return "Merchant added!";
		}

		@PutMapping(value = "/updateMerchant", consumes = { "application/json" })
		public String update(@RequestBody Merchant merchant) {
			service.updateMerchant(merchant);
			return "Merchant updated";
		}
		
		
		
		//admin searching user deatails
		
		@GetMapping(value="/AllUser")
		public List<User1> findAllUser(){
			return service.getAllUser();
			}
		
		@GetMapping(value="/findUser/{UserId}")
		public List<User1> findByUserId(@PathVariable int UserId){
			return service.SearchUserId(UserId);
		}
		
		@PostMapping(value = "/newUser", consumes = { "application/json" })
		public String save(@RequestBody User1 user) {
			service.createUser(user);
			return "User added!";
		}

		@PutMapping(value = "/updateUser", consumes = { "application/json" })
		public String update(@RequestBody User1 user) {
			service.updateUser(user);
			return "User updated!";
		}
		
		
		
		
		//merchant searching in his/her inventory
		
		@GetMapping(value="/findWithMerchantId/{merchantId}")
		public List<Product> findAllProductWithMerchantId(@PathVariable Integer merchantId){
			System.out.println(merchantId);
			return service.getAllProductWithMerchantId(merchantId);
		}
		@GetMapping(value="/findWithMerchantId/{merchantId}/{productId}")
		public List<Product> findByProductIdWithMerchantId(@PathVariable Integer merchantId,@PathVariable int productId){
			return service.SearchProductIdWithMerchantId(productId,merchantId);
		}
		
        @GetMapping(value="/findWithMerchantIdAndByName/{merchantId}/{ProductName}")
        public List<Product> findByProductNameWithMerchantId(@PathVariable Integer merchantId,@PathVariable String ProductName){
        return service.SearchProductNameWithMerchantId(ProductName,merchantId);
        }
        
        @GetMapping(value="/findWithMerchantIdAndCompany/{merchantId}/{Company}")
        public List<Product> findByCompanyWithMerchantId(@PathVariable Integer merchantId,@PathVariable String Company){
        	return service.SearchCompanyNameWithMerchantId(Company,merchantId);
        }
        
        
        @GetMapping(value="/findWithMerchantIdAndCategory/{merchantId}/{Category}")
        List<Product> findByCategoryWithMerchantId(@PathVariable Integer merchantId,@PathVariable String Category){
        	return service.SearchCategoryNameWithMerchantId(Category,merchantId);
        }
        
        @GetMapping(value="/findWithMerchantIdAndSubCategory/{merchantId}/{subcategory}")
        List<Product> findBySubCategoryWithMerchantId(@PathVariable Integer merchantId,@PathVariable String subcategory){
        	return service.SearchSubCategoryNameWithMerchantId(subcategory,merchantId);
        }
        
        @PostMapping(value = "/new", consumes = { "application/json" })
		public String save1(@RequestBody Product product) {
			service.createProductWithMerchantId(product);
			return "Product added!";
		}

		@PutMapping(value = "/update", consumes = { "application/json" })
		public String update1(@RequestBody Product product) {
			service.updateProductWithMerchantId(product);
			return "Product updated";
		}
        
        

	

       }

