package com.fdse.config_manager.response;

public class DeltaNodeByListResponse {
    private boolean status;
    private String message;

    public DeltaNodeByListResponse(){

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
