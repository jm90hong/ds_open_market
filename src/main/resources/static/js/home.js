$(document).ready(function(){
    getItems();
});

function getItems(){ 
    $.ajax({
        url:"/api/item/list",
        method:"get",
        success:function(res){
            console.log(res);
        }
    });
}
