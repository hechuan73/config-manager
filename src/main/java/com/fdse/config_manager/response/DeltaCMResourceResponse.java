package com.fdse.config_manager.response;

public class DeltaCMResourceResponse {
    private boolean status;
    private String message;

    public DeltaCMResourceResponse(){

    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
