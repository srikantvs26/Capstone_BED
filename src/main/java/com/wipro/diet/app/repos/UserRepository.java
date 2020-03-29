package com.wipro.diet.app.repos;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wipro.diet.app.beans.User;


@Repository
public interface UserRepository extends CrudRepository<User,String> {
	
	User findByUserId(String ID);
	User findByFname(String fname);
	
	@Query("from User u where u.email!=?1")
	ArrayList<User> findAllUsers(String email);
	
	@Query("from User u where u.type<>?1")
	ArrayList<User> findByEmail(String type);
	@Query("from User u where u.division=?1")
	ArrayList<User> findByDiv(int div);
	
	@Query("select doj from User u where u.email=?1")
	String findDoj(String email);

	@Query("from User ")
	ArrayList<User> findAll();
	
	@Transactional
	@Modifying
	@Query("update User n set n.type=?1  where n.email =?2")
	void settype(String type,String email);

	@Transactional
	@Modifying
	@Query("delete from User n where n.email=?1")
	int deleteUser(String email);
	
	@Query("select fname from User u where u.email=?1")
	String findFname(String email);
	@Query("select division from User u where u.email=?1")
	int findDivision(String email);
	
	
}