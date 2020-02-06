package com.spring.studentportal.repository;

import com.spring.studentportal.model.SignUpModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<SignUpModel,Long> {


}
