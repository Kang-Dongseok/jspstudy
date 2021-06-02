package dto;

import java.sql.Date;

public class BoardDTO {

	private long no;
	private String author;
	private String title;
	private String content;
	private String ip;
	private int hit;
	private Date postdate;
	private Date lastmodified;
	private int state;
	private long groupno;
	private int groupord;
	private int depth;
	
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
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public Date getPostdate() {
		return postdate;
	}
	public void setPostdate(Date postdate) {
		this.postdate = postdate;
	}
	public Date getLastmodified() {
		return lastmodified;
	}
	public void setLastmodified(Date lastmodified) {
		this.lastmodified = lastmodified;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public long getGroupno() {
		return groupno;
	}
	public void setGroupno(long groupno) {
		this.groupno = groupno;
	}
	public int getGroupord() {
		return groupord;
	}
	public void setGroupord(int groupord) {
		this.groupord = groupord;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	
}