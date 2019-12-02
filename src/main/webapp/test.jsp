<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

 
<select name="selectBox" id="selectBox">
    <option value="가" selected>A</option>
    <option value="나">B</option>
    <option value="다">C</option>
</select>
</body>

<script type="text/javascript">
    var target = document.getElementById("selectBox");
    alert('선택된 옵션 text 값=' + target.options[target.selectedIndex].text);     // 옵션 text 값
       alert('선택된 옵션 value 값=' + target.options[target.selectedIndex].value);     // 옵션 value 값

</script>


</body>
</html>