$(document).ready(function(){


    $('#submit-btn').click(function(){
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


        $.ajax({
            url:'./api/item/create',
            type:'post',
            data:{
                name:name,
                content:content,
                price:price,
                discount_rate:discount_rate/100,
                item_img_url:'http://~~'
            },
            success:function(data){ 
                alert(data);
            },
            error:function(e){
                console.log(e);
            }
        });
    });

});