
$(document).ready(function(){
    $("#go-login-btn").click(function(){
        location.href = "./login";
    });

    $("#go-save-user-btn").click(function(){
        location.href = "./save-user";
    });



    //로그아웃
    $("#logout-btn").click(function(){

        var con = confirm('로그아웃 하시겠습니까?');

        if(!con){
            return;
        }
        $.ajax({
            url: "./api/user/logout",   
            type: "post",
            success: function(result){
                if(result=='ok'){
                    alert("로그아웃 되었습니다.");
                    location.replace('./');
                }else{
                    alert("로그아웃 실패");
                }
                
            }
        });
    }); 
});
