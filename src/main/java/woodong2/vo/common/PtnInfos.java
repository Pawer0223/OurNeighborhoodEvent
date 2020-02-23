package woodong2.vo.common;

//사업자정보 
public class PtnInfos {

	// 사업자ID 
	private String ptnCd;

	// 사업자등록번호 
	private String bizrRegNo;

	// 상호명 
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

	@Override
	public String toString() {
		return "PtnInfos [ptnCd=" + ptnCd + ", bizrRegNo=" + bizrRegNo + ", ptnNm=" + ptnNm + ", rpstNm=" + rpstNm
				+ ", rpstTel=" + rpstTel + ", faxNo=" + faxNo + ", addNo=" + addNo + ", neighbor=" + neighbor + "]";
	}

}