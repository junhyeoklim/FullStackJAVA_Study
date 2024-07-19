package com.springbook.biz.common;

public final class Constants {
    public static final String USER_VIEW = "/User_View";
    public static final String ADMIN_VIEW = "/Admin_View";
    public static final String ALERT_VIEW = "/AlertView";
    
    public static final String BOARD_LIST = "SELECT * FROM BOARD ORDER BY SEQ DESC";
    public static final String BOARD_GET = "SELECT * FROM BOARD WHERE SEQ=?";
    public static final String BOARD_INSERT = "INSERT INTO BOARD (POST_NUM, TITLE, CONTENT, S_NAME, S_ID, S_DEPARTMENT, CREATE_TIME, UPDATE_TIME, VIEWS, COMMENT_CNT, IS_NOTICE) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String BOARD_UPDATE = "UPDATE BOARD SET TITLE=?, CONTENT=?, S_NAME=?, S_ID=?, S_DEPARTMENT=?, UPDATE_TIME=?, VIEWS=?, COMMENT_CNT=?, IS_NOTICE=? WHERE B_ID=?";
    public static final String BOARD_DELETE = "DELETE FROM BOARD WHERE B_ID=?";
    
    private Constants() {
        throw new UnsupportedOperationException("Cannot instantiate a constant class");
    }
}
