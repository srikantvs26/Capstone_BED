package com.wipro.diet.app.repos;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wipro.diet.app.beans.NewUser;

@Repository
public interface NewUserRepository  extends CrudRepository<NewUser,String>  {

	@Query("from NewUser n where n.status=?1")
	ArrayList<NewUser> findByStatus(String status);
	@Query("from NewUser n where n.email=?1")
	NewUser findByEmail(String email);
	
	@Transactional
	@Modifying
	@Query("update NewUser n set n.status=?1  where n.email =?2")
	void setStatusForNewUser(String s,String email);
	
	@Transactional
	@Modifying
	@Query("delete from NewUser n where n.email=?1")
	void deleteUser(String email);
	
	@Query("from NewUser")
	ArrayList<NewUser> findByEmail();
	

	

}
