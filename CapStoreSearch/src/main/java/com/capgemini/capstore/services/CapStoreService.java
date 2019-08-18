package com.capgemini.capstore.services;

import java.util.List;

import com.capgemini.capstore.beans.Merchant;
import com.capgemini.capstore.beans.Product;
import com.capgemini.capstore.beans.User1;


	public interface CapStoreService {
		public List<Product> getAllProduct();
		public List<Product> SearchProductId(Integer productId);
		public List<Product> SearchProduct(String productName);
		public List<Product> SearchCompany(String company);
		public List<Product> SearchCategory(String category);
		public List<Product> SearchSubCategory(String subcategory);
		public Product createProduct(Product p);
		public Product updateProduct(Product p);
		
		
		
		
		public List<Merchant> getAllMerchant();
		public List<Merchant> SearchMerchantId(int merchantId);
		public Merchant createMerchant(Merchant m);
		public Merchant updateMerchant(Merchant m);
		
		
		
		public List<User1> getAllUser();
		public List<User1> SearchUserId(int userId);
		public User1 createUser(User1 u);
		public User1 updateUser(User1 u);
		
		
		
		
		public List<Product> getAllProductWithMerchantId(Integer merchantId);
		public List<Product> SearchProductIdWithMerchantId(Integer productId,Integer merchantId);
		public List<Product> SearchProductNameWithMerchantId(String productName,Integer merchantId);
		public List<Product> SearchCompanyNameWithMerchantId(String company,Integer merchantId);
		public List<Product> SearchCategoryNameWithMerchantId(String category,Integer merchantId);
		public List<Product> SearchSubCategoryNameWithMerchantId(String subcategory,Integer merchantId);
		public Product createProductWithMerchantId(Product p);
		public Product updateProductWithMerchantId(Product p);
 
	}



