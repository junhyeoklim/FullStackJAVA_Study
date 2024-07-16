package com.springbook.view.controller;

public class ViewResolver {
    private String adminPrefix;
    private String userPrefix;
    private String suffix;

    public void setAdminPrefix(String adminPrefix) {
        this.adminPrefix = adminPrefix;
    }

    public void setUserPrefix(String userPrefix) {
        this.userPrefix = userPrefix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getView(String viewName) {
        if (viewName.startsWith("Admin_View")) {
            return adminPrefix + viewName + suffix;
        } else if (viewName.startsWith("User_View")) {
            return userPrefix + viewName + suffix;
        } else {
            return "/" + viewName + suffix; // 루트 경로에서 접근할 수 있는 파일
        }
    }
}
