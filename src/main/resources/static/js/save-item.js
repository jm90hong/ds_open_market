$(document).ready(function(){


    //firebase 초기화
    if (!firebase.apps.length) {
        firebase.initializeApp(firebaseConfig);
    }

    //스토리지 초기화
    var storage = firebase.storage();

    var selectedMainImgBase64 = '';
   

    $('#img-upload-box').click(function(){
        $('#main-img-file').trigger('click');
    });

    $('#main-img-file').change(async function(){
        var file = this.files[0];
       
        //미리 보기
        var base64 = await myFirebase.getBase64(file);
        alert(base64);



        selectedMainImgBase64=base64;
        $('#img-upload-box').empty();
        $('#img-upload-box')
            .css('background-image','url('+base64+')')
            .css('background-size','cover');
    });




    $('#submit-btn').click(async function(){
        var name = $('#name').val();
        var content = $('#content').val();
        var price = $('#price').val();
        var discount_rate = $('#discount-rate').val(); 
        
        if(name.length==0){
            alert('상품명을 채워주세요.');
            return;
        }

        if(content.length==0){
            alert('상품소개를 채워주세요.');
            return;
        }

        if(price==0){
            alert('상품가격을 채워주세요.');
            return;
        }

        if(discount_rate==0){
            alert('할인율을 채워주세요.');
            return;
        }


        if(selectedMainImgBase64.length==0){
            alert('대표 상품 이미지를 등록해주세요.');
            return;
        }   

        

        //이미지 업로드
        var item_img_url = await myFirebase.uploadItemImage(storage,selectedMainImgBase64);


       

        $.ajax({
            url:'./api/item/create',
            type:'post',
            data:{
                name:name,
                content:content,
                price:price,
                discount_rate:discount_rate/100,
                item_img_url:item_img_url
            },
            success:function(data){ 
                if(data=='success'){
                    alert('상품 등록이 완료되었습니다.');
                    location.href='./';
                }else{
                    alert('상품 등록에 실패하였습니다.');
                }
            },
            error:function(e){
                console.log(e);
            }
        });
    });

});