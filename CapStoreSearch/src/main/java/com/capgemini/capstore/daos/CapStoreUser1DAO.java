package com.capgemini.capstore.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capgemini.capstore.beans.Product;



@Repository
public interface CapStoreUser1DAO extends JpaRepository<Product,Integer> {
	@Query("select p from Product p")
	List<Product> findAllProduct();
	@Query("select p from Product p where UPPER(p.productName) LIKE UPPER(?1)")
	List<Product> findByProductName(String productName);
	@Query("select p from Product p where UPPER(p.company) LIKE UPPER(?1)")
	List<Product> findByCompany(String company);
	@Query("select p from Product p where  UPPER(p.category) LIKE UPPER(?1)")
	List<Product> findByCategory(String category);
	@Query("select p from Product p where UPPER(p.subcategory) LIKE UPPER(?1)")
	List<Product> findBySubCategory(String subcategory);
	
	
	// only admin can search through productId,user can't
	@Query("select p from Product p where p.productID=?1")
	List<Product> findByProductId(Integer productId);

	
	
	

}



