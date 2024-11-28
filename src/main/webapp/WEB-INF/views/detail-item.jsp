<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="icon" href="./image/logo-icon.png"/>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.0/css/all.min.css" integrity="sha512-9xKTRVabjVeZmc+GUW8GgSmcREDunMM+Dt/GrzchfN8tkwHizc5RP4Ok/MXFFy5rIjJjzhndFScTceq5e6GvVQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet" href="./css/style.css"/>



<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twbs-pagination/1.4.2/jquery.twbsPagination.min.js" integrity="sha512-frFP3ZxLshB4CErXkPVEXnd5ingvYYtYhE5qllGdZmcOlRKNEPbufyupfdSTNmoF5ICaQNO6SenXzOZvoGkiIA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script src="./js/detail-item.js"></script>

</head>

<style>
	.detail-item-img{
		width: 100px;
		height: 100px;
		object-fit: cover;
		border:1px solid #f2f2f2;
		border-radius: 5px;
	}
</style>

<body>
	

	<jsp:include page="./include/header.jsp"/>
	
	



	<div class="home-container">
		<div class="inner" style="display: flex;">
			


			<div class="detail-item-img-container" style="width: 50%;">
				

				<section>
					<img style="border:1px solid #f2f2f2;width: 100%;height: 400px;object-fit: cover;" src="${item.item_img_url}" alt="상품이미지"/>
				</section>

				<section style="display: flex;gap: 10px;margin-top: 10px;">	
					<c:forEach items="${itemImgs}" var="itemImg">
						<img class="detail-item-img" src="${itemImg.item_img_url}" alt="상품이미지"/>
					</c:forEach>
			</div>

			<div class="detail-item-info-container" style="width: 50%;">
				456
			</div>

			

		</div>
	</div>

	
</body>
</html>