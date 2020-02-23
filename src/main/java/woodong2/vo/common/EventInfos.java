package woodong2.vo.common;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

// 이벤트정보 
public class EventInfos implements Serializable {

    // 이벤트 번호 
    private String eventSeq;

    // 사업자ID 
    private String ptnCd;

    // 사업자 명 
    private String ptnNm;

    // 이벤트 명 
    private String eventNm;

    // 이벤트 내용 
    private String eventDesc;

    // 이벤트 상품 
    private String product;

    // 상품이미지 
    private String productPic;
    
    // 상품이미지  
    private MultipartFile pictureFile;

    // 원 금액 
    private Long originPrice;

    // 이벤트 금액 
    private Long eventPrice;

    // 수량 
    private Integer amount;

    // 이벤트 진행상태 
    private String eventStatus;

    // 동네 
    private String neighbor;

    // 배달가능여부 
    private String deliveryYn;

    public String getEventSeq() {
        return eventSeq;
    }

    public void setEventSeq(String eventSeq) {
        this.eventSeq = eventSeq;
    }

    public String getPtnCd() {
        return ptnCd;
    }

    public void setPtnCd(String ptnCd) {
        this.ptnCd = ptnCd;
    }

    public String getPtnNm() {
        return ptnNm;
    }

    public void setPtnNm(String ptnNm) {
        this.ptnNm = ptnNm;
    }

    public String getEventNm() {
        return eventNm;
    }

    public void setEventNm(String eventNm) {
        this.eventNm = eventNm;
    }

    public String getEventDesc() {
        return eventDesc;
    }

    public void setEventDesc(String eventDesc) {
        this.eventDesc = eventDesc;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getProductPic() {
        return productPic;
    }

    public void setProductPic(String productPic) {
        this.productPic = productPic;
    }

    public Long getOriginPrice() {
        return originPrice;
    }

    public void setOriginPrice(Long originPrice) {
        this.originPrice = originPrice;
    }

    public Long getEventPrice() {
        return eventPrice;
    }

    public void setEventPrice(Long eventPrice) {
        this.eventPrice = eventPrice;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getEventStatus() {
        return eventStatus;
    }

    public void setEventStatus(String eventStatus) {
        this.eventStatus = eventStatus;
    }

    public String getNeighbor() {
        return neighbor;
    }

    public void setNeighbor(String neighbor) {
        this.neighbor = neighbor;
    }

    public String getDeliveryYn() {
        return deliveryYn;
    }

    public void setDeliveryYn(String deliveryYn) {
        this.deliveryYn = deliveryYn;
    }
    
    public MultipartFile getPictureFile() {
		return pictureFile;
	}

	public void setPictureFile(MultipartFile pictureFile) {
		this.pictureFile = pictureFile;
	}

	@Override
	public String toString() {
		return "EventInfos [eventSeq=" + eventSeq + ", ptnCd=" + ptnCd + ", ptnNm=" + ptnNm + ", eventNm=" + eventNm
				+ ", eventDesc=" + eventDesc + ", product=" + product + ", productPic=" + productPic + ", pictureFile="
				+ pictureFile + ", originPrice=" + originPrice + ", eventPrice=" + eventPrice + ", amount=" + amount
				+ ", eventStatus=" + eventStatus + ", neighbor=" + neighbor + ", deliveryYn=" + deliveryYn + "]";
	}
	
}