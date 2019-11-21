package first.actions.model;

//이벤트 참여이력 
public class EventHist {

	// 사용자ID 
	private String userId;

	// 이벤트 번호 
	private Integer eventSeq;

	// 참여상태 
	private String partStatus;

	// 이벤트 명 
	private String eventNm;

	// 리뷰여부 
	private String reviewYn;

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

	public String getPartStatus() {
		return partStatus;
	}

	public void setPartStatus(String partStatus) {
		this.partStatus = partStatus;
	}

	public String getEventNm() {
		return eventNm;
	}

	public void setEventNm(String eventNm) {
		this.eventNm = eventNm;
	}

	public String getReviewYn() {
		return reviewYn;
	}

	public void setReviewYn(String reviewYn) {
		this.reviewYn = reviewYn;
	}

	// EventHist 모델 복사
	public void CopyData(EventHist param)
	{
		this.userId = param.getUserId();
		this.eventSeq = param.getEventSeq();
		this.partStatus = param.getPartStatus();
		this.eventNm = param.getEventNm();
		this.reviewYn = param.getReviewYn();
	}

	@Override
	public String toString() {
		return "EventHist [userId=" + userId + ", eventSeq=" + eventSeq + ", partStatus=" + partStatus + ", eventNm="
				+ eventNm + ", reviewYn=" + reviewYn + "]";
	}


}