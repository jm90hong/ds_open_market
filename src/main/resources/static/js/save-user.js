const firebaseConfig = {
    apiKey: "AIzaSyAjMo161z8lVauMCOAiynyo2xcK_SHwlxI",
    authDomain: "open-market-801f0.firebaseapp.com",
    projectId: "open-market-801f0",
    storageBucket: "open-market-801f0.firebasestorage.app",
    messagingSenderId: "486349643801",
    appId: "1:486349643801:web:bf1543d2dda44d06668a88",
    measurementId: "G-ZDKCZ2PVN5"
};


$(document).ready(function() {


    //firebase 초기화
    if (!firebase.apps.length) {
        firebase.initializeApp(firebaseConfig);
    }

    //스토리지 초기화
    var storage = firebase.storage();



    $("#profile-img").click(function(){
        $("#file").trigger('click');
    });

    $("#file").change(function(){
        var file = $(this)[0].files[0];
        console.log(file);

        getBase64(file).then(function(base64){
            $("#profile-img").attr('src',base64);
        });

        // var ref = storage.ref('some_path').child("img.png");
        // ref.put(file).then(function(snapshot){
        //     ref.getDownloadURL().then(function(url){
        //         //다운로드 주소 url -> 여기서 ajax로 DB 에 insert 하기
        //         console.log(url);
        //         $("#profile-img").attr('src',url);
        //     }).catch(function(err){
        //         //에러
        //     });
        // });

    });




    //유효성 검사 체크 데이터
    var valid={
        id:false,
        nick:false,
        pw:false
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

        
        valid.pw = false;
        if(!isSpecialChar) {
            msg = "특수문자를 포함해야 합니다.";
           
        } else if(!isLongEnough) {
            msg = "비밀번호는 8자리 이상이어야 합니다.";
           
        } else if(!isMatch) {
            msg = "비밀번호가 일치하지 않습니다.";
            
        } else {
            msg = "비밀번호가 일치합니다.";
            valid.pw = true;
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
                    $("#check-id-btn")
                    .text("인증완료")
                    .css('pointer-events', 'none');
                }else{
                    //가입 불가능한 상태
                    valid.id = false;
                }
            }
        });
    });

    //닉네임 중복확인
    $("#check-nick-btn").click(function() {
        var nick = $("#nick").val();

        $.ajax({
            url: "./api/user/getByNick",
            type: "GET",
            data: { 
                nick: nick 
            },
            success: function(response) {
                console.log(response);
                if(response==''){
                    //가입 가능한 상태
                    valid.nick = true;
                    $("#check-nick-btn")
                    .text("인증완료")
                    .css('pointer-events', 'none');
            
                }else{
                    //가입 불가능한 상태
                    valid.nick = false;
                }
            }
        });
    });



    $("#save-user-btn").click( async function() {

        
        if(!valid.id){
            alert("아이디 중복확인을 해주세요.");               
            return;
        }
        if(!valid.nick){
            alert("닉네임 중복확인을 해주세요.");
            return;
        }
        if(!valid.pw){
            alert("비밀번호를 확인해주세요.");
            return;
        }


        $('#loader').css('display','inline-block');
        $("#save-user-btn").css('pointer-events','none');

        //이미지 업로드 및 주소 확보
        var base64 = $("#profile-img").attr('src');
        if(base64.length<100){
            saveUserToDB(base64);
        }else{
            //firebase 업로드
            var img_url=await myFirebase.uploadUserImage(storage,base64,$("#id").val());
            saveUserToDB(img_url);
        }
        
        
    

    });



});

function saveUserToDB(img_url){
    $.ajax({
        url: "./api/user/create",
        type: "POST",
        data: {
            id: $("#id").val(),
            pw: $("#pw").val(),
            nick: $("#nick").val(),
            address: $("#address").val(),
            img_url:img_url,
        },
        success: function(response) {
            if(response=='ok'){
                alert("회원가입이 완료되었습니다.");
                location.replace("./login");
            }
        }, 
        error: function(e) {
            console.log(e);
        }
    }); 
}



function getBase64(file) {
    return new Promise(function(resolve, reject){
        var reader = new FileReader();
        reader.readAsDataURL(file);
        reader.onload = function () {
            resolve(reader.result);
        };
        reader.onerror = function (error) {
            reject('Error: ', error);
        };
    });
 }