package com.fdse.config_manager.response;

public class SetUnsetServiceRequestSuspendResponse {

    private boolean status;

    private String message;

    public SetUnsetServiceRequestSuspendResponse(){
        //do nothing
    }

    public SetUnsetServiceRequestSuspendResponse(boolean status, String message) {
        this.status = status;
        this.message = message;
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
