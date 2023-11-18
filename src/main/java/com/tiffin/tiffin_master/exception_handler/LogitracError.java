package com.tiffin.tiffin_master.exception_handler;

public enum LogitracError {
    LOGIN_ERROR(
            0,
            "Server Error",
            "Server crashed, reason not known"
    );
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
