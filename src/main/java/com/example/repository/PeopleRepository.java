package com.example.repository;

import com.example.domain.PeopleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeopleRepository extends JpaRepository<PeopleEntity, Long> {

    @Query("SELECT p FROM PeopleEntity p WHERE p.personID = :personID")
    PeopleEntity findByPersonID(@Param("personID") Long personID);

    @Query("SELECT p FROM PeopleEntity p WHERE p.fullName = :fullName")
    List<PeopleEntity> findByFullName(@Param("fullName") String fullName);

    @Query("SELECT p FROM PeopleEntity p WHERE p.preferredName = :preferredName")
    List<PeopleEntity> findByPreferredName(@Param("preferredName") String preferredName);

    @Query("SELECT p FROM PeopleEntity p WHERE p.searchName = :searchName")
    List<PeopleEntity> findBySearchName(@Param("searchName") String searchName);

    @Query("SELECT p FROM PeopleEntity p WHERE p.isPermittedToLogon = :isPermittedToLogon")
    List<PeopleEntity> findByIsPermittedToLogon(@Param("isPermittedToLogon") Boolean isPermittedToLogon);

    @Query("SELECT p FROM PeopleEntity p WHERE p.logonName = :logonName")
    List<PeopleEntity> findByLogonName(@Param("logonName") String logonName);

    @Query("SELECT p FROM PeopleEntity p WHERE p.isExternalLogonProvider = :isExternalLogonProvider")
    List<PeopleEntity> findByIsExternalLogonProvider(@Param("isExternalLogonProvider") Boolean isExternalLogonProvider);

    @Query("SELECT p FROM PeopleEntity p WHERE p.isSystemUser = :isSystemUser")
    List<PeopleEntity> findByIsSystemUser(@Param("isSystemUser") Boolean isSystemUser);

    @Query("SELECT p FROM PeopleEntity p WHERE p.isEmployee = :isEmployee")
    List<PeopleEntity> findByIsEmployee(@Param("isEmployee") Boolean isEmployee);

    @Query("SELECT p FROM PeopleEntity p WHERE p.isSalesperson = :isSalesperson")
    List<PeopleEntity> findByIsSalesperson(@Param("isSalesperson") Boolean isSalesperson);

}