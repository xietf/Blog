/**
 * Created by Administrator on 2018/11/21.
 */
var flog=false;
function Ihidden()
{
    if (flog) {
        $(".logo").css({visibility: "hidden"});
    } else {
        $(".logo").css({visibility: "unset"});
    }
    flog=!flog;
}

$(document).ready(function(){
    setInterval(Ihidden, 2000);
});

$(".logon").bind("click",function(){
    $.ajax({
        url:"http://localhost:8080/login",
        type:"post",
        data:$("#form_box").serialize(),
        success:function(data){
            alert(data.msg)
            if(data.status==1){
                window.location.href="http://localhost:8080/admin/toindex";
            }
            else {
                window.location.reload();
            }
        }

    })
})
    $("#messagebtn").bind("click",function(){
        $.ajax({
            url:"http://localhost:8080/message",
            type:"post",
            data:$("#messagefrom").serialize(),
            success:function(msg){
                alert(msg)
            }
        })
    })