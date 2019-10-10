package com.fdse.config_manager.response;

public class AsyncRequestSequenceResponse {

    private boolean status;

    private String message;

    public AsyncRequestSequenceResponse() {
        //do nothing
    }

    public AsyncRequestSequenceResponse(boolean status, String message) {
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
