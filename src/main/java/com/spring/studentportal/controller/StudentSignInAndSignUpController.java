package com.spring.studentportal.controller;

import com.spring.studentportal.dto.request.SignInRequest;
import com.spring.studentportal.dto.request.SignUpRequest;
import com.spring.studentportal.services.SingInAndSignUpService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student/")
public class StudentSignInAndSignUpController {
   private final SingInAndSignUpService singInAndSignUpService;

    public StudentSignInAndSignUpController(SingInAndSignUpService singInAndSignUpService) {
        this.singInAndSignUpService = singInAndSignUpService;
    }

    @PostMapping("signup")
    public ResponseEntity<String> signUp(@RequestBody SignUpRequest signUpRequest) {
       return new ResponseEntity(singInAndSignUpService.signUp(signUpRequest),
               HttpStatus.CREATED);
    }

    @PutMapping("user/{id}")
    public void updateUser(@PathVariable Long id, @RequestBody SignUpRequest signUpRequest) {
        singInAndSignUpService.update(id,signUpRequest);

    }

    @GetMapping("signIn")
    public ResponseEntity<Long> signIn(@RequestBody SignInRequest signInRequest) {
       return singInAndSignUpService.singIn(signInRequest);
    }
    @DeleteMapping("user/{id}")
    public void deleteUser(@PathVariable Long id) {
        singInAndSignUpService.delete(id);

    }
}
