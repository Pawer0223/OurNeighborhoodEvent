package woodong2.utilities.function;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class CommonFunctions {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());

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

	
	// 파일 업로드를 위한 메서드
	
	// 윈도우라면 workspace의 드라이브를 파악하여 JVM이 알아서 처리해준다.
	// 따라서 workspace가 C드라이브에 있다면 C드라이브에 upload 폴더를 생성해 놓아야 한다.
	private static final String SAVE_PATH = "/upload";
	private static final String PREFIX_URL = "/upload/";

	public String restore(MultipartFile multipartFile , String subDir) {
		
		String url = null;

		try {
			// 파일 정보
			String originFilename = multipartFile.getOriginalFilename();
			String extName = originFilename.substring(originFilename.lastIndexOf("."), originFilename.length());
			Long size = multipartFile.getSize();

			// 서버에서 저장 할 파일 이름
			String saveFileName = genSaveFileName(extName);

			log.debug("originFilename : " + originFilename);
			log.debug("extensionName : " + extName);
			log.debug("size : " + size);
			log.debug("saveFileName : " + saveFileName);

			writeFile(multipartFile, saveFileName , subDir);
			url = PREFIX_URL + subDir + "/" + saveFileName;
		}
		catch (IOException e) {
			// 원래라면 RuntimeException 을 상속받은 예외가 처리되어야 하지만
			// 편의상 RuntimeException을 던진다.
			// throw new FileUploadException();	
			throw new RuntimeException(e);
		}
		return url;
	}


	// 현재 시간을 기준으로 파일 이름 생성
	private String genSaveFileName(String extName) {
		String fileName = "";

		Calendar calendar = Calendar.getInstance();
		fileName += calendar.get(Calendar.YEAR);
		fileName += calendar.get(Calendar.MONTH);
		fileName += calendar.get(Calendar.DATE);
		fileName += calendar.get(Calendar.HOUR);
		fileName += calendar.get(Calendar.MINUTE);
		fileName += calendar.get(Calendar.SECOND);
		fileName += calendar.get(Calendar.MILLISECOND);
		fileName += extName;

		return fileName;
	}


	// 파일을 실제로 write 하는 메서드
	private boolean writeFile(MultipartFile multipartFile, String saveFileName , String subDir)
			throws IOException{
		boolean result = false;
		
		String savePath = SAVE_PATH + "/" + subDir;
		
		File file = new File("c:/"+savePath);
		
		//디렉토리가 존재하지않으면 자동으로 생성해주기
		if ( !file.exists() ) {
			file.mkdirs();
		}

		byte[] data = multipartFile.getBytes();
		FileOutputStream fos = new FileOutputStream(savePath+ "/" + saveFileName);
		fos.write(data);
		fos.close();

		return result;
	}



}
