package dto;

public class PageVO {

	/*************************
	
	게시글1      관리자      2021-05-21
	게시글2      관리자      2021-05-21
	게시글3      관리자      2021-05-21
	
		 << 1 2 3 4 5 >>
	 ************************/
	private int totalRecord = 0;    // 전체 게시글의 개수
	private int totalPage = 0;      // 전체 페이지의 개수
	private int recordPerPage = 3;  // 한 페이지당 게시글의 개수
	
	private int page = 1;			// 현재 페이지 번호(기본 1페이지)
	private int beginRecord = 0;	// 각 페이지에 표시되는 시작 게시글 번호
	private int endRecord = 0;		// 각 페이지에 표시되는 종료 게시글 번호
	
	private int pagePerBlock = 5;	// 한 블록에 5개 페이지를 표시
	private int beginPage = 0; 		// 각 블록에 표시되는 시작 페이지 번호
	private int endPage = 0;		// 각 블록에 표시되는 종료 페이지 번호
	
	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
	public int getTotalPage() {
		return totalPage;
	}
	// 전체 페이지는 전체 레코드 개수와 한 페이지에 표시되는 게시글 개수로 계산한다.
	public void setTotalPage() {
		totalPage = totalRecord / recordPerPage;
		if (totalRecord % recordPerPage != 0) {
			totalPage++;
		}
	}
	public int getRecordPerPage() {
		return recordPerPage;
	}
	public void setRecordPerPage(int recordPerPage) {
		this.recordPerPage = recordPerPage;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getBeginRecord() {
		return beginRecord;
	}
	public void setBeginRecord(int beginRecord) {
		this.beginRecord = beginRecord;
	}
	public int getEndRecord() {
		return endRecord;
	}
	public void setEndRecord(int endRecord) {
		this.endRecord = endRecord;
	}
	public int getPagePerBlock() {
		return pagePerBlock;
	}
	public void setPagePerBlock(int pagePerBlock) {
		this.pagePerBlock = pagePerBlock;
	}
	public int getBeginPage() {
		return beginPage;
	}
	public void setBeginPage(int beginPage) {
		this.beginPage = beginPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
}
