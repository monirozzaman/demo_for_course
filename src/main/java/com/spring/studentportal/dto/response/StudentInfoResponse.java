package com.spring.studentportal.dto.response;

import com.spring.studentportal.model.CourseModel;
import lombok.*;

import java.util.List;

@Data
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StudentInfoResponse {
    private String name;
    private String dept;
    private String studentId;
    private List<CourseModel> courseModels;


}
