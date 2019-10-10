package com.fdse.config_manager.request;

import com.fdse.config_manager.bean.SingleDeltaAllRequest;

import java.util.List;

public class DeltaAllRequest {
    private String clusterName;
    private List<SingleDeltaAllRequest> deltaRequests;

    public DeltaAllRequest(){

    }

    public String getClusterName() {
        return clusterName;
    }

    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }

    public List<SingleDeltaAllRequest> getDeltaRequests() {
        return deltaRequests;
    }

    public void setDeltaRequests(List<SingleDeltaAllRequest> deltaRequests) {
        this.deltaRequests = deltaRequests;
    }
}
