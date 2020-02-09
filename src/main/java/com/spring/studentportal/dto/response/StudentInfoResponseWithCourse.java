package com.spring.studentportal.dto.response;

import com.spring.studentportal.dto.request.CourseRequest;
import lombok.*;

import java.util.List;

@Data
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StudentInfoResponseWithCourse {

    private String name;
    private String dept;
    private String studentId;
    private List<CourseRequest> courseRequestList;


}
