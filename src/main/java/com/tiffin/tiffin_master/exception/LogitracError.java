package com.tiffin.tiffin_master.exception;

public enum LogitracError {
    SERVER_ERROR(
            0,
            "Server Error",
            "Server crashed, reason not known"
    ),
    ACCESS_DENIED(
            2,
            "Access Denied",
            "User is not allowed to perform this action."
    ),
    INVALID_INFO(
            3,
            "Invalid Info",
            "wrong information"
    ),
    USERNAME_DOES_NOT_EXIST(
            4,
            "user does not exist",
            "user name does not exist"
    ),
    PASSWORD_INCORRECT(
            5,
            "incorrect password",
            "password is incorrect"
    ),
    USERNAME_UNAVAILABLE(
            6,
            "Username Unavailable",
            "Username is already used"
    ),
    USERNAME_INVALID(
            7,
            "Username invalid",
            "username is invalid"
    ),SHOP_LIST_ABSENT(
            8,
                    "Shop detail Unavailable",
                    "Shop detail is not given"
    ),;


    private final int code;
    private final String shortDesc;
    private final String description;

    LogitracError(int code, String shortDesc, String description) {
        this.code = code;
        this.shortDesc = shortDesc;
        this.description = description;
    }

    public String getCode() {
        return String.format("%04d", code);
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public String getDescription() {
        return description;
    }
}
