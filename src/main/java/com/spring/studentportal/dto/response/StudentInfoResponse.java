package com.spring.studentportal.dto.response;

import lombok.*;

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


}
