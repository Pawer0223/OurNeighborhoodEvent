package first.actions.model;

//리뷰정보 
public class ReviewInfos {

	// 리뷰번호 
	private Integer reviewSeq;

	// 사용자ID 
	private String userId;

	// 이벤트 번호 
	private Integer eventSeq;

	// 사업자ID 
	private String ptnCd;

	// 리뷰제목 
	private String reviewName;

	// 리뷰내용 
	private String reviewDesc;
	
	private int stars;

	public Integer getReviewSeq() {
		return reviewSeq;
	}

	public void setReviewSeq(Integer reviewSeq) {
		this.reviewSeq = reviewSeq;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getEventSeq() {
		return eventSeq;
	}

	public void setEventSeq(Integer eventSeq) {
		this.eventSeq = eventSeq;
	}

	public String getPtnCd() {
		return ptnCd;
	}

	public void setPtnCd(String ptnCd) {
		this.ptnCd = ptnCd;
	}

	public String getReviewName() {
		return reviewName;
	}

	public void setReviewName(String reviewName) {
		this.reviewName = reviewName;
	}

	public String getReviewDesc() {
		return reviewDesc;
	}

	public void setReviewDesc(String reviewDesc) {
		this.reviewDesc = reviewDesc;
	}
	

	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

	@Override
	public String toString() {
		return "ReviewInfos [reviewSeq=" + reviewSeq + ", userId=" + userId + ", eventSeq=" + eventSeq + ", ptnCd="
				+ ptnCd + ", reviewName=" + reviewName + ", reviewDesc=" + reviewDesc + ", stars=" + stars + "]";
	}

}