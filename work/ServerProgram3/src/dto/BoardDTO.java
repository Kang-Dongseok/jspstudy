package dto;

import java.sql.Date;

public class BoardDTO {

	private long no;
	private String author;
	private String title;
	private String content;
	private int hit;
	private String ip;
	private Date postdate;
	
	public BoardDTO() {}
	public BoardDTO(long no, String author, String title, String content, int hit, String ip, Date postdate) {
		super();
		this.no = no;
		this.author = author;
		this.title = title;
		this.content = content;
		this.hit = hit;
		this.ip = ip;
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
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Date getPostdate() {
		return postdate;
	}
	public void setPostdate(Date postdate) {
		this.postdate = postdate;
	}
	
}
