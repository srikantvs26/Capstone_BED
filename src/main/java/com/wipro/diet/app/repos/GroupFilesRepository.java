package com.wipro.diet.app.repos;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wipro.diet.app.beans.GroupFiles;


@Repository
public interface GroupFilesRepository extends JpaRepository<GroupFiles, Long> {
	
	@Query("from GroupFiles g where g.zone=?1")
	List<GroupFiles> findByZone(int zone);
}
