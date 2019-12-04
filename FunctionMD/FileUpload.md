## 회원가입 및 이벤트 등록시 사진업로드기능 구현

- pom.xml에 파입업로드를 위한 라이브러리설정 추가.
```
		<!-- 파일 업로드를위해서 추가 -->
		<!-- Apache Commons file upload  -->
		<dependency>
			<groupId>commons-fileupload</groupId>
			<artifactId>commons-fileupload</artifactId>
			<version>1.3.3</version>
		</dependency>
		
		<!-- Apache Commons IO -->
		<dependency>
			<groupId>org.apache.commons</groupId>
			<artifactId>commons-io</artifactId>
			<version>1.3.2</version>
		</dependency>
```

- action-sevlet.xml에 CommonsMultipartResolver클래스를 사용하기 위한 beand_id 설정 추가.

```
	 <!--파일 업로드 하기위해서 추가 -->		  
	 <!-- 멀티파트 리졸버 -->
	<bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
		<!-- 최대업로드 가능한 바이트크기 -->
		<property name="maxUploadSize" value="100000000" />
		<!-- 디스크에 임시 파일을 생성하기 전에 메모리에 보관할수있는 최대 바이트 크기 -->
		<property name="maxInMemorySize" value="100000000" />
		<!-- defaultEncoding -->
		<property name="defaultEncoding" value="utf-8" />
	</bean>
```

- form태그의 enctype="multipart/form-data"로 지정.

```
<form method="post" enctype="multipart/form-data" action="/first/userInfos/userRegist.do">
  ...
  ...
</form>
```

- model클래스에 MultipartFile타입의 변수추가.

```
	// 프로필사진, 파일업로드하기위한 용도
	private MultipartFile pictureFile;
  ```

- 파일명 중복을 예방하기위해 현재시간을 기준으로 파일명을 생성하도록 구현

```
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
```

- FileOutputStream클래스를 활용하여 지정한 dir에 파일업로드 수행.

```
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

```

- 업로드 파일의 절대경로를 DB에 저장

- 업로드 수행 메서드 : <a href="https://github.com/Taesan94/OurNeighborhoodEvent/blob/master/src/main/java/first/common/commonFn/CommonFunctions.java">[ restore ]</a>

