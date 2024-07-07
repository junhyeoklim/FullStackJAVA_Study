package board.dto;

import java.util.List;

public class BoardDTO {
    private long b_id;
    private int post_num;
    private String title;
    private String content;
    private String s_name;
    private int s_id;
    private String s_department; // 필드 이름 확인
    private String createTime;
    private String updateTime;
    private long views;
    private int commentCnt;
    private boolean isNotice;
    private List<FileDTO> fileList; 
    
    
    
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
    public boolean isNotice() {
        return isNotice;
    }

    public void setNotice(boolean isNotice) {
        this.isNotice = isNotice;
    }
	public long getB_id() {
		return b_id;
	}
	public void setB_id(long b_id) {
		this.b_id = b_id;
	}
	public int getPost_num() {
		return post_num;
	}
	public void setPost_num(int post_num) {
		this.post_num = post_num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getS_id() {
		return s_id;
	}
	public void setS_id(int s_id) {
		this.s_id = s_id;
	}
	public String getS_department() {
		return s_department;
	}
	public void setS_department(String s_department) {
		this.s_department = s_department;
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
	public long getViews() {
		return views;
	}
	public void setViews(long views) {
		this.views = views;
	}
	public int getCommentCnt() {
		return commentCnt;
	}
	public void setCommentCnt(int commentCnt) {
		this.commentCnt = commentCnt;
	}
	public List<FileDTO> getFileList() {
		return fileList;
	}
	public void setFileList(List<FileDTO> fileList) {
		this.fileList = fileList;
	}
	
	
}
