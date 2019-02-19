package com.lemsst.bangsamoro.core.data;

import java.util.List;
import java.util.Map;

public class TestScenarioData {

    private String id;
    private String description;
    private Map<String, String> data;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map<String, String> getData() {
        return data;
    }

    public void setData(Map<String, String> data) {
        this.data = data;
    }
}
