package com.spring.studentportal.services;

import com.spring.studentportal.dto.request.CourseRequest;
import com.spring.studentportal.dto.request.SignInRequest;
import com.spring.studentportal.dto.request.SignUpRequest;
import com.spring.studentportal.dto.response.StudentInfoResponse;
import com.spring.studentportal.dto.response.StudentInfoResponseWithCourse;
import com.spring.studentportal.model.CourseModel;
import com.spring.studentportal.model.SignUpModel;
import com.spring.studentportal.repository.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SingInAndSignUpService {
    private final StudentRepository studentRepository;

    public SingInAndSignUpService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public String signUp(SignUpRequest signUpRequest) {
/*
        List<CourseModel> courseRequests = new ArrayList<>();
        for (CourseRequest courseRequest1 : signUpRequest.getCourseRequests()) {
            CourseModel courseModel = new CourseModel();
            courseModel.setSubject(courseRequest1.getSubject());
            courseRequests.add(courseModel);

        }

        SignUpModel signUpModel = new SignUpModel();

        signUpModel.setStudentId(signUpRequest.getStudentId());
        signUpModel.setName(signUpRequest.getStudentName());
        signUpModel.setDept(signUpRequest.getStudentDept());
        signUpModel.setPassword(signUpRequest.getStudentPass());
        signUpModel.setCourseModels(courseRequests);

        studentRepository.save(signUpModel);*/
        return "1234";
    }


    public StudentInfoResponseWithCourse getCourseBy(Long id) {
        Optional<SignUpModel> signUpModelOptional = studentRepository.findById(id);
        if (!signUpModelOptional.isPresent()) {

        }

        List<CourseRequest> courseRequestList = new ArrayList<>();
        for (CourseModel courseModel : signUpModelOptional.get().getCourseModels()) {
            courseRequestList.add(new CourseRequest(courseModel.getSubject()));
        }


        return StudentInfoResponseWithCourse.builder()
                .name(signUpModelOptional.get().getName())
                .dept(signUpModelOptional.get().getDept())
                .studentId(signUpModelOptional.get().getStudentId())
                .courseRequestList(courseRequestList)
                .build();
    }


    public StudentInfoResponse getStudentBy(Long id) {

        Optional<SignUpModel> signUpModelOptional = studentRepository.findById(id);

        /*StudentInfoResponse studentInfoResponses = new StudentInfoResponse();

        SignUpModel signUpModel = signUpModelOptional.get();
        studentInfoResponses.setName(signUpModel.getName());
        studentInfoResponses.setDept(signUpModel.getDept());
        studentInfoResponses.setStudentId(signUpModel.getStudentId());*/


        return StudentInfoResponse.builder()
                .name(signUpModelOptional.get().getName())
                .dept(signUpModelOptional.get().getDept())
                .studentId(signUpModelOptional.get().getStudentId())
                .courseModels(signUpModelOptional.get().getCourseModels())
                .build();
    }

    public ResponseEntity<Long> singIn(SignInRequest signInRequest) {

        List<SignUpModel> getStudentDetails = studentRepository.findAll();
        for (SignUpModel signUpModel : getStudentDetails) {
            if (signUpModel.getStudentId().equals(signInRequest.getVarsityId())
                    && signUpModel.getPassword().equals(signInRequest.getPassword())) {
                return new ResponseEntity(signUpModel.getId(), HttpStatus.OK);
            }

        }

        return new ResponseEntity(0l, HttpStatus.FORBIDDEN);
    }


    public void update(Long id, SignUpRequest signUpRequest) {

        Optional<SignUpModel> signUpModelOptional = studentRepository.findById(id);
        if (!signUpModelOptional.isPresent()) {
            throw new ResourceAccessException("Value Not found");
        }


        SignUpModel signUpModel = signUpModelOptional.get();
        signUpModel.setName(signUpRequest.getStudentName());
        signUpModel.setDept(signUpRequest.getStudentDept());
        signUpModel.setStudentId(signUpRequest.getStudentId());
        signUpModel.setPassword(signUpRequest.getStudentPass());
        signUpModel.setCourseModels(signUpRequest.getCourseRequests());
        studentRepository.save(signUpModel);
    }

    public void delete(Long id) {
        studentRepository.deleteById(id);
    }


}
