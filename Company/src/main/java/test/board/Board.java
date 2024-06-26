package test.board;

import java.sql.Timestamp;

public class Board {
    private long b_id;
    private int post_num;
    private String title;
    private String content;
    private int s_id;
    private String s_department; // 필드 이름 확인
    private Timestamp createTime;
    private Timestamp updateTime;
    private long views;
    private int commentCnt;

    // Getters and Setters
    public long getBId() { return b_id; }
    public void setBId(long b_id) { this.b_id = b_id; }
    public int getPostNum() { return post_num; }
    public void setPostNum(int post_num) { this.post_num = post_num; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public int getSId() { return s_id; }
    public void setSId(int s_id) { this.s_id = s_id; }
    public String getSDepartment() { return s_department; }
    public void setSDepartment(String s_department) { this.s_department = s_department; }
    public Timestamp getCreateTime() { return createTime; }
    public void setCreateTime(Timestamp createTime) { this.createTime = createTime; }
    public Timestamp getUpdateTime() { return updateTime; }
    public void setUpdateTime(Timestamp updateTime) { this.updateTime = updateTime; }
    public long getViews() { return views; }
    public void setViews(long views) { this.views = views; }
    public int getCommentCnt() { return commentCnt; }
    public void setCommentCnt(int commentCnt) { this.commentCnt = commentCnt; }
}


