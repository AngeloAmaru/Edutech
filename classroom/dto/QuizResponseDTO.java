package com.edutech.classroom.dto;

import java.time.Instant;

public class QuizResponseDTO {

    private Integer id;
    private Integer quizId;
    private Integer studentId;
    private String selectedOption;
    private String responseContent;
    private String assignmentUrl;
    private Instant submittedAt;

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

    public String getSelectedOption() {
        return selectedOption;}
    public void setSelectedOption(String selectedOption) {
        this.selectedOption = selectedOption;}

    public String getResponseContent() {
        return responseContent;}
    public void setResponseContent(String responseContent) {
        this.responseContent = responseContent;}

    public String getAssignmentUrl() {
        return assignmentUrl;}
    public void setAssignmentUrl(String assignmentUrl) {
        this.assignmentUrl = assignmentUrl;}

    public Instant getSubmittedAt() {
        return submittedAt;}
    public void setSubmittedAt(Instant submittedAt) {
        this.submittedAt = submittedAt;}
}
