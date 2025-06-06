package com.edutech.classroom.dto;

import java.time.Instant;

public class SupportTicketDTO {

    private Integer id;
    private Integer userId;
    private Integer supportUserId;
    private String subject;
    private String description;
    private String status;
    private Instant createdAt;
    private Instant closedAt;

    // Getters and Setters

    public Integer getId() {
        return id;}
    public void setId(Integer id) {
        this.id = id; }

    public Integer getUserId() {
        return userId;}
    public void setUserId(Integer userId) {
        this.userId = userId;}

    public Integer getSupportUserId() {
        return supportUserId;}
    public void setSupportUserId(Integer supportUserId) {
        this.supportUserId = supportUserId;}

    public String getSubject() {
        return subject;}
    public void setSubject(String subject) {
        this.subject = subject;}

    public String getDescription() {
        return description;}
    public void setDescription(String description) {
        this.description = description;}

    public String getStatus() {
        return status;}
    public void setStatus(String status) {
        this.status = status;}

    public Instant getCreatedAt() {
        return createdAt;}
    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;}

    public Instant getClosedAt() {
        return closedAt;}
    public void setClosedAt(Instant closedAt) {
        this.closedAt = closedAt;}
}
