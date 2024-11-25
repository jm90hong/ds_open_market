<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품등록</title>

<link rel="icon" href="./image/logo-icon.png"/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.0/css/all.min.css" integrity="sha512-9xKTRVabjVeZmc+GUW8GgSmcREDunMM+Dt/GrzchfN8tkwHizc5RP4Ok/MXFFy5rIjJjzhndFScTceq5e6GvVQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet" href="./css/style.css"/>
<link rel="stylesheet" href="./css/style1.css"/>
<link rel="stylesheet" href="./css/index.css"/>
<link rel="stylesheet" href="./css/detail-item.css"/>

<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script src="https://www.gstatic.com/firebasejs/7.3.0/firebase.js"></script>
<script src="https://www.gstatic.com/firebasejs/7.3.0/firebase-app.js"></script>
<script src="https://www.gstatic.com/firebasejs/7.3.0/firebase-storage.js"></script>

<script src="./js/util.js"></script>
<script src="./js/save-item.js"></script>
<script src="./js/async.js"></script>

</head>
<body>
	
	<div class="detail-container1" style="width:650px;display: block;">
		<div style="color:#191919;font-weight:700;font-size:20px;">
			어떤 <font style="color:var(--color-main)">경험</font>을 하셨나요?<br/>
			<font style="color:var(--color-main)">솔직한 후기</font>를 남겨주세요.
		</div>
		
		
		<div class="form-box">
			<div class="title">상품명<font style="color:red;">*</font></div>
			<div class="content">상품명을 적어주세요.</div>
			<input id="name" placeholder="상품명"/>
		</div>

		<div class="form-box">
			<div class="title">상품소개<font style="color:red;">*</font></div>
			<div class="content">상품 소개를 적어주세요.</div>
			<textarea  id="content"  placeholder="상세히 적어주세요."></textarea>
		</div>


		<div class="form-box">
			<div class="title">가격<font style="color:red;">*</font></div>
			<div class="content">가격을 적어주세요. (단위 : 원)</div>
			<input type="number"id="price" placeholder="20000"/>
		</div>
		<div class="form-box">
			<div class="title">할인율<font style="color:red;">*</font></div>
			<div class="content">할인율을 적어주세요.(단위 %)</div>
			<input type="number"id="discount-rate" placeholder="10"/>
		</div>
		
		<div class="form-box">
			<div class="title">대표 상품 이미지<font style="color:red;">*</font></div>
			<div class="content bg">
				1. 이미지 사이즈 1928*1928 권장<br/>
				2. 상품 이미지가 포함된 이미지.<br/>
				3. 불법, 광고성 이미지 금지.<br/>
			</div>
			
			
			<div>
				<div id="img-upload-box" class="img-upload-box">
					<i class="fa-solid fa-plus"></i>
					<div style="font-size:13px;color:#585858;">대표이미지를 등록하세요.</div>
				</div>
				<input id="main-img-file" type="file" style="display: none;"/>
			</div>
		</div>
		
		
		<div class="form-box">
			<div class="title">상세이미지<font style="color:red;">*</font></div>
			<div class="content bg">
				1. 이미지 사이즈 500*500 권장<br/>
				2. 여행지 이미지가 포함된 이미지.<br/>
				3. 불법, 광고성 이미지 금지.<br/>
			</div>
			
			
			<input id="detail-img-file" type="file" style="display: none;"/>
			<div id="detail-img-list" class="images-group">
				<div id="detail-img-upload-box" class="img-upload-box small">
					<i class="fa-solid fa-plus" style="margin-top:10px;"></i>
					<div style="font-size:13px;color:#585858;">
						<font id="detail-img-count" style="color:var(--color-main);font-weight:700">0</font>/<font id="max-cnt"></font>
					</div>
				</div>
				
				
				
				<!-- <div class="img-box" style="display:none;">
					<img src="https://media.triple.guide/triple-cms/c_limit,f_auto,h_1024,w_1024/7fec9212-16d5-43eb-bb62-ec54ac9e41ac.jpeg"/>
					<div class="del-btn">
						<i class="fa-solid fa-trash-can"></i>
					</div>
				</div> -->
				
				
			</div>
		</div>
		
		
		
		
		<button id="submit-btn" class="long-btn" style="margin-top:30px;display: flex;align-items: center;justify-content: center;">
			<span id="loader" class="loader" style="display: none;"></span>
			<span style="margin-left:10px;">등록완료</span>
		</button>
	</div>
	
	
</div>

	
</body>
</html>