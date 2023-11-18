package com.tiffin.tiffin_master.exception_handler;

public class ResourceNotFoundException extends LogitrackException {

    public ResourceNotFoundException(LogitracError e) {
        super(e);
    }

    public ResourceNotFoundException(LogitracError e, String message) {
        super(e, message);
    }
}
