<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>

<link rel="icon" href="./image/logo-icon.png"/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.0/css/all.min.css" integrity="sha512-9xKTRVabjVeZmc+GUW8GgSmcREDunMM+Dt/GrzchfN8tkwHizc5RP4Ok/MXFFy5rIjJjzhndFScTceq5e6GvVQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet" href="./css/style.css"/>



<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script src="./js/login.js"></script>
</head>
<body>
	
	<div class="center-container" style="flex-direction:column	;">
	
		
		<div style="margin-top: 100px;text-align: center;">
			<img src="./image/store.png" style="width:100px;"/>
			<h2>로그인</h2>
		</div>

		<div class="form-container">
			
			<input type="text" id="id" placeholder="아이디"/>
			<input type="password" id="pw" placeholder="비밀번호"/>
			

			<button class="submit-btn" id="login-btn">로그인</button>
		</div>
		

	</div>

	
	


	
</body>
</html>