package com.iscl.app.feature.userProfile;

import org.springframework.data.jpa.repository.Modifying;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.iscl.app.feature.userProfile.AllTeacherProfile;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AllAdminCodeRepository extends JpaRepository<AllAdminCode, Long>
{
 
	@Query("select a from AllAdminCode a where a.code=?1 ")
	AllAdminCode findAdminCodeByAdmin(String code);
	

}