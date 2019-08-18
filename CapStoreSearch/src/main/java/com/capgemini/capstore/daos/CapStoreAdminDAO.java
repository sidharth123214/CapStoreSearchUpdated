package com.capgemini.capstore.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capgemini.capstore.beans.Merchant;




	@Repository
	public interface CapStoreAdminDAO extends JpaRepository<Merchant,Integer> {
		
		
		
		
		@Query("select m from Merchant m")
		List<Merchant>findAllMerchant();
		@Query("select m from Merchant m where m.merchantId=?1")
		List<Merchant> findByMerchantId(Integer MerchantId);
		
		

		
		
		

	}

	



