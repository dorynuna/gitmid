<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div align="center">
	<br><br>
	<div><h1>회 원 목 록</h1></div>
	<div>
		<table border="1">
			<thead>
				<tr>
					<td width="150" align="center">아이디</td>
					<td width="150" align="center">이 름</td>
					<td width="150" align="center">나 이</td>
					<td width="150" align="center">전화번호</td>
					<td width="250" align="center">주 소</td>
					<td width="150" align="center">권 한</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${members }" var="m">
					<tr onmouseover="this.style.background='#fcecae'" 
						onmouseleave="this.style.background='#FFFFFF'"
						onclick="memberSelect('${m.mId}')">
					<td width="150" align="center">${m.mId }</td>
					<td width="150" align="center">${m.mName }</td>
					<td width="150" align="center">${m.mTel }</td>
					<td width="250" align="center">${m.mAddr }</td>
					<td width="150" align="center">${m.mrAuthor }</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div><br>
	<div>
		<form id="frm" action="memberSelect.do" method="post">
			<input type="hidden" id="mId" name="mId">
		</form>
	</div>
</div>
<script type="text/javascript">
	function memberSelect(id){
		document.getElementById("mId").value=id;
		frm.submit();  //숨겨진 폼을 전송한다.
	}
</script>

</body>
</html>