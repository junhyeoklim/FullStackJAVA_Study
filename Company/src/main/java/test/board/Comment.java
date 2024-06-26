package test.board;

import java.sql.Timestamp;

public class Comment {
    private long commentId;
    private long bId;
    private String userName;
    private String content;
    private Timestamp createTime;
    private Timestamp updateTime;
    private Long parentCommentId; // Parent comment ID

    // Getters and Setters
    public long getCommentId() { return commentId; }
    public void setCommentId(long commentId) { this.commentId = commentId; }
    public long getBId() { return bId; }
    public void setBId(long bId) { this.bId = bId; }
    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public Timestamp getCreateTime() { return createTime; }
    public void setCreateTime(Timestamp createTime) { this.createTime = createTime; }
    public Timestamp getUpdateTime() { return updateTime; }
    public void setUpdateTime(Timestamp updateTime) { this.updateTime = updateTime; }
    public Long getParentCommentId() { return parentCommentId; }
    public void setParentCommentId(Long parentCommentId) { this.parentCommentId = parentCommentId; }
}

