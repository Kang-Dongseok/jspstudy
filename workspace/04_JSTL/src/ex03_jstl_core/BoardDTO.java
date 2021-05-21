package ex03_jstl_core;

public class BoardDTO {

	private String no;
	private String title;
	private String content;
	private String author;
	private int like;
	
	public BoardDTO() {}
	public BoardDTO(String no, String title, String content, String author, int like) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.author = author;
		this.like = like;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getLike() {
		return like;
	}

	public void setLike(int like) {
		this.like = like;
	}
}
