package com.spring.studentportal.dto.request;

public class CourseRequest {

    private String subject;

    public CourseRequest(String subject) {
        this.subject = subject;
    }

    public CourseRequest() {
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
