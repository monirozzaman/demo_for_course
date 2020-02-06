package com.spring.studentportal.dto.request;

import java.util.List;

public class SignUpRequest {

    private String studentName;

    private String studentDept;

    private String studentId;

    private String studentPass;
    private List<CourseRequest> courseRequests;

    public List<CourseRequest> getCourseRequests() {
        return courseRequests;
    }

    public void setCourseRequests(List<CourseRequest> courseRequests) {
        this.courseRequests = courseRequests;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentDept() {
        return studentDept;
    }

    public void setStudentDept(String studentDept) {
        this.studentDept = studentDept;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentPass() {
        return studentPass;
    }

    public void setStudentPass(String studentPass) {
        this.studentPass = studentPass;
    }
}
