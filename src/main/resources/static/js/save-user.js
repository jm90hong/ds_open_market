$(document).ready(function() {

    //유효성 검사 체크 데이터
    var valid={
        id:false,
        nick:false
    };

    //비밀번호 유효성 검사
    $("#pw, #pw2").on("keyup", function() {
        var pw = $("#pw").val();
        var pw2 = $("#pw2").val();
        
        //특수문자 포함 여부 체크
        var specialChar = /[!@#$%^&*(),.?":{}|<>]/;
        var isSpecialChar = specialChar.test(pw);
        
        //8자리 이상 체크 
        var isLongEnough = pw.length >= 8;
        
        //비밀번호 일치 여부
        var isMatch = (pw === pw2);
        var msg = "";
        
        if(!isSpecialChar) {
            msg = "특수문자를 포함해야 합니다.";
        } else if(!isLongEnough) {
            msg = "비밀번호는 8자리 이상이어야 합니다.";
        } else if(!isMatch) {
            msg = "비밀번호가 일치하지 않습니다.";
        } else {
            msg = "비밀번호가 일치합니다.";
        }
        
        $("#pw2").next("div").text(msg);
    });



    //아이디 중복확인
    $("#check-id-btn").click(function() {

        var id = $("#id").val();

        $.ajax({
            url: "./api/user/getById",
            type: "GET",
            data: { 
                id: id 
            },
            success: function(response) {
                console.log(response);
                if(response==''){
                    //가입 가능한 상태
                    valid.id = true;
                }else{
                    //가입 불가능한 상태
                    valid.id = false;
                }
            }
        });
    });
});