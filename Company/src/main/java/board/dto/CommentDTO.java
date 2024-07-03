package board.dto;

public class CommentDTO {
    private long comment_Id;
    private long b_Id;
    private int s_id;
    private String userName;
    private String content;
    private String createTime;
    private String updateTime;
    private Long parentCommentId;
    private boolean is_deleted;
    private int depth;
    private int orderNumber;
    
    
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
	
	public int getS_id() {
		return s_id;
	}
	public void setS_id(int s_id) {
		this.s_id = s_id;
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
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public Long getParentCommentId() {
		return parentCommentId;
	}
	public void setParentCommentId(Long parentCommentId) {
		this.parentCommentId = parentCommentId;
	}
	public boolean isIs_deleted() {
		return is_deleted;
	}
	public void setIs_deleted(boolean is_deleted) {
		this.is_deleted = is_deleted;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public int getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	
}
