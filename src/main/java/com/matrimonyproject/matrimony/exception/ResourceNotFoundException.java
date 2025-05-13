package com.matrimonyproject.matrimony.exception;


import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Setter
@Getter
@NoArgsConstructor
public class ResourceNotFoundException extends RuntimeException {
    private String resourceName;
    private String field;
    private String fieldName;


    public ResourceNotFoundException( String resourceName, String field, String fieldName) {
        super(String.format("%s not found  with %s : %s", resourceName, field, fieldName));
        this.resourceName = resourceName;
        this.field = field;
        this.fieldName = fieldName;
    }
    public ResourceNotFoundException(Long field) {
        super(String.format("Enrollment failed: User with ID %d not found. Please register before enrolling.", field));
        this.field=field.toString();
    }





}
