package com.wipro.diet.app.repos;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wipro.diet.app.beans.MonthlyMeasurements;

@Repository
public interface MonthlyMeasureRepository extends JpaRepository<MonthlyMeasurements, Long> {
	@Query("select nameFirstF,nameSecondF,nameThirdF from MonthlyMeasurements m where m.email=?1")
	String findFileNames(String email);
	
	
	@Transactional
	@Modifying
	@Query("update MonthlyMeasurements n set n.nameFirstF=?1,n.fileFirst=?2,n.mimetypeF=?3  where n.email =?4")
	void uploadFirstFile(String filename,byte[] file, String mimetype,String email);
	
	@Transactional
	@Modifying
	@Query("update MonthlyMeasurements n set n.nameSecondF=?1,n.fileSecond=?2,n.mimetypeS=?3  where n.email =?4")
	void uploadSecondFile(String filename,byte[] file, String mimetype,String email);
	
	@Transactional
	@Modifying
	@Query("update MonthlyMeasurements n set n.nameThirdF=?1,n.fileThird=?2,n.mimetypeT=?3  where n.email =?4")
	void uploadThirdFile(String filename,byte[] file, String mimetype,String email);
	
	@Query("from MonthlyMeasurements m where m.zone=?1")
	List<MonthlyMeasurements> findByZone(int zone);
	@Query("from MonthlyMeasurements m where m.email=?1")
	Optional<MonthlyMeasurements> findFile(String email);
	
	@Transactional
	@Modifying
	@Query("delete from MonthlyMeasurements n where n.email=?1")
	void deleteUser(String email);

}
