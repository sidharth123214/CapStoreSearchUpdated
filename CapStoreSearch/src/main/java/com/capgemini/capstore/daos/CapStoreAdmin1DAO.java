package com.capgemini.capstore.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capgemini.capstore.beans.User1;

public interface CapStoreAdmin1DAO extends JpaRepository<User1,Integer>{
	
	@Query("Select u from User1 u" )
	List<User1> findAllUser();
	
	@Query("select u from User1 u where u.userId=?1")
	List<User1> findByUserId(int UserId);
	

}
