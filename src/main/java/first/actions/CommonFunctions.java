package first.actions;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CommonFunctions {
	
	/**
	 * SHA-256으로 해싱하는 메소드
	 * 
	 * @param bytes
	 * @return
	 * @throws NoSuchAlgorithmException 
	 */
	private byte[] sha256(String msg) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(msg.getBytes());

		return md.digest();
	}
	
	/**
	 * 바이트를 헥사값으로 변환한다, type 1 , 16진수로변환
	 * 
	 * @param bytes
	 * @return
	 */
	private String bytesToHex1(byte[] bytes) {
	    StringBuilder builder = new StringBuilder();
	    for (byte b: bytes) {
	      builder.append(String.format("%02x", b));
	    }
	    return builder.toString();
	}
	
	public String makeEncrypt(String msg) throws NoSuchAlgorithmException {
		return bytesToHex1(sha256(msg));
	}
	

}
