package com.fdse.config_manager.bean.Metrics.Response;

import com.fdse.config_manager.bean.Metrics.PodMetrics.PodMetrics;

import java.util.List;

public class PodsMetricsResponse {
    private boolean status;
    private String message;
    private List<PodMetrics> podsMetrics;

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

    public List<PodMetrics> getPodsMetrics() {
        return podsMetrics;
    }

    public void setPodsMetrics(List<PodMetrics> podsMetrics) {
        this.podsMetrics = podsMetrics;
    }
}
