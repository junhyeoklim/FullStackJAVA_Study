package board.dto;

import java.sql.Timestamp;

public class CommentDTO {
    private long comment_Id;
    private long b_Id;
    private String userName;
    private String content;
    private Timestamp createTime;
    private Timestamp updateTime;
    private Long parentCommentId;
    
    
	public long getComment_Id() {
		return comment_Id;
	}
	public void setComment_Id(long comment_Id) {
		this.comment_Id = comment_Id;
	}
	public long getB_Id() {
		return b_Id;
	}
	public void setB_Id(long b_Id) {
		this.b_Id = b_Id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public Timestamp getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	public Long getParentCommentId() {
		return parentCommentId;
	}
	public void setParentCommentId(Long parentCommentId) {
		this.parentCommentId = parentCommentId;
	}
}
