package com.login.smarttech.repository;

import com.login.smarttech.entity.UserInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionalEventListener;

import java.util.Date;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserInformation,Integer> {

    Optional<UserInformation> findByUserName(String userName);
    @Modifying
    @Transactional
    @Query("update UserInformation set newAccessType=:newAccessType,editTimestamp=:dt where userName=:userName")
    Integer updateNewAccessType(@Param("userName")String userName,@Param("newAccessType") String newAccessType,@Param("dt") Date dt);
    @Modifying
    @Transactional
    @Query("update UserInformation set accessApplicable=:access where userName=:username")
    Integer updateAccessApplicable(@Param("username") String username,@Param("access")boolean access);
}
