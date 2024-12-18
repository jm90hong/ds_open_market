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
<script src="./js/home.js"></script>

</head>
<body>
	

	<jsp:include page="./include/header.jsp"/>
	
	



	<div class="home-container">
		<div class="inner">
			<div class="title">
				<h2>상품리스트</h2>
			</div>

			<section id="item-list" class="product-list">
				

				

				
				<!-- <div class="product-item">
					<img src="https://cafe24.poxo.com/ec01/steampot5114/0X0oriblsbKxpSjRld8pWsyRYhzqmQuL/5AgSkS+SSPd9+nDQsrDXSHW/YHCZhzb/LsUzPXJPb97+Jk919TFQQ==/_/web/product/big/202409/514eb5a8a26d883c89708af08be899cd.png"/>
					<div class="product-info">
						<span class="product-name">리얼 유기늉 레몬즙 박스(10박스 할인 이벤트 진행중) 리얼 유기늉 레몬즙 박스(10박스 할인 이벤트 진행중)</span>
						<del class="product-price">50,000 원</del>
						<div>
							<span class="product-discount">20%</span>
							<span class="product-discount-price">20,500 원</span>
						</div>
						<span class="product-point">메버쉽 포인트 10,000원 적립 가능</span>

					</div>
				</div> -->

				
				

				
				

				


			</section>
			<ul id="pagination-demo" class="pagination-sm"></ul>


			<button id="more-btn" style="margin:0 auto;display: none;margin-top:50px;margin-bottom: 150px;padding: 8px 20px;">더보기</button>

		</div>
	</div>

	
</body>
</html>