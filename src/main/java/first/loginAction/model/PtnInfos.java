package first.loginAction.model;

//사업자정보 
public class PtnInfos {

	// 사업자ID 
	private String ptnCd;

	// 사업자등록번호 
	private String bizrRegNo;

	// 사업자명 
	private String ptnNm;

	// 대표자명 
	private String rpstNm;

	// 대표전화번호 
	private String rpstTel;

	// FAX번호 
	private String faxNo;

	// 우편번호 
	private String addNo;

	// 동네 
	private String neighbor;

	// 프로필사진 
	private String profilePic;


	public String getPtnCd() {
		return ptnCd;
	}

	public void setPtnCd(String ptnCd) {
		this.ptnCd = ptnCd;
	}

	public String getBizrRegNo() {
		return bizrRegNo;
	}

	public void setBizrRegNo(String bizrRegNo) {
		this.bizrRegNo = bizrRegNo;
	}

	public String getPtnNm() {
		return ptnNm;
	}

	public void setPtnNm(String ptnNm) {
		this.ptnNm = ptnNm;
	}

	public String getRpstNm() {
		return rpstNm;
	}

	public void setRpstNm(String rpstNm) {
		this.rpstNm = rpstNm;
	}

	public String getRpstTel() {
		return rpstTel;
	}

	public void setRpstTel(String rpstTel) {
		this.rpstTel = rpstTel;
	}

	public String getFaxNo() {
		return faxNo;
	}

	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
	}

	public String getAddNo() {
		return addNo;
	}

	public void setAddNo(String addNo) {
		this.addNo = addNo;
	}

	public String getNeighbor() {
		return neighbor;
	}

	public void setNeighbor(String neighbor) {
		this.neighbor = neighbor;
	}

	public String getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

	// PtnInfos 모델 복사
	public void CopyData(PtnInfos param)
	{
		this.ptnCd = param.getPtnCd();
		this.bizrRegNo = param.getBizrRegNo();
		this.ptnNm = param.getPtnNm();
		this.rpstNm = param.getRpstNm();
		this.rpstTel = param.getRpstTel();
		this.faxNo = param.getFaxNo();
		this.addNo = param.getAddNo();
		this.neighbor = param.getNeighbor();
		this.profilePic = param.getProfilePic();
	}


	@Override
	public String toString() {
		return "PtnInfos [ptnCd=" + ptnCd + ", bizrRegNo=" + bizrRegNo + ", ptnNm=" + ptnNm + ", rpstNm=" + rpstNm
				+ ", rpstTel=" + rpstTel + ", faxNo=" + faxNo + ", addNo=" + addNo + ", neighbor=" + neighbor
				+ ", profilePic=" + profilePic + "]";
	}

}