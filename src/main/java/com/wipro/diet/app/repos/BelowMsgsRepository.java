package com.wipro.diet.app.repos;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wipro.diet.app.beans.BelowMsgs;

@Repository
public interface BelowMsgsRepository extends CrudRepository<BelowMsgs,String>{
	@Query("from BelowMsgs ORDER BY slno ASC")
	ArrayList<BelowMsgs> findById();
	
	@Transactional
	@Modifying
	@Query("delete from BelowMsgs a where a.slno=?1")
	void deleteById(int id);
}
