<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>

<link rel="icon" href="./image/logo-icon.png"/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.0/css/all.min.css" integrity="sha512-9xKTRVabjVeZmc+GUW8GgSmcREDunMM+Dt/GrzchfN8tkwHizc5RP4Ok/MXFFy5rIjJjzhndFScTceq5e6GvVQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet" href="./css/style.css"/>



<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script src="https://www.gstatic.com/firebasejs/7.3.0/firebase.js"></script>
<script src="https://www.gstatic.com/firebasejs/7.3.0/firebase-app.js"></script>
<script src="https://www.gstatic.com/firebasejs/7.3.0/firebase-storage.js"></script>

<script src="./js/save-user.js"></script>
<script src="./js/async.js"></script>

</head>
<body>
	
	<div class="center-container" style="flex-direction:column	;">
	
		
		<div style="margin-top: 100px;text-align: center;">
			<img src="./image/store.png" style="width:100px;"/>
			<h2>회원가입</h2>
		</div>

		<div class="form-container">


			<img id="profile-img" style="margin-bottom: 20px; " src="./image/default_profile.png"/>
			<input style="display: none;" type="file" id="file"/>

			<div class="input-with-btn">
				<input type="text" id="id" placeholder="아이디"/>
				<button id="check-id-btn">중복확인</button>
			</div>
			
			<input type="password" id="pw" placeholder="비밀번호"/>
			<input type="password" id="pw2" placeholder="비밀번호 확인" style="margin-bottom: 4px;"/>
			<div style="margin-bottom: 15px;">비밀번호가 일치 합니다.</div>
			<div class="input-with-btn">
				<input type="text" id="nick" placeholder="닉네임"/>
				<button id="check-nick-btn">중복확인</button>
			</div>
			
			<input type="text" id="address" placeholder="주소(선택사항)"/>


			<button class="submit-btn" id="save-user-btn">
				<div id="loader" class="loader" style="margin-right: 8px;display: none;"></div>
				회원가입
			</button>
		</div>
		

	</div>

	
	


	
</body>
</html>