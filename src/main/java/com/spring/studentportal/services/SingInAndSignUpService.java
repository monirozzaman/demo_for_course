package com.spring.studentportal.services;

import com.spring.studentportal.dto.request.SignInRequest;
import com.spring.studentportal.dto.request.SignUpRequest;
import com.spring.studentportal.model.SignUpModel;
import com.spring.studentportal.repository.StudentRepository;
import jdk.management.resource.ResourceRequestDeniedException;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;
import java.util.Optional;

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

    public ResponseEntity<Long> singIn(SignInRequest signInRequest){

       List<SignUpModel> getStudentDetails = studentRepository.findAll();
       for(SignUpModel signUpModel: getStudentDetails)
       {
           if(signUpModel.getStudentId().equals(signInRequest.getVarsityId())
                   && signUpModel.getPassword().equals(signInRequest.getPassword())) {
               return new ResponseEntity(signUpModel.getId(), HttpStatus.OK);
           }

       }

        return new ResponseEntity(0l, HttpStatus.FORBIDDEN);
    }


    public void update(Long id, SignUpRequest signUpRequest) {

       Optional<SignUpModel> signUpModelOptional= studentRepository.findById(id);
       if(!signUpModelOptional.isPresent())
       {
           throw new ResourceAccessException("Value Not found");
       }

       SignUpModel signUpModel=signUpModelOptional.get();
       signUpModel.setName(signUpRequest.getStudentName());
       signUpModel.setDept(signUpRequest.getStudentDept());
       signUpModel.setStudentId(signUpRequest.getStudentId());
       signUpModel.setPassword(signUpRequest.getStudentPass());

       studentRepository.save(signUpModel);
    }

    public void delete(Long id) {
        studentRepository.deleteById(id);
    }
}
