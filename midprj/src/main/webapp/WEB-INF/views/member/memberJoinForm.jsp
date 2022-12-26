<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입폼</title>
<style>
body {
  font-family: Arial, Helvetica, sans-serif;
  background-color: black;
}

* {
  box-sizing: border-box;
}

/* Add padding to containers */
.container {
  padding: 16px;
  background-color: white;
}

/* Full-width input fields */
input[type=text], input[type=password] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}

/* Overwrite default styles of hr */
hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 25px;
}

/* Set a style for the submit button */
.registerbtn {
  background-color: #04AA6D;
  color: white;
  padding: 16px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
}

.registerbtn:hover {
  opacity: 1;
}

/* Add a blue text color to links */
a {
  color: dodgerblue;
}

/* Set a grey background color and center the text of the "sign in" section */
.signin {
  background-color: #f1f1f1;
  text-align: center;
}
</style>
</head>

<body>


<form id="frm" action="memberJoin.do" onsubmit="return formCheck()" method="post">
  <div class="container">
    <h1>Register</h1>
    <p>Please fill in this form to create an account.</p>
    <hr>

    <label for="id"><b>아이디</b></label>
    <input type="text" placeholder="아이디를 입력하세요" id="mId" name="mId" required="required">&nbsp;
	<button type="button" onclick="idChk()" id="btnId" value="No">중복체크</button>
	
	
    <label for="psw"><b>비밀번호</b></label>
    <input type="password" placeholder="비밀번호를 입력하세요" id="mPw" name="mPw" required="required">>

    <label for="psw-repeat"><b>패스워드 확인</b></label>
    <input type="password" placeholder="비밀번호를 재입력하세요" id="passwordChk" required="required">
    
  	<label for="name"><b>이름</b></label>
    <input type="text" placeholder="이름을 입력하세요" id="mName" name="mName" required="required">
    
    <label for="addr"><b>주소</b></label>
    <input type="text" placeholder="이름을 입력하세요" id="mAddr" name="mAddr">
    
    <label for="tel"><b>전화번호</b></label>
    <input type="tel" placeholder="이름을 입력하세요"id="mTel" name="mTel">
    
    <hr>
    
    <input type="submit" value="회원가입"> &nbsp;&nbsp; 
	<input type="reset" value="취소"> &nbsp;&nbsp; 
	<input type="button" onclick="location.href='main.do'" value="홈가기">
    
    <p>By creating an account you agree to our <a href="#">Terms & Privacy</a>.</p>

    <button type="submit" class="registerbtn">Register</button>
  </div>
  
  <div class="container signin">
    <p>Already have an account? <a href="#">Sign in</a>.</p>
  </div>
</form>

	<script type="text/javascript">
		function formCheck() { // 아이디 중복체크 및 패스워드 동일성 확인
			let pass1 = document.getElementById("mPw").value;
			let pass2 = document.getElementById("passwordChk").value;
			let checkId = document.getElementById("btnId").value;

			if (checkId == "No") {
				alert("아이디 중복체크를 하세요!!");
				return false;
			}
			if (pass1 != pass2) {
				alert("패스워드가 일치하지 않습니다. !!!");
				document.getElementById("mPw").value = "";
				document.getElementById("passwordChk").value = "";
				document.getElementById("mPw").focus();
				return false;
			}

			return true;
		}

		function idChk() { // 아이디 중복체크 Ajax로 비교
			let id = document.getElementById("mId").value;
			let url = 'AjaxMemberIdCheck.do?id='+id; // get방식으로 보내기
			console.log('ddd')
			fetch(url)
				.then((response)=>response.text()) 
				.then((data)=>idCheck(data));
		}
		
		
		function idCheck(str){
			if (str == '1'){
				alert("사용할 수 있는 아이디입니다. !!");
				document.getElementById("btnId").value = 'Yes';
				document.getElementById("btnId").disabled = true; // 버튼 비활성화
			}else{
				console.log(str)
				alert("이미 사용하는 아이디 입니다. \n다시 입력하세요.");
				document.getElementById("mId").value="";
				document.getElementById("mId").focus();
			}
		}
		
	</script>
</body>
</html>