package com.matrimonyproject.matrimony.customEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EducationArea {
    SSC("10th"),
    HSC("12th"),
    Graduate("Bachelor's degree"),
    Post_Graduate("Post Graduate"),
    Doctor("Doctor");
    private final String value;
    public String getValue() {
        return value;
    }
}
