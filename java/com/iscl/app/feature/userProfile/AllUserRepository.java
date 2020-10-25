package com.iscl.app.feature.userProfile;

import org.springframework.data.jpa.repository.Modifying;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AllUserRepository extends JpaRepository<AllUser, Long>
{
	@Query("select a from AllUser a where a.phone=?1")
	AllUser findUserByPhone(String phoneNumber);
	
	
	@Query("select COALESCE(max(allUsersId),0) from AllUser ")
	int findUserCount();
	
	@Modifying
	@Query("update AllUser a set a.userRolesPl.userRoleId=?1 where a.allUsersId=?2")
	void updateUserRole(int userRoleId, int userId);
	
	@Modifying
	@Query("update AllUser a set a.email=?1 where a.allUsersId=?2")
	void updateUserEmail(String email, int userId);
	
 
}