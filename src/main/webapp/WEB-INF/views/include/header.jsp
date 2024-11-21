<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    

<script src="./js/header.js"></script>
    
<header class="header">
    <div class="inner">
        <div class="top">
            <span class="logo-txt">웹 포트폴리오</span>
            
            <div>

                <c:if test="${empty sessionScope.me}">
                    <button id="go-login-btn">로그인</button>
                    <button id="go-save-user-btn">회원가입</button>
                </c:if>
                
                <c:if test="${not empty sessionScope.me}">
                    <span style="color:var(--color-purple);">${sessionScope.me.nick}님 환영합니다.</span>
                    <button id="logout-btn">로그아웃</button>
                </c:if>

    
            </div>
        </div>
        <div class="bottom">
            <div style="display: flex;align-items: center;">
                <img class="logo-img" src="./image/store.png"/>
                
                
                
                <div class="header-input">
                    <input placeholder="상품명을 입력하세요."/>
                    <i class="fa-solid fa-magnifying-glass"></i>
                </div>
            </div>
        </div>
    </div>
</header>