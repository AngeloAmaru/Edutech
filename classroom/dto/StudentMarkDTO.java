package com.edutech.classroom.dto;

import java.math.BigDecimal;
import java.time.Instant;

public class StudentMarkDTO {

    private Integer id;
    private Integer quizId;
    private Integer studentId;
    private BigDecimal mark;
    private String comments;
    private Instant gradedAt;

    // Getters and Setters

    public Integer getId() {
        return id;}
    public void setId(Integer id) {
        this.id = id;}

    public Integer getQuizId() {
        return quizId;}
    public void setQuizId(Integer quizId) {
        this.quizId = quizId;}

    public Integer getStudentId() {
        return studentId;}
    public void setStudentId(Integer studentId) {
        this.studentId = studentId;}

    public BigDecimal getMark() {
        return mark;}
    public void setMark(BigDecimal mark) {
        this.mark = mark;}

    public String getComments() {
        return comments;}
    public void setComments(String comments) {
        this.comments = comments;}

    public Instant getGradedAt() {
        return gradedAt;}
    public void setGradedAt(Instant gradedAt) {
        this.gradedAt = gradedAt;}
}
