package com.matrimonyproject.matrimony.customEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum AppRole {
    ROLE_USER("Basic user"),
    ROLE_ADMIN("Admin user"),
    ROLE_PREMIUM_USER("Premium User"),
    ROLE_MODERATOR_REVIWER("Moderator reviewer"),
    ROLE_GUEST("Guest"),
    ROLE_SUPPORT("Support"),
    ROLE_DEVELOPER("Developer");

    private final String roleName;
    public String getRoleName() {
        return roleName;
    }

}