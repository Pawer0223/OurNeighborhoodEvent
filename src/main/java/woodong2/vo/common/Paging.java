package woodong2.vo.common;

public class Paging {

	// 현재페이지, 시작페이지, 끝페이지, 게시글 총 갯수, 페이지당 글 갯수, 마지막페이지, SQL쿼리에 쓸 start, end
	private int nowPage,	// 현재페이지
				startPage,	// 시작페이지
				endPage,	// 끝페이지
				total,		// 게시글 총 갯수
				cntPerPage,	// 페이지당 글 갯수
				lastPage, 	// 마지막페이지
				start, 		// 쿼리 start조건
				end			// 쿼리 end조건
				;
	
	// 리스트 몇개까지 보여줄껀지
	private int cntPage = 5;

	public Paging() {

	}// default 생성자

	public Paging(int total, int nowPage, int cntPerPage) {
		setNowPage(nowPage);
		setCntPerPage(cntPerPage);
		setTotal(total);
		calcLastPage(getTotal(), getCntPerPage());
		calcStartEndPage(getNowPage(), cntPage);
		calcStartEnd(getNowPage(), getCntPerPage());
	}

	// 제일 마지막 페이지 계산
	public void calcLastPage(int total, int cntPerPage) {
		
		setLastPage((int) Math.ceil((double)total / (double)cntPerPage));
	}
	// 시작, 끝 페이지 계산
	public void calcStartEndPage(int nowPage, int cntPage) {
		
		setEndPage(((int)Math.ceil((double)nowPage / (double)cntPage)) * cntPage);
		if (getLastPage() < getEndPage()) {
			setEndPage(getLastPage());
		}
		
		// EndPage가 6일때 ..StartPage도 6이 나와야 함..최초 산식에 따르면 2가 나옴 ....
		
		// 총 페이지가 11개 까지있는데 내가 선택한게 6번째라고하면 ?
		
		// ex) 11을 5로 나누면 [ 1~5 , 6~10 , 11~ 11 ] 3구간 존재
		
		// 1~4까지는 5로나누었을때 몫이 0 5는 1 즉, 나머지가 0일때는 , 몫 -1을 곱하면 됨.
		
		int mok = nowPage/cntPage;
		
		if ( nowPage%cntPage==0 ) mok-=1;
		
		setStartPage( cntPage*mok + 1 );
		
		if (getStartPage() < 1) {
			setStartPage(1);
		}
	}

	// DB 쿼리에서 사용할 start, end값 계산
	public void calcStartEnd(int nowPage, int cntPerPage) {
		setEnd(nowPage * cntPerPage);
		setStart(getEnd() - cntPerPage + 1);
	}

	public int getNowPage() {
		return nowPage;
	}

	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getCntPerPage() {
		return cntPerPage;
	}

	public void setCntPerPage(int cntPerPage) {
		this.cntPerPage = cntPerPage;
	}

	public int getLastPage() {
		return lastPage;
	}

	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public int getCntPage() {
		return cntPage;
	}

	public void setCntPage(int cntPage) {
		this.cntPage = cntPage;
	}

	@Override
	public String toString() {
		return "Paging [nowPage=" + nowPage + ", startPage=" + startPage + ", endPage=" + endPage + ", total=" + total
				+ ", cntPerPage=" + cntPerPage + ", lastPage=" + lastPage + ", start=" + start + ", end=" + end + "]";
	}
		
	}//class
