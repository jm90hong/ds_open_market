$(document).ready(function(){


    var start = 0;
    const count = 16;
    getItems(start,count);



    $('#more-btn').click(function(){
        start =start+count;
        getItems(start,count);
    });

    

});

function getItems(s,c){ 
    $.ajax({
        url:"/api/item/findAll",
        method:"get",
        data:{
            start:s,
            count:c
        },  
        success:function(response){


            var items = response;
            console.log(items);
            $.each(items, function(index, item){


               var discount_price = item.price * (1-item.discount_rate);
               var mPoint = discount_price * item.m_rate;
               $('#item-list').append(`
                    <div class="product-item">
                        <img src="${item.item_img_url}"/>
                        <div class="product-info">
                            <span style="color:#999;font-size:13px;margin-top:10px;">${item.nick}</span>
                            <span class="product-name">${item.name}</span>
                            <del class="product-price">${item.price.toLocaleString()} 원</del>
                            <div>
                                <span class="product-discount">${item.discount_rate*100}%</span>
                                <span class="product-discount-price">${discount_price.toLocaleString()} 원</span>
                            </div>
                            <span class="product-point">멥버쉽 포인트 ${mPoint.toLocaleString()} 원 적립 가능</span>

                        </div>
                    </div>
               `);
            });
            
        }
    });
}
