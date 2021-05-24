package dto;

import java.sql.Date;

public class BoardDTO {
	
	private long idx;
	private String author;
	private String title;
	private String content;
	private int hit;
	private Date postdate;
	public long getIdx() {
		return idx;
	}
	public void setIdx(long idx) {
		this.idx = idx;
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
	public Date getPostdate() {
		return postdate;
	}
	public void setPostdate(Date postdate) {
		this.postdate = postdate;
	}
	@Override
	public String toString() {
		return "BoardDTO [idx=" + idx + ", author=" + author + ", title=" + title + ", content=" + content + ", hit="
				+ hit + ", postdate=" + postdate + "]";
	}
	
}