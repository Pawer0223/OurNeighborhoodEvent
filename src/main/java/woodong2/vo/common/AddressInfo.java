package woodong2.vo.common;

public class AddressInfo {
	
	// x좌표
	private String x ;
	
	// y좌표
	private String y ;
	
	// 주소명
	private String addressNm;
	
	public AddressInfo(String x, String y, String addressNm){
		this.x=x;
		this.y=y;
		this.addressNm=addressNm;
	}
	

	public String getX() {
		return x;
	}

	public void setX(String x) {
		this.x = x;
	}

	public String getY() {
		return y;
	}

	public void setY(String y) {
		this.y = y;
	}

	public String getAddressNm() {
		return addressNm;
	}

	public void setAddressNm(String addressNm) {
		this.addressNm = addressNm;
	}

	@Override
	public String toString() {
		return "AddressInfo [x=" + x + ", y=" + y + ", addressNm=" + addressNm + "]";
	}

}
