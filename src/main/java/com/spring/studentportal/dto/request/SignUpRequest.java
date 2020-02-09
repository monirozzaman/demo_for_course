package com.spring.studentportal.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SignUpRequest {

    private String studentName;
    private String studentDept;
    private String studentId;
    private String studentPass;
    private List<CourseRequest> courseRequests;

}
