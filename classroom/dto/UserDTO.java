package com.edutech.classroom.dto;

import java.time.Instant;

public class UserDTO {

    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private Integer roleId;
    private Boolean isActive;
    private Instant createdAt;
    private Instant updatedAt;

    // Getters and Setters

    public Integer getId() {
        return id;}
    public void setId(Integer id) {
        this.id = id;}

    public String getFirstName() {
        return firstName;}
    public void setFirstName(String firstName) {
        this.firstName = firstName;}

    public String getLastName() {
        return lastName;}
    public void setLastName(String lastName) {
        this.lastName = lastName;}

    public String getEmail() {
        return email;}
    public void setEmail(String email) {
        this.email = email;}

    public Integer getRoleId() {
        return roleId;}
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;}

    public Boolean getIsActive() {
        return isActive;}
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;}

    public Instant getCreatedAt() {
        return createdAt;}
    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;}

    public Instant getUpdatedAt() {
        return updatedAt;}
    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;}
}
