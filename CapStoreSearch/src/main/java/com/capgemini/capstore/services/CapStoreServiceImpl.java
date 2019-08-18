package com.capgemini.capstore.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.capstore.beans.Merchant;
import com.capgemini.capstore.beans.Product;
import com.capgemini.capstore.beans.User1;
import com.capgemini.capstore.daos.CapStoreAdmin1DAO;
import com.capgemini.capstore.daos.CapStoreAdminDAO;
import com.capgemini.capstore.daos.CapStoreMerchantDAO;
import com.capgemini.capstore.daos.CapStoreUser1DAO;




	@Service
	@Transactional
	public class CapStoreServiceImpl implements CapStoreService {
		@Autowired CapStoreUser1DAO user1Dao;
		@Autowired CapStoreAdminDAO adminDao;
		@Autowired CapStoreAdmin1DAO admin1Dao;
		@Autowired CapStoreMerchantDAO merchantDao;
		
		
		
		@Override
		public List<Product> getAllProduct() {
			// TODO Auto-generated method stub
			return user1Dao.findAllProduct();
		} 
		
		@Override
		public List<Product> SearchProductId(Integer productId) {
			// TODO Auto-generated method stub
			return user1Dao.findByProductId(productId);
		}
		
		
		public List<Product> SearchProduct(String productName) {
			// TODO Auto-generated method stub
			productName="%"+productName+"%";
			return user1Dao.findByProductName(productName);
		}
		
		
		
		public List<Product> SearchCompany(String Company) {
			// TODO Auto-generated method stub
			Company="%"+Company+"%";
			return user1Dao.findByCompany(Company);
		}
		
		public List<Product> SearchCategory(String Category) {
			// TODO Auto-generated method stub
			Category="%"+Category+"%";
			return user1Dao.findByCategory(Category);
		}
		
		@Override
		public List<Product> SearchSubCategory(String subcategory) {
			// TODO Auto-generated method stub
			subcategory="%"+subcategory+"%";
			return user1Dao.findBySubCategory(subcategory);
		}
		
		@Override
		public Product createProduct(Product p) {
			// TODO Auto-generated method stub
		return user1Dao.save(p);
		}
		
		@Override
		public Product updateProduct(Product p) {
			// TODO Auto-generated method stub
			return user1Dao.save(p);
		}
		
		

		
		

		@Override
		public List<Merchant> getAllMerchant() {
			// TODO Auto-generated method stub
			return adminDao.findAllMerchant();
		}
		
		
		public List<Merchant> SearchMerchantId(int MerchantId) {
			// TODO Auto-generated method stub
			return adminDao.findByMerchantId(MerchantId);
		}
		
		
	    @Override
		public Merchant createMerchant(Merchant m) {
			// TODO Auto-generated method stub
			return adminDao.save(m);
		}


		@Override
		public Merchant updateMerchant(Merchant m) {
			// TODO Auto-generated method stub
			return adminDao.save(m);
		}
		
		
		
		
		
        @Override
		public List<User1> getAllUser() {
			// TODO Auto-generated method stub
			return admin1Dao.findAllUser();
		}
		
		
        @Override
		public List<User1> SearchUserId(int UserId) {
			// TODO Auto-generated method stub
			return admin1Dao.findByUserId(UserId);
		}
		
		
        public User1 createUser(User1 u) {
			// TODO Auto-generated method stub
			return admin1Dao.save(u);
		}


	    public User1 updateUser(User1 u) {
			// TODO Auto-generated method stub
			return admin1Dao.save(u);
		}
	    
	    
	    
	    



		public List<Product> getAllProductWithMerchantId(Integer merchantId) {
			List<Product> list = user1Dao.findAllProduct();
			System.out.println(list.size());
			list = list.stream().filter(product->{
				if(product.getMerchant().getMerchantId() == merchantId) {
					return true;
				}else {
					return false;
				}
			}).collect(Collectors.toList());
			return list;
		}
		
		
		@Override
		public List<Product> SearchProductIdWithMerchantId(Integer productId, Integer merchantId) {
			// TODO Auto-generated method stub
			Merchant merchantObject=adminDao.findById(merchantId).get();
			return merchantDao.findByProductIdWithMerchantId(productId,merchantObject);
		}



		@Override
		public List<Product> SearchProductNameWithMerchantId(String ProductName, Integer merchantId) {
			// TODO Auto-generated method stub
			Merchant merchantObject=adminDao.findById(merchantId).get();
			ProductName="%"+ProductName+"%";
			return merchantDao.findByProductNameWithMerchantId(ProductName,merchantObject);
		}



		@Override
		public List<Product> SearchCompanyNameWithMerchantId(String Company, Integer merchantId) {
			// TODO Auto-generated method stub
			Merchant merchantObject=adminDao.findById(merchantId).get();
			Company="%"+Company+"%";
			return merchantDao.findByCompanyWithMerchantId(Company,merchantObject);
		}



		@Override
		public List<Product> SearchCategoryNameWithMerchantId(String Category,Integer merchantId) {
			// TODO Auto-generated method stub
			Merchant merchantObject=adminDao.findById(merchantId).get();
			Category="%"+Category+"%";
			return merchantDao.findByCategoryWithMerchantId(Category,merchantObject);
		}
		
		@Override
		public List<Product> SearchSubCategoryNameWithMerchantId(String subcategory, Integer merchantId) {
			// TODO Auto-generated method stub
			Merchant merchantObject=adminDao.findById(merchantId).get();
			subcategory="%"+subcategory+"%";
			return merchantDao.findBySubCategoryWithMerchantId(subcategory,merchantObject);
		}




		@Override
		public Product createProductWithMerchantId(Product p) {
			// TODO Auto-generated method stub
			return merchantDao.save(p);
		}



		@Override
		public Product updateProductWithMerchantId(Product p) {
			// TODO Auto-generated method stub
			return merchantDao.save(p);
		}

		


	
		





		

		
		
		

	}

