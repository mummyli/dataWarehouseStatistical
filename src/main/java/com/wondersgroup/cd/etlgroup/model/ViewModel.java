package com.wondersgroup.cd.etlgroup.model;

/**
 * Created by lsj on 2017-7-18.
 */
public class ViewModel {
    private String viewName;
    private String[] primKeys;
    private String filePath;

    public String getViewName() {
        return viewName;
    }

    public void setViewName(String viewName) {
        this.viewName = viewName;
    }

    public String[] getPrimKeys() {
        return primKeys;
    }

    public void setPrimKeys(String[] primKeys) {
        this.primKeys = primKeys;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
