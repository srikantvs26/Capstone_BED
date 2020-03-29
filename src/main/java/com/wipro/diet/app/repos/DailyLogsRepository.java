package com.wipro.diet.app.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wipro.diet.app.beans.DailyLogs;

@Repository
public interface DailyLogsRepository extends JpaRepository<DailyLogs, Long> {
	@Query("from DailyLogs d where d.zone=?1")
	List<DailyLogs> findByZone(int zone);
	
	@Query("from DailyLogs d where d.email=?1")
	List<DailyLogs> findByEmail(String zone);
	
	@Query("select count(*) from DailyLogs d where d.email=?1 and d.datelog=?2")
	int findByLastUpload(String email,String datelog);
}
