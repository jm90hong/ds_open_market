
$(document).ready(function(){
    $("#login-btn").click(function(){
        
        var id = $("#id").val();
        var pw = $("#pw").val();

        $.ajax({
            url: "./api/user/login",
            type: "get",
            data: {id: id, pw: pw},
            success: function(result){
                
                if(result==''){
                    alert("가입된 계정이 아닙니다.");
                }else{
                    location.replace('./');
                }
            },
            error: function(e){
                console.log(e);
            }
        });


    });
});
