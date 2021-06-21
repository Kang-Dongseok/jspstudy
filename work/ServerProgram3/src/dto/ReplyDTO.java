package dto;

import java.sql.Date;

public class ReplyDTO {

	private long no;
	private String author;
	private String content;
	private String ip;
	private long boardNo;
	private Date postdate;
	
	public ReplyDTO() {}
	public ReplyDTO(long no, String author, String content, String ip, long boardNo, Date postdate) {
		super();
		this.no = no;
		this.author = author;
		this.content = content;
		this.ip = ip;
		this.boardNo = boardNo;
		this.postdate = postdate;
	}
	
	public long getNo() {
		return no;
	}
	public void setNo(long no) {
		this.no = no;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public long getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(long boardNo) {
		this.boardNo = boardNo;
	}
	public Date getPostdate() {
		return postdate;
	}
	public void setPostdate(Date postdate) {
		this.postdate = postdate;
	}
	
}
