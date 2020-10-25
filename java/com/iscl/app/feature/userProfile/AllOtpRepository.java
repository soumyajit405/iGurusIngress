package com.iscl.app.feature.userProfile;

import org.springframework.data.jpa.repository.Modifying;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AllOtpRepository extends JpaRepository<AllOtp, Long>
{
 
	@Query("select COALESCE(max(allOtpId),0) from AllOtp where allUser.allUsersId=?1 and otp=?2")
	int verifyOtp(int userId, String otp);
	
	@Modifying
	@Query("update AllOtp a set a.otp=?1 where a.allUser.allUsersId=?2")
	void updateOtp(String otp, int userId);
	
}