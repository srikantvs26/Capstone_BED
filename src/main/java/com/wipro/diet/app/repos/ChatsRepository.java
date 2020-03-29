package com.wipro.diet.app.repos;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wipro.diet.app.beans.Chats;


@Repository
public interface ChatsRepository extends CrudRepository<Chats,Integer>  {
	@Query("from Chats c where c.tmail=?1 order by c.slno desc")
	ArrayList<Chats> findByTmail(String mail);
	
	@Query("from Chats c where c.fmail=?1 and c.tmail=?2 or c.fmail=?2 and c.tmail=?1 Order By c.slno asc")
	ArrayList<Chats> findByTmail(String fmail,String tmail);

	
}
