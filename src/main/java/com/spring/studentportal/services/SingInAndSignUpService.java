package com.spring.studentportal.services;

import com.spring.studentportal.dto.request.SignUpRequest;
import com.spring.studentportal.model.SignUpModel;
import com.spring.studentportal.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class SingInAndSignUpService {
    private final StudentRepository studentRepository;

    public SingInAndSignUpService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public String signUp(SignUpRequest signUpRequest){

        SignUpModel signUpModel = new SignUpModel();
        signUpModel.setStudentId(signUpRequest.getStudentId());
        signUpModel.setName(signUpRequest.getStudentName());
        signUpModel.setDept(signUpRequest.getStudentDept());
        signUpModel.setPassword(signUpRequest.getStudentPass());

        studentRepository.save(signUpModel);

        return signUpRequest.getStudentId();
    }


}
