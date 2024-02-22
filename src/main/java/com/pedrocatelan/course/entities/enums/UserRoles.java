package com.pedrocatelan.course.entities.enums;

public enum UserRoles {
    ADMIN("admin"),
    USER("user");
    
    private String role;
    UserRoles(String role) {
        this.role = role;
    }
    String getRole() {
        return role;
    }
}
