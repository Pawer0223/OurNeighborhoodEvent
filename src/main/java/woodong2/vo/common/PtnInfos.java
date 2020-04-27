package woodong2.vo.common;

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

	// 전체 도로명 주소 
	private String addressNm;

	// 우편번호 
	private String zoneNo;

	// 위도 
	private String latitude;

	// 경도 
	private String longitude;

	// 지역명1 
	private String region1depthNm;

	// 지역명2 
	private String region2depthNm;

	// 지역명3 
	private String region3depthNm;

	// 도로명 
	private String roadNm;
	
	// default constructor
	public PtnInfos() {};
	
	public PtnInfos(String addressNm, String zoneNo, String latitude, String longitude, String region1depthNm,
			String region2depthNm, String region3depthNm, String roadNm) {
		super();
		this.addressNm = addressNm;
		this.zoneNo = zoneNo;
		this.latitude = latitude;
		this.longitude = longitude;
		this.region1depthNm = region1depthNm;
		this.region2depthNm = region2depthNm;
		this.region3depthNm = region3depthNm;
		this.roadNm = roadNm;
	}

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

	public String getAddressNm() {
		return addressNm;
	}

	public void setAddressNm(String addressNm) {
		this.addressNm = addressNm;
	}

	public String getZoneNo() {
		return zoneNo;
	}

	public void setZoneNo(String zoneNo) {
		this.zoneNo = zoneNo;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	
	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getRegion1depthNm() {
		return region1depthNm;
	}

	public void setRegion1depthNm(String region1depthNm) {
		this.region1depthNm = region1depthNm;
	}

	public String getRegion2depthNm() {
		return region2depthNm;
	}

	public void setRegion2depthNm(String region2depthNm) {
		this.region2depthNm = region2depthNm;
	}

	public String getRegion3depthNm() {
		return region3depthNm;
	}

	public void setRegion3depthNm(String region3depthNm) {
		this.region3depthNm = region3depthNm;
	}

	public String getRoadNm() {
		return roadNm;
	}

	public void setRoadNm(String roadNm) {
		this.roadNm = roadNm;
	}

	@Override
	public String toString() {
		return "PtnInfos [ptnCd=" + ptnCd + ", bizrRegNo=" + bizrRegNo + ", ptnNm=" + ptnNm + ", rpstNm=" + rpstNm
				+ ", rpstTel=" + rpstTel + ", addressNm=" + addressNm + ", zoneNo=" + zoneNo + ", latitude=" + latitude
				+ ", longitude=" + longitude + ", region1depthNm=" + region1depthNm + ", region2depthNm="
				+ region2depthNm + ", region3depthNm=" + region3depthNm + ", roadNm=" + roadNm + "]";
	}

}