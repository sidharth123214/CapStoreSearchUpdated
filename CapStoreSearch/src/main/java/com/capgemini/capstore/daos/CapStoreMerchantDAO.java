package com.capgemini.capstore.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capgemini.capstore.beans.Merchant;
import com.capgemini.capstore.beans.Product;
@Repository
public interface CapStoreMerchantDAO extends JpaRepository<Product,Integer> {
	
	
	@Query("select p from Product p where p.merchant=?1")
	List<Product> findAllProductWithMerchantId(Merchant merchantObject);
	
	@Query("select p from Product p where p.merchant=?2 AND p.productID=?1")
	List<Product> findByProductIdWithMerchantId(int productId,Merchant merchantObject);
	
	@Query("select p from Product p where p.merchant=?2 AND UPPER(p.productName) LIKE UPPER(?1)")
	List<Product> findByProductNameWithMerchantId(String productName,Merchant merchantObject);
	
	@Query("select p from Product p where p.merchant=?2 AND UPPER(p.company) LIKE UPPER(?1)")
	List<Product> findByCompanyWithMerchantId(String Company,Merchant merchantObject);
	
	@Query("select p from Product p where p.merchant=?2 AND UPPER(p.category) LIKE UPPER(?1)")
	List<Product> findByCategoryWithMerchantId(String Category,Merchant merchantObject);

    @Query("select p from Product p where p.merchant=?2 AND UPPER(p.subcategory) LIKE UPPER(?1)")
    List<Product> findBySubCategoryWithMerchantId(String subcategory,Merchant merchantObject);
    
}
