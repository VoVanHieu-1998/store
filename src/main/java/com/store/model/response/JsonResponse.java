package com.store.model.response;

import java.util.List;

public class JsonResponse {
    private String status;
    private List result;
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public List getResult() {
        return result;
    }
    public void setResult(List result) {
        this.result = result;
    }
}
