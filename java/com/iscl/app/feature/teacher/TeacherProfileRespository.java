package com.iscl.app.feature.teacher;

import org.springframework.data.jpa.repository.Modifying;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.iscl.app.feature.userProfile.AllTeacherProfile;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface TeacherProfileRespository extends JpaRepository<AllTeacherProfile, Long>
{
 
	@Query("select a from AllTeacherProfile a where a.allUser1.allUsersId=?1 ")
	AllTeacherProfile findUserCountById(int userId);
	
	@Modifying
	@Query("update AllTeacherProfile a set a.teacherName=?1,a.allUser2.allUsersId=?2 where a.allUser1.allUsersId=?3 ")
	void updateTeacherProfile(String name, int schoolId, int userId);
	
}